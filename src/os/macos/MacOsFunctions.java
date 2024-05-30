package os.macos;

import java.io.File;
import java.nio.file.Paths;

public class MacOsFunctions {

    public File getMacOsDownloadsFolder(final String userHome) {
        return Paths.get(userHome, "Downloads").toFile();
    }
}
