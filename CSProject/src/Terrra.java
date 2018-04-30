import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Terrra extends Application {
	

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch();
	}
	
	private BallControl circle1 = new BallControl();
	Image ship1 = new Image("http://www.freepngimg.com/thumb/spaceship/24752-5-spaceship-thumb.png");
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		circle1.setFill(new ImagePattern(ship1));
		circle1.setStroke(Color.ANTIQUEWHITE);

		
		//Shots 
		//Circle shots = new Circle(50, 30, 10);
		//shots.setFill(Color.YELLOW);
		//shots.setLayoutX(circle.getCenterX());
	
		
		HBox pfb = new HBox(10);
		pfb.setAlignment(Pos.CENTER);
		Button left = new Button("Left");// new ImageView("http://freevector.co/wp-content/uploads/2014/09/55152-left-arrow.png"));
		Button right = new Button("Right");//, new ImageView("https://t5.rbxcdn.com/3856a8135179ca5ccd25c88b3243207e"));
		pfb.getChildren().addAll(left, right);
		pfb.setStyle("-fx-border-color: blue");
		
		left.setOnAction(new handler1());
		right.setOnAction(new handler2());
	
		
	
		/*GridPane gp = new GridPane();
		circlepane.setLayoutX(250.0f);
		shots.setLayoutX(250.0f);
		shots.setLayoutY(170.0f);
		gp.getChildren().addAll(circlepane, shots);
		gp.setAlignment(Pos.BOTTOM_CENTER);
		*/
	
		
		BorderPane borderPane = new BorderPane();
		borderPane.setBottom(pfb);
		borderPane.setCenter(circle1);
		
		Scene scene = new Scene(borderPane, 450, 300);
		primaryStage.setTitle("Galaga");
		primaryStage.setScene(scene);
		primaryStage.show();

	}
	class handler1 implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent arg0) {
			// TODO Auto-generated method stub
			circle1.left();
		}
		
	}
	class handler2 implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
			// TODO Auto-generated method stub
			circle1.right();
		}
		
	}
	class BallControl extends Pane {
	      public final double radius = 20;
	      private double x = radius, y = radius;
	      private double dx = 1, dy = 1;
	      private Circle circle = new Circle();
	      Image ship1 = new Image("http://www.freepngimg.com/thumb/spaceship/24752-5-spaceship-thumb.png");
	      private Circle shots = new Circle();
	      
	      public BallControl() {
	        getChildren().addAll(circle, shots);
	        circle.setCenterX(225.0f);
	        circle.setCenterY(250.0f);
	        circle.setRadius(20.0f);
	        circle.setStroke(Color.TRANSPARENT);
	        circle.setFill(new ImagePattern(ship1));
	        shots.setCenterX(225.0f);
	        shots.setCenterY(210.0f);
	        shots.setRadius(10);
	        shots.setFill(Color.YELLOW);
	        shots.setStroke(Color.BLACK);
	        
	      }

	      public void setStroke(Color antiquewhite) {
			// TODO Auto-generated method stub
			
		}

		public void setFill(ImagePattern imagePattern) {
			// TODO Auto-generated method stub
			
		}

		protected void moveBall() {
	        // Check boundaries
	        if (x < radius || x > getWidth() - radius) {
	          dx = 0; // Change ball move direction
	        }
	        if (y < radius || y > getHeight() - radius) {
	          dy = 0; // Change ball move direction
	        }

	        // Adjust ball position
	        x += dx;
	        y += dy;
	        circle.setCenterX(x);
	        circle.setCenterY(y);
	        shots.setCenterX(x);
	        shots.setCenterX(y);
	      }   
	     
	      public void left() {
	        circle.setCenterX(circle.getCenterX() - 10);
	        shots.setCenterX(circle.getCenterX()- 10);
	      }       
	      public void right() {
	        circle.setCenterX(circle.getCenterX() + 10);
	        shots.setCenterX(circle.getCenterX()+ 10);
	      }
	      }

	/* class CirclePane extends StackPane{
		
		
		Image ship1 = new Image("http://www.freepngimg.com/thumb/spaceship/24752-5-spaceship-thumb.png");
		Circle circle = new Circle(50,30,20);
		Circle shots = new Circle(50, 30, 10);
	
		
		public CirclePane() {
			getChildren().add(circle);
			circle.setFill(new ImagePattern(ship1));
			circle.setStroke(Color.ANTIQUEWHITE);
		}
		public void left() {
			circle.setCenterX(circle.getCenterX() - 10);
			if (circle.getCenterX() <= 0) {
				
			}
			shots.setCenterX(circle.getCenterX() - 10);
		}
		public void right() {
			circle.setCenterX(circle.getCenterX() + 10);
			if (circle.getCenterX() >= 450) {
				
			}
			shots.setCenterX(circle.getCenterX() + 10);

	}
	// Attach shots/ path to position of circle 	
		
  }
  */
}

/*protected BorderPane getPane() {
ship.setFitHeight(30);
ship.setFitWidth(45);

Pane c = new HBox();
Circle circle = new Circle(50,30,20);
circle.setFill(new ImagePattern(ship1));
circle.setStroke(Color.ANTIQUEWHITE);
circlepane.getChildren().add(circle);
c.getChildren().add(circle);
c.setParent(Pos.BOTTOM_CENTER);


HBox pfb = new HBox(10);
Button left = new Button("Left");// new ImageView("http://freevector.co/wp-content/uploads/2014/09/55152-left-arrow.png"));
Button right = new Button("Right");//, new ImageView("https://t5.rbxcdn.com/3856a8135179ca5ccd25c88b3243207e"));
pfb.getChildren().addAll(left, right);
pfb.setAlignment(Pos.CENTER);
pfb.setStyle("-fx-border-color: blue");

Pane paneForShip = new Pane();
paneForShip.getChildren().addAll(ship);


BorderPane pane = new BorderPane();
pane.setBottom(pfb);
pane.setStyle("-fx-background-color: black");
pane.setCenter(c);




//How do I link the left and right buttons to the main car node? Do I need to make a line path?
//
left.setOnAction(new handler1());
//car.setX(car.getX() - 10);
right.setOnAction(new handler2());

//right.setOnAction(e -> ship.setX(ship.getX() + 10));

return pane;
} */


