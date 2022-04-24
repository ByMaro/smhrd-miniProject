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

		System.out.println("□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□");
		System.out.println("□■□□□□□□□■□□■□□□□■□□□■■■■□□□■□□□□■■■■□□□□□□□□□■■■□□□□■□□□□■□□■□□■■■■■■□");
		System.out.println("□■■□□□□□■■□□■□□□□■□□■□□□□■□□■□□□■□□□□■□□□□□□□■□□□■□□□■□□□□■□□■□□□□□□□■□");
		System.out.println("□■■□□□□□■■□□■□□□□■□□■□□□□■□□■□□■□□□□□□□□□□□□■□□□□□■□□■□□□□■□□■□□□□□□■□□");
		System.out.println("□■□■□□□■□■□□■□□□□■□□■□□□□□□□■□□■□□□□□□□□□□□□■□□□□□■□□■□□□□■□□■□□□□□■□□□");
		System.out.println("□■□■□□□■□■□□■□□□□■□□□■■□□□□□■□□■□□□□□□□□□□□□■□□□□□■□□■□□□□■□□■□□□□□■□□□");
		System.out.println("□■□□■□■□□■□□■□□□□■□□□□□■■□□□■□□■□□□□□□□□□□□□■□□□□□■□□■□□□□■□□■□□□□■□□□□");
		System.out.println("□■□□■□■□□■□□■□□□□■□□□□□□□■□□■□□■□□□□□□□□□□□□■□□□□□■□□■□□□□■□□■□□□■□□□□□");
		System.out.println("□■□□□■□□□■□□■□□□□■□□■□□□□■□□■□□■□□□□□□□□□□□□■□□□■□■□□■□□□□■□□■□□□■□□□□□");
		System.out.println("□■□□□■□□□■□□■□□□□■□□■□□□□■□□■□□□■□□□□■□□□□□□□■□□□■□□□■□□□□■□□■□□■□□□□□□");
		System.out.println("□■□□□□□□□■□□□■■■■□□□□■■■■□□□■□□□□■■■■□□□□□□□□□■■■□■□□□■■■■□□□■□□■■■■■■□");
		System.out.println("□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□□");

		while (true) {
			mp3.play("C:\\Users\\GITCT\\Desktop\\노래\\인트로.mp3");
			System.out.println("┏────────────────────────────────────────┓");
			System.out.println("│   [1] 로그인  [2] 회원가입  [3] 종료   │");
			System.out.println("┗────────────────────────────────────────┛");
			System.out.print("메뉴 >> ");
			int input1 = sc.nextInt();
			if (input1 == 1) {
				System.out.println("────────  Log In  ────────");
				System.out.print("아이디 입력 : ");
				String id = sc.next();

				System.out.print("비밀번호 입력 : ");
				String pw = sc.next();
				System.out.println("──────────────────────");
				
				String nickName = dao.userLogin(id, pw);
				if (nickName != null) {
					System.out.println();
					System.out.println(nickName + "님 어서오세요~♪");
					mp3.stop();

					while (true) {
						System.out.println();
						System.out.println("★───────────────────────────────────────────────────────★");
						System.out.println("    [1] 게임하기 [2] 랭킹보기 [3] 게임설명 [4] 로그아웃");
						System.out.println("★───────────────────────────────────────────────────────★");
						System.out.print("메뉴 >> ");
						int input2 = sc.nextInt();
						
						System.out.println();
						if (input2 == 1) {
							System.out.println("게임하기를 선택하셨습니다.");
							System.out.print("개발자가 노래를 긁어오고 있습니다. 잠시만 기다려주세요");
							
							
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
							System.out.println("───────── 랭킹 ────────");
							
							ArrayList<userRank> resultList = dao.getRankingList();

							
							for(int i = 0; i<resultList.size(); i++) {
								System.out.println(resultList.get(i).toString());
								
								
							}
							System.out.println("──────────────────────");
							System.out.println();

						} else if (input2 == 3) {
							System.out.println();
							System.out.println("★─────────────────────────────────────────────────────────────────★");
							System.out.println("게임은 총 3가지 유형으로 출제 됩니다.");
							System.out.println("목숨은 3개로 시작하고 총 10번의 정답입력 기회가 주어집니다.\n");
							System.out.println("첫번째, TTS 음성으로 가사듣고 제목맞추기\n");
							System.out.println("두번째, 가사듣고 소절 맞추기");
							System.out.println("* 띄어쓰기 없이 입력하세요.\n");
							System.out.println("세번째, 세가지 혼합된 노래 중에 포함되지 않은 노래 맞추기");
							System.out.println("* 숫자를 입력하세요.\n");
							System.out.println("TTS문제 100점, 가사맞추기 200점, 제목맞추기 300점");
							System.out.println("★─────────────────────────────────────────────────────────────────★");
							System.out.println();
						} else if (input2 == 4) {
							System.out.println("로그아웃 하셨습니다.");
							break;
						} else {
							System.out.println("잘못된 숫자를 입력하셨습니다.");
						}
					}

				} else
					System.out.println("로그인 실패");
				mp3.stop();

			} else if (input1 == 2) {
				System.out.println("===== 회원가입 =====");
				System.out.print("아이디 입력 : ");
				String id = sc.next();

				System.out.print("비밀번호 입력 : ");
				String pw = sc.next();

				System.out.print("닉네임 입력 : ");
				String nick = sc.next();

				int row = dao.join(id, pw, nick);

				if (row > 0) {
					System.out.println("회원가입 완료!!");
					mp3.stop();
				} else {
					System.out.println("회원가입 실패 ㅠㅠ");
				}

			} else if (input1 == 3) {
				System.out.println("종료합니다.");
				mp3.stop();
				break;

			} else {
				System.out.println("잘못된 숫자를 입력하셨습니다.");
			}
		}

	}

	

}