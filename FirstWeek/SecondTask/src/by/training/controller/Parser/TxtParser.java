package by.training.controller.Parser;

        import by.training.model.Request;
        import java.io.BufferedReader;
        import java.io.File;
        import java.io.FileInputStream;
        import java.io.FileNotFoundException;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.io.UnsupportedEncodingException;
        import java.util.ArrayList;
        import java.util.List;
        import java.util.regex.Matcher;
        import java.util.regex.Pattern;

/**
 * Created by Aliaksandr_Nestsiarovich on 4/26/2016.
 */
public class TxtParser implements Parser{

    List<Request> commandList = new ArrayList<>();

    /**
     * Parse txt file line by line.
     * @param path String with path to txt.
     */
    public void parseByPath(String path) {

        FileInputStream fis;
        BufferedReader br;
        String line = null;

        try {
            File file = new File(path);
            fis = new FileInputStream(file);
            br = new BufferedReader(new InputStreamReader(fis, "UTF8"));
            while ((line = br.readLine()) != null) {
                if(!line.isEmpty()) {
                    parseLine(line);
                }
            }
            br.close();
        } catch (UnsupportedEncodingException e) {
            System.err.println("Unsupported coding. UTF-8 required");
            System.exit(0);
        }
        catch (FileNotFoundException e) {
            System.err.println("File Not Found!");
            System.exit(0);
        } catch (IOException e) {
            System.err.println("Can't read from the source file");
            System.exit(0);
        }

    }

    /**
     * Parse line and form Action object.
     * @param line representing one line of file.
     */
    private void parseLine(String line) {

        List<String> list = new ArrayList<>();
		/*Pattern for dividing string for words with spaces or quoted sentences*/
        Matcher m = Pattern.compile("(['\"])((?:\\\\\\1|.)+?)\\1|([^\\s\"']+)").matcher(line);
        while (m.find()) {
			/*Sanitize string for blank chars like \uFEFF*/
            String temp = m.group(0).replaceAll("[\uFEFF-\uFFFF]", "");

			/*escape quotes by -QUOT- for difficult queries*/
            temp = temp.replaceAll("-QUOT-", "\"");
			/*Delete quotes by sides*/
            if (temp.length() >= 2
                    && temp.charAt(0) == '"'
                    && temp.charAt(temp.length()-1) == '"') {
                list.add(temp.substring(1, temp.length() - 1));
                continue;
            }
            list.add(temp);
        }

        if (list.size() > 0)
        {
            Request tmp = new Request(line, list.toArray(new String[0]));
            commandList.add(tmp);
        }
    }

    public List<Request> getRequestList() {

        return commandList;

    }

}
