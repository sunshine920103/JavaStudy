package com.cc.dataStruct.scala

import com.sun.glass.ui.View.Capability

/**
  * @author ：cc
  * @date ：created in 2020/5/9 11:16
  * @description ：$ {description}
  * @modified By：
  * @version: $version$
  */
class LinkedListScala(headNode: Option[Node]) {
  def this() = this(new Node(None, None))

  def insertTohead(value: Option[Int]) = {
    val node = new Node(value, if (headNode.isEmpty) None else headNode.get.next)
    headNode.get.next = Some(node)
  }


}

class Node(val data: Option[Int], var next: Option[Node])

object test {
  def main(args: Array[String]): Unit = {
    val linkedListScala = new LinkedListScala()
    linkedListScala.insertTohead(2)
  }
}