import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import org.hibernate.*;
import org.hibernate.cfg.*;
import java.io.*;
import java.util.*;
import java.util.List;

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
		
		c.add(txtData);
		c.add(btnBack);
		
		ActionListener a1 = (ae) -> {
			Sms a = new Sms();
			dispose();
		};
		btnBack.addActionListener(a1);

		
		String data="";
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		SessionFactory sfact = cfg.buildSessionFactory();
		Session s = null;
		try
		{
			s = sfact.openSession();
			List<StudentProject> stu = new ArrayList<>();
			stu = s.createQuery("from StudentProject").list();
			for(StudentProject m : stu)
				data = data + "\t	" + m.getRno() + "\t||\t" + m.getName() + "\t||\t" + m.getM1() + "\t||\t" + m.getM2() + "\t||\t" + m.getM3() + "\n";
			txtData.setText(data);

		}
		catch(Exception e)
		{
			String msg = "Issue: " + e;
			JOptionPane.showMessageDialog(c,msg);	
		}
		finally
		{
			s.close();
		}

	
		setVisible(true);
		setSize(500,400);
		setTitle("View St.");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
}