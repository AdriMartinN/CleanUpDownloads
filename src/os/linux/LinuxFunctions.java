package os.linux;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class LinuxFunctions {

    public File getLinuxDownloadsFolder(final String userHome) {
        final Path configFilePath = Paths.get(userHome, ".config/user-dirs.dirs");
        if (configFilePath.toFile().exists()) {
            try (final BufferedReader reader = new BufferedReader(new FileReader(configFilePath.toFile()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    if (line.startsWith("XDG_DOWNLOAD_DIR")) {
                        final String[] parts = line.split("=");
                        if (parts.length == 2) {
                            final String path = parts[1].trim().replace("$HOME", userHome).replaceAll("\"", "");
                            return Paths.get(path).toFile();
                        }
                    }
                }
            } catch (final IOException e) {
                e.printStackTrace();
            }
        }

        return Paths.get(userHome, "Downloads").toFile();
    }
}
