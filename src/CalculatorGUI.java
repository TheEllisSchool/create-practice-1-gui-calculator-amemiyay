import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class CalculatorGUI extends JFrame {
	
	public JTextField in1;
	public JTextField in2;
	public JLabel answer;
	
	public CalculatorGUI() {
        initGUI();

        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Calculator");
        setSize(200, 200);
        setResizable(true);
        setLocationRelativeTo(null);
        
        
        pack();
    }

	private void initGUI() {
		
			
		JLabel titleLabel = new JLabel("Calculator");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        Font titleFont = new Font(Font.SERIF, Font.PLAIN, 32);
        titleLabel.setFont(titleFont);
        titleLabel.setOpaque(true);
        titleLabel.setBackground(Color.white);
        add(titleLabel, BorderLayout.PAGE_START);
        
        
        //number panel set-up
        JPanel numberInPanel = new JPanel();
        numberInPanel.setLayout(new GridLayout(2, 2));
        numberInPanel.setPreferredSize(new Dimension(250, 75));
        numberInPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        numberInPanel.setBackground(Color.white);
        add(numberInPanel, BorderLayout.LINE_START);
        
        JLabel num1 = new JLabel("First Number: ");
        numberInPanel.add(num1);
             
        in1 = new JTextField(10);
        numberInPanel.add(in1);
        
        JLabel num2 = new JLabel("Second Number: ");
        numberInPanel.add(num2);
        
        in2 = new JTextField(10);
        numberInPanel.add(in2);
        
        //set-up button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2, 2));
        buttonPanel.setPreferredSize(new Dimension (300, 50));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        buttonPanel.setBackground(Color.white);
        add(buttonPanel, BorderLayout.LINE_END);
        
        
        //average button set-up
        JButton averageBtn = new JButton("Average");
        averageBtn.setBackground(Color.black);
        averageBtn.setForeground(Color.white);
        averageBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                  calcAvg();
            }
        });
        buttonPanel.add(averageBtn);
        
        
        //factorial button set-up
        JButton factorialBtn = new JButton("Factorial");
        factorialBtn.setBackground(Color.black);
        factorialBtn.setForeground(Color.white);
        factorialBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                  calcFactorial();
            }
        });
        buttonPanel.add(factorialBtn);
        
        
        //higher number button set-up
        JButton higherBtn = new JButton("Higher");
        higherBtn.setBackground(Color.black);
        higherBtn.setForeground(Color.white);
        higherBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                  calcHigher();
            }
        });
        buttonPanel.add(higherBtn);
        
        
        
      //percent change button set-up
        JButton perChangeBtn = new JButton("Percent Change");
        perChangeBtn.setBackground(Color.black);
        perChangeBtn.setForeground(Color.white);
        perChangeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                  calcPerChange();
            }
        });
        buttonPanel.add(perChangeBtn);
        
        
		
        answer = new JLabel();
        answer.setPreferredSize(new Dimension (500, 50));
        Font answerFont = new Font(Font.SERIF, Font.PLAIN, 20);
        answer.setFont(answerFont);
        answer.setOpaque(true);
        answer.setBackground(Color.white);
        add(answer, BorderLayout.PAGE_END);
        
       
        
	}

	private void calcHigher() {
		double x = Double.parseDouble(in1.getText());
		double y = Double.parseDouble(in2.getText());
		double higherNum;
		if (x > y) {
			higherNum = x;
		} else {
			higherNum = y;
		}
		
		answer.setText("Higher number is: " + higherNum);
		
	}

	private void calcPerChange() {
		double x = Double.parseDouble(in1.getText());
		double y = Double.parseDouble(in2.getText());
		
		double perChange = (x - y)/x * 100;
		if (perChange < 0) {
			perChange = perChange * -1;
		}
		
		answer.setText("Percent Change is: " + perChange);
		
	}

	private void calcFactorial() {
		double X = Double.parseDouble(in1.getText());
		int x = (int)X;
		double factorial = x;
		while (x > 1) {
			factorial = factorial*(x-1);
			x--;
		}
		
		answer.setText("Factorial is: " + factorial);

	}

	private void calcAvg() {
		double x = Double.parseDouble(in1.getText());
		double y = Double.parseDouble(in2.getText());
		
		double avg = (x + y)/2;
		
		answer.setText("Average is: " + avg);
		
		
		
	}

	public static void main(String[] args) {
		try {
            String className = UIManager.getCrossPlatformLookAndFeelClassName();
            UIManager.setLookAndFeel(className);
        } catch (Exception e) {
        }

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CalculatorGUI();
            }
        });

	}

}
