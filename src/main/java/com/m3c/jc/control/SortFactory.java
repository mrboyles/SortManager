package com.m3c.jc.control;

import com.m3c.jc.model.BinaryTreeSorter;
import com.m3c.jc.model.BubbleSorter;
import com.m3c.jc.model.MergeSorter;
import com.m3c.jc.model.Sorter;
import org.apache.log4j.Logger;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class SortFactory {

    //For logging
    static Logger log = Logger.getLogger(SortFactory.class.getName());

    private static final String TYPE_NOT_FOUND = "Sorry but there is no sorter called ";
    private static final String TYPE_NOT_STATED = "Sorry but there is no sorter selected in the config file";
    private static final String CONFIG_ERROR = "Sorry config file was not found";

    public static Sorter getInstance() throws SortManagerException {
        //Tries to load up an instance of a sorter, specifically the one selected in the config file
        try (FileReader fr = new FileReader("resources/factory.properties")) {
            Properties properties = new Properties();
            properties.load(fr);
            String sorter = properties.getProperty("sorter");
            switch (sorter) {
                case "bubble":
                    return new BubbleSorter();
                case "merge":
                    return new MergeSorter();
                case "binary":
                    return new BinaryTreeSorter();
                default:
                    log.debug("Exception thrown: " + TYPE_NOT_FOUND + "'" + sorter + "'");
                    //Error message for invalid sorter name
                    throw new SortManagerException(TYPE_NOT_FOUND + "'" + sorter + "'");
            }
        } catch (IOException ioe) {
            log.debug("Exception thrown: " + CONFIG_ERROR);
            //Error message for missing config file
            throw new SortManagerException(CONFIG_ERROR);
        } catch (NullPointerException npe) {
            log.debug(TYPE_NOT_STATED);
            //Error for sorter type not being stated in config file
            throw new SortManagerException(TYPE_NOT_STATED);
        }
    }
}
