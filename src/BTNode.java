/*************************************************************************
 * This class is the blueprint of a binary node that wraps information of 
 * a generic type T, and that has 2 links to 2 potential "children" 
 * called left and right.
 * Most of the code is given to you. 
 * You are asked to complete a few TODOs as shown below. 
 * There are 3 TODOs in this file (TODO 1, TODO 2, and TODO 3).
 * You can only add code in the TODOs. You are not allowed to modify 
 * anything else in the code. 
 *************************************************************************/ 

public class BTNode<T> extends  FamilyMember{

    private T data;
    private BTNode<T> left;
    private BTNode<T> right;
    
    // Constructors ****************************************************************
    public BTNode() {}
    
    public BTNode(T d) {
        data = d;
        left = null;
        right = null;
    }
    
    // Setters *********************************************************************
    public void setData(T d) {
        data = d;   
    }
    
    public void setLeft(BTNode<T> L) {
        left = L;
    }
    
    public void setRight(BTNode<T> R) {
        right = R;
    }
    
    // Getters **********************************************************************
    public T getData() {
        return data;   
    }
    
    public BTNode<T> getLeft() {
        return left;   
    }
    
    public BTNode<T> getRight() {
        return right;   
    }
    
    // Other methods ***************************************************************
    /* printNode prints the content of the current node */
    public void printNode() {
        System.out.println(data.toString());   
    }

    /* Height computes the height of the current node */
    public int height() {
        if (this == null) return -1;
        if (right == null && left == null) return 0;
        if(right == null) return left.height();
        if(left == null) return right.height();
        return 1 + Math.max(left.height(), right.height());
    }
    
    /* TODO 1:
     * SizeBelow computes the number of nodes that are part of the subtree
     * originating at the current node (this), including this current node 
     * TODO 1. Complete the implementation of the method sizeBelow.
     * Your implementation must be RECURSIVE */
    public int sizeBelow() {
        if(right == null && left == null) return 1;
        if(left == null) {
            return 1 + right.sizeBelow();
        }
        if(right == null) {
            return 1 + left.sizeBelow();
        }
        return 1 + left.sizeBelow() + right.sizeBelow();
    }
    
    /* TODO 2:
     * hasLeft returns true if the current node (this) has a non null left child, 
     * false otherwise 
     * TODO 2. Complete the implementation of the method hasLeft.
     */
    public boolean hasLeft() {
        return this.left != null;
    }
    
    /* TODO 3:
     * hasRight returns true if the current node (this) has a non null right child, 
     * false otherwise 
     * TODO 3. Complete the implementation of the method hasLeft.
     */
    public boolean hasRight() {
        return this.right != null;
    }
}