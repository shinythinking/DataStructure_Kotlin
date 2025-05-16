package shinythinking.data_structure.interfaces

import data_structure.interfaces.DataStructure

interface Tree<T : Comparable<T>> : DataStructure<T> {
    fun insert(value: T): Boolean
    fun search(value: T): Boolean
    fun delete(value: T): Boolean
}