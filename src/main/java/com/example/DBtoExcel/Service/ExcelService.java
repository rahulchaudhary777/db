package com.example.DBtoExcel.Service;

import com.example.DBtoExcel.Helpers.Helper;
import com.example.DBtoExcel.MyDetails;
import com.example.DBtoExcel.repo.DetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

@Service
public class ExcelService {
    @Autowired
    private DetailsRepo detailsRepo;

    public ByteArrayInputStream getActualData() throws IOException, IllegalAccessException {
        List<MyDetails> list = detailsRepo.findAll();

        ByteArrayInputStream inputStream = Helper.dataToExcel(list);
        return inputStream;
    }
}
