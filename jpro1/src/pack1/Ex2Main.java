package pack1;



public class Ex2Main {
	public static void main(String[] args) {
		// getter, setter 연습
		System.out.println("프로그램을 실행하다가 ...");
		
		// Ex2Car 객체를 만들기
		System.out.println();
		Ex2Car tom = new Ex2Car();
		tom.showData();		
		System.out.println("이름은 " + tom.irum);
		tom.irum = "미스터 톰"; // private이 아니므로 접근가능
		System.out.println("이름은 " + tom.irum);
		System.out.println("겟터, 셋터 확인");
		//tom.speed = 80; // private 이므로 접근 불가능
		// tom.abcd(80, 123); // 예를 들어 비밀번호에 의해 수정 결정
		tom.setSpeed(80);
		tom.showData();	
		// System.out.println("속도는 " + tom.speed);
		System.out.println("속도는 " + tom.getSpeed()); // 속도는 80 출력
		int result = tom.getSpeed();
		System.out.println("속도는 " + result); // 속도는 80 출력
	
	}
}
