package reader;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Slf4j
public class Reader {

    public Reader() {
    }

    public List<String> readValues(String filePath) {
        FileReader fileReader = getFileFromPath(filePath);

        if(fileReader != null) {
            return getValuesAsList(fileReader);
        }

        return Collections.emptyList();
    }

    private FileReader getFileFromPath(String filePath) {
        File file = new File(filePath);
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(file);
        } catch (FileNotFoundException e) {
            log.error("Could not get file from path.");
            e.printStackTrace();
        }

        return fileReader;
    }

    private List<String> getValuesAsList(FileReader fileReader) {

        List<String> result = new ArrayList<>();

        try(BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line = bufferedReader.readLine();

            while(line != null) {
                result.add(line);
                line = bufferedReader.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
            log.error("Could not read values from source file.");
        }

        return result;
    }
}
