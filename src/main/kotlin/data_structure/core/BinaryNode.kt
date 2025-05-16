package shinythinking.data_structure.core

/*
노드에 대한 설명
자신의 부모에 대한 정보를 가짐 -> null이면 Root 노드
자식들은 여럿을 가질 수 있음.
특별한 메서드를 가질 필요가 없기 때문에 data class로 선언
 */
data class BinaryNode<T>(
    val value: T,
    var parent: BinaryNode<T>? = null,
    var left: BinaryNode<T>? = null,
    var right: BinaryNode<T>? = null,
    val depth: Int? = null,
    val color: ColorForNode = ColorForNode.NONE
) {
    override fun toString(): String {
        return "Node(value=$value, left=$left, right=$right, depth=$depth, color=$color)"
    }
}

enum class ColorForNode {
    NONE, RED, BLACK
}