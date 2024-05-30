package file;

import os.CheckOs;

import javax.swing.*;
import java.io.File;

public class FileService {
    private final CheckOs checkOs;

    public FileService() {
        this.checkOs = new CheckOs();
    }

    public void emptyDownloadsFolder() {
        final File downloadsFolder = this.checkOs.getDownloadsFolder();

        if (downloadsFolder != null && downloadsFolder.exists() && downloadsFolder.isDirectory()) {
            final File[] files = downloadsFolder.listFiles();

            if (files != null) {
                for (final File file : files) {
                    this.deleteFileOrFolder(file);
                }
            }

            JOptionPane.showMessageDialog(null, "The downloads folder has been emptied.");
        } else {
            JOptionPane.showMessageDialog(null, "Downloads folder not found.");
        }
    }

    private void deleteFileOrFolder(final File file) {
        if (file.isDirectory()) {
            final File[] contents = file.listFiles();
            if (contents != null) {
                for (final File f : contents) {
                    this.deleteFileOrFolder(f);
                }
            }
        }

        if (!file.delete()) {
            System.err.println("Failed to delete file: " + file.getAbsolutePath());
        }
    }
}
