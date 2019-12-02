import org.apache.commons.io.IOUtils;

public class FileReader {

    private String file;

    public FileReader(String file) {
        this.file = file;
    }

    public String readRawDataToString() throws Exception {
        ClassLoader classLoader = getClass().getClassLoader();
        return IOUtils.toString(classLoader.getResourceAsStream(file));
    }

}
