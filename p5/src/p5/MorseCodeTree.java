package p5;

import java.util.ArrayList;

public class MorseCodeTree implements LinkedConverterTreeInterface<String>{
    TreeNode<String> mainRoot;
    public MorseCodeTree(){
        mainRoot = new TreeNode<>(" "," ");
        buildTree();
    }
	/**
	 * Returns a reference to the root
	 * @return reference to root
	 */
    @Override
	public TreeNode<String> getRoot()
    {
        return mainRoot;
    }
	
	/**
	 * sets the root of the Tree
	 * @param newNode a TreeNode<T> that will be the new root
	 */
	@Override
	public void setRoot(TreeNode<String> newNode)
    {
		mainRoot = newNode;
    }
	
	
	
	/**
	 * Adds result to the correct position in the tree based on the code
	 * This method will call the recursive method addNode
	 * 
	 * @param code the code for the new node to be added
	 * @param letter the letter to do added
	 */
	 @Override
	 public void insert(String code, String letter)
     {
		addNode(mainRoot, code, letter);
     } 
	/**
	 * This is a recursive method that adds element to the correct position 
	 * in the tree based on the code.
	 * 
	 * @param root the root of the tree for this particular recursive instance of addNode
	 * @param code the code for this particular recursive instance of addNode
	 * @param letter the data of the new TreeNode to be added
	 */
	@Override
	public void addNode(TreeNode<String> root, String code, String letter)
    {
		for(int i =0;i<code.length()-1;i++)
		{
			if(code.charAt(i)== '.')
				root = root.getLeft();
			else
				root = root.getRight();
		}
		if(code.charAt(code.length()-1)== '.'){
			root.setLeft(new TreeNode<>(letter, code));
		}else {
			root.setRight(new TreeNode<>(letter, code));
		}
    }
	/**
	 * Fetch the data in the tree based on the code
	 * This method will call the recursive method fetchNode
	 * 
	 * @param code the code that describes the traversals within the tree
	 * @return the result that corresponds to the code
	 */
	@Override
	public String fetch(String code)
    {
		return fetchNode(mainRoot,code);
    }
	
	/**
	 * This is the recursive method that fetches the data of the TreeNode
	 * that corresponds with the code
	 * 
	 * @param root the root of the tree for this particular recursive instance of addNode
	 * @param code the code for this particular recursive instance of fetchNode
	 * @return the data corresponding to the code
	 */
	@Override
	public String fetchNode(TreeNode<String> root, String code)
    {
		for(int i =0;i<code.length();i++)
		{
			if(code.charAt(i)== '.')
				root = root.getLeft();
			else
				root = root.getRight();
		}
		return root.getValue();
    }
	
	/**
	 * This operation is not supported for a LinkedConverterTree
	 * @param data data of node to be deleted
	 * @return reference to the current tree
	 * @throws UnsupportedOperationException
	 */
	@Override
	public LinkedConverterTreeInterface<String> delete(String data) throws UnsupportedOperationException
	{
		throw new UnsupportedOperationException();
	}
		
	
	
	/**
	 * This operation is not supported for a LinkedConverterTree
	 * @return reference to the current tree
	 * @throws UnsupportedOperationException
	 */
	@Override
	public LinkedConverterTreeInterface<String> update() throws UnsupportedOperationException
    {
		throw new UnsupportedOperationException();
    }
		

	/**
	 * This method builds the LinkedConverterTree by inserting TreeNodes<T>
	 * into their proper locations
	 * 
	 */
	@Override
	public void buildTree()
    {
		insert(".","e");
		insert("-","t");
		insert(".-","a");
		insert("..","i");
		insert("-.","n");
		insert("--","m");
		insert("...","s");
		insert("..-","u");
		insert(".-.","r");
		insert("-..","d");
		insert(".--","w");
		insert("-.-","k");
		insert("--.","g");
		insert("---","o");
		insert("....","h");
		insert("...-","v");
		insert("..-.","f");
		insert(".-..","l");
		insert("-...","b");
		insert("-..-","x");
		insert(".---","j");
		insert("-.--","y");
		insert("--.-","q");
		insert("-.-.","c");
		insert("--..","z");
		insert(".--.","p");
    }
	


	/**
	 * Returns an ArrayList of the items in the linked converter Tree in LNR (Inorder) Traversal order
	 * Used for testing to make sure tree is built correctly
	 * @return an ArrayList of the items in the linked Tree
	 */
	@Override
	public ArrayList<String> toArrayList()
    {
		ArrayList<String> out = new ArrayList<>();
		LNRoutputTraversal(mainRoot, out);
		return out;
    }
	
	
	/**
	 * The recursive method to put the contents of the linked converter tree in an ArrayList<T> 
	 * LNR (Inorder)
	 * @param root the root of the tree for this particular recursive instance
	 * @param list the ArrayList that will hold the contents of the tree in LNR order
	 */
	@Override
	public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list)
    {
		if(root != null){
		LNRoutputTraversal(root.getLeft(),list);
		list.add(root.getValue());
		LNRoutputTraversal(root.getRight(),list);
		}
    }
	

	
	
}
