package pack;

import java.util.Scanner;

public class Test9while {

	public static void main(String[] args) {
//		// 반복문 while
//		// while(조건) {실행문들...}
//		int w = 1;
//		while(w <= 5) { // for문과 다르게 증가치가 매개변수가 아닌 블럭 안에 들어있어야 한다.
//			System.out.print("w=" + w + " "); // w=1 w=2 w=3 w=4 w=5 while 수행 후 w: 6 으로 출력됨
//			w++;
//		}
//		System.out.println("\nwhile 수행 후 w:" + w);
//		
//		System.out.println();
//		int count = 0;
//		while(count < 5) {
//			count++;
//			System.out.println("count : " + count);
//			if(count == 3) {System.out.println("쉬어가기");
//			
//			}
//			if(count == 5) {
//				System.out.println("count가 5라서 종료: " + count);
//			}
//		}
//		System.out.println();
//		w = 0;
//		while(true) { // 무한 루프
//			w++;
//			if(w == 5) break;
//			if(w == 3) continue; // continue일때 위로 다시 올라가므로 w=3은 출력이 되지 않는다.
//			System.out.println("w는 " + w);
//				
//		}
//		
//		System.out.println();
//		//factorial n!은 1부터 n까지의 모든 정수의 곱을 의미
//		// ex: 5! = 5 * 4 * 3 * 2 * 1 = 120
//		Scanner scanner = new Scanner(System.in);
//		System.out.println("정수 입력");
//		 int number = scanner.nextInt(); // api를 가져다 적용
//		 
//		 //factorial 계산을 위한 초기값 설정
//		 int factorial = 1;
//		 int i = 1; // 반복을 위한 counter 변수
//		 while(i <= number) {
//			 //System.out.println(i);
//			 factorial *= i;
//			 i++;
//		 }
//		 System.out.printf("number는 %d factorial은 %d이다", number, factorial);
//		 
//		 System.out.println("\n다중 while ---");
//		 int a = 1;
//		 while (a <= 3) {  //다중 while문
//			 System.out.println("a:" + a);
//			 int b = 1;
//			 while(b <= 4) {System.out.print("b:" + b);
//				 b++;
//				 
//			 }
//			 a++;
//			 System.out.println();
// 			 출력결과
//           a:1
//			 b:1b:2b:3b:4
//			 a:2
//			 b:1b:2b:3b:4
//			 a:3
//			 b:1b:2b:3b:4
			 
//  			키보드로 입력받은 숫자에 대해 1부터 시작해 그 숫자까지 모든 수에
//				나누기를 시도하고 나누어 떨어지는 경우(약수) 그 수 를 출력한다
// 				0이나 음수를 입력하면 프로그램 종료.
			 
//			 Scanner scanner1 = new Scanner(System.in);
//			     while(true) { //while(true) 이므로 무한 반복
//				 System.out.println("정수 입력(0이나 음수면 종료):");
//				 int num = scanner1.nextInt(); // API를 가져다 적용
//				 if(num <= 0) {
//					 System.out.println("프로그램 종료");
//					 break;
//				 }
//				 System.out.println(num + "의 약수는");
//				 int divisor = 1; //약수를 찾기 위해 1부터 시작
//				 while(divisor <= num) {
//					 if(num % divisor == 0) {
//						 System.out.println(divisor); // 약수 출력
//					 }
//					 divisor++; // 다음 수로 이동
//					정수를 입력하면 약수를 구해주는 위의 코드의 출력결과는 아래와 같다.
//					 정수 입력(0이나 음수면 종료):
//						 20
//						 20의 약수는
//						 1
//						 2
//						 4
//						 5
//						 10
//						 20
					 
//				 	}
//				}
		
//			 System.out.println();
//			 //do{반복 수행문...} while(조건);
//			 int k = 10;
//			 do {System.out.println("k : " + k);
//			 	k = k + 1;
//			 }while (k<=5); //while 조건문이 아래에 있으므로 k: 10이 한번은 출력된다.
//			 
		
		
//				 System.out.println("exam -------");
		
//			 문1) 1 ~ 100 사이의 정수 중 3의 배수이지만 2의 배수가 아닌 수를 출력하고, 합과 갯수도 출력
			 
//		    int sum = 0;
//	        int count = 0;
//	        int number = 1;
//
//	        while (number <= 100) {
//	            if (number % 3 == 0 && number % 2 != 0) {
//	                System.out.println(number);
//	                sum += number;
//	                count++;
//	            }
//	            number++;
//	        }
//
//	        System.out.println("합: " + sum);
//	        System.out.println("갯수: " + count);
			        
			 //문2) -1, 3, -5, 7, -9, 11 .... 99까지의 합 출력
//	        int sum = 0;
//	        int number = -1;
//	        int limit = 99;
//
//	        while (number <= limit) {
//	            sum += number;
//	            if (number > 0) {
//	                number = -number - 2;
//	            } else {
//	                number = -number + 2;
//	            }
//	        }
//
//	        System.out.println("합: " + sum);  //출력 결과 -51
			        
		// 문제 2번 정석으로 풀기 -1, 3, -5, 7, -9, 11 .... 99까지의 합 출력
		int n=1, cnt = 1, hap = 0;
		while(n < 100) {
			if(cnt % 2 == 0) {
			hap += n;
			System.out.println("짝수" + n);
		}else {
			int imsi = n * -1;
			hap +=imsi; //부호 변경 후 누적
			System.out.println("홀수" + imsi);
		}
		n += 2;
		cnt += 1;
	}
		System.out.println("while 합은" + hap + "입니다"); // 출력 결과 50
//		
//		// 문제 2번 for문으로 출력하기 -1, 3, -5, 7, -9, 11 .... 99까지의 합 출력
//		int hap2 = 0, cnt2 = 1;
//		for(int c=1; c < 100; c += 2) {
//			if(cnt2 % 2 == 0) {
//				hap2 += c;
//			}else {
//				hap2 += (-1) * c;
//			}
//			cnt2++;
//		}
//		System.out.println("for 합은 " + hap2 + "입니다");
		
		
//			 //문3) 1 ~ 1000 사이의 정수중에서 소수와 그 개수를 출력
//			       //첫번째 풀이 방법 
//			        int count1 = 0;
//
//			        for (int d = 2; d <= 1000; d++) {
//			            if (isPrime(d)) {
//			                System.out.println(d);
//			                count1++;
//			            }
//			        }
//
//			        System.out.println("소수의 개수: " + count1);}
//			    
//
//			  
//		
//
//		 
//
//		 
//		  // 소수인지 판별하는 메소드
//		    public static boolean isPrime(int num) {
//		        if (num <= 1) {
//		            return false;
//		        }
//		        for (int i = 2; i <= Math.sqrt(num); i++) {
//		            if (num % i == 0) {
//		                return false;
//		            }
//		        }
//		        return true;
//			 //소수 : 1보다 크며 1과 그 수 자체 이외의 다른 수로는 나누어 떨어지지 않는 수
//		        }
//			결과값 소수의 개수: 168
		
//		    // 문제 3번 정석 풀이 방법 1 ~ 1000 사이의 정수 중에서 소수와 그 개수를 출력
//		    
		    int aa = 2;
		    int count2 = 0;  //소수의 갯수
		    int su2 = 0;
		    System.out.println("1부터 100까지의 소수: ");
		    while(aa <= 100) {
		    	boolean imsi = false;
		    	
		    	int bb = 2;
		    	while (bb <= aa - 1) {
		    		if(aa % bb == 0) {
		    			imsi = true;
		    		}
		    		bb++;
		    	}
		    	if(imsi == false) {
		    		System.out.println(aa + " ");
		    		count2++;
		    	}
		    	aa++;
		    }
		    System.out.println("\n건수 : " + count2);
		    
		    System.out.println("2부터 그 숫자의 제곱근까지의 모든 수로 나누어 떨어지는지 확인");
		    //소수를 찾는 이유로 제곱근까지만 검사하는 것은 어떤 수의 약수는 그 수의 제곱근을 넘지 않기 때문이다.
		    int num = 2; // 1은 소수가 아니므로 2부터 출발
		    int count7 = 0; // 소수의 개수
		    System.out.println("1부터 100까지의 소수: ");
		    while(num <= 100) {
		    	boolean isPrime = true; // 현재 숫자가 소수인지 판별
		    	int divisor = 2; // 나누는 수는 2부터 시작
		    	while(divisor <= Math.sqrt(num)) {
		    		if(num % divisor == 0) {
		    			isPrime = false;
		    			break; // 나누어 떨어지지 않으면 더 이상의 검사는 필요없음
		    			
		    		}
		    		divisor++;
		    	}
		    	if (isPrime == true) { //if(isPrime)으로 써도 같은 의미
		    		count7++;  // 소수의 개수 증가
		    		System.out.println(num + " ");
		    	}
		    		num++;
		    }
		    System.out.println("\n건수 : " + count2);
		    
	}
}