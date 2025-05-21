package electricity.billing.system;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.net.URI;

public class payment_bill extends JFrame implements ActionListener {
    JButton back, openPaytm;
    String meter;

    payment_bill(String meter) {
        this.meter = meter;
        setLayout(null);

        JLabel label = new JLabel("Click below to proceed to Paytm Payment:");
        label.setBounds(250, 100, 300, 30);
        add(label);

        openPaytm = new JButton("Go to Paytm");
        openPaytm.setBounds(300, 150, 150, 30);
        openPaytm.addActionListener(e -> {
            try {
                Desktop.getDesktop().browse(new URI("https://paytm.com/online-payments"));
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Unable to open Paytm!");
            }
        });
        add(openPaytm);

        back = new JButton("Back");
        back.setBounds(300, 200, 150, 30);
        back.addActionListener(this);
        add(back);

        setSize(800, 600);
        setLocation(400, 150);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new pay_bill(meter); // your original pay_bill class
    }

    public static void main(String[] args) {
        new payment_bill("12345");
    }
}
