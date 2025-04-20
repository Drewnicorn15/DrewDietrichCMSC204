package p5;

/**
 * @author Drew Dietrich 
 */
public class TreeNode<T> {
    private TreeNode<T> left,right;
    T value;
    String code;
    public TreeNode(T v,String c)
    {
        left = null;
        right = null;
        value = v;
        code = c;
    }
    public T getValue()
    {
        return value;
    }
    public String getCode()
    {
        return code;
    }
    public TreeNode<T> getLeft()
    {
        return left;
    }
    public TreeNode<T> getRight(){
        return right;
    }
    public void setRight(TreeNode<T> newNode)
    {
        right = newNode;
    }
    public void setLeft(TreeNode<T> newNode)
    {
        left = newNode;
    }

}
