package reservation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

class MyFrame extends JFrame { // �������α׷�

	JPanel menuPan = new JPanel(); // �ָ޴�
	JButton[] menuButton = new JButton[5];
	String[] menuStr = { "�а�����", "�л�����", "��������", "������" };
	int menu;

	JPanel subPan = new JPanel(); // �����޴�
	JButton[] subButton = new JButton[2];
	String[][] subMenuStr = { { "�а������Է�", "�а�����" }, { "�л������Է�", "�л�����" }, { "���������Է�", "��������" },
			{ "�й��Է�", "����������ȣ�Է�" } };
	int sub;

	JPanel resPan = new JPanel(); // ���� �޴� �� ������ �޴��� ���� �޴�
	JButton[] resButton = new JButton[4];
	String[][] resStr = { { "����û", "������", "�����", "��������ǥ��" }, { "�����һ�㼱��", "��������ǥ��" } };

	JPanel infoPan = new JPanel(); // ������ ǥ�� ��Ÿ���� �κ�

	public MyFrame() {
		setSize(1000, 750);
		setLayout(null);

		menuPan.setLayout(new GridLayout(menuStr.length, 1));

		for (int i = 0; i < menuStr.length; i++) {
			menuButton[i] = new JButton(menuStr[i]);
			menuButton[i].setBackground(Color.DARK_GRAY);
			menuButton[i].setFont(new Font("����", Font.BOLD, 30));
			menuButton[i].setForeground(Color.WHITE);

			final int ii = i;
			menuButton[i].addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					menu = ii;
					subUpdate(ii);
				}
			});
			menuPan.add(menuButton[i]);
		}

		for (int i = 0; i < subButton.length; i++) {
			subButton[i] = new JButton();

			final int jj = i;
			subButton[i].addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					sub = jj;
					if (menu != 3) {
						show(jj);
					} else { // ���޴��� ���
						resUpdate(jj);
					}
				}
			});
		}

		for (int i = 0; i < resButton.length; i++) {
			resButton[i] = new JButton();

			final int kk = i;
			resButton[i].addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					show(kk);
				}
			});
		}

		infoPan.setLayout(new BorderLayout());
		infoPan.setBounds(400, 0, 580, 700);

		menuPan.setBounds(0, 0, 200, menuStr.length * 140);
		add(menuPan);
		add(subPan);
		add(infoPan);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void subUpdate(int num) { // ���� �޴� ǥ��
		subPan.removeAll();
		subPan.setLayout(new GridLayout(subMenuStr[num].length, 1));
		for (int i = 0; i < subMenuStr[num].length; i++) {
			subButton[i].setText(subMenuStr[num][i]);
			subButton[i].setBackground(Color.GRAY);
			subButton[i].setFont(new Font("����", Font.BOLD, 15));
			subButton[i].setForeground(Color.WHITE);
			subPan.add(subButton[i]);
		}
		subPan.setBounds(200, 0, 200, subMenuStr[num].length * 100);
		revalidate();
		repaint();
	}

	public void resUpdate(int num) { // ���޴� ǥ��
		subPan.removeAll();
		subPan.setLayout(new GridLayout(resStr[num].length, 1));
		for (int i = 0; i < resStr[num].length; i++) {
			resButton[i].setText(resStr[num][i]);
			resButton[i].setBackground(Color.GRAY);
			resButton[i].setFont(new Font("����", Font.BOLD, 15));
			resButton[i].setForeground(Color.WHITE);
			subPan.add(resButton[i]);
		}
		subPan.setBounds(200, 0, 200, resStr[num].length * 100);
		revalidate();
		repaint();
	}

	public void show(int num) { // ���� �޴��� ���� �޴��� ���� ������(infoPan)

		System.out.println("menu" + menu + "  sub" + sub);
		switch (menu) {
		case 0:
			Start.selectAll();
			System.out.println(subMenuStr[menu][num]);
			break;
		case 1:
			System.out.println(subMenuStr[menu][num]);
			break;
		case 2:
			System.out.println(subMenuStr[menu][num]);
			break;
		case 3:
			System.out.println("res" + num + " " + resStr[sub][num]);
			break;
		}
	}

}

class ConnectFrame extends JFrame { // �����ͺ��̽� ���� �� ���� â
	MyFrame mf;

	int check = 0;
	JLabel info = new JLabel("����");
	Timer lodingTimer;
	TimerTask lodingTask;

	Timer timer;
	TimerTask task;

	public ConnectFrame() {
		setLayout(new BorderLayout());
		add(info, BorderLayout.CENTER);
		info.setFont(new Font("����", Font.BOLD, 40));

		setSize(500, 150);

		// â�� ȭ�� ��� ��ġ
		Dimension screen1 = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension screen2 = getSize();
		int xpos = (int) (screen1.getWidth() / 2 - screen2.getWidth() / 2);
		int ypos = (int) (screen1.getHeight() / 2 - screen2.getHeight() / 2);
		setLocation(xpos, ypos);

		setVisible(true);
	}

	public void loding() { // �����ͺ��̽� ���� ��

		lodingTimer = new Timer();
		lodingTask = new TimerTask() {

			@Override
			public void run() {
				System.out.println(check);
				if (check == -1)
					lodingTimer.cancel();
				else {
					switch (check % 3) {
					case 0:
						changeMsg(" �����ͺ��̽� ������.  ");
						break;
					case 1:
						changeMsg(" �����ͺ��̽� ������.. ");
						break;

					case 2:
						changeMsg(" �����ͺ��̽� ������...");
						break;
					}

					check++;
				}
			}
		};

		lodingTimer.schedule(lodingTask, 0, 500);
	}

	public void success() { // �����ͺ��̽� ���ῡ ������ ���
		check = -1;
		changeMsg(" �����ͺ��̽� ���� ����");

		timer = new Timer();
		task = new TimerTask() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				setVisible(false); // �����ͺ��̽� ���� ����â ����
				mf = new MyFrame(); // ���� â ����
			}
		};
		timer.schedule(task, 1000);
	}

	public void changeMsg(String text) {
		info.setText(text);
	}
}

public class Start {

	static Connection con = null;
	static ConnectFrame frame;
	static JTable table;

	public static void selectAll() {

		Statement stmt;
		String[] header = { "deptID", "deptName", "offiNum" };
		String[][] context = null;

		int i = 0;

		try {

			stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery("SELECT * FROM department");

			rs.last();
			int nRecord = rs.getRow();
			context = new String[nRecord][header.length];
			rs.beforeFirst();

			while (rs.next()) {
				String id = rs.getString("deptID");
				String name = rs.getString("deptName");
				String offNum = rs.getString("offiNum");

				context[i][0] = id;
				context[i][1] = name;
				context[i][2] = offNum;

				System.out.println(id + " " + name + " " + offNum);

				i++;

			}

		} catch (SQLException e) {

			e.printStackTrace();

		}

		table = new JTable(context, header);

		JScrollPane scrollPane = new JScrollPane(table);
		frame.mf.infoPan.add(scrollPane, BorderLayout.CENTER);
		frame.mf.infoPan.repaint();
		frame.mf.infoPan.revalidate();

	}

	static Connection makeConnection() {

		String url = "jdbc:mysql://localhost/projects?characterEncoding=UTF-8&serverTimezone=UTC"; // �����ͺ��̽� ����
		Connection con = null;
		try {
			frame = new ConnectFrame();
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("�����ͺ��̽� ������ ...");
			frame.loding();
			con = DriverManager.getConnection(url, "puser", "1234"); // ����� ����
			System.out.println("�����ͺ��̽� ���� ����");
			frame.success();
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC ����̹��� ã�� ���߽��ϴ�...");
			frame.changeMsg("JDBC ����̹��� ã�� ���߽��ϴ�...");
		} catch (SQLException e) {
			System.out.println("�����ͺ��̽� ���� ����");
			frame.changeMsg("�����ͺ��̽� ���� ����");
		}
		return con;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		con = makeConnection();
	}
}
