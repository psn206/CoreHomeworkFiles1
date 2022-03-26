import javax.imageio.IIOException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class Main {

    public static StringBuilder initializationDir(String[] nameDirs) {
        StringBuilder log = new StringBuilder();
        for (int i = 1; i < nameDirs.length; i++) {
            File dir = new File(nameDirs[0], nameDirs[i]);
            log.append("Директория: " + nameDirs[i] + " создана - " + dir.mkdir());
            log.append("\n");
        }
        return log;
    }

    public static StringBuilder initializationFile (String[] nameFile) {
        StringBuilder log = new StringBuilder();
        try {
            for (int i = 1; i < nameFile.length; i++) {
                File f = new File(nameFile[0] + nameFile[i]);
                log.append("Файл: " + nameFile[i]+ " создан- "+   f.createNewFile());
                log.append("\n");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return log;
    }

    public static void main(String[] args) throws IOException {

        StringBuilder log = new StringBuilder();
        log.append(initializationDir(new String[]{"D://Games", "src", "res", "savegames", "temp"}));
        log.append(initializationDir(new String[]{"D://Games//src", "main", "test"}));
        log.append(initializationDir(new String[]{"D://Games//res", "drawables", "vectors", "icons"}));
        log.append(initializationFile(new String[]{"D://Games//src//main//", "Main.java", "Utils.java"}));
        log.append(initializationFile(new String[]{"D://Games//temp//", "temp.txt"}));
        System.out.println(log);
        try(FileWriter writer = new FileWriter ("D://Games//temp//temp.txt", false)) {
            writer.write(log.toString());
        } catch (IIOException e){
            System.out.println(e);
        }
    }
}

