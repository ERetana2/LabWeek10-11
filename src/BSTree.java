/*************************************************************************
 * This class is the blueprint of a binary search node that extends the 
 * type binary tree (BTree)
 * There is 1 BONUS activity in this file.
 *************************************************************************/

public class BSTree<T extends Comparable<T>> extends BTree<T> {

    // A Binary Search Tree has no additional attributes compared to a Binary Tree

    // Constructors ****************************************************************
    public BSTree() {
        super();
    }

    public BSTree(BTNode<T> N) {
        super(N);
    }

    // Other method ***************************************************************
    /* BONUS:
     * Method insert:
     * Takes data to be added to the binary search tree
     * Insert a node that contains this data at the correct position in the BST
     */
    public void insert(T data) {
        /*
        BTNode<T> newData = new BTNode<>(data);
        if (getRoot() == null) {
            setRoot(newData);
        }
        BTNode<T> temp = getRoot();
        while(newData.getSiblings() > temp.getSiblings()){ // go right if siblings is greater than root
            if(temp.hasRight()){
                temp = temp.getRight();
                if(newData.getSiblings() > temp.getSiblings()){
                    temp.setRight(newData);
                }else{
                }
            }

        }

         */

    }
}