package AutoClicker;

import java.awt.*;
import java.awt.event.InputEvent;

public class AutoClickerPresenter {
    private AutoClickerView view;
    private int ms;
    private Robot robot = new Robot();

    public AutoClickerPresenter(AutoClickerView view) throws AWTException {
        this.view = view;
        view.setPresenter(this);
    }
    public void confirm(int ms){
        this.ms =  ms;
    }
    public void execute(){
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
        robot.delay(ms);
    }

}
