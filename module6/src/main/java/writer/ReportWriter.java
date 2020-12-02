package writer;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class ReportWriter {
    private final static String OUTPUT_FILE = "src/main/resources/output.txt";
    private Writer writer;

    /**
     * Open ReportWriter
     *
     * @throws IOException
     */
    public void openWriter() throws IOException {
        if (writer == null) {
            writer = new FileWriter(OUTPUT_FILE);
        }
    }

    /**
     * Write lines
     *
     * @param string line, what need to write.
     * @throws IOException
     */
    public void writeLine(String string) throws IOException {
        writer.write(string);
    }

    /**
     * close WriteWrapper
     *
     * @throws IOException
     */
    public void closeWrapper() throws IOException {
        writer.close();
    }
}
