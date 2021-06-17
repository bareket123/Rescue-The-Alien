import javax.swing.*;
import java.awt.*;

public class Alien {
    private int x;
    private int y;
    private ImageIcon alienLevel2;


    public Alien(int x, int y) {
        this.x = x;
        this.y = y;
        alienLevel2 =new ImageIcon("images/alienlevel2.jpg");


    }
    public ImageIcon getAlienLevel2() {
        return alienLevel2;
    }

    public void setAlienLevel2(ImageIcon alienLevel2) {
        this.alienLevel2 = alienLevel2;
    }
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }



    public void paint(Graphics graphics,SecondLevel secondLevel) {
        this.alienLevel2.paintIcon(secondLevel,graphics,this.x,this.y);

    }



}
