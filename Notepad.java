import javax.swing.*;
import java.awt.Color;
import java.io.*;

public class Notepad {
    public static void main(String[] args) {
        JFrame window = new JFrame("Notepad");
        JTextArea textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("File");
        JMenuItem open = new JMenuItem("Open");
        JMenuItem save = new JMenuItem("Save");
        JMenuItem exit = new JMenuItem("Exit");

        textArea.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 14));
        textArea.setText("Start typing!");
        textArea.setCaretColor(Color.WHITE);

        menu.add(open);
        menu.add(save);
        menu.add(exit);
        menuBar.add(menu);
        window.setJMenuBar(menuBar);
        window.add(scrollPane);
        window.setSize(1000, 800);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);

        open.addActionListener(e -> {
            JFileChooser fc = new JFileChooser();
            if (fc.showOpenDialog(window) == JFileChooser.APPROVE_OPTION) {
                try (BufferedReader br = new BufferedReader(new FileReader(fc.getSelectedFile()))) {
                    textArea.read(br, null);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(window, "Error opening file!");
                }
            }
        });

        save.addActionListener(e -> {
            JFileChooser fc = new JFileChooser();
            if (fc.showSaveDialog(window) == JFileChooser.APPROVE_OPTION) {
                try (BufferedWriter bw = new BufferedWriter(new FileWriter(fc.getSelectedFile()))) {
                    textArea.write(bw);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(window, "Error saving file!");
                }
            }
        });

        exit.addActionListener(e -> System.exit(0));

        window.setBackground(Color.DARK_GRAY);
        textArea.setBackground(Color.DARK_GRAY);
        scrollPane.setBackground(Color.DARK_GRAY);
        menuBar.setBackground(Color.DARK_GRAY);
        menu.setBackground(Color.DARK_GRAY);
        save.setBackground(Color.DARK_GRAY);
        open.setBackground(Color.DARK_GRAY);
        exit.setBackground(Color.DARK_GRAY);

        window.setForeground(Color.WHITE);
        textArea.setForeground(Color.WHITE);
        scrollPane.setForeground(Color.WHITE);
        menuBar.setForeground(Color.WHITE);
        menu.setForeground(Color.WHITE);
        save.setForeground(Color.WHITE);
        open.setForeground(Color.WHITE);
        exit.setForeground(Color.WHITE);
    }
}
