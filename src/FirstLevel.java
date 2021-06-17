import javax.swing.*;
import java.awt.*;



public class FirstLevel extends JPanel implements Collision {
    private Player player;
    private Enemy enemy1;
    private Enemy enemy2;
    private Enemy enemy3;
    private Enemy enemy4;
    private ImageIcon alienLevel1=new ImageIcon("images/alienfirst.gif");
    private Image backGround = new ImageIcon("images/space.jpg").getImage();

    public FirstLevel() {
        this.setBounds(0,0,Constants.WINDOW_WIDTH,Constants.WINDOW_HEIGHT);
        this.setDoubleBuffered(true);
        this.player = new Player(Constants.PLAYER_X, Constants.PLAYER_Y, Constants.PLAYER_WIDTH, Constants.PLAYER_HEIGHT);
        this.enemy1 = new Enemy(Constants.ENEMY1_X, Constants.ENEMY1_Y, Constants.ENEMY1_SIZE, Constants.ENEMY1_SIZE);
        this.enemy2 = new Enemy(Constants.ENEMY2_X, Constants.ENEMY2_Y, Constants.ENEMY2_SIZE, Constants.ENEMY2_SIZE);
        this.enemy3 = new Enemy(Constants.ENEMY3_X, Constants.ENEMY3_Y, Constants.ENEMY3_SIZE, Constants.ENEMY3_SIZE);
        this.enemy4 = new Enemy(Constants.ENEMY4_X, Constants.ENEMY4_Y, Constants.ENEMY4_SIZE, Constants.ENEMY4_SIZE);


    }



    @Override
    public void paint(Graphics g) {
        super.paint(g);
                    g.drawImage(backGround, 0, 0, Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT, this);
                    this.player.paint(g);
                    this.enemy1.paint(g);
                    this.enemy2.paint(g);
                    this.enemy3.paint(g);
                    this.enemy4.paint(g);
                    g.drawImage(alienLevel1.getImage(), Constants.ALIEN1_X, Constants.ALIEN1_Y,Constants.ALIEN_LEVEL1_WIDTH,Constants.ALIEN_LEVEL1_HEIGHT, null);



    }



    public boolean collision(Player player, Enemy enemy) {
        Rectangle playerRectangle = new Rectangle(player.getX(), player.getY(), player.getWidth(), player.getHeight());
        Rectangle enemyRectangle = new Rectangle(enemy.getX(), enemy.getY(), enemy.getWidth(), enemy.getHeight());
        boolean collision = playerRectangle.intersects(enemyRectangle);
        return collision;

    }

    public boolean playerMeetAlien(Player player) {
        Rectangle playerRectangle = new Rectangle(player.getX(), player.getY(), player.getWidth(), player.getHeight());
        Rectangle alienRectangle = new Rectangle(Constants.ALIEN1_X, Constants.ALIEN1_Y, Constants.ALIEN_Y_LEVEL2, Constants.ALIEN_Y_LEVEL2);
        boolean meeting = playerRectangle.intersects(alienRectangle);
        return meeting;

    }

    public void startOverAfterCollision() {
        if (collision(player, enemy1) || collision(player, enemy2) || collision(player, enemy3) || collision(player, enemy4)) {
            JFrame startOverButton = new JFrame();
            startOverButton.setLocationRelativeTo(null);
            JOptionPane.showMessageDialog(startOverButton, "first level: You are died!!,Please press OK if you want to stars Over");
           resetPlayerAndEnemiesAfterCollision();

        }



    }public void resetPlayerAndEnemiesAfterCollision() {
            this.player.setX(Constants.PLAYER_X);
            this.player.setY(Constants.PLAYER_Y);
            this.enemy1.setX(Constants.ENEMY1_X);
            this.enemy1.setY(Constants.ENEMY1_Y);
            this.enemy2.setX(Constants.ENEMY2_X);
            this.enemy2.setY(Constants.ENEMY1_Y);
            this.enemy3.setX(Constants.ENEMY3_X);
            this.enemy3.setY(Constants.ENEMY3_Y);
            this.enemy4.setX(Constants.ENEMY4_X);
            this.enemy4.setY(Constants.ENEMY4_Y);

        }

    public boolean moveToNextLevel() {
        if (playerMeetAlien(this.player)) {
            this.player.setX(Constants.PLAYER_X);
            this.player.setY(Constants.PLAYER_Y);

            return true;
        } else
            return false;


    }public ImageIcon getAlienLevel1() {
        return alienLevel1;
    }

    public void setAlienLevel1(ImageIcon alienLevel1) {
        this.alienLevel1 = alienLevel1;
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

    public void setAlien(ImageIcon alien) {
        this.alienLevel1 = alien;
    }

    public ImageIcon getAlien() {
        return alienLevel1;
    }

    public Image getBackGround() {
        return backGround;
    }

    public void setBackGround(Image backGround) {
        this.backGround = backGround;
    }
}
