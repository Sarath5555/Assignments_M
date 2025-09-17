import java.util.*;
import java.util.stream.Collectors;

class Employee {
	String name;
	String department;
	double salary; 

	public Employee(String name, String department) {
		this.name = name;
		this.department = department;
	}

	public Employee(String name, double salary) {
		this.name = name;
		this.salary = salary;
	}

	public String toString() {
		return name;
	}
}

public class streams {

	public static List<String> sortStrings(List<String> input) {
		Collections.sort(input);
		return input;
	}

	public static long countLongStrings(List<String> input) {
		return input.stream()
		       .filter(s -> s.length() > 4)
		       .count();
	}

	public static Map<String, List<Employee>> groupByDepartment(List<Employee> employees) {
		return employees.stream()
		       .collect(Collectors.groupingBy(emp -> emp.department));
	}

	public static double findAverageSalary(List<Employee> employees) {
		return employees.stream()
		       .mapToDouble(emp -> emp.salary)
		       .average()
		       .orElse(0.0);
	}

	public static String concatenateWithCommas(List<String> input) {
		return String.join(",", input);
	}

	public static String findHighestPaidEmployee(List<Employee> employees) {
		return employees.stream()
		       .max(Comparator.comparingDouble(emp -> emp.salary))
		       .map(emp -> emp.name)
		       .orElse("No Employees");
	}

	public static Map<String, Integer> mapNamesToLengths(List<String> names) {
		return names.stream()
		       .collect(Collectors.toMap(name -> name, String::length));
	}

	public static List<String> convertToUpperCase(List<String> input) {
		return input.stream()
		       .map(String::toUpperCase)
		       .collect(Collectors.toList());
	}

	public static List<Integer> getFirstThreeNumbers(List<Integer> numbers) {
		return numbers.stream()
		       .limit(3)
		       .collect(Collectors.toList());
	}

	public static long multiplyAllNumbers(List<Integer> numbers) {
		return numbers.stream()
		       .reduce(1, (a, b) -> a * b);
	}

	public static long countDistinctWords(String sentence) {
		return Arrays.stream(sentence.toLowerCase().split("\\W+"))
		       .filter(s -> !s.isEmpty())
		       .distinct()
		       .count();
	}

	public static List<String> findNamesStartingWithA(List<String> names) {
		return names.stream()
		       .filter(name -> name.startsWith("A"))
		       .collect(Collectors.toList());
	}

	public static String findLongestString(List<String> input) {
		return input.stream()
		       .max(Comparator.comparingInt(String::length))
		       .orElse("No Strings");
	}

	public static Map<String, Long> countWordOccurrences(String sentence) {
		return Arrays.stream(sentence.split("\\s+"))
		       .collect(Collectors.groupingBy(word -> word, Collectors.counting()));
	}

	public static String joinUppercaseNames(List<String> names) {
		return names.stream()
		       .map(String::toUpperCase)
		       .collect(Collectors.joining(" - "));
	}

	public static void main(String[] args) {

		System.out.println("1. Sort strings");
		List<String> fruits = Arrays.asList("banana", "apple", "mango");
		System.out.println("Sorted Strings: " + sortStrings(fruits));

		System.out.println("2. Count long strings");
		List<String> animals = Arrays.asList("cat", "tiger", "lion", "crocodile");
		System.out.println("Count of long strings: " + countLongStrings(animals));

		System.out.println("3. Group employees by department");
		List<Employee> employeesDept = Arrays.asList(
		                                   new Employee("John", "IT"),
		                                   new Employee("Alice", "HR"),
		                                   new Employee("Bob", "IT")
		                               );
		System.out.println("Group by Department: " + groupByDepartment(employeesDept));

		System.out.println("4. Find average salary");
		List<Employee> employeesSalary = Arrays.asList(
		                                     new Employee("John", 50000),
		                                     new Employee("Alice", 60000)
		                                 );
		System.out.println("Average Salary: " + findAverageSalary(employeesSalary));

		System.out.println("5. Concatenate strings with commas");
		List<String> languages = Arrays.asList("Java", "Python", "C++");
		System.out.println("Concatenated: " + concatenateWithCommas(languages));

		System.out.println("6. Find highest paid employee");
		List<Employee> employeesHighPay = Arrays.asList(
		                                      new Employee("John", 70000),
		                                      new Employee("Alice", 95000)
		                                  );
		System.out.println("Highest Paid Employee: " + findHighestPaidEmployee(employeesHighPay));

		System.out.println("7. Map names to their lengths");
		List<String> names = Arrays.asList("Tom", "Elizabeth", "Sam");
		System.out.println("Names to Lengths: " + mapNamesToLengths(names));

		System.out.println("8. Convert all strings to uppercase");
		List<String> techs = Arrays.asList("java", "python");
		System.out.println("Uppercase Strings: " + convertToUpperCase(techs));

		System.out.println("9. Get first 3 numbers from a list");
		List<Integer> numbers = Arrays.asList(40, 15, 25, 20, 35, 7);
		System.out.println("First 3 Numbers: " + getFirstThreeNumbers(numbers));

		System.out.println("10. Multiply all numbers using reduce");
		System.out.println("Multiplication Result: " + multiplyAllNumbers(numbers));

		System.out.println("11. Count distinct words");
		String sentence = "Java is great. JAVA is powerful.";
		System.out.println("Distinct Words Count: " + countDistinctWords(sentence));

		System.out.println("12. Find names starting with A");
		List<String> namesList = Arrays.asList("Alice", "Bob", "Andrew", "Tom");
		System.out.println("Names starting with A: " + findNamesStartingWithA(namesList));

		System.out.println("13. Find longest string");
		List<String> strings = Arrays.asList("cat", "elephant", "dog");
		System.out.println("Longest String: " + findLongestString(strings));

		System.out.println("14. Count occurrences of each word");
		String text = "apple banana apple orange banana apple";
		System.out.println("Word Occurrences: " + countWordOccurrences(text));

		System.out.println("15. Join uppercase names with -");
		List<String> nameList = Arrays.asList("john", "alice", "mark");
		System.out.println("Joined Uppercase Names: " + joinUppercaseNames(nameList));
	}
}
