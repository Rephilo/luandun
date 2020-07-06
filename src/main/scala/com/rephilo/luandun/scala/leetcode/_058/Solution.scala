package com.rephilo.luandun.scala.leetcode._058

import scala.annotation.tailrec

/**
  * 058
  *
  * @author rephilo
  */
object Solution {

  /**
    * split
    *
    * @param s
    * @return
    */
  def lengthOfLastWord1(s: String): Int = {
    val array = s.split(" ")
    if (array.nonEmpty) {
      return array(array.length - 1).length
    }

    0
  }

  /**
    * 循环 case 这里写的不好，挺乱的
    *
    * @param s
    * @return
    */
  def lengthOfLastWord2(s: String): Int = {
    @tailrec
    def calc(s: String, index: Int, result: Int): Int = {
      if (index < 0) {
        return result
      }
      val currChar = s.charAt(index)
      currChar match {
        case ' ' =>
          if (result > 0) {
            return result
          }
          calc(s, index - 1, result)
        case _ => calc(s, index - 1, result + 1)
      }
    }

    calc(s, s.length - 1, 0)
  }
}
