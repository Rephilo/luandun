package com.rephilo.luandun.leetcode

import scala.annotation.tailrec

/**
  * LeetCode常规题
  */
object LeetCode {

  class ListNode(var _x: Int = 0) {
    var next: ListNode = null
    var x: Int = _x
  }

  abstract class BinaryMatrix {
    def get(x: Int, y: Int): Int

    def dimensions(): Array[Int]
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
    * 053
    *
    * @param nums
    * @return
    */
  def maxSubArray(nums: Array[Int]): Int = {
    @tailrec
    def calcMax(nums: Array[Int], i: Int, max: Int): Int = {
      i match {
        case _ if i == nums.length => max
        case _ =>
          if (nums(i - 1) > 0) {
            nums(i) += nums(i - 1)
          }

          calcMax(nums, i + 1, math.max(nums(i), max))
      }
    }

    calcMax(nums, 1, nums(0))
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
    * 201
    *
    * @param m
    * @param n
    * @return
    */
  def rangeBitwiseAnd(m: Int, n: Int): Int = {
    @tailrec
    def calc(m: Int, n: Int, step: Int): Int = {
      if (m == n) {
        n << step
      } else {
        calc(m >> 1, n >> 1, step + 1)
      }
    }

    calc(m, n, 0)
  }

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
    * 283
    *
    * @param nums
    */
  def moveZeroes(nums: Array[Int]): Unit = {

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

  /**
    * April 21st
    *
    * @param binaryMatrix
    * @return
    */
  def leftMostColumnWithOne(binaryMatrix: BinaryMatrix): Int = {
    if (binaryMatrix == null || binaryMatrix.dimensions().isEmpty) {
      return -1
    }

    val row = binaryMatrix.dimensions()(0)
    val col = binaryMatrix.dimensions()(1)

    @tailrec
    def findLeftMost(currRow: Int, currCol: Int, result: Int, binaryMatrix: BinaryMatrix): Int = {
      if (currCol < 0 || currRow >= row || result == 0) {
        return result
      }

      if (binaryMatrix.get(currRow, currCol) == 0) {
        findLeftMost(currRow + 1, currCol, result, binaryMatrix)
      } else {
        findLeftMost(currRow, currCol - 1, currCol, binaryMatrix)
      }
    }

    findLeftMost(0, col - 1, -1, binaryMatrix)
  }
}
