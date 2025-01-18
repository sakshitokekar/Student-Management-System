import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import org.hibernate.*;
import org.hibernate.cfg.*;
import java.io.*;
import java.util.*;

class AddDetail extends JFrame
{
	Container c;
	JLabel lblRno,lblName,lblM1,lblM2,lblM3;
	JTextField txtRno,txtName,txtM1,txtM2,txtM3;
	JButton btnSave,btnBack;

	AddDetail(){
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
		ActionListener a1 = (ae) ->
         {
			
		/*********************Connection Part***********************/
			Configuration cfg = new Configuration();
			cfg.configure("hibernate.cfg.xml");
			SessionFactory sfact = cfg.buildSessionFactory();
			Session s = null;	
			Transaction t = null;
	
			try
            {
				s = sfact.openSession();
				t = s.beginTransaction();
				int rno = Integer.parseInt( txtRno.getText());
				if(rno>0){
					String name = txtName.getText();
					if(name!=null && name.length()>2)
					{	
						int m1 = Integer.parseInt( txtM1.getText());
						int m2 = Integer.parseInt( txtM2.getText());
						int m3 = Integer.parseInt( txtM3.getText());
						if(m1>0 && m1<100 && m2>0 && m2<100 && m3>0 && m3<100){
							StudentProject stu = new StudentProject(rno,name,m1,m2,m3);
							s.save(stu);
							t.commit();
							String msg = "Record Saved";
							JOptionPane.showMessageDialog(c,msg);
						}
						else{
							JOptionPane.showMessageDialog(c,"Marks must be in the range 0-100");
							txtM1.setText("");
							txtM1.requestFocus();
							txtM2.setText("");
							txtM3.setText("");

						}
					}
					else{
						JOptionPane.showMessageDialog(c,"Name must be minimum 2 letters of alphabets");
						txtName.setText("");
						txtName.requestFocus();
					}
				}
				else{
					JOptionPane.showMessageDialog(c,"Roll number must be a positive integer");
					txtRno.setText("");
					txtRno.requestFocus();
				}

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
		setTitle("Add St.");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
	}