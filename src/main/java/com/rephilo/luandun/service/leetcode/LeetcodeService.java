package com.rephilo.luandun.service.leetcode;

import com.google.common.collect.Lists;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

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

    public static class BinaryMatrix {
        private int[][] matrix;

        public int get(int x, int y) {
            return matrix[x][y];
        }

        public List<Integer> dimensions() {
            List<Integer> result = Lists.newArrayList();
            result.add(matrix[0].length);
            result.add(matrix.length);
            return result;
        }

        BinaryMatrix(int[][] param) {
            this.matrix = param;
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
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
     * 055
     *
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i <= max) {
                max = Math.max(max, i + nums[i]);
                if (max >= nums.length - 1) {
                    return true;
                }
            }
        }

        return false;
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
     * 124
     *
     * @param root
     * @return
     */
    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        getMaxPathSum(root);
        return max;
    }

    public int getMaxPathSum(TreeNode currNode) {
        if (currNode == null) {
            return 0;
        }

        int tmp = currNode.val;
        int left = Math.max(getMaxPathSum(currNode.left), 0);
        int right = Math.max(getMaxPathSum(currNode.right), 0);

        max = Math.max(max, tmp + left + right);

        return currNode.val + Math.max(left, right);
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
     * 146
     */
    static class LRUCache {
        private Map<Integer, Integer> cacheMap;
        private final int capacity;
        private ListNode head;
        private ListNode tail;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.cacheMap = new LinkedHashMap<>(capacity);
        }

        public int get(int key) {
            if (!cacheMap.containsKey(key)) {
                return -1;
            }

            Integer val = cacheMap.remove(key);
            cacheMap.put(key, val);
            return val;
        }

        public void put(int key, int value) {
            if (cacheMap.containsKey(key)) {
                cacheMap.remove(key);
                cacheMap.put(key, value);
                return;
            }
            cacheMap.put(key, value);
            //超出capacity，删除最久没用的,利用迭代器，删除第一个
            if (cacheMap.size() > capacity) {
                cacheMap.remove(cacheMap.entrySet().iterator().next().getKey());
            }
        }
    }

    /**
     * 169
     * 摩尔投票法
     * （拉出来中路solo，剩下的一定是大于n/2的数）
     *
     * @param nums
     * @return
     */
    public static int majorityElement(int[] nums) {
//        int size = nums.length;
//        int max = -1;
//        Map<Integer, Integer> countMap = new HashMap<>();
//        Arrays.stream(nums).forEach(x -> {
//            countMap.putIfAbsent(x, 0);
//            countMap.put(x, countMap.get(x) + 1);
//        });
//
//        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
//            if (entry.getValue() >= size / 2) {
//                if (countMap.get(max) == null) {
//                    max = entry.getKey();
//                } else {
//                    if (countMap.get(max) < entry.getValue()) {
//                        max = entry.getKey();
//                    }
//                }
//
//            }
//        }
//
//        return max;
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int major = nums[0];
        int count = 0;
        for (int num : nums) {
            if (count == 0) {
                major = num;
                count = 1;
            } else {
                if (num == major) {
                    count += 1;
                } else {
                    count -= 1;
                }
            }
        }

        return major;
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
     * 201
     * 010111 + 1 = 011000，则010111 & 011000 = 010000。那么，x & (x+1) 后几位相反数的“与操作”，结果总为0。
     * 所以，当(m,m+1,...n-1,n)进行连续“与操作”时，会按照上述规律被抵消很大一部分，而只剩下n的前缀部分，最后只需将n归位。举个例子：
     * <p>
     * m = 5(0101), n = 7 (0111)。不停右移，得到n前缀部分为01，最后归位前缀得res=0100=4
     *
     * @param m
     * @param n
     * @return
     */
    public int rangeBitwiseAnd(int m, int n) {
        int step = 0;
        while (m != n) {
            m = m >> 1;
            n = n >> 1;
            step++;
        }

        return n << step;
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
     * 208
     * 别问，学
     * https://leetcode-cn.com/problems/implement-trie-prefix-tree/solution/shi-xian-trie-qian-zhui-shu-by-leetcode/
     */
    public class Trie {
        private boolean is_string = false;
        private Trie next[] = new Trie[26];

        public Trie() {
        }

        public void insert(String word) {//插入单词
            Trie root = this;
            char w[] = word.toCharArray();
            for (int i = 0; i < w.length; ++i) {
                if (root.next[w[i] - 'a'] == null) root.next[w[i] - 'a'] = new Trie();
                root = root.next[w[i] - 'a'];
            }
            root.is_string = true;
        }

        public boolean search(String word) {//查找单词
            Trie root = this;
            char w[] = word.toCharArray();
            for (int i = 0; i < w.length; ++i) {
                if (root.next[w[i] - 'a'] == null) return false;
                root = root.next[w[i] - 'a'];
            }
            return root.is_string;
        }

        public boolean startsWith(String prefix) {//查找前缀
            Trie root = this;
            char p[] = prefix.toCharArray();
            for (int i = 0; i < p.length; ++i) {
                if (root.next[p[i] - 'a'] == null) return false;
                root = root.next[p[i] - 'a'];
            }
            return true;
        }
    }

    /**
     * 230
     *
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest(TreeNode root, int k) {
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();

        while (true) {
            while (root != null) {
                stack.add(root);
                root = root.left;
            }
            root = stack.removeLast();
            if (--k == 0) return root.val;
            root = root.right;
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
     * 278
     *
     * @param n
     * @return
     */
    public int firstBadVersion(int n) {
        int left = 0;
        int right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean isBadVersion(int n) {
        return false;
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
     * 328
     *
     * @param head
     * @return
     */
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode oddTail = head;
        ListNode evenHead = head.next;
        ListNode evenTail = evenHead;

        while (evenTail != null && evenTail.next != null) {
            oddTail.next = evenTail.next;
            oddTail = oddTail.next;
            evenTail.next = oddTail.next;
            evenTail = evenTail.next;
        }

        oddTail.next = evenHead;

        return head;
    }

    /**
     * 367
     * 牛顿迭代法
     * 看不懂看不懂，等后面总结一波
     *
     * @param num
     * @return
     */
    public boolean isPerfectSquare(int num) {
        if (num < 2) {
            return true;
        }

        long x = num / 2;
        while (x * x > num) {
            x = (x + num / x) / 2;
        }
        return (x * x == num);
    }

    /**
     * 383
     *
     * @param ransomNote
     * @param magazine
     * @return
     */
    public boolean canConstruct(String ransomNote, String magazine) {
//        Map<Character, Integer> mag = new HashMap<>();
//        boolean flag = true;
//        for (char m : magazine.toCharArray()) {
//            mag.putIfAbsent(m, 0);
//            mag.put(m, mag.get(m) + 1);
//        }
//
//        for (char r : ransomNote.toCharArray()) {
//            if (mag.get(r) == null || mag.get(r) == 0) {
//                flag = false;
//                break;
//            } else {
//                mag.put(r, mag.get(r) - 1);
//            }
//        }
//
//        return flag;
        if (magazine.length() < ransomNote.length()) {
            return false;
        }
        int[] caps = new int[26];
        for (char c : ransomNote.toCharArray()) {
            int index = magazine.indexOf(c, caps[c - 'a']);
            if (index == -1) {
                return false;
            }
            caps[c - 97] = index + 1;
        }
        return true;
    }

    /**
     * 387
     *
     * @param s
     * @return
     */
    public static int firstUniqChar(String s) {
//        int[] arr = new int[26];
//        int result = -1;
//        char[] array = s.toCharArray();
//        for (char c : array) {
//            arr[c - 97] += 1;
//        }
//
//        for (int i = 0; i < array.length; i++) {
//            if (arr[array[i] - 97] == 1) {
//                result = result + i + 1;
//                break;
//            }
//        }
//
//        return result;
        int result = Integer.MAX_VALUE;

        for (char c = 'a'; c <= 'z'; c++) {
            int index = s.indexOf(c);

            if (index != -1 &&
                    index == s.lastIndexOf(c)) {
                result = Math.min(result, index);
            }
        }

        return result == Integer.MAX_VALUE ? -1 : result;
    }

    /**
     * 402
     *
     * @param num
     * @param k
     * @return
     */
    public String removeKdigits(String num, int k) {
        LinkedList<Character> stack = new LinkedList<Character>();

        for (char digit : num.toCharArray()) {
            while (stack.size() > 0 && k > 0 && stack.peekLast() > digit) {
                stack.removeLast();
                k -= 1;
            }
            stack.addLast(digit);
        }

        /* remove the remaining digits from the tail. */
        for (int i = 0; i < k; ++i) {
            stack.removeLast();
        }

        // build the final string, while removing the leading zeros.
        StringBuilder ret = new StringBuilder();
        boolean leadingZero = true;
        for (char digit : stack) {
            if (leadingZero && digit == '0') {
                continue;
            }
            leadingZero = false;
            ret.append(digit);
        }

        /* return the final string  */
        if (ret.length() == 0) {
            return "0";
        }
        return ret.toString();
    }

    /**
     * 438
     * 滑动窗口，别问，学
     *
     * @param s
     * @param p
     * @return
     */
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0)
            return list;

        int[] hash = new int[256];
        for (char c : p.toCharArray()) {
            hash[c]++;
        }
        int left = 0;
        int right = 0;
        int count = p.length();

        while (right < s.length()) {

            if (hash[s.charAt(right)] > 0) {
                count--;
            }
            hash[s.charAt(right)]--;
            right++;

            if (count == 0) {
                list.add(left);
            }

            if (right - left == p.length()) {
                if (hash[s.charAt(left)] >= 0) {
                    count++;
                }
                hash[s.charAt(left)]++;
                left++;
            }
        }
        return list;
    }


    /**
     * 476
     * 位运算确实是弱项，需要再学习
     *
     * @param num
     * @return
     */
    public int findComplement(int num) {
        int temp = num, c = 0;
        while (temp > 0) {
            //根据判断条件
            //二进制右移并赋值给temp，
            temp >>= 1;
            //二进制左移之后结果+1 赋值给c
            c = (c << 1) + 1;
        }
        return num ^ c;
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
     * 540
     *
     * @param nums
     * @return
     */
    public int singleNonDuplicate(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (mid % 2 == 1) {
                mid--;
            }
            if (nums[mid] == nums[mid + 1]) {
                lo = mid + 2;
            } else {
                hi = mid;
            }
        }
        return nums[lo];
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
     * 451
     * 超时了。。
     *
     * @param s
     * @return
     */
    public static String frequencySort(String s) {
        return null;
    }

    /**
     * 560
     *
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        int count = 0, sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int num : nums) {
            sum += num;
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    /**
     * 567
     *
     * @param s1
     * @param s2
     * @return
     */
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;
        int[] s1map = new int[26];
        int[] s2map = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1map[s1.charAt(i) - 'a']++;
            s2map[s2.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s2.length() - s1.length(); i++) {
            if (matches(s1map, s2map))
                return true;
            s2map[s2.charAt(i + s1.length()) - 'a']++;
            s2map[s2.charAt(i) - 'a']--;
        }
        return matches(s1map, s2map);
    }

    public boolean matches(int[] s1map, int[] s2map) {
        for (int i = 0; i < 26; i++) {
            if (s1map[i] != s2map[i])
                return false;
        }
        return true;
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
     * 771
     *
     * @param J
     * @param S
     * @return
     */
    public int numJewelsInStones(String J, String S) {
        int result = 0;
        HashSet<Character> set = new HashSet<>();
        for (char j : J.toCharArray()) {
            set.add(j);
        }

        for (char s : S.toCharArray()) {
            if (set.contains(s)) {
                result++;
            }
        }

        return result;
    }

    /**
     * 733
     *
     * @param image
     * @param sr
     * @param sc
     * @param newColor
     * @return
     */
    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] != newColor) {
            doFloodFill(image, sr, sc, newColor, image[sr][sc]);
        }
        return image;
    }

    public static void doFloodFill(int[][] image, int i, int j, int newColor, int currColor) {
        if (i >= image.length || i < 0) {
            return;
        }

        if (j >= image[0].length || j < 0) {
            return;
        }

        if (image[i][j] == currColor) {
            image[i][j] = newColor;
            doFloodFill(image, i + 1, j, newColor, currColor);
            doFloodFill(image, i - 1, j, newColor, currColor);
            doFloodFill(image, i, j + 1, newColor, currColor);
            doFloodFill(image, i, j - 1, newColor, currColor);
        }
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
     * 901
     */
    class StockSpanner {
        Stack<Integer> prices, weights;

        public StockSpanner() {
            prices = new Stack();
            weights = new Stack();
        }

        public int next(int price) {
            int w = 1;
            while (!prices.isEmpty() && prices.peek() <= price) {
                prices.pop();
                w += weights.pop();
            }

            prices.push(price);
            weights.push(w);
            return w;
        }
    }

    /**
     * 987
     *
     * @param A
     * @param B
     * @return
     */
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> ans = new ArrayList();
        int i = 0, j = 0;

        while (i < A.length && j < B.length) {
            int lo = Math.max(A[i][0], B[j][0]);
            int hi = Math.min(A[i][1], B[j][1]);
            if (lo <= hi) {
                ans.add(new int[]{lo, hi});
            }
            if (A[i][1] < B[j][1]) {
                i++;
            } else {
                j++;
            }
        }

        return ans.toArray(new int[ans.size()][]);
    }

    /**
     * 993
     * 用两个hashMap存，好秀啊。。
     *
     * @param root
     * @param x
     * @param y
     * @return
     */
    private Map<Integer, Integer> depthMap;
    private Map<Integer, TreeNode> parentMap;

    public boolean isCousins(TreeNode root, int x, int y) {
        depthMap = new HashMap<>();
        parentMap = new HashMap<>();
        dfsIsCousins(root, null);
        return depthMap.get(x).equals(depthMap.get(y))
                && !parentMap.get(x).equals(parentMap.get(y));
    }

    private void dfsIsCousins(TreeNode curr, TreeNode parent) {
        if (curr == null) {
            return;
        }
        depthMap.put(curr.val, parent != null ? 1 + depthMap.get(parent.val) : 0);
        parentMap.put(curr.val, parent);
        dfsIsCousins(curr.left, curr);
        dfsIsCousins(curr.right, curr);
    }

    /**
     * 997
     *
     * @param N
     * @param trust
     * @return
     */
    public static int findJudge(int N, int[][] trust) {
        if (trust == null || trust.length == 0) {
            return N;
        }
        if (trust.length == 1) {
            return trust[0][1];
        }
        int[] deped = new int[N + 1];
        int[] dep = new int[N + 1];

        for (int[] arr : trust) {
            deped[arr[1]]++;
            dep[arr[0]]++;
        }

        for (int i = 0; i <= N; i++) {
            if (deped[i] == N - 1 && dep[i] == 0) {
                return i;
            }
        }

        return -1;
    }

    /**
     * 918
     *
     * @param A
     * @return
     */
    public int maxSubarraySumCircular(int[] A) {
        return 0;
    }

    /**
     * 1008
     *
     * @param preorder
     * @return
     */
    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }

        return buildBstFromPreorder(preorder, 0, preorder.length - 1);
    }

    /**
     * 根据前序遍历的顺序构造二叉搜索树
     *
     * @param preorder
     * @return
     */
    private TreeNode buildBstFromPreorder(int[] preorder, int start, int end) {
        if (start > end) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[start]);
        int i;
        for (i = start; i <= end; i++) {
            if (preorder[i] > node.val) {
                break;
            }
        }

        node.left = buildBstFromPreorder(preorder, start + 1, i - 1);
        node.right = buildBstFromPreorder(preorder, i, end);

        return node;
    }

    /**
     * 1035
     * 又是动态规划
     *
     * @param A
     * @param B
     * @return
     */
    public int maxUncrossedLines(int[] A, int[] B) {
        int n1 = A.length;
        int n2 = B.length;
        int[][] dp = new int[n1 + 1][n2 + 1];
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                if (A[i] == B[j]) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }
        return dp[n1][n2];
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
     * 1143
     *
     * @param text1
     * @param text2
     * @return
     */
    public static int longestCommonSubsequence(String text1, String text2) {
        char[] chars1 = text1.toCharArray();
        char[] chars2 = text2.toCharArray();
        int[][] dp = new int[chars1.length + 1][chars2.length + 1];

        for (int i = 1; i <= chars1.length; i++) {
            for (int j = 1; j <= chars2.length; j++) {
                if (chars1[i - 1] == chars2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[chars1.length][chars2.length];
    }

    /**
     * 1232
     * 将求斜率转为求乘积
     * y2-y0/x2-x0 = y1-y0/x1-x0
     *
     * @param coordinates
     * @return
     */
    public boolean checkStraightLine(int[][] coordinates) {
        if (coordinates == null || coordinates.length < 2) {
            return false;
        }

        if (coordinates.length == 2) {
            return true;
        }

        int x0 = coordinates[0][0];
        int y0 = coordinates[0][1];
        for (int i = 2; i < coordinates.length; i++) {
            int x1 = coordinates[i - 1][0];
            int y1 = coordinates[i - 1][1];
            int x2 = coordinates[i][0];
            int y2 = coordinates[i][1];

            int product1 = (y2 - y0) * (x1 - x0);
            int product2 = (y1 - y0) * (x2 - x0);
            if (product1 != product2) {
                return false;
            }
        }

        return true;
    }

    /**
     * 1277
     *
     * @param matrix
     * @return
     */
    public int countSquares(int[][] matrix) {
        int result = 0;
        int[][] dp = new int[matrix.length][matrix[0].length]; // 直接用matrix初始化就是对的值

        for (int m = 0; m < matrix.length; m++) {
            for (int n = 0; n < matrix[0].length; n++) {
                if (matrix[m][n] == 1) {
                    if (m > 0 && n > 0) {//这里多加个判断，false其实就是相当于之前的那两个循环
                        dp[m][n] = Math.min(Math.min(dp[m - 1][n], dp[m][n - 1]), dp[m - 1][n - 1]) + 1;
                    }
                    result += dp[m][n];
                }
            }
        }
        return result;
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
     * 2020 April 14th
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

    /**
     * 2020 April 21st
     * 从矩阵的右上角设置指针，如果是1则想左移动，如果是0则向下移动，记录最左侧的数据
     *
     * @param binaryMatrix
     * @return
     */
    public static int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        if (binaryMatrix == null || binaryMatrix.dimensions().isEmpty()) {
            return -1;
        }
        List<Integer> dimensions = binaryMatrix.dimensions();
        int row = dimensions.get(0);
        int col = dimensions.get(1);
        int currRow = 0;
        int currCol = col - 1;
        int result = -1;

        while (currCol >= 0 && currRow < row) {
            if (result == 0) {
                break;
            }
            if (binaryMatrix.get(currRow, currCol) == 0) {
                currRow++;
            } else {
                result = currCol;
                currCol--;
            }
        }

        return result;
    }

    /**
     * 2020 April 28th
     */
    static class FirstUnique {

        private LinkedHashMap<Integer, Integer> uniqueMap;
        private Set<Integer> duplicate;

        public FirstUnique(int[] nums) {
            uniqueMap = new LinkedHashMap<>();
            duplicate = new HashSet<>();

            for (int num : nums) {
                handle(num);
            }
        }

        private void handle(int num) {
            //已重复的直接过滤
            if (duplicate.contains(num)) {
                return;
            }
            //不在唯一表中，则直接加入唯一表
            if (!uniqueMap.containsKey(num)) {
                uniqueMap.put(num, num);
            } else {
                //在唯一表中，则从唯一表中删除，放入重复表
                uniqueMap.remove(num);
                duplicate.add(num);
            }
        }

        public int showFirstUnique() {
            if (uniqueMap.isEmpty()) {
                return -1;
            } else {
                return uniqueMap.entrySet().iterator().next().getKey();
            }
        }

        public void add(int value) {
            handle(value);
        }
    }

    /**
     * 2020 April 30th
     *
     * @param root
     * @param arr
     * @return
     */
    public static boolean isValidSequence(TreeNode root, int[] arr) {
        return isValidSequenceDfs(root, arr, 0);
    }

    private static boolean isValidSequenceDfs(TreeNode curr, int[] arr, int i) {
        //i超过数组长度则说明不匹配，直接返回false
        if (i >= arr.length) {
            return false;
        }
        //走到null节点
        if (curr == null) {
            return false;
        }
        //当前节点字符和正在校验的字符不一致则直接返回false
        if (curr.val != arr[i]) {
            return false;
        }
        //当前节点如果是最后一位，则需要是叶子节点
        if (i == arr.length - 1) {
            return curr.left == null && curr.right == null;
        }

        boolean left = isValidSequenceDfs(curr.left, arr, i + 1);
        boolean right = isValidSequenceDfs(curr.right, arr, i + 1);

        return left || right;
    }

    public static void main(String[] args) {
        frequencySort("eert");
    }

}
