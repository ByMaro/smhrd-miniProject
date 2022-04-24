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
			System.out.println("문제 다 긁어왔어요! 문제 시작합니다!\n");
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

					System.out.println("TTS 문제 입니다.");
					System.out.println("HINT───────────────────────────★");
					System.out.println("제목 초성 : " + musicList.get(i).getHint());
					System.out.println("─────────────────────────────★");
					if (mp3.isPlaying()) {
						mp3.stop();
					}
					mp3.play(musicList.get(i).getPath());

					System.out.println("정답 입력 잔여 횟수 : " + (10 - cnt));
					System.out.print("정답입력 >> ");
					String ans = sc.next();
					stop();

					score += 100;

					if (ans.equals(musicList.get(i).getAnswer())) {
						System.out.println("정답입니다~♪");
						System.out.println();
						stop();

						mp3.play("C:\\Users\\GITCT\\Desktop\\노래\\정답입니다.mp3"); // 정답효과음

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

						System.out.print("틀렸습니다 ㅋ \t");
						System.out.print("life : ");
						if (life == 2) {
							System.out.println("♥ ♥ ♡");
						} else if (life == 1) {
							System.out.println("♥ ♡ ♡");
						} else {
							System.out.println("♡ ♡ ♡");
						}
						mp3.play("C:\\Users\\GITCT\\Desktop\\노래\\못맞췄지롱.mp3"); // 땡 효과음
						cnt++;

						if (life == 0) {
							System.out.println("GAME OVER!");
							break;
						}
						System.out.println();
						System.out.print("다시 듣겠습니까? (y) 넘어가기 (n)>> ");
						String re = sc.next();
						System.out.println();

						if (re.equals("y")) {
							mp3.play(musicList.get(i).getPath());
						} else if (re.equals("n")) {
							break;
						} else {
							System.out.println("다시 입력해주세요.");
						}
					}
				}

			} else if (musicList.get(i).getMusicid() / 100 == 2) {
				while (true) {
					System.out.println("가사 맞추기입니다.");
					System.out.println("HINT───────────────────────────★");
					System.out.println("초성 : " + musicList.get(i).getHint());
					System.out.println("─────────────────────────────★");
					if (mp3.isPlaying()) {
						mp3.stop();
					}
					mp3.play(musicList.get(i).getPath());

					System.out.println("정답 입력 잔여 횟수 : " + (10 - cnt));
					System.out.print("정답입력 >> ");
					String ans = sc.next();
					stop();

					if (ans.equals(musicList.get(i).getAnswer())) {
						System.out.println("정답입니다~♪");
						System.out.println();
						stop();

						mp3.play("C:\\Users\\GITCT\\Desktop\\노래\\정답입니다.mp3"); // 정답효과음

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
						System.out.print("틀렸습니다 ㅋ \t");
						System.out.print("life : ");

						if (life == 2) {
							System.out.println("♥ ♥ ♡");
						} else if (life == 1) {
							System.out.println("♥ ♡ ♡");
						} else {
							System.out.println("♡ ♡ ♡");
						}
						mp3.play("C:\\Users\\GITCT\\Desktop\\노래\\못맞췄지롱.mp3"); // 땡 효과음
						cnt++;
						if (life == 0) {
							System.out.println("GAME OVER!");
							break;
						}
						System.out.println();
						System.out.print("다시 듣겠습니까? (y) 넘어가기 (n) >> ");
						String re = sc.next();
						System.out.println();

						if (re.equals("y")) {
							mp3.play(musicList.get(i).getPath());
						} else if (re.equals("n")) {
							break;
						} else {
							System.out.println("다시 입력해주세요.");
						}
					}

				}

			} else if (musicList.get(i).getMusicid() / 100 == 3) {
				while (true) {
					System.out.println("셋중에 없는 곡은?");
					System.out.println(musicList.get(i).getHint());
					if (mp3.isPlaying()) {
						mp3.stop();
					}
					mp3.play(musicList.get(i).getPath());

					System.out.println("정답 입력 잔여 횟수 : " + (10 - cnt));
					System.out.print("정답입력 >> ");
					String ans = sc.next();
					stop();

					if (ans.equals(musicList.get(i).getAnswer())) {
						System.out.println("정답입니다~♪");
						System.out.println();
						stop();

						mp3.play("C:\\Users\\GITCT\\Desktop\\노래\\정답입니다.mp3"); // 정답효과음

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
						System.out.print("틀렸습니다 ㅋ \t");
						System.out.print("life : ");
						if (life == 2) {
							System.out.println("♥ ♥ ♡");
						} else if (life == 1) {
							System.out.println("♥ ♡ ♡");
						} else {
							System.out.println("♡ ♡ ♡");
						}
						mp3.play("C:\\Users\\GITCT\\Desktop\\노래\\못맞췄지롱.mp3"); // 땡 효과음

						cnt++;
						if (life == 0) {
							System.out.println("GAME OVER!");

							break;
						}
						System.out.println();
						System.out.print("다시 듣겠습니까? (y) 넘어가기 (n) >> ");
						String re = sc.next();
						System.out.println();

						if (re.equals("y")) {
							mp3.play(musicList.get(i).getPath());
						} else if (re.equals("n")) {
							break;
						} else {
							System.out.println("다시 입력해주세요.");
						}
					}
				}
			} else {
				System.out.println("잘못된 숫자를 입력하셨어요! 다시 입력해주세요!");
			}
			if (cnt == 10) {
				System.out.println(cnt + "번의 기회를 다 사용하셨습니다.");
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