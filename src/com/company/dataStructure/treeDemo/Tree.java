package com.company.dataStructure.treeDemo;

public interface Tree {
    /**
     * 返回当前节点中存放的对象
     *
     * @return Object
     */
    Object getElem();

    /**
     * 将对象obj存入当前节点，并返回此前的内容
     *
     * @return Object
     */
    Object setElem(Object obj);
    /**
     * 返回当前节点的父节点
     *
     * @return TreeLinkedList
     */
    TreeLinkedList getParent();
    /**
     * 返回当前节点的长子
     *
     * @return TreeLinkedList
     */
    TreeLinkedList getFirstChild();
    /**
     * 返回当前节点的最大弟弟
     *
     * @return TreeLinkedList
     */
    TreeLinkedList getNextSibling();
    /**
     * 返回当前节点后代元素的数目，即以当前节点为根的子树的规模
     *
     * @return int
     */
    int getSize();
    /**
     * 返回当前节点的高度
     *
     * @return int
     */
    int getHeight();
    /**
     * 返回当前节点的深度
     *
     * @return int
     */
    int getDepth();
}
