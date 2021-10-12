public class Main {
    public static void main(String[] args) {
        University universityMGU = new University("123", "Moscow State University", "MGU",
                                                  1835, StudyProfile.MEDICINE);



        Student studentPeter = new Student("Peter Petrov", "123", 3, (float)99.87);

        System.out.println(studentPeter);
        System.out.println(universityMGU);

    }
}
