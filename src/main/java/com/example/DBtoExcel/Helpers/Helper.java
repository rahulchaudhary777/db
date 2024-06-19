package com.example.DBtoExcel.Helpers;

import com.example.DBtoExcel.MyDetails;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;

public class Helper {

    public static String[] HEADERS = {
            "id",
            "name",
            "email",
            "password",
            "gender"
    };

    public static String SHEET_NAME = "category_data";

    public static ByteArrayInputStream dataToExcel(List<MyDetails> list) throws IOException, IllegalAccessException {
        Workbook workbook = new XSSFWorkbook();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        try {
            Sheet sheet = workbook.createSheet(SHEET_NAME);

            // Create headers row
            Row headersRow = sheet.createRow(0);
            for (int i = 0; i < HEADERS.length; i++) {
                Cell cell = headersRow.createCell(i);
                cell.setCellValue(HEADERS[i]);
            }

            int rowIndex = 1;
            for (MyDetails obj : list) {
                Row dataRow = sheet.createRow(rowIndex++);
                int columnIndex = 0;

                Field[] fields = obj.getClass().getDeclaredFields();

                for (Field field : fields) {
                    field.setAccessible(true);

                    Object value = field.get(obj);

                    Cell cell = dataRow.createCell(columnIndex++);
                    if (value == null) {
                        cell.setCellValue("");
                    } else if (value instanceof String) {
                        cell.setCellValue((String) value);
                    } else if (value instanceof Integer) {
                        cell.setCellValue((Integer) value);
                    } else if (value instanceof Double) {
                        cell.setCellValue((Double) value);
                    } else if (value instanceof Boolean) {
                        cell.setCellValue((Boolean) value);
                    }
                }
            }

            workbook.write(outputStream);
            return new ByteArrayInputStream(outputStream.toByteArray());
        } finally {
            workbook.close();
            outputStream.close();
        }
    }
}
