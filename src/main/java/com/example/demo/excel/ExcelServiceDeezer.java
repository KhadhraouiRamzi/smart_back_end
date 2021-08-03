package com.example.demo.excel;

import com.example.demo.entite.details;
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
public class ExcelServiceDeezer {

    @Autowired
    com.example.demo.dao.detailRepository detailRepository;

    @Autowired
    com.example.demo.dao.deezerRepository deezerRepository;

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

    private static int quantite;
    private static float value;
    private static double TTC;
    private static double part_smart;
    private static double tax_telecom;
    private static double part_TTC;
    private static double HTVA;
    private static double part_artiste;
    private static int nbr_ecoute;
    private static double valeur_ttc;

    public void uploadExcelDeezer(MultipartFile file) throws ParseException, InvalidFormatException, DateException, nullException {
        try {
            List<details> details = excelDeezerToDetails(file.getInputStream());
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

    public List<details> excelDeezerToDetails(InputStream is) throws IOException, InvalidFormatException, ParseException, DateException, nullException {

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

            if(!(currentRow.getCell(0).getDateCellValue() == null)){
                if(deezerRepository.getDetailsByDate1andFile(new java.sql.Date(currentRow.getCell(0).getDateCellValue().getTime()),"Deezer")==0){
                    details.setDate1(new java.sql.Date(currentRow.getCell(0).getDateCellValue().getTime()));
                }
                else throw new DateException("Revenue de mois "+formaterrr.format(new Date(currentRow.getCell(0).getDateCellValue().getTime()))+" existe deja !! verifiez vos date !");
            }
            else throw new nullException("la date debut est doit etre non vide verifiez la ligne " + (currentRow.getRowNum()+1));

            if(!(currentRow.getCell(1).getDateCellValue() ==null)){
                details.setDate2(new java.sql.Date(currentRow.getCell(1).getDateCellValue().getTime()));
            }
            else throw new nullException("la date fin est doit etre non vide verifiez " +
                    "la ligne " + (currentRow.getRowNum()+1));

            if(!(currentRow.getCell(2) ==null)){
                currentRow.getCell(2).setCellType(CellType.STRING);
                details.setIsrc(currentRow.getCell(2).getStringCellValue());
            }

            else throw new nullException("la valeur de Isrc est doit etre non vide verifiez " +
                    "la ligne " + (currentRow.getRowNum()+1));


            if(!(currentRow.getCell(3) ==null)){
                currentRow.getCell(3).setCellType(CellType.STRING);
                String nom_artiste;
                switch (currentRow.getCell(3).getStringCellValue()) {
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
                        nom_artiste = currentRow.getCell(3).getStringCellValue();
                        break;
                }

                details.setNamea(nom_artiste);

            }

            else throw new nullException("le nom d'artiste est doit etre non vide verifiez " +
                    "la ligne " + (currentRow.getRowNum()+1));

            if(!(currentRow.getCell(4) ==null)){
                currentRow.getCell(4).setCellType(CellType.STRING);
                String c = currentRow.getCell(4).getStringCellValue();
                details.setContent(c);
            }
            else throw new nullException("le nom de chanson est doit etre non vide verifiez " +
                    "la ligne " + (currentRow.getRowNum()+1));

            if(!(currentRow.getCell(5) ==null)){
                currentRow.getCell(5).setCellType(CellType.STRING);
                details.setAlbum(currentRow.getCell(5).getStringCellValue());
            }
            else throw new nullException("l'album est doit etre non vide verifiez " +
                    "la ligne " + (currentRow.getRowNum()+1));

            if(!(currentRow.getCell(6) ==null)){
                currentRow.getCell(6).setCellType(CellType.STRING);
                details.setUpc(currentRow.getCell(6).getStringCellValue());
            }
            else throw new nullException("la valeur de Upc est doit etre non vide verifiez " +
                    "la ligne " + (currentRow.getRowNum()+1));

            if(!(currentRow.getCell(7) ==null)){
                currentRow.getCell(7).setCellType(CellType.STRING);
                details.setPays(currentRow.getCell(7).getStringCellValue());
            }
            else throw new nullException("le pays est doit etre non vide verifiez " +
                    "la ligne " + (currentRow.getRowNum()+1));

            if(!(currentRow.getCell(8) ==null)) {
                currentRow.getCell(8).setCellType(CellType.NUMERIC);
                nbr_ecoute = ((int) currentRow.getCell(8).getNumericCellValue());
                details.setQuantite(Math.abs(nbr_ecoute));
            }
            else throw new nullException("le nombre d'ecoute est doit etre non vide verifiez " +
                    "la ligne " + (currentRow.getRowNum()+1));

            if(!(currentRow.getCell(9) ==null)) {
                currentRow.getCell(9).setCellType(CellType.NUMERIC);
                valeur_ttc=currentRow.getCell(9).getNumericCellValue();
                details.setNetrevenu(Math.abs(valeur_ttc));
                details.setTTC(Math.abs(valeur_ttc));
                details.setPart_artiste(Math.abs(valeur_ttc/2));
                details.setPart_smart(Math.abs(valeur_ttc/2));
            }
            else throw new nullException("la valeur du net Revenue est doit etre non vide verifiez " +
                    "la ligne " + (currentRow.getRowNum()+1));


            if(!(currentRow.getCell(10)==null)){
                currentRow.getCell(10).setCellType(CellType.STRING);
                details.setType_stream(currentRow.getCell(10).getStringCellValue());
            }
            else throw new nullException("le type de stream doit etre non vide verifiez " +
                    "la ligne " + (currentRow.getRowNum()+1));


           // details.setDevise(currentRow.getCell(23).getStringCellValue());


            details.setFile("Deezer");
            tutorials.add(details);

        }


        workbook.close();

        return tutorials;


    }


}
