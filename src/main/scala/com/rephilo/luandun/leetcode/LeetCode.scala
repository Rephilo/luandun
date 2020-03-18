package com.rephilo.luandun.leetcode

import scala.annotation.tailrec

/**
  * LeetCode常规题
  */
object LeetCode {

  /**
    * 009
    *
    * @param x
    * @return
    */
  def isPalindrome(x: Int): Boolean = {
    if (x < 0) {
      return false
    }
    var origin = x
    var reverse = 0

    while (origin != 0) {
      reverse = reverse * 10 + origin % 10
      origin = origin / 10
    }

    x == reverse
  }

  /**
    * 074
    *
    * @param nums
    * @param target
    * @return
    */
  def binarySearch(nums: Array[Int], target: Int): Int = {
    @tailrec
    def binarySearchRec(start: Int, end: Int): Int = {
      val mid = (start + end) / 2
      if (start > end) {
        return -1
      }
      if (nums(mid) == target) {
        mid
      } else if (nums(mid) < target) {
        binarySearchRec(mid + 1, end)
      } else {
        binarySearchRec(start, mid - 1)
      }
    }

    binarySearchRec(0, nums.length - 1)
  }

  /**
    * 1108
    *
    * @param address
    * @return
    */
  def defangIPaddr(address: String): String = {
    address.replace(".", "[.]")
  }

  /**
    * 1342
    *
    * @param num
    * @return
    */
  def numberOfSteps(num: Int): Int = {
    @tailrec
    def steps(num: Int, count: Int): Int = {
      num match {
        case 0 => count
        case _ if num % 2 != 0 => steps(num - 1, count + 1)
        case _ if num % 2 == 0 => steps(num / 2, count + 1)
      }
    }

    steps(num, 0)
  }

  /**
    * 1365
    *
    * @param nums
    * @return
    */
  def smallerNumbersThanCurrent(nums: Array[Int]): Array[Int] = {
    null
  }

}
