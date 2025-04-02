package shinythinking.data_structure.core

import shinythinking.data_structure.interfaces.core.LinkedList

class DoublyLinkedList<T> : LinkedList<T> {
    private val dummy = NodeForLL<T>(null, null, null)
    private var head = dummy
    private var tail = dummy
    private var size = 0

    override fun addFirst(data: T) {
        val newNode = NodeForLL<T>(data, head, head.next)
        head.next?.prev = newNode
        head.next = newNode
        if (size == 0) tail = newNode
        size++
    }

    override fun addLast(data: T) {
        val newNode = NodeForLL<T>(data, tail, null)
        tail.next = newNode
        tail = newNode
        size++
    }

    override fun removeFirst(): T {
        val firstNode = head.next ?: throw IndexOutOfBoundsException("List is empty")
        head.next = firstNode.next
        firstNode.next?.prev = head
        if (size == 1) tail = head
        size--

        return firstNode.data ?: throw IndexOutOfBoundsException("List is empty")
    }

    override fun removeLast(): T {
        val lastNode = tail
        tail = tail.prev ?: throw IndexOutOfBoundsException("List is empty")
        tail.next = null
        if (size == 1) tail = head
        size--

        return lastNode.data ?: throw IndexOutOfBoundsException("List is empty")
    }

    override fun peekFirst(): T {
        return head.next?.data ?: throw IndexOutOfBoundsException("List is empty")
    }

    override fun peekLast(): T {
        return tail.data ?: throw IndexOutOfBoundsException("List is empty")
    }

    override fun getSize(): Int = size
}