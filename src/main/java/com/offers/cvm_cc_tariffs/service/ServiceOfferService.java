package com.offers.cvm_cc_tariffs.service;

import com.offers.cvm_cc_tariffs.model.ServiceOffer;
import com.offers.cvm_cc_tariffs.repo.ServiceOffersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;

@Service
public class ServiceOfferService extends OfferService{
    @Autowired
    private ServiceOffersRepo serviceOffersRepo;
    String line = "";
    String pathname = "D:/doc";
    String destination = "D:/anotherdoc";
    String fileType = "CVM_offers_services";

    @Scheduled(cron = "0/15 * * * * *")
    public void execute(){
        ArrayList<String> offers = fileList(pathname, fileType);
        for (String s : offers){
            if (compareFiles(destination, s, fileType)){
                System.out.println("Файл услуг " + s + " уже есть в нашей папке");
                System.out.println();
            }
            else {
                System.out.println("Файла услуг " + s + " нет в папке, копируем");
                saveServiceOffers(pathname, destination, s);
            }
        }
    }
    private void saveServiceOffers(String pathname, String destination, String FileName) {
        try {
            if(FileName != null){
            copyFile(pathname + "/" + FileName, destination + "/" + FileName);
            System.out.println("Обращаемся к файлу");
            FileInputStream stream = new FileInputStream(destination + "/" + FileName);
            InputStreamReader inputStreamReader = new InputStreamReader(stream, "Cp1251");
            System.out.println("Кодировка русского языка");
            BufferedReader reader = new BufferedReader(inputStreamReader);
            System.out.println("Считываем файл");
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] data = line.split("\",");
                ServiceOffer offer = new ServiceOffer();
                offer.setDescriber_number(data[0].substring(1));
                offer.setDate_of_fix(data[1].substring(1));
                offer.setOffer_id(data[2].substring(1));
                offer.setCampaign_offer_name(data[3].substring(1));
                offer.setEmployee(data[4].substring(1));
                offer.setOffer_status(data[5].substring(1));
                offer.setSubdivision(data[6].substring(1));
                offer.setPackage_name(data[7].substring(1));
                offer.setConnection_fact(data[8].substring(1));
                offer.setPayment_date(data[9].substring(1));
                offer.setPayment(data[10].substring(1, data[10].length() - 1));
                serviceOffersRepo.save(offer);
            }
            System.out.println("Сохранили файл услуг в БД");
                System.out.println();
        }
            else {
                System.out.println("Этого документа нет в папке соурс");
                System.out.println();
                throw new FileNotFoundException();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
