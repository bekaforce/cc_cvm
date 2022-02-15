package com.offers.cvm_cc_tariffs.service;

import com.offers.cvm_cc_tariffs.model.TariffOffer;
import com.offers.cvm_cc_tariffs.repo.TariffOffersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.*;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


@Service
public class TariffOfferService extends OfferService{
    @Autowired
    private TariffOffersRepo tariffOffersRepo;
    String line = "";
    String pathname = "//172.28.141.109/Reports/KD_sales";
    String destination = "C:/Users/BOZhanakeev/Documents/cvm_offers";
    String fileType = "CVM_offers_tariffs";

    @Scheduled(cron = "0 0/1 * * * *")
    public void execute() throws IOException {
        ArrayList<String> offers = fileList(pathname, fileType);
        for (String s : offers) {
            if (compareFiles(destination, s, fileType)) {
                System.out.println("Файл тарифов " + s + " уже есть в нашей папке");
                System.out.println();
            } else {
                System.out.println("Файла тарифов " + s + " нет в папке, копируем");
                copyFile(pathname + "/" + s, destination + "/" + s);
                saveTariffOffers(destination, s);
            }
        }
        renameFile(fileType, destination);
        System.out.println(LocalDate.now());
        System.out.println("До следующей проверки файлов!");
    }

    public void saveTariffOffers(String destination, String FileName) {
        SimpleDateFormat format = new SimpleDateFormat();
        format.applyPattern("yyyy/MM/dd HH:mm:ss");
        try {
            if(FileName != null){
            System.out.println("Обращаемся к файлу");
            FileInputStream stream = new FileInputStream(destination + "/" + FileName);
            InputStreamReader inputStreamReader = new InputStreamReader(stream, "Cp1251");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            bufferedReader.readLine();
            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split("\",");
                if (data.length < 36){
                    System.out.println("В файле не все столбцы");
                }
                else {
                    TariffOffer offer = new TariffOffer();
                    offer.setDate(data[0].substring(1));
                    offer.setSubsKey(data[1].substring(1));
                    offer.setActivation_date(data[2].substring(1));
                    offer.setSubId(data[3].substring(1));
                    offer.setSubscriberNumber(data[4].substring(1));
                    offer.setChannel(data[5].substring(1));
                    if (checkNull(data[6].substring(1))){
                        offer.setOperation_date(null);
                    }
                    else {
                        offer.setOperation_date(format.parse(data[6].substring(1)));
                    }
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
                    if (checkNull(data[23].substring(1))){
                        offer.setUpsell(null);
                    }
                    else {
                        offer.setUpsell((int)Math.round(Double.parseDouble(data[23].substring(1))));
                    }
                    offer.setSeven_days_condition(data[24].substring(1));
                    offer.setOffer_name(data[25].substring(1));
                    if (checkNull(data[26].substring(1))){
                        offer.setOffer_payment(null);
                    }
                    else {
                        offer.setOffer_payment((int)Math.round(Double.parseDouble(data[26].substring(1))));
                    }
                    offer.setCurrent_tariff_category(data[27].substring(1));
                    offer.setPrevious_tariff_category(data[28].substring(1));
                    offer.setCurrent_tariff_payment(data[29].substring(1));
                    offer.setPrevious_tariff_payment(data[30].substring(1));
                    offer.setUpsell_CVM(data[31].substring(1));
                    offer.setOffer_id(data[32].substring(1));
                    if (checkNull(data[33].substring(1))){
                        offer.setOffer_date(null);
                    }
                    else {
                        offer.setOffer_date(format.parse(data[33].substring(1)));
                    }
                    offer.setLogin(data[34].substring(1));
                    offer.setOffer_status(data[35].substring(1));
                    offer.setEight_days(data[36].substring(1, data[36].length() - 1));
                    tariffOffersRepo.save(offer);
                }
            }
                stream.close();
                inputStreamReader.close();
                bufferedReader.close();
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
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}