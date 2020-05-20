package com.cc.dataStruct.scala

import scala.reflect.ClassTag

/**
  * @author ：cc
  * @date ：created in 2020/5/15 11:18
  * @description ：$ {description}
  * @modified By：
  * @version: $version$
  */
class CircularQueue[T: ClassTag](capacity: Int) {
  val array = new Array[T](capacity)
  var tail = 0
  var head = 0

  def enqueue(value: T): String = {
    //判断队满
    if ((tail + 1) % capacity == head) return "队列已满"
    array(tail) = value
    tail = (tail + 1) % capacity
    "success"
  }

  def dequeue(): Any = {
    //判空
    if (tail == head) return null
    val res = array(head)
    head = (head + 1) % capacity
    res
  }

  def printAll() = {
    for (i <- array)
      print(i+"  ")
    println()
  }


}

object testCircularQueue {
  def main(args: Array[String]): Unit = {
    val c = new CircularQueue[Int](3)
    println(c.enqueue(1))
    println(c.enqueue(2))
    println(c.enqueue(3))
    c.printAll()
    println(c.enqueue(4))
    println("消费："+ c.dequeue())
    println(c.enqueue(4))
    c.printAll()
    println("消费："+c.dequeue())
    c.printAll()
    println(c.enqueue(3))
    c.printAll()
    println(c.enqueue(5))
    println("消费："+c.dequeue())
  }
}
