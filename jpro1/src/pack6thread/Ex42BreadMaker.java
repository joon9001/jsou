package pack6thread;

import java.util.Iterator;

public class Ex42BreadMaker extends Thread { // 빵 생산자
	private Ex42BreadPlate plate;
	
	public Ex42BreadMaker(Ex42BreadPlate plate) {
		this.plate = plate;
	}
	
	@Override
		public void run() {
			for (int i = 0; i < 30; i++) {
				plate.makeBread();
			}
		}
}
