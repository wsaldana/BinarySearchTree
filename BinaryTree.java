/**
 * @author Walter Saldaña
 * Referencias: Duane A. Bailey. (2007). Java Structures. 7ma edicion.
 * Clase de BinaryTree
 */
public class BinaryTree<E> {

    protected E val;
    protected BinaryTree<E> parent;
    protected BinaryTree<E> left, right; 

    /**
     * Constructor sin parametros
     * Crea un arbol binario con valores defecto
     */
    public BinaryTree(){
        val = null;
        parent = null; 
        left = right = this;
    }

    /**
     * Constructor de un parametro
     * Crea un Binary tree con su valor de nodo y objetos nulos de hijos
     * @param value
     */
    public BinaryTree(E value){
        val = value;
        right = left = new BinaryTree<E>();
        setLeft(left);
        setRight(right);
    }

    /**
     * Constructor con parametros
     * Crea un BinaryTree Asignando valor a todos sus atributos
     * @param value
     * @param left
     * @param right
     */
    public BinaryTree(E value, BinaryTree<E> left, BinaryTree<E> right){
        val = value;
        if (left == null) { left = new BinaryTree<E>(); }
        setLeft(left);
        if (right == null) { right = new BinaryTree<E>(); }
        setRight(right);
    }




    
    /**
     * Asigna un objeto hijo a la izquierda
     * @param newLeft
     */
    public void setLeft(BinaryTree<E> newLeft){
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
    public void setRight(BinaryTree<E> newRight){
        if (isEmpty()) return;
        if (right != null && right.getParent() == this) right.setParent(null);
        right = newRight;
        right.setParent(this);
    }

    /**
     * Asigna un objeto de asociado de mayor jerarquia
     * @param newParent
     */
    protected void setParent(BinaryTree<E> newParent){
        if (!isEmpty()){
            parent = newParent;
        }
    }
    
    /**
     * @return the left
     */
    public BinaryTree<E> getLeft() {
        return left;
    }

    /**
     * @return the right
     */
    public BinaryTree<E> getRight() {
        return right;
    }

    /**
     * @return the parent
     */
    public BinaryTree<E> getParent() {
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

}