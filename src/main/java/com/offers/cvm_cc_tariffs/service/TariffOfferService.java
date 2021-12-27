package com.offers.cvm_cc_tariffs.service;

import com.offers.cvm_cc_tariffs.model.TariffOffer;
import com.offers.cvm_cc_tariffs.repo.TariffOffersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;


@Service
public class TariffOfferService extends OfferService{
    @Autowired
    private TariffOffersRepo tariffOffersRepo;
    String line = "";
    String pathname = "D:/doc";
    String destination = "D:/anotherdoc";
    String fileType = "CVM_offers_tariffs";

    @Scheduled(cron = "0/15 * * * * *")
    public void execute() {
        ArrayList<String> offers = fileList(pathname, fileType);
        for (String s : offers) {
            if (compareFiles(destination, s, fileType)) {
                System.out.println("Файл тарифов " + s + " уже есть в нашей папке");
                System.out.println();
            } else {
                System.out.println("Файла тарифов " + s + " нет в папке, копируем");
                saveTariffOffers(pathname, destination, s);
            }
        }
    }

    public void saveTariffOffers(String pathname, String destination, String FileName) {
        try {
            if(FileName != null){
            copyFile(pathname + "/" + FileName, destination + "/" + FileName);
            System.out.println("Обращаемся к файлу");
            FileInputStream stream = new FileInputStream(destination + "/" + FileName);
            InputStreamReader inputStreamReader = new InputStreamReader(stream, "Cp1251");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            bufferedReader.readLine();
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split("\",");
                TariffOffer offer = new TariffOffer();
                offer.setDate(data[0].substring(1));
                offer.setSubsKey(data[1].substring(1));
                offer.setActivation_date(data[2].substring(1));
                offer.setSubId(data[3].substring(1));
                offer.setSubscriberNumber(data[4].substring(1));
                offer.setChannel(data[5].substring(1));
                offer.setOperation_date(data[6].substring(1));
                offer.setCurrent_tariff(data[7].substring(1));
                offer.setPrevious_tariff(data[8].substring(1));
                offer.setComparison(data[9].substring(1));
                offer.setRev_until_total(data[10].substring(1));
                offer.setRev_after_total(data[11].substring(1));
                offer.setTwo_weeks_condition(data[12].substring(1));
                offer.setThirty_days_condition(data[13].substring(1));
                offer.setSixty_days_condition(data[14].substring(1));
                offer.setDate_of_first_payment(data[15].substring(1));
                offer.setAmount_of_payment(data[16].substring(1));
                offer.setAgent(data[17].substring(1));
                offer.setSubAgent(data[18].substring(1));
                offer.setChannel_group(data[19].substring(1));
                offer.setMotivational_number(data[20].substring(1));
                offer.setUSSD_number(data[21].substring(1));
                offer.setRegion_of_max(data[22].substring(1));
                offer.setUpsell(data[23].substring(1));
                offer.setSeven_days_condition(data[24].substring(1));
                offer.setOffer_name(data[25].substring(1));
                offer.setOffer_payment(data[26].substring(1));
                offer.setCurrent_tariff_category(data[27].substring(1));
                offer.setPrevious_tariff_category(data[28].substring(1));
                offer.setCurrent_tariff_payment(data[29].substring(1));
                offer.setPrevious_tariff_payment(data[30].substring(1));
                offer.setUpsell_CVM(data[31].substring(1));
                offer.setOffer_id(data[32].substring(1, data[32].length() - 1));
                tariffOffersRepo.save(offer);
            }
                System.out.println("Сохранили файл тарифов в БД");
                System.out.println();
        }
            else {
                System.out.println("Этого документа нет в папке соурс");
                System.out.println();
                throw new FileNotFoundException();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}