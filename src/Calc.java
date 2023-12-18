import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Calc {
    public static void main(String[] args) {
        JFrame frame = new JFrame("電卓");
        JTextField textField = new JTextField();
        
        frame.getContentPane().setLayout(null); // デフォルトレイアウト無効
        frame.setBounds(100, 100, 285, 340); // x, y, width, height
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        textField.setBounds(20, 10, 245, 30);
        frame.getContentPane().add(textField); // テキストフィールドをフレームに追加

        int buttonNumber = 0;
        for(int i = 0; i< 3; i++) {
            for(int j = 0; j < 3; j++) {
                buttonNumber++;
                addButton(frame, String.valueOf(buttonNumber), 20 + j*60, 170 - i*60, event -> textField.setText(textField.getText() + event.getActionCommand()));
            }
        }
        
        addButton(frame, "0", 20, 230, event -> textField.setText(textField.getText() + event.getActionCommand()));
        addButton(frame, "AC", 80, 230, event -> textField.setText(""));
        //addButton(frame, "=", 140, 230, event -> 
        addButton(frame, "/", 200, 50, event -> textField.setText(textField.getText() + event.getActionCommand()));
        addButton(frame, "*", 200, 110, event -> textField.setText(textField.getText() + event.getActionCommand()));
        addButton(frame, "-", 200, 170, event -> textField.setText(textField.getText() + event.getActionCommand()));
        addButton(frame, "+", 200, 230, event -> textField.setText(textField.getText() + event.getActionCommand()));
        
        frame.setVisible(true); // 可視化
    }
    
    private static void addButton(JFrame frame, String text, int x, int y, ActionListener actionListener) {
        JButton button = new JButton(text);
        button.setBounds(x, y, 50, 50);
        frame.getContentPane().add(button);
        button.addActionListener(actionListener);
    }
}