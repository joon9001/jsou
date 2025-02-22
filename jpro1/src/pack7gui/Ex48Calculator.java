// 팀원 풀이방식
package pack7gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Ex48Calculator extends JFrame implements ActionListener {
	private JTextField txt1, txt2;
	int num1, num2;
	private ButtonGroup rbGroup = new ButtonGroup();
	private JRadioButton rbA, rbS, rbM, rbD;
	private JLabel lblResult;
	private JButton btnCalc, btnReset, btnFin;
	
	public Ex48Calculator() {
		super("미니 계산기");
		
		calcLayout();
		
		setBounds(200, 200, 300, 400);
		setVisible(true);
		
		//super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				int result = JOptionPane.showConfirmDialog(Ex48Calculator.this, 
						"정말 종료할거야?", "종료 확인", JOptionPane.YES_NO_OPTION);
				if(result == JOptionPane.YES_OPTION) 
					setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				else
					setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			}
		});
	}
	
	private void calcLayout() {
		setLayout(new GridLayout(5,1));
		
		// 1행
		JLabel lbl1 = new JLabel("숫자1: ");
		txt1 = new JTextField("",20);
		JPanel panel1 = new JPanel();
		panel1.add(lbl1);
		panel1.add(txt1);
		add(panel1);
		
		// 2행
		JLabel lbl2 = new JLabel("숫자2: ");
		txt2 = new JTextField("",20);
		JPanel panel2 = new JPanel();
		panel2.add(lbl2);
		panel2.add(txt2);
		add(panel2);
		
		// 3행
		JLabel lbl3 = new JLabel("연산선택: ");
		rbA = new JRadioButton("+",true);
		rbS = new JRadioButton("-",false);
		rbM = new JRadioButton("*",false);
		rbD = new JRadioButton("/",false);
		rbGroup.add(rbA);
		rbGroup.add(rbS);
		rbGroup.add(rbM);
		rbGroup.add(rbD);
		
		JPanel panel3 = new JPanel();
		panel3.add(lbl3);
		panel3.add(rbA);
		panel3.add(rbS);
		panel3.add(rbM);
		panel3.add(rbD);
		add(panel3);
		
		// 4행
		lblResult = new JLabel("결과: ", JLabel.CENTER);
		add(lblResult);
		
		// 5행
		btnCalc = new JButton("계산"); 
		btnReset = new JButton("초기화");
		btnFin = new JButton("종료");
		btnCalc.addActionListener(this);
		btnReset.addActionListener(this);
		btnFin.addActionListener(this);
		
		JPanel panel5 = new JPanel();
		panel5.add(btnCalc);
		panel5.add(btnReset);
		panel5.add(btnFin);
		add(panel5);	

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnCalc) {			
			// 숫자1 오류 검사
			if(txt1.getText().equals("")) {
				lblResult.setText("숫자1 입력해");
				txt1.requestFocus();
				return;
			}
			try {
				num1 = Integer.parseInt(txt1.getText());
			} catch (Exception e2) {
				lblResult.setText("숫자1 정수로 제대로 입력!!");
				txt1.requestFocus();
				return;
			}
			
			// 숫자2 오류 검사
			if(txt2.getText().equals("")) {
				lblResult.setText("숫자2 입력해");
				txt2.requestFocus();
				return;
			}
			try {
				num2 = Integer.parseInt(txt2.getText());
			} catch (Exception e2) {
				lblResult.setText("숫자2 정수로 제대로 입력!!");
				txt2.requestFocus();
				return;
			}
			
			// 계산
			int result;
			if(rbA.isSelected()) lblResult.setText("결과: " + (num1 + num2));
			else if (rbS.isSelected()) lblResult.setText("결과: " + (num1 - num2));
			else if (rbM.isSelected()) lblResult.setText("결과: " + (num1 * num2));
			else {
				if(num1==0) {
					lblResult.setText("0은 나눌 수 없어");
					txt1.setText("");
					txt1.requestFocus();
				}
				else if(num2==0) {
					lblResult.setText("0으로 나눌 수 없어");
					txt2.setText("");
					txt2.requestFocus();
				} else
				lblResult.setText("결과: " + (double)num1 / (double)num2);
			}
			
			
		} else if(e.getSource() == btnReset) {
			txt1.setText("");
			txt2.setText("");
			rbA.setSelected(true);
			rbS.setSelected(false);
			rbM.setSelected(false);
			rbD.setSelected(false);
			txt1.requestFocus();
			lblResult.setText("결과: ");
		} else {
			int result = JOptionPane.showConfirmDialog(this, "정말 종료할거야?", "종료 확인", JOptionPane.YES_NO_OPTION);
			if(result == 0) System.exit(0);
			else return;
		}		
	}

	public static void main(String[] args) {
		new Ex48Calculator();
	}
}


/*
 내 풀이방식

package pack7gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Ex48Calculator extends JFrame implements ActionListener{
	JTextField txtNum1, txtNum2;
	ButtonGroup buttonGroup = new ButtonGroup(); // 버튼이 모두 1개로 합쳐지는 것을 방지하기 위해 그룹으로 묶어서 분리하기 위함
	JRadioButton rdoPlus, rdoMinus, rdoMul, rdoDiv;
	JLabel lblResult;
	JButton btnCal, btnReset, btnFin;


	int num1 = 0;
	int num2 = 0;
	int Result = 0;
	
   
     
	
	
	public Ex48Calculator() {
		super("미니 계산기");
		
		layoutInit();
		calculate();
		reset();
		finish();
		
		setBounds(200, 200, 400, 300);
		setVisible(true);
		
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	private void layoutInit() {
		setLayout(new GridLayout(5, 1));
		
		// 1행
		JLabel lbl1 = new JLabel("숫자1 : "); //숫자1 제목 필드 추가
		txtNum1 = new JTextField("", 20); //숫자1 입력 필드 추가
		 String inputText1 = txtNum1.getText();
		 num1 = Integer.parseInt(inputText1);
		JPanel panel1 = new JPanel();
		panel1.add(lbl1);
		panel1.add(txtNum1);
		add(panel1); // Frame에 등록
		
		// 2행
		
		JLabel lbl2 = new JLabel("숫자2 : "); //숫자2 제목 필드 추가
		txtNum2 = new JTextField("", 20);//숫자2 입력 필드 추가
		String inputText2 = txtNum2.getText();
		num2 = Integer.parseInt(inputText2);
		JPanel panel2 = new JPanel();
		panel2.add(lbl2);
		panel2.add(txtNum2);
		add(panel2); // Frame에 등록
		
		// 3행
		JLabel lbl3 = new JLabel("연산 선택 : "); // 연산 선택 필드 추가
		rdoPlus = new JRadioButton("+"); // 
		rdoMinus = new JRadioButton("-");
		rdoMul = new JRadioButton("*");
		rdoDiv = new JRadioButton("/");
		buttonGroup.add(rdoPlus);//JRadioButton은 그룹화 해야함
		buttonGroup.add(rdoMinus);
		buttonGroup.add(rdoMul);
		buttonGroup.add(rdoDiv);
		JPanel panel3 = new JPanel();
		panel3.add(rdoPlus);
		panel3.add(rdoMinus);
		panel3.add(rdoMul);
		panel3.add(rdoDiv);
		add(panel3);
		// 4행
		JLabel lbl4 = new JLabel("결과 : "); 
		JPanel panel4 = new JPanel();
		panel4.add(lbl4);
		panel4.add(lblResult);
		add(panel4);
		
		// 5행
		JButton btnCal = new JButton("계산"); // 계산 버튼 추가
		JButton btnReset = new JButton("초기화"); // 초기화 버튼 추가
		JButton btnFin = new JButton("종료"); // 종료 버튼 추가
		btnCal.addActionListener(this);
		btnReset.addActionListener(this);
		btnFin.addActionListener(this);
		JPanel panel5 = new JPanel();
		panel5.add(btnCal);
		panel5.add(btnReset);
		panel5.add(btnFin);
		add(panel5);
	
	}
    private void calculate(){
    	 if (rdoPlus isSelected()) {
    		 Result = num1 + num2;
    		 
    		 
         } else if (subtractRadioButton.isSelected()) {
             result = num1 - num2;
         } else if (multiplyRadioButton.isSelected()) {
             result = num1 * num2;
         } else if (divideRadioButton.isSelected()) {
             if (num2 != 0) {
                 result = num1 / num2;
             } 
	};
	private void reset() {
		
	};
	private void finish() {
		
	};
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	
		
		
		
		
	    if (e.getSource() == btnCal) {
            calculate();
        } 
	    if (e.getSource() == btnReset) {
            reset();
        }
	    if (e.getSource() == btnFin) {
            finish();
        }
    
	}
	
	public static void main(String[] args) {
		new Ex48Calculator();
	}
}
*/