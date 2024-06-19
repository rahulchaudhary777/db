package com.example.DBtoExcel.Controller;

import com.example.DBtoExcel.Service.ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayInputStream;
import java.io.IOException;

@RestController
public class DetailsController {
    @Autowired
    private ExcelService service;
    @GetMapping("/excel")
    public ResponseEntity<Resource> download() throws IOException, IllegalAccessException {
        String filename = "details.xlsx";
        ByteArrayInputStream actualData =  service.getActualData();
        InputStreamResource file = new InputStreamResource(actualData);

//        ResponseEntity<Resource> body = ResponseEntity.ok()
//                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename="+filename)
//                .contentType(MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))
//                .body(file);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentDispositionFormData("inline", filename);
        headers.setContentType(MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"));

        return ResponseEntity.ok()
                .headers(headers)
                .body(file);

//        return body;
    }
}
