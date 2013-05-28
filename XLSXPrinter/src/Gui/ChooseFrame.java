package Gui;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Storage.Pojo;

import com.toedter.calendar.JDateChooser;

public class ChooseFrame extends JFrame {

    private static final long serialVersionUID = 6669957942758340961L;

    public ChooseFrame(final Pojo pojo) {

        this.setTitle("XLSX Printer - Dennis Markmann");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(280, 155);
        this.setLayout(new FlowLayout());
        this.setLocationRelativeTo(null);

        this.setLayout(new GridBagLayout());
        final GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(5, 5, 5, 5);

        final JLabel searchKeyLabel = new JLabel("SearchKey:");
        final JTextField searchKeyField = new JTextField(8);
        final JButton commitButton = new JButton("Bestätigen");

        final JLabel dateLabel = new JLabel("Datum:");
        final JDateChooser chooser = new JDateChooser();
        // final JButton dateCommitButton = new JButton("Bestätigen");

        c.gridx = 0;
        c.gridy = 0;
        this.add(searchKeyLabel, c);

        c.gridx = 0;
        c.gridy = 1;
        this.add(searchKeyField, c);

        c.gridx = 1;
        c.gridy = 0;
        this.add(dateLabel, c);

        c.gridx = 1;
        c.gridy = 1;
        this.add(chooser, c);

        c.gridx = 0;
        c.gridy = 2;
        this.add(commitButton, c);

        // c.gridx = 1;
        // c.gridy = 2;
        // this.add(dateCommitButton, c);

        commitButton.addActionListener(new ChooseFrameListener(this, searchKeyField, pojo, chooser));
        // dateCommitButton.addActionListener(new ChooseFrameListener(this, null, pojo, chooser, dateCommitButton));

        this.setVisible(true);
        this.pack();
    }
}
