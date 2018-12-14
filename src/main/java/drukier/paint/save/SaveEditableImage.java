package drukier.paint.save;

import drukier.paint.Canvas;
import drukier.paint.shapes.Shape;

import java.io.*;
import java.util.ArrayList;

public class SaveEditableImage {

    private String fileName;
    private ArrayList<Shape> shapes;

    public SaveEditableImage(Canvas canvas, String fileName) {
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
