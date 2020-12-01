package AutoClicker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AutoClickerView extends JFrame {
    private AutoClickerPresenter presenter;
    private JTextField delayField;
    private JButton confirmButton;
    private JPanel mainPanel;
    private JButton STOPButton;
    private JTextField clicksCountField;

    private int clicksCount;


    public AutoClickerView() {
        super("AutoClicker");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(550, 450);
        setContentPane(mainPanel);
        mainPanel.isFocusable();
        setVisible(true);


        confirmButton.addActionListener(e -> {

            presenter.confirm(Integer.parseInt(delayField.getText()));
            clicksCount = Integer.parseInt(clicksCountField.getText());

        });
        STOPButton.addActionListener(e -> System.exit(0));

        KeyListener keyListener = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                for (int i = 0; i < clicksCount; i++) {
                    presenter.execute();

                }

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }

        };
        confirmButton.addKeyListener(keyListener);
        mainPanel.addKeyListener(keyListener);


    }

    public void setPresenter(AutoClickerPresenter presenter) {
        this.presenter = presenter;
    }
}
