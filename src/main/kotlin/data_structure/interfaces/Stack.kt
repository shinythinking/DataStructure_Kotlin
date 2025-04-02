package data_structure.interfaces

/*
Immutable 자료형을 고려하여 Stack 자체를 반환하도록 설정
 */
interface Stack<T> : DataStructure<T> {
    fun push(data: T): Stack<T>
    fun pop(): Pair<T?, Stack<T>>
    fun peek(): T?
}