package com.rephilo.luandun.leetcode._1108

object Solution {
  /**
    * 1108
    *
    * @param address
    * @return
    */
  def defangIPaddr(address: String): String = {
    address.replace(".", "[.]")
  }
}
