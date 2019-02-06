package data.sort

object QuickSort {
  /**
    * 快速排序
    *
    * @param list 待排序列表
    * @tparam A 列表元素类型
    * @return
    */
  def quickSort[A](list: List[A])(implicit a: A => Ordered[A]): List[A] = list match {
    case Nil => List()
    case head :: tail =>
      val (left, right) = tail.partition(_ < head)
      quickSort(left) ::: head :: quickSort(right)
  }
}
