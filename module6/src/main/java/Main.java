import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try {
            Writer writer = new FileWriter("src/main/resources/outputRammTree.txt");
            printTree(0, new File("d:/Rammstein"), writer);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            readFromFile();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    static void printTree(int depth, File file, Writer writer) throws IOException {
        StringBuilder indent = new StringBuilder();
        StringBuilder indentMinus = new StringBuilder();
        StringBuilder intendLine = new StringBuilder();
        File[] files;
        int length = 4;
        for (int i = 0; i < depth; i++) {
            indent.append(" ");
            indentMinus.append("-");
        }
        for (int i = 0; i < depth - length; i++) {
            intendLine.append(" ");
        }
        if (file.isDirectory()) {
            writer.write( indent.toString() + "|" +indentMinus.toString() + file.getName() + "\n");
//            System.out.print("|" + indent.toString() + file.getName() + "\n");
        } else{
            writer.write( intendLine +"|  " + file.getName() + "\n");

        }
        if (file.isDirectory()) {
            files = file.listFiles();
            sortFileWrappers(Arrays.asList(files));
            for (File value : files) {
                printTree(depth + length, value, writer);
            }
        }
    }
    private static void sortFileWrappers(List<File> childFiles) {
        childFiles.sort((file1, file2) -> {
            if ((file1.isFile() && file2.isFile())
                    || (file1.isDirectory() && file2.isDirectory())) {
                return file1.getName().compareTo(file2.getName());
            }
            if (file1.isFile() && file2.isDirectory()) {
                return -1;
            }
            if (file2.isFile() && file1.isDirectory()) {
                return 1;
            }
            return 0;
        });
    }
    public static void readFromFile() throws FileNotFoundException {
        Queue <String> allTitles = new ArrayDeque<>();
        List<String> stringList = new ArrayList<>();
        int directionCheck = 0;
        Scanner scanner = new Scanner(new File("src/main/resources/outputRammTree.txt"));
        while (scanner.hasNextLine()){
            allTitles.offer(scanner.nextLine());
        }
        for (String name : allTitles){
            if(name.lastIndexOf("|--") > 0){
                directionCheck++;
            }
            else {
                stringList.add(name);
            }
        }
        System.out.println(directionCheck);
//        System.out.println(stringList);
        scanner.close();
    }
}
