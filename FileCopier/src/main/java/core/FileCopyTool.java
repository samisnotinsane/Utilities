package main.java.core;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.*;
import java.util.List;

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

        lblSrc = new JLabel("Source folder:");
        lblDest = new JLabel("Destination folder:");
        txtSrcPath = new JTextArea(0, 20);
        txtDestPath = new JTextArea(0, 20);
        btnCopy = new JButton("Copy");
        btnCopy.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                startCopy();
            }
        });

        progressBar = new JProgressBar();

        txtSrcPath.setSize(new Dimension(50, 0));
        txtDestPath.setSize(new Dimension(50, 0));

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


    public void startCopy() {
        SwingWorker<Boolean, Double> worker = new SwingWorker<Boolean, Double>() {
            @Override
            protected Boolean doInBackground() throws Exception {
                return null;
            }

            @Override
            protected void process(List<Double> chunks) {

            }

            @Override
            protected void done() {

            }
        };
        worker.execute();
    }



}
