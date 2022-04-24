package controller;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import javazoom.jl.player.MP3Player;
import model.DAO;
import model.musicDTO;

public class gameController {
	Random ran = new Random();
	DAO dao = new DAO();
	Scanner sc = new Scanner(System.in);
	Thread thread = new Thread();

	private MP3Player mp3 = new MP3Player();
	private ArrayList<musicDTO> musicList = new ArrayList<musicDTO>();

	public gameController() {

		ArrayList<Integer> buf = new ArrayList<Integer>();
		buf = dao.musicId();

		int[] ran_index = new int[30];

		for (int i = 0; i < ran_index.length; i++) {
			ran_index[i] = buf.get(ran.nextInt(buf.size()));
			for (int j = 0; j < i; j++) {
				if (ran_index[i] == ran_index[j]) {
					i--;
					break;
				}
			}
		}
		for (int i = 0; i < ran_index.length; i++) {
			musicList.add(dao.musicIdQuestion(ran_index[i]));
		}
		try {
			System.out.println("���� �� �ܾ�Ծ��! ���� �����մϴ�!\n");
			Thread.sleep(2000);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public musicDTO play(String id, String nickname) {
		int i = 0;
		int score = 0;
		int cnt = 0;
		stop();
		int life = 3;

		while (life > 0) {

			if (musicList.get(i).getMusicid() / 100 == 1) {
				while (true) {

					System.out.println("TTS ���� �Դϴ�.");
					System.out.println("HINT��������������������������������������������������������");
					System.out.println("���� �ʼ� : " + musicList.get(i).getHint());
					System.out.println("������������������������������������������������������������");
					if (mp3.isPlaying()) {
						mp3.stop();
					}
					mp3.play(musicList.get(i).getPath());

					System.out.println("���� �Է� �ܿ� Ƚ�� : " + (10 - cnt));
					System.out.print("�����Է� >> ");
					String ans = sc.next();
					stop();

					score += 100;

					if (ans.equals(musicList.get(i).getAnswer())) {
						System.out.println("�����Դϴ�~��");
						System.out.println();
						stop();

						mp3.play("C:\\Users\\GITCT\\Desktop\\�뷡\\�����Դϴ�.mp3"); // ����ȿ����

						try {
							thread.sleep(3000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}

						cnt++;
						break;
					} else {
						stop();
						life--;

						System.out.print("Ʋ�Ƚ��ϴ� �� \t");
						System.out.print("life : ");
						if (life == 2) {
							System.out.println("�� �� ��");
						} else if (life == 1) {
							System.out.println("�� �� ��");
						} else {
							System.out.println("�� �� ��");
						}
						mp3.play("C:\\Users\\GITCT\\Desktop\\�뷡\\����������.mp3"); // �� ȿ����
						cnt++;

						if (life == 0) {
							System.out.println("GAME OVER!");
							break;
						}
						System.out.println();
						System.out.print("�ٽ� ��ڽ��ϱ�? (y) �Ѿ�� (n)>> ");
						String re = sc.next();
						System.out.println();

						if (re.equals("y")) {
							mp3.play(musicList.get(i).getPath());
						} else if (re.equals("n")) {
							break;
						} else {
							System.out.println("�ٽ� �Է����ּ���.");
						}
					}
				}

			} else if (musicList.get(i).getMusicid() / 100 == 2) {
				while (true) {
					System.out.println("���� ���߱��Դϴ�.");
					System.out.println("HINT��������������������������������������������������������");
					System.out.println("�ʼ� : " + musicList.get(i).getHint());
					System.out.println("������������������������������������������������������������");
					if (mp3.isPlaying()) {
						mp3.stop();
					}
					mp3.play(musicList.get(i).getPath());

					System.out.println("���� �Է� �ܿ� Ƚ�� : " + (10 - cnt));
					System.out.print("�����Է� >> ");
					String ans = sc.next();
					stop();

					if (ans.equals(musicList.get(i).getAnswer())) {
						System.out.println("�����Դϴ�~��");
						System.out.println();
						stop();

						mp3.play("C:\\Users\\GITCT\\Desktop\\�뷡\\�����Դϴ�.mp3"); // ����ȿ����

						try {
							thread.sleep(3000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}

						cnt++;
						score += 200;

						break;
					} else {
						stop();
						life--;
						System.out.print("Ʋ�Ƚ��ϴ� �� \t");
						System.out.print("life : ");

						if (life == 2) {
							System.out.println("�� �� ��");
						} else if (life == 1) {
							System.out.println("�� �� ��");
						} else {
							System.out.println("�� �� ��");
						}
						mp3.play("C:\\Users\\GITCT\\Desktop\\�뷡\\����������.mp3"); // �� ȿ����
						cnt++;
						if (life == 0) {
							System.out.println("GAME OVER!");
							break;
						}
						System.out.println();
						System.out.print("�ٽ� ��ڽ��ϱ�? (y) �Ѿ�� (n) >> ");
						String re = sc.next();
						System.out.println();

						if (re.equals("y")) {
							mp3.play(musicList.get(i).getPath());
						} else if (re.equals("n")) {
							break;
						} else {
							System.out.println("�ٽ� �Է����ּ���.");
						}
					}

				}

			} else if (musicList.get(i).getMusicid() / 100 == 3) {
				while (true) {
					System.out.println("���߿� ���� ����?");
					System.out.println(musicList.get(i).getHint());
					if (mp3.isPlaying()) {
						mp3.stop();
					}
					mp3.play(musicList.get(i).getPath());

					System.out.println("���� �Է� �ܿ� Ƚ�� : " + (10 - cnt));
					System.out.print("�����Է� >> ");
					String ans = sc.next();
					stop();

					if (ans.equals(musicList.get(i).getAnswer())) {
						System.out.println("�����Դϴ�~��");
						System.out.println();
						stop();

						mp3.play("C:\\Users\\GITCT\\Desktop\\�뷡\\�����Դϴ�.mp3"); // ����ȿ����

						try {
							thread.sleep(3000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}

						score += 300;
						cnt++;
						break;
					} else {
						stop();
						life--;
						System.out.print("Ʋ�Ƚ��ϴ� �� \t");
						System.out.print("life : ");
						if (life == 2) {
							System.out.println("�� �� ��");
						} else if (life == 1) {
							System.out.println("�� �� ��");
						} else {
							System.out.println("�� �� ��");
						}
						mp3.play("C:\\Users\\GITCT\\Desktop\\�뷡\\����������.mp3"); // �� ȿ����

						cnt++;
						if (life == 0) {
							System.out.println("GAME OVER!");

							break;
						}
						System.out.println();
						System.out.print("�ٽ� ��ڽ��ϱ�? (y) �Ѿ�� (n) >> ");
						String re = sc.next();
						System.out.println();

						if (re.equals("y")) {
							mp3.play(musicList.get(i).getPath());
						} else if (re.equals("n")) {
							break;
						} else {
							System.out.println("�ٽ� �Է����ּ���.");
						}
					}
				}
			} else {
				System.out.println("�߸��� ���ڸ� �Է��ϼ̾��! �ٽ� �Է����ּ���!");
			}
			if (cnt == 10) {
				System.out.println(cnt + "���� ��ȸ�� �� ����ϼ̽��ϴ�.");
				break;
			}
			i++;
		}
		dao.updateScore(id, nickname, score);
		return musicList.get(i);
	}

	public boolean stop() {
		boolean result = false;
		if (mp3.isPlaying()) {
			mp3.stop();
			result = true;
		}
		return result;
	}

}