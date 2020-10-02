/* 14.1 (Display images) Write a program that displays four images in
a grid pane, as shown in Figure 14.43a. */


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
public class flag extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane pane = new GridPane();
        pane.setHgap(5);
        pane.setVgap(5);
        Image canada = new Image("canada.gif");
        Image china = new Image("china.gif");
        Image uk = new Image("uk.gif");
        Image america = new Image("america.gif");
        ImageView imagecanada = new ImageView(canada);
        imagecanada.setFitWidth(232);
        imagecanada.setFitHeight(138);
        ImageView imagechina = new ImageView(china);
        imagechina.setFitWidth(232);
        imagechina.setFitHeight(138);
        ImageView imageuk = new ImageView(uk);
        imageuk.setFitWidth(232);
        imageuk.setFitHeight(138);
        ImageView imageamerica = new ImageView(america);
        imageamerica.setFitWidth(232);
        imageamerica.setFitHeight(138);

        pane.add(imagecanada, 0, 0);
        pane.add(imagechina, 1, 0);
        pane.add(imageuk, 0, 1);
        pane.add(imageamerica, 1, 1);
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Display images - 14.1");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
    public static void main(String[] args) {
        Application.launch(args);
    }
}
