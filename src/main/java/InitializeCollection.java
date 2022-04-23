import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

public class InitializeCollection {

    private InitializeCollection() {}

    private static final ArrayList<Student> studentArrayList = new ArrayList<>();
    private static final ArrayList<University> universityArrayList = new ArrayList<>();

    public static void initCollections() throws Exception {

        InitializeCollection init = new InitializeCollection();

        URL resource = init.getClass().getClassLoader().getResource("universityInfo.xlsx");

        if (resource == null) {
            throw new Exception("XLSX file is undefined");
        }

        File file = new File(resource.toURI());
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheetStudent = workbook.getSheet("Студенты");
        XSSFSheet sheetUniversity = workbook.getSheet("Университеты");

        initializeStudents(sheetStudent);

        initializeUniversities(sheetUniversity);

    }



    private static void initializeStudents (XSSFSheet sheetStudent) {
        Iterator<Row> rowIterator = sheetStudent.iterator();
        int i = 0;

        while (rowIterator.hasNext()){
            // get the next row
            Row row = rowIterator.next();

            if (row.getRowNum() == 0) {
                // skip the row 0 - it's a row with headers
               continue;
           } else {
               // cell value for Course Number - in the format of 2.0 => should be 2
               String courseNumStr = Double.toString(row.getCell(2).getNumericCellValue());

               int d = courseNumStr.indexOf(".");
               courseNumStr = courseNumStr.substring(0,d);

               studentArrayList.add(i, new Student(row.getCell(1).getStringCellValue(),
                                                   row.getCell(0).getStringCellValue(),
                                                   Integer.parseInt(courseNumStr),
                                                   (float) row.getCell(3).getNumericCellValue()));
               i++;
           }
        }

    }

    private static void initializeUniversities (XSSFSheet sheetUniversity) {
        Iterator<Row> rowIterator = sheetUniversity.iterator();
        int i = 0;

        while (rowIterator.hasNext()){
            // get the next row
            Row row = rowIterator.next();

            if (row.getRowNum() == 0) {
                // skip the row 0 - it's a row with headers
                continue;
            } else {
                universityArrayList.add(i, new University(row.getCell(0).getStringCellValue(),
                        row.getCell(1).getStringCellValue(),
                        row.getCell(2).getStringCellValue(),
                        (int) row.getCell(3).getNumericCellValue(),
                        StudyProfile.valueOf(row.getCell(4).getStringCellValue())));
                i++;
            }
        }

    }

    public static ArrayList<Student> getStudentArrayList() {
        return studentArrayList;
    }

    public static ArrayList<University> getUniversityArrayList() {
        return universityArrayList;
    }
}
