package drukier.paint.shapes;

import java.awt.*;
import java.io.Serializable;

public abstract class Shape implements Serializable {

    private Color color;

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void paint(Graphics g){
        g.setColor(getColor());
    }
}

