package drukier.paint;

import javax.imageio.ImageIO;
import java.io.*;
import java.util.ArrayList;

public class SaveEditableImage {

    private Canvas canvas;
    private String fileName;
    private ArrayList<Shape> shapes;

    public SaveEditableImage(Canvas canvas, String fileName) {
        this.canvas = canvas;
        this.fileName = fileName;
        shapes = canvas.getShapes();

        saveAsPaint();
    }

    private void saveAsPaint() {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fileName);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(shapes);

            objectOutputStream.close();
        } catch (IOException e){
            System.out.println("Save failed");
        }
    }

}
