package ee.taltech.iti0202.typegame;

import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextBoundsType;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class TypeGame extends Application {

    private static final HashMap<StackPane, String> symbols = new HashMap<>();
    private Pane root = new Pane();
    private String symbol;
    private int score;

    public static void main(String[] args) {
        launch(args);
    }

    private Color makeColor() {
        int red = ThreadLocalRandom.current().nextInt(100, 252);
        int green = ThreadLocalRandom.current().nextInt(100, 252);
        int blue = ThreadLocalRandom.current().nextInt(100, 252);
        return Color.rgb(red, green, blue);
    }

    private StackPane makeCircle() {
        Circle circle = new Circle(70, 70, 40);
        circle.setFill(makeColor());
        Random x = new Random();
        Random y = new Random();
        Random number = new Random();
        char c = (char) (number.nextInt(20) + 'a');
        symbol = String.valueOf(c);
        Text text = new Text(symbol);
        text.setBoundsType(TextBoundsType.VISUAL);
        text.setFont(Font.font("Impact", 20));
        StackPane stack = new StackPane();
        stack.setLayoutX(x.nextInt(250));
        stack.setLayoutY(y.nextInt(250));
        stack.getChildren().addAll(circle, text);
        return stack;
    }

    private StackPane makeScoreBoard() {
        Rectangle rectangle = new Rectangle(100, 30);
        rectangle.setFill(Color.WHITE);
        Text text = new Text("Score: " + score);
        text.setBoundsType(TextBoundsType.VISUAL);
        text.setFont(Font.font("Impact", 20));
        StackPane stack = new StackPane();
        stack.setLayoutX(300);
        stack.setLayoutY(0);
        stack.getChildren().addAll(rectangle, text);
        return stack;
    }

    private void makeCircles() {
        while (symbols.size() < 3) {
            StackPane circles = makeCircle();
            checkPosition(circles);
            Node scoreboard = makeScoreBoard();
            root.getChildren().addAll(scoreboard);
        }
    }

    private void checkPosition(StackPane circles) {
        boolean collisionDetected = false;
        for (Map.Entry < StackPane, String > j : symbols.entrySet()) {
            if (circles.getBoundsInParent().intersects(j.getKey().getBoundsInParent())) {
                collisionDetected = true;
            }
        }
        if (collisionDetected) {
            return;
        } else {
            symbols.put(circles, symbol);
            root.getChildren().add(circles);
        }
    }

    private void animation(StackPane pane) {
        FadeTransition circleAnimation = new FadeTransition(Duration.millis(1000), pane);
        circleAnimation.setFromValue(1.0);
        circleAnimation.setToValue(0.0);
        circleAnimation.setAutoReverse(true);
        Animation.Status animation = circleAnimation.getStatus();
        if (animation == Animation.Status.RUNNING) {
            root.getChildren().remove(pane);
            return;
        }
        if (animation == Animation.Status.STOPPED) {
            circleAnimation.play();
        }
    }

    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(root, 400, 400);
        primaryStage.setTitle("TypeGame");
        makeCircles();
        root.setOnKeyPressed(keyEvent -> {
                    if (symbols.containsValue(keyEvent.getText())) {
                        for (Map.Entry<StackPane, String> j : symbols.entrySet()) {
                            if (j.getValue().toLowerCase().equals(keyEvent.getText())) {
                                symbols.remove(j.getKey());
                                animation(j.getKey());
                                break;
                            }
                        }
                        while (symbols.size() < 3) {
                            StackPane circles = makeCircle();
                            checkPosition(circles);
                        }
                        score += 1;
                    } else {
                        score -= 1;
                    }
                    root.getChildren().addAll(makeScoreBoard());
                }
        );
        root.setFocusTraversable(true);
        root.requestFocus();
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
