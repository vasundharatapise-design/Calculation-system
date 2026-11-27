import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleCalculator extends JFrame
        implements ActionListener {

    JTextField t1, t2;
    JButton add, sub, mul, div;
    JLabel result;

    SimpleCalculator() {
        setTitle("Simple Calculator");
        setSize(300, 300);
        setLayout(new FlowLayout());

        t1 = new JTextField(15);
        t2 = new JTextField(15);

        add = new JButton("+");
        sub = new JButton("-");
        mul = new JButton("*");
        div = new JButton("/");

        result = new JLabel("Result:");

        add(new JLabel("Enter First Number:"));
        add(t1);

        add(new JLabel("Enter Second Number:"));
        add(t2);

        add(add);
        add(sub);
        add(mul);
        add(div);

        add(result);

        add.addActionListener(this);
        sub.addActionListener(this);
        mul.addActionListener(this);
        div.addActionListener(this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            double a = Double.parseDouble(t1.getText());
            double b = Double.parseDouble(t2.getText());
            double ans = 0;

            if (e.getSource() == add)
                ans = a + b;
            else if (e.getSource() == sub)
                ans = a - b;
            else if (e.getSource() == mul)
                ans = a * b;
            else if (e.getSource() == div) {
                if (b == 0) {
                    result.setText("Cannot divide by zero");
                    return;
                }
                ans = a / b;
            }

            result.setText("Result: " + ans);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                    "Please enter valid numbers.");
        }
    }

    public static void main(String[] args) {
        new SimpleCalculator();
    }
}
