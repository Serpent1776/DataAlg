import javax.swing.*;
//import java.awt.*;
//import java.awt.event.*;
public class Window {
    JFrame window;
    JPanel panel;

    public Window() {
        this.window = new JFrame("Library Operations");
        this.window.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.window.setSize(400, 150);
        this.panel = new JPanel();
    }
    public JFrame getWindow() {
        return this.window;
    }
    public JPanel getPanel() {
        return this.panel;
    }
}
