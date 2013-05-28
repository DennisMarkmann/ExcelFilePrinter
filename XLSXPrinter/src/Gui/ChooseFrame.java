package Gui;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Storage.Pojo;

import com.toedter.calendar.JDateChooser;

public class ChooseFrame extends JFrame {

    private static final long serialVersionUID = 6669957942758340961L;

    public ChooseFrame(final Pojo pojo) {

        this.setTitle("XLSX Printer");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(260, 155);
        this.setLocationRelativeTo(null);

        final JPanel centerPanel = new JPanel();
        final JPanel southPanel = new JPanel();

        this.add(centerPanel, BorderLayout.CENTER);
        this.add(southPanel, BorderLayout.SOUTH);

        centerPanel.setLayout(new GridBagLayout());
        final GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(5, 5, 5, 5);

        final JLabel searchKeyLabel = new JLabel("SearchKey:");
        final JTextField searchKeyField = new JTextField(7);
        final JButton commitButton = new JButton("Bestätigen");

        final JLabel dateLabel = new JLabel("Datum:");
        final JDateChooser chooser = new JDateChooser();

        c.gridx = 0;
        c.gridy = 0;
        centerPanel.add(searchKeyLabel, c);

        c.gridx = 0;
        c.gridy = 1;
        centerPanel.add(searchKeyField, c);

        c.gridx = 1;
        c.gridy = 0;
        centerPanel.add(dateLabel, c);

        c.gridx = 1;
        c.gridy = 1;
        centerPanel.add(chooser, c);

        southPanel.add(commitButton);

        commitButton.addActionListener(new ChooseFrameListener(this, searchKeyField, pojo, chooser));

        this.setVisible(true);
    }
}
