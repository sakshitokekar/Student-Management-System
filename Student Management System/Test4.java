import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class ViewDetail extends JFrame
{
	Container c;
	TextArea txtData;
	JButton btnBack;
	ViewDetail(){
		c = getContentPane();
		c.setLayout(new FlowLayout());

		btnBack = new JButton("Back");
		txtData = new TextArea(20,60);			
		
		String data = DbHandler.viewStudent();
		txtData.setText(data);

		c.add(txtData);
		c.add(btnBack);
		
		ActionListener a1 = (ae) -> {
			Sms a = new Sms();
			dispose();
		};
		btnBack.addActionListener(a1);
	
		setVisible(true);
		setSize(500,400);
		setTitle("View St.");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
}

public class Test4{
public static void main(String args[])
{
	ViewDetail s = new ViewDetail();
}}