import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.util.zip.*;

//Задача 3: Загрузка

public class Main_loadgame {
    public static void main(String[] args) {
        //распаковка
        openZip("D:\\#test\\Java_2024\\Games_1.3\\savegames\\zipSaveGame.zip");

        //загрузка сохраненного файла
        GameProgress load1 = openProgress ("D:\\#test\\Java_2024\\Games_1.3\\savegames\\save1.dat");
        System.out.println(load1);

    }//конец main

    public static void openZip (String fileZip) {
        ///
        try(ZipInputStream zin = new ZipInputStream(new FileInputStream(fileZip))) {
            ZipEntry entry;
            String name;
            while ((entry = zin.getNextEntry()) != null) {
                name = entry.getName();
                FileOutputStream fout = new FileOutputStream(name);
                for (int c = zin.read(); c != -1; c = zin.read()) {
                    fout.write(c);
                }
                fout.flush();
                zin.closeEntry();
                fout.close();
            }
        } catch (Exception ex) {
            System.out.println("Возникла ошибка во время извлечения файла из архива, проверьте данные");
        }
    }

    public static GameProgress openProgress (String file) {
        GameProgress gameProgress = null;
        try (FileInputStream fis = new FileInputStream(file);
             ObjectInputStream ios = new ObjectInputStream(fis)) {
            gameProgress = (GameProgress) ios.readObject();
        } catch (Exception ex) {
            System.out.println("Возникла ошибка во время загрузки сохраненного файла, проверьте данные");
        }
        return gameProgress;
    }
}//конец программы
