package entity.Player;

import entity.Entity;
import inventory.Inventory;
import item.weapon.sword.Sword;
import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Player extends Entity {

    KeyHandler keyHandler;
    public int health = 100;
    public int maxHealth = 100;
    public Inventory inventory;

    boolean isRolling = false;
    boolean isAttacking = false;
    String direction;
    public BufferedImage up1, up2, up3, up4, up_left1, up_left2, up_left3, up_left4, up_right1, up_right2, up_right3, up_right4, down1, down2, down3, down4, left1, left2, left3, left4, right1, right2, right3, right4, down_left1, down_left2, down_left3, down_left4, down_right1, down_right2, down_right3, down_right4;
    public BufferedImage r_up1, r_up2, r_up3, r_up4, r_down1, r_down2, r_down3, r_down4, r_left1, r_left2, r_left3, r_left4, r_right1, r_right2, r_right3, r_right4, r_down_left1, r_down_left2, r_down_left3, r_down_left4, r_down_right1, r_down_right2, r_down_right3, r_down_right4, r_up_left1,r_up_left2, r_up_left3, r_up_left4, r_up_right1, r_up_right2, r_up_right3, r_up_right4;
    public BufferedImage a_right_1, a_right_2, a_right_3, a_right_4, a_left_1, a_left_2, a_left_3, a_left_4;

    public Player(GamePanel game, KeyHandler keyHandler) {
        super(game);

        this.keyHandler = keyHandler;

        inventory = new Inventory();
        setDefaultValues();
        getPlayerImage();

        hitbox = new Rectangle(0 , 0, game.tileSize-16, game.tileSize-23);
    }

    public void setDefaultValues() {
        x = 50;
        y = 50;
        inventory.addItem(new Sword());
        speed = 2;
        cardinalDirection = "down";
        direction = "down";
        animationSpeed = 15;
    }

    public void getPlayerImage() {
        try {
            up1 = ImageIO.read(new File("resources/player/youmu/walking/up_1.png"));
            up2 = ImageIO.read(new File("resources/player/youmu/walking/up_2.png"));
            up3 = ImageIO.read(new File("resources/player/youmu/walking/up_3.png"));
            up4 = ImageIO.read(new File("resources/player/youmu/walking/up_4.png"));
            up_left1 = ImageIO.read(new File("resources/player/youmu/walking/up_left_1.png"));
            up_left2 = ImageIO.read(new File("resources/player/youmu/walking/up_left_2.png"));
            up_left3 = ImageIO.read(new File("resources/player/youmu/walking/up_left_3.png"));
            up_left4 = ImageIO.read(new File("resources/player/youmu/walking/up_left_4.png"));
            up_right1 = ImageIO.read(new File("resources/player/youmu/walking/up_right_1.png"));
            up_right2 = ImageIO.read(new File("resources/player/youmu/walking/up_right_2.png"));
            up_right3 = ImageIO.read(new File("resources/player/youmu/walking/up_right_3.png"));
            up_right4 = ImageIO.read(new File("resources/player/youmu/walking/up_right_4.png"));
            down1 = ImageIO.read(new File("resources/player/youmu/walking/down_1.png"));
            down2 = ImageIO.read(new File("resources/player/youmu/walking/down_2.png"));
            down3 = ImageIO.read(new File("resources/player/youmu/walking/down_3.png"));
            down4 = ImageIO.read(new File("resources/player/youmu/walking/down_4.png"));
            down_left1 = ImageIO.read(new File("resources/player/youmu/walking/down_left_1.png"));
            down_left2 = ImageIO.read(new File("resources/player/youmu/walking/down_left_2.png"));
            down_left3 = ImageIO.read(new File("resources/player/youmu/walking/down_left_3.png"));
            down_left4 = ImageIO.read(new File("resources/player/youmu/walking/down_left_4.png"));
            down_right1 = ImageIO.read(new File("resources/player/youmu/walking/down_right_1.png"));
            down_right2 = ImageIO.read(new File("resources/player/youmu/walking/down_right_2.png"));
            down_right3 = ImageIO.read(new File("resources/player/youmu/walking/down_right_3.png"));
            down_right4 = ImageIO.read(new File("resources/player/youmu/walking/down_right_4.png"));
            left1 = ImageIO.read(new File("resources/player/youmu/walking/left_1.png"));
            left2 = ImageIO.read(new File("resources/player/youmu/walking/left_2.png"));
            left3 = ImageIO.read(new File("resources/player/youmu/walking/left_3.png"));
            left4 = ImageIO.read(new File("resources/player/youmu/walking/left_4.png"));
            right1 = ImageIO.read(new File("resources/player/youmu/walking/right_1.png"));
            right2 = ImageIO.read(new File("resources/player/youmu/walking/right_2.png"));
            right3 = ImageIO.read(new File("resources/player/youmu/walking/right_3.png"));
            right4 = ImageIO.read(new File("resources/player/youmu/walking/right_4.png"));

            r_up1 = ImageIO.read(new File("resources/player/youmu/rolling/up_1.png"));
            r_up2 = ImageIO.read(new File("resources/player/youmu/rolling/up_2.png"));
            r_up3 = ImageIO.read(new File("resources/player/youmu/rolling/up_3.png"));
            r_up4 = ImageIO.read(new File("resources/player/youmu/rolling/up_4.png"));
            r_up_left1 = ImageIO.read(new File("resources/player/youmu/rolling/up_left_1.png"));
            r_up_left2 = ImageIO.read(new File("resources/player/youmu/rolling/up_left_2.png"));
            r_up_left3 = ImageIO.read(new File("resources/player/youmu/rolling/up_left_3.png"));
            r_up_left4 = ImageIO.read(new File("resources/player/youmu/rolling/up_left_4.png"));
            r_up_right1 = ImageIO.read(new File("resources/player/youmu/rolling/up_right_1.png"));
            r_up_right2 = ImageIO.read(new File("resources/player/youmu/rolling/up_right_2.png"));
            r_up_right3 = ImageIO.read(new File("resources/player/youmu/rolling/up_right_3.png"));
            r_up_right4 = ImageIO.read(new File("resources/player/youmu/rolling/up_right_4.png"));
            r_down1 = ImageIO.read(new File("resources/player/youmu/rolling/down_1.png"));
            r_down2 = ImageIO.read(new File("resources/player/youmu/rolling/down_2.png"));
            r_down3 = ImageIO.read(new File("resources/player/youmu/rolling/down_3.png"));
            r_down4 = ImageIO.read(new File("resources/player/youmu/rolling/down_4.png"));
            r_down_left1 = ImageIO.read(new File("resources/player/youmu/rolling/down_left_1.png"));
            r_down_left2 = ImageIO.read(new File("resources/player/youmu/rolling/down_left_2.png"));
            r_down_left3 = ImageIO.read(new File("resources/player/youmu/rolling/down_left_3.png"));
            r_down_left4 = ImageIO.read(new File("resources/player/youmu/rolling/down_left_4.png"));
            r_down_right1 = ImageIO.read(new File("resources/player/youmu/rolling/down_right_1.png"));
            r_down_right2 = ImageIO.read(new File("resources/player/youmu/rolling/down_right_2.png"));
            r_down_right3 = ImageIO.read(new File("resources/player/youmu/rolling/down_right_3.png"));
            r_down_right4 = ImageIO.read(new File("resources/player/youmu/rolling/down_right_4.png"));
            r_left1 = ImageIO.read(new File("resources/player/youmu/rolling/left_1.png"));
            r_left2 = ImageIO.read(new File("resources/player/youmu/rolling/left_2.png"));
            r_left3 = ImageIO.read(new File("resources/player/youmu/rolling/left_3.png"));
            r_left4 = ImageIO.read(new File("resources/player/youmu/rolling/left_4.png"));
            r_right1 = ImageIO.read(new File("resources/player/youmu/rolling/right_1.png"));
            r_right2 = ImageIO.read(new File("resources/player/youmu/rolling/right_2.png"));
            r_right3 = ImageIO.read(new File("resources/player/youmu/rolling/right_3.png"));
            r_right4 = ImageIO.read(new File("resources/player/youmu/rolling/right_4.png"));

            a_right_1 = ImageIO.read(new File("resources/player/youmu/attacking/right_1.png"));
            a_right_2 = ImageIO.read(new File("resources/player/youmu/attacking/right_2.png"));
            a_right_3 = ImageIO.read(new File("resources/player/youmu/attacking/right_3.png"));
            a_right_4 = ImageIO.read(new File("resources/player/youmu/attacking/right_4.png"));
            a_left_1 = ImageIO.read(new File("resources/player/youmu/attacking/left_1.png"));
            a_left_2 = ImageIO.read(new File("resources/player/youmu/attacking/left_2.png"));
            a_left_3 = ImageIO.read(new File("resources/player/youmu/attacking/left_3.png"));
            a_left_4 = ImageIO.read(new File("resources/player/youmu/attacking/left_4.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void attack() {
    }

    public void update() {

        animationSpeed = 15;
        speed = 2;

        if (keyHandler.shiftPressed) {
            speed = 4;
            animationSpeed = 8;
        }
        if (keyHandler.xPressed) {
            speed = 1;
            animationSpeed = 20;
        }
        // Walking action
        if (keyHandler.leftPressed || keyHandler.rightPressed || keyHandler.downPressed || keyHandler.upPressed) {

            if (keyHandler.upPressed) {
                cardinalDirection = "up";
                direction = cardinalDirection;

                if (keyHandler.leftPressed) {
                    direction = "up_left";
                } else if (keyHandler.rightPressed) {
                    direction = "up_right";
                }
            }

            if (keyHandler.downPressed) {
                cardinalDirection = "down";
                direction = cardinalDirection;

                if (keyHandler.leftPressed) {
                    direction = "down_left";
                } else if (keyHandler.rightPressed) {
                    direction = "down_right";
                }
            }
            if (keyHandler.leftPressed) {
                cardinalDirection = "left";
                direction = cardinalDirection;

                if (keyHandler.upPressed) {
                    direction = "up_left";
                } else if (keyHandler.downPressed) {
                    direction = "down_left";
                }
            }
            if (keyHandler.rightPressed) {
                cardinalDirection = "right";
                direction = cardinalDirection;

                if (keyHandler.upPressed) {
                    direction = "up_right";
                } else if (keyHandler.downPressed) {
                    direction = "down_right";
                }
            }

            // Rolling action
            if (keyHandler.spacePressed && !isRolling) {
                isRolling = true;
                spriteNumber = 1;
                animationSpeed /= 4;
                keyHandler.spacePressed = false;
            }

            isColliding = false;
            gamePanel.collisionHandler.checkTile(this);

            if (isColliding == false) {
                if (direction == "up" || direction == "up_left" || direction == "up_right") {
                    y -= speed;
                }
                if (direction == "left" || direction == "up_left" || direction == "down_left") {
                    x -= speed;
                }
                if (direction == "down" || direction == "down_left" || direction == "down_right") {
                    y += speed;
                }
                if (direction == "right" || direction == "up_right" || direction == "down_right") {
                    x += speed;
                }
            }
        }
        else {
            isRolling = false;
            keyHandler.spacePressed = false;
        }

        // Attacking action
        if (keyHandler.xPressed && !isAttacking) {
            isAttacking = true;
            attack();
            spriteNumber = 1;
            speed = 0;
            keyHandler.xPressed = false;
        }

        if (!keyHandler.upPressed && !keyHandler.downPressed && !keyHandler.leftPressed && !keyHandler.rightPressed && !isAttacking) {
            spriteNumber = 1;
        } else {

            spriteCounter++;
            if (spriteCounter > animationSpeed) {
                spriteCounter = 0;
                spriteNumber++;
                if (spriteNumber == 5) {
                    spriteNumber = 1;
                    isRolling = false;
                    isAttacking = false;
                }
            }
        }

        hitbox.setLocation(x+8, y+18);
    }




    public void render(Graphics2D g2) {

        BufferedImage image = null;
        int playerWidth = gamePanel.tileSize;
        int playerHeight = gamePanel.tileSize;

        if (direction == "up" || direction == "up_left" || direction == "up_right")
            {
                switch (direction) {
                    case "up_left":
                        if (spriteNumber == 1) {
                            image = isRolling == true ? r_up_left1 : up_left1;
                        } else if (spriteNumber == 2) {
                            image = isRolling == true ? r_up_left2 : up_left2;
                        } else if (spriteNumber == 3) {
                            image = isRolling == true ? r_up_left3 : up_left3;
                        } else if (spriteNumber == 4) {
                            image = isRolling == true ? r_up_left4 : up_left4;
                        }
                        break;
                    case "up_right":
                        if (spriteNumber == 1) {
                            image = isRolling == true ? r_up_right1 : up_right1;
                        } else if (spriteNumber == 2) {
                            image = isRolling == true ? r_up_right2 : up_right2;
                        } else if (spriteNumber == 3) {
                            image = isRolling == true ? r_up_right3 : up_right3;
                        } else if (spriteNumber == 4) {
                            image = isRolling == true ? r_up_right4 : up_right4;
                        }
                        break;
                    default:
                        if (spriteNumber == 1) {
                            image = isRolling == true ? r_up1 : up1;
                        } else if (spriteNumber == 2) {
                            image = isRolling == true ? r_up2 : up2;
                        } else if (spriteNumber == 3) {
                            image = isRolling == true ? r_up3 : up3;
                        } else if (spriteNumber == 4) {
                            image = isRolling == true ? r_up4 : up4;
                        }
                        break;
                }

            }
        if (direction == "down" || direction == "down_left" || direction == "down_right") {
            switch (direction) {
                case "down_left":
                    if (spriteNumber == 1) {
                        image = isRolling == true ? r_down_left1 : down_left1;
                    } else if (spriteNumber == 2) {
                        image = isRolling == true ? r_down_left2 : down_left2;
                    } else if (spriteNumber == 3) {
                        image = isRolling == true ? r_down_left3 : down_left3;
                    } else if (spriteNumber == 4) {
                        image = isRolling == true ? r_down_left4 : down_left4;
                    }
                    break;
                case "down_right":
                    if (spriteNumber == 1) {
                        image = isRolling == true ? r_down_right1 : down_right1;
                    } else if (spriteNumber == 2) {
                        image = isRolling == true ? r_down_right2 : down_right2;
                    } else if (spriteNumber == 3) {
                        image = isRolling == true ? r_down_right3 : down_right3;
                    } else if (spriteNumber == 4) {
                        image = isRolling == true ? r_down_right4 : down_right4;
                    }
                    break;
                default:
                    if (spriteNumber == 1) {
                        image = isRolling == true ? r_down1 : down1;
                    } else if (spriteNumber == 2) {
                        image = isRolling == true ? r_down2 : down2;
                    } else if (spriteNumber == 3) {
                        image = isRolling == true ? r_down3 : down3;
                    } else if (spriteNumber == 4) {
                        image = isRolling == true ? r_down4 : down4;
                    }
                    break;
            }
        }
        if (direction == "left")
        {
            if (spriteNumber == 1) {
                image = isRolling == true ? r_left1 : left1;
            } else if (spriteNumber == 2) {
                image = isRolling == true ? r_left2 : left2;
            } else if (spriteNumber == 3) {
                image = isRolling == true ? r_left3 : left3;
            } else if (spriteNumber == 4) {
                image = isRolling == true ? r_left4 : left4;
            }
        }

        if (direction == "right")
        {
            if (spriteNumber == 1) {
                image = isRolling == true ? r_right1 : right1;
            }
            else if (spriteNumber == 2) {
                image = isRolling == true ? r_right2 : right2;
            }
            else if (spriteNumber == 3) {
                image = isRolling == true ? r_right3 : right3;
            }
            else if (spriteNumber == 4) {
                image = isRolling == true ? r_right4 : right4;
            }
        }
        if (isAttacking == true) {
            playerWidth += 10;

            if (cardinalDirection == "up" || cardinalDirection == "left") {
                if (spriteNumber == 1) {
                    image = a_left_1;
                }
                else if (spriteNumber == 2) {
                    image = a_left_2;
                }
                else if (spriteNumber == 3) {
                    image = a_left_3;
                }
                else if (spriteNumber == 4) {
                    image = a_left_4;
                }
            }
            else if (cardinalDirection == "down" || cardinalDirection == "right") {
                if (spriteNumber == 1) {
                    image = a_right_1;
                }
                else if (spriteNumber == 2) {
                    image = a_right_2;
                }
                else if (spriteNumber == 3) {
                    image = a_right_3;
                }
                else if (spriteNumber == 4) {
                    image = a_right_4;
                }
            }

        }

        g2.drawImage(image, x, y, playerWidth, playerHeight, null);
        g2.setColor(Color.RED);
        g2.fill(hitbox);

    }

}
