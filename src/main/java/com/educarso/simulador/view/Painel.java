package com.educarso.simulador.view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Painel extends JPanel{
	private JFrame mainFrame;
	   private JLabel headerLabel;
	   private JLabel statusLabel;
	   private JPanel controlPanel;
	   private JLabel msglabel;

	   public Painel(){
	      prepareGUI();
	   }
	  
	   private void prepareGUI(){
	      mainFrame = new JFrame("Java Swing Examples");
	      mainFrame.setSize(400,400);
	      mainFrame.setLayout(new GridLayout(3, 1));
	      
	      mainFrame.addWindowListener(new WindowAdapter() {
	         public void windowClosing(WindowEvent windowEvent){
	            System.exit(0);
	         }        
	      });    
	      headerLabel = new JLabel("", JLabel.CENTER);        
	      statusLabel = new JLabel("",JLabel.CENTER);    
	      statusLabel.setSize(350,100);
	      msglabel = new JLabel("Welcome to TutorialsPoint SWING Tutorial.", JLabel.CENTER);
	      controlPanel = new JPanel();
	      controlPanel.setLayout(new FlowLayout());

	      mainFrame.add(headerLabel);
	      mainFrame.add(controlPanel);
	      mainFrame.add(statusLabel);
	      mainFrame.setVisible(true);  
	   }
	   public void showJPanelDemo(){
	      headerLabel.setText("Container in action: JPanel");      
	      JPanel panel = new JPanel();
	      panel.setBackground(Color.magenta);
	      panel.setLayout(new FlowLayout());        
	      panel.add(msglabel);
	      controlPanel.add(panel);        
	      mainFrame.setVisible(true);      
	   }   
}