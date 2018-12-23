package drukier.paint.shapes;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.Serializable;

public abstract class Shape implements Serializable {

    private Color color;

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void paint(BufferedImage image, Graphics imageGraphics){
        imageGraphics.setColor(getColor());
    }
}

