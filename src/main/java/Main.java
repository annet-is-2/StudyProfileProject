public class Main {
    public static void main(String[] args) {

        System.out.println("Check out Collections are empty");
        System.out.println("count of universities:" + InitializeCollection.getUniversityArrayList().size());
        System.out.println("count of students:" + InitializeCollection.getStudentArrayList().size());
        System.out.println("--- Let's populate collections ---");

        try {
            InitializeCollection.initCollections();

            System.out.println("--- List of Universities ---");
            // check out what we got in University Collection
            InitializeCollection.getUniversityArrayList().forEach(std -> System.out.println(std));

            System.out.println("--------");
            System.out.println("--- List of Students ---");

            // check out what we got in Student Collection
            InitializeCollection.getStudentArrayList().forEach(std -> System.out.println(std));
        } catch (Exception e) {
            System.out.println("System Exception: "+ e.getMessage());
        }

    }
}
