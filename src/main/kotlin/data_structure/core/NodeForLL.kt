package shinythinking.data_structure.core

class NodeForLL<T>(
    val data: T?,
    var prev: NodeForLL<T>?,
    var next: NodeForLL<T>?
)