import java.util.*;
import java.util.stream.Collectors;
 
public class Main {
 
    static class Candidate {
        private String name;
        private int id;
        private int age;
        private String gender;
        private String department;
        private int yearOfJoining;
        private double salary;
 
        public Candidate(int id, String name, int age, String gender, String department, int yearOfJoining, double salary) {
            this.id = id;
            this.name = name;
            this.age = age;
            this.gender = gender;
            this.department = department;
            this.yearOfJoining = yearOfJoining;
            this.salary = salary;
        }
 
        public String getName() {
            return name;
        }
 
        public int getId() {
            return id;
        }
 
        public int getAge() {
            return age;
        }
 
        public String getGender() {
            return gender;
        }
 
        public String getDepartment() {
            return department;
        }
 
        public int getYearOfJoining() {
            return yearOfJoining;
        }
 
        public double getSalary() {
            return salary;
        }
 
        @Override
        public String toString() {
            return "Candidate{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", age=" + age +
                    ", gender='" + gender + '\'' +
                    ", department='" + department + '\'' +
                    ", yearOfJoining=" + yearOfJoining +
                    ", salary=" + salary +
                    '}';
        }
    }
 
    public static void main(String[] args) {
        List<Candidate> candidates = Arrays.asList(
                new Candidate(1, "Sarath", 25, "Male", "Product Development", 2020, 60000),
                new Candidate(2, "Samitha", 28, "Female", "HR", 2019, 55000),
                new Candidate(3, "Akhila", 23, "Female", "Product Development", 2021, 62000),
                new Candidate(4, "Bhanush", 22, "Male", "Product Development", 2022, 58000),
                new Candidate(5, "Hema", 29, "Female", "Marketing", 2018, 54000)
        );
 
        System.out.println("Gender Count: " + Implementation.getCount(candidates));
        System.out.println("Average Age by Gender: " + Implementation.getAverageAge(candidates));
        System.out.println("Department-wise Count: " + Implementation.countCandidatesDepartmentWise(candidates));
        System.out.println("Youngest Male in Product Development: " +
                Implementation.getYoungestCandidateDetails(candidates));
    }
 
    static class Implementation {
 
        public static Map<String, Long> getCount(List<Candidate> list) {
            return list.stream()
                    .collect(Collectors.groupingBy(Candidate::getGender, Collectors.counting()));
        }
 
        public static Map<String, Double> getAverageAge(List<Candidate> list) {
            return list.stream()
                    .collect(Collectors.groupingBy(Candidate::getGender, Collectors.averagingInt(Candidate::getAge)));
        }
 
        public static Map<String, Long> countCandidatesDepartmentWise(List<Candidate> list) {
            return list.stream()
                    .collect(Collectors.groupingBy(Candidate::getDepartment, Collectors.counting()));
        }
 
        public static Optional<Candidate> getYoungestCandidateDetails(List<Candidate> list) {
            return list.stream()
                    .filter(c -> "Male".equalsIgnoreCase(c.getGender()) &&
                            "Product Development".equalsIgnoreCase(c.getDepartment()))
                    .min(Comparator.comparingInt(Candidate::getAge));
        }
    }
}
 
 