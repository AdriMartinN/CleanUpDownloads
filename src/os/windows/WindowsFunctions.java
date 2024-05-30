package os.windows;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class WindowsFunctions {

    public File getWindowsDownloadsFolder() {
        final List<String> commonDownloadPaths = Arrays.asList(
                System.getProperty("user.home") + File.separator + "Downloads",
                "C:" + File.separator + "Users" + File.separator + "Public" + File.separator + "Downloads",
                "C:" + File.separator + "Users" + File.separator + "Default" + File.separator + "Downloads"
        );

        for (final String path : commonDownloadPaths) {
            final File downloadsFolder = new File(path);
            if (downloadsFolder.exists() && downloadsFolder.isDirectory()) {
                return downloadsFolder;
            }
        }

        return null;
    }
}
