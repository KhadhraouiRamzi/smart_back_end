package com.example.demo.excel;

import com.example.demo.entite.details;
import com.example.demo.entite.devise;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class ExcelServiceBelieve {

    private static final Map<String, String> fileExtensionMap;

    static {
        fileExtensionMap = new HashMap<String, String>();
        //excel type
        fileExtensionMap.put("xls", "application/vnd.ms-excel");
        fileExtensionMap.put("xlt", "application/vnd.ms-excel");
        fileExtensionMap.put("xla", "application/vnd.ms-excel");
        fileExtensionMap.put("xlsx", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        fileExtensionMap.put("xltx", "application/vnd.openxmlformats-officedocument.spreadsheetml.template");
        fileExtensionMap.put("xlsm", "application/vnd.ms-excel.sheet.macroEnabled.12");
        fileExtensionMap.put("xltm", "application/vnd.ms-excel.template.macroEnabled.12");
        fileExtensionMap.put("xlam", "application/vnd.ms-excel.addin.macroEnabled.12");
        fileExtensionMap.put("xlsb", "application/vnd.ms-excel.sheet.binary.macroEnabled.12");
    }

    @Autowired
    com.example.demo.dao.believeRepository believeRepository;
    @Autowired
    com.example.demo.dao.detailRepository detailRepository;
    @Autowired
    com.example.demo.dao.deviseRepository deviseRepository;

    private static int quantite;
    private static float value;
    private static double TTC;
    private static double part_smart;
    private static double tax_telecom;
    private static double part_TTC;
    private static double HTVA;
    private static double part_artiste;
    private static int nbr_ecoute;
    private static double valeur_ttc_eur;
    private static double valeur_ttc;

    public void uploadExcelBelieve(MultipartFile file) throws ParseException, InvalidFormatException, DateException, nullException {
        try {
            List<details> details = excelBelieveToDetails(file.getInputStream());
            detailRepository.saveAll(details);
        } catch (IOException e) {
            throw new RuntimeException("fail to store excel data: " + e.getMessage());
        }
    }

    public static boolean hasExcelFormat(MultipartFile file) {

        if (!fileExtensionMap.containsValue(file.getContentType())) {
            return false;
        }

        return true;
    }


    public List<details> excelBelieveToDetails(InputStream is) throws IOException, InvalidFormatException, ParseException, DateException, nullException {

        Workbook workbook = WorkbookFactory.create(is);

        Sheet sheet = workbook.getSheetAt(0);
        Iterator<Row> rows = sheet.iterator();

        List<details> tutorials = new ArrayList<>();
        SimpleDateFormat formaterrr = new SimpleDateFormat("MMM yyyy");

        int rowNumber = 0;
        while (rows.hasNext()) {

            Row currentRow = rows.next();


            // skip header and the unused columns
            if (rowNumber == 0) {
                rowNumber++;
                continue;
            }


            details details = new details();
            devise devise = new devise();

            currentRow.getCell(0).setCellType(CellType.STRING);
            currentRow.getCell(1).setCellType(CellType.STRING);
            currentRow.getCell(2).setCellType(CellType.NUMERIC);
            currentRow.getCell(3).setCellType(CellType.NUMERIC);
            currentRow.getCell(5).setCellType(CellType.STRING);
            currentRow.getCell(6).setCellType(CellType.STRING);
            currentRow.getCell(10).setCellType(CellType.STRING);
            currentRow.getCell(11).setCellType(CellType.STRING);
            currentRow.getCell(14).setCellType(CellType.STRING);
            currentRow.getCell(20).setCellType(CellType.STRING);
            currentRow.getCell(21).setCellType(CellType.STRING);
            currentRow.getCell(23).setCellType(CellType.STRING);




            if(!currentRow.getCell(0).getStringCellValue().isEmpty()){
                String nom_artiste;
                switch (currentRow.getCell(0).getStringCellValue()) {
                    case "Lotfi_Bouchnak":
                        nom_artiste = "Lotfi Bouchnak";
                        break;

                    case "Saber El Rebai":
                        nom_artiste = "Saber Rebai";
                        break;

                    case "Ines Feat Kafon":
                        nom_artiste = "In-s Feat Kafon";
                        break;

                    default:
                        nom_artiste = currentRow.getCell(0).getStringCellValue();
                        break;
                }

                details.setNamea(nom_artiste);

            }

            else throw new nullException("le nom d'artiste est doit etre non vide verifiez " +
                    "la ligne " + (currentRow.getRowNum()+1));


            if(!currentRow.getCell(1).getStringCellValue().isEmpty()){
                details.setPlateforme(currentRow.getCell(1).getStringCellValue());
            }

            else throw new nullException("le platforme est doit etre non vide verifiez " +
                    "la ligne " + (currentRow.getRowNum()+1));

            nbr_ecoute=((int) currentRow.getCell(2).getNumericCellValue());
            details.setQuantite(Math.abs(nbr_ecoute));
            
            valeur_ttc_eur=currentRow.getCell(3).getNumericCellValue();


            if(!currentRow.getCell(5).getStringCellValue().isEmpty()){
                if(currentRow.getCell(5).getStringCellValue().equals(currentRow.getCell(10).getStringCellValue())){
                    details.setAlbum("Single");
                }
                else {
                    details.setAlbum(currentRow.getCell(5).getStringCellValue());
                }
            }
            else throw new nullException("l'album est doit etre non vide verifiez " +
                    "la ligne " + (currentRow.getRowNum()+1));


            if(!currentRow.getCell(6).getStringCellValue().isEmpty()){
                details.setUpc(currentRow.getCell(6).getStringCellValue());
            }
            else throw new nullException("la valeur de Upc est doit etre non vide verifiez " +
                    "la ligne " + (currentRow.getRowNum()+1));

            if(!currentRow.getCell(10).getStringCellValue().isEmpty()){
                String c = currentRow.getCell(10).getStringCellValue();
                details.setContent(c);
            }
            else {
                String c = currentRow.getCell(5).getStringCellValue();
                details.setContent(c);
            }

            if(!currentRow.getCell(11).getStringCellValue().isEmpty()){
                details.setIsrc(currentRow.getCell(11).getStringCellValue());
            }

            else throw new nullException("la valeur de Isrc est doit etre non vide verifiez " +
                    "la ligne " + (currentRow.getRowNum()+1));

            if(!currentRow.getCell(14).getStringCellValue().isEmpty()){
                details.setType(currentRow.getCell(14).getStringCellValue());
            }
            else throw new nullException("le type de sortie est doit etre non vide verifiez " +
                    "la ligne " + (currentRow.getRowNum()+1));

            if(!currentRow.getCell(18).getDateCellValue().toString().isEmpty()){
                details.setDate2(new Date(currentRow.getCell(18).getDateCellValue().getTime()));
            }
            else throw new nullException("la date fin est doit etre non vide verifiez " +
                    "la ligne " + (currentRow.getRowNum()+1));

            details.setDate1(new Date(currentRow.getCell(19).getDateCellValue().getTime()));

           /* if(!currentRow.getCell(19).getDateCellValue().toString().isEmpty()){
                if(believeRepository.getDetailsByDate1andFile(new Date(currentRow.getCell(19).getDateCellValue().getTime()),"Believe")==0){
                    details.setDate1(new Date(currentRow.getCell(19).getDateCellValue().getTime()));
                }
                else throw new DateException("Revenue de mois "+formaterrr.format(new Date(currentRow.getCell(19).getDateCellValue().getTime()))+" existe deja !! verifiez vos date !");
            }

            else throw new nullException("la date debut est doit etre non vide verifiez " +
                    "la ligne " + (currentRow.getRowNum()+1));
*/
            if(!currentRow.getCell(20).getStringCellValue().isEmpty()){
                details.setPays(currentRow.getCell(20).getStringCellValue());
            }
            else throw new nullException("le pays est doit etre non vide verifiez " +
                    "la ligne " + (currentRow.getRowNum()+1));

            if(!currentRow.getCell(21).getStringCellValue().isEmpty()){
                details.setType_vente(currentRow.getCell(21).getStringCellValue());
            }

            else throw new nullException("le type de vente doit etre non vide verifiez " +
                    "la ligne " + (currentRow.getRowNum()+1));

            if(!(currentRow.getCell(22)==null)){
            currentRow.getCell(22).setCellType(CellType.STRING);
            details.setType_stream(currentRow.getCell(22).getStringCellValue());
            }

            else throw new nullException("le type de stream doit etre non vide verifiez " +
                    "la ligne " + (currentRow.getRowNum()+1));

            if(!currentRow.getCell(23).getStringCellValue().isEmpty()){
                details.setDevise(currentRow.getCell(23).getStringCellValue());
            }

            else throw new nullException("la valeur de devise doit etre non vide verifiez " +
                    "la ligne " + (currentRow.getRowNum()+1));

            details.setNetrevenu(Math.abs(valeur_ttc_eur));
            details.setTTC_EUR(Math.abs(valeur_ttc_eur));
            
            System.out.println("getCours ------>"+deviseRepository.getCourParDate(details.getDate1(), details.getDate2()));
            
            if(deviseRepository.getCourParDate(details.getDate1(), details.getDate2())!=null){
                details.setTTC(Math.abs(valeur_ttc_eur * deviseRepository.getCourParDate(details.getDate1(), details.getDate2())));//getCoursDate(details.getDate1(), details.getDate2())));
            }
            else throw new DateException("Devise du mois "+details.getDate1()+" et "+details.getDate2()+" pas existe sur table devise !! Merci de completer le tableau Cours Devise !");
       
            
            System.out.println("cours ---------> "+ deviseRepository.getCourParDate(details.getDate1(), details.getDate2()));
            System.out.println("date1 ---------> "+details.getDate1());
            System.out.println("date2 ---------> "+details.getDate2());
            System.out.println("ttc  ---------> "+details.getTTC());
            System.out.println("ttc_eur ---------> "+details.getTTC_EUR());
            
            valeur_ttc=details.getTTC();
            details.setPart_artiste(Math.abs(valeur_ttc/2));
            details.setPart_smart(Math.abs(valeur_ttc/2));


            details.setFile("Believe");
            details.setCdate(new Date(Calendar.getInstance().getTime().getTime()));

            tutorials.add(details);

        }


        workbook.close();

        return tutorials;


    }


}
