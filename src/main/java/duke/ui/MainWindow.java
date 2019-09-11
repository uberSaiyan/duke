package duke.ui;

import duke.core.Duke;
import duke.util.Response;
import duke.util.ResponseCode;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Controller for MainWindow. Provides the layout for the other controls.
 */
public class MainWindow extends AnchorPane {
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private VBox dialogContainer;
    @FXML
    private TextField userInput;
    @FXML
    private Button sendButton;

    private Duke duke;

    private Image userImage = new Image(this.getClass().getResourceAsStream("/images/DaUser.png"));
    private Image dukeImage = new Image(this.getClass().getResourceAsStream("/images/DaDuke.png"));

    /**
     * Sets initial values upon loading.
     */
    @FXML
    public void initialize() {
        scrollPane.vvalueProperty().bind(dialogContainer.heightProperty());
        showWelcome();
    }

    private void showWelcome() {
        String welcome = "Hello! I'm Duke\n"
                + "What can I do for you?\n";
        dialogContainer.getChildren().addAll(
                DialogBox.getDukeDialog(welcome, dukeImage)
        );
    }

    public void setDuke(Duke d) {
        duke = d;
    }

    /**
     * Creates two dialog boxes, one echoing user input and the other containing Duke's reply and then appends them to
     * the dialog container. Clears the user input after processing.
     */
    @FXML
    private void handleUserInput() {
        String input = userInput.getText();
        Response response = duke.getResponse(input);
        assert response != null : "Null response from Duke.";
        dialogContainer.getChildren().add(DialogBox.getUserDialog(input, userImage));
        DialogBox dukeDialogBox = DialogBox.getDukeDialog(response.getMessage(), dukeImage);

        if (response.getResponseCode() == ResponseCode.OK) {
            dukeDialogBox.setColor(Color.GREEN);
        } else if (response.getResponseCode() == ResponseCode.ERROR) {
            dukeDialogBox.setColor(Color.RED);
        } else if (response.getResponseCode() == ResponseCode.EXIT) {
            dukeDialogBox.setColor(Color.BLUE);
            timedExit(1);
        }

        dialogContainer.getChildren().add(dukeDialogBox);
        userInput.clear();
    }

    private void timedExit(int seconds) {
        assert seconds > 0 : "Timed exit must be positive.";
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.exit(0);
            }
        }, new Date(System.currentTimeMillis() + seconds * 1000));
    }
}