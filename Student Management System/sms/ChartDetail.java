import javax.swing.*;
import org.jfree.data.category.*;
import org.jfree.chart.*;
import org.jfree.chart.plot.*;
import java.awt.*;
import java.awt.event.*;
import org.hibernate.*;
import org.hibernate.cfg.*;
import java.io.*;
import java.util.*;
import java.sql.*;
import java.util.List;

class ChartDetail extends JFrame
{

Container c;

ChartDetail(){
DefaultCategoryDataset ds = new DefaultCategoryDataset();

try{
Configuration cfg = new Configuration();
cfg.configure("hibernate.cfg.xml");
SessionFactory sfact = cfg.buildSessionFactory();
Session s = null;

s = sfact.openSession();
List<StudentProject> stu = new ArrayList<>();
stu = s.createQuery("from StudentProject").list();

for(StudentProject m : stu)
{
	String name = m.getName();
	int m1 = m.getM1();
	int m2 = m.getM2();
	int m3 = m.getM3();
	
	ds.addValue(m1,"Subject1",name);
	ds.addValue(m2,"Subject2",name);
	ds.addValue(m3,"Subject3",name);

}


JFreeChart ch = ChartFactory.createBarChart("Performance Review","Students","Marks",ds,PlotOrientation.VERTICAL,true,false,false);

ChartPanel pa = new ChartPanel(ch);

setContentPane(pa);

/*File bb = new File("bb.png");
ChartUtilities.saveChartAsPNG(bb,ch,500,500);*/

}
catch(Exception e){}

setSize(300,300);
setLocationRelativeTo(null);
setTitle("CHART");
setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
setVisible(true);
}
}