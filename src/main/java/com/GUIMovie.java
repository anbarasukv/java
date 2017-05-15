package com;

import java.awt.event.ActionListener;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.FindMovies;

import conDB.connectUtil;

import java.sql.*;
import java.util.ArrayList;

public class GUIMovie extends JFrame implements ActionListener {
	JTextArea jl=new JTextArea(50,50);
	JTextField tf1=new JTextField(30);
	JTextField tf2=new JTextField(10);
	JTextField tf3=new JTextField(1);
	JLabel jt=new JLabel("REVATURE ENTERTAINMENT PARK");
	Connection con;

	public GUIMovie()
	{
	setTitle("Revature Movies Park");
	setSize(250,400);
	setLayout(new FlowLayout());
	add(jt);
	JButton fm=new JButton("LIST MOVIES");
	add(fm);
	JButton dm=new JButton("DELETE MOVIE");
	add(dm);
	add(tf1);add(tf2);add(tf3);
	JButton im=new JButton("INSERT MOVIE");
	add(im);
	setVisible(true);
	dm.addActionListener(this	);
	fm.addActionListener(this	);im.addActionListener(this	);
	}

	//@Override
	public void actionPerformed(ActionEvent e) {
		String s1=e.getActionCommand();
		
		//myString = editTextArea.getText();
    	//FindMovies.findAllMovies(con);
      
       // editTextArea.setText("");
		if(s1.equals("LIST MOVIES"))
		{
			//System.out.println(s1);
			
		//add(jl);
		con=connectUtil.connectDB();
		ArrayList<Movies> list=FindMovies.findAllMovies(con);	
		//System.out.println(list);
		for(Movies m:list)//split with space or separate class
			
		System.out.println(m.movie_name+"  "+m.release_date+"   "+m.is_active);
       jl.setText("movie_nakshdgfkhsdgfkhzbgfkhzfkzdme");
        jl.setVisible(true);
        try {
			con.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		}
		
		
		if(s1.equals("INSERT MOVIE"))
		{
			System.out.println(s1);
			
		//add(jl);
		con=connectUtil.connectDB();
		
		
		String m_name=tf1.getText();
		String relDate=tf2.getText();
		int isactive=Integer.parseInt(tf3.getText());
		//System.out.println(m_name+""+relDate+""+isactive);
		insertMovie.insertRec(m_name, relDate, isactive,con);
		//FindMovies.findAllMovies(con);	
		
		//for(Movies m:list)//split with space or separate class
			
		//System.out.println(m.movie_name+"  "+m.release_date+"   "+m.is_active);
       jl.setText("movie_nakshdgfkhsdgfkhzbgfkhzfkzdme");
        jl.setVisible(true);
        try {
			con.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		}
	}

	
}