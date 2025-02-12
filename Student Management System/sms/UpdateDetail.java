import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import org.hibernate.*;
import org.hibernate.cfg.*;
import java.io.*;
import java.util.*;

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
			int rno = Integer.parseInt( txtRno.getText());
			String name = txtName.getText();
			int m1 = Integer.parseInt( txtM1.getText());
			int m2 = Integer.parseInt( txtM2.getText());
			int m3 = Integer.parseInt( txtM3.getText());
		
		/*********************Connection Part***********************/
			Configuration cfg = new Configuration();
			cfg.configure("hibernate.cfg.xml");

			SessionFactory sfact = cfg.buildSessionFactory();
			Session s = null;

			Transaction t = null;

			try{
				s = sfact.openSession();
				t = s.beginTransaction();
				StudentProject stu = new StudentProject();
				stu.setName(name);
        			stu.setRno(rno);
				stu.setM1(m1);
        			stu.setM2(m2);
        			stu.setM3(m3);
      				s.update(stu);
       				t.commit();

				String msg = "Record Updated";
				JOptionPane.showMessageDialog(c,msg);
			}
			catch(Exception e)
			{
				t.rollback();
				String msg = "Issue: " + e;
				JOptionPane.showMessageDialog(c,msg);	
			}
			finally{
				s.close();
				String msg = "Disconnected";
				JOptionPane.showMessageDialog(c,msg);	
			}
		/*********************Connection Part Ended***********************/
		};
		btnSave.addActionListener(a1);

		ActionListener a2 = (ae) -> {
			Sms a = new Sms();
			dispose();
		};
		btnBack.addActionListener(a2);
	
		setVisible(true);
		setSize(300,400);
		setTitle("Update St.");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
}
