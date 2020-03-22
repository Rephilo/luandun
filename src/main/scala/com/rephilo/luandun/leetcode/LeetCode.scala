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

    @tailrec
    def loop(x: Int, reverse: Int): Int = {
      x match {
        case 0 => reverse
        case _ if x != 0 => loop(x / 10, reverse * 10 + x % 10)
      }
    }

    x == loop(x, 0)
  }

  /**
   * 013
   *
   * @param s
   * @return
   */
  def romanToInt(s: String): Int = {
    def getNum(currStr: Char): Int = {
      currStr match {
        case 'M' => 1000
        case 'D' => 500
        case 'C' => 100
        case 'L' => 50
        case 'X' => 10
        case 'V' => 5
        case 'I' => 1
        case _ => 0
      }
    }

    var result = 0
    for (i <- 0 until s.length - 1) {
      val currNum = getNum(s.charAt(i))
      val nextNum = getNum(s.charAt(i + 1))
      if (currNum < nextNum) result -= currNum
      else result += currNum
    }

    result += getNum(s.charAt(s.length - 1))
    result
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
