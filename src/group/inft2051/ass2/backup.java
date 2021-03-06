package group.inft2051.ass2;

import com.codename1.ui.Graphics;
import com.codename1.ui.Image;
import com.nlcode.cn1.core.Game;
import com.nlcode.cn1.core.ResourceManager;
import com.nlcode.cn1.core.graphics.Animation;
import com.nlcode.cn1.core.graphics.TileMap;
import com.nlcode.cn1.core.input.Keyboard;
import com.nlcode.cn1.core.input.Screenpad;
import com.nlcode.cn1.core.input.ScreenpadSpriteButton;
import group.inft2051.ass2.sprites.*;

public class backup extends Game
{
    Plumber plumber;
    TileMap stage;

    public backup(int width, int height) {
        super(width, height, true, true);
    }

    @Override
    public void init() {
        Image background = null;
        background = ResourceManager.loadImage("/bg_01.png");
        plumber = new PlumberNormal();
        stage = new TileMap(
                this, "/mapa_1-1.csv",
                new PlumberSpriteFactory(),
                background, plumber, 10, 10);
        //stage.setVerticalScrolling(TileMap.Scrolling.END);
        ResourceManager.loadSound("/bg_01.mp3").play();

        //On screen pad
        createDPad(100, 165);
        //On screen buttons
        createButtons(400, 165);
    }

    @Override
    public void update(long time) {
        //A keyCode or Xperia Play's X or Screenbutton 1
        boolean correr = false;
        if (this.getCurrentKeyboardState().isKeyDown(Keyboard.Key.A)
                || this.getCurrentKeyboardState().isKeyDown(Keyboard.Key.XPERIA_PLAY_X)
                || this.getCurrentScreenpadState().isButtonDown(Screenpad.Button.B1)) {
            correr = true;
        }
        this.plumber.setSpeedX(0);
        //Left key/button
        if (this.getCurrentKeyboardState().isKeyDown(Keyboard.Key.LEFT)
                || this.getCurrentKeyboardState().isKeyDown(Keyboard.Key.XPERIA_PLAY_LEFT)
                || this.getCurrentScreenpadState().isButtonDown(Screenpad.Button.LEFT)) {
            this.plumber.setDireccion(Plumber.Direction.LEFT);
            this.plumber.setSpeedX(plumber.getSpeedX() - this.plumber.getVelocidad());
            if (correr) {
                this.plumber.setSpeedX(plumber.getSpeedX() * 2);
            }
        }
        //Right key/button
        if (this.getCurrentKeyboardState().isKeyDown(Keyboard.Key.RIGHT)
                || this.getCurrentKeyboardState().isKeyDown(Keyboard.Key.XPERIA_PLAY_RIGHT)
                || this.getCurrentScreenpadState().isButtonDown(Screenpad.Button.RIGHT)) {
            this.plumber.setDireccion(Plumber.Direction.RIGHT);
            this.plumber.setSpeedX(this.plumber.getVelocidad());
            if (correr) {
                this.plumber.setSpeedX(plumber.getSpeedX() * 2);
            }
        }
        //X keyCode or Xperia Play's Circle or ScreenButton 2
        if (this.getCurrentKeyboardState().isKeyDown(Keyboard.Key.X)
                || this.getCurrentKeyboardState().isKeyDown(Keyboard.Key.XPERIA_PLAY_CIRCLE)
                || this.getCurrentScreenpadState().isButtonDown(Screenpad.Button.B2)) {
            this.plumber.saltar();
        }
        //Update plumber states
        if (!this.plumber.getState().equals(Plumber.State.JUMPING)) {
            if (this.plumber.getSpeedX() != 0) {
                this.plumber.setState(Plumber.State.WALKING);
            } else {
                this.plumber.setState(Plumber.State.STANDING);
            }
        }
        stage.update(time);
    }

    @Override
    public void draw(Graphics g, int width, int height) {
        stage.draw(g, width, height);

        // On screen debug values
        /*g.drawString("plumber x:" + plumber.getX(), 10, 10);
         g.drawString("plumber y:" + plumber.getY(), 10, 30);
         g.drawString("plumber vx:" + plumber.getSpeedX(), 10, 50);
         g.drawString("plumber vy:" + plumber.getSpeedY(), 10, 70);
         g.drawString("Sprites:" + stage.getSprites().size(), 10, 100);
         g.drawString("Touch x:" + getCurrentTouchPanelState().getTouchLocations()[0].getPosition().getX(), 10, 130);
         g.drawString("Touch y:" + getCurrentTouchPanelState().getTouchLocations()[0].getPosition().getY(), 10, 160);
         g.drawString("Touch state:" + getCurrentTouchPanelState().getTouchLocations()[0].getState().name(), 10, 190);*/
    }

    @Override
    public void destroy() {
    }

    public void createDPad(int x, int y) {
        ScreenpadSpriteButton upButton = new ScreenpadSpriteButton(
                this,
                x,
                y,
                new Animation(ResourceManager.loadImage("/vk_d_up.png")),
                new Animation(ResourceManager.loadImage("/vk_up.png")),
                Screenpad.Button.UP);
        ScreenpadSpriteButton leftButton = new ScreenpadSpriteButton(
                this,
                (int) upButton.getX() - upButton.getHeight() + 16,
                (int) upButton.getY() + upButton.getHeight() - 15,
                new Animation(ResourceManager.loadImage("/vk_d_left.png")),
                new Animation(ResourceManager.loadImage("/vk_left.png")),
                Screenpad.Button.LEFT);
        ScreenpadSpriteButton rightButton = new ScreenpadSpriteButton(
                this,
                (int) upButton.getX() + upButton.getWidth() - 15,
                (int) upButton.getY() + upButton.getHeight() - 14,
                new Animation(ResourceManager.loadImage("/vk_d_right.png")),
                new Animation(ResourceManager.loadImage("/vk_right.png")),
                Screenpad.Button.RIGHT);
        ScreenpadSpriteButton downButton = new ScreenpadSpriteButton(
                this,
                (int) upButton.getX() - 1,
                (int) leftButton.getY() + leftButton.getHeight() - 15,
                new Animation(ResourceManager.loadImage("/vk_d_down.png")),
                new Animation(ResourceManager.loadImage("/vk_down.png")),
                Screenpad.Button.DOWN);
        this.getCanvas().getScreenpadSpriteButtons().add(upButton);
        this.getCanvas().getScreenpadSpriteButtons().add(leftButton);
        this.getCanvas().getScreenpadSpriteButtons().add(rightButton);
        this.getCanvas().getScreenpadSpriteButtons().add(downButton);
    }
    public void createButtons(int x, int y) {
        ScreenpadSpriteButton triangleButton = new ScreenpadSpriteButton(
                this,
                x,
                y,
                new Animation(ResourceManager.loadImage("/vk_d_triangle.png")),
                new Animation(ResourceManager.loadImage("/vk_triangle.png")),
                Screenpad.Button.B1);
        ScreenpadSpriteButton circleButton = new ScreenpadSpriteButton(
                this,
                (int) triangleButton.getX() + triangleButton.getHeight() + 16,
                (int) triangleButton.getY() + triangleButton.getHeight() - 15,
                new Animation(ResourceManager.loadImage("/vk_d_circle.png")),
                new Animation(ResourceManager.loadImage("/vk_circle.png")),
                Screenpad.Button.B2);
        this.getCanvas().getScreenpadSpriteButtons().add(triangleButton);
        this.getCanvas().getScreenpadSpriteButtons().add(circleButton);
    }
}
