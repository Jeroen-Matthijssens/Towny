package graphics.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import graphics.OpenglUtils;
import graphics.ui.icon.Icon;
import input.MouseButton;
import input.MousePosition;
import main.Game;

import static org.lwjgl.glfw.GLFW.GLFW_MOUSE_BUTTON_LEFT;

public class TopBar {
    private int x, y; // x and y of the top left corner
    private int width, height; // width and height
    private int vilcount, solcount; // amount of villagers and soldiers
    private int solId,vilId,pauseId,playId,fastId,slowId;
    private int vilSize;
    private int slowWidth, slowHeight;
    private int pauseWidth, pauseHeight;
    private int playWidth, playHeight;
    private static final Color COL = new Color(91, 94, 99, 110); // the colour of the background
    private static final Font font = new Font("Dialog", Font.BOLD, 15);
    private boolean paused; // is the game paused
    private byte speed = 6;

    // constructor
    TopBar() {
        width = 270;
        height = 82;
        this.x = (Game.width*Game.SCALE-width)/2;
        this.y = 5;
        init();
    }

    // intialise
    private void init() {
        try {
            BufferedImage solimg = ImageIO.read(Icon.class.getResource("/res/icons/soldier.png"));
            vilSize = solimg.getWidth();
            solId = loadImage(solimg);
            vilId = loadImage(ImageIO.read(Icon.class.getResource("/res/icons/villager.png")));
            BufferedImage pauseimg = ImageIO.read(Icon.class.getResource("/res/icons/pause.png"));
            pauseId = loadImage(pauseimg);
            pauseWidth = pauseimg.getWidth();
            pauseHeight = pauseimg.getHeight();
            BufferedImage slowimg = ImageIO.read(Icon.class.getResource("/res/icons/slow.png"));
            slowId = loadImage(slowimg);
            slowWidth = slowimg.getWidth();
            slowHeight = slowimg.getHeight();
            fastId = loadImage(ImageIO.read(Icon.class.getResource("/res/icons/fast.png")));
            BufferedImage playimg = ImageIO.read(Icon.class.getResource("/res/icons/play.png"));
            playId = loadImage(playimg);
            playWidth = playimg.getWidth();
            playHeight = playimg.getHeight();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private int loadImage(BufferedImage image) throws IOException{
        int[] pixels = new int[image.getWidth() * image.getHeight()];
        image.getRGB(0, 0, image.getWidth(), image.getHeight(), pixels, 0, image.getWidth());
        return OpenglUtils.loadTexture(pixels,image.getWidth(),image.getHeight());

    }

    // update the villager and soldier counts
    public void updateCounts(int solcount, int vilcount) {
        this.solcount = solcount;
        this.vilcount = vilcount;
    }

    public void update() {
        if (clickedOnPause()) {
            togglePause();
        } else if (clickedOnFast()) {
            upSpeed();
        } else if (clickedOnSlow()) {
            downSpeed();
        }
    }

    public byte getSpeed() {
        if (speed == 0)
            return 6;
        return speed;
    }

    private void upSpeed() {
        if (speed < 9)
            speed++;
    }

    private void downSpeed() {
        if (speed > 3)
            speed--;
    }

    // render the topbar on the screen
    public void render() {
        OpenglUtils.drawFilledSquare(x,y,width,height,COL.getRed()/255f,COL.getGreen()/255f,COL.getBlue()/255f,COL.getAlpha()/255f);
        OpenglUtils.drawTexturedQuad(x+10,y+17, vilSize,vilSize,vilId);
        OpenglUtils.drawTexturedQuad(x+210,y+17, vilSize,vilSize,solId);
        OpenglUtils.drawTexturedQuad(x+75,y+30,slowWidth,slowHeight,slowId);
        OpenglUtils.drawTexturedQuad(x+160,y+30,slowWidth,slowHeight,fastId);
        if (!paused) {
            OpenglUtils.drawTexturedQuad(x+125,y+25,pauseWidth,pauseHeight,pauseId);
        } else {
            OpenglUtils.drawTexturedQuad(x+125,y+25,playWidth,playHeight,playId);
        }
        /*g.setColor(COL);
        g.setFont(font);
        g.setColor(Color.black);
        g.drawString("Villagers", x * Game.SCALE + 10, y * Game.SCALE + 12);
        g.drawString(vilcount + "", x * Game.SCALE + 30, y * Game.SCALE + 82);
        g.drawString("Speed: " + (speed - 2), x * Game.SCALE + 105, y * Game.SCALE + 25);
        g.drawString("Soldiers", x * Game.SCALE + (width >> 1) + 70, y * Game.SCALE + 12);
        g.drawString(solcount + "", x * Game.SCALE + (width >> 1) + 90, y * Game.SCALE + 82);
*/
    }

    // has the user clicked on the pause button
    private boolean clickedOnPause() {
        return (MousePosition.getTrueXPixels() >= x * Game.SCALE + (width / 3) + 35
                && MousePosition.getTrueXPixels() <= x * Game.SCALE + (width / 3) + 35 + pauseWidth
                && MousePosition.getTrueYPixels() >= (y * Game.SCALE + 30) && MousePosition.getTrueYPixels() <= (y * Game.SCALE + 30) + 10//pauseimg.getHeight(null)
                && MouseButton.wasPressed(GLFW_MOUSE_BUTTON_LEFT));
    }

    private boolean clickedOnFast() {
        return (MousePosition.getTrueXPixels() >= x * Game.SCALE + (width >> 1) + 20
                && MousePosition.getTrueXPixels() <= x * Game.SCALE + (width >> 1) + 20 + slowWidth
                && MousePosition.getTrueYPixels() >= (y * Game.SCALE + 35) && MousePosition.getTrueYPixels() <= (y * Game.SCALE + 35) + 10//fastimg.getHeight(null)
                && MouseButton.wasPressed(GLFW_MOUSE_BUTTON_LEFT));
    }

    private boolean clickedOnSlow() {
        return (MousePosition.getTrueXPixels() >= x * Game.SCALE + (width >> 2) + 10
                && MousePosition.getTrueXPixels() <= x * Game.SCALE + (width >> 2) + 10 + slowWidth
                && MousePosition.getTrueYPixels() >= (y * Game.SCALE + 35) && MousePosition.getTrueYPixels() <= (y * Game.SCALE + 35) +10// slowimg.getHeight(null)
                && MouseButton.wasPressed(GLFW_MOUSE_BUTTON_LEFT));
    }

    // toggle pausing
    private void togglePause() {
        if (paused) {
            paused = false;
            speed = 6;
        } else {
            paused = true;
            speed = 0;
        }
    }

    // getter
    public boolean isPaused() {
        return paused;
    }

}
