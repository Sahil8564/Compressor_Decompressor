package GUI;




import Comp_Decomp.Comp;
import Comp_Decomp.Decomp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class AppFrame extends JFrame implements ActionListener {
    JButton compressButton;
    JButton decompressButton;

    AppFrame(String name)
    {
        this.setTitle(name);

        Container c = this.getContentPane();
        c.setLayout(new BorderLayout());

        // panel for the heading inside the window
        JPanel headingPanel = getHeadingPanel();

        JPanel buttonPanel = new JPanel(); // Create a panel for the buttons
        buttonPanel.setBackground(Color.red); // Set background color
        buttonPanel.setPreferredSize(new Dimension(getWidth(),150)); // Set preferred size

        compressButton = new JButton("Select file to Compress");
        decompressButton = new JButton("Select file to Decompress");
        compressButton.setBackground(Color.white); // Set button background color
        decompressButton.setBackground(Color.white); // Set button background color
        compressButton.setForeground(Color.black); // Set button text color
        decompressButton.setForeground(Color.black); // Set button text color


        buttonPanel.add(compressButton);
        buttonPanel.add(decompressButton);

        c.add(headingPanel, BorderLayout.NORTH); // Add the heading panel to the top
        c.add(buttonPanel, BorderLayout.CENTER); // Add the button panel to the center

        compressButton.addActionListener(this);
        decompressButton.addActionListener(this);

        this.setSize(500, 300);
        this.setResizable(false);

        this.getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        this.getContentPane().setBackground(Color.black); // Set background color for the frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null); // Center the frame on the screen
        this.setVisible(true);


    }

    private JPanel getHeadingPanel()
    {
        JPanel headingPanel = new JPanel();
        headingPanel.setBackground(Color.BLACK); // Set background
        headingPanel.setPreferredSize(new Dimension(getWidth(),20));

        // label for the heading
        JLabel headingLabel = new JLabel("Compressor-Decompressor");
        headingLabel.setFont(new Font("Aerial" , Font.ITALIC, 20));
        headingLabel.setForeground(Color.white);
        // Set text color
        headingPanel.add(headingLabel); // Add the heading label to the heading panel
        return headingPanel;
    }

    @Override
    public void actionPerformed(ActionEvent A) {
        if (A.getSource() == compressButton) {
            JFileChooser fileChooser = new JFileChooser();

            int response = fileChooser.showSaveDialog(null);
            if (response == JFileChooser.APPROVE_OPTION) {
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.print(file);
                try
                {
                    Comp.method(file);
                }
                catch (Exception B)
                {
                    JOptionPane.showMessageDialog(null, B.toString());
                }
            }
        }
        if (A.getSource() == decompressButton)
        {
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(null);
            if (response == JFileChooser.APPROVE_OPTION)
            {
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.print(file);
                try
                {
                    Decomp.method(file);
                }
                catch (Exception B)
                {
                    JOptionPane.showMessageDialog(null, B.toString());
                }
            }
        }
    }
}
