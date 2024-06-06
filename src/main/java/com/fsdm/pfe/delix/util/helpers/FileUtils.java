/*
 *
 *  * @project : DeliX
 *  * @created : 06/06/2024, 16:17
 *  * @modified : 06/06/2024, 16:17
 *  * @description : This file is part of the DeliX project.
 *  * @license : MIT License
 *
 */

package com.fsdm.pfe.delix.util.helpers;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileUtils {
    // convert list of string to file
    public static File convertListToFile(List<String> list, String fileName) {
        File file = new File(fileName);
        try {
            FileWriter writer = new FileWriter(file);
            for (String str : list) {
                writer.write(str + System.lineSeparator());
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }
}