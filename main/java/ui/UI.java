package ui;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class UI extends Application
{
    HBox codeBox;
    VBox uiBox;

    TextArea javaTextArea;
    TextArea pythonTextArea ;

    Scanner scanner;

    public static final String CODE_CONVERT_BUTTON = "Convert";
    public static final String PROJECT_TITLE = "Coffee Snake";

    public UI()
    {
        codeBox = new HBox();
        uiBox = new VBox();

        javaTextArea = new TextArea();
        pythonTextArea = new TextArea();

        scanner = new Scanner();
    }

    public TextArea getJavaTextArea()
    {
        return javaTextArea;
    }

    public TextArea getPythonTextArea()
    {
        return pythonTextArea;
    }

    public void setPythonTextArea(String pythonCode)
    {
        this.pythonTextArea = new TextArea(pythonCode);
    }

    @Override
    public void start(Stage stage) throws Exception
    {
        FlowPane uiFlowPane = new FlowPane();

        Button convertButton = new Button(CODE_CONVERT_BUTTON);

        codeBox.getChildren().addAll(getJavaTextArea(), getPythonTextArea());

        uiBox.getChildren().addAll(codeBox, convertButton);
        uiBox.setAlignment(Pos.CENTER);

        convertButton.setOnAction(actionEvent ->
        {
            scanner.writeJavaCodeToFile(getJavaTextArea().getText());
            setPythonTextArea(scanner.readPythonCodeFromFile());

            codeBox.getChildren().clear();
            codeBox.getChildren().addAll(getJavaTextArea(), getPythonTextArea());

            uiBox.getChildren().clear();
            uiBox.getChildren().add(0, codeBox);

            uiFlowPane.getChildren().clear();
            uiFlowPane.getChildren().addAll(uiBox);
        });

        uiFlowPane.getChildren().addAll(uiBox);

        Scene scene = new Scene(uiFlowPane, 1000, 500);
        stage.setTitle(PROJECT_TITLE); // Set the stage title
        stage.setScene(scene); // Place the scene in the stage
        stage.show();
    }

    //main function runs the application for the GUI
    public static void main(String[] args)
    {
        Application.launch(args);
    }
}
