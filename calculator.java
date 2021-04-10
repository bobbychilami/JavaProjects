import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class calculator extends JFrame implements ActionListener{
	
	JFrame j;
	JTextField mainBox;
	JButton a1,a2,a3,a4,a5,a6,a7,a8,a9,a0,plus,minus,mult,divide,equal,clear,dot;
	String firstNum = "",secondNum = "";
	String operands = "";
	Boolean pt1 = false;
	Boolean pt2 = false;
	calculator(){
		j = new JFrame("Calculator");
		
		mainBox = new JTextField();
		mainBox.setBounds(100,100,250,50);
		j.add(mainBox);
		
		a1 = new JButton("1");
		a1.setBounds(100,150,50,50);
		j.add(a1);
		
		a2 = new JButton("2");
		a2.setBounds(150,150,50,50);
		j.add(a2);
		
		a3 = new JButton("3");
		a3.setBounds(200,150,50,50);
		j.add(a3);
		
		a4 = new JButton("4");
		a4.setBounds(100,200,50,50);
		j.add(a4);
		
		
		a5 = new JButton("5");
		a5.setBounds(150,200,50,50);
		j.add(a5);
		
		a6 = new JButton("6");
		a6.setBounds(200,200,50,50);
		j.add(a6);
		
		a7 = new JButton("7");
		a7.setBounds(100,250,50,50);
		j.add(a7);
		
		a8 = new JButton("8");
		a8.setBounds(150,250,50,50);
		j.add(a8);
		
		a9 = new JButton("9");
		a9.setBounds(200,250,50,50);
		j.add(a9);
		
		a0 = new JButton("0");
		a0.setBounds(150,300,50,50);
		j.add(a0);
		
		dot = new JButton(".");
		dot.setBounds(200,300,50,50);
		j.add(dot);
		
		plus = new JButton("+");
		plus.setBounds(250,150,50,50);
		j.add(plus);
		
		minus = new JButton("-");
		minus.setBounds(300,150,50,50);
		j.add(minus);
		
		mult = new JButton("*");
		mult.setBounds(250,200,50,50);
		j.add(mult);
		
		divide = new JButton("/");
		divide.setBounds(300,200,50,50);
		j.add(divide);
		
		equal = new JButton("=");
		equal.setBounds(250,250,100,50);
		j.add(equal);
		
		clear = new JButton("C");
		clear.setBounds(250,300,100,50);
		j.add(clear);
		
		a1.addActionListener(this);
		a2.addActionListener(this);
		a3.addActionListener(this);
		a4.addActionListener(this);
		a5.addActionListener(this);
		a6.addActionListener(this);
		a7.addActionListener(this);
		a8.addActionListener(this);
		a9.addActionListener(this);
		a0.addActionListener(this);
		plus.addActionListener(this);
		minus.addActionListener(this);
		mult.addActionListener(this);
		divide.addActionListener(this);
		equal.addActionListener(this);
		clear.addActionListener(this);
		dot.addActionListener(this);
		
		j.setSize(700,700);
		j.setLayout(null);
		j.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		String b = e.getActionCommand();
		if(b.charAt(0) == '.' && pt1 == true && operands == "")
		{
			pt1 = false;
			pt2 = false;
			firstNum = "";
			secondNum = "";
			operands = "";
			mainBox.setText("Please Enter a valid number");
		}
		else if(b.charAt(0) == '.' && operands != "" && pt2 == true)
		{
			pt1 = false;
			pt2 = false;
			firstNum = "";
			secondNum = "";
			operands = "";
			mainBox.setText("Please Enter a valid number");
		}
		else if((b.charAt(0)>='0' && b.charAt(0)<='9' || b.charAt(0) == '.')&& operands == "")
		{
			if(b.charAt(0) == '.' )
				pt1 = true;
			firstNum += b.charAt(0);
			mainBox.setText(firstNum);
		}
		else if((b.charAt(0)>='0' && b.charAt(0)<='9' || b.charAt(0) == '.') && operands != "")
		{
			if(b.charAt(0) == '.' )
			{
				pt2 = true;
			}
			secondNum += b.charAt(0);
			mainBox.setText(firstNum+operands+secondNum);
		}
		else if(b.charAt(0) == '+')
		{
			operands += b.charAt(0);
			mainBox.setText(firstNum+operands);
		}
		else if(b.charAt(0) == '-')
			{
			operands += b.charAt(0);
			mainBox.setText(firstNum+operands);
		}
		else if(b.charAt(0) == '*')
		{
			operands += b.charAt(0);
			mainBox.setText(firstNum+operands);
		}	
		else if(b.charAt(0) == '/')
		{
			operands += b.charAt(0);
			mainBox.setText(firstNum+operands);
		}
		else if(b.charAt(0) == '=')
		{
			Double num1;
			if(operands.equals(""))
			num1 = Double.parseDouble(firstNum);
			else{
			if(operands.equals("+"))
			num1 = Double.parseDouble(firstNum)+Double.parseDouble(secondNum);
			else if(operands.equals("-"))
			num1 = Double.parseDouble(firstNum)-Double.parseDouble(secondNum);
			else if(operands.equals("*"))
			num1 = Double.parseDouble(firstNum)*Double.parseDouble(secondNum);
			else
			num1 = Double.parseDouble(firstNum)/Double.parseDouble(secondNum);
			}
			mainBox.setText(firstNum+operands+secondNum+"="+Double.toString(num1));
		}
		else
		{
			pt1 = false;
			pt2 = false;
			firstNum = "";
			secondNum = "";
			operands = "";
			mainBox.setText("");
			
		}
		
	}
	
	public static void main(String[] args){
		new calculator();
	}
}