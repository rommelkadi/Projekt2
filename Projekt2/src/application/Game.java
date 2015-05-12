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
			
			//Uus stseen 2. leveli jaoks. UUE leveli sisu on level2 klassis
			BorderPane juur4 = new BorderPane();
			juur4.setId("taust");
			Scene scene4 = new Scene(juur4, 800, 500);
			scene4.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			
			Scene scene2 = new Scene(juur,800,500);
			scene2.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			Scene scene3 = new Scene(juur2,800,500);
			scene3.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			
			
			
			
			//Algus Graafika veits kole veel, aga küll saab 
			Text text1 = new Text("TEA KEDA TERVITAD");
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
			
			//Ekraanide ülemisele osale HBox, et saaks lisada 2 nuppu üles
			HBox hbox = new HBox();
			juur2.setTop(hbox);
			hbox.setId("yles");
			
			Text reegliText = new Text(juur.getWidth()/2, juur.getHeight()/2, "Mängu reeglid on väga lihtsad. Vajuta pildile ning kirjuta, kellega on tegu.");
			reegliText.setFont(Font.font ("Verdana", 20));
			juur.setCenter(reegliText);
			Button tagasi = new Button("Tagasi avalehele");
			tagasi.setId("tagasi");
			juur.setTop(tagasi);
			
			Button tagasi2 = new Button("Tagasi avalehele");
			//Kontrolli jaoks üks nupp esialgu
			Button valmis = new Button("Valmis");
			valmis.setId("tagasi");
			tagasi2.setId("tagasi");
			
			hbox.getChildren().addAll(tagasi2, valmis);
			
			
			
			//Mängu osa
			
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
			String[] logs1 = new String[]{"ReinPrank.png","TaivoPungas.png","NiitsooMargus.png","AivarAnnamaa.png","UrmasTamm.png"};
			logs.addAll(Arrays.asList(logs1));
			
			
			//panin praegu nii logode vastused arraysse, et texfieldi tööd testida, 
			//hiljem vist peame kuidagi mugavamalt lahendama selle
			String[] vastused = new String[]{"Rein Prank","Taivo Pungas","Margus Niitsoo","Aivar Annamaa","Urmas Tamm"};			
			
			// kristi path :D "file:/C:/Users/Kristi Koppel/workspace/Mäng/src/Mäng/Logod/"
			//kadi path "file:/C:/Users/Kadi/git/Projekt2.1/Projekt2/src/application/"

			for (int i=0; i<5; i++){
				logod[i] = new ImageView(new Image("file:/C:/Users/Kadi/git/Projekt2.1/Projekt2/src/images/" + logs.get(i)));
				logod[i].setFitWidth(150);
				logod[i].setFitHeight(200);
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
		        					        	 System.out.println("ÕIGE");
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
			logod[1].addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

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
			        					        	 System.out.println("ÕIGE");
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
			logod[2].addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

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
		        					        	 System.out.println("ÕIGE");
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
			logod[3].addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

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
		        					        	 System.out.println("ÕIGE");
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
			logod[4].addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

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
		        					        	 System.out.println("ÕIGE");
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
			
			
			//Kui kõik logogd on nähtamatud, ehk õigesti vastatud, siis kuvab ekraanile TUBLI ja Uue leveli nupu...L
			valmis.setOnAction(new EventHandler<ActionEvent>(){
				public void handle (ActionEvent e) {
					if(logod[0].isVisible()==false && logod[1].isVisible()==false && logod[2].isVisible()==false && logod[3].isVisible()==false && logod[4].isVisible()==false){
						Text tubliText = new Text("Tubli! Teadsid kõiki õppejõude. Liigu nüüd edasi järgmise semestri juurde");
						tubliText.setId("informatsioonTekst");
						Button uusLevel = new Button("Semester 2");
						uusLevel.setAlignment(Pos.BOTTOM_CENTER);
						uusLevel.setId("uusLevel");
						flow.getChildren().addAll(tubliText, uusLevel);
						
						//Vajutades uue Leveli nupule, ilmub uus stseen ja jätkub samamoodi
						uusLevel.setOnAction(new EventHandler<ActionEvent>() {

				            public void handle(ActionEvent event) {
				            	
				                peaLava.setScene(scene4);  
				                FlowPane flow2 = new FlowPane();
				    			flow2.setId("keskmine");
				    			juur4.setCenter(flow2);
				    			juur4.setTop(hbox);
				    			flow2.setPadding(new Insets(6, 5, 6, 5));
				    			flow2.setVgap(4);
				    			flow2.setHgap(4);
				    			flow2.setPrefWrapLength(200);
				    			
				    			GridPane texts2 = new GridPane();
				    			texts2.setId("alumine");
				    			juur4.setBottom(texts2);
				    			texts2.setPadding(new Insets(6,5,6,5));
				    			texts2.setVgap(4);
				    			texts2.setHgap(4);
				    			for(int i = 0; i<5; i++){
				    				texts2.getColumnConstraints().add(new ColumnConstraints(150));
				    				}
				    			String[] logs2 = new String[]{"KalevTarkpea.png","EnoTõnisson.png","AntiIngel1.png","ElinaKallas.png","AnneVillems.png"};			
				    			String[] vastused2 = new String[]{"Kalev Tarkpea","Eno Tõnisson","Anti Ingel","Elina Kallas","Anne Villems"};
				    			ArrayList<String> logos2 = new ArrayList<String>();
				    			logos2.addAll(Arrays.asList(logs2));
				    			
				    			//kadi path "file:/C:/Users/Kadi/git/Projekt2.1/Projekt2/src/application/"
				    			for (int i=0; i<5; i++){
				    				logod[i] = new ImageView(new Image("file:/C:/Users/Kadi/git/Projekt2.1/Projekt2/src/images/" + logos2.get(i)));
				    				logod[i].setFitWidth(150);
				    				logod[i].setFitHeight(200);
				    				flow2.getChildren().add(logod[i]);
				    				
				    				text[i] = new TextField();
				    				text[i].setPrefWidth(150);		
				    				
				    				
				    			}
				    			logod[0].	addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

				   			     @Override
				   			     public void handle(MouseEvent event) {
				   			    	 
				   			         System.out.println("vajutasin");
				   			         texts2.add(text[0],0,0);
				   			         text[0].setOnKeyPressed(new EventHandler<KeyEvent>()
				   		        			    {
				   		        			        @Override
				   		        			        public void handle(KeyEvent ke)
				   		        			        {
				   		        			            if (ke.getCode().equals(KeyCode.ENTER))
				   		        			            {
				   		        			            	String vast  = text[0].getText();
				   		        					         if (vast.equalsIgnoreCase(vastused2[0])){
				   		        					        	 System.out.println("ÕIGE");
				   		        					        	 logod[0].setVisible(false);
				   		        					        	 text[0].setVisible(false);}
				   		        					         else{
				   		        					        	 System.out.println("Vale :(");
				   		        					         }
				   		        			            }
				   		        			            
				   		        			        }
				   		        			    });
				   			     
				   			      logod[1].addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

				   				     @Override
				   				     public void handle(MouseEvent event) {
				   				    	 
				   				         System.out.println("vajutasin");
				   				         texts2.add(text[1], 1, 0);
				   				         
				   				        	 text[1].setOnKeyPressed(new EventHandler<KeyEvent>()
				   				        			    {
				   				        			        @Override
				   				        			        public void handle(KeyEvent ke)
				   				        			        {
				   				        			            if (ke.getCode().equals(KeyCode.ENTER))
				   				        			            {
				   				        			            	String vast  = text[1].getText();
				   				        					         if (vast.equalsIgnoreCase(vastused2[1])){
				   				        					        	 System.out.println("ÕIGE");
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
				   				logod[2].addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

				   				     @Override
				   				     public void handle(MouseEvent event) {
				   				    	 
				   				         System.out.println("vajutasin");
				   				         texts2.add(text[2], 2, 0);
				   				         text[2].setOnKeyPressed(new EventHandler<KeyEvent>()
				   			        			    {
				   			        			        @Override
				   			        			        public void handle(KeyEvent ke)
				   			        			        {
				   			        			        	if (ke.getCode().equals(KeyCode.ENTER))
				   			        			            {
				   			        			            	String vast  = text[2].getText();
				   			        					         if (vast.equalsIgnoreCase(vastused2[2])){
				   			        					        	 System.out.println("ÕIGE");
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
				   				logod[3].addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

				   				     @Override
				   				     public void handle(MouseEvent event) {
				   				    	 
				   				         System.out.println("vajutasin");
				   				         texts2.add(text[3], 3, 0);
				   				         event.consume();
				   				         text[3].setOnKeyPressed(new EventHandler<KeyEvent>()
				   			        			    {
				   			        			        @Override
				   			        			        public void handle(KeyEvent ke)
				   			        			        {
				   			        			            if (ke.getCode().equals(KeyCode.ENTER))
				   			        			            {
				   			        			            	String vast  = text[3].getText();
				   			        					         if (vast.equalsIgnoreCase(vastused2[3])){
				   			        					        	 System.out.println("ÕIGE");
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
				   				logod[4].addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

				   				     @Override
				   				     public void handle(MouseEvent event) {
				   				    	 
				   				         System.out.println("vajutasin");
				   				         texts2.add(text[4], 4, 0);
				   				         text[4].setOnKeyPressed(new EventHandler<KeyEvent>()
				   			        			    {
				   			        			        @Override
				   			        			        public void handle(KeyEvent ke)
				   			        			        {
				   			        			            if (ke.getCode().equals(KeyCode.ENTER))
				   			        			            {
				   			        			            	String vast  = text[4].getText();
				   			        					         if (vast.equalsIgnoreCase(vastused2[4])){
				   			        					        	 System.out.println("ÕIGE");
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
				   			         event.consume();
				   			     }
				   			});
				                
				            }
				        });
						
						
					}
					
					
					
					else{
						int counter = 0;
						Text pooleliText = new Text("Ei saa edasi liikuda, sa ei tea veel kõiki õppejõude!");
						flow.getChildren().add(pooleliText);
						pooleliText.setId("informatsioonTekst");
						FadeTransition ft = new FadeTransition(Duration.millis(5000));
						if (counter == 0) {
							ft.setFromValue(1.0);
							ft.setToValue(0.0);
							ft.setNode(pooleliText);
							ft.play();
							
						}
							
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