import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import org.hibernate.*;
import org.hibernate.cfg.*;
import java.io.*;
import java.util.*;

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

		/*********************Connection Part***********************/		
			Configuration cfg = new Configuration();
			cfg.configure("hibernate.cfg.xml");

			SessionFactory sfact = cfg.buildSessionFactory();
			Session s = null;

			Transaction t = null;

			try{
				s = sfact.openSession();
				t = s.beginTransaction();


				StudentProject stu = (StudentProject)s.get(StudentProject.class,rno);
				if( stu!=null)
				{
					s.delete(stu);
					t.commit();
					String msg = "Deleted";
					JOptionPane.showMessageDialog(c,msg);	
				}
			}
			catch(Exception e)
			{
				t.rollback();
				String msg = "issue " + e;
				JOptionPane.showMessageDialog(c,msg);	
			}
			finally
			{
				s.close();
				String msg = "disconnected";
				JOptionPane.showMessageDialog(c,msg);	
			}
		/*********************Connection Part Ended***********************/		

		};
		btnSave.addActionListener(a2);

		setVisible(true);
		setSize(300,400);
		setTitle("Delete St.");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
}