package com.example.matrix;

import com.example.matrix.module.Matrix;
import com.example.matrix.module.MatrixException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        try {
            Matrix matrix = new Matrix(3, 3);
            matrix.fillRndDotZero();
            System.out.println(matrix.toString());
            matrix.addElementByIndex(4, 0, 12.2);
            System.out.println(matrix.toString());
            System.out.println(matrix.toString());
        } catch (MatrixException e) {
            System.out.println(e.cause());
        }
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 800);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}