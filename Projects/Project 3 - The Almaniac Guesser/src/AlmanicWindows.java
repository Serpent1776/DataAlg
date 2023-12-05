import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import javax.swing.*;
public class AlmanicWindows {
    JFrame titleMenu;
    JFrame questionarre;
    JFrame confirmWindow;
    boolean titleVisible;
    boolean questionarreVisible;
    boolean comfirmVisible;
    JPanel panel;
    JPanel answerPanel;
    JPanel confirmPanel;
    JLabel playquestion;
    JLabel gamequestion;
    JLabel confirmQuestion;
    JButton play;
    JButton end;
    JButton qYes;
    JButton qNo;
    JButton cYes;
    JButton cNo;
    public AlmanicWindows() {
        this.titleMenu = new JFrame("Almanicguesser");
        this.titleMenu.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE); 
        this.titleMenu.setSize(400, 150);
        this.questionarre = new JFrame("Guesser's question");
        questionarre.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        questionarre.setSize(400, 150);
        this.confirmWindow = new JFrame("Confirm question");
        confirmWindow.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        confirmWindow.setSize(400, 150);
        this.playquestion = new JLabel("Do you want to play or exit the game?");
        this.gamequestion = new JLabel("");
        this.confirmQuestion = new JLabel("");
        this.titleVisible = false;
        this.questionarreVisible = false;
        this.comfirmVisible = false;
        this.panel = new JPanel();
        this.answerPanel = new JPanel();
        this.confirmPanel = new JPanel();
        titleMenu.getContentPane().add(panel, BorderLayout.CENTER);
        titleMenu.getContentPane().add(playquestion, BorderLayout.NORTH);
        questionarre.getContentPane().add(answerPanel, BorderLayout.CENTER);
        questionarre.getContentPane().add(gamequestion, BorderLayout.NORTH);
        confirmWindow.getContentPane().add(confirmPanel, BorderLayout.CENTER);
        confirmWindow.getContentPane().add(confirmQuestion, BorderLayout.NORTH);
        play = new JButton("play");
        end = new JButton("exit");
        panel.add(play);
        panel.add(end);
        qYes = new JButton("yes");
        qNo = new JButton("no");
        answerPanel.add(qYes);
        answerPanel.add(qNo);
        cYes = new JButton("yes");
        cNo = new JButton("no");
        confirmPanel.add(cYes);
        confirmPanel.add(cNo);
        
    }
    /* all toggles open and close the window without the need of a boolean, move conveinent for the game.
     * functionally a t-flipflop
     */
    public void titleVisibletoggle() { 
        titleVisible = !titleVisible;
        titleMenu.setVisible(titleVisible);
    }
    public void questionarreVisibletoggle() {
        questionarreVisible = !questionarreVisible;
        questionarre.setVisible(questionarreVisible);
    }
    public void confirmVisibletoggle() {
        comfirmVisible = !comfirmVisible;
        confirmWindow.setVisible(comfirmVisible);
    }
    public JFrame getTitleMenu() {
        return this.titleMenu;
    }
    public JPanel getPanel() {
        return this.panel;
    }
    public JFrame getQuestionarre() {
        return questionarre;
    }
    public JPanel getAnswerPanel() {
        return answerPanel;
    }
    public JLabel getGamequestion() {
        return gamequestion;
    }
    public JLabel getPlayquestion() {
        return playquestion;
    }
    public JButton getPlay() {
        return play;
    }
    public JButton getEnd() {
        return end;
    }
    public JButton getqYes() {
        return qYes;
    }
    public JButton getqNo() {
        return qNo;
    }
    public JButton getcYes() {
        return cYes;
    }
    public JButton getcNo() {
        return cNo;
    }
    public void addActionListenerPlay(ActionListener action) {
        play.addActionListener(action);
    }
    public void addActionListenerEnd(ActionListener action) {
        end.addActionListener(action);
    }
    public void addActionListenerQYes(ActionListener action) {
        qYes.addActionListener(action);
    }
    public void addActionListenerQNo(ActionListener action) {
        qNo.addActionListener(action);
    }
    public void addActionListenerCYes(ActionListener action) {
        cYes.addActionListener(action);
    }
    public void addActionListenerCNo(ActionListener action) {
        cNo.addActionListener(action);
    }
    public void addWindowListenerTitleMenu(WindowAdapter windowAdapter) {
        titleMenu.addWindowListener(windowAdapter);
    }
    public void addWindowListenerQuestionarre(WindowAdapter action) {
        questionarre.addWindowListener(action);
    }
     public void addWindowListenerConfirm(WindowAdapter action) {
        confirmWindow.addWindowListener(action);
    }
    public void setGameQuestion(String question) {
        gamequestion.setText(question);
    }
    public void setConfirmQuestion(String question) {
        confirmQuestion.setText(question);
    }
}