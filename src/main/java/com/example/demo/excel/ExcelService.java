package com.example.demo.excel;

import com.example.demo.dao.detailRepository;
import com.example.demo.entite.details;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
public class ExcelService {

    public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";

    @Autowired
    detailRepository detailRepository;

    private static  int quantite  ;
    private static  float value  ;
    private static double TTC;
    private static double part_smart;
    private static double tax_telecom;
    private static double part_TTC;
    private static double HTVA;
    private static double part_artiste;

    public void uploadExcel(MultipartFile file) {
        try {
            List<details> details = ExcelService.excelToDetails(file.getInputStream());
            detailRepository.saveAll(details);
        } catch (IOException e) {
            throw new RuntimeException("fail to store excel data: " + e.getMessage());
        }
    }

    public static boolean hasExcelFormat(MultipartFile file) {

        if (!TYPE.equals(file.getContentType())) {
            return false;
        }

        return true;
    }



    public static List<details> excelToDetails(InputStream is) {
        try {
            Workbook workbook = new XSSFWorkbook(is);

            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rows = sheet.iterator();

            List<details> tutorials = new ArrayList<>();

            /*-------parsing of date from ---------*/
            String fdate1=(sheet.getRow(2).getCell(0)).getStringCellValue();
            String  str1 = fdate1.replaceAll("([^/0-9])", "");
            System.out.println(str1);
            Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(str1);
            java.sql.Date d1=  new java.sql.Date(date1.getTime());
            System.out.println(d1);

            /*-------parsing of date to ---------*/
            String tdate2=(sheet.getRow(3).getCell(0)).getStringCellValue();
            String  str2 = tdate2.replaceAll("([^/0-9])", "");
            System.out.println(str2);
            Date date2=new SimpleDateFormat("dd/MM/yyyy").parse(str2);
            java.sql.Date d2=  new java.sql.Date(date2.getTime());
            System.out.println(date2);

            int rowNumber = 0;
            while (rows.hasNext()) {
                Row currentRow = rows.next();

                // skip header and the unused columns
                if (rowNumber == 0 || rowNumber == 1 ||
                    rowNumber == 2 || rowNumber == 3 ||
                    rowNumber == 4 || rowNumber == 5) {
                    rowNumber++;
                    continue;
                }

                Iterator<Cell> cellsInRow = currentRow.iterator();

                details details = new details();

                int cellIdx = 0;
                while (cellsInRow.hasNext()) {
                    Cell currentCell = cellsInRow.next();

                    details.setDate1(d1);
                    details.setDate2(d2);

                    switch (cellIdx) {
                        case 0:
                            details.setContent(currentCell.getStringCellValue());
                            break;
                        case 2:
                            details.setCategory(currentCell.getStringCellValue());
                            break;
                        case 3:
                            details.setPlateforme(currentCell.getStringCellValue());
                            break;
                        case 4:
                        	String nom_artiste;
                        switch (currentCell.getStringCellValue()) {
                        case "Lotfi_Bouchnak" : 
                        	nom_artiste ="Lotfi Bouchnak";
                            break;
                            
                        case "Saber El Rebai" : 
                        	nom_artiste ="Saber Rebai";
                            break;
                            
                        case "Ines Feat Kafon" : 
                        	nom_artiste ="In-s Feat Kafon";
                            break;    

                        default: nom_artiste = currentCell.getStringCellValue();
                        break;
                        }
                            details.setNamea(nom_artiste);  
                            System.out.println(nom_artiste);
                            System.out.println(currentCell.getStringCellValue());
                            break;
                        case 5:
                            details.setUniteprice((float) currentCell.getNumericCellValue());
                            value = (float)currentCell.getNumericCellValue();
                            break;
                        case 6:
                           double q=Double.parseDouble(currentCell.getStringCellValue());
                            details.setQuantite((int) q);
                            quantite= (int) q;
                            details.setTTC((double) (quantite*value));
                            TTC = (quantite*value);
                            System.out.println(TTC);

                            details.setPart_smart((double) (TTC*0.3));
                            part_smart = (TTC*0.3);
                            System.out.println(part_smart);

                            details.setTax_telecom((double) (part_smart*0.059));
                            tax_telecom =part_smart*0.059;
                            System.out.println(tax_telecom);

                            details.setPart_TTC((double) ( part_smart - tax_telecom ));
                            part_TTC = part_smart - tax_telecom ;
                            System.out.println("part_TTC "+part_TTC);

                            details.setHTVA((double) (part_TTC / 1.19));
                            HTVA = part_TTC / 1.19;
                            System.out.println(HTVA);

                            details.setPart_artiste((double) (HTVA / 2));
                            System.out.println( (HTVA / 2));

                            details.setGrossrevenu((double) 0);
                            break;
                        default:
                            break;
                    }
                    cellIdx++;
                }
                tutorials.add(details);
            }

            workbook.close();

            return tutorials;

        } catch (IOException | ParseException e) {
            throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
        }
    }

}
