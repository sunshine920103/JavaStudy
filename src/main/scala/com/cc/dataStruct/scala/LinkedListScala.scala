package com.cc.dataStruct.scala


/**
  * @author ：cc
  * @date ：created in 2020/5/9 11:16
  * @description ：$ {description}
  * @modified By：
  * @version: $version$
  */
class LinkedListScala(headNode: Option[Node]) {
  def this() = this(Some(new Node(0, None, None)))


  def find(value: Int): Option[Node] = {
    var tmp = headNode.get.next
    while (tmp.isDefined && tmp.get.data != value) {
      tmp = tmp.get.next
    }
    tmp
  }

  def insertTohead(value: Int) = {
    val node = new Node(value, headNode, if (headNode.isEmpty) None else headNode.get.next)
    if (node.next.isDefined)
      node.next.get.pre = Some(node)

    headNode.get.next = Some(node)
  }

  def insertAfter(exitNode: Node, value: Int) = {
    val node = new Node(value, Some(exitNode), exitNode.next)
    if (node.next.isDefined)
      node.next.get.pre = Some(node)

    exitNode.next = Some(node)

  }

  def inverseLink() = {
    var tmp = headNode.get.next
    var last: Option[Node] = None
    while (tmp.isDefined) {
      val swap = tmp.get.pre
      tmp.get.pre = tmp.get.next
      tmp.get.next = swap

      if (tmp.get.pre.isEmpty)
        last = tmp
      tmp = tmp.get.pre
    }
    headNode.get.next.get.next = None
    headNode.get.next = last
    last.get.pre = headNode
  }

  def delete(value: Int): String = {
    val node = find(value)
    if (node.isEmpty)
      return "cont find data"
    node.get.pre.get.next = node.get.next
    if (node.get.next.isDefined) {
      node.get.next.get.pre = node.get.pre
    }
    node.get.pre = None
    node.get.next = None
    return "delete success"
  }

  def isPalindrome(): Boolean = {
    var nodeLow = headNode.get.next
    var nodeFast = headNode.get.next
    var lastNode: Option[Node] = None
    while (nodeFast.isDefined && nodeFast.get.next.isDefined) {
      if (nodeFast.get.next.get.next.isEmpty)
        lastNode = nodeFast.get.next
      nodeFast = nodeFast.get.next.get.next
      nodeLow = nodeLow.get.next
    }
    if (lastNode.isEmpty) lastNode = nodeFast

    var start = headNode.get.next
    while (start != nodeLow) {
      if (!start.get.data.equals(lastNode.get.data)) {
        return false
      }
      start = start.get.next
      lastNode = lastNode.get.pre
    }
    start.get.data.equals(lastNode.get.data)
  }


  def printAll() = {
    var stringBuilder = new StringBuilder
    var tmp = headNode.get.next

    while (tmp.isDefined) {
      stringBuilder.append(tmp.get.data)
      tmp = tmp.get.next
    }
    println(stringBuilder.toString())
  }


}

class Node(val data: Int, var pre: Option[Node], var next: Option[Node])

object test {
  def main(args: Array[String]): Unit = {

    val linkedListScala = new LinkedListScala()
    linkedListScala.insertTohead(2)
    linkedListScala.insertTohead(4)
    linkedListScala.insertTohead(5)
    linkedListScala.insertTohead(5)
    linkedListScala.insertAfter(linkedListScala.find(2).get, 3)
    linkedListScala.insertTohead(4)
    linkedListScala.insertTohead(2)
    linkedListScala.insertTohead(3)
    linkedListScala.printAll()
    linkedListScala.inverseLink()
    linkedListScala.printAll()
    print(linkedListScala.isPalindrome())
  }
}