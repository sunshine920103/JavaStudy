package com.cc.dataStruct.scala


/**
  * @author ：cc
  * @date ：created in 2020/6/3 17:33
  * @description ：$ {description}
  * @modified By：
  * @version: $version$
  */
class BinaryTree[T] {

  //前序遍历
  def preOrder(root: BNode[T]): String = {
    val result = new StringBuilder
    if (root != null) {
      result.append(root.data).append("->")
      result.append(preOrder(root.leftSub))
      result.append(preOrder(root.rightSub))
    }
    result.mkString
  }

  //前序遍历
  def preOrder2(root: BNode[T]): Unit = {
    if (root == null) return
    print(root.data + "=>")
    preOrder2(root.leftSub)
    preOrder2(root.rightSub)
  }

  //中序遍历
  def midOrder(root: BNode[T]): String = {
    val result = new StringBuilder
    if (root != null) {
      result.append(midOrder(root.leftSub))
      result.append(root.data).append("->")
      result.append(midOrder(root.rightSub))
    }
    result.mkString
  }

  //后序遍历
  def postOrder(root: BNode[T]): String = {
    val result = new StringBuilder
    if (root != null) {
      result.append(postOrder(root.leftSub))
      result.append(postOrder(root.rightSub))
      result.append(root.data).append("->")
    }
    result.mkString
  }

  //层次遍历
  def stepOrder(root: BNode[T]): String = {
    val queue = new CircularQueue[BNode[T]](10)
    queue.enqueue(root)
    val result = new StringBuilder
    while (queue.count > 0) {
      val n = queue.dequeue().asInstanceOf[BNode[T]]
      result.append(n.data.toString).append(">>")
      if (n.leftSub != null) {
        queue.enqueue(n.leftSub)
      }
      if (n.rightSub != null) {
        queue.enqueue(n.rightSub)
      }
    }

    result.mkString

  }

}


class BNode[T](val data: T, var leftSub: BNode[T], var rightSub: BNode[T])

object testBinaryTree {

  /*
   *         A
   *        / \
   *       B   C
   *      / \ / \
   *     D  E F  G
   *
   */

  def main(args: Array[String]): Unit = {
    val D = new BNode[String]("D", null, null)
    val E = new BNode[String]("E", null, null)
    val F = new BNode[String]("F", null, null)
    val G = new BNode[String]("G", null, null)
    val B = new BNode[String]("B", D, E)
    val C = new BNode[String]("C", F, G)
    val root = new BNode[String]("A", B, C)

    val binaryTree = new BinaryTree[String]
    print(binaryTree.preOrder(root))
    println()
    binaryTree.preOrder2(root)
    println()
    print(binaryTree.midOrder(root))
    println()
    print(binaryTree.postOrder(root))
    println()
    print(binaryTree.stepOrder(root))
  }
}

