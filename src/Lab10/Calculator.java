package Lab10;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Calculator extends JFrame implements ActionListener {

    private JButton button_1;
    private JButton button_2;
    private JButton button_3;
    private JButton button_4;
    private JButton button_5;
    private JButton button_6;
    private JButton button_7;
    private JButton button_8;
    private JButton button_9;
    private JButton button_0;
    private JLabel display;
    private JLabel resultDisplay;
    private JButton button_plus;
    private JButton button_minus;
    private JButton button_time;
    private JButton button_divide;
    private JButton button_c;
    private JButton button_ce;
    private JButton button_equal;
    double numDouble1=0,numDouble2=0;
    String numString1=" ",numString2=" ",input="0";
    String operator= " ";

    private StringBuilder currentInput = new StringBuilder();
	private JButton button_dot;

    public Calculator(String title) {
        setTitle(title);
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        

        display = new JLabel();
        display.setHorizontalAlignment(JLabel.RIGHT);
        display.setOpaque(true); 
        display.setBackground(java.awt.Color.WHITE);
        display.setText("0");
        display.setFont(new Font("Arial", Font.PLAIN, 40));

        resultDisplay = new JLabel();
        resultDisplay.setHorizontalAlignment(JLabel.RIGHT);
        resultDisplay.setOpaque(true); 
        resultDisplay.setBackground(java.awt.Color.WHITE);
        resultDisplay.setText(""); 

       
        display.setPreferredSize(new java.awt.Dimension(300, 60));
        resultDisplay.setPreferredSize(new java.awt.Dimension(300, 40));

        button_1 = new JButton("1");
        button_2 = new JButton("2");
        button_3 = new JButton("3");
        button_4 = new JButton("4");
        button_5 = new JButton("5");
        button_6 = new JButton("6");
        button_7 = new JButton("7");
        button_8 = new JButton("8");
        button_9 = new JButton("9");
        button_0 = new JButton("0");
        button_plus = new JButton("+");
        button_minus = new JButton("-");
        button_time = new JButton("x");
        button_divide = new JButton("/");
        button_c = new JButton("C");
        button_ce = new JButton("CE");
        button_equal = new JButton("=");
        button_dot = new JButton(".");

        button_1.addActionListener(this);
        button_2.addActionListener(this);
        button_3.addActionListener(this);
        button_4.addActionListener(this);
        button_5.addActionListener(this);
        button_6.addActionListener(this);
        button_7.addActionListener(this);
        button_8.addActionListener(this);
        button_9.addActionListener(this);
        button_0.addActionListener(this);
        button_plus.addActionListener(this);
        button_minus.addActionListener(this);
        button_time.addActionListener(this);
        button_divide.addActionListener(this);
        button_c.addActionListener(this);
        button_ce.addActionListener(this);
        button_equal.addActionListener(this);
        button_dot.addActionListener(this);

        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        gbc.weighty = 0.0; 
        gbc.insets = new Insets(5, 5, 0, 5);
        add(resultDisplay, gbc);

        
        gbc.gridy = 1; 
        gbc.gridwidth = 4; 
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(0, 5, 5, 5);
        add(display, gbc);
        
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridwidth = 1; 
        gbc.weightx = 0.0; 

        
        addButton(button_c, 0, 2, gbc);
        addButton(button_ce, 1, 2, gbc);
        addButton(button_divide, 2, 2, gbc);
        addButton(button_time, 3, 2, gbc);

        addButton(button_7, 0, 3, gbc);
        addButton(button_8, 1, 3, gbc);
        addButton(button_9, 2, 3, gbc);
        addButton(button_minus, 3, 3, gbc);

        addButton(button_4, 0, 4, gbc);
        addButton(button_5, 1, 4, gbc);
        addButton(button_6, 2, 4, gbc);
        addButton(button_plus, 3, 4, gbc);
        
        addButton(button_1, 0, 5, gbc);
        addButton(button_2, 1, 5, gbc);
        addButton(button_3, 2, 5, gbc);
        addButton(button_dot, 3, 5, gbc);
        
        

        gbc.gridwidth = 3; 
        gbc.gridx = 0;
        gbc.gridy = 6;
        add(button_0, gbc);

        gbc.gridwidth = 1;
        
        gbc.gridx = 3;
        gbc.gridy = 6;
        add(button_equal, gbc);
    }

    private void addButton(JButton button, int x, int y, GridBagConstraints gbc) {
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0; 
        gbc.weighty = 1.0; 
        add(button, gbc);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton source = (JButton) e.getSource();
        String buttonText = source.getText();
        

        if (buttonText.equals("CE")) {
            display.setText("0");
            input="0";
        }
        else if (buttonText.equals("C")) {
            display.setText("0");
            resultDisplay.setText(" ");
            input="0";
            numString1=" ";
            numString2=" ";
            operator=" ";
        }
        else if (buttonText.equals("+")||buttonText.equals("-")||buttonText.equals("x")||buttonText.equals("/")) {
        	
        	if(operator==" ") {
        	operator=buttonText;
            numString1=input;
            resultDisplay.setText(numString1 + " " + operator);
            input = " ";
        	}
        	else if(operator=="=") {
        	operator=buttonText;
            resultDisplay.setText(numString1 + " " + operator);
            input = " ";
        	}
        	else {
            	numString2 = input;
                String result = calculate(numString1, operator, numString2);
                
                display.setText(result);
                operator=buttonText;
                resultDisplay.setText(result + " " + operator);
                numString1=result;
                input = " ";
        		
        	}
            
            
        }
        else if (buttonText.equals("=")) {
        	numString2 = input;
        	
            resultDisplay.setText(numString1 + " " + operator + " " + numString2 + " " + buttonText);
            String result = calculate(numString1, operator, numString2);
            display.setText(result);
            operator=buttonText;
            numString1=result;
            
        }
        
        
        else {
           if(operator.equals("=")) {
               display.setText(buttonText);
               resultDisplay.setText("");
               input=buttonText;
               numString1=" ";
               numString2="";
               operator=" ";
           }
           else {
           if(input=="0") {
        	   input=buttonText;
        	   display.setText(input);
           }
           else {
           input+=buttonText;
           display.setText(input);
           }
           }
        
        }

    }
    private String calculate(String numString1, String operator, String numString2) {
        
        double number1 = Double.parseDouble(numString1);
        double number2 = Double.parseDouble(numString2);
        double result = 0;

        switch (operator) {
            case "+":
                result = number1 + number2;
                break;
            case "-":
                result = number1 - number2;
                break;
            case "x":
                result = number1 * number2;
                break;
            case "/":
                if (number2 != 0) {
                    result = number1 / number2;
                } else {
                    return "Cannot divide by zero";
                }
                break;
        }
        return String.valueOf(result);
    }


}

