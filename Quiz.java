import java.awt.event.*;
import javax.swing.*;
public class Quiz extends JFrame implements ActionListener{
	JLabel jlable;
	JRadioButton jradiobutton[]=new JRadioButton[5];
	JButton button1,button2;
	ButtonGroup buttongroup;
	int count=0,currques=0;
	int arr[]=new int[5];	
	Quiz(String str){
		super(str);
		jlable=new JLabel();
		add(jlable);
		buttongroup=new ButtonGroup();
		for(int i=0;i<5;i++){
			jradiobutton[i]=new JRadioButton();	
			add(jradiobutton[i]);
			buttongroup.add(jradiobutton[i]);
		}
		button1=new JButton("Next");
		button2=new JButton("Submit");
		button1.addActionListener(this);
		button2.addActionListener(this);
		add(button1);add(button2);
		set();
		jlable.setBounds(30,40,450,20);
		jradiobutton[0].setBounds(50,100,100,20);
		jradiobutton[1].setBounds(50,125,100,20);
		jradiobutton[2].setBounds(50,150,100,20);
		jradiobutton[3].setBounds(50,175,100,20);
		button1.setBounds(120,250,75,25);
		button2.setBounds(300,250,75,25);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setVisible(true);
		setSize(600,400);
	}
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==button1){
			if(check())
				count=count+1;
			currques++;
			set();	
			if(currques==5){
				button1.setEnabled(false);
				button2.setText("Result");
			}
		}
		if(e.getActionCommand().equals("Result")){
			if(check())
				count=count+1;
			currques++;
			JOptionPane.showMessageDialog(this,"Correct answers: "+count);
			System.exit(0);
		}
	}
	public void set(){
		jradiobutton[4].setSelected(true);
		if(currques==0)
		{
			jlable.setText("Which of the following option leads to the portability and security of Java?");
			jradiobutton[0].setText("Bytecode is executed by JVM");
			jradiobutton[1].setText("The applet makes the Java code secure and portable");
			jradiobutton[2].setText("Use of exception handling");
			jradiobutton[3].setText("Dynamic binding between objects");
		}
		if(currques==1) {
			jlable.setText("Which of the following is not a Java features?");
			jradiobutton[0].setText("Dynamic");
			jradiobutton[1].setText("Architecture Neutral");
			jradiobutton[2].setText("Use of pointers");
			jradiobutton[3].setText("Object-oriented");
			
		}
		if(currques==2) {
			jlable.setText("The \\u0021 article referred to as a");
			jradiobutton[0].setText("Unicode escape sequence");
			jradiobutton[1].setText("Octal escape");
			jradiobutton[2].setText("Hexadecimal");
			jradiobutton[3].setText("Line feed");
		}
		if(currques==3) {
			jlable.setText(" _____ is used to find and fix bugs in the Java programs.");
			jradiobutton[0].setText("JVM");
			jradiobutton[1].setText("JRE");
			jradiobutton[2].setText("JDK");
			jradiobutton[3].setText("JDB");
		}
		if(currques==4) {
			jlable.setText("Which of the following is a valid declaration of a char?");
			jradiobutton[0].setText("char ch = '\\utea';");
			jradiobutton[1].setText("char ca = 'tea';");
			jradiobutton[2].setText("char cr = \\u0223;");
			jradiobutton[3].setText("char cc = '\\itea';");
		}
		jlable.setBounds(30,40,450,20);
		for(int i=0,j=0;i<=90;i+=30,j++)
			jradiobutton[j].setBounds(50,80+i,200,20);
	}
	boolean check(){
		if(currques==0)
			return(jradiobutton[0].isSelected());
		if(currques==1)
			return(jradiobutton[2].isSelected());
		if(currques==2)
			return(jradiobutton[0].isSelected());
		if(currques==3)
			return(jradiobutton[3].isSelected());
		if(currques==4)
			return(jradiobutton[0].isSelected());
		return false;
	}
	public static void main(String args[]){
		new Quiz("Java Test");
	}
}
