import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class Sms extends JFrame
{
	Container c;
	JButton btnAdd,btnView,btnUpdate,btnDelete,btnCharts;
	Sms(){
		c = getContentPane();
		c.setLayout(new FlowLayout());

		btnAdd = new JButton("Add");
		btnView = new JButton("View");
		btnUpdate = new JButton("Update");
		btnDelete = new JButton("Delete");
		btnCharts = new JButton("Charts");
		
		c.add(btnAdd);
		c.add(btnView);
		c.add(btnUpdate);
		c.add(btnDelete);
		c.add(btnCharts);

		ActionListener a1 = (ae) -> {
			AddDetail ad = new AddDetail();	
			dispose();
		};
		btnAdd.addActionListener(a1);

		ActionListener a2 = (ae) -> {
			ViewDetail vd = new ViewDetail();
			dispose();	
		};
		btnView.addActionListener(a2);

		ActionListener a3 = (ae) -> {
			UpdateDetail ud = new UpdateDetail();	
			dispose();
		};
		btnUpdate.addActionListener(a3);

		ActionListener a4 = (ae) -> {
			DeleteDetail ad = new DeleteDetail();	
			dispose();
		};
		btnDelete.addActionListener(a4);

		setVisible(true);
		setSize(200,200);
		setTitle("S.M.S");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
}

public class Test
{
	public static void main(String args[])
	{
		Sms s = new Sms();
	}
}