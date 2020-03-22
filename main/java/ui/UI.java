package ui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class UI extends Application
{
    HBox codeBox, labelBox;
    VBox javaCodeBox, pythonCodeBox, uiBox;

    TextArea javaTextArea;
    TextArea pythonTextArea ;

    Scanner scanner;

    private static final String CODE_CONVERT_BUTTON = "Convert";
    private static final String PROJECT_TITLE = "Coffee Snake";
    private static final String JAVA_LABEL = "Java Code";
    private static final String PYTHON_LABEL = "Python Code";

    public UI()
    {
        codeBox = new HBox();
        labelBox = new HBox();
        javaCodeBox = new VBox();
        pythonCodeBox = new VBox();
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

        javaTextArea.setPrefHeight(500);
        pythonTextArea.setPrefHeight(500);

        Label javaLabel = new Label(JAVA_LABEL);
        Label pythonLabel = new Label(PYTHON_LABEL);

        javaLabel.setFont(Font.font("TW Cen MT", FontWeight.BOLD, 15));
        pythonLabel.setFont(Font.font("TW Cen MT", FontWeight.BOLD, 15));

        javaCodeBox.getChildren().addAll(javaLabel, javaTextArea);
        pythonCodeBox.getChildren().addAll(pythonLabel, pythonTextArea);

        javaCodeBox.setPadding(new Insets(10, 10, 10, 10));
        pythonCodeBox.setPadding(new Insets(10, 10 , 10 ,10));

        //labelBox.getChildren().addAll(javaLabel, pythonLabel);

        codeBox.setPadding(new Insets(10, 10, 10 , 10));
        codeBox.getChildren().addAll(javaCodeBox, pythonCodeBox);

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

        Scene scene = new Scene(uiFlowPane, 1010, 700);
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
