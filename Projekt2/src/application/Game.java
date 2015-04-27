package application;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Game extends Application{
	public void start(Stage peaLava) {
		try {
			//Tsau Kadi! Nii teen selle aknakese nüüd siia. Ja siis selline lugu et loon kolm erinevat stseeni, 
			//et ei tekiks uusi aknaid, vaid et kõik toimubks lihtsalt läbi stseenivahetuste. Igal stseenil on oma juur.
		
			
			BorderPane root = new BorderPane();
			Scene scene1 = new Scene(root,800,500, Color.LIGHTGREY);
			scene1.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			BorderPane juur = new BorderPane();
			BorderPane juur2= new BorderPane();
			Scene scene2 = new Scene(juur,800,500, Color.WHITE);
			scene2.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Scene scene3 = new Scene(juur2,800,500, Color.ANTIQUEWHITE);
			scene3.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			//Graafika veits kole veel, aga küll saab 
			Text text1 = new Text(320,50, "LOGOQUIZ");
			text1.setFont(Font.font ("Calibri", 50));
			root.setTop(text1);
			Button reeglid = new Button("Reeglid");
			Button alusta = new Button("Alusta mängu");
			VBox vbox = new VBox(8); 
			vbox.getChildren().addAll(alusta,reeglid);
			root.setCenter(vbox);
			
			Button tagasi = new Button("Tagasi");
			Button tagasi2 = new Button("Tagasi");
			juur.setTop(tagasi);
			juur2.setTop(tagasi2);
			
			tagasi.setOnAction(new EventHandler<ActionEvent>() {

	            public void handle(ActionEvent event) {
	                peaLava.setScene(scene1);
	                ;
	                
	            }
	        });
			tagasi2.setOnAction(new EventHandler<ActionEvent>() {

	            public void handle(ActionEvent event) {
	                peaLava.setScene(scene1);
	                ;
	                
	            }
	        });
			//Siin vahetab stseeni ning peale seda läheb uude klassi täitma seda mis me sinna lõpuks kirjutame
			//Aga ma pole päris kindel kuidas me saame teises klassis graafiliselt muuta asju, ma usun 
			// et minu lähenemine ei pruugi olla ka kõige õigem. Eks sa vaata üle, et mis võiks muuta 
			
			
			reeglid.setOnAction(new EventHandler<ActionEvent>() {

	            public void handle(ActionEvent event) {
	                peaLava.setScene(scene2);
	                Reeglid b = new Reeglid();
	                b.reeglid();
	                
	            }
	        });
			alusta.setOnAction(new EventHandler<ActionEvent>() {

	            public void handle(ActionEvent event) {
	                peaLava.setScene(scene3);
	                Alusta a = new Alusta();
	                a.alusta();
	                
	            }
	        });
			peaLava.setScene(scene1);
			//Vähe mugavam, ei pea proportsioonidega mässama kui akent muuta ei saa = D
			peaLava.setResizable(false);
			peaLava.setTitle("Logoquiz");
			peaLava.show();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
