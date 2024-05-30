package os;

import os.linux.LinuxFunctions;
import os.macos.MacOsFunctions;
import os.windows.WindowsFunctions;

import java.io.File;

public class CheckOs {
    MacOsFunctions macOsFunctions;
    LinuxFunctions linuxFunctions;
    WindowsFunctions windowsFunctions;

    public CheckOs() {
        this.macOsFunctions = new MacOsFunctions();
        this.linuxFunctions = new LinuxFunctions();
        this.windowsFunctions = new WindowsFunctions();
    }


    public File getDownloadsFolder() {
        final String osName = System.getProperty("os.name").toLowerCase();
        final String userHome = System.getProperty("user.home");

        if (osName.contains("win")) {
            return this.windowsFunctions.getWindowsDownloadsFolder();
        } else if (osName.contains("mac")) {
            return this.macOsFunctions.getMacOsDownloadsFolder(userHome);
        } else if (osName.contains("nux")) {
            return this.linuxFunctions.getLinuxDownloadsFolder(userHome);
        } else {
            throw new UnsupportedOperationException("Unsupported operating system");
        }
    }
}
