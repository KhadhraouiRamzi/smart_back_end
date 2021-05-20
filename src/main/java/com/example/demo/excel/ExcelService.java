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
                            details.setNamea(currentCell.getStringCellValue());
                            break;
                        case 5:
                            details.setUniteprice((float) currentCell.getNumericCellValue());
                            break;
                        case 6:
                            currentCell.setCellType(CellType.NUMERIC);
                            details.setQuantite((int) currentCell.getNumericCellValue());
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
