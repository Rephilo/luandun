package com.rephilo.luandun.leetcode._013

object Solution {
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
}
