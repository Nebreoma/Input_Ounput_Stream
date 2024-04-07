import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.lang.StringBuilder;

//Задача 1: Установка

public class Main {
    public static void main(String[] args) {
        String file;

        /// создание temp и файл temp.txt
        File dirTemp = new File("D:\\#test\\Java_2024\\Games_1.3\\temp");
        File fileTemp = new File(dirTemp, "temp.txt");
        if (dirTemp.mkdir()) { //если директория создана, то создаем файл
            try {
                if (fileTemp.createNewFile()) { //если файл создан, то записываем его
                    file = "Каталог temp и файл temp.txt созданы\n";
                    try (FileWriter writer = new FileWriter("D:\\#test\\Java_2024\\Games_1.3\\temp\\temp.txt", false)) {
                        writer.write(file);
                        writer.flush();
                    } catch (IOException ex) {
                        System.out.println("Возникла ошибка во время создания файла temp.txt, проверьте данные");
                    }
                }
            } catch (IOException ex) {
                System.out.println("Возникла ошибка во время создания каталога, проверьте данные");
            }
        } else {
            System.out.println("Возникла ошибка во время создания каталога temp, проверьте данные");
        }

        ///создание src
        File dirSrc = new File("D:\\#test\\Java_2024\\Games_1.3\\src");
        file = "src";
        if (dirSrc.mkdir()) { //если директория создана, то создаем файл
            writeToFileTemp(file);
        } else {
            nonWriteToFileTemp(file);
        }
        ///создание res
        File dirRes = new File("D:\\#test\\Java_2024\\Games_1.3\\res");
        file = "res";
        if (dirRes.mkdir()) { //если директория создана, то создаем файл
            writeToFileTemp(file);
        } else {
            nonWriteToFileTemp(file);
        }

        ///создание savegames
        File dirSavegames = new File("D:\\#test\\Java_2024\\Games_1.3\\savegames");
        file = "savegames";
        if (dirSavegames.mkdir()) { //если директория создана, то создаем файл
            writeToFileTemp(file);
        } else {
            nonWriteToFileTemp(file);
        }

        ///создание подкаталога main в src
        File dirMain = new File("D:\\#test\\Java_2024\\Games_1.3\\src\\main");
        file = "main";
        if (dirMain.mkdir()) { //если директория создана, то создаем файл
            writeToFileTemp(file);
        } else {
            nonWriteToFileTemp(file);
        }

        ///создание подкаталога test в src
        File dirTest = new File("D:\\#test\\Java_2024\\Games_1.3\\src\\test");
        file = "test";
        if (dirTest.mkdir()) { //если директория создана, то создаем файл
            writeToFileTemp(file);
        } else {
            nonWriteToFileTemp(file);
        }

        ///создание подкаталога drawables в res
        File dirDrawables = new File("D:\\#test\\Java_2024\\Games_1.3\\res\\drawables");
        file = "drawables";
        if (dirDrawables.mkdir()) { //если директория создана, то создаем файл
            writeToFileTemp(file);
        } else {
            nonWriteToFileTemp(file);
        }

        ///создание подкаталога vectors в res
        File dirVectors = new File("D:\\#test\\Java_2024\\Games_1.3\\res\\vectors");
        file = "vectors";
        if (dirVectors.mkdir()) { //если директория создана, то создаем файл
            writeToFileTemp(file);
        } else {
            nonWriteToFileTemp(file);
        }

        ///создание подкаталога icons в res
        File dirIcons = new File("D:\\#test\\Java_2024\\Games_1.3\\res\\icons");
        file = "icons";
        if (dirIcons.mkdir()) { //если директория создана, то создаем файл
            writeToFileTemp(file);
        } else {
            nonWriteToFileTemp(file);
        }

        ///создание файла Main.java в подкаталоге main каталога src
        File fileMain = new File(dirMain, "Main.java");
        file = "Main.java";
        try {
            if (fileMain.createNewFile()) { //если файл создан, то записываем его
                writeToFileTemp(file);
            }
        } catch (IOException ex) {
            nonWriteToFileTemp(file);
        }

        ///создание файла Utils.java в подкаталоге main каталога src
        File fileUtils = new File(dirMain, "Utils.java");
        file = "Utils.java";
        try {
            if (fileUtils.createNewFile()) { //если файл создан, то записываем его
                writeToFileTemp(file);
            }
        } catch (IOException ex) {
            nonWriteToFileTemp(file);
        }
    }//конец main

    public static void writeToFileTemp(String file) {
        StringBuilder text = new StringBuilder(file + " создан\n");
        try (FileWriter writer = new FileWriter("D:\\#test\\Java_2024\\Games_1.3\\temp\\temp.txt", true)) {
            writer.write(text.toString());
            writer.flush();
        } catch (IOException ex) {
            System.out.println("Возникла ошибка во время записи, проверьте данные");
        }
    }

    public static void nonWriteToFileTemp(String file) {
        StringBuilder text = new StringBuilder(file + " не создан\n");
        try (FileWriter writer = new FileWriter("D:\\#test\\Java_2024\\Games_1.3\\temp\\temp.txt", true)) {
            writer.write(text.toString());
            writer.flush();
        } catch (IOException ex) {
            System.out.println("Возникла ошибка во время записи, проверьте данные");
        }
    }
}//конец программы
