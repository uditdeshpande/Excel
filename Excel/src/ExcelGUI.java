import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class ExcelGUI extends JFrame implements ActionListener{

	JPanel root,north,east,south,tabr,imgr,tabt,tabb;
	JButton browse,accept,generate,submit,invaxis,about,help,save_chart,clear,addrow,addcol,cleardata,delrow,creategraph,temp,refresh;
	JTextField filein;
	JLabel file,status,tmp;
	JComboBox graphtype,xaxis,yaxis;
	JTable table;
	String[] graph=new String[] {"Stack Chart","Pie Chart","Bar Chart","Line Chart"};
	JScrollPane pane;
	DefaultTableModel tm;
	DefaultComboBoxModel xme=new DefaultComboBoxModel();
	DefaultComboBoxModel yme=new DefaultComboBoxModel();
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
		//init
		
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
		
		filein=new JTextField();
		file=new JLabel("Please choose the excel file");
		browse=new JButton("Browse");
		accept=new JButton("Submit");
		xaxis=new JComboBox(xme);
		yaxis=new JComboBox(yme);
		refresh=new JButton("      Refresh    ");
		invaxis=new JButton("  Invert Axis   ");
		about=new JButton("    About Us    ");
		help=new JButton("         Help        ");
		save_chart=new JButton("  Save Chart  ");
		clear=new JButton("Clear Screen");
		String[] head={"Details","Column 1","Column2"};
		Object[][] data= {{"A",1,2},{"B",3,4},{"C",5,6}};
		tm=new DefaultTableModel(data,head);
		table=new JTable(tm);
		pane=new JScrollPane(table);
		addrow=new JButton("Add ROW");
		addcol=new JButton("Add COL");
		cleardata=new JButton("Clear Data");
		delrow=new JButton("Delete Row");
		creategraph=new JButton("Create Graph");
		status=new JLabel("");
		graphtype=new JComboBox(graph);
		
		
		this.add(north, BorderLayout.NORTH);
		this.add(root,BorderLayout.CENTER);
		this.add(east,BorderLayout.EAST);
		this.add(south,BorderLayout.SOUTH);
		//NORTH PANEL UI COMPONENTS
		
		//this.add(north);
		filein.setColumns(50);
		north.add(file);
		north.add(filein);
		north.add(browse);
		north.add(graphtype);
		refreshlogic();
		north.add(new JLabel("X-Axis"));
		north.add(xaxis);
		north.add(new JLabel("Y-Axis"));
		north.add(yaxis);
		north.add(accept);
		north.add(status);
		
		
		//WEST COMPONENTS ADD
		east.add(refresh);
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
		tabt.add(pane);
		tabb.add(addrow);
		tabb.add(addcol);
		tabb.add(cleardata);
		tabb.add(delrow);
		tabb.add(creategraph);
		//actual logic
		
	//	temp=new JButton("Temp");
	//	imgr.add(temp);
	//	tmp=new JLabel("Tmp");
	//	imgr.add(tmp);
		
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
		creategraph.addActionListener(this);
		refresh.addActionListener(this);
	//	temp.addActionListener(this);
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
			
		}
		else if(e.getSource()==addcol)
		{
			tm.addColumn("Column"+tm.getColumnCount());
			refreshlogic();
		}
		else if(e.getSource()==cleardata)
		{
			tm.setRowCount(0);
			
		}
		else if(e.getSource()==delrow)
		{
			tm.removeRow(table.getSelectedRow());
		}
		else if(e.getSource()==creategraph)
		{
			
		}
		else if(e.getSource()==refresh)
		{
			refreshlogic();
				
		}
		
		
		
	}

	void createBarChart()
	{
		
	}
	
	void createPieChart()
	{
		
	}
	
	void createLineChart()
	{
		
	}
	
	void createStackChart()
	{
		
	}
	
	void refreshlogic()
	{
		
		xme.removeAllElements();yme.removeAllElements();
		for(int i=1;i<table.getColumnCount();i++)
			{xme.addElement(i);
			yme.addElement(i);
		
	}
	}
	
}
