package ui;

import javafx.scene.control.Alert.AlertType;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog.*;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;
import javax.tools.*;
import java.io.*;
import java.util.*;


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
    private static final String JAVA_FILE_BUTTON = "Load and Compile a Java File";
    private static final String SAVE_JAVA_FILE = "Save Text Area as Java file";
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

    Alert alert = new Alert(AlertType.INFORMATION);

    public List<String> compileFunction(File file)
    {
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();

        StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, null);
        Iterable<? extends JavaFileObject> compilationUnits =
                fileManager.getJavaFileObjectsFromFiles(Arrays.asList(file));

        DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<JavaFileObject>();
        compiler.getTask(null, fileManager, diagnostics, null, null, compilationUnits).call();

        List<String> errorMessage = new ArrayList<String>();
        Formatter formatter = new Formatter();
        for (Diagnostic diagnostic : diagnostics.getDiagnostics())
        {
            errorMessage.add(diagnostic.getKind() + ": Line [" + diagnostic.getLineNumber() + "] Position [" + diagnostic.getPosition() + "]  " + diagnostic.getMessage(Locale.ROOT) + "\n");

        }

        //  alert.show();
        if (errorMessage.size() < 1)
        {
            errorMessage.add("No Errors Found");
        }
        errorMessage.forEach(value -> alert.setContentText(errorMessage.toString()));
        alert.show();
        return errorMessage;
    }

    @Override
    public void start(Stage stage) throws Exception
    {
        FlowPane uiFlowPane = new FlowPane();

        Button convertButton = new Button(CODE_CONVERT_BUTTON);
        Button clearButton = new Button(PROJECT_CLEAR_BUTTON);
        Button pythonButton = new Button(PYTHON_SAVE_BUTTON);
        Button javaButton = new Button(JAVA_FILE_BUTTON);
        Button saveJavaButton = new Button(SAVE_JAVA_FILE);

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

        codeBox.setPadding(new Insets(10, 10, 10, 10));
        codeBox.getChildren().addAll(javaCodeBox, pythonCodeBox);

        uiBox.getChildren().addAll(codeBox, javaButton, saveJavaButton, convertButton, clearButton, pythonButton);
        uiBox.setAlignment(Pos.CENTER);

        convertButton.setOnAction(actionEvent ->
        {
            scanner.writeJavaCodeToFile(getJavaTextArea().getText());
            setPythonTextArea(scanner.readPythonCodeFromFile());

            codeBox.getChildren().clear();
            codeBox.getChildren().addAll(getJavaTextArea(), getPythonTextArea());

            uiFlowPane.getChildren().clear();
            uiFlowPane.getChildren().addAll(uiBox);
        });

        clearButton.setOnAction(actionEvent ->
        {
            javaTextArea.clear();
            pythonTextArea.clear();


        });

        saveJavaButton.setOnAction(actionEvent ->
        {
            FileChooser javaFileChooser = new FileChooser();

            FileChooser.ExtensionFilter extFilter =
                    new FileChooser.ExtensionFilter("Javafiles (*.java)", "*.java");
            javaFileChooser.getExtensionFilters().add(extFilter);

            File javaSaveFile = javaFileChooser.showSaveDialog(stage);

            if (javaSaveFile != null)
            {
                saveJavaFile(javaTextArea.getText(), javaSaveFile);
            }

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
                    new FileChooser.ExtensionFilter("Java files (*.java)", "*.java");
            javaFileChooser.getExtensionFilters().add(extFilter);

            File javaFile = javaFileChooser.showOpenDialog(stage);

            if (javaFile != null)
            {
                javaTextArea.setText(loadJavaFile(javaFile));
                System.out.println(compileFunction(javaFile));

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

    private void saveJavaFile(String javaCode, File file)
    {
        try
        {
            FileWriter javaFileWriter = new FileWriter(file);
            javaFileWriter.write(javaCode);
            javaFileWriter.close();
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
                sb.append(javaCode);
                sb.append(System.getProperty("line.separator"));
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