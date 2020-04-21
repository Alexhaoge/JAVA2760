import javafx.animation.*;
import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.effect.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import javafx.util.*;

public class ColorfulCirclesDemo extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        Scene scene = new Scene(root, 800, 600, Color.BLACK);
        //Scene scene = new Scene(root, Color.BLACK);
        primaryStage.setScene(scene);

        Group circles = new Group();
        for(int i=0; i<30; i++){
            Circle circle = new Circle(150, Color.web("white", 0.05));
            circle.setStrokeType(StrokeType.OUTSIDE);
            circle.setStroke(Color.web("white",0.16));
            circle.setStrokeWidth(4);
            circles.getChildren().add(circle);
        }
        root.getChildren().add(circles);

        circles.setEffect(new BoxBlur(10, 10, 3));

        Rectangle colors = new Rectangle(scene.getWidth(), scene.getHeight(), 
            new LinearGradient(0f, 1f, 1f, 0f, true, CycleMethod.NO_CYCLE, 
                new Stop[]{
                    new Stop(0, Color.web("#f8bd55")),
                    new Stop(0.14, Color.web("#c0fe56")),
                    new Stop(0.28, Color.web("#5dfbc1")),
                    new Stop(0.42, Color.web("#64c2f8")),
                    new Stop(0.56, Color.web("#be4af7")),
                    new Stop(0.70, Color.web("#ed5fc2")),
                    new Stop(0.84, Color.web("#ef504c")),
                    new Stop(1, Color.web("#f2660f"))
                }
            )
        );
        root.getChildren().add(colors);

        Group blendModeGroup = new Group(
            new Group(
                new Rectangle(
                    scene.getWidth(), 
                    scene.getHeight(), 
                    Color.BLACK
                ),
                circles
            ),
            colors
        );
        colors.setBlendMode(BlendMode.OVERLAY);
        root.getChildren().add(blendModeGroup);
        
        Timeline timeline = new Timeline();
        for(Node circle: circles.getChildren()){
            timeline.getKeyFrames().addAll(
                new KeyFrame(Duration.ZERO, 
                    new KeyValue(circle.translateXProperty(), Math.random()*800),
                    new KeyValue(circle.translateYProperty(), Math.random()*600)
                ),
                new KeyFrame(new Duration(40000),
                    new KeyValue(circle.translateXProperty(), Math.random()*800),
                    new KeyValue(circle.translateYProperty(), Math.random()*600)
                )
            );
        }
        timeline.play();

        primaryStage.show();
    }

}