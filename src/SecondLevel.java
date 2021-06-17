import javax.swing.*;
import java.awt.*;


public class SecondLevel extends JPanel implements Collision {
    private Player player;
    private Enemy enemy1;
    private Enemy enemy2;
    private Enemy enemy3;
    private Enemy enemy4;
    private Enemy enemy5;
    private Enemy enemy6;
    private Enemy enemy7;
    private Alien alien;
    private ImageIcon winnerIcon = new ImageIcon("images/winner.gif");
    private ImageIcon icon = new ImageIcon("images/spacesecond.gif");

    public SecondLevel(Player player, Enemy enemy1, Enemy enemy2, Enemy enemy3, Enemy enemy4) {
        setBounds(0, 0, Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
        this.setDoubleBuffered(true);
        this.player = player;
        this.enemy1 = enemy1;
        this.enemy2 = enemy2;
        this.enemy3 = enemy3;
        this.enemy4 = enemy4;
        this.enemy5 = new Enemy(Constants.ENEMY5_X, Constants.ENEMY5_Y, Constants.ENEMY_SIZE, Constants.ENEMY_SIZE);
        this.enemy6 = new Enemy(Constants.ENEMY6_X, Constants.ENEMY6_Y, Constants.ENEMY_SIZE, Constants.ENEMY_SIZE);
        this.enemy7 = new Enemy(Constants.ENEMY7_X, Constants.ENEMY7_Y, Constants.ENEMY_SIZE, Constants.ENEMY_SIZE);
        this.alien = new Alien(Constants.ALIEN_Y_LEVEL2, Constants.ALIEN_X_LEVEL2);

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Image background = icon.getImage();
        g.drawImage(background, Constants.END_FRAME, Constants.END_FRAME, Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT, null);
        this.player.paint(g);
        this.enemy1.paint(g);
        this.enemy2.paint(g);
        this.enemy3.paint(g);
        this.enemy4.paint(g);
        this.enemy5.paint(g);
        this.enemy6.paint(g);
        this.enemy7.paint(g);
        alien.paint(g, this);
    }


    public boolean collision(Player player, Enemy enemy) {
        Rectangle playerRectangle = new Rectangle(player.getX(), player.getY(), player.getWidth(), player.getHeight());
        Rectangle enemyRectangle = new Rectangle(enemy.getX(), enemy.getY(), enemy.getWidth(), enemy.getHeight());
        boolean collision = playerRectangle.intersects(enemyRectangle);
        return collision;


    }


    public boolean playerMeetAlien(Player player) {
        Rectangle playerRectangle = new Rectangle(player.getX(), player.getY(), player.getWidth(), player.getHeight());
            Rectangle alienRectangle = new Rectangle(Constants.ALIEN_X_LEVEL2, Constants.ALIEN_Y_LEVEL2,Constants.ALIEN_LEVEL2_WIDTH, Constants.ALIEN_LEVEL2_HEIGHT);
        boolean meeting = playerRectangle.intersects(alienRectangle);
        return meeting;


    }


    public void startOverAfterCollision() {
        if (collision(player, enemy1) || collision(player, enemy2) || collision(player, enemy3) ||
                collision(player, enemy4) || collision(player, enemy5) ||
                collision(player, enemy6) || collision(player, enemy7)) {
            JFrame startOverButton = new JFrame();
            startOverButton.setLocationRelativeTo(null);
            JOptionPane.showMessageDialog(startOverButton, "You are died!!,Please press OK if you want to stars Over");
            resetPlayerAndEnemiesAfterCollision();


        }


    }

    public boolean isWinner() {
        if (playerMeetAlien(this.player)) {
            this.player.setX(Constants.PLAYER_X);
            this.player.setY(Constants.PLAYER_Y);
            return true;
        }


        return false;
    }

    //if you disqualified, this function make sure you to return you to the beginning point,enemies 1-4 already taking care of in level 1
    public void resetPlayerAndEnemiesAfterCollision() {
        this.player.setX(Constants.PLAYER_X);
        this.player.setY(Constants.PLAYER_Y);
        this.enemy5.setX(Constants.ENEMY5_X);
        this.enemy5.setY(Constants.ENEMY5_Y);
        this.enemy6.setX(Constants.ENEMY6_X);
        this.enemy6.setY(Constants.ENEMY6_Y);
        this.enemy7.setX(Constants.ENEMY7_X);
        this.enemy7.setY(Constants.ENEMY7_Y);


    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Enemy getEnemy1() {
        return enemy1;
    }

    public void setEnemy1(Enemy enemy1) {
        this.enemy1 = enemy1;
    }

    public Enemy getEnemy2() {
        return enemy2;
    }

    public void setEnemy2(Enemy enemy2) {
        this.enemy2 = enemy2;
    }

    public Enemy getEnemy3() {
        return enemy3;
    }

    public void setEnemy3(Enemy enemy3) {
        this.enemy3 = enemy3;
    }

    public Enemy getEnemy4() {
        return enemy4;
    }

    public void setEnemy4(Enemy enemy4) {
        this.enemy4 = enemy4;
    }

    public Alien getAlien() {
        return alien;
    }

    public void setAlien(Alien alien) {
        this.alien = alien;
    }

    public Enemy getEnemy5() {
        return enemy5;
    }

    public void setEnemy5(Enemy enemy5) {
        this.enemy5 = enemy5;
    }

    public Enemy getEnemy6() {
        return enemy6;
    }

    public void setEnemy6(Enemy enemy6) {
        this.enemy6 = enemy6;
    }

    public Enemy getEnemy7() {
        return enemy7;
    }

    public void setEnemy7(Enemy enemy7) {
        this.enemy7 = enemy7;
    }


    public ImageIcon getWinnerIcon() {
        return winnerIcon;
    }

    public void setWinnerIcon(ImageIcon winnerIcon) {
        this.winnerIcon = winnerIcon;
    }

    public ImageIcon getIcon() {
        return icon;
    }

    public void setIcon(ImageIcon icon) {
        this.icon = icon;
    }
}


