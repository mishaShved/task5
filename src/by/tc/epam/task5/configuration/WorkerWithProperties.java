package by.tc.epam.task5.configuration;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class WorkerWithProperties {

    private static WorkerWithProperties ourInstance;
    private String xmlFilePath;
    private String responcePagePath;


    private WorkerWithProperties() throws IOException{

       
        Properties props = new Properties();
        props.load(new FileInputStream(new File("/home/misha/Desktop/Task5_1/src/properties.ini")));
        xmlFilePath = props.getProperty("FILE_NAME");
        responcePagePath = props.getProperty("JSP_PAGE");

    }

    public static WorkerWithProperties getOurInstance() throws IOException{

        if (ourInstance == null) {
            return ourInstance = new WorkerWithProperties();
        }else {
            return ourInstance;
        }
    }

    public String getXMLFilePath() {
        return xmlFilePath;
    }

    public String getResponcePagePath() {
        return responcePagePath;
    }
}