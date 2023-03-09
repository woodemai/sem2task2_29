package ru.vsu.cs.savchenko_n_a.sem2.task2_29;

import ru.vsu.cs.savchenko_n_a.sem2.task2_29.utils.JTableUtils;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.File;
import java.text.ParseException;

public class Window extends JFrame{
    private JTable tableInput;
    private JButton buttonInput;
    private JButton buttonOutput;
    private JButton buttonExecute;
    private JTable tableOutput;
    private JPanel panel;
    public Window() {
        setTitle("task2_29");
        setContentPane(panel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        int weight = dimension.width/2;
        int height = dimension.height/2;
        setBounds(dimension.width/2  - weight/2, dimension.height/2 - height/2, weight, height);

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File("."));
        FileFilter filter = new FileNameExtensionFilter("Text files", "txt");
        fileChooser.addChoosableFileFilter(filter);

        JTableUtils.initJTableForArray(tableInput, 50, false, false, false, false);
        JTableUtils.initJTableForArray(tableOutput, 50, false, false, false, false);

        buttonInput.addActionListener(e -> {
            try {
                if (fileChooser.showOpenDialog(panel) == JFileChooser.APPROVE_OPTION) {
                    String path = fileChooser.getSelectedFile().getPath();
                    JTableUtils.writeArrayToJTable(tableInput, Solution.getNumbers(path));
                }
            }catch (Exception e1) {
                throw new RuntimeException(e1);
            }
        });
        buttonOutput.addActionListener(e -> {
            try {
                if (fileChooser.showOpenDialog(panel) == JFileChooser.APPROVE_OPTION) {
                    int [] arr = JTableUtils.readIntArrayFromJTable(tableOutput);
                    assert arr != null;
                    Solution.saveToFile(fileChooser.getSelectedFile().getPath(), arr);
                }
            }catch (Exception e1) {
                throw new RuntimeException(e1);
            }
        });
        buttonExecute.addActionListener(e -> {
            int[] arr = new int[0];
            try {
                arr = JTableUtils.readIntArrayFromJTable(tableInput);
            } catch (ParseException ex) {
                throw new RuntimeException(ex);
            }
            DoublyLinkedList linkedList = new DoublyLinkedList(arr);
            linkedList.reverse();
            arr  = linkedList.toArray();
            JTableUtils.writeArrayToJTable(tableOutput, arr);
        });
    }
}
