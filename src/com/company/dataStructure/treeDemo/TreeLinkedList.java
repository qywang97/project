package com.company.dataStructure.treeDemo;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class TreeLinkedList implements Tree{
    /**
     * 树根节点
     */
    private Object element;

    /**
     * 父节点、长子及最大的弟弟
     */
    private TreeLinkedList parent, firstChild, nextSibling;

    /**
     * （单节点树）构造方法
     */
    public TreeLinkedList() {
        this(null, null, null, null);
    }

    /**
     * 构造方法
     *
     * @param object      树根节点
     * @param parent      父节点
     * @param firstChild  长子
     * @param nextSibling 最大的弟弟
     */
    public TreeLinkedList(Object object, TreeLinkedList parent, TreeLinkedList firstChild, TreeLinkedList nextSibling) {
        this.element = object;
        this.parent = parent;
        this.firstChild = firstChild;
        this.nextSibling = nextSibling;
    }

    @Override
    public Object getElem() {
        return element;
    }

    @Override
    public Object setElem(Object obj) {
        Object bak = element;
        element = obj;
        return bak;
    }

    @Override
    public TreeLinkedList getParent() {
        return parent;
    }

    @Override
    public TreeLinkedList getFirstChild() {
        return firstChild;
    }

    @Override
    public TreeLinkedList getNextSibling() {
        return nextSibling;
    }

    @Override
    public int getSize() {
        //当前节点也是自己的后代
        int size = 1;
        //从长子开始
        TreeLinkedList subtree = firstChild;
        //依次
        while (null != subtree) {
            //累加
            size += subtree.getSize();
            //所有孩子的后代数目
            subtree = subtree.getNextSibling();
        }
        //得到当前节点的后代总数
        return size;
    }

    @Override
    public int getHeight() {
        int height = -1;
        //从长子开始
        TreeLinkedList subtree = firstChild;
        while (null != subtree) {
            //在所有孩子中取最大高度
            height = Math.max(height, subtree.getHeight());
            subtree = subtree.getNextSibling();
        }
        //即可得到当前节点的高度
        return height + 1;
    }

    @Override
    public int getDepth() {
        int depth = 0;
        //从父亲开始
        TreeLinkedList p = parent;
        while (null != p) {
            depth++;
            //访问各个真祖先
            p = p.getParent();
        }
        //真祖先的数目，即为当前节点的深度
        return depth;
    }

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchMethodException {
        Object root0 = new String("1");
        Object root1 = new String("2");
        Object root2 = new String("3");
        Class clazz = TreeLinkedList.class;
        Constructor constructor =clazz.getDeclaredConstructor(Object.class,TreeLinkedList.class,TreeLinkedList.class,TreeLinkedList.class);
        TreeLinkedList root = (TreeLinkedList) constructor.newInstance(root0,null,null,null);
        TreeLinkedList left = (TreeLinkedList) constructor.newInstance(root1,root,null,null);
        TreeLinkedList right = (TreeLinkedList) constructor.newInstance(root2,root,null,null);
        root.firstChild = left;
        root.nextSibling = right;

        System.out.println(root.getElem());
        System.out.println(root.getFirstChild());
        System.out.println(root.getDepth());
        System.out.println(root.getNextSibling());
        System.out.println(root.getHeight());
        System.out.println(left.getParent());
    }
}
