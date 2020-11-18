package com.dkat.module6;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    private final static String DIR_PREFIX = "|---";
    private final static String FILE_PREFIX = "|      ";
    private final static String DEFAULT_INDENTAION = "    ";

    public static void main(String[] args) {
        FileWrapper rootDirWrapper = new FileWrapper(new File("D:/temp"));
        readFiles(rootDirWrapper);
        System.out.println(rootDirWrapper);

        printWrappedFiles(rootDirWrapper, 0);
    }

    private static FileWrapper readFiles(FileWrapper fileWrapper) {
        ArrayList<FileWrapper> childWrappers = new ArrayList<>();
        File rootFile = fileWrapper.getFile();
        if (rootFile.isFile()) {
            return fileWrapper;
        } else {
            List<File> childFiles = Arrays.asList(rootFile.listFiles());
            sortFileWrappers(childFiles);
            for (File childFile : childFiles) {
                FileWrapper childWrapper = readFiles(new FileWrapper(childFile));
                childWrappers.add(childWrapper);
            }
            fileWrapper.setChildFiles(childWrappers);
        }
        return fileWrapper;
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

    private static void printWrappedFiles(FileWrapper rootDirWrapper, int indentationLevel) {
        StringBuilder indentation = new StringBuilder();
        for (int index = 1; index < indentationLevel; index++) {
            indentation.append(DEFAULT_INDENTAION);
        }
        if (rootDirWrapper.getFile().isFile()) {
            System.out.println(indentation + FILE_PREFIX + rootDirWrapper.getFile().getName());
        } else {
            System.out.println(indentation + DIR_PREFIX + rootDirWrapper.getFile().getName());
            for (FileWrapper childWrapper : rootDirWrapper.getChildFiles()) {
                printWrappedFiles(childWrapper, indentationLevel + 1);
            }
        }
    }
}
