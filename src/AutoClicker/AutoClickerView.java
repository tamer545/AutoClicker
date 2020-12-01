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
    private JComboBox mouseButtonComboBox;

    private int clicksCount;


    public AutoClickerView() {
        super("AutoClicker");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(700, 650);
        setContentPane(mainPanel);
        setLocationRelativeTo(null);
        setResizable(false);
        mainPanel.isFocusable();
        setVisible(true);

        mouseButtonComboBox.addItem("Left Mouse Button");
        mouseButtonComboBox.addItem("Middle Mouse Button");
        mouseButtonComboBox.addItem("Right Mouse Button");


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
                if (e.getKeyCode() == KeyEvent.VK_F7) {
                    if (clicksCount >= 5) {
                        for (int i = 0; i < clicksCount; i++) {
                            if (mouseButtonComboBox.getSelectedItem().equals("Left Mouse Button")) {
                                presenter.executeMouseLeft();
                            } else if (mouseButtonComboBox.getSelectedItem().equals("Middle Mouse Button")) {
                                presenter.executeMouseRight();
                            } else if (mouseButtonComboBox.getSelectedItem().equals("Right Mouse Button")) {
                                presenter.executeMouseMiddle();
                            }
                        }
                    }
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
