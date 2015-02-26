package misc.liststuff;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MyList<T extends Comparable<? super T>> {
    public List<T> removeDuplicates(List<T> input, int n) {
        Map<T, Integer> temp = new LinkedHashMap<T, Integer>();
        int count;

        for (T element : input) {
            count = ((temp.containsKey(element)) ? temp.get(element) : 0);
            if (count < n) {
                temp.remove(element);
                temp.put(element, count + 1);
            }
        }
        return new LinkedList<T>(temp.keySet());
    }

    public List<T> mergeRecursiveDestructive(List<T> list1, List<T> list2) {

        if (0 == list1.size())
            return list2;
        if (0 == list2.size())
            return list1;

        List<T> result = new LinkedList<>();

        if (list1.get(0).compareTo(list2.get(0)) < 0) {
            result.add(list1.remove(0));
        } else {
            result.add(list2.remove(0));
        }

        result.addAll(mergeRecursiveDestructive(list1, list2));
        return result;
    }

    public List<T> mergeIterativeDestructive(List<T> list1, List<T> list2) {

        List<T> result = new LinkedList<>();

        while (list1.size() > 0 && list2.size() > 0) {
            if (list1.get(0).compareTo(list2.get(0)) < 0) {
                result.add(list1.remove(0));
            } else {
                result.add(list2.remove(0));
            }
        }

        result.addAll(list1);
        result.addAll(list2);
        list1.clear();
        list2.clear();

        return result;
    }

    public List<T> mergeRecursiveNonDestructive(List<T> list1, List<T> list2, List<T> result, int i, int j) {

        if (i == list1.size()) {
            result.addAll(list2.subList(j, list1.size() - 1));
            return result;
        }
        if (j == list2.size()) {
            result.addAll(list1.subList(i, list2.size() - 1));
            return result;
        }

        if (list1.get(i).compareTo(list2.get(j)) < 0) {
            result.add(list1.get(i));
            i++;
        } else {
            result.add(list2.get(j));
            j++;
        }

        return mergeRecursiveNonDestructive(list1, list2, result, i, j);
    }

    public List<T> mergeIterativeNonDestructive(List<T> list1, List<T> list2, List<T> result) {
        int i = 0;
        int j = 0;

        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i).compareTo(list2.get(j)) < 0) {
                result.add(list1.get(i));
                i++;
            } else {
                result.add(list2.get(j));
                j++;
            }
        }

        while (i < list1.size()) {
            result.add(list1.get(i));
            i++;
        }

        while (j < list2.size()) {
            result.add(list2.get(j));
            j++;
        }

        return result;
    }

    public List<T> mergeSort(List<T> list1) {
        if (list1.size() > 1) {
            List<T> left = new LinkedList<>(list1.subList(0, list1.size() / 2));
            List<T> right = new LinkedList<>(list1.subList(list1.size() / 2, list1.size()));
            return mergeIterativeDestructive(mergeSort(left), mergeSort(right));
        } else {
            return list1;
        }
    }

    public void dutchFlag(List<Integer> input) {
        int low = 0;
        int mid = 0;
        int high = input.size() - 1;

        while (low < high && input.get(low) == 0)
            low++;
        while (high > low && input.get(high) == 2)
            high--;
        mid = low;
        while (mid <= high) {
            switch (input.get(mid)) {
            case 0:
                swap(input, mid, low);
                low++;
                mid++;
                break;
            case 1:
                mid++;
                break;
            case 2:
                swap(input, high, mid);
                high--;
                break;
            }
        }
    }

    public <type> void swap(List<type> input, int from, int to) {
        type temp = input.get(to);
        input.set(to, input.get(from));
        input.set(from, temp);
    }

    public Set<List<Integer>> threeSum(List<Integer> input, int target) {
        Set<List<Integer>> result = new HashSet<List<Integer>>();

        ArrayList<Integer> sortedInput = new ArrayList<Integer>(input);
        Collections.sort(sortedInput);

        int j = 0;
        int k = 0;

        for (int i = 0; i < sortedInput.size(); i++) {
            j = i + 1;
            k = sortedInput.size() - 1;

            while (j < k) {
                int sum = sortedInput.get(i) + sortedInput.get(j) + sortedInput.get(k);
                if (sum == target) {
                    // add to result set
                    List<Integer> solTriplet = new ArrayList<Integer>();
                    Collections.addAll(solTriplet, sortedInput.get(i), sortedInput.get(j), sortedInput.get(k));
                    result.add(solTriplet);
                    j++;
                    k--;
                } else if (sum < target) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return result;
    }

    public Set<List<Integer>> threeSumHashMap(List<Integer> input, int target) {
        Set<List<Integer>> result = new HashSet<List<Integer>>();
        Map<Integer, List<Integer>> twoSum = new HashMap<Integer, List<Integer>>();

        for (int i = 0; i < input.size(); i++) {
            for (int j = 0; j < input.size(); j++) {
                if (i != j)
                    twoSum.put(input.get(i) + input.get(j), Arrays.asList(i, j));
            }
        }

        for (int i = 0; i < input.size(); i++) {
            List<Integer> candidate = twoSum.get(target - input.get(i));
            if (candidate != null && !candidate.contains(i)) {
                // add to result set
                List<Integer> solTriplet = new ArrayList<Integer>();
                solTriplet.add(input.get(i));
                for (Integer index : candidate) {
                    solTriplet.add(input.get(index));
                }
                Collections.sort(solTriplet);
                result.add(solTriplet);
            }
        }

        return result;
    }

    public Set<List<Integer>> twoSumHashMap(List<Integer> input, int target) {
        Set<List<Integer>> result = new HashSet<List<Integer>>();
        Map<Integer, Integer> numbers = new HashMap<Integer, Integer>();
        for (Integer in : input) {
            numbers.put(in, ((numbers.containsKey(in)) ? numbers.get(in) + 1 : 1));
        }

        for (Integer in : input) {
            int needed = target - in;
            if (numbers.get(in) > 0) {
                numbers.put(in, numbers.get(in) - 1);
                if (numbers.containsKey(needed) && numbers.get(needed) > 0) {
                    List<Integer> solpair = new ArrayList<Integer>();
                    solpair.add(in);
                    solpair.add(needed);
                    numbers.put(needed, numbers.get(needed) - 1);
                    result.add(solpair);
                } else {
                    numbers.put(in, numbers.get(in) + 1);
                }
            }
        }

        return result;
    }

}
