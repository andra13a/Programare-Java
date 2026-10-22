import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

import java.io.FileOutputStream;
import java.util.Map;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Note Studenți");

        Map<String, Object[]> data = new TreeMap<>();
        data.put("1", new Object[]{"Prenume", "Nume", "Nota1", "Nota2", "Nota3", "Nota4", "Max", "Medie"});
        data.put("2", new Object[]{"Amit", "Shukla", 9, 8, 7, 5});
        data.put("3", new Object[]{"Lokesh", "Gupta", 8, 9, 6, 7});
        data.put("4", new Object[]{"John", "Adwards", 8, 8, 7, 6});
        data.put("5", new Object[]{"Brian", "Schultz", 7, 6, 8, 9});

        // Stil pentru header: fundal verde, bold
        XSSFCellStyle headerStyle = workbook.createCellStyle();
        headerStyle.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());
        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        XSSFFont headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 12);
        headerStyle.setFont(headerFont);

        // Stil pentru coloanele G și H (fundal galben)
        XSSFCellStyle yellowStyle = workbook.createCellStyle();
        yellowStyle.setFillForegroundColor(IndexedColors.LIGHT_YELLOW.getIndex());
        yellowStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        int rowNum = 0;
        for (String key : data.keySet()) {
            Row row = sheet.createRow(rowNum);
            Object[] objArr = data.get(key);
            int colNum = 0;

            for (Object obj : objArr) {
                Cell cell = row.createCell(colNum++);
                if (obj instanceof String)
                    cell.setCellValue((String) obj);
                else if (obj instanceof Integer)
                    cell.setCellValue((Integer) obj);

                if (rowNum == 0) {
                    cell.setCellStyle(headerStyle); // Fundal verde + bold
                }
            }

            // Adăugare formule doar pentru rândurile de date
            if (rowNum > 0) {
                int excelRow = rowNum + 1;

                // Coloana G - MAX
                Cell maxCell = row.createCell(6);
                maxCell.setCellFormula(String.format("MAX(C%d:F%d)", excelRow, excelRow));
                maxCell.setCellStyle(yellowStyle);

                // Coloana H - AVERAGE
                Cell avgCell = row.createCell(7);
                avgCell.setCellFormula(String.format("AVERAGE(C%d:F%d)", excelRow, excelRow));
                avgCell.setCellStyle(yellowStyle);
            } else {
                // Pentru header: aplicăm stilul galben și la coloanele G și H
                row.getCell(6).setCellStyle(yellowStyle);
                row.getCell(7).setCellStyle(yellowStyle);
            }

            rowNum++;
        }

        // Auto-size pentru toate coloanele
        for (int i = 0; i < 8; i++) {
            sheet.autoSizeColumn(i);
        }

        // Scrierea în fișier
        try (FileOutputStream out = new FileOutputStream("output8.xlsx")) {
            workbook.write(out);
            workbook.close();
            System.out.println("Fișierul 'output8.xlsx' a fost generat cu succes!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
