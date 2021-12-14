package bsu.java.group6.lab2.Gritskov.var7;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class MainFrame extends JFrame{

	private static final int WIDTH = 500;
	private static final int HEIGHT = 500;
	
	private JTextField textFieldX;
	private JTextField textFieldY;
	private JTextField textFieldZ;
	
	private JTextField textFieldResult;
	private JTextField textFieldSum;
	
	private ButtonGroup radioButtons = new ButtonGroup();
	
	private Box hboxFormulaType = Box.createHorizontalBox();
	
	private int formulaId = 1;
	private Double sum = 0.0;
	private Double result = 0.0;
	
	public Double calculate1(Double x, Double y, Double z) {
		double divisible = Math.sqrt(Math.sqrt(Math.log(Math.pow(1+z,2)) + Math.cos(Math.PI*Math.pow(y, 3))));
		double divisor = Math.pow(Math.cos(Math.pow(Math.E, x)) + Math.sqrt(1/x) + Math.pow(Math.E, Math.pow(x, 2)),Math.sin(x));
		return divisible / divisor;
	}
	
	public Double calculate2(Double x, Double y, Double z) {
		return Math.pow(Math.sin(Math.pow(z, y)),2) / Math.sqrt(1+Math.pow(x, 3));
	}
	
	
	
	public MainFrame() {
		
		
	}
	
	public static void main(String[] args) {
		MainFrame frame = new MainFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}

}
