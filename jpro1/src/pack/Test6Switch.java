package pack;

import java.util.Scanner;

public class Test6Switch {

	public static void main(String[] args) {
		// 조건 판단문 switch : 좀 더 정형화된 문법으로 값에 따라 여러 방향으로 분기하는 경우에 사용
		// 길게 늘어진 if문에 비해 코드가 짧고 의미파악이 쉽다.
		int nai = 25;
		nai = nai / 10 * 10; // 몫만 취하므로 나이대가 나온다

		switch (nai) {
		case 20:
			System.err.println("이십대");
			break; // break를 안걸어주면 밑에 case 30까지 다 출력된다.
		case 30:
			System.err.println("삼십대");
			System.err.println("만세");
			break;
		default:
			System.err.println("기타");
			break;
		}

		System.out.println();
		String jik = "과장";
		switch (jik) {
		case "대리": // switch 조건문에 문자열이 들어갈 수 있다.
			System.err.println("대리");
			break;
		case "과장":
			System.err.println("과장 만세");
			break;
		case "부장":
			System.err.println("부장 만세2");
			System.err.println("하하하");
			break;
		default:
			System.out.println("기타 직원");
		}

		System.out.println();
		System.out.println(Math.random()); // 난수 출력
		int time = (int) (Math.random() * 4) + 8; // 8-11 사이 정수를 얻을 수 있음

		switch (time) {
		case 8:
			System.out.println("학원 가자");
			break;
		case 9:
			System.out.println("인사하자");
			System.out.println("복습하자");
			break;
		case 10:
			System.out.println("문제 풀자");
			break;
		default:
			System.out.println("명상 시간");
		}

		System.out.println();
		// 키보드로 년과 월을 입력받아 해당 년월의 날수 출력
		int year, month, days = 28;
		String msg = "평년";

		Scanner sc = new Scanner(System.in);
		System.out.println("년도 입력");
		year = sc.nextInt();
		System.out.println("월 입력");
		month = sc.nextInt();

		year = 2024;
		month = 2;

		if (month < 1 || month > 12) {
			System.out.println("월은 1 ~ 12 사이만 허용"); // 입력자료 오류 검사
			System.exit(0); // 프로그램 강제 종료, 원래는 main 함수의 마지막 괄호에서 끝나야 하는데 exit 명령으로 여기에서 바로 끝난다.

		}
		// 윤년 체크해서 윤년이면 2월에 29
		if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) { // 4의 배수이고 100의 배수가 아니거나 400의 배수 //윤년의 조건
			days = 29;
			msg = "윤년";
		}

		switch (month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			days = 31;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			days = 30;
			break;

		}

		System.out.println("결과 : " + year + "년 " + month + "월은 " + days + " " + msg);

	}

}
