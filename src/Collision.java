import javax.swing.*;

public interface Collision {
    public void resetPlayerAndEnemiesAfterCollision();
    public boolean collision(Player player, Enemy enemy);
    public void startOverAfterCollision();
     public boolean playerMeetAlien(Player player);

}