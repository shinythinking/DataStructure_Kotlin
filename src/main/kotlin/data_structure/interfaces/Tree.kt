package shinythinking.data_structure.interfaces

import shinythinking.data_structure.core.NodeForTree

interface Tree<T> {
    fun createTree(): Tree<T>
    fun root(): NodeForTree<T>
    fun addChild(parent: NodeForTree<T>, child: NodeForTree<T>)
    fun removeNode(nodeForTree: NodeForTree<T>)
    fun traverse(): String
}