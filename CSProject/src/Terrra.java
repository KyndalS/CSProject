import java.util.Random;

import javafx.animation.PathTransition;
import javafx.scene.Node;
import javafx.animation.Timeline;
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
	
	@Override
	public void start(Stage primaryStage) throws Exception {

		
		HBox pfb = new HBox(10);
		pfb.setAlignment(Pos.CENTER);
		Button left = new Button("Left");// new ImageView("http://freevector.co/wp-content/uploads/2014/09/55152-left-arrow.png"));
		Button right = new Button("Right");//, new ImageView("https://t5.rbxcdn.com/3856a8135179ca5ccd25c88b3243207e"));
		pfb.getChildren().addAll(left, right);
		pfb.setStyle("-fx-border-color: blue");
		
		Pane pfAliens = new Pane();
		ImageView a1 = new ImageView(new Image("https://images.vectorhq.com/images/previews/413/alien-space-ship-icon-b-w-psd-438456.png"));
		ImageView a2 = new ImageView(new Image("https://images.vectorhq.com/images/previews/413/alien-space-ship-icon-b-w-psd-438456.png"));
		ImageView a3 = new ImageView(new Image("https://images.vectorhq.com/images/previews/413/alien-space-ship-icon-b-w-psd-438456.png"));
		ImageView a4 = new ImageView(new Image("https://images.vectorhq.com/images/previews/413/alien-space-ship-icon-b-w-psd-438456.png"));
		ImageView a5 = new ImageView(new Image("https://images.vectorhq.com/images/previews/413/alien-space-ship-icon-b-w-psd-438456.png"));
		a1.setPreserveRatio(true);
		a2.setPreserveRatio(true);
		a3.setPreserveRatio(true);
		a4.setPreserveRatio(true);
		a5.setPreserveRatio(true);
		
		a1.setFitHeight(20); 
		a2.setFitHeight(20); 
		a3.setFitHeight(20); 
		a4.setFitHeight(20); 
		a5.setFitHeight(20);
		a1.setFitWidth(20); 
		a2.setFitHeight(20); 
		a3.setFitHeight(20); 
		a4.setFitHeight(20); 
		a5.setFitHeight(20);
		
	//	alien1.setLayoutX(ran);
		/*ImageView alien6 = new ImageView(new Image("https://images.vectorhq.com/images/previews/413/alien-space-ship-icon-b-w-psd-438456.png"));
		ImageView alien4 = new ImageView(new Image("https://www.freeiconspng.com/uploads/spaceship-png-icon-5.png"));
		ImageView alien6 = new ImageView(new Image("https://images.vectorhq.com/images/previews/413/alien-space-ship-icon-b-w-psd-438456.png"));
		ImageView alien5 = new ImageView(new Image("https://www.freeiconspng.com/uploads/spaceship-png-icon-5.png"));
		ImageView alien6 = new ImageView(new Image("https://images.vectorhq.com/images/previews/413/alien-space-ship-icon-b-w-psd-438456.png"));
		*/
		Random random = new Random();
		//int ranX = random.nextInt(430-1); // random value from 0 to width
		//int ranY = random.nextInt(150-1);
		a1.setLayoutX(random.nextInt(430-1));
		a1.setLayoutY(random.nextInt(150-1));
		a2.setLayoutX(random.nextInt(450-1));
		a2.setLayoutY(random.nextInt(150-1));
		a3.setLayoutX(random.nextInt(450-1));
		a3.setLayoutY(random.nextInt(150-1));
		a4.setLayoutX(random.nextInt(450-1));
		a4.setLayoutY(random.nextInt(150-1));
		a5.setLayoutX(random.nextInt(450-1));
		a5.setLayoutY(random.nextInt(150-1));
		
		Line aLine = new Line();
		aLine.setStartX(a1.getLayoutX());
		aLine.setStartY(a1.getLayoutY());
		aLine.setEndX(a1.getLayoutX() - 20.0f);
		aLine.setEndY(a1.getLayoutY());
		
		/*Line bLine = new Line();
		bLine.setStartX(a2.getLayoutX());
		bLine.setStartY(a2.getLayoutY());
		bLine.setEndX(a2.getLayoutX() - 20.0f);
		bLine.setEndY(a2.getLayoutY());
		*/
		PathTransition aMoves = new PathTransition();
		aMoves.setNode(a1);
		aMoves.setPath(aLine);
		aMoves.setDuration(Duration.millis(4000));
		aMoves.setCycleCount(Timeline.INDEFINITE);
		aMoves.play();
		/*PathTransition bMoves = new PathTransition();
		aMoves.setNode(a2);
		aMoves.setPath(bLine);
		aMoves.setDuration(Duration.millis(4000));
		aMoves.setCycleCount(Timeline.INDEFINITE);
		aMoves.play();
		*/
		pfAliens.getChildren().addAll(a1, a2, a3, a4, a5);
		
		
		GridPane upperAliens = new GridPane();
		upperAliens.getChildren().add(pfAliens);
		
		
		
		
		BorderPane borderPane = new BorderPane();
		borderPane.setBottom(pfb);
		borderPane.setCenter(new BallControl());
		//borderPane.setCenter(upperAliens);
		borderPane.getChildren().add(upperAliens);
		//BorderPane.setAlignment(upperAliens, pos.);
		
		left.setOnAction(new leftHandler((BallControl)borderPane.getCenter()));
		right.setOnAction(new rightHandler((BallControl)borderPane.getCenter()));
		Scene scene = new Scene(borderPane, 450, 300);
		primaryStage.setTitle("Galaga");
		primaryStage.setScene(scene);
		primaryStage.show();

	}
	class leftHandler implements EventHandler<ActionEvent> {
		BallControl p;
		public leftHandler(BallControl p) {
			this.p = p;
		}
		@Override
		public void handle(ActionEvent arg0) {
			// TODO Auto-generated method stub
		
			p.left();
			p.path();

		}
		
	}
	class rightHandler implements EventHandler<ActionEvent> {
		BallControl p;
		public rightHandler(BallControl p) {
			this.p = p;
		}
		@Override
		public void handle(ActionEvent event) {
			// TODO Auto-generated method stub
		
			p.right();
			p.path();
		}
		
	}
	
	class BallControl extends Pane {
	      public final double radius = 20;
	      private double x = radius, y = radius;
	      private double dx = 1, dy = 1;
	      
	      private Circle ship; 
	      Circle s = new Circle();
	      private Line line = new Line();
	      PathTransition pt = new PathTransition();
	        	
	       public Circle initialShip() {
	    	ship = new Circle(); 
	    	Image ship1 = new Image("http://www.freepngimg.com/thumb/spaceship/24752-5-spaceship-thumb.png");
	    	ship.setCenterX(225.0f);
	        ship.setCenterY(250.0f);
	        ship.setRadius(20.0f);
	        ship.setStroke(Color.TRANSPARENT);
	        ship.setFill(new ImagePattern(ship1));
			return ship;
	       }		
	       
	      public Circle shots() {
	  		Circle shots = new Circle();
	 		shots.setCenterX(ship.getCenterX());
	        shots.setCenterY(215.0f);
	        shots.setRadius(10);
	        shots.setFill(Color.YELLOW);
	        shots.setStroke(Color.BLACK);
			return shots;		
	      }
	      public BallControl() { //Initial 
	       getChildren().addAll(initialShip());
	       ship = (Circle)getChildren().get(0);
	       
	      }	 
	      public void path() {
	    	Line line = new Line();
	    	 line.setStartX(ship.getCenterX());
	        line.setEndX(ship.getCenterX());
	        line.setStartY(215.0f);
	        line.setEndY(15.0f);
	        
	        PathTransition pt = new PathTransition();
	        pt.setNode(shots());
	        getChildren().add(pt.getNode());
			pt.setPath(line);
			pt.setDuration(Duration.millis(4000));
			pt.setCycleCount(1);
			pt.setOnFinished( new removeShots());
			pt.play();
	      } 
	      class removeShots implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent arg0) {
			// TODO Auto-generated method stub
			PathTransition pt = (PathTransition)arg0.getSource();
			Node shot = pt.getNode();
			getChildren().remove(shot);
			
		}
		
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
	        ship.setCenterX(x);
	        ship.setCenterY(y);
	        //shots.setCenterX(x);
	        //shots.setCenterX(y);
	    
	      }   
	     
	      public void left() {
	        ship.setCenterX(ship.getCenterX() - 10);
	       
	      }       
	      public void right() {
	        ship.setCenterX(ship.getCenterX() + 10);
	        
	      }
	      public void setStroke(Color antiquewhite) {
	    	  
		}

		public void setFill(ImagePattern imagePattern) {
			
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


