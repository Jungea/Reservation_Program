package reservation;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyFrame extends JFrame {
	JPanel menuPan = new JPanel();
	JButton[] menuButton = new JButton[5];
	String[] menuStr = { "학과관리", "학생관리", "교수관리", "상담관리" };
	int menu;

	JPanel subPan = new JPanel();
	JButton[] subButton = new JButton[3];
	String[][] subMenuStr = { { "학과정보입력", "학과삭제", "메인메뉴돌아가기" }, { "학생정보입력", "학생삭제", "메인메뉴돌아가기" },
			{ "교수정보입력", "교수삭제", "메인메뉴돌아가기" }, { "학번입력", "교수고유번호입력" } };
	int sub;

	JPanel resPan = new JPanel();
	JButton[] resButton = new JButton[5];
	String[][] resStr = { { "상담신청", "상담취소", "상담기록", "상담상세정보표시", "메인메뉴돌아가기" }, { "승인할상담선택", "상담상세정보표시", "메인메뉴돌아가기" } };

	public MyFrame() {
		setSize(1000, 750);
		setLayout(null);

		menuPan.setLayout(new GridLayout(menuStr.length, 1));
//		menuPan.setBackground(Color.DARK_GRAY);

		for (int i = 0; i < menuStr.length; i++) {
			menuButton[i] = new JButton(menuStr[i]);
			menuButton[i].setBackground(Color.DARK_GRAY);
			menuButton[i].setFont(new Font("굴림", Font.BOLD, 30));
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

		menuPan.setBounds(0, 0, 200, menuStr.length * 140);
		add(menuPan);
		add(subPan);

		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void subUpdate(int num) {
		subPan.removeAll();
		subPan.setLayout(new GridLayout(subMenuStr[num].length, 1));
		for (int i = 0; i < subMenuStr[num].length; i++) {
			subButton[i].setText(subMenuStr[num][i]);
			subButton[i].setBackground(Color.GRAY);
			subButton[i].setFont(new Font("굴림", Font.BOLD, 15));
			subButton[i].setForeground(Color.WHITE);
			subPan.add(subButton[i]);
		}
		subPan.setBounds(200, 0, 200, subMenuStr[num].length * 100);
		revalidate();
		repaint();
	}

	public void show(int num) {
		System.out.println("menu" + menu + "  sub" + sub);
		if (menu == 3)
			System.out.println(resStr[sub][num]);
		else
			System.out.println(subMenuStr[menu][num]);
	}

	public void resUpdate(int num) {
		subPan.removeAll();
		subPan.setLayout(new GridLayout(resStr[num].length, 1));
		for (int i = 0; i < resStr[num].length; i++) {
			resButton[i].setText(resStr[num][i]);
			resButton[i].setBackground(Color.GRAY);
			resButton[i].setFont(new Font("굴림", Font.BOLD, 15));
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
