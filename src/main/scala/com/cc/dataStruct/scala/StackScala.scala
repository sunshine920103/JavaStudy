package com.cc.dataStruct.scala

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

/**
  * @author ：cc
  * @date ：created in 2020/5/14 09:41
  * @description ：$ {description}
  * @modified By：
  * @version: $version$
  */
class StackScala[T] {

  val listBuffer: ListBuffer[T] = ListBuffer.empty
  var count = 0

  def push(value: T): Unit = {
    listBuffer += value
    count += 1
  }

  def pop(): Unit = {
    listBuffer.remove(count - 1)
    count -= 1
  }

  def clear(): Unit = {
    listBuffer.clear()
  }

  def printAll: Unit = {
    println(listBuffer.toList.toString())
  }

}

object testStackScala {
  def main(args: Array[String]): Unit = {
    val s = new StackScala[Int]
    s.push(1)
    s.push(2)
    s.printAll
    s.pop()
    s.push(3)
    s.printAll
  }
}
