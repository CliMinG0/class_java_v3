package bubble.test05;

public interface Moveable {

    // public abstract 생략 가능
    public abstract void left();
    public abstract void right();
    public abstract void up();
    default void down(){};
    
    



}
