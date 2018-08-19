import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class calculator extends JFrame implements ActionListener{
	
	private JTextArea text;
	
	private JButton b2;
	private JButton b3;
	private JButton b4;
	private JButton b6;
	private JButton b7;
	private JButton b8;
	private JButton b10;
	private JButton b11;
	private JButton b12;
	private JButton b14;
	private JButton b5;
	private JButton b16;
	private JButton b17;
	private JButton b1;
	private JButton b9;
	private JButton b13;
	private JButton b15;
	
	int firstNum;
	boolean dvid;
	boolean plus;
	boolean multiplication;
	boolean minus;
	
	
	
	public calculator() { //계산기 Frame
		setTitle("계산기"); //계산기의 Frame의 이름
		setSize(250,300); //계산기의 Frame의 크키
		
		
		FlowLayout flow = new FlowLayout(FlowLayout.LEFT, 5, 5); //flow라는 이름의 flowlayout속성을 부여
		setLayout(flow); //flow라는 레이아웃을 frame에 설정
		
		Panel p1 = new Panel(); //p1라는 이름의 패널한개 생성
	
		Panel p2 = new Panel(); //p2라는 이름의 패널 한개 생성
		
		Panel p3 = new Panel(); //p3라는 이름의 패널 한개 생성
		
		text = new JTextArea(1,20);
		p1.add(text);
		
		b1 = new JButton("C"); //b1이라는 이름의 JButton에 속성 string타입의 "C"
		p2.add(b1); //b1(버튼)을 p2(패널)에 추가
		
		
		
		p3.setLayout(new GridLayout(4,0,5,5)); //p3레이아웃을 gridlayout으로 설정
		b2 = new JButton("7"); //버튼 16개 생성
		b3 = new JButton("8");
		b4 = new JButton("9");
		b5 = new JButton("/");
		b6 = new JButton("4");
		b7 = new JButton("5");
		b8 = new JButton("6");
		b9 = new JButton("*");
		b10 = new JButton("1");
		b11 = new JButton("2");
		b12 = new JButton("3");
		b13 = new JButton("-");
		b14 = new JButton("0");
		b15 = new JButton("+/-"); //미구현 사용법x
		b16 = new JButton("=");
		b17 = new JButton("+");
		
		p3.add(b2); //16개의 버튼 p3패널에 추가
		p3.add(b3);
		p3.add(b4);
		p3.add(b5);
		p3.add(b6);
		p3.add(b7);
		p3.add(b8);
		p3.add(b9);
		p3.add(b10);
		p3.add(b11);
		p3.add(b12);
		p3.add(b13);
		p3.add(b14);
		p3.add(b15);
		p3.add(b16);
		p3.add(b17);
		
		add(p1); // Frame에 각가의 패널 p1,p2,p3를 추가합니다.
		add(p2);
		add(p3);
		
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		b8.addActionListener(this);
		b10.addActionListener(this);
		b11.addActionListener(this);
		b12.addActionListener(this);
		b14.addActionListener(this);
		b5.addActionListener(this);
		b16.addActionListener(this);
		b17.addActionListener(this);
		b1.addActionListener(this);
		b9.addActionListener(this);
		b13.addActionListener(this);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == b10) {
			text.append("1");	
		}
		else if (e.getSource() == b11) {
			text.append("2");
		}
		else if (e.getSource() == b12) {
			text.append("3");
		}
		else if (e.getSource() == b14) {
			text.append("0");
		}
		else if (e.getSource() == b6) {
			text.append("4");
		}
		else if (e.getSource() == b7) {
			text.append("5");
		}
		else if (e.getSource() == b8) {
			text.append("6");
		}
		else if (e.getSource() == b2) {
			text.append("7");
		}
		else if (e.getSource() == b3) {
			text.append("8");
		}
		else if (e.getSource() == b4) {
			text.append("9");
		}
		else if (e.getSource() == b5) {   //처음으로 이벤트가 발생하는게 나누기라면 
			String firstNumStr = text.getText();
			firstNum = Integer.parseInt(firstNumStr);
			text.setText("");
			dvid = true;
		}
		else if (e.getSource() == b17) { // +
			String firstNumStr = text.getText();
			firstNum = Integer.parseInt(firstNumStr);
			text.setText("");
			plus = true;
		}
		else if(e.getSource() == b1) {
			firstNum = 0;
			text.setText("");
		}
		else if(e.getSource() == b9) { // *
			String firstNumStr = text.getText();
			firstNum = 0;
			text.setText("");
			multiplication = true;
		}
		else if(e.getSource() == b13) {
			String firstNumStr = text.getText();
			firstNum = 0;
			text.setText("");
			minus = true;
		}
		else if (e.getSource() == b16) {  //b16은 =이다.
			String lastNumStr = text.getText();
			int lastNum = Integer.parseInt(lastNumStr); 
		    if(dvid) {
					double resultDouble =  (double)(firstNum / lastNum);
					String result = Double.toString(resultDouble);
					text.setText(result);
					dvid = false; // false를 적용해서 다시 dvid가 쓰이지 않게 해준다
		    }
			else if(plus) {
				double resultDouble = (double)(firstNum + lastNum);
				String result = Double.toString(resultDouble);
				text.setText(result);
				plus = false;
			}
			else if(multiplication) {
				double resultDouble = (double)(firstNum * lastNum);
				String result = Double.toString(resultDouble);
				text.setText(result);
				multiplication = false;
			}
			else if(minus) {
				double resultDouble = (double)(firstNum - lastNum);
				String result = Double.toString(resultDouble);
				text.setText(result);
				minus = false;
			}
			
		}
		
	}

}
