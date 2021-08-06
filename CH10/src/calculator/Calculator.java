package calculator;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class Calculator extends JFrame{
	private JTextField resultText;
	private ArrayList<String> calculation = new ArrayList<String>();
	private String num="";
	private String prevOperation="";
	
	public Calculator() {
		Container contentPane = this.getContentPane();
		contentPane.setBackground(Color.LIGHT_GRAY); // (new Color(255,0,0))
		
		resultText = new JTextField();
		resultText.setBackground(Color.WHITE);
		resultText.setFont(new Font("맑은 고딕",Font.BOLD,40));
		resultText.setHorizontalAlignment(JTextField.RIGHT);
		resultText.setEditable(false);//수정 못하게
//		resultText.setPreferredSize(new Dimension(400,100));// 값을 지정해서 크기조정가능
		
		
		JPanel btnPanel = new JPanel();//컨테이너 역할을 한다.
		btnPanel.setLayout(new GridLayout(4,4,2,2));//4줄에 4칸 2,2
		
		contentPane.add(resultText, BorderLayout.NORTH);//크기 고정값임
		contentPane.add(btnPanel, BorderLayout.SOUTH);//크기 고정값임
		
		//버튼들을 한번에 제어하기 위한 배열을 하나 만듬...
		JButton btns[] = new JButton[16];
		String numberAndOperator[] = {"C","÷","×","=","7","8","9","+","4","5","6","-","1","2","3","0"};
		for(int i=0; i<16; i++) {
			btns[i] = new JButton(numberAndOperator[i]);
			btns[i].setPreferredSize(new Dimension(80,80));
			btns[i].setForeground(Color.WHITE);
			btns[i].setBorderPainted(false);
			btns[i].setFont(new Font("맑은 고딕", Font.BOLD,30));
			btns[i].addActionListener(new BtnActionListener());
			btnPanel.add(btns[i]);
			if (i==0) {
				btns[i].setBackground(Color.RED);
			}else if (i==1 | i==2 || i==3 || i==7|| i==11) {
				btns[i].setBackground(Color.GRAY);
			}else {
				btns[i].setBackground(Color.BLACK);
			}
		}
		this.setTitle("Calculator");
		this.setSize(400, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.pack();//자식들의 크기에 맞춰서 줄이거나 늘리기..(껴맞추기)
		
		
		
		this.setVisible(true);
	}
	class BtnActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton clickedBtn = (JButton)e.getSource();//이벤트가 발생된 오브젝트
			String operation = e.getActionCommand();
			
			if (operation.equals("C")) {
				resultText.setText("");
			}else if (operation.equals("=")) {
				String result = Double.toString(calculate(resultText.getText()));
				resultText.setText(result);
			}else if (operation.equals("+")||operation.equals("-")||operation.equals("×")||operation.equals("÷")){
				if(resultText.getText().equals("")&& operation.equals("-")) {
					resultText.setText(resultText.getText()+operation);
				}else if (!resultText.getText().equals("")&&!prevOperation.equals("+")&&!prevOperation.equals("-")&&!prevOperation.equals("×")&&!prevOperation.equals("÷")) {
					resultText.setText(resultText.getText()+operation);
				}
			}else {
				resultText.setText(resultText.getText()+operation);
			}
			prevOperation = operation;
//			System.out.println(operation);
//			System.out.println(clickedBtn.getText().trim());
		}
		
	}
	
	private void resultTextParsing(String tempText) {
		calculation.clear();
		for(int i=0; i<tempText.length(); i++) {
			char ch = tempText.charAt(i);
			if(ch=='÷' || ch=='×' || ch=='+'|| ch=='-') {
				calculation.add(num);
				num="";
				calculation.add(ch+"");
			}
			else {
				num+=ch;
			}
		}
		calculation.add(num);
		calculation.remove("");
		num="";
		System.out.println(calculation.toString());
	}
	
	private double calculate(String tempText) {
		String mode = "";
		double prevNum = 0;
		double currentNum = 0;
		resultTextParsing(resultText.getText());
		for(int i=0; i<calculation.size(); i++) {
			String str = calculation.get(i);
			if(str.equals("+")) {
				mode = "plus";
			}else if (str.equals("-")) {
				mode = "minus";
			}else if(str.equals("×")) {
				mode = "mul";
			}else if(str.equals("÷")) {
				mode = "div";
			}else {
				if((mode.equals("mul") || mode.equals("div"))&& !str.equals("+") && !str.equals("-") && !str.equals("×") && !str.equals("÷") ) {
					Double first = Double.parseDouble(calculation.get(i-2));
					Double second = Double.parseDouble(calculation.get(i));
					Double result = 0.0;
					if(mode.equals("mul")) {
						result = first*second;
					}else if (mode.equals("multiply")) {
						result = first/second;
					}
					System.out.println(result);
					calculation.add(i+1,Double.toString(result));
					for(int j=0; j<3; j++) {
						calculation.remove(i-2);
					}
					i-=2;
				}
			}
		}
		
		for(String str : calculation) {
			if(str.equals("+")) {
				mode = "plus";
			}else if (str.equals("-")) {
				mode = "minus";
			}else {
				currentNum = Double.parseDouble(str);
				if(mode.equals("plus")) {
					prevNum+=currentNum;
				}else if(mode.equals("minus")) {
					prevNum-=currentNum;
				}else {
					prevNum = currentNum;
				}
			}
		}
		System.out.println(prevNum);
		
		return prevNum;
	}
	
	public static void main(String[] args) {
		new Calculator();
	}
}
