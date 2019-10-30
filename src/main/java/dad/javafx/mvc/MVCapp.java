package dad.javafx.mvc;

import dad.javafx.mvc.modificar.ModificarController;
import dad.javafx.mvc.utils.Persistencia;
import dad.javafx.mvc.ver.VerController;
import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MVCapp extends Application{
	
	private VerController verController;
	private ModificarController modificarController;
	private IntegerProperty dato = new SimpleIntegerProperty();

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		verController = new VerController();
		modificarController = new ModificarController();
		
		verController.datoProperty().bind(dato);
		modificarController.datoProperty().bindBidirectional(dato);
		
		Scene verScene = new Scene(verController.getView(),320,200);
		primaryStage.setTitle("MVC");
		primaryStage.setScene(verScene);
		primaryStage.show();
		
		
		
		Scene modificarScene = new Scene(modificarController.getView(),320,200);
		Stage secondaryStage = new Stage();
		
		secondaryStage.setX(primaryStage.getX()+primaryStage.getWidth());
		secondaryStage.setY(primaryStage.getY());
		secondaryStage.setTitle("Modificar");
		secondaryStage.setScene(modificarScene);
		secondaryStage.show();
		
		

		
	}
	
	@Override
	public void init() throws Exception {
		dato.set(Persistencia.cargar());
		super.init();
	}
	
	@Override
	public void stop() throws Exception {
		Persistencia.guardar(dato.get());
		super.stop();
	}
	
	public static void main(String [] args) {
		launch(args);
	}

}
