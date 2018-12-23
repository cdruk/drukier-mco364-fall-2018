package drukier.paint.save;

import drukier.paint.Canvas;
import drukier.paint.shapes.Shape;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static java.awt.image.BufferedImage.TYPE_INT_ARGB;

public class SaveImage {

    private int imageSize;
    private drukier.paint.Canvas canvas;
    private BufferedImage painting;
    private String fileName;

    public SaveImage(int canvasSize, Canvas canvas, String fileName) {
        imageSize = canvasSize;
        this.canvas = canvas;
        painting = new BufferedImage(imageSize, imageSize, TYPE_INT_ARGB);
        this.fileName = fileName;
//        paintImage();
        saveImage();
    }

//    private void paintImage() {
//        Graphics2D g = painting.createGraphics();
//        g.setColor(Color.WHITE);
//        g.fillRect(0, 0, imageSize, imageSize);
//        for (Shape shape : canvas.getShapes()) {
//            shape.paint();
//        }
//    }

    private void saveImage() {
        try {
            File outputFile = new File(fileName);
            ImageIO.write(painting, "png", outputFile);
        } catch (IOException e) {
            System.out.println("Save failed");
        }
    }
}
