package shinythinking.data_structure.mutable.stack

import data_structure.interfaces.Stack
import shinythinking.data_structure.core.DoublyLinkedList

class LinkedStack<T> : Stack<T> {
    private val list = DoublyLinkedList<T>()

    override fun push(data: T): Stack<T> {
        list.addLast(data)
        return this
    }

    override fun pop(): Pair<T?, Stack<T>> {
        return list.removeLast() to this
    }

    override fun peek() = list.peekLast()

    override fun isEmpty(): Boolean = list.getSize() == 0

    override fun size() = list.getSize()
}