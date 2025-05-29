import javax.swing.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.io.*;

public class Notepad {
    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }
    
        JFrame window = new JFrame("Notepad");
        JTextArea textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("File");
        JMenuItem open = new JMenuItem("Open");
        JMenuItem save = new JMenuItem("Save");
        JMenuItem exit = new JMenuItem("Exit");
        JMenu modes = new JMenu("Modes");
        JCheckBoxMenuItem darkmode = new JCheckBoxMenuItem("Dark Mode");
        JComboBox fontSize = new JComboBox();

        textArea.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 15));
        textArea.setText("Start typing!");

        fontSize.addItem("10");
        fontSize.addItem("12");
        fontSize.addItem("14");
        fontSize.addItem("18");
        fontSize.addItem("24");
        fontSize.addItem("30");

        fontSize.setSelectedItem("14");

        fontSize.setMaximumSize(new Dimension(60, 25));

        menu.add(open);
        menu.add(save);
        menu.add(exit);
        modes.add(darkmode);
        menuBar.add(menu);
        menuBar.add(modes);
        menuBar.add(fontSize);
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

        darkmode.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                window.setBackground(Color.DARK_GRAY);
                textArea.setBackground(Color.DARK_GRAY);
                scrollPane.setBackground(Color.DARK_GRAY);
                menuBar.setBackground(Color.DARK_GRAY);
                menu.setBackground(Color.DARK_GRAY);
                save.setBackground(Color.DARK_GRAY);
                open.setBackground(Color.DARK_GRAY);
                exit.setBackground(Color.DARK_GRAY);
                modes.setBackground(Color.DARK_GRAY);
                darkmode.setBackground(Color.DARK_GRAY);

                textArea.setCaretColor(Color.WHITE);

                window.setForeground(Color.WHITE);
                textArea.setForeground(Color.WHITE);
                scrollPane.setForeground(Color.WHITE);
                menuBar.setForeground(Color.WHITE);
                menu.setForeground(Color.WHITE);
                save.setForeground(Color.WHITE);
                open.setForeground(Color.WHITE);
                exit.setForeground(Color.WHITE);
                modes.setForeground(Color.WHITE);
                darkmode.setForeground(Color.WHITE);
            } else {
                window.setBackground(Color.WHITE);
                textArea.setBackground(Color.WHITE);
                scrollPane.setBackground(Color.WHITE);
                menuBar.setBackground(Color.WHITE);
                menu.setBackground(Color.WHITE);
                save.setBackground(Color.WHITE);
                open.setBackground(Color.WHITE);
                exit.setBackground(Color.WHITE);
                modes.setBackground(Color.WHITE);
                darkmode.setBackground(Color.WHITE);

                textArea.setCaretColor(Color.BLACK);

                window.setForeground(Color.BLACK);
                textArea.setForeground(Color.BLACK);
                scrollPane.setForeground(Color.BLACK);
                menuBar.setForeground(Color.BLACK);
                menu.setForeground(Color.BLACK);
                save.setForeground(Color.BLACK);
                open.setForeground(Color.BLACK);
                exit.setForeground(Color.BLACK);
                modes.setForeground(Color.BLACK);
                darkmode.setForeground(Color.BLACK);
            }
        });

        fontSize.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                int size = Integer.parseInt((String) fontSize.getSelectedItem());
                textArea.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, size));
            }
        });
    }
}
