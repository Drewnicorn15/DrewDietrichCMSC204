module Assignment3 {
	//requires javafx.controls;
	requires junit;
	exports application to junit;
	opens application to javafx.graphics, javafx.fxml;
}
