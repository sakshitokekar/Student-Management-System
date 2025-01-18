import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class UpdateDetail extends JFrame
{
	Container c;
	JLabel lblRno,lblName,lblM1,lblM2,lblM3;
	JTextField txtRno,txtName,txtM1,txtM2,txtM3;
	JButton btnSave,btnBack;
	UpdateDetail(){
		c = getContentPane();
		c.setLayout(new FlowLayout());

		btnSave = new JButton("Save");
		btnBack = new JButton("Back");
		
		lblRno = new JLabel("Enter rno:");
		lblName = new JLabel("Enter name:");
		lblM1 = new JLabel("Enter sub marks 1:");
		lblM2 = new JLabel("Enter sub marks 2:");
		lblM3 = new JLabel("Enter sub marks 3:");			
		txtRno = new JTextField(20);
		txtName = new JTextField(20);
		txtM1 = new JTextField(20);
		txtM2 = new JTextField(20);
		txtM3 = new JTextField(20);			
		
		c.add(lblRno);
		c.add(txtRno);
		c.add(lblName);
		c.add(txtName);
		c.add(lblM1);
		c.add(txtM1);
		c.add(lblM2);
		c.add(txtM2);
		c.add(lblM3);
		c.add(txtM3);
		c.add(btnSave);
		c.add(btnBack);
		
		ActionListener a1 = (ae) -> {
			Sms a = new Sms();
			dispose();
		};
		btnBack.addActionListener(a1);
	
		setVisible(true);
		setSize(300,400);
		setTitle("Update St.");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
}

public class Test2{
public static void main(String args[])
{
	UpdateDetail s = new UpdateDetail();
}}