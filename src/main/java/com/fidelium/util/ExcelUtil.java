package com.fidelium.util;

import com.fidelium.domain.User;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017-11-27.
 */
@Service
public class ExcelUtil {

    private Logger logger = LoggerFactory.getLogger(getClass());

    public <T> WritableWorkbook createExcelOutputExcel(HttpServletResponse response, List<T> list, List<String> headerNames, List<String> headers, String fileName, String sheetName) {

        WritableWorkbook writableWorkbook = null;

        try {

            Gson gson = new Gson();
            List<List<String>> value = new ArrayList<>();
            List<String> headerList = new ArrayList<>();
            boolean check = true;
            for(T tClass :list){

                List<String> valueList = new ArrayList<>();
                Class<? extends Object> clazz = tClass.getClass();
                String result = gson.toJson(tClass);

                JsonParser parser = new JsonParser();
                JsonElement element = parser.parse(result);
                Field[] dFields = clazz.getDeclaredFields();

                /*
                * 추후에 header 정해지면 작업
                * */
                for (String header : headers){
                    if(element.getAsJsonObject().get(header)!=null){
                        String str = element.getAsJsonObject().get(header).getAsString();
                        valueList.add(str);
                    }else{
                        valueList.add("");
                    }
                }

                /*
                * 임시 작업
                * */
//                for (Field d : dFields){
//                    if(check){
//                        headerList.add(d.getName());
//                    }
//                    if(element.getAsJsonObject().get(d.getName())!=null){
//                        String str = element.getAsJsonObject().get(d.getName()).getAsString();
//                        valueList.add(str);
//                    }else{
//                        valueList.add("");
//                    }
//                }
//                check = false;

                value.add(valueList);
            }
            response.setContentType("application/vnd.ms-excel");
            response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
            writableWorkbook = Workbook.createWorkbook(response.getOutputStream());
            WritableSheet excelOutputsheet = writableWorkbook.createSheet(sheetName, 0);
//            addExcelOutputHeader(excelOutputsheet, headerList);
            addExcelOutputHeader(excelOutputsheet, headerNames);
            writeExcelOutputData(excelOutputsheet, value);
            writableWorkbook.write();
            writableWorkbook.close();
        }catch (Exception e){
            logger.debug("{}", e.getMessage());
        }

        return writableWorkbook;
    }

    private void addExcelOutputHeader(WritableSheet sheet, List<String> headerList) throws RowsExceededException, WriteException{
        for (int i=0; i<headerList.size(); i++){
            sheet.addCell(new Label(i, 0, headerList.get(i)));
        }
    }

    private void writeExcelOutputData(WritableSheet sheet, List<List<String>> value) throws RowsExceededException, WriteException{
        int j = 1;
        for (List<String> valueList : value){
            for (int i = 0; i < valueList.size(); i++) {
                sheet.addCell(new Label(i, j, valueList.get(i)));
            }
            j++;
        }
    }

}
