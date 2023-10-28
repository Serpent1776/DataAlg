import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;
public class CallWindow {
    JFrame window;
    JFrame confirm;
    JPanel panel;
    JPanel answerPanel;

    public CallWindow() {
        this.window = new JFrame("Call Machine");
        this.window.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE); 
        this.window.setSize(400, 150);
        this.confirm = new JFrame("Do you confirm?");
        confirm.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        confirm.setSize(400, 150);
        this.panel = new JPanel();
        this.answerPanel = new JPanel();
    }
    public JFrame getWindow() {
        return this.window;
    }
    public JPanel getPanel() {
        return this.panel;
    }
    public JFrame getConfirm() {
        return confirm;
    }
    public JPanel getAnswerPanel() {
        return answerPanel;
    }
}
