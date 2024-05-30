import file.FileService;

import javax.swing.*;

public class Main {

    public static void main(final String[] args) {
        final FileService fileUtils = new FileService();

        final int result = JOptionPane.showConfirmDialog(null,
                "Are you sure you want to empty the contents of the downloads folder?",
                "Confirm",
                JOptionPane.YES_NO_OPTION);

        if (result == JOptionPane.YES_OPTION) {
            fileUtils.emptyDownloadsFolder();
        }
    }
}
