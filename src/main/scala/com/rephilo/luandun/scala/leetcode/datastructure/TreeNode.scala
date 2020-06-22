package com.rephilo.luandun.scala.leetcode.datastructure

/**
  * 树节点
  *
  * @param _value 当前节点值
  * @param _left  左子树
  * @param _right 右子树
  */
class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
  var value: Int = _value
  var left: TreeNode = _left
  var right: TreeNode = _right
}
