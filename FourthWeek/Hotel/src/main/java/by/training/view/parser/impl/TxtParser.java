package by.training.view.parser.impl;

import by.training.bean.Request;
import by.training.view.parser.Parser;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aliaksandr_Nestsiarovich on 4/26/2016.
 */
public class TxtParser implements Parser {

    List<Request> commandList = new ArrayList<>();

    /**
     * Parse txt file line by line.
     *
     * @param path String with path to txt.
     */
    public void parseByPath(String path) {

        FileInputStream fis;
        BufferedReader br;
        String line;

        try {
            File file = new File(path);
            fis = new FileInputStream(file);
            br = new BufferedReader(new InputStreamReader(fis, "UTF8"));
            while ((line = br.readLine()) != null) {
                if (!line.isEmpty()) {
                    parseLine(line);
                }
            }
            br.close();
        } catch (UnsupportedEncodingException e) {
            System.err.println("Unsupported coding. UTF-8 required");
        } catch (FileNotFoundException e) {
            System.err.println("File Not Found!");
        } catch (IOException e) {
            System.err.println("Can't read from the source file");
        }

    }

    /**
     * Parse line and form Action object.
     *
     * @param line representing one line of file.
     */
    private void parseLine(String line) {
        Request request = new Request(line);
        String[] parts = line.split(" ", 2);
        request.setCommandName(parts[0]);
        if (parts.length > 1) {
            for (String param : parts[1].split(" | ")) {
                String[] pair = param.split("=");
                if (pair.length == 2) {
                    request.addArgument(pair[0], pair[1]);
                }
            }
            commandList.add(request);
        } else {
            commandList.add(request);
        }
    }

    public List<Request> getRequestList() {
        return commandList;
    }

}
