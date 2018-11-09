package drukier.paint;

import java.awt.*;

public class Shape {

    private Color color;

    private PaintTool tool;

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public PaintTool getTool() {
        return tool;
    }

    public void setTool(PaintTool tool) {
        this.tool = tool;
    }
}
