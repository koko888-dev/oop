package Lab8_3;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class JavaGUI{
	
	public static void main(String[] args){
		 JFrame frame = new JFrame("Test");
		 frame.setSize(250,300);
		 frame.setVisible(true);
		 frame.setEnabled (true);
		 JButton jb = new JButton("click");
		 jb.setBounds(20, 50, 300, 50);
		 JPanel center = new JPanel();
		 JLabel jl = new JLabel("");
		 frame.add(jb);
		 center.add(jl);
		 frame.getContentPane().add(center, BorderLayout.CENTER);
		 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 jb.addActionListener(new ActionListener(){
			 int i = 1;
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	if(e.getSource() == jb) {
	            		jl.setText(i+"");
	            		System.out.println(i);
	            		i++;
	            	}
	            }
	        });
		 
	}


}


