import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.net.*;
import java.util.*;


public class tour implements ActionListener {
	protected JPanel container;//top level container
	
	protected JPanel inputArea;
	protected JTextField input1;
	protected JTextField input2;
	protected JLabel label1;
	protected JLabel label2;
	protected JButton button1;
	
	protected JPanel listArea;
	protected DefaultListModel listM;
	protected JList list;
	protected JLabel pickDes;
	protected JScrollPane scroll;
	protected JButton button2;
	
	protected JPanel displayArea;
	protected JTextPane display;
	protected JScrollPane result;
	protected JScrollPane scroll2;
	
	
	
	public tour(){
		container = new JPanel();
		container.setLayout(new BorderLayout());
		
		//code for inputArea-----------------------------------------
		inputArea = new JPanel();
		inputArea.setLayout(new BoxLayout(inputArea, BoxLayout.Y_AXIS));
		input1 = new JTextField();
		input2 = new JTextField();
		label1 = new JLabel("Please enter graph url here.");
		label2 = new JLabel("Please enter attraction url here.");
		button1 = new JButton("Show Destinations");
		button1.addActionListener(this);
		inputArea.add(label1);		
		inputArea.add(input1);
		inputArea.add(label2);
		inputArea.add(input2);
		inputArea.add(button1);
		//add inputArea to container
		container.add(inputArea, BorderLayout.PAGE_START);
		
		//code for checkbox area-------------------------------------
		listArea = new JPanel();
		listArea.setLayout(new BorderLayout());
		listM = new DefaultListModel();
		list = new JList(listM);
		list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		scroll = new JScrollPane(list);
		pickDes = new JLabel();//Should say pick destination from below after link enter'd
		button2 = new JButton("Get my schedule!");
		listArea.add(pickDes, BorderLayout.PAGE_START);
		listArea.add(scroll, BorderLayout.CENTER);
		listArea.add(button2,BorderLayout.PAGE_END);
		container.add(listArea, BorderLayout.CENTER);
		
		//code for result area--------------------------------------
		displayArea = new JPanel();
		displayArea.setLayout(new BorderLayout());
		display = new JTextPane();
		scroll2 = new JScrollPane(display);
		displayArea.add(scroll2, BorderLayout.CENTER);
		container.add(displayArea, BorderLayout.PAGE_END);
		
	}
	
	public void actionPerformed(ActionEvent ae){
		try{
		//----------------action event handler when "Enter" is clicked--------------
		if (ae.getSource() == button1){
			listM.clear();
			urlValidate url1v = new urlValidate(input1.getText());
			urlValidate url2v = new urlValidate(input2.getText());
			if(!url1v.isVal() || !url2v.isVal()){
				JOptionPane.showMessageDialog(null, "You've entered an invalid url, please try again.");
			}
			else{
				//first sanitize the 2 urls then extract destination strings from url2
				url1v.sanitize();
				url2v.sanitize();
					
				ArrayList<String> destinations = new ArrayList<String>();
				ArrayList<String> data = new ArrayList<String>();
				data = url2v.getData();
				//get the destination string from data and add to destinations
				for(int x = 1; x<data.size(); x++){
					 String delims = "\\t{1,}";
					if(x>=1){
					   String[] tokens = data.get(x).split(delims);
					   destinations.add(tokens[1]);
					}
					
				}
				//populate list with destination
				for(int x = 0; x<destinations.size(); x++){
					listM.addElement(destinations.get(x));
				}
				
				
			}
		}
		
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Error: Please sure the url you entered is valid and try again. " + e);
		}
	}
	
}
