package data_structure.interfaces

/*
Immutable 자료형을 고려하여 Queue자체를 반환하도록 설정
 */
interface Queue<T> : DataStructure<T> {
    fun enqueue(data: T): Queue<T>
    fun dequeue(): Pair<T?, Queue<T>>
    fun peek(): T?
}