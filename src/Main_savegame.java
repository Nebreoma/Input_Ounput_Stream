import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.*;

//Задача 2: Сохранение

public class Main_savegame {
    public static void main(String[] args) {

        List<String> listSave = new ArrayList<>();

        GameProgress save1 = new GameProgress(100, 10, 3, 300);
        GameProgress save2 = new GameProgress(20, 1, 19, 10);
        GameProgress save3 = new GameProgress(80, 22, 5, 150);

        listSave.add("D:\\#test\\Java_2024\\Games_1.3\\savegames\\save1.dat");
        listSave.add("D:\\#test\\Java_2024\\Games_1.3\\savegames\\save2.dat");
        listSave.add("D:\\#test\\Java_2024\\Games_1.3\\savegames\\save3.dat");

        ///сохранение
        saveGame(listSave.get(0), save1);
        saveGame(listSave.get(1), save2);
        saveGame(listSave.get(2), save3);

        ///архивация
        zipFiles("D:\\#test\\Java_2024\\Games_1.3\\savegames\\zipSaveGame.zip", listSave);

        ///удаление

        for (String s : listSave) {
            File fileSave = new File(s);
            if (!fileSave.delete()) {
                System.out.println("Возникла ошибка во время удаления файла, проверьте данные");
            }
        }
    }//конец main

    public static void saveGame(String file, GameProgress save) {
        try (FileOutputStream fos = new FileOutputStream(file);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(save);
        } catch (Exception ex) {
            System.out.println("Возникла ошибка во время создания файла save1.dat, проверьте данные");
        }
    }

    public static void zipFiles(String file, List<String> list) {

        try (ZipOutputStream zout = new ZipOutputStream(new FileOutputStream(file))) {
            for (String s : list) {
                FileInputStream fis = new FileInputStream(s);
                zout.putNextEntry(new ZipEntry(s));
                byte[] buffer = new byte[fis.available()];
                fis.read(buffer);
                zout.write(buffer);
                fis.close();
            }
            zout.closeEntry();

        } catch (Exception ex) {
            System.out.println("Возникла ошибка во время архивации, проверьте данные");
        }
    }
}//конец программы
