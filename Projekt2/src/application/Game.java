package application;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
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
			root.setId("taust");
			Scene scene1 = new Scene(root,800,500);
			scene1.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			//Reeglid
			BorderPane juur = new BorderPane();
			juur.setId("taust");
			//Mängu osa
			BorderPane juur2= new BorderPane();
			juur2.setId("taust");
			//FlowPane flow = new FlowPane();
			//juur2.setCenter(flow);
			
			
			Scene scene2 = new Scene(juur,800,500);
			scene2.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			Scene scene3 = new Scene(juur2,800,500);
			scene3.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			//Algus Graafika veits kole veel, aga küll saab 
			Text text1 = new Text("LOGOQUIZ");
			//root.setTop(text1);
			//root.setAlignment(text1, Pos.TOP_CENTER);
			text1.setId("avaTekst");
			Button reeglid = new Button("Reeglid");
			Button alusta = new Button("Alusta mängu");
			reeglid.setId("avaNupp");
			alusta.setId("avaNupp");
			VBox vbox = new VBox(8); 
			vbox.getChildren().addAll(text1, alusta,reeglid);
			root.setCenter(vbox);
			vbox.setAlignment(Pos.CENTER);
			
			Text reegliText = new Text(juur.getWidth()/2, juur.getHeight()/2, "Mängu reeglid on väga lihtsad. Vajuta logole ning kirjuta, millega on tegu.");
			reegliText.setFont(Font.font ("Verdana", 20));
			juur.setCenter(reegliText);
			Button tagasi = new Button("Tagasi avalehele");
			Button tagasi2 = new Button("Tagasi avalehele");
			tagasi.setId("tagasi");
			tagasi2.setId("tagasi");
			
			juur.setTop(tagasi);
			juur2.setTop(tagasi2);
			
			//Mängu osa
			// logo = new Image("logo-1.jpg");
			
			Image logo = new Image("https://lh3.ggpht.com/O0aW5qsyCkR2i7Bu-jUU1b5BWA_NygJ6ui4MgaAvL7gfqvVWqkOBscDaq4pn-vkwByUx=w300");
			ImageView iv1 = new ImageView();
			iv1.setImage(logo);
			iv1.setFitWidth(100);
			iv1.setFitHeight(100);
			juur2.setCenter(iv1);
			
			
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
