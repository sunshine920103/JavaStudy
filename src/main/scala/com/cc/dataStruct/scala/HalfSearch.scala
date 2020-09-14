package com.cc.dataStruct.scala

/**
  * @author ：cc
  * @date ：created in 2020/6/2 11:39
  * @description ：$ {description}
  * @modified By：
  * @version: $version$
  */
class HalfSearch(array: Array[Int], value: Int) {

  //无重复元素下查找给定值
  def search(): Int = {
    var start = 0
    var end = array.length - 1
    while (start <= end) {
      val mid = start + (end - start) / 2
      if (array(mid) == value) {
        return mid
      }
      if (array(mid) < value) {
        start = mid + 1
      } else {
        end = mid - 1
      }
    }
    -1
  }

  //无重复元素下查找给定值--递归实现
  def searchRecursive(start: Int, end: Int): Int = {
    if (start > end) return -1
    val mid = start + (end - start) / 2
    if (array(mid) == value) {
      return mid
    }
    if (array(mid) < value) {
      searchRecursive(mid + 1, end)
    } else {
      searchRecursive(start, mid - 1)
    }

  }


  //有重复元素下查找第一个给定值位置
  def searchFirst(): Int = {
    var start = 0
    var end = array.length - 1
    while (start <= end) {
      val mid = start + (end - start) / 2
      if (array(mid) > value) {
        end = mid - 1
      } else if (array(mid) < value) {
        start = mid + 1
      } else {
        if (mid == 0 || array(mid - 1) != value) return mid
        end = mid - 1
      }
    }
    -1
  }

  //有重复元素下查找最后一个给定值位置
  def searchLast(): Int = {
    var start = 0
    var end = array.length - 1
    while (start <= end) {
      val mid = start + (end - start) / 2
      if (array(mid) > value) {
        end = mid - 1
      } else if (array(mid) < value) {
        start = mid + 1
      } else {
        if (mid == array.length - 1 || array(mid + 1) != value) return mid
        start = mid + 1
      }
    }
    -1
  }


  //有重复元素下查找第一个大于等于给定值的元素位置
  def searchLargeEqual(): Int = {
    var start = 0
    var end = array.length - 1
    while (start <= end) {
      val mid = start + (end - start) / 2
      if (array(mid) >= value) {
        if (mid == 0 || array(mid - 1) < value) return mid
        end = mid - 1
      } else {
        start = mid + 1
      }
    }
    -1
  }

  //有重复元素下查找最后一个小于等于给定值的元素位置
  def searchSmallEqual(): Int = {
    var start = 0
    var end = array.length - 1
    while (start <= end) {
      val mid = start + (end - start) / 2
      if (array(mid) <= value) {
        if (mid == array.length - 1 || array(mid + 1) > value) return mid
        start = mid + 1
      } else {
        end = mid - 1
      }
    }
    -1
  }


}
