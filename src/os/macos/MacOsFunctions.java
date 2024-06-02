package os.macos;

import java.io.File;

public class MacOsFunctions {

    public File getMacOsDownloadsFolder() {
        return new File(System.getProperty("user.home") + "/Downloads");
    }
}