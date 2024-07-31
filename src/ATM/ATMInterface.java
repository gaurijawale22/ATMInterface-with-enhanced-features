import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ATMInterface extends Application {
    private ATM atm;

    public ATMInterface() {
        atm = new ATM(); // Assume ATM is initialized and loaded with user data
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("ATM Interface");

        VBox root = new VBox(10);
        Label welcomeLabel = new Label("Welcome to the ATM");

        TextField userIdField = new TextField();
        userIdField.setPromptText("User ID");

        PasswordField pinField = new PasswordField();
        pinField.setPromptText("PIN");

        Button loginButton = new Button("Login");
        loginButton.setOnAction(e -> handleLogin(userIdField.getText(), pinField.getText()));

        root.getChildren().addAll(welcomeLabel, userIdField, pinField, loginButton);

        Scene scene = new Scene(root, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void handleLogin(String userId, String pin) {
        if (atm.authenticateUser(userId, pin)) {
            // Proceed to account operations (you can create a new scene for this)
            System.out.println("Login successful");
        } else {
            System.out.println("Authentication failed");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}

