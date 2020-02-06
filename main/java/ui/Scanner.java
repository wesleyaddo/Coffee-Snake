package ui;

import java.io.*;

public class Scanner
{
    String javaCode;
    String pythonCode;

    public static final String JAVA_FILE = "javaCode.txt";
    public static final String PYTHON_FILE = "pythonCode.txt";

    public String getJavaCode()
    {
        return javaCode;
    }

    public void setJavaCode(String javaCode)
    {
        this.javaCode = javaCode;
    }

    public String getPythonCode()
    {
        return pythonCode;
    }

    public void setPythonCode(String pythonCode)
    {
        this.pythonCode = pythonCode;
    }

    public void writeJavaCodeToFile(String javaCode)
    {
        try
        {
            BufferedWriter javaCodeFileWriter = new BufferedWriter(new FileWriter(JAVA_FILE));
            javaCodeFileWriter.write(javaCode);
            javaCodeFileWriter.close();
        } catch (Exception e)
        {
            System.out.println("An Exception has been caught: " + e);
        }
    }

    public String readPythonCodeFromFile()
    {
        StringBuilder pythonCode = new StringBuilder();
        try (BufferedReader pythonCodeFileReader = new BufferedReader(new FileReader(PYTHON_FILE)))
        {
            String sCurrentLine;
            while ((sCurrentLine = pythonCodeFileReader.readLine()) != null)
            {
                pythonCode.append(sCurrentLine).append("\n");
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        return pythonCode.toString();
    }
}
