package application;
import java.util.ArrayList;
import java.util.Arrays;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Game extends Application{
	public void start(Stage peaLava) {
		try {
			//Tsau Kadi! Nii teen selle aknakese n��d siia. Ja siis selline lugu et loon kolm erinevat stseeni, 
			//et ei tekiks uusi aknaid, vaid et k�ik toimubks lihtsalt l�bi stseenivahetuste. Igal stseenil on oma juur.
		
			
			BorderPane root = new BorderPane();
			root.setId("taust");
			Scene scene1 = new Scene(root,800,500);
			scene1.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			//Reeglid
			BorderPane juur = new BorderPane();
			juur.setId("taust");
			//M�ngu osa
			BorderPane juur2= new BorderPane();
			juur2.setId("taust");	
			
			Scene scene2 = new Scene(juur,800,500);
			scene2.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			Scene scene3 = new Scene(juur2,800,500);
			scene3.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			//Algus Graafika veits kole veel, aga k�ll saab 
			Text text1 = new Text("LOGOQUIZ");
			//root.setTop(text1);
			//root.setAlignment(text1, Pos.TOP_CENTER);
			text1.setId("avaTekst");
			Button reeglid = new Button("Reeglid");
			Button alusta = new Button("Alusta m�ngu");
			reeglid.setId("avaNupp");
			alusta.setId("avaNupp");
			VBox vbox = new VBox(8); 
			vbox.getChildren().addAll(text1, alusta,reeglid);
			root.setCenter(vbox);
			vbox.setAlignment(Pos.CENTER);
			
			//Ekraanide �lemisele osale HBox, et saaks lisada 2 nuppu �les
			HBox hbox = new HBox();
			juur2.setTop(hbox);
			hbox.setId("yles");
			
			Text reegliText = new Text(juur.getWidth()/2, juur.getHeight()/2, "M�ngu reeglid on v�ga lihtsad. Vajuta logole ning kirjuta, millega on tegu.");
			reegliText.setFont(Font.font ("Verdana", 20));
			juur.setCenter(reegliText);
			Button tagasi = new Button("Tagasi avalehele");
			tagasi.setId("tagasi");
			juur.setTop(tagasi);
			
			Button tagasi2 = new Button("Tagasi avalehele");
			//Kontrolli jaoks �ks nupp esialgu
			Button valmis = new Button("Valmis");
			valmis.setId("tagasi");
			tagasi2.setId("tagasi");
			
			hbox.getChildren().addAll(tagasi2, valmis);
			//juur2.setTop(tagasi2);
			
			
			//M�ngu osa
			
			FlowPane flow = new FlowPane();
			flow.setId("keskmine");
			juur2.setCenter(flow);
			flow.setPadding(new Insets(6, 5, 6, 5));
			flow.setVgap(4);
			flow.setHgap(4);
			flow.setPrefWrapLength(200);
			
			GridPane texts = new GridPane();
			texts.setId("alumine");
			juur2.setBottom(texts);
			texts.setPadding(new Insets(6,5,6,5));
			texts.setVgap(4);
			texts.setHgap(4);
			for(int i = 0; i<5; i++){
				texts.getColumnConstraints().add(new ColumnConstraints(150));
				}
			
			ImageView logod[] = new ImageView[8];
			TextField text[] = new TextField[8];
			
			ArrayList<String> logs = new ArrayList<String>();
			String[] logs1 = new String[]{"logo-1.png","logo-2.png","logo-3.png","logo-4.png","logo-5.png"};
			logs.addAll(Arrays.asList(logs1));
			
			//panin praegu nii logode vastused arraysse, et texfieldi t��d testida, 
			//hiljem vist peame kuidagi mugavamalt lahendama selle
			String[] vastused = new String[]{"chrome","lays","android","apple","nike"};			
			
			// minu path enda jaoks :D "file:/C:/Users/Kristi Koppel/workspace/M�ng/src/M�ng/Logod/"
			for (int i=0; i<5; i++){
				logod[i] = new ImageView(new Image("file:/C:/Users/Kadi/git/Projekt2.1/Projekt2/src/application/" + logs.get(i)));
				logod[i].setFitWidth(150);
				logod[i].setFitHeight(150);
				flow.getChildren().add(logod[i]);
				
				text[i] = new TextField();
				text[i].setPrefWidth(150);				
			}
			
			logod[0].	addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

			     @Override
			     public void handle(MouseEvent event) {
			    	 
			         System.out.println("vajutasin");
			         texts.add(text[0],0,0);
			         text[0].setOnKeyPressed(new EventHandler<KeyEvent>()
		        			    {
		        			        @Override
		        			        public void handle(KeyEvent ke)
		        			        {
		        			            if (ke.getCode().equals(KeyCode.ENTER))
		        			            {
		        			            	String vast  = text[0].getText();
		        					         if (vast.equalsIgnoreCase(vastused[0])){
		        					        	 System.out.println("�IGE");
		        					        	 logod[0].setVisible(false);
		        					        	 text[0].setVisible(false);}
		        					         else{
		        					        	 System.out.println("Vale :(");
		        					         }
		        			            }
		        			        }
		        			    });
			         event.consume();
			     }
			});
			logod[1].	addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

			     @Override
			     public void handle(MouseEvent event) {
			    	 
			         System.out.println("vajutasin");
			         texts.add(text[1], 1, 0);
			         
			        	 text[1].setOnKeyPressed(new EventHandler<KeyEvent>()
			        			    {
			        			        @Override
			        			        public void handle(KeyEvent ke)
			        			        {
			        			            if (ke.getCode().equals(KeyCode.ENTER))
			        			            {
			        			            	String vast  = text[1].getText();
			        					         if (vast.equalsIgnoreCase(vastused[1])){
			        					        	 System.out.println("�IGE");
			        					        	 logod[1].setVisible(false);
			        					        	 text[1].setVisible(false);}
			        					         else{
			        					        	 System.out.println("Vale :(");
			        					         }
			        			            }
			        			        }
			        			    });
			         
			         event.consume();
			     }
			});
			logod[2].	addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

			     @Override
			     public void handle(MouseEvent event) {
			    	 
			         System.out.println("vajutasin");
			         texts.add(text[2], 2, 0);
			         text[2].setOnKeyPressed(new EventHandler<KeyEvent>()
		        			    {
		        			        @Override
		        			        public void handle(KeyEvent ke)
		        			        {
		        			        	if (ke.getCode().equals(KeyCode.ENTER))
		        			            {
		        			            	String vast  = text[2].getText();
		        					         if (vast.equalsIgnoreCase(vastused[2])){
		        					        	 System.out.println("�IGE");
		        					        	 logod[2].setVisible(false);
		        					        	 text[2].setVisible(false);}
		        					         else{
		        					        	 System.out.println("Vale :(");
		        					         }
		        			            }
		        			        }
		        			    });
			         event.consume();
			     }
			});
			logod[3].	addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

			     @Override
			     public void handle(MouseEvent event) {
			    	 
			         System.out.println("vajutasin");
			         texts.add(text[3], 3, 0);
			         event.consume();
			         text[3].setOnKeyPressed(new EventHandler<KeyEvent>()
		        			    {
		        			        @Override
		        			        public void handle(KeyEvent ke)
		        			        {
		        			            if (ke.getCode().equals(KeyCode.ENTER))
		        			            {
		        			            	String vast  = text[3].getText();
		        					         if (vast.equalsIgnoreCase(vastused[3])){
		        					        	 System.out.println("�IGE");
		        					        	 logod[3].setVisible(false);
		        					        	 text[3].setVisible(false);}
		        					         else{
		        					        	 System.out.println("Vale :(");
		        					         }
		        			            }
		        			        }
		        			    });
			     }
			});
			logod[4].	addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

			     @Override
			     public void handle(MouseEvent event) {
			    	 
			         System.out.println("vajutasin");
			         texts.add(text[4], 4, 0);
			         text[4].setOnKeyPressed(new EventHandler<KeyEvent>()
		        			    {
		        			        @Override
		        			        public void handle(KeyEvent ke)
		        			        {
		        			            if (ke.getCode().equals(KeyCode.ENTER))
		        			            {
		        			            	String vast  = text[4].getText();
		        					         if (vast.equalsIgnoreCase(vastused[4])){
		        					        	 System.out.println("�IGE");
		        					        	 logod[4].setVisible(false);
		        					        	 text[4].setVisible(false);}
		        					         else{
		        					        	 System.out.println("Vale :(");
		        					         }
		        			            }
		        			        }
		        			    });
			         event.consume();
			     }
			});
			//Kui k�ik logogd on n�htamatud, ehk �igesti vastatud, siis kuvab ekraanile TUBLI ja Uue leveli nupu... EI T��TA VEEL
			valmis.setOnAction(new EventHandler<ActionEvent>(){
				public void handle (ActionEvent e) {
					if(logod[0].isVisible()==false && logod[1].isVisible()==false && logod[2].isVisible()==false && logod[3].isVisible()==false && logod[4].isVisible()==false){
						Text tubliText = new Text("Tubli! Teadsid k�iki logosid. Liigu n��d edasi j�rgmise leveli juurde");
						tubliText.setId("informatsioonTekst");
						Button uusLevel = new Button("J�rgmised logod");
						uusLevel.setAlignment(Pos.BOTTOM_CENTER);
						uusLevel.setId("uusLevel");
						flow.getChildren().addAll(tubliText, uusLevel);
						
						uusLevel.setOnAction(new EventHandler<ActionEvent>() {

				            public void handle(ActionEvent event) {
				                peaLava.setScene(scene3);
				                Alusta a = new Alusta();
				                a.alusta();
				                
				            }
				        });
					}
					else{
						//Siin bug sees, peaks eraldi kontrollima, kas seda nuppu on juba korra vajutatud, kui on siis tuleks fade transition uuesti k�ima panna.
						Text pooleliText = new Text("Ei saa edasi liikuda, sul on veel osad vastamata!");
						pooleliText.setId("informatsioonTekst");
						flow.getChildren().add(pooleliText);
						FadeTransition ft = new FadeTransition(Duration.millis(5000));
						ft.setFromValue(1.0);
						ft.setToValue(0.0);
						
						ft.setNode(pooleliText);
						ft.play();
					}
						
				}
			});
			
			
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