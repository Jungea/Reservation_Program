package reservation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * �ۼ���: ������
 * �ۼ���: 2018.12.10.
 * ����: hw6_5 �а� ����Ʈ ���
 */

import java.util.Scanner;

public class Main {

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

	public static void main(String[] args) throws SQLException {
		Connection con = makeConnection();

		Scanner scan = new Scanner(System.in);
		System.out.println("���� �� �ϳ��� �����Ͻÿ�.");
		String data1;
		String data2;
		String mainMenu;
		int subMenu;
		int menu;

		String sql;
		Statement stmt = con.createStatement();
		ResultSet rs;

		do {
			System.out.print("\n---------------------------------------------");
			System.out.print("\na)�а�����  b)�л�����  c)��������  d)������  e)����  ---> ");

			mainMenu = scan.next();
			switch (mainMenu) {
			case "a":
				sql = "SELECT * FROM DEPARTMENT";
				rs = stmt.executeQuery(sql);
				while (rs.next()) {
					System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));
				}

				do {
					System.out.print("\n1)�а������Է�  2)�а�����  3)���θ޴����ư��� ---> ");
					subMenu = scan.nextInt();
					switch (subMenu) {
					case 1:
						System.out.print("�а����� �Է�: ");
						data1 = scan.next();
						System.out.println("�Է� <" + data1 + ">");
						System.out.println("��ü ����Ʈ ���");
						break;
					case 2:
						System.out.print("������ �а�: ");
						data1 = scan.next();
						System.out.println("�Է� <" + data1 + ">");
						System.out.println("��ü ����Ʈ ���");
						break;
					case 3:
						System.out.println("���θ޴��� ���ư��ϴ�.");
						break;
					default:
						System.out.println("�޴� ��ȣ ����: �޴��� �ٽ� �����ϼ���.");
					}
				} while (!(subMenu == 3));

				break;

			case "b":
				System.out.println("��ü ����Ʈ ���");
				do {
					System.out.print("\n1)�л������Է�  2)�л�����  3)���θ޴����ư��� ---> ");
					subMenu = scan.nextInt();
					switch (subMenu) {
					case 1:
						System.out.print("�а� ����: ");
						data1 = scan.next();
						System.out.print("�л����� �Է�: ");
						data2 = scan.next();
						System.out.println("�Է� <" + data1 + ", " + data2 + ">");
						System.out.println("��ü ����Ʈ ���");
						break;
					case 2:
						System.out.print("������ �л�: ");
						data1 = scan.next();
						System.out.println("�Է� <" + data1 + ">");
						System.out.println("��ü ����Ʈ ���");
						break;
					case 3:
						System.out.println("���θ޴��� ���ư��ϴ�.");
						break;
					default:
						System.out.println("�޴� ��ȣ ����: �޴��� �ٽ� �����ϼ���.");
					}
				} while (!(subMenu == 3));

				break;

			case "c":
				System.out.println("��ü ����Ʈ ���");
				do {
					System.out.print("\n1)���������Է�  2)��������  3)���θ޴����ư��� ---> ");
					subMenu = scan.nextInt();
					switch (subMenu) {
					case 1:
						System.out.print("�а� ����: ");
						data1 = scan.next();
						System.out.print("�������� �Է�: ");
						data2 = scan.next();
						System.out.println("�Է� <" + data1 + ", " + data2 + ">");
						System.out.println("��ü ����Ʈ ���");
						break;
					case 2:
						System.out.print("������ ����: ");
						data1 = scan.next();
						System.out.println("�Է� <" + data1 + ">");
						System.out.println("��ü ����Ʈ ���");
						break;
					case 3:
						System.out.println("���θ޴��� ���ư��ϴ�.");
						break;
					default:
						System.out.println("�޴� ��ȣ ����: �޴��� �ٽ� �����ϼ���.");
					}
				} while (!(subMenu == 3));

				break;

			case "d":
				do {
					System.out.print("\n1)�й��Է�  2)�����Է� ---> ");
					subMenu = scan.nextInt();
					if (subMenu == 1) {
						System.out.print("�й� �Է�: ");
						data1 = scan.next();
						System.out.println("�Է� <" + data1 + ">");
						do {
							System.out.print("\n1)����û  2)������  3)�����  4)��� ������ǥ��  5)���θ޴��� ���ư���  ---> ");
							menu = scan.nextInt();

							switch (menu) {
							case 1:
								System.out.print("���� ����: ");
								data1 = scan.next();
								System.out.print("��� ���� �Է�: ");
								data2 = scan.next();
								System.out.println("�Է� <" + data1 + ", " + data2 + ">");
								System.out.println("��û�� ��� ���� ǥ��");
								break;
							case 2:
								System.out.print("����� ��� ����: ");
								data1 = scan.next();
								System.out.println("�Է� <" + data1 + ">");
								System.out.println("����� ��� ����");
								break;
							case 3:
								System.out.print("��� ����: ");
								data1 = scan.next();
								System.out.print("��� ��� �Է�: ");
								data2 = scan.next();
								System.out.println("�Է� <" + data1 + ", " + data2 + ">");
								break;
							case 4:
								System.out.println("���ε� ��㿡 ���� ���� ǥ��");
								System.out.print("��� ����: ");
								data1 = scan.next();
								System.out.println("�Է� <" + data1 + ">");
								System.out.println("Ư�� ��㿡 ���� ���� ǥ��");
								break;
							case 5:
								System.out.println("���θ޴��� ���ư��ϴ�.");
								break;
							default:
								System.out.println("�޴� ��ȣ ����: �޴��� �ٽ� �����ϼ���.");
							}
						} while (!(menu == 5));

						if (menu == 5)
							break;

					} else if (subMenu == 2) {
						System.out.print("���� ������ȣ �Է�: ");
						data1 = scan.next();
						System.out.println("�Է� <" + data1 + ">");
						System.out.println("��û�� ��� ����Ʈ ���");

						do {
							System.out.print("\n1)�����һ�㼱��  2)��������ǥ��  3)���θ޴��� ���ư���  ---> ");
							menu = scan.nextInt();

							switch (menu) {
							case 1:
								System.out.print("������ ��� ����: ");
								data1 = scan.next();
								System.out.println("�Է� <" + data1 + ">");
								System.out.println("������ ��� ����");
								break;
							case 2:
								System.out.println("��� ��㿡 ���� ���� ǥ��");
								System.out.print("��� ����: ");
								data1 = scan.next();
								System.out.println("�Է� <" + data1 + ">");
								System.out.println("Ư�� ��㿡 ���� ���� ǥ��");
								break;
							case 3:
								System.out.println("���θ޴��� ���ư��ϴ�.");
								break;
							default:
								System.out.println("�޴� ��ȣ ����: �޴��� �ٽ� �����ϼ���.");
							}
						} while (!(menu == 3));

						if (menu == 3)
							break;
					} else
						System.out.println("�޴� ��ȣ ����: �޴��� �ٽ� �����ϼ���.");
				} while (!(subMenu == 1 || subMenu == 2));

				break;

			case "e":
				System.out.println("�����մϴ�.");
				break;

			default:
				System.out.println("�޴� ��ȣ ����: �޴��� �ٽ� �����ϼ���.");
			}
		} while (!mainMenu.equals("e"));
	}
}
