package pack5io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Ex35IoTest2 {
	// 1byte 단위로 데이터 입출력 : 문자, 그림, 소리 파일 등 다양한 데이터 처리가 가능
	public void write_file(File file, ArrayList<String> strdatas) {
		try {
			BufferedWriter writer = new BufferedWriter(
			  new OutputStreamWriter(new FileOutputStream(file), "utf-8"));
			for(String munja: strdatas) {
				writer.write(munja, 0, munja.length());
				writer.newLine(); // 라인 스킵
				
			}
			if(writer != null) writer.close();
		} catch (Exception e) {
			System.out.println("write_file err : " + e);
		} 
		
	}

	public void read_file(File file) {
		try {
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(new FileInputStream(file), "UTF-8"));
			String oneline;
			// String strs = null;
			// 문자열 더하기 많은 경우 아래 두개의 클래스 중 하나를 추천
			StringBuffer buffer = new StringBuffer();
			// StringBuilder builder = new StringBuilder();
			
			while((oneline = reader.readLine()) != null) {
		//		strs += oneline + "\n"; // 문자열 더하기는 비권장
				buffer.append(oneline + "\n");
			}
			if(reader != null) reader.close();
			System.out.println(buffer.toString());
			//버퍼 내용 콘솔로 출력			
		} catch (Exception e) {
			System.out.println("write_file err : " + e);
		} finally {

		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> list = new ArrayList<String>();
		list.add("하하");
		list.add("호호");
		list.add("허허허");

		File file = new File("c:/work/iotest.txt");

		Ex35IoTest2 test2 = new Ex35IoTest2();
		test2.write_file(file, list);
		test2.read_file(file);

	}

}
