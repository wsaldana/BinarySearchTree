/**
 * @author Walter Saldaña #19897
 * Referencias: Duane A. Bailey. (2007). Java Structures. 7ma edicion.
 * Clase que implementa los metodos de un Binary Search Tree
 */

public class BinarySearchTree<E extends Comparable<E>> implements OrderedStructure<E>{

    private E val;
    private BinarySearchTree<E> parent;
    private BinarySearchTree<E> left, right; 

    /**
     * Constructor sin parametros
     */
    public BinarySearchTree(){
        val = null;
        parent = null; 
        left = right = null;
    }

    /**
     * Constructor que inicializa un BST
     * @param val
     */
    public BinarySearchTree(E value){
        val = value;
        right = left = new BinarySearchTree<E>();
        setLeft(left);
        setRight(right);
    }

    /**
     * Elimina todos los elementos del BST
     */
    public void clear(){}

    /**
     * @return numero de elementos en el BST
     */
    public int size(){
        return 0;
    }

    /**
     * Agrega elementos de manera ordenada al BST
     * @param value
     */
    public void add(E newValue, BinarySearchTree<E> tree){  
        int comp = tree.getValue().compareTo(newValue);
        if(comp>0 && tree.getLeft()==null){
            tree.setLeft(new BinarySearchTree<E>());
            tree.getLeft().setValue(newValue);
        }else if(tree.getLeft()!=null){
            add(newValue, tree.getLeft());
        }if(comp<0 && tree.getRight()==null){
            tree.setRight(new BinarySearchTree<E>());
            tree.getRight().setValue(newValue);
        }else if(tree.getRight()!=null){
            add(newValue, tree.getRight());
        }
    }

    /**
     * @param value
     * @return true si value se encuentra en el BST
     */
    public boolean contains(BinarySearchTree<E> node, E value){
        if (node.getValue() == value) {
            return true;
        }
        boolean contains = false;
        if (node.getLeft() != null) {
            contains = contains(node.getLeft(), value);
        }
        if (!contains && node.getRight() != null) {
            contains = contains(node.getRight(), value);
        }
    
        return contains;
    }

    /**
     * @param value valor a buscar dentro del BST
     * @return valor del BST
     */
    public E get(E value, BinarySearchTree<E> node){
        if(node != null) {
            inOrder(node.getLeft());
               if(node.getValue().compareTo(value)==0){
                   return node.getValue();
               }
            inOrder(node.getRight());
        }
        return null;
    }

    /**
     * @param value valor que se quiere eliminar
     * @return el valor que recien se elimino
     */
    public E remove(E value){
        return value;
    }

        /**
     * Asigna un objeto hijo a la izquierda
     * @param newLeft
     */
    public void setLeft(BinarySearchTree<E> newLeft){
        if (isEmpty()) return;
        if (left != null && left.getParent() == this) left.setParent(null);
        left = newLeft;
        left.setParent(this);
    }

    public boolean isEmpty() {
        return this.getValue() == null;
    }

    /**
     * Asigna un objeto hijo a la derecha
     * 
     * @param newRight
     */
    public void setRight(BinarySearchTree<E> newRight){
        if (isEmpty()) return;
        if (right != null && right.getParent() == this) right.setParent(null);
        right = newRight;
        right.setParent(this);
    }

    /**
     * Asigna un objeto de asociado de mayor jerarquia
     * @param newParent
     */
    protected void setParent(BinarySearchTree<E> newParent){
        if (!isEmpty()){
            parent = newParent;
        }
    }
    
    /**
     * @return the left
     */
    public BinarySearchTree<E> getLeft() {
        return left;
    }

    /**
     * @return the right
     */
    public BinarySearchTree<E> getRight() {
        return right;
    }

    /**
     * @return the parent
     */
    public BinarySearchTree<E> getParent() {
        return parent;
    }

    /**
     * 
     * @return
     */
    public E getValue(){
        return val;
    }

    /**
     * 
     * @param value
     */
    public void setValue(E value){
        val = value;
    }

    public void inOrder(BinarySearchTree<E> node) {
        if(node != null) {
            inOrder(node.getLeft());
            System.out.println(node.getValue().toString() + " ");   
            inOrder(node.getRight());
        }
    }
    
}