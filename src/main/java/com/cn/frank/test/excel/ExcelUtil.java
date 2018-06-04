package com.cn.frank.test.excel;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.util.JSONUtils;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: frank_du
 * Time : 2017/12/29 上午11:16
 */
public class ExcelUtil {

    public static final  String[] NAMES = {"name","code", "capacity", "region"};

    public static void main(String[] args) {
        String jsonStr = "";
        JSONArray jsonArray = JSONArray.fromObject(jsonStr);
        Export2Excel(jsonArray);
    }


    public static void Export2Excel(JSONArray jsonArray) {

        HSSFWorkbook workbook = new HSSFWorkbook();// 创建一个Excel文件

        HSSFSheet sheet = workbook.createSheet();// 创建一个Excel的Sheet

        HSSFCellStyle style = workbook.createCellStyle();

        style.setFillBackgroundColor(HSSFColor.BLUE_GREY.index);

        HSSFRow titleRow = sheet.createRow(0);

        for(int i=0;i<NAMES.length;i++){
            titleRow.createCell(i).setCellValue(NAMES[i]);
        }

        titleRow.setRowStyle(style);

        if (jsonArray.size() > 0) {
            for (int i = 0; i < jsonArray.size(); i++) {
                HSSFRow row = sheet.createRow(i + 1);
                JSONObject json = jsonArray.getJSONObject(i); // 遍历 jsonarray
                for(int j=0;j<NAMES.length;j++){
                    row.createCell(j).setCellValue(json.get(NAMES[j]).toString());
                }

            }
        }
        try {
            FileOutputStream fos = new FileOutputStream("b.xls");
            workbook.write(fos);
            fos.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
