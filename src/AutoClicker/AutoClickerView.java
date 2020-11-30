package AutoClicker;

import javax.swing.*;
import java.awt.event.*;

public class AutoClickerView extends JFrame {
    private AutoClickerPresenter presenter;
    private JTextField delayField;
    private JButton confirmButton;
    private JPanel mainPanel;


    public AutoClickerView() {
        super("AutoClicker");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 400);
        setContentPane(mainPanel);
        setVisible(true);
        confirmButton.addActionListener(e -> {
            presenter.confirm(Integer.parseInt(delayField.getText()));

        });
        confirmButton.addKeyListener(new KeyListener() {


            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                while (e.getKeyCode() == KeyEvent.VK_P) {
                    presenter.execute();

                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }

        });

    }

    public void setPresenter(AutoClickerPresenter presenter) {
        this.presenter = presenter;
    }
}
