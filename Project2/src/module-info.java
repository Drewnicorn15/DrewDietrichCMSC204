module Project2 {
	requires javafx.controls;
	requires java.desktop;
	requires junit;
	requires org.junit.jupiter.api;
	
	opens application to javafx.graphics, javafx.fxml;
}
