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
import java.util.ArrayList;
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

        } catch (IOException e) {
            throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
        }
    }

}
