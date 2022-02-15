package com.offers.cvm_cc_tariffs.service;

import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;

@Service
public class OfferService {
    public void copyFile(String filename, String destination){
        try {
            System.out.println("Зашли в папку проверить есть ли файл");
            Path sourceDir = Paths.get(filename);
            Path destinationDir = Paths.get(destination);
            if (Files.exists(sourceDir)) {
                System.out.println("Файл существует, значит копируем в свою папку");
                Files.copy(sourceDir, destinationDir, StandardCopyOption.REPLACE_EXISTING);
            }
            else {
                System.out.println("Не могу найти файл сервисов");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void renameFile(String fileName, String pathname) throws IOException {
        File folder = new File(pathname);
        File[] list = folder.listFiles();
        Path fileToRenamePath = Paths.get(pathname + "/" + fileName + ".csv");
        String renamedFile = fileName + " " + LocalDate.now() + ".csv";
        Path toCheck = Paths.get(pathname + "/" + renamedFile);
        for (File f : list){
            if (f.getName().endsWith(fileName + ".csv")){
                if (!Files.exists(toCheck)){
                    Files.move(fileToRenamePath, fileToRenamePath.getParent().resolve(renamedFile), StandardCopyOption.REPLACE_EXISTING);
                    System.out.println("Файл " + fileName + " переименован" + " на " + renamedFile);
                }
                else {
                    System.out.println("Сегодня файл был переименован");
                }
            }
        }
    }

    public ArrayList<String> fileList(String pathname, String fileType){
        File folder = new File(pathname);
        File[] list = folder.listFiles();
        ArrayList<String> offers = new ArrayList<>();
        for(int i = 0; i < list.length; i++){
            String fileName = list[i].getName();
            if (fileName.startsWith(fileType)){
                offers.add(fileName);
            }
        }
        return offers;
    }


    public boolean compareFiles(String destination, String fromSource, String fileType){
        ArrayList<String> list = fileList(destination, fileType);
        String fileToday = fileType + " " + LocalDate.now() + ".csv";
        int a = 0;
        for (String result : list){
            if (result == null){
                return false;
            }
            if (result.equals(fromSource)){
                return true;
            }
        }
        return false;
    }

    public boolean checkNull(String getString){
        return getString.equals("");
    }
}
