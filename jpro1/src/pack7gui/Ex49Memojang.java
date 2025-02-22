package pack7gui;

import java.awt.*;
import java.awt.event.*;
import java.io.*;


import java.awt.FileDialog;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.net.URI;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;

public class Ex49Memojang extends JFrame implements ActionListener {
	private JTextArea txtMemo = new JTextArea("",10,30);
	private String copyText; //복사한 문자열 잠시 보관용
	
	private JMenuItem mnuNew, mnuSave, mnuOpen, mnuExit;
	private JMenuItem mnuCopy, mnuPaste, mnuCut, mnuDel, mnuFontSize;
	private JMenuItem mnuAbout, mnuEtc1, mnuEtc2;
	
	private JPopupMenu popup; // 팝업메뉴
	private JMenuItem m_white, m_blue, m_yellow;
	
	public Ex49Memojang() {
		super("메모장");
		
		initlayout();
		menulayout();
		setBounds(200, 200, 400, 350);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				int result = JOptionPane.showConfirmDialog(Ex49Memojang.this, 
						"정말 종료할거야?", "종료 확인", JOptionPane.YES_NO_OPTION);
				if(result == JOptionPane.YES_OPTION) 
					setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				else
					setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			}
		});
	}
	private void initlayout() {
		// TODO Auto-generated method stub
		JScrollPane scrollPane = new JScrollPane(txtMemo);
		txtMemo.setFont(new Font("돋음", Font.PLAIN, 16));
		add("Center", scrollPane);
	}
	
	private void menulayout() {
		JMenuBar menuBar = new JMenuBar(); // 메뉴바
		
		JMenu mnuFile = new JMenu("파일"); //주메뉴
		mnuNew = new JMenuItem("새문서"); //부메뉴
		mnuOpen = new JMenuItem("열기...");
		mnuSave = new JMenuItem("저장...");
		mnuExit = new JMenuItem("종료...");
		mnuFile.add(mnuNew);
		mnuFile.add(mnuOpen);
		mnuFile.add(mnuSave);
		mnuFile.addSeparator(); //구분선 
		mnuFile.add(mnuExit); // 메뉴에 부메뉴 등록
		
		JMenu mnuEdit = new JMenu("편집"); // 주메뉴
		mnuCopy = new JMenuItem("복사");
		mnuCopy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK)); 
		//복사 메뉴 아이템을 출력할 때 옆에 단축키(Ctrl+C)도 같이 표시
				
		mnuPaste= new JMenuItem("붙여넣기");
		mnuCut = new JMenuItem("잘라내기");
		mnuDel = new JMenuItem("삭제");
		mnuFontSize = new JMenuItem("글꼴 크기...");
		mnuEdit.add(mnuCopy);
		mnuEdit.add(mnuPaste);
		mnuEdit.add(mnuCut);
		mnuEdit.add(mnuDel);
		mnuEdit.addSeparator();
		mnuEdit.add(mnuFontSize);
		
		JMenu mnuShow = new JMenu("보기"); // 주메뉴
		mnuAbout = new JMenuItem("메모장이란...");
		mnuEtc1 = new JMenuItem("계산기");
		mnuEtc2 = new JMenuItem("카페");
		
		mnuShow.add(mnuAbout);
		mnuShow.addSeparator(); 
		mnuShow.add(mnuEtc1);
		mnuShow.add(mnuEtc2);
		
		menuBar.add(mnuFile); // 메뉴바에 주메뉴 등록
		menuBar.add(mnuEdit); // 메뉴바에 주메뉴 등록
		menuBar.add(mnuShow); // 메뉴바에 주메뉴 등록
		setJMenuBar(menuBar); // JFrame에 메뉴바 등록
		
		//메뉴에 리스너 달기
		mnuNew.addActionListener(this);
		mnuOpen.addActionListener(this);
		mnuSave.addActionListener(this);
		mnuExit.addActionListener(this);
		mnuCopy.addActionListener(this);
		mnuPaste.addActionListener(this);
		mnuCut.addActionListener(this);
		mnuDel.addActionListener(this);
		mnuFontSize.addActionListener(this);
		mnuAbout.addActionListener(this);
		mnuEtc1.addActionListener(this);
		mnuEtc2.addActionListener(this);
		
		// 팝업 메뉴
		popup = new JPopupMenu();
		JMenu menuColor = new JMenu("색 선택");
		m_white = new JMenuItem("하양");
		m_blue = new JMenuItem("파랑");
		m_yellow = new JMenuItem("노랑");
		menuColor.add(m_white);
		menuColor.add(m_blue);
		menuColor.add(m_yellow);
		m_white.addActionListener(this);
		m_blue.addActionListener(this);
		m_yellow.addActionListener(this);
		popup.add(menuColor);
		txtMemo.add(popup); // txtMemo에 팝업 메뉴 추가
		
		txtMemo.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mousePressed(MouseEvent e) {
				// 마우스 오른쪽 버튼 클릭 시 해당 지점에 팝업 띄우기
			if((e.getModifiersEx() &
				MouseEvent.BUTTON3_DOWN_MASK) == MouseEvent.BUTTON3_DOWN_MASK){
				//e.getModifiersEx()가 마우스 오른쪽 버튼이 눌렸는지 확인
//				// button3이 오른쪽 버튼
				popup.show(txtMemo, e.getX(), e.getY());
				// txtMemo에서 마우스 오른쪽 버튼 클릭한 지점의 x,y좌표 값 위치에 출력
				}
			}
		});
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//System.out.println(e.getActionCommand());
//		System.out.println(e.getSource());
		if(e.getSource() == mnuNew) { //새문서
			txtMemo.setText("");
			setTitle("제목없음");
		}else if(e.getSource() == mnuOpen) { //열기
			// 파일 열기를 위한 경로명과 파일명 얻기는 os 지원 창 사용
						FileDialog dialog = new FileDialog(this, 
								"열기", FileDialog.LOAD);
						dialog.setDirectory("."); 
						//이클립스에서 작업하고 있는 현재 경로가 디렉토리 기본값으로 사용됨, root 폴더는 /
						dialog.setVisible(true);
						if(dialog.getFile() == null) return;
						String dfName = dialog.getDirectory() + dialog.getFile();
						//System.out.println("dfName : " + dfName);
						try {
							BufferedReader reader = new BufferedReader(
									new FileReader(dfName));
							txtMemo.setText("");
							String line = "";
							while((line = reader.readLine()) != null){
								txtMemo.append(line + "\n");
							}
							reader.close();
							
							setTitle(dialog.getFile() + " - 메모장"); //열기 위치가 제목으로 바뀜
						} catch (Exception e2) {
							System.out.println(e2.getMessage());//개발자가 보기 위한 에러 메세지
							JOptionPane.showMessageDialog(this, 
									e2.getMessage(), "에러", 
									JOptionPane.WARNING_MESSAGE);//사용자에게 보여주기 위한 에러 메세지
						}
		}else if(e.getSource() == mnuSave) { //저장
			// 파일 저장을 위한 경로명과 파일명 얻기는 os 지원 창 사용
			FileDialog dialog = new FileDialog(this, 
					"저장", FileDialog.SAVE);
			dialog.setDirectory("."); 
			//이클립스에서 작업하고 있는 현재 경로가 디렉토리 기본값으로 사용됨, root 폴더는 /
			dialog.setVisible(true);
			if(dialog.getFile() == null) return;
			String dfName = dialog.getDirectory() + dialog.getFile();
			//System.out.println("dfName : " + dfName);
			
			try {
				//BufferedWriter writer = new BufferedWriter(
				//		new FileWriter("c:/work/a.txt")); 
				// 윈도우 타입으로 경로 및 파일 지정 c:\\work\\a.txt
				//file이 들어간 처리이므로 예외처리를 반드시 해줘야한다. 자바에서는 강제성으로 안하면 진행 안됨
				BufferedWriter writer = new BufferedWriter(
						new FileWriter(dfName)); 
				writer.write(txtMemo.getText());
				writer.close();
				setTitle(dialog.getFile() + " - 메모장"); //저장파일명이 제목으로 바뀜
			} catch (Exception e2) {
				System.out.println(e2.getMessage());//개발자가 보기 위한 에러 메세지
				JOptionPane.showMessageDialog(this, 
						e2.getMessage(), "에러", 
						JOptionPane.WARNING_MESSAGE);//사용자에게 보여주기 위한 에러 메세지
			}
		}else if(e.getSource() == mnuExit) { //종료
			int result = JOptionPane.showConfirmDialog
					(this, "정말 종료할까요?", "종료", JOptionPane.YES_NO_OPTION);
			if(result == JOptionPane.YES_OPTION);
				System.exit(0);
		}else if(e.getSource() == mnuCopy) { //복사
			//System.out.println(txtMemo.getSelectedText());
			copyText = txtMemo.getSelectedText();
			
		}else if(e.getSource() == mnuPaste) { //붙여넣기
			//txtMemo.setText(copyText);
			int position = txtMemo.getCaretPosition();
			txtMemo.insert(copyText, position); //커서가 있는 위치에 붙여넣기 가능
		}else if(e.getSource() == mnuCut) { //자르기
			copyText = txtMemo.getSelectedText();
			
			//copyText에 저장된 부분은 txtMemo에서 지움
			int start = txtMemo.getSelectionStart();
		    int end = txtMemo.getSelectionEnd();
			txtMemo.replaceRange("", start, end);
			
		}else if(e.getSource() == mnuDel) { //삭제
			int start = txtMemo.getSelectionStart();
		    int end = txtMemo.getSelectionEnd();
			txtMemo.replaceRange("", start, end);
		}else if(e.getSource() == mnuFontSize) { //글꼴 크기
			String fontSize = JOptionPane.showInputDialog(this, 
					"글꼴 크기", "16");
			if(fontSize != null) {
				try {
					int fSize = Integer.parseInt(fontSize);
					txtMemo.setFont(new Font(
							txtMemo.getFont().getName(), 
							txtMemo.getFont().getStyle(), 
							fSize));
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(this, "글자 크기를 정확히 입력하세요");
				}
			}
			
		}else if(e.getSource() == mnuAbout) { //메모장이란
			new Ex49MemoAbout(this);
			System.out.println("About 호출 후 상황 "); // Modal, Modeless 구분
		}else if(e.getSource() == mnuEtc1) { //기타1
			// exe (실행파일) 실행하기
			try {
				Runtime runtime = Runtime.getRuntime();
				runtime.exec("calc.exe");
				
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(this, e2.getMessage());
			}
		}else if(e.getSource() == mnuEtc2) { //기타2
			// 브라우저 실행하기
			try {
				// Desktop 클래스는 Java 응용 프로그램 URI 나 파일을 처리하기 위해 
				// 등록된 관련 응용 프로그램을 실행 할 수 있습니다.
				// 지원하는 기능은 아래와 같습니다.
				//1. 기본 브라우저를 통해서 URL 전시
				//2. 메일 클라이언트 실행
				//3. 기본 응용프로그램을 통해서 파일을 열거나 편집
				
				String url = "https://cafe.daum.net/flowlife";
						//Desktop 지원 확인
				if(Desktop.isDesktopSupported()) {
					Desktop desktop = Desktop.getDesktop();
					if(desktop.isSupported(Desktop.Action.BROWSE)) {
					//URI는 문자열, 특정 리소스를 의미함
						desktop.browse(new URI(url));
				}
			}else {
				JOptionPane.showMessageDialog(this, "브라우저 지원 안함");
			}}
			catch(Exception e2) {
				JOptionPane.showMessageDialog(this, e2.getMessage());
			}
		}else if(e.getSource() == m_white) {
			txtMemo.setBackground(Color.white);		// 팝업 메뉴용
		}else if(e.getSource() == m_blue) {
			txtMemo.setBackground(Color.blue);
		}
		else if(e.getSource() == m_yellow) {
			txtMemo.setBackground(Color.yellow);		
		}
		
	}
	
	public static void main(String[] args) {
		// 간단한 메모장 만들기
		new Ex49Memojang();

	}

}
