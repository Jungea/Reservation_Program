package reservation;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyFrame extends JFrame {
	JPanel menuPan = new JPanel();
	JButton[] menuButton = new JButton[5];
	String[] menuStr = { "�а�����", "�л�����", "��������", "������" };
	int menu;

	JPanel subPan = new JPanel();
	JButton[] subButton = new JButton[2];
	String[][] subMenuStr = { { "�а������Է�", "�а�����" }, { "�л������Է�", "�л�����" }, { "���������Է�", "��������" },
			{ "�й��Է�", "����������ȣ�Է�" } };
	int sub;

	JPanel resPan = new JPanel();
	JButton[] resButton = new JButton[4];
	String[][] resStr = { { "����û", "������", "�����", "��������ǥ��" }, { "�����һ�㼱��", "��������ǥ��" } };

	JPanel infoPan = new JPanel();

	public MyFrame() {
		setSize(1000, 750);
		setLayout(null);

		menuPan.setLayout(new GridLayout(menuStr.length, 1));
//		menuPan.setBackground(Color.DARK_GRAY);

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
					} else {
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

		infoPan.setBackground(Color.WHITE);
		infoPan.setBounds(400, 0, 580, 700);

		menuPan.setBounds(0, 0, 200, menuStr.length * 140);
		add(menuPan);
		add(subPan);
		add(infoPan);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void subUpdate(int num) {
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

	public void show(int num) {
		System.out.println("menu" + menu + "  sub" + sub);
		switch (menu) {
		case 0:
			System.out.println(subMenuStr[menu][num]);
			break;
		case 1:
			System.out.println(subMenuStr[menu][num]);
			break;
		case 2:
			System.out.println(subMenuStr[menu][num]);
			break;
		case 3:
			System.out.println("res"+num+" "+resStr[sub][num]);
			break;
		}
	}

	public void resUpdate(int num) {
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyFrame();
	}

}
