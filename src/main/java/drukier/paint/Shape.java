package drukier.paint;

import java.awt.*;

public abstract class Shape {

    private Color color;

    private Tool tool;

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Tool getTool() {
        return tool;
    }

    public void setTool(Tool tool) {
        this.tool = tool;
    }

    public void paint(Graphics g){
        g.setColor(getColor());
    }
}

