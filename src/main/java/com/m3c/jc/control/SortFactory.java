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

    static Logger log = Logger.getLogger(SortFactory.class.getName());

    private static final String TYPE_NOT_FOUND = "Sorry but there is no sorter called ";
    private static final String CONFIG_ERROR = "Sorry config file was not found";

    public static Sorter getInstance() throws SortManagerException {

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
                    throw new SortManagerException(TYPE_NOT_FOUND + "'" + sorter + "'");
            }
        } catch (IOException e) {
            log.debug("Exception thrown: " + CONFIG_ERROR);
            throw new SortManagerException(CONFIG_ERROR);
        }
    }
}
