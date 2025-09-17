import java.util.*;

public class Sets
{
	public static void AddToSet(Set<String> str) {
		str.add("Cars");
		Collections.addAll(str, "Tesla", "BMW", "Audi", "Mercedes", "Ford", 
                   "Honda", "Hyundai", "Toyota", "Kia", "Nissan");
	}

	public static Set<Integer> RemoveDuplicates(List<Integer> nums, Set<Integer> numset) {
		for(int num : nums) {
			numset.add(num);
		}
		return numset;
	}

	public static boolean FindEquality(List<Integer> nums) {
		Set<String> set1 = new HashSet<>(Arrays.asList("Tesla", "BMW", "Audi"));
        Set<String> set2 = new HashSet<>(Arrays.asList("Audi", "BMW", "Tesla"));

        boolean isEqual = set1.equals(set2);
        return isEqual;
	}

	public static List<Integer> FindIntersection(List<Integer> nums) {
		List<Integer> Intersection = new ArrayList<>();
		Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 3, 5, 7, 9, 11));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(2, 3, 6, 7, 10, 11));

		for(int num : set1){
		    if(set2.contains(num)) Intersection.add(num);
		}

		return Intersection;
	}
	
	public static Set<Integer> FindUnion(Set<Integer> A, Set<Integer> B) {
        Set<Integer> ans = new HashSet<>(A);
        ans.addAll(B);
        return ans;
    }

    public static Set<Integer> FindDifference(Set<Integer> A, Set<Integer> B) {
        Set<Integer> ans = new HashSet<>(A);
        ans.removeAll(B);
        return ans;
    }

    public static Set<Integer> FindSymmetricDifference(Set<Integer> A, Set<Integer> B) {
        Set<Integer> ans = new HashSet<>(A);
        ans.addAll(B); 

        Set<Integer> common = new HashSet<>(A);
        common.retainAll(B); 

        ans.removeAll(common);
        return ans;
    }
    
    public static boolean ContainsAll(Set<Integer> setA, Set<Integer> setB) {
        return setA.containsAll(setB);
    }
    
    public static List<Integer> SetToList(Set<Integer> set) {
        return new ArrayList<>(set);
    }
    
    public static Set<Integer> ListToSet(List<Integer> list) {
        return new HashSet<>(list);
    }
    
    public static boolean RemoveElement(Set<Integer> set, int value) {
        return set.remove(value); 
    }
    
    public static void printWordCounts(List<String> words) {
        Set<String> s = new HashSet<>(words); 
        Map<String, Integer> map = new HashMap<>();

        for (String word : words) {
            if (map.containsKey(word)) map.put(word, map.get(word) + 1);
            else map.put(word, 1); 
        }

        for (String word : s) {
            System.out.println(word + ": " + map.get(word));
        }
    }
    
	public static void main(String[] args) {

		Set<String> str = new HashSet<>();
		Set<Integer> numset = new HashSet<>();
		List<Integer> nums = new ArrayList<>();
		Collections.addAll(nums, 1, 6, 3, 9, 5, 4, 3, 2, 8, 7, 9, 10, 5);
		Set<Integer> A = new HashSet<>(Arrays.asList(1, 3, 5, 7, 9, 11));
        Set<Integer> B = new HashSet<>(Arrays.asList(2, 3, 6, 7, 10, 11));
        List<String> words = Arrays.asList("Toyota", "Honda", "Ford", "Toyota", "BMW", "Honda", "Tesla", "BMW", "Ford", "Toyota");

		System.out.println("Adding names to the set");
		AddToSet(str);
		System.out.println(str);

		System.out.println("Removing Duplicates");
		Set<Integer> Dup = RemoveDuplicates(nums, numset);
		System.out.println(Dup);

		System.out.println("Finding Equality of Sets");
		boolean Equal = FindEquality(nums);
		System.out.println(Equal);

		System.out.println("Finding Intersection");
		List<Integer> Intersection = FindIntersection(nums);
		System.out.println(Intersection);
		
		System.out.println("Finding Union");
		Set<Integer> Union = FindUnion(A, B);
		System.out.println(Union);
		
		System.out.println("Finding Difference");
		Set<Integer> Difference = FindDifference(A, B);
		System.out.println(Difference);
		
		System.out.println("Finding Symmetric Difference");
		Set<Integer> SymmetricDifference = FindSymmetricDifference(A, B);
		System.out.println(SymmetricDifference); 
		
		System.out.println("Finding whether set contains all the elements of another set");
		boolean AllElements = ContainsAll(A, B);
		System.out.println(AllElements);
		
		System.out.println("Converting Set to List");
		List<Integer> setToList = SetToList(A);
		System.out.println(setToList);
		
		System.out.println("Converting List to Set");
		Set<Integer> listToSet = ListToSet(nums);
		System.out.println(listToSet);
		
		System.out.println("Removing an element from Set");
        boolean removed = RemoveElement(A, 5);
        System.out.println(removed);
		
		System.out.println("Unique words and their frequencies:");
		printWordCounts(words);

	}
}