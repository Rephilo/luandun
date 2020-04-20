package com.rephilo.luandun.service.leetcode;

import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 没事写写LeetCode的题
 *
 * @author wangxiao15
 */
@Service
public class LeetcodeService {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 001
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (map.containsKey(diff) && map.get(diff) != i) {
                return new int[]{i, map.get(diff)};
            }
        }

        return new int[2];
    }

    /**
     * 002
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int step = 0;
        ListNode listNode = null;
        ListNode head = null;

        while (l1 != null || l2 != null) {
            int val1 = l1 != null ? l1.val : 0;
            int val2 = l2 != null ? l2.val : 0;

            int result = val1 + val2;

            if (step > 0) {
                result = result + step;
                step--;
            }

            if (result > 9) {
                result = result - 10;
                step++;
            }

            if (listNode == null) {
                listNode = new ListNode(result);
                head = listNode;
            } else {
                listNode.next = new ListNode(result);
                listNode = listNode.next;
            }

            if (l1 != null) {
                l1 = l1.next;
            }

            if (l2 != null) {
                l2 = l2.next;
            }
        }

        if (step > 0) {
            listNode.next = new ListNode(step);
        }

        return head;
    }

    /**
     * 003
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        for (int i = 0, j = 0; i < s.length(); ++i) {
            if (map.containsKey(s.charAt(i))) {
                j = Math.max(j, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - j + 1);
        }
        return max;
    }

    /**
     * 007
     *
     * @param x
     * @return
     */
    public static int reverse(int x) {
        int result = 0;

        while (x != 0) {
            int tail = x % 10;
            int newResult = result * 10 + tail;
            if ((newResult - tail) / 10 != result) {
                return 0;
            }
            result = newResult;
            x = x / 10;
        }

        return result;
    }

    /**
     * 009
     *
     * @param x
     * @return
     */
    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int reverse = 0;
        int y = x;

        while (x != 0) {
            reverse = reverse * 10 + x % 10;
            x = x / 10;
        }

        return y == reverse;
    }

    /**
     * 013
     *
     * @param s
     * @return
     */
    public int romanToInt(String s) {
        int result = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            int currNum = getNum(s.charAt(i));
            int nextNum = getNum(s.charAt(i + 1));
            if (currNum < nextNum) {
                result -= currNum;
            } else {
                result += currNum;
            }
        }

        result += getNum(s.charAt(s.length() - 1));
        return result;
    }

    private int getNum(char currStr) {
        switch (currStr) {
            case 'M':
                return 1000;
            case 'D':
                return 500;
            case 'C':
                return 100;
            case 'L':
                return 50;
            case 'X':
                return 10;
            case 'V':
                return 5;
            case 'I':
                return 1;
            default:
                return 0;
        }
    }

    /**
     * 014
     *
     * @param strs
     * @return
     */
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String pre = strs[0];
        for (String str : strs) {
            while (!str.startsWith(pre)) {
                pre = pre.substring(0, pre.length() - 1);
            }
        }

        return pre;
    }

    /**
     * 020
     *
     * @param s
     * @return
     */
    public static boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>(3);
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(map.get(c));
            } else if (stack.isEmpty() || !stack.pop().equals(c)) {
                return false;
            }
        }

        return stack.isEmpty();
    }

    /**
     * 021
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode tempNode = null;
        while (l1 != null || l2 != null) {
            int currNum;
            if (l1 == null) {
                currNum = l2.val;
                l2 = l2.next;
            } else if (l2 == null) {
                currNum = l1.val;
                l1 = l1.next;
            } else {
                if (l1.val <= l2.val) {
                    currNum = l1.val;
                    l1 = l1.next;
                } else {
                    currNum = l2.val;
                    l2 = l2.next;
                }
            }

            if (head == null) {
                head = new ListNode(currNum);
                tempNode = head;
            } else {
                tempNode.next = new ListNode(currNum);
                tempNode = tempNode.next;
            }
        }

        return head;
    }

    /**
     * 033
     *
     * @param nums
     * @param target
     * @return
     */
    public static int search33(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }

        int boundIndex = findBoundIndex(nums, 0, nums.length - 1);
        if (boundIndex <= 0) {
            return binarySearch(nums, 0, nums.length - 1, target);
        } else if (nums[boundIndex] == target) {
            return boundIndex;
        } else if (nums[0] > target) {
            return binarySearch(nums, boundIndex, nums.length - 1, target);
        } else {
            return binarySearch(nums, 0, boundIndex - 1, target);
        }
    }

    /**
     * 寻找轴值
     *
     * @param nums
     * @return
     */
    public static int findBoundIndex(int[] nums, int left, int right) {
        if (left == right) {
            return -1;
        }
        int mid = (left + right) / 2;

        //最左边情况
        if (mid == 0) {
            if (nums[mid] > nums[mid + 1]) {
                return mid + 1;
            } else {
                return -1;
            }
        }

        //最右边情况
        if (mid == nums.length - 1) {
            if (nums[mid - 1] > nums[mid]) {
                return mid;
            } else {
                return -1;
            }
        }

        //找到部分顺序队列
        if (nums[mid - 1] < nums[mid] && nums[mid] < nums[mid + 1]) {
            int l = findBoundIndex(nums, left, mid);
            int r = findBoundIndex(nums, mid + 1, right);

            return Math.max(l, r);
        } else {
            if (nums[mid] > nums[mid - 1]) {
                return mid + 1;
            } else {
                return mid;
            }
        }
    }

    /**
     * 049
     * 更骚的做法给每个数字映射成一个质数，相乘的积相同则属于同一个list
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> tmp = new HashMap<>();
        if (strs != null) {
            for (String str : strs) {
                char[] chars = str.toCharArray();
                Arrays.sort(chars);
                String key = String.valueOf(chars);
                tmp.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
            }


            result.addAll(tmp.values());
        }

        return result;
    }

    /**
     * 053
     * 不太懂为什么可以转换成直接求和，看问题的角度没找对
     *
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i - 1] > 0) {
                nums[i] += nums[i - 1];
            }
            maxSum = Math.max(nums[i], maxSum);
        }
        return maxSum;
    }

    /**
     * 064
     * 经典动态规划
     *
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int[][] dp = new int[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = grid[i][j];
                } else if (i == 0) {
                    dp[i][j] += dp[i][j - 1] + grid[i][j];
                } else if (j == 0) {
                    dp[i][j] += dp[i - 1][j] + grid[i][j];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j] + grid[i][j], dp[i][j - 1] + grid[i][j]);
                }
            }
        }

        return dp[grid.length - 1][grid[0].length - 1];
    }

    /**
     * 122 只要后一天比前一天高，就可以按照一天一天的买进
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - prices[i - 1] > 0) {
                max += prices[i] - prices[i - 1];
            }
        }

        return max;
    }

    /**
     * 136
     * 常规解法，没考虑空间复杂度
     * 天秀解法，异或
     *
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        return Arrays.stream(nums).reduce((x, y) -> x ^ y).orElse(0);
//        int result = 0;
//        Map<Integer, Integer> tempMap = new HashMap<Integer, Integer>();
//        for (int num : nums) {
//            tempMap.putIfAbsent(num, 0);
//            tempMap.put(num, tempMap.get(num) + 1);
//        }
//
//        for (Map.Entry<Integer, Integer> entry : tempMap.entrySet()) {
//            if (entry.getValue() < 2) {
//                result = entry.getKey();
//            }
//        }
//
//        return result;
    }

    /**
     * 200
     *
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int row = grid.length;
        int col = grid[0].length;
        int iland = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    iland++;
                    dfs(grid, i, j);
                }
            }
        }

        return iland;
    }

    void dfs(char[][] grid, int r, int c) {
        int row = grid.length;
        int col = grid[0].length;

        if (r < 0 || c < 0
                || r >= row || c >= col
                || grid[r][c] == '0') {
            return;
        }

        grid[r][c] = '0';
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }

    /**
     * 202
     * 这个题有问题 为什么会收敛到一个循环，无法证明
     *
     * @param n
     * @return
     */
    public boolean isHappy(int n) {
        try {
            return duCalc(n, 1);
        } catch (Exception ignored) {

        }
        return false;
    }

    private Boolean duCalc(int m, int times) {
        if (times > 100) {
            return false;
        }
        int result = 0;
        while (m > 0) {
            int i = m % 10;
            result += i * i;
            m = m / 10;
        }

        if (result == 1) {
            return true;
        } else {
            return duCalc(result, times + 1);
        }
    }

    /**
     * 238 左边乘一遍，右边乘一遍
     * 动态规划
     *
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int left = 1;
        for (int i = 0; i < res.length; i++) {
            res[i] = left;
            left *= nums[i];
        }
        int right = 1;
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] *= right;
            right *= nums[i];
        }
        return res;
    }

    /**
     * 283 想到了双指针，没想到简单的写法
     *
     * @param nums
     */
    public static void moveZeroes(int[] nums) {
        if (nums == null) {
            return;
        }
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                j++;
            }
        }
    }

    /**
     * 525
     *
     * @param nums
     * @return
     */
    public static int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int maxlen = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            count = count + (nums[i] == 1 ? 1 : -1);
            if (map.containsKey(count)) {
                maxlen = Math.max(maxlen, i - map.get(count));
            } else {
                map.put(count, i);
            }
        }
        return maxlen;
    }

    /**
     * 543
     *
     * @param root
     * @return
     */
    public int diameterOfBinaryTree(TreeNode root) {
        return depth(root, 0);
    }

    private int depth(TreeNode currNode, int max) {
        if (currNode == null) {
            return 0;
        }

        int left = depth(currNode.left, max);
        int right = depth(currNode.right, max);
        max = Math.max(left + right, max);

        return Math.max(left, right) + 1;
    }

    /**
     * 678
     * 贪心算法，检查左右是否匹配，将*处理成边界值，如果最终的结果区间包含0则返回true
     *
     * @param s
     * @return
     */
    public boolean checkValidString(String s) {
        int minOpen = 0, maxOpen = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                minOpen++;
                maxOpen++;
            } else if (c == ')') {
                minOpen--;
                maxOpen--;
            } else {
                minOpen--;
                maxOpen++;
            }
            if (maxOpen < 0) {
                return false;
            }
            minOpen = Math.max(minOpen, 0);
        }
        return minOpen == 0;
    }

    /**
     * 704
     *
     * @param nums
     * @param target
     * @return
     */
    public static int search704(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length - 1, target);
    }

    private static int binarySearch(int[] nums, int start, int end, int target) {
        int mid = (start + end) / 2;
        if (start > end) {
            return -1;
        }
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] < target) {
            return binarySearch(nums, mid + 1, end, target);
        } else if (nums[mid] > target) {
            return binarySearch(nums, start, mid - 1, target);
        }

        return -1;
    }

    /**
     * 844
     *
     * @param S
     * @param T
     * @return
     */
    public boolean backspaceCompare(String S, String T) {
        StringBuilder s = new StringBuilder();
        StringBuilder t = new StringBuilder();
        for (Character c : S.toCharArray()) {
            if (c.equals('#')) {
                if (s.length() > 0) {
                    s.deleteCharAt(s.length() - 1);
                }
            } else {
                s.append(c);
            }
        }

        for (Character c : T.toCharArray()) {
            if (c.equals('#')) {
                if (t.length() > 0) {
                    t.deleteCharAt(t.length() - 1);
                }
            } else {
                t.append(c);
            }
        }

        return s.toString().equals(t.toString());
    }

    /**
     * 876
     *
     * @param head
     * @return
     */
    public static ListNode middleNode(ListNode head) {
        int i = 0;
        int j = 0;
        ListNode curr = head;
        while (curr != null) {
            curr = curr.next;
            i++;
        }

        int val = i / 2;

        while (j < val) {
            head = head.next;
            j++;
        }

        return head;
    }

    /**
     * 1046
     *
     * @param stones
     * @return
     */
    public static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((i1, i2) -> i2 - i1);
        for (int i : stones) {
            pq.add(i);
        }
        while (pq.size() >= 2) {

            int x = pq.poll();
            int y = pq.poll();
            if (x > y) {
                pq.offer(x - y);
            }
        }
        return pq.size() == 1 ? pq.peek() : 0;
    }

    /**
     * 1108
     *
     * @param address
     * @return
     */
    public String defangIPaddr(String address) {
        return address.replace(".", "[.]");
    }

    /**
     * 1342
     *
     * @param num
     * @return
     */
    public static int numberOfSteps(int num) {
        int result = 0;
        while (num > 0) {
            if (num % 2 == 0) {
                num = num / 2;
            } else {
                num = num - 1;
            }

            result++;
        }

        return result;
    }

    /**
     * 1365
     *
     * @param nums
     * @return
     */
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] count = new int[101];
        int[] result = new int[nums.length];

        for (int num : nums) {
            count[num]++;
        }

        for (int i = 1; i <= 100; i++) {
            count[i] += count[i - 1];
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                result[i] = 0;
            } else {
                result[i] = count[nums[i] - 1];
            }
        }

        return result;
    }

    /**
     * April 7th，不在题库中的题，有点意思啊
     *
     * @param arr
     * @return
     */
    public int countElements(int[] arr) {
        Map<Integer, Integer> tmp = new HashMap<>();
        int result = 0;
        for (int x : arr) {
            tmp.putIfAbsent(x, 0);
            tmp.put(x, tmp.get(x) + 1);
        }

        for (int x : arr) {
            Integer k = tmp.get(x + 1);
            if (k != null && k > 0) {
                result++;
            }
        }

        return result;
    }

    /**
     * April 14th
     *
     * @param s
     * @param shift
     * @return
     */
    public static String stringShift(String s, int[][] shift) {
        int finalDirect = 0;
        int finalPath = 0;

        for (int i = 0; i < shift.length; i++) {
            int direct = shift[i][0];
            int path = shift[i][1];
            if (direct == 0) {
                finalPath += path;
            } else {
                finalPath -= path;
            }
        }

        if (finalPath < 0) {
            finalDirect = 1;
            finalPath = Math.abs(finalPath);
        }

        finalPath = finalPath % s.length();

        char[] newCharArray = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            int cover = i;
            if (finalDirect == 0) {
                cover += finalPath;
            } else {
                cover -= finalPath;
            }

            if (cover >= s.length()) {
                cover -= s.length();
            } else if (cover < 0) {
                cover += s.length();
            }

            newCharArray[i] = s.charAt(cover);
        }

        return new String(newCharArray);
    }


    public static void main(String[] args) {
        search33(new int[]{3, 1}, 3);
    }
}
