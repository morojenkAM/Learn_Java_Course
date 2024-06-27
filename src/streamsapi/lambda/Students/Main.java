package streamsapi.lambda.Students;

import java.util.*;

import static java.util.stream.Collectors.*;

public class Main {
    public static void main(String[] args) {
        List <Student> students = new ArrayList<>();
        students.add(new Student("John", "Doe", 30, "Male", "Mechanical Engineering", 122));
        students.add(new Student("Jane", "Smith", 22, "Female", "Computer Engineering", 324));
        students.add(new Student ("Ann", "Gurnmeister", 56, "Female", "Biotech Engineering", 64));
        students.add(new Student("Elon", "Gated", 27, "Male", "Mechanical Engineering", 90));
        students.add(new Student("Justin", "Case", 26, "Male", "Computer Engineering", 340));
        students.add(new Student("Dianne", "Ameter", 31, "Female", "Biotech Engineering", 128));
        students.add(new Student("Joss", "Sticks", 23, "Male", "Computer Engineering", 20));

        List <Student> filteredStudents = students.stream()
                .filter(a -> a.getFirstName().startsWith("A"))//Find a list of students whose first name starts with 'A'
                .collect(toList());
        System.out.println("\n Name whose first name starts with A");
        for (Student s : filteredStudents) {
            System.out.println(s);
        }

        Map<String, Set<String>> namesByDepertament   = students.stream()
                .collect(groupingBy(
                        Student::getDepartamentName,
                        mapping(
                                Student::getFirstName,
                                toSet())
                ));
        System.out.println("\n Group the students by department names");
        namesByDepertament.forEach((departamentName,firstName) -> System.out.println(departamentName + " : " + firstName));

        //total students
        long total = students.stream().count();
        System.out.println("\n Total number of students: " + total);


        // Max age using mapToInt and max
        OptionalInt maxAgeOptional = students.stream()
                .mapToInt(s -> s.getAge())
                .max();

        maxAgeOptional.ifPresent(maxAge -> System.out.println("Max age: " + maxAge));

        //departaments names
        // Gruparea studenților după numele departamentului și afișarea acestora
        Map<String, Set<Student>> studentsByDepartment = students.stream()
                .collect(groupingBy(
                        Student::getDepartamentName,
                        toSet()
                ));

        System.out.println("\n Students grouped by department:");
        studentsByDepartment.forEach((departmentName, studentSet) -> {
            System.out.println(departmentName + ":");
            studentSet.forEach(System.out::println);
        });

        // count of students in each department
        Map<String, Long> studentsByDepertament   = students.stream()
                .collect(groupingBy(
                        Student::getDepartamentName,//grupam dupa numele departamentuli
                        counting()) //numaram membrii
                );
        System.out.println("\n Count department ");
        studentsByDepertament.forEach((departament,count) -> System.out.println(departament + " : " +count));

        //Find the list of students whose age is less than 30

        List <Student> studentsUnder30 = students.stream()
                .filter(student -> student.getAge() < 30)
                .collect(toList());
        System.out.println("\n The list of students whose age is less than 30");
        for (Student k : studentsUnder30) {
            System.out.println(k);

            //Find the list of students whose rank is between 50 and 100
            List <Student> RankBetween50and100 = students.stream()
                    .filter(students3 -> students3.getAverageGrade() >=50 && students3.getAverageGrade() <=100)
                    .collect(toList());
            System.out.println("\n The list of students whose rank is between 50 and 100");
            for (Student l : RankBetween50and100) {
                System.out.println(l);


                //Find the average age of male and female students

                Map<String, Double> averageAge   = students.stream()
                        .collect(groupingBy(
                                Student::getGender,//grupam dupa gen
                                averagingInt(Student::getAge))); //calculam varsta;
                System.out.println("\n The average age of male and female students  ");
                studentsByDepertament.forEach((gender,averageAge1) -> System.out.println(gender + " : " + averageAge));


                //Find the department which is having the maximum number of students

                Map<String, Long> maxStudents   = students.stream()
                        .collect(groupingBy(
                                Student::getDepartamentName,//grupam dupa departament
                                counting()
                        ));//numara studentii

                String departamentWithMaxStudents = maxStudents.entrySet().stream()
                        .max(Map.Entry.comparingByValue()) // Găsește intrarea cu valoarea maximă (numărul maxim de studenți)
                        .map(Map.Entry::getKey) // Extrage cheia (numele departamentului) din intrarea găsită
                        .orElse("N/A"); // Dacă nu există nicio intrare, returnează "N/A" ca valoare implicită
                System.out.println("\n Department which is having the maximum number of students is " + departamentWithMaxStudents);

                //Find the average rank in all departments
                Map<String, Double> averageRank   = students.stream()
                        .collect(groupingBy(
                                Student::getDepartamentName,//grupam dupa departaemnt
                                averagingInt(Student::getAverageGrade))); //calculam nota;
                System.out.println("\n The average rank in all departments ");
                averageRank.forEach((departament1,averageRank1) -> System.out.println(departament1 + " : " + averageRank1));


                //Find the highest rank in each department
                Map<String, Optional<Student>> averageRankMax   = students.stream()
                        .collect(groupingBy(
                                Student::getDepartamentName,//grupam dupa departaemnt
                                maxBy(Comparator.comparingInt(Student::getAverageGrade))));//calculam nota

                System.out.println("\n The average rank in all departments ");
                averageRankMax.forEach((departament1,averageRankMax1) -> System.out.println(departament1 + " : " + averageRankMax1));


                //Sort students by their rank
                List<Student> sortedList = students.stream()
                        .sorted(Comparator.comparingInt(Student::getAverageGrade))
                        .collect(toList());
                System.out.println("\n Sort students by their rank");
                sortedList.forEach(System.out::println);

                //Find the student who has second-highest rank
               Optional<Student> secondHighestRank = students.stream()
                       .sorted(Comparator.comparingInt(Student ::getAverageGrade))
                       .skip(1)
                       .findFirst();
               System.out.println("\n The student who has second-highest rank " + secondHighestRank);

            }



        }
    }}
