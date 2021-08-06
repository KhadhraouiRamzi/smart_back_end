package com.example.demo.webService;

import com.example.demo.excel.*;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.text.ParseException;

@CrossOrigin(origins = "*")
@RestController
public class deezerRestService {

    @Autowired
    ExcelServiceDeezer excelServiceDeezer;


    /*--------------*web Service pour l'upload des details*--------------*/

    @PostMapping("/uploadExcelDeezer")
    public ResponseEntity<ResponseMessage> uploadFileDeezer(@RequestParam("file") MultipartFile file) {
        String message = "";

        if (ExcelServiceBelieve.hasExcelFormat(file)) {
            try {
                excelServiceDeezer.uploadExcelDeezer(file);

                message = "l'importation et terminé avec succes: " + file.getOriginalFilename();
                return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
            } catch (DateException | ParseException | InvalidFormatException | nullException e) {
                message = "echec d'importation: " + e.getMessage();
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
            }
        }
        message = "echec d'importation: le fichier n'est pas de type excel !";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));
    }

}
