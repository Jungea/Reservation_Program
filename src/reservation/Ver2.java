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
//title.setFont(new Font("나눔고딕", Font.BOLD, 30));

public class Ver2 extends JFrame {
	int who = -1; // 0 학생/ 1교수

	JTextField idField;

	JTextField pField;
	JPasswordField passField;
	JButton loginButton;

	public Ver2() {
		setSize(500, 800);
		setLayout(null);

		JPanel panel = new JPanel();
		add(panel); // panel 만들기, 추가
		panel.setLayout(new GridLayout(2, 1));

		ImageIcon titleImg = new ImageIcon("img/title.png");
		JLabel title = new JLabel(titleImg);
		add(title);
		center(title, 50, 200, 200);

		// 아이디 필드
		idField = new JTextField("아이디");
		idField.setForeground(Color.GRAY);
		idField.setFont(new Font("나눔고딕", Font.BOLD, 15));
		panel.add(idField);

		// placeholder 효과
		idField.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				if (idField.getText().isEmpty()) {
					idField.setForeground(Color.GRAY);
					idField.setText("아이디");
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				if (idField.getText().equals("아이디")) {
					idField.setText("");
					idField.setForeground(Color.BLACK);
					idField.setFont(new Font("나눔고딕", Font.PLAIN, 15));
				}
			}
		});

		pField = new JTextField("비밀번호");
		pField.setFont(new Font("나눔고딕", Font.BOLD, 15));
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

		// 로그인 버튼
		loginButton = new JButton("로그인");
		add(loginButton);
		loginButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				while (MySQL.con == null) // mysql 연결 중
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

	// 컴포넌트의 위치를 가운데로
	public void center(Component c, int ypos, int width, int height) {
		Dimension screen1 = getSize();
		int xpos = (int) (screen1.getWidth() / 2 - width / 2);
		c.setBounds(xpos, ypos, width, height);
	}

	// 프레임을 화면 가운데로 위치
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

		String url = "jdbc:mysql://localhost/projects?characterEncoding=UTF-8&serverTimezone=UTC"; // 데이터베이스 변경
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("데이터베이스 연결중 ...");
			con = DriverManager.getConnection(url, "puser", "1234"); // 사용자 변경
			System.out.println("데이터베이스 연결 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC 드라이버를 찾지 못했습니다...");
		} catch (SQLException e) {
			System.out.println("데이터베이스 연결 실패");
		}
		return con;

	}

	// 학생만 로그인 가능
	public static int login(String id, String pass) throws SQLException {
		stmt = con.createStatement();
		String sql = "SELECT * FROM student WHERE stdid = '" + id + "' AND stdPass = '" + pass + "'";
		ResultSet rs = stmt.executeQuery(sql);

		int count = 0;
		while (rs.next())
			count++;

		if (count == 1) {
			System.out.println("학생 로그인 성공");
			return 0;
		}

		sql = "SELECT * FROM professor WHERE proid = '" + id + "' AND proPass = '" + pass + "'";
		rs = stmt.executeQuery(sql);

		count = 0;
		while (rs.next())
			count++;

		if (count == 1) {
			System.out.println("교수 로그인 성공");
			return 1;
		}

		System.out.println("로그인 실패");

		stmt.close();
		return -1;

	}

}
