package com.rephilo.luandun.service.leetcode._383;

public class Solution {
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
}
