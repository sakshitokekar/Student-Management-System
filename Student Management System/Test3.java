import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class DeleteDetail extends JFrame
{
	Container c;
	JLabel lblRno;
	JTextField txtRno;
	JButton btnSave,btnBack;

	DeleteDetail(){
		c = getContentPane();
		c.setLayout(new FlowLayout());

		btnSave = new JButton("Save");
		btnBack = new JButton("Back");
		
		lblRno = new JLabel("Enter rno:");	
		txtRno = new JTextField(20);			
		
		c.add(lblRno);
		c.add(txtRno);
		
		c.add(btnSave);
		c.add(btnBack);
		
		ActionListener a1 = (ae) -> {
			Sms a = new Sms();
			dispose();
		};
		btnBack.addActionListener(a1);
	
		ActionListener a2 = (ae) -> {
			int rno = Integer.parseInt( txtRno.getText());
			DbHandler.deleteStudent(rno);
		};
		btnBack.addActionListener(a2);

		setVisible(true);
		setSize(300,400);
		setTitle("Delete St.");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
}

public class Test3{
public static void main(String args[])
{
	DeleteDetail s = new DeleteDetail();
}}