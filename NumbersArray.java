import java.util.*;

public class NumbersArray {
    public static void main(String[] args) {
        Integer[] input = { 1, 2, 3, 4, 1, 5 };

        System.out.println("Input : " + Arrays.toString(input));
        System.out.println("Max number : " + findMax(input));
        System.out.println("Duplicate numbers : " + Arrays.toString(findDuplicates(input)));
        System.out.println("Unique numbers : " + Arrays.toString(findUnique(input)));

        System.out.println();

        input = new Integer[] { 1, 2, 3, 4, 1, 2, 5, 3 };

        System.out.println("Input : " + Arrays.toString(input));
        System.out.println("Max number : " + findMax(input));
        System.out.println("Duplicate numbers : " + Arrays.toString(findDuplicates(input)));
        System.out.println("Unique numbers : " + Arrays.toString(findUnique(input)));
    }

    // Write your methods here 123
    public static Integer findMax(Integer[] nums) {
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (max <= nums[i]) {
                max = nums[i];
            }
        }

        return max;
    }

    public static Integer[] findDuplicates(Integer[] nums) {
        Map<Integer, Integer> counts = new HashMap<>();
        List<Integer> duplicates = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            counts.put(nums[i], counts.get(nums[i]) != null ? counts.get(nums[i]) + 1 : 1);
        }

        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            if (entry.getValue() > 1) {
                duplicates.add(entry.getKey());
            }
        }

        return duplicates.toArray(new Integer[0]);
    }

    public static Integer[] findUnique(Integer[] nums) {
        Map<Integer, Integer> counts = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            counts.put(nums[i], counts.get(nums[i]) != null ? counts.get(nums[i]) + 1 : 1);
        }

        return counts.entrySet().stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .toArray(Integer[]::new);
    }
}
