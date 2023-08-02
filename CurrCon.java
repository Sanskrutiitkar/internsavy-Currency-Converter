import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class C1 extends JFrame
{
Container c;
JLabel lblProj, lblp, lblFrom, lblTo, output;
JTextField txtAmount;
JComboBox choiceFrom, choiceTo;
JButton btnSubmit;

C1(){

String currency[]={"INR","USD","EUR"};
c = getContentPane();
c.setLayout(null);

lblProj = new JLabel("Welcome to Currency Converter!!" , JLabel.CENTER);
lblp = new JLabel("Enter Amount : " , JLabel.CENTER);
txtAmount = new JTextField(60);
lblFrom = new JLabel("Convert From : ");
choiceFrom = new JComboBox(currency);
lblTo = new JLabel("Convert To : ");
choiceTo = new JComboBox(currency);
output = new JLabel("");

btnSubmit = new JButton("Convert");

Font f = new Font("Times New Roman",Font.BOLD,24);
lblProj.setFont(f);
lblp.setFont(f);
txtAmount.setFont(f);
lblFrom.setFont(f);
choiceFrom.setFont(f);
lblTo.setFont(f);
choiceTo.setFont(f);
btnSubmit.setFont(f);
output.setFont(f);

lblProj.setBounds(10,30,600,50);
lblp.setBounds(100,80,400,50);
txtAmount.setBounds(200,120,190,40);
lblFrom.setBounds(40,200,200,50);
choiceFrom.setBounds(350,200,180,35);
lblTo.setBounds(40,290,200,50);
choiceTo.setBounds(350,290,180,35);
btnSubmit.setBounds(220,400,150,35);
output.setBounds(190,480,600,50);

c.add(lblProj);
c.add(lblp);
c.add(txtAmount);
c.add(lblFrom);
c.add(choiceFrom);
c.add(lblTo);
c.add(choiceTo);
c.add(btnSubmit);
c.add(output);

ActionListener a1=(ae) -> {
try{
	if(txtAmount.getText().equals("")){
		throw new Exception("Please enter a amount");
	}	
	Double amount= Double.parseDouble(txtAmount.getText());
	Double total;
	if(amount<0){
		throw new Exception("Please enter a valid amount");	
	}
	switch (choiceFrom.getSelectedItem().toString()) {
		case "USD":
			switch (choiceTo.getSelectedItem().toString()) {
				case "INR":
					total=amount*82.743;
					output.setText(txtAmount.getText()+" USD = "+total+" INR");	
					break;
				case "EUR":	
					total=amount*0.943;
					output.setText(txtAmount.getText()+" USD = "+total+" EUR");
					break;
				default:
					total=amount*1;
					output.setText(txtAmount.getText()+" USD = "+total+" USD");
					break;
                }
                break;
	
		case "INR":
			switch (choiceTo.getSelectedItem().toString()) {
				case "USD":
					total=amount*0.0120;
					output.setText(txtAmount.getText()+" INR = "+total+" USD");	
					break;
				case "EUR":	
					total=amount*0.01139;
					output.setText(txtAmount.getText()+" INR = "+total+" EUR");
					break;
				default:
					total=amount*1;
					output.setText(txtAmount.getText()+" INR = "+total+" INR");
					break;
                }
                break;
	
		case "EUR":
                
			switch (choiceTo.getSelectedItem().toString()) {
				case "USD":
					total=amount*1.06057;
					output.setText(txtAmount.getText()+" EUR = "+total+" USD");	
					break;
				case "INR":	
					total=amount*87.74738;
					output.setText(txtAmount.getText()+" EUR = "+total+" INR");
					break;
				default:
					total=amount*1;
					output.setText(txtAmount.getText()+" EUR = "+total+" EUR");
					break;
                }
                break;
}
}
catch(NumberFormatException e){
	JOptionPane.showMessageDialog(c,"Enter numbers only");
	txtAmount.setText("");
	txtAmount.requestFocus();
}
catch(Exception e){
	JOptionPane.showMessageDialog(c,e.getMessage());
	txtAmount.setText("");
	txtAmount.requestFocus();
}
};
btnSubmit.addActionListener(a1);

setTitle("Currency Converter - InternSavy");
setSize(600,600);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
}
}

class CurrCon{
public static void main(String args[]){
C1 t = new C1();
}
}