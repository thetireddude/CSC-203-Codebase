import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileProcessor {

    /**
     * Processes arithmetic expressions line-by-line in the given file.
     *
     * @param filePath Path to a file containing arithmetic expressions.
     */
    public static void processFile(String filePath) {
        File infile = new File(filePath);
        try (Scanner scan = new Scanner(infile)) {
            while (scan.hasNext()) {
                String line = scan.nextLine();
                // TODO: Process each line of the input file, handling blank 
                // lines and spacing differences as appropriate
                if(line.isEmpty()){
                    continue;
                }
                linkedList lineList = BigNumArithmetic.getLineList(line);
                String result = BigNumArithmetic.checkOperator(lineList);
                System.out.println(result);

            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + infile.getPath());
        }
    }
}
