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
import javafx.stage.FileChooser;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class UI extends Application
{
    HBox codeBox, labelBox;
    VBox javaCodeBox, pythonCodeBox, uiBox;

    TextArea javaTextArea;
    TextArea pythonTextArea;

    Scanner scanner;

    private static final String CODE_CONVERT_BUTTON = "Convert";
    private static final String PROJECT_CLEAR_BUTTON = "Clear Project";
    private static final String PYTHON_SAVE_BUTTON = "Save Python File";
    private static final String JAVA_FILE_BUTTON = "Add a Java Text File";
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
        Button clearButton = new Button(PROJECT_CLEAR_BUTTON);
        Button pythonButton = new Button(PYTHON_SAVE_BUTTON);
        Button javaButton = new Button(JAVA_FILE_BUTTON);

        javaTextArea.setPrefHeight(500);
        pythonTextArea.setPrefHeight(500);

        Label javaLabel = new Label(JAVA_LABEL);
        Label pythonLabel = new Label(PYTHON_LABEL);

        javaLabel.setFont(Font.font("TW Cen MT", FontWeight.BOLD, 15));
        pythonLabel.setFont(Font.font("TW Cen MT", FontWeight.BOLD, 15));

        javaCodeBox.getChildren().addAll(javaLabel, javaTextArea);
        pythonCodeBox.getChildren().addAll(pythonLabel, pythonTextArea);

        javaCodeBox.setPadding(new Insets(10, 10, 10, 10));
        pythonCodeBox.setPadding(new Insets(10, 10, 10, 10));

        //labelBox.getChildren().addAll(javaLabel, pythonLabel);

        codeBox.setPadding(new Insets(10, 10, 10, 10));
        codeBox.getChildren().addAll(javaCodeBox, pythonCodeBox);

        uiBox.getChildren().addAll(codeBox, convertButton, clearButton, pythonButton, javaButton);
        uiBox.setAlignment(Pos.CENTER);

        convertButton.setOnAction(actionEvent ->
        {
            scanner.writeJavaCodeToFile(getJavaTextArea().getText());
            setPythonTextArea(scanner.readPythonCodeFromFile());

            codeBox.getChildren().clear();
            codeBox.getChildren().addAll(getJavaTextArea(), getPythonTextArea());

            //  uiBox.getChildren().clear();
            //  uiBox.getChildren().add(0, codeBox);

            uiFlowPane.getChildren().clear();
            uiFlowPane.getChildren().addAll(uiBox);
        });

        clearButton.setOnAction(actionEvent ->
        {
            javaTextArea.clear();
            pythonTextArea.clear();


        });
        pythonButton.setOnAction(actionEvent ->
        {
            FileChooser pythonFileChooser = new FileChooser();

            FileChooser.ExtensionFilter extFilter =
                    new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
            pythonFileChooser.getExtensionFilters().add(extFilter);

            File pythonFile = pythonFileChooser.showSaveDialog(stage);

            if (pythonFile != null)
            {
                savePythonFile(pythonTextArea.getText(), pythonFile);
            }
        });
        javaButton.setOnAction(actionEvent ->
        {
            FileChooser javaFileChooser = new FileChooser();

            FileChooser.ExtensionFilter extFilter =
                    new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
            javaFileChooser.getExtensionFilters().add(extFilter);

            File javaFile = javaFileChooser.showOpenDialog(stage);

            if (javaFile != null)
            {
                javaTextArea.setText(loadJavaFile(javaFile));
            }
        });


        uiFlowPane.getChildren().addAll(uiBox);

        Scene scene = new Scene(uiFlowPane, 1010, 700);
        stage.setTitle(PROJECT_TITLE); // Set the stage title
        stage.setScene(scene); // Place the scene in the stage
        stage.show();
    }

    private void savePythonFile(String pythonCode, File file)
    {
        try
        {
            FileWriter pythonFileWriter = new FileWriter(file);
            pythonFileWriter.write(pythonCode);
            pythonFileWriter.close();
        } catch (IOException e)
        {
        }

    }

    private String loadJavaFile(File javafile)
    {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = null;

        try
        {
            String javaCode;

            br = new BufferedReader(new FileReader(javafile));
            while ((javaCode = br.readLine()) != null)
            {
                sb.append(javaCode + "\n");
            }

        } catch (FileNotFoundException e)
        {
        } catch (IOException e)
        {
        } finally
        {
            try
            {
                br.close();
            } catch (IOException e)
            {
            }
        }
        return sb.toString();
    }

    //main function runs the application for the GUI
    public static void main(String[] args)
    {
        Application.launch(args);
    }
}
