package data.factory

import data.structure.Heap

object DataStructureFactory {
  def getHeap(array: Array[Int]): Heap = {
    new Heap
  }
}
