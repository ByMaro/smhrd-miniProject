package view;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import controller.gameController;
import javazoom.jl.player.MP3Player;
import model.DAO;
import model.User;
import model.musicDTO;
import model.userRank;

public class main {

	public static void main(String[] args) {
		Random ran = new Random();
		Scanner sc = new Scanner(System.in);
		DAO dao = new DAO();
		MP3Player mp3 = new MP3Player();

		System.out.println("������������������������������������������������������������������������");
		System.out.println("������������������������������������������������������������������������");
		System.out.println("������������������������������������������������������������������������");
		System.out.println("������������������������������������������������������������������������");
		System.out.println("������������������������������������������������������������������������");
		System.out.println("������������������������������������������������������������������������");
		System.out.println("������������������������������������������������������������������������");
		System.out.println("������������������������������������������������������������������������");
		System.out.println("������������������������������������������������������������������������");
		System.out.println("������������������������������������������������������������������������");
		System.out.println("������������������������������������������������������������������������");
		System.out.println("������������������������������������������������������������������������");

		while (true) {
			mp3.play("C:\\Users\\GITCT\\Desktop\\�뷡\\��Ʈ��.mp3");
			System.out.println("������������������������������������������������������������������������������������");
			System.out.println("��   [1] �α���  [2] ȸ������  [3] ����   ��");
			System.out.println("������������������������������������������������������������������������������������");
			System.out.print("�޴� >> ");
			int input1 = sc.nextInt();
			if (input1 == 1) {
				System.out.println("����������������  Log In  ����������������");
				System.out.print("���̵� �Է� : ");
				String id = sc.next();

				System.out.print("��й�ȣ �Է� : ");
				String pw = sc.next();
				System.out.println("��������������������������������������������");
				
				String nickName = dao.userLogin(id, pw);
				if (nickName != null) {
					System.out.println();
					System.out.println(nickName + "�� �������~��");
					mp3.stop();

					while (true) {
						System.out.println();
						System.out.println("�ڦ���������������������������������������������������������������������������������������������������������������");
						System.out.println("    [1] �����ϱ� [2] ��ŷ���� [3] ���Ӽ��� [4] �α׾ƿ�");
						System.out.println("�ڦ���������������������������������������������������������������������������������������������������������������");
						System.out.print("�޴� >> ");
						int input2 = sc.nextInt();
						
						System.out.println();
						if (input2 == 1) {
							System.out.println("�����ϱ⸦ �����ϼ̽��ϴ�.");
							System.out.print("�����ڰ� �뷡�� �ܾ���� �ֽ��ϴ�. ��ø� ��ٷ��ּ���");
							
							
							Thread thread = new Thread();
							
							try {
								for(int i =0; i<5; i++) {
									thread.sleep(500);
									System.out.print(" . ");
								}
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
							
							System.out.println();
							gameController game = new gameController();
											
							game.play(id, nickName);

							
						} else if (input2 == 2) {
							System.out.println();
							System.out.println("������������������ ��ŷ ����������������");
							
							ArrayList<userRank> resultList = dao.getRankingList();

							
							for(int i = 0; i<resultList.size(); i++) {
								System.out.println(resultList.get(i).toString());
								
								
							}
							System.out.println("��������������������������������������������");
							System.out.println();

						} else if (input2 == 3) {
							System.out.println();
							System.out.println("�ڦ�����������������������������������������������������������������������������������������������������������������������������������");
							System.out.println("������ �� 3���� �������� ���� �˴ϴ�.");
							System.out.println("����� 3���� �����ϰ� �� 10���� �����Է� ��ȸ�� �־����ϴ�.\n");
							System.out.println("ù��°, TTS �������� ������ ������߱�\n");
							System.out.println("�ι�°, ������ ���� ���߱�");
							System.out.println("* ���� ���� �Է��ϼ���.\n");
							System.out.println("����°, ������ ȥ�յ� �뷡 �߿� ���Ե��� ���� �뷡 ���߱�");
							System.out.println("* ���ڸ� �Է��ϼ���.\n");
							System.out.println("TTS���� 100��, ������߱� 200��, ������߱� 300��");
							System.out.println("�ڦ�����������������������������������������������������������������������������������������������������������������������������������");
							System.out.println();
						} else if (input2 == 4) {
							System.out.println("�α׾ƿ� �ϼ̽��ϴ�.");
							break;
						} else {
							System.out.println("�߸��� ���ڸ� �Է��ϼ̽��ϴ�.");
						}
					}

				} else
					System.out.println("�α��� ����");
				mp3.stop();

			} else if (input1 == 2) {
				System.out.println("===== ȸ������ =====");
				System.out.print("���̵� �Է� : ");
				String id = sc.next();

				System.out.print("��й�ȣ �Է� : ");
				String pw = sc.next();

				System.out.print("�г��� �Է� : ");
				String nick = sc.next();

				int row = dao.join(id, pw, nick);

				if (row > 0) {
					System.out.println("ȸ������ �Ϸ�!!");
					mp3.stop();
				} else {
					System.out.println("ȸ������ ���� �Ф�");
				}

			} else if (input1 == 3) {
				System.out.println("�����մϴ�.");
				mp3.stop();
				break;

			} else {
				System.out.println("�߸��� ���ڸ� �Է��ϼ̽��ϴ�.");
			}
		}

	}

	

}