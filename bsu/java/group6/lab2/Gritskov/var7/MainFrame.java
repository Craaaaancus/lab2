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
	
	private void addRadioButton(String buttonName, final int formulaId) {
		JRadioButton button = new JRadioButton(buttonName);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				MainFrame.this.formulaId = formulaId;
				
			}
		});
		
		radioButtons.add(button);
		hboxFormulaType.add(button);
	}
	
	public MainFrame() {
		super("Calculating formula");
		setSize(WIDTH, HEIGHT);
		Toolkit kit = Toolkit.getDefaultToolkit();
		setLocation((kit.getScreenSize().width - WIDTH)/2, (kit.getScreenSize().height - HEIGHT)/2);
		hboxFormulaType.add(Box.createHorizontalGlue());
		addRadioButton("Formula 1", 1);
		addRadioButton("Formula 2", 2);
		radioButtons.setSelected(radioButtons.getElements().nextElement().getModel(), true);
		hboxFormulaType.add(Box.createHorizontalGlue());
		hboxFormulaType.setBorder(BorderFactory.createLineBorder(Color.YELLOW));
		
		JLabel labelForX = new JLabel("X:");
		textFieldX = new JTextField("0", 10);
		textFieldX.setMaximumSize(textFieldX.getPreferredSize());
		
		JLabel labelForY = new JLabel("Y:");
		textFieldY = new JTextField("0", 10);
		textFieldY.setMaximumSize(textFieldY.getPreferredSize());
		
		JLabel labelForZ = new JLabel("Z:");
		textFieldZ = new JTextField("0", 10);
		textFieldZ.setMaximumSize(textFieldZ.getPreferredSize());
		
		
		Box hboxVariables = Box.createHorizontalBox();
		hboxVariables.setBorder(BorderFactory.createLineBorder(Color.RED));
		
		hboxVariables.add(labelForX);
		hboxVariables.add(Box.createHorizontalStrut(10));
		hboxVariables.add(textFieldX);
		hboxVariables.add(Box.createHorizontalGlue());
		
		hboxVariables.add(labelForY);
		hboxVariables.add(Box.createHorizontalStrut(10));
		hboxVariables.add(textFieldY);
		hboxVariables.add(Box.createHorizontalGlue());
		
		hboxVariables.add(labelForZ);
		hboxVariables.add(Box.createHorizontalStrut(10));
		hboxVariables.add(textFieldZ);
		JLabel labelForResult = new JLabel("Result:");
		textFieldResult = new JTextField("0", 10);
		JLabel labelForSum = new JLabel("Sum:");
		textFieldSum = new JTextField("0", 10);
		Box hboxResult = Box.createHorizontalBox();
		hboxResult.add(Box.createHorizontalGlue());
		hboxResult.add(Box.createHorizontalStrut(30));
		hboxResult.add(labelForResult);
		hboxResult.add(Box.createHorizontalStrut(10));
		hboxResult.add(textFieldResult);
		hboxResult.add(Box.createHorizontalStrut(20));
		hboxResult.add(labelForSum);
		hboxResult.add(Box.createHorizontalStrut(10));
		hboxResult.add(textFieldSum);
		hboxResult.add(Box.createHorizontalStrut(30));
		hboxResult.add(Box.createHorizontalGlue());
		hboxResult.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		
		JButton buttonCalc = new JButton("Calculate");
		buttonCalc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				try {
						Double x = Double.parseDouble(textFieldX.getText());
						Double y = Double.parseDouble(textFieldY.getText());
						Double z = Double.parseDouble(textFieldZ.getText());
						
						
						if (formulaId==1) {
							result = calculate1(x, y, z);
						}
						else {
							result = calculate2(x, y, z);
						}
						textFieldResult.setText(result.toString());
			        }
				catch (NumberFormatException ex){
					JOptionPane.showMessageDialog(MainFrame.this, "Ошибка в формате записи числа с плавающей точкой", "Ошибочный формат числа", 
							JOptionPane.WARNING_MESSAGE);
					
				}
			}
		});
		
		JButton buttonReset = new JButton("Reset");
		buttonReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
			textFieldX.setText("0");
			textFieldY.setText("0");
			textFieldZ.setText("0");
			textFieldResult.setText("0");
			}
		});
		
		Box hboxButtons = Box.createHorizontalBox();
		hboxButtons.add(Box.createHorizontalGlue());
		hboxButtons.add(buttonCalc);
		hboxButtons.add(Box.createHorizontalStrut(30));
		hboxButtons.add(buttonReset);
		hboxButtons.add(Box.createHorizontalGlue());
		hboxButtons.setBorder(BorderFactory.createLineBorder(Color.GREEN));
		
		Box contentBox = Box.createVerticalBox();
		contentBox.add(Box.createVerticalGlue());
		contentBox.add(Box.createVerticalStrut(30));
		contentBox.add(hboxVariables);
		contentBox.add(Box.createVerticalStrut(100));
		contentBox.add(hboxResult);
		contentBox.add(Box.createVerticalStrut(100));
		contentBox.add(hboxSumButtons);
		contentBox.add(Box.createVerticalStrut(30));
		contentBox.add(hboxButtons);
		contentBox.add(Box.createVerticalStrut(30));
		contentBox.add(hboxFormulaType);
		contentBox.add(Box.createVerticalStrut(30));
		contentBox.add(Box.createVerticalGlue());
		getContentPane().add(contentBox, BorderLayout.CENTER);
	}
	
	public static void main(String[] args) {
		MainFrame frame = new MainFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}

}
