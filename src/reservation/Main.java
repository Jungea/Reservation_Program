package reservation;

/*
 * �ۼ���: ������
 * �ۼ���: 2018.12.09.
 * ����: hw6_2 ��� ���α׷�
 */

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("���� �� �ϳ��� �����Ͻÿ�.");
		String data1;
		String data2;
		String mainMenu;
		int subMenu;
		int menu;

		do {
			System.out.print("\n---------------------------------------------");
			System.out.print("\na)�а�����  b)�л�����  c)��������  d)������  e)����  ---> ");

			mainMenu = scan.next();
			switch (mainMenu) {
			case "a":
				System.out.println("��ü ����Ʈ ���");

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
