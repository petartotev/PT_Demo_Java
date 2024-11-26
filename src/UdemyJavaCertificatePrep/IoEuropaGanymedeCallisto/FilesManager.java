package IoEuropaGanymedeCallisto;

import java.io.*;

public class FilesManager {
    public void playWithCopyingTextFileWithNoBufferingUsingFileReaderAndFileWriter() {
        String currentDirectory = System.getProperty("user.dir");  /* Get current directory */
        File srcFile = new File("./res/source.txt");      /* Loading physical files into Java objects */
        File destFile = new File("./res/destination.txt"); /* No need for file to exist before program execution - it creates one if missing! */

        try(var reader = new FileReader(srcFile); /* using try-with-resources to make sure close() is applied on the 2 objects */
            var writer = new FileWriter(destFile)) {
            int c;
            while ((c = reader.read()) != - 1) {
                writer.write(c); /* writing character by character with write() method */
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void playWithCopyingTextFileUsingBuffering() {
        File srcFile = new File("./res/source.txt");      /* Loading physical files into Java objects */
        File destFile = new File("./res/destinationBuffered.txt"); /* No need for file to exist before program execution - it creates one if missing! */

        try(var reader = new BufferedReader(new FileReader(srcFile)); /* using try-with-resources to make sure close() is applied on the 2 objects */
            var writer = new BufferedWriter(new FileWriter(destFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line); /* writing character by character with write() method */
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void playWithCopyingBinaryFileWithNoBuffering() {
        File srcFile = new File("./res/Sources-Root.png");      /* Loading physical files into Java objects */
        File destFile = new File("./res/Sources-Root-Copied.png"); /* No need for file to exist before program execution - it creates one if missing! */

        try(var reader = new FileInputStream(srcFile); /* using try-with-resources to make sure close() is applied on the 2 objects */
            var writer = new FileOutputStream(destFile)) {
            int c;
            while ((c = reader.read()) != - 1) {
                writer.write(c); /* writing character by character with write() method */
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void playWithCopyingBinaryFileUsingBuffering() {
        File srcFile = new File("./res/Sources-Root.png");      /* Loading physical files into Java objects */
        File destFile = new File("./res/Sources-Root-Copied-Buffered.png"); /* No need for file to exist before program execution - it creates one if missing! */

        try(var in = new BufferedInputStream(new FileInputStream(srcFile)); /* using try-with-resources to make sure close() is applied on the 2 objects */
            var out = new BufferedOutputStream(new FileOutputStream(destFile))) {
            var buffer = new byte[1024];
            int numBytesRead;
            while ((numBytesRead = in.read(buffer)) > 0) { /* reads buffer (up to 1024 bytes) and stores in buffer, and returns number of bytes read */
                out.write(buffer, 0, numBytesRead); /* write bytes from buffer, from 0 to buffer length */
                out.flush(); /* flush() => execute this write command right away! Used if we want to ensure data is written immediately! */

                /*
                Example: you transfer a file of 16 GB. 2 GB already transferred and electricity stops.
                If flush() -> 2 GB will be transferred.
                If not flush() -> the whole file will be ready when all is transferred.
                 */
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
