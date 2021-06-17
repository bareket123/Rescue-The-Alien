import javax.swing.*;
import java.awt.*;

public class CurrenScene extends JPanel {
    private FirstLevel firstLevel;
    private SecondLevel secondLevel;
    private int sceneId;

    public CurrenScene(){
        firstLevel=new FirstLevel();
        secondLevel=new SecondLevel(firstLevel.getPlayer(),firstLevel.getEnemy1(),firstLevel.getEnemy2(),firstLevel.getEnemy3(),firstLevel.getEnemy4());
        sceneId=Constants.FIRST_LEVEL;
        this.add(firstLevel);
        this.add(secondLevel);
         this.mainGameLoop();

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
            switch (this.sceneId) {

                case Constants.FIRST_LEVEL:
                    firstLevel.paint(g);
                    Graphics2D createGraphics = (Graphics2D) g;
                    if (firstLevel.getPlayer().getX()==Constants.PLAYER_X && firstLevel.getPlayer().getY()==Constants.PLAYER_Y){
                        createGraphics.setFont( new Font("David", Font.BOLD, Constants.LABEL_SIZE));
                        createGraphics.setPaint( Color.WHITE );
                        createGraphics.drawString("LEVEL 1",Constants.LABEL_LEVEL_X,Constants.LABEL_LEVEL_Y);
                        createGraphics.dispose();
                    }


                    break;
                case Constants.SECOND_LEVEL:
                    secondLevel.paint(g);
                     createGraphics = (Graphics2D) g;
                    if (secondLevel.getPlayer().getX()==Constants.PLAYER_X && secondLevel.getPlayer().getY()==Constants.PLAYER_Y){
                        createGraphics.setFont( new Font("David", Font.BOLD, Constants.LABEL_SIZE));
                        createGraphics.setPaint( Color.WHITE );
                        createGraphics.drawString("LEVEL 2",Constants.LABEL_LEVEL_X,Constants.LABEL_LEVEL_Y);
                        createGraphics.dispose();
                    }
                    break;
            }


    }
    public void mainGameLoop() {
        new Thread(() -> {
            while (true) {


                    repaint();
                    switch (this.sceneId){
                        case Constants.FIRST_LEVEL:
                            this.firstLevel.getEnemy1().moveEnemies();
                            this.firstLevel.getEnemy2().moveEnemies();
                            this.firstLevel.getEnemy3().moveEnemies();
                            this.firstLevel.getEnemy4().moveEnemies();
                            if (this.firstLevel.getPlayer().getX() != Constants.PLAYER_X && this.firstLevel.getPlayer().getY() != Constants.PLAYER_Y) {
                                firstLevel.startOverAfterCollision();
                            }

                            if (firstLevel.moveToNextLevel()) {
                                this.sceneId = Constants.SECOND_LEVEL;
                            }
                            break;


                        case Constants.SECOND_LEVEL:
                            this.firstLevel.getEnemy1().moveEnemies();
                            this.firstLevel.getEnemy2().moveEnemies();
                            this.firstLevel.getEnemy3().moveEnemies();
                            this.firstLevel.getEnemy4().moveEnemies();
                            this.secondLevel.getEnemy5().moveEnemies();
                            this.secondLevel.getEnemy6().moveEnemies();
                            this.secondLevel.getEnemy7().moveEnemies();
                            if (this.secondLevel.getPlayer().getX() != Constants.PLAYER_X && this.secondLevel.getPlayer().getY() != Constants.PLAYER_Y) {
                                firstLevel.startOverAfterCollision(); //make sure enemies 1-4 reposition after collision
                                secondLevel.startOverAfterCollision();
                            } if (secondLevel.isWinner()) {
                                Object[] options = {"Yes", "No"};
                            int n = JOptionPane.showOptionDialog(this, "winner!!!!!!!!!!!\n Do You want to start over", null, JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options,null);
                            if (n == Constants.NO_OPTION) {
                                System.exit(0);
                            } else if (n == Constants.YES_OPTION) {
                                this.sceneId=Constants.FIRST_LEVEL;
                            }
                        }


                            break;
                    }


                    try {
                    Thread.sleep(Constants.FRAMES_SPEED);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        }



    public FirstLevel getFirstLevel() {
        return firstLevel;
    }

    public void setFirstLevel(FirstLevel firstLevel) {
        this.firstLevel = firstLevel;
    }

    public SecondLevel getSecondLevel() {
        return secondLevel;
    }

    public void setSecondLevel(SecondLevel secondLevel) {
        this.secondLevel = secondLevel;
    }



        }














