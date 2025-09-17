import java.util.*;

public class SetMap {

    public static Set<Integer> unionOfHashSets(Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> unionSet = new HashSet<>(set1);
        unionSet.addAll(set2);
        return unionSet;
    }

    public static void priorityQueueOperations(List<Integer> elements) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(elements);
    
        System.out.println("PriorityQueue: " + new PriorityQueue<>(pq));
        System.out.println("Peek: " + pq.peek());
        System.out.println("Removed: " + pq.remove());
        System.out.println("AfterRemoval: " + pq);
    }


    public static void dequeOperations() {
        Deque<Integer> deque = new LinkedList<>();
        
        deque.addFirst(5);
        deque.addFirst(6);
        deque.addFirst(7);

        deque.addLast(2);
        deque.addLast(3);
        deque.addLast(4);

        System.out.println("DequeInitial: " + new LinkedList<>(deque));
        Integer removedFirst = deque.removeFirst();
        System.out.println("RemovedFirst: " + removedFirst);
        Integer removedLast = deque.removeLast();
        System.out.println("RemovedLast: " + removedLast);
        System.out.println("DequeAfterRemovals: " + deque);
    }

    public static Map<String, Integer> wordFrequency(String sentence) {
        String[] words = sentence.replaceAll("[^a-zA-Z ]", "").split("\\s+");
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        return wordCount;
    }

    public static Map<Character, Integer> charFrequency(String input) {
        Map<Character, Integer> charCount = new HashMap<>();
        for (char c : input.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }
        return charCount;
    }

    public static Map<String, String> phoneBook() {
        Map<String, String> contacts = new HashMap<>();
        contacts.put("Alice", "9876543210");
        contacts.put("Bob", "9123456780");
        contacts.put("Charlie", "9988776655");
        return contacts;
    }

    public static List<Map.Entry<String, Integer>> sortMapByValue(Map<String, Integer> employeeSalary) {
        List<Map.Entry<String, Integer>> list = new ArrayList<>(employeeSalary.entrySet());
        list.sort(Map.Entry.comparingByValue());
        return list;
    }

    public static Map<Integer, List<String>> groupWordsByLength(List<String> words) {
        Map<Integer, List<String>> lengthMap = new HashMap<>();
        for (String word : words) {
            int len = word.length();
            lengthMap.putIfAbsent(len, new ArrayList<>());
            lengthMap.get(len).add(word);
        }
        return lengthMap;
    }

    public static Map<String, String> swapKeysAndValues(Map<String, String> map) {
        Map<String, String> swapped = new HashMap<>();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            swapped.put(entry.getValue(), entry.getKey());
        }
        return swapped;
    }

    public static Map<String, Integer> listElementFrequency(List<String> list) {
        Map<String, Integer> freqMap = new HashMap<>();
        for (String item : list) {
            freqMap.put(item, freqMap.getOrDefault(item, 0) + 1);
        }
        return freqMap;
    }

    public static void main(String[] args) {

        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3, 4));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(3, 4, 5, 6));
        
        List<Integer> nums = Arrays.asList(5, 1, 3, 7, 2);

        String sentence = "This is a test. This test is easy.";
        String charInput = "banana";

        Map<String, Integer> employeeSalary = new HashMap<>();
        employeeSalary.put("Alice", 50000);
        employeeSalary.put("Bob", 75000);
        employeeSalary.put("Charlie", 60000);

        List<String> words = Arrays.asList("apple", "bat", "car", "orange");

        Map<String, String> sampleMap = new HashMap<>();
        sampleMap.put("A", "Apple");
        sampleMap.put("B", "Banana");
        sampleMap.put("C", "Cherry");

        List<String> fruits = Arrays.asList("apple", "banana", "apple", "orange", "banana", "apple");
        
        System.out.println("1. Union of HashSets");        
        System.out.println(unionOfHashSets(set1, set2));

        System.out.println("2. PriorityQueue Operations");
        priorityQueueOperations(nums);

        System.out.println("3. Deque Operations");
        dequeOperations();

        System.out.println("4. Word Frequency");
        System.out.println(wordFrequency(sentence));

        System.out.println("5. Character Frequency");
        System.out.println(charFrequency(charInput));

        System.out.println("6. Phone Book");
        System.out.println(phoneBook()); 
        
        System.out.println("7. Employees Sorted by Salary");
        System.out.println(sortMapByValue(employeeSalary));

        System.out.println("8. Words Grouped by Length");
        System.out.println(groupWordsByLength(words));
        
        System.out.println("9. Swapped Map");
        System.out.println(swapKeysAndValues(sampleMap));

        System.out.println("10. Element Frequencies");
        System.out.println(listElementFrequency(fruits));
    }
}
