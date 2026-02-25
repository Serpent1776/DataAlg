import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class SearchGUI {
    JFrame searchFrame;
    JButton enter;
    JTextArea jText;
    String string;
    AlmanicTree searchArea;
    public SearchGUI(AlmanicTree tree) {
        searchFrame = new JFrame();
        searchFrame.setSize(150, 400);
        jText = new JTextArea();
        jText.setSize(200, 16);
        jText.setFont(new Font("BerlinSans", 2, 12));
        jText.setLineWrap(true);
        enter = new JButton("confirm");
        enter.addActionListener(new ActionListener() {
            public void actionPerformed( ActionEvent pressed) {
                searchEnter();
            }
        });
        searchFrame.getContentPane().add(jText, BorderLayout.CENTER);
        searchFrame.getContentPane().add(enter, BorderLayout.WEST);
        this.searchArea = tree;
    }
    public void open() {
        searchFrame.setVisible(true);
    }
    public void searchEnter() {
       String searched = "";
       this.string = searched;
    }
    public String getString() {
        return string;
    }
}
