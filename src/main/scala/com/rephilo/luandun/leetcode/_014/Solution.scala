package com.rephilo.luandun.leetcode._014

import scala.annotation.tailrec

object Solution {
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
}
