package bubble.test04;

import javax.swing.*;

public class Bubble extends JLabel implements Moveable{
    private int x;
    private int y;

    private boolean left;
    private boolean right;
    private boolean up;


    private Player player;

    private ImageIcon bubble;



    public Bubble(Player player) {
        this.player = player;
        initData();
        setInitLayout();
    }

    private void initData() {
        bubble = new ImageIcon("images/bubble.png");
        left = false;
        right = false;
        up = false;
    }

    private void setInitLayout() {
        x = player.getX();
        y = player.getY();

        setIcon(bubble);
        setSize(50,50);
        setLocation(x,y);
    }




    // Getter
    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    public boolean isLeft() {
        return left;
    }

    public boolean isRight() {
        return right;
    }

    public boolean isUp() {
        return up;
    }

    public Player getPlayer() {
        return player;
    }

    public ImageIcon getBubble() {
        return bubble;
    }

    // Setter

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setBubble(ImageIcon bubble) {
        this.bubble = bubble;
    }

    @Override
    public void left() {

    }

    @Override
    public void right() {

    }

    @Override
    public void up() {

    }

}

