package com.offers.cvm_cc_tariffs.service;

import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;

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
}
