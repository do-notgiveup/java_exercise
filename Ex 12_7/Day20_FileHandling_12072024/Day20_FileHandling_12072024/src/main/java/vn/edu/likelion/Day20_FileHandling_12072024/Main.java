package vn.edu.likelion.Day20_FileHandling_12072024;

import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Base64;

public class Main {
    public static void main(String[] args) {
        String sourceFile = "StudentsList.txt";
        String docName = "AbsentList_" +
                LocalDate.now().format(DateTimeFormatter.ofPattern("ddMMyyyy")) + ".docx";

        BufferedReader br = null;
        String line;

        try {
            // doc file StudentList.txt de lay danh sach hv
            br = new BufferedReader(new FileReader(sourceFile));

            // doc file excel output1.xlsx mau de dien vao theo format
            FileInputStream inputStream = new FileInputStream(("output1.xlsx"));
            Workbook workbook = WorkbookFactory.create(inputStream);
            Sheet sheet = workbook.getSheet("Sheet1");

            // Ghi ra file output.docx
            FileOutputStream out = new FileOutputStream(docName);

            XWPFDocument document = new XWPFDocument(); // Tạo 1 tài liệu mới

            // Tạo 1 đoạn văn bản và thêm nội dung
            XWPFParagraph paragraph = document.createParagraph();

            int r = 4, c = 1;
            while ((line = br.readLine()) != null) {
                r = writeExcelFile(line, r, c, sheet);
                writeWordFile(line, r, paragraph);
            }

            FileOutputStream fos = new FileOutputStream("output1.xlsx");
            workbook.write(fos);
            workbook.close();
            br.close();
            System.out.println("Da ghi file thanh cong");

            document.write(out);
            document.close(); // Đóng tài liệu
            System.out.println("Đã tạo file docx thành công!");

            // doc file word va file excel
            readExcelFile();
            // doc file word
            readWordFile(docName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int writeExcelFile(String str, int r, int c, Sheet sheet) {
        String[] strs = str.split("[\t]");
//        for (int i = 0; i < strs.length; i++) {
//            System.out.println(strs[i]);
//        }
        if (Integer.parseInt(strs[2]) == 1) {

            Font font = sheet.getWorkbook().createFont();
            font.setFontHeightInPoints((short) 14);

            CellStyle cellStyle = sheet.getWorkbook().createCellStyle();
            cellStyle.setFont(font);
            cellStyle.setBorderTop(BorderStyle.THIN);
            cellStyle.setBorderBottom(BorderStyle.THIN);
            cellStyle.setBorderLeft(BorderStyle.THIN);
            cellStyle.setBorderRight(BorderStyle.THIN);
            cellStyle.setAlignment(HorizontalAlignment.CENTER);
            cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);

            Row row = sheet.createRow(r);

            Cell cell = row.createCell(c);
            cell.setCellStyle(cellStyle);
            cell.setCellValue(Base64.getEncoder().encodeToString(strs[1].getBytes()));


            Cell cell0 = row.createCell(c - 1);
            cell0.setCellStyle(cellStyle);
            cell0.setCellValue(r - 3);

            return ++r;
        }
        return r;
    }

    public static void writeWordFile(String str, int r, XWPFParagraph paragraph) {
        String[] strs = str.split("[\t]");

        if (Integer.parseInt(strs[2]) == 0) {

            XWPFRun run = paragraph.createRun();
            run.setText(r - 4 + "\t" + Base64.getEncoder().encodeToString(strs[1].getBytes()));
            run.addBreak();

        }
    }

    public static void readExcelFile() {

        try {
            FileInputStream inputStream = new FileInputStream(new File("output1.xlsx"));
            Workbook workbook = WorkbookFactory.create(inputStream); // Tạo workbook từ file Excel
            Sheet sheet = workbook.getSheetAt(0); // Lấy sheet đầu tiên từ workbook
            // Duyệt qua từng dòng của sheet và in ra giá trị của từng ô
            System.out.println("\nDu lieu doc tu file excel: ");
            for (int i = 4; i <= sheet.getLastRowNum(); i++) {
                for (Cell cell : sheet.getRow(i)) {
                    switch (cell.getCellType()) {
                        case STRING:
//                            String data = cell.getStringCellValue();
//                            byte[] bytes = Base64.getDecoder().decode(data);
//                            String string = new String(bytes);
                            System.out.print(new String(Base64.getDecoder()
                                    .decode(cell.getStringCellValue())) + "\t\n");
//                            System.out.println(string);
//                            System.out.println(cell.getStringCellValue());
                            break;
                    }
                }
            }
            workbook.close();
            inputStream.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void readWordFile(String docName) {
        try {
            FileInputStream fis = new FileInputStream(docName);
            XWPFDocument document = new XWPFDocument(OPCPackage.open(fis));
            // Đọc các đoạn văn bản từ tài liệu
            System.out.println("Du lieu doc tu file word: ");
            for (XWPFParagraph paragraph : document.getParagraphs()) {
                for (String line : paragraph.getText().split("\n")){
                    System.out.println(new String(Base64.getDecoder().decode(line.split("\t")[1])));
                }
//                for (Object o : ) {
//
//                }
//                String s1 = paragraph.getText();
//                String[]  s1s = s1.split("\t");
//                System.out.println(new String(Base64.getDecoder()
//                        .decode((paragraph.getText().split("\t"))[1])));
//                System.out.println(paragraph.getText());
            }
            document.close();
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}