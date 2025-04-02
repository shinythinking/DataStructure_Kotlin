package shinythinking.data_structure.interfaces.core

interface DynamicArray<T> : Fundamental<T> {
    fun grow()
    fun requireGrow(): Boolean
}