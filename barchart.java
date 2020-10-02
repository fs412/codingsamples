/* **14.12 (Display a bar chart) Write a program that uses a bar chart
to display the percentages of the overall grade represented by
projects, quizzes, midterm exams, and the final exam, as shown in
Figure 14.46b . Suppose projects take 20 % and are displayed
in red, quizzes take 10 % and are displayed in blue, midterm
exams take 30 % and are displayed in green, and the final exam
takes 40 % and is displayed in orange. Use the Rectangle class to
display the bar. Interested readers may explore the JavaFX
BarChart class for further study. 
*/

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class barchart extends Application {
    private static final double WIDTH = 400;
    private static final double HEIGHT = 400;
    private static final double LIMIT_HEIGHT = (HEIGHT / 2);
    private static double[] percent = new double[]{0.20, 0.10, 0.30, 0.40};
    private static String[] titles = new String[] {
            "Project - " + String.format("%d%s", (int)(100 * percent[0]), "%"),
            "Quizzes - " + String.format("%d%s", (int)(100 * percent[1]), "%"),
            "Midterm - " + String.format("%d%s", (int)(100 * percent[2]), "%"),
            "Final - "+ String.format("%d%s", (int)(100 * percent[3]), "%")
    };

    private static Color[] colors = new Color[]{Color.RED, Color.BLUE, Color.GREEN, Color.ORANGE};

    @Override
    public void start(Stage primaryStage) {

        Pane pane = new Pane();
        pane.setPadding(new Insets(5, 10, 0, 10));
        Rectangle[] barcharts = new Rectangle[4];

        for (int i = 0; i < barcharts.length; i++) {
            barcharts[i] = new Rectangle(
                    5 + (100 * i), 
                    LIMIT_HEIGHT - (HEIGHT * percent[i]), 
                    WIDTH / barcharts.length - 5, 
                    HEIGHT * percent[i]); 
            barcharts[i].setFill(colors[i]);
            Text text = new Text(5 + (100 * i),LIMIT_HEIGHT - (HEIGHT * percent[i]) - 5,titles[i]);
            pane.getChildren().addAll(text, barcharts[i]);

        }

        primaryStage.setScene(new Scene(pane, WIDTH + 20, LIMIT_HEIGHT));
        primaryStage.setTitle("Bar graph");
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }



}