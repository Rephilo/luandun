package com.rephilo.luandun.scala.leetcode.explore.arrays._1295

object Solution {
  /**
    * scala好秀啊。。
    *
    * @param nums
    * @return
    */
  def findNumbers(nums: Array[Int]): Int = {
    nums.count(num => num.toString.length % 2 == 0)
  }
}
