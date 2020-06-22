package com.rephilo.luandun.scala.leetcode._169

object Solution {
  /**
    * 169
    * 排序法
    * 排序之后，多余一半的数字一定在中间
    *
    * @param nums
    * @return
    */
  def majorityElement(nums: Array[Int]): Int = {
    val sortedNums = nums.sorted
    sortedNums(nums.length / 2)
  }
}
