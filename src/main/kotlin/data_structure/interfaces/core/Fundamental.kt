package shinythinking.data_structure.interfaces.core

interface Fundamental<T> {
    fun addFirst(data: T)
    fun addLast(data: T)
    fun removeFirst(): T
    fun removeLast(): T
    fun peekFirst(): T?
    fun peekLast(): T?
    fun getSize(): Int
}