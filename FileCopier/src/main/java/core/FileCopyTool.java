package main.java.core;

import javax.swing.*;
import java.awt.*;

/**
 * Created by sameen on 11/11/2016.
 */
public class FileCopyTool extends JFrame {

    private JLabel lblSrc;
    private JLabel lblDest;
    private JTextArea txtSrcPath;
    private JTextArea txtDestPath;
    private JButton btnCopy;
    private JProgressBar progressBar;

    public FileCopyTool() {
        FlowLayout layout = new FlowLayout();
        JPanel panel = new JPanel();
        JFrame frame = new JFrame();
        panel.setLayout(layout);
        layout.setAlignment(FlowLayout.TRAILING);

        lblSrc = new JLabel("Source:");
        lblDest = new JLabel("Destination:");
        txtSrcPath = new JTextArea();
        txtDestPath = new JTextArea();
        btnCopy = new JButton("Copy");
        progressBar = new JProgressBar();

        txtSrcPath.setSize(new Dimension(50, 0));
        txtDestPath.setSize(new Dimension(50, 0));

        txtSrcPath.setText("path...      ");
        txtDestPath.setText("path...      ");

        panel.add(lblSrc);
        panel.add(txtSrcPath);
        panel.add(lblDest);
        panel.add(txtDestPath);
        panel.add(btnCopy);
        panel.add(progressBar);

        panel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Copying Tool");
        frame.pack();
        frame.setVisible(true);
    }



}
