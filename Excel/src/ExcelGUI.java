import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;


public class ExcelGUI extends JFrame implements ActionListener{

	JPanel root,north,east,south,tabr,imgr,tabt,tabb;
	JButton browse,accept,generate,submit,invaxis,about,help,save_chart,clear,addrow,addcol,cleardata,delrow,delcol;
	JTextField filein;
	JLabel file,status;
	JComboBox graphtype;
	JTable table;
	String[] graph=new String[] {"Stack Chart","Pie Chart","Bar Chart","Line Chart"};
	JScrollPane pane;
	DefaultTableModel tm;
	
	public ExcelGUI()
	{
		this.setLayout(new BorderLayout());
	setupUI();
	addListener();
	
	this.setExtendedState(JFrame.MAXIMIZED_BOTH);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setVisible(true);	

	}
	
	public static void main(String []args)
	{
		new ExcelGUI();
	}
	
	void setupUI()
	{
		
		north=new JPanel(new FlowLayout(FlowLayout.LEFT));
		root=new JPanel(new FlowLayout(FlowLayout.LEFT));
		tabr=new JPanel();imgr=new JPanel();
		tabr.setLayout(new BoxLayout(tabr,BoxLayout.Y_AXIS));
		tabt=new JPanel(new FlowLayout());tabb=new JPanel(new FlowLayout());
		tabr.add(tabt);tabr.add(tabb);
		root.add(tabr);root.add(imgr);
		south=new JPanel(new FlowLayout(FlowLayout.CENTER));
		east=new JPanel();
		east.setLayout(new BoxLayout(east,BoxLayout.Y_AXIS));
		
		
		this.add(north, BorderLayout.NORTH);
		this.add(root,BorderLayout.CENTER);
		this.add(east,BorderLayout.EAST);
		this.add(south,BorderLayout.SOUTH);
		//NORTH PANEL UI COMPONENTS
		
		//this.add(north);
		filein=new JTextField();
		filein.setColumns(50);
		file=new JLabel("Please choose the excel file");
		north.add(file);
		browse=new JButton("Browse");
		north.add(filein);
		north.add(browse);
		accept=new JButton("Submit");
		status=new JLabel("");
		graphtype=new JComboBox(graph);
		north.add(graphtype);
		north.add(accept);
		north.add(status);
		
		
		//WEST COMPONENTS ADD
		invaxis=new JButton("  Invert Axis   ");
		about=new JButton("    About Us    ");
		help=new JButton("         Help        ");
		save_chart=new JButton("  Save Chart  ");
		clear=new JButton("Clear Screen");
		east.add(invaxis);
		east.add(about);
		east.add(help);
		east.add(save_chart);
		east.add(clear);
		//SOUTH PANEL UI COMPONENTS
//		south.setBackground(Color.BLACK);
//		submit=new JButton("Submit");
//		south.add(submit);
//		
		String[] head={"Details","Column 1","Column2"};
		Object[][] data= {{"A",1,2},{"B",3,4},{"C",5,6}};
		tm=new DefaultTableModel(data,head);
		table=new JTable(tm);
		pane=new JScrollPane(table);
		tabt.add(pane);
		addrow=new JButton("Add ROW");
		addcol=new JButton("Add COL");
		cleardata=new JButton("Clear Data");
		delrow=new JButton("Delete Row");
		delcol=new JButton("Delete Column");
		tabb.add(addrow);
		tabb.add(addcol);
		tabb.add(cleardata);
		tabb.add(delrow);
		tabb.add(delcol);
		//actual logic
		
		
	}

	void addListener()
	{
		accept.addActionListener(this);
		browse.addActionListener(this);
		addrow.addActionListener(this);
		addcol.addActionListener(this);
		help.addActionListener(this);
		browse.addActionListener(this);
		cleardata.addActionListener(this);
		invaxis.addActionListener(this);
		save_chart.addActionListener(this);
		about.addActionListener(this);
		clear.addActionListener(this);
		delrow.addActionListener(this);
		delcol.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource()==browse)
		{
			if(!filein.getText().isEmpty())
			{
				status.setForeground(Color.GREEN);
				status.setText("File read successfully!");
			}
			else
			{
				status.setForeground(Color.RED);
				status.setText("File read failed!");
			}	
			
		
		}
		
		else if(e.getSource()==addrow)
		{
			Object []temp={"",null,null};
			tm.insertRow(table.getSelectedRow()+1,temp);
			tm.addRow(temp);
		}
		else if(e.getSource()==addcol)
		{
			tm.addColumn("Column"+tm.getColumnCount());
		}
		else if(e.getSource()==cleardata)
		{
			tm.setRowCount(0);
		}
		else if(e.getSource()==delrow)
		{
			tm.removeRow(table.getSelectedRow());
		}
		else if(e.getSource()==delcol)
		{
			
		}
	}
}
