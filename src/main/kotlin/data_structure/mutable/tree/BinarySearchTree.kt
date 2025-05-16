package shinythinking.data_structure.mutable.tree

import shinythinking.data_structure.core.BinaryNode
import shinythinking.data_structure.interfaces.Tree

class BinarySearchTree<T : Comparable<T>> : Tree<T> {
    private var root: BinaryNode<T>? = null
    private var size = 0

    override fun insert(value: T): Boolean {
        if (root == null) {
            root = BinaryNode(value)
            return true
        }
        val foundNode = bstSearchOrParent(value) ?: return false

        if (foundNode.value != value) {
            if (foundNode.value < value) {
                foundNode.right = BinaryNode(value)
            } else {
                foundNode.left = BinaryNode(value)
            }
            return true
        } else {
            return false
        }
    }

    override fun search(value: T): Boolean {
        return value == (bstSearchOrParent(value)?.value ?: false)
    }

    override fun delete(value: T): Boolean {
        val targetNode = bstSearchOrParent(value)
        if (targetNode == null) return false
        else if (targetNode.value != value) {
            return false
        }

        if (targetNode.right == null && targetNode.left == null) {
            if (targetNode.parent == null) {
                root = null
            } else if (targetNode.parent!!.right == targetNode) {
                targetNode.parent!!.right = null
            } else {
                targetNode.parent!!.left = null
            }
        } else if (targetNode.left != null && targetNode.right != null) {
            var leftMost = targetNode.left
            while (leftMost?.right != null) {
                leftMost = leftMost.right
            }

            change(leftMost!!, targetNode)
        } else if (targetNode.right != null) {
            change(targetNode.right!!, targetNode)
        } else {
            change(targetNode.left!!, targetNode)
        }
        return true
    }

    override fun isEmpty(): Boolean {
        return root == null
    }

    override fun size(): Int {
        return size
    }

    /*
    핵심 함수 : value 값과 같은 노드를 찾는다. 없으면 부모를 반환한다.
    이유 : 이 함수 하나를 호출하여 search와 insert, delete를 해결하기 위함.
    만약 같은 값이 없다면 부모의 값과 비교하여 오른쪽 혹은 왼쪽에 배치한다.
     */
    private fun bstSearchOrParent(value: T): BinaryNode<T>? {
        if (root == null) return null

        var parent: BinaryNode<T>? = null
        var current = root

        while (current != null) {
            if (current.value < value) {
                parent = current
                current = current.right
            } else if (current.value > value) {
                parent = current
                current = current.left
            } else {
                return current
            }
        }
        return parent
    }

    private fun change(from: BinaryNode<T>, to: BinaryNode<T>) {
        if (to.parent != null) {
            if (to.parent!!.value > from.value) {
                to.parent!!.left = from
            } else {
                to.parent!!.right = from
            }
        } else {
            from.parent = null
        }
        if (to.left != null) {
            to.left!!.parent = from
        }
        if (to.right != null) {
            to.right!!.parent = from
        }

        from.left = to.left
        from.right = to.right

        to.parent = null
        to.right = null
        to.left = null
    }

    fun getRoot() = root
}