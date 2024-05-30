package os.windows;

import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.nio.file.Path;

public class WindowsFunctions {

    public File getWindowsDownloadsFolder() {
        final Path downloadsPath = FileSystemView.getFileSystemView()
                .getDefaultDirectory()
                .toPath()
                .resolve("Downloads");
        return downloadsPath.toFile();
    }
}

