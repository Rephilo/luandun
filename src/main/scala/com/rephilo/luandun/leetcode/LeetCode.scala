package com.rephilo.luandun.leetcode

import scala.annotation.tailrec
import scala.runtime.Nothing$

/**
  * LeetCode常规题
  */
object LeetCode {

  class ListNode(var _x: Int = 0) {
    var next: ListNode = null
    var x: Int = _x
  }

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
    * 014
    *
    * @param strs
    * @return
    */
  def longestCommonPrefix(strs: Array[String]): String = {
    if (strs.isEmpty) {
      return ""
    }

    @tailrec
    def getPrefix(currStr: String, prefix: String): String = {
      if (prefix.isEmpty) {
        ""
      } else if (currStr.startsWith(prefix)) {
        prefix
      } else {
        getPrefix(currStr, prefix.substring(0, prefix.length - 1))
      }
    }

    strs.foldLeft(strs.head)((prefix, currStr) => getPrefix(currStr, prefix))
  }

  /**
    * 020
    *
    * @param s
    * @return
    */
  def isValid(s: String): Boolean = {
    false
  }

  def mergeTwoLists(l1: ListNode, l2: ListNode): ListNode = {
    null
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
    * 122
    * sliding函数（选取的元素数，步长）
    *
    * @param prices
    * @return
    */
  def maxProfit(prices: Array[Int]): Int = {
    if (prices.length < 2) 0 else prices.sliding(2, 1).map(x => x(1) - x(0)).filter(_ > 0).sum
  }

  /**
    * 136
    * 天秀解法，异或
    *
    * @param nums
    * @return
    */
  def singleNumber(nums: Array[Int]): Int = nums.reduce(_ ^ _)

  /**
    * 202
    * 弗洛伊德循环查找算法
    * 生成一个链表，快指针走两格，慢指针走一格，如果汇合说明是循环，如果快指针先到1则是快乐数
    *
    * @param n
    * @return
    */
  def isHappy(n: Int): Boolean = {
    @tailrec
    def squareSum(n: Int, sum: Int): Int = {
      n match {
        case 0 => sum
        case _ => squareSum(n / 10, sum + (n % 10) * (n % 10))
      }
    }

    @tailrec
    def floydCycleFinding(slow: Int, fast: Int): Boolean = {
      fast match {
        case 1 => true
        case _ if fast == slow => false
        case _ => floydCycleFinding(squareSum(slow, 0), squareSum(squareSum(fast, 0), 0))
      }
    }

    floydCycleFinding(n, squareSum(n, 0))
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
