package reservation;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

//panel.setBorder(new LineBorder(Color.BLACK, 1));
//title.setFont(new Font("�������", Font.BOLD, 30));

public class Ver2 extends JFrame {
	int who = -1; // 0 �л�/ 1����

	JTextField idField;

	JTextField pField;
	JPasswordField passField;
	JButton loginButton;

	public Ver2() {
		setSize(500, 800);
		setLayout(null);

		JPanel panel = new JPanel();
		add(panel); // panel �����, �߰�
		panel.setLayout(new GridLayout(2, 1));

		ImageIcon titleImg = new ImageIcon("img/title.png");
		JLabel title = new JLabel(titleImg);
		add(title);
		center(title, 50, 200, 200);

		// ���̵� �ʵ�
		idField = new JTextField("���̵�");
		idField.setForeground(Color.GRAY);
		idField.setFont(new Font("�������", Font.BOLD, 15));
		panel.add(idField);

		// placeholder ȿ��
		idField.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				if (idField.getText().isEmpty()) {
					idField.setForeground(Color.GRAY);
					idField.setText("���̵�");
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				if (idField.getText().equals("���̵�")) {
					idField.setText("");
					idField.setForeground(Color.BLACK);
					idField.setFont(new Font("�������", Font.PLAIN, 15));
				}
			}
		});

		pField = new JTextField("��й�ȣ");
		pField.setFont(new Font("�������", Font.BOLD, 15));
		panel.add(pField);
		pField.setForeground(Color.GRAY);

		passField = new JPasswordField();
		passField.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				if (passField.getPassword().length == 0) {
					panel.remove(passField);
					panel.add(pField);
					panel.repaint();
					panel.revalidate();
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub

			}
		});

		pField.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				panel.remove(pField);
				panel.add(passField);
				panel.repaint();
				panel.revalidate();
				passField.requestFocus();

			}
		});
		center(panel, 300, 300, 100);

		// �α��� ��ư
		loginButton = new JButton("�α���");
		add(loginButton);
		loginButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				while (MySQL.con == null) // mysql ���� ��
					;
				try {
					who = MySQL.login(idField.getText(), new String(passField.getPassword()));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.out.println(who + " " + idField.getText() + " " + new String(passField.getPassword()));
			}
		});
		center(loginButton, 410, 300, 50);

		frameLocation();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	// ������Ʈ�� ��ġ�� �����
	public void center(Component c, int ypos, int width, int height) {
		Dimension screen1 = getSize();
		int xpos = (int) (screen1.getWidth() / 2 - width / 2);
		c.setBounds(xpos, ypos, width, height);
	}

	// �������� ȭ�� ����� ��ġ
	public void frameLocation() {
		Dimension screen1 = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension screen2 = getSize();
		int xpos = (int) (screen1.getWidth() / 2 - screen2.getWidth() / 2);
		int ypos = (int) (screen1.getHeight() / 2 - screen2.getHeight() / 2);
		setLocation(xpos, ypos);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Ver2();
		MySQL.con = MySQL.makeConnection();
	}

}

class MySQL {
	static Connection con = null;
	static Statement stmt = null;

	public static Connection makeConnection() {

		String url = "jdbc:mysql://localhost/projects?characterEncoding=UTF-8&serverTimezone=UTC"; // �����ͺ��̽� ����
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("�����ͺ��̽� ������ ...");
			con = DriverManager.getConnection(url, "puser", "1234"); // ����� ����
			System.out.println("�����ͺ��̽� ���� ����");
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC ����̹��� ã�� ���߽��ϴ�...");
		} catch (SQLException e) {
			System.out.println("�����ͺ��̽� ���� ����");
		}
		return con;

	}

	// �л��� �α��� ����
	public static int login(String id, String pass) throws SQLException {
		stmt = con.createStatement();
		String sql = "SELECT * FROM student WHERE stdid = '" + id + "' AND stdPass = '" + pass + "'";
		ResultSet rs = stmt.executeQuery(sql);

		int count = 0;
		while (rs.next())
			count++;

		if (count == 1) {
			System.out.println("�л� �α��� ����");
			return 0;
		}

		sql = "SELECT * FROM professor WHERE proid = '" + id + "' AND proPass = '" + pass + "'";
		rs = stmt.executeQuery(sql);

		count = 0;
		while (rs.next())
			count++;

		if (count == 1) {
			System.out.println("���� �α��� ����");
			return 1;
		}

		System.out.println("�α��� ����");

		stmt.close();
		return -1;

	}

}
