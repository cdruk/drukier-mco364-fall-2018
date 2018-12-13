package drukier.paint.save;

import drukier.paint.Canvas;
import drukier.paint.shapes.Shape;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class OpenEditableImage {
    private Canvas canvas;
    private String fileName;
    private ArrayList<Shape> shapes = new ArrayList<>();

    public OpenEditableImage(Canvas canvas, String fileName) {
        this.canvas = canvas;
        this.fileName = fileName;

        openAsPaint();
    }

    private void openAsPaint() {
        try {
            FileInputStream fileInputStream = new FileInputStream(fileName);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            Object shape = objectInputStream.readObject();
            canvas.getShapes().clear();
            shapes.addAll((ArrayList<Shape>) shape);
            canvas.setShapes(shapes);
            objectInputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Open failed");
        }
    }
}
