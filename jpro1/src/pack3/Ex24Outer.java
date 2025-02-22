package pack3;

import java.awt.Frame;
import java.awt.event.WindowAdapter;

//내부 클래스
//클래스의 멤버로 필드, 메소드, 클래스를 사용할 수 있다.
//추가적으로 특정 클래스 내에서 클래스를 선언해서 사용할 수 있는데 이름 내부 클래스라고 한다.
//내부 클래스는 독립적으로 인스턴스 할 수 없다. 내부 클래스를 포함한 외부 클래스에 의해 등재된다.


public class Ex24Outer {
	private int a;
	private Inner inner;
	
	public Ex24Outer() {
		System.out.println("outer 생성자");
		a = 10;
		inner = new Inner(); // 내부 클래스는 외부 클래스를 통해 인스턴스 한다.
	}
	
	public void aa() {
		System.out.println("외부에 있는 aa 메서드 실행");
		bb(); // aa 메소드와 동급 메소드 호출이므로 바로 부를 수 있음
		inner.cc();//cc 메소드는 내부 클래스의 멤버 
		System.out.println("1outer의 a:" + a + ", inner의 b:" + inner.b);
	}
	
	public void bb() {
		System.out.println("외부에 있는 bb 메서드 실행");
	}
	
	public class Inner{ //내부 클래스
		private int b;
		
		public Inner() {
			System.out.println("inner 생성자");
			b = 20;
		}
		
		public void cc() {
			System.out.println("내부 클래스에 있는 cc 메서드 처리");
			bb(); // 내부 클래스는 외부 클래스의 멤버를 자유롭게 호출 가능
			System.out.println("2outer의 a:" + a + ", inner의 b:" + b);
		}
		public class InnerInner{//내부 클래스 내에서 다시 내부 클래스를 선언 가능
			
		}
		
		
	}
	
	//내부 클래스의 수 만큼 extends를 사용할 수 있다.
	public class Inner2 extends Frame{
		
	}
	public class Inner3 extends WindowAdapter{
		
	}
	
}
