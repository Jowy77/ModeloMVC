package dad.javafx.mvc.modificar;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ModificarView extends VBox {
	
	private TextField datoText;
	private Button esatablecerButton;
	private Button incrementarButton;
	private Button decrementarButton;
	
	public ModificarView() {
		super();
		
		datoText = new TextField();
		datoText.setPrefColumnCount(5);
		
		esatablecerButton = new Button("Establecer");
		esatablecerButton.setDefaultButton(true);
		
		incrementarButton = new Button(">>");
		decrementarButton = new Button("<<");
		
		HBox datosBos = new HBox(5,new Label("Nuevo Valor: "),datoText);
		datosBos.setAlignment(Pos.BASELINE_CENTER);
		
		HBox botonesBox = new HBox(5,decrementarButton,incrementarButton);
		botonesBox.setAlignment(Pos.BASELINE_CENTER);
		
		setSpacing(5);
		setAlignment(Pos.CENTER);
		getChildren().addAll(datosBos,esatablecerButton,botonesBox);
		
	}

	public TextField getDatoText() {
		return datoText;
	}

	public Button getEsatablecerButton() {
		return esatablecerButton;
	}

	public Button getIncrementarButton() {
		return incrementarButton;
	}

	public Button getDecrementarButton() {
		return decrementarButton;
	}
	
	

}
