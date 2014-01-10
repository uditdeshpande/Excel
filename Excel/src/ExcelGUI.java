import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class ExcelGUI extends JFrame implements ActionListener{

	JPanel root,north,west;
	JButton browse,accept,generate;
	JTextField filein;
	JLabel file;
	public ExcelGUI()
	{
	setupUI();
	addListener();
	this.setLayout(new FlowLayout(FlowLayout.LEFT));
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
		this.add(north);
		filein=new JTextField();
		filein.setColumns(50);
		file=new JLabel("Please choose the excel file");
		north.add(file);
		browse=new JButton("Browse");
		north.add(filein);
		north.add(browse);
		accept=new JButton("Submit");
		north.add(accept);
		
		
	}

	void addListener()
	{
		accept.addActionListener(this);
		browse.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource()==browse)
		{
		JFileChooser fc=new JFileChooser();
		fc.showOpenDialog(this);
		
		}
	}
}
