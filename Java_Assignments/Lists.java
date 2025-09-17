import java.util.*;

class Student {
    int id;
    String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String toString() {
        return "(" + id + ", " + name + ")";
    }
}

public class Lists {

    public static void AddToList(List<Integer> nums) {
        nums.add(1);
        Collections.addAll(nums, 6, 3, 9, 5, 4, 3, 2, 8, 7, 9, 10, 5);
    }

    public static List<Integer> RemoveEvenNums(List<Integer> nums) {
        List<Integer> Even = new ArrayList<>();
        for (int num : nums) {
            if (num % 2 != 0) Even.add(num);
        }
        return Even;
    }

    public static int[] FindMinMax(List<Integer> nums) {
        int min = nums.get(0), max = nums.get(0);
        for (int num : nums) {
            if (num < min) min = num;
            if (num > max) max = num;
        }
        return new int[]{min, max};
    }

    public static List<Integer> AscendingOrder(List<Integer> nums) {
        List<Integer> Asc = new ArrayList<>(nums);
        Asc.sort(Comparator.naturalOrder());
        return Asc;
    }

    public static List<Integer> DescendingOrder(List<Integer> nums) {
        List<Integer> Desc = new ArrayList<>(nums);
        Desc.sort(Comparator.reverseOrder());
        return Desc;
    }

    public static List<Integer> ManualReverse(List<Integer> nums) {
        List<Integer> reversed = new ArrayList<>();
        for (int i = nums.size() - 1; i >= 0; i--) {
            reversed.add(nums.get(i));
        }
        return reversed;
    }

    public static List<Integer> BuiltinReverse(List<Integer> nums) {
        List<Integer> reversed = new ArrayList<>(nums);
        Collections.reverse(reversed);
        return reversed;
    }

    public static boolean CheckElement(List<Integer> nums, int num) {
        return nums.contains(num);
    }

    public static List<Integer> FindDuplicates(List<Integer> nums) {
        List<Integer> dup = new ArrayList<>();
        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (!seen.add(num)) {
                if (!dup.contains(num)) System.out.print(num + " ");
            }
        }
        return new ArrayList<>(seen);
    }

    public static List<Integer> ArrayToList() {
        int[] arr = {1, 2, 4, 8, 9, 4, 7};
        List<Integer> list = new ArrayList<>();
        for (int num : arr) {
            list.add(num);
        }
        return list;
    }

    public static List<Integer> MergeLists() {
        List<Integer> list1 = new ArrayList<>();
        Collections.addAll(list1, 1, 2, 3, 4, 5);
        List<Integer> list2 = new ArrayList<>();
        Collections.addAll(list2, 6, 7, 8, 9, 10);
        List<Integer> merged = new ArrayList<>(list1);
        merged.addAll(list2);
        return merged;
    }

    public static List<Student> AddStudentsToList() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Ravi"));
        students.add(new Student(2, "Ajay"));
        students.add(new Student(3, "Pavan"));
        students.add(new Student(4, "Bharat"));
        students.add(new Student(5, "Kiran"));
        return students;
    }

    public static List<Student> SortStudentsByName(List<Student> students) {
        students.sort(Comparator.comparing(student -> student.name));
        return students;
    }

    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();

        System.out.println("Adding integers to the list");
        AddToList(nums);
        System.out.println(nums);

        System.out.println("Removing Even Numbers");
        System.out.println(RemoveEvenNums(nums));

        System.out.println("Finding Minimum and Maximum");
        int[] MinMax = FindMinMax(nums);
        System.out.println("Min: " + MinMax[0] + ", Max: " + MinMax[1]);

        System.out.println("Acending Order");
        System.out.println(AscendingOrder(nums));

        System.out.println("Descending Order");
        System.out.println(DescendingOrder(nums));

        System.out.println("Manual Reverse");
        System.out.println(ManualReverse(nums));

        System.out.println("Built-in Reverse");
        System.out.println(BuiltinReverse(nums));

        System.out.println("Checking an Element");
        System.out.println(CheckElement(nums, 10));

        System.out.println("Duplicates");
        FindDuplicates(nums); // Print handled inside method

        System.out.println("\nArray To List");
        System.out.println(ArrayToList());

        System.out.println("Merging Two Lists");
        System.out.println(MergeLists());

        System.out.println("Adding Students to the List");
        List<Student> students = AddStudentsToList();
        for (Student s : students) System.out.println(s);

        System.out.println("Sorting the Students by name");
        List<Student> sortedStudents = SortStudentsByName(students);
        for (Student s : sortedStudents) System.out.println(s);
    }
}
