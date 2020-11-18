package com.dkat.module6;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

public class FileWrapper {
    private List<FileWrapper> childFiles;
    private File file;

    public FileWrapper(File file) {
        this.file = file;
        this.childFiles = new LinkedList<>();
    }

    public List<FileWrapper> getChildFiles() {
        return childFiles;
    }

    public void setChildFiles(List<FileWrapper> childFiles) {
        this.childFiles = childFiles;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    @Override
    public String toString() {
        return "FileWrapper{" +
                "file=" + file +
                ", childFiles=" + childFiles +
                '}';
    }
}
