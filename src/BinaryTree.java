
public class BinaryTree {

	public Node root;
	
	public BinaryTree() {
		this.root = null;
	}
	
	
	// add a new Node
	public void add(String key, int val) {
		
		Node newone = new Node(key, val);
		Node parent = null;
		
		if(root == null) {
			
			root = newone;
			
		}
		
		Node current = root;
		
		while(true) {
			
			parent = current;
			
			if(val > parent.value) {
				
				current = current.right;
				if(current == null) {
					parent.right = newone;
					return;
				}
				
			}
			
			else {
				
				current = current.left;
				if(current == null) {
					parent.left = newone;
					return;
				}
				
			}
		}
		
	}
	
	
	// find both the node and its parent
	public Node[] find(int val) {
		
		Node current = root;
		Node parent = null;
		Node curAndpar[] = new Node[2];	// store current and parent at the same time
		
		while(current !=null) {
			
			parent = current;
			curAndpar[0] = current;
			curAndpar[1] = parent;
			if(val == current.value)
				return curAndpar;
			else if(val>current.value) 
				current = current.right;
			else
				current = current.left;
			
		}
		
		System.out.println("Can't find the node");
		return null;
	}
	
	
	public void update(Node current, Node n) {
		
		Node curAndpar[] = new Node[2];
		curAndpar = find(n.value);
		current = curAndpar[0];
		current.value = n.value;
		current.key = n.key;
		
	}
	
	
	//  find the other node in the tree which will replace the deleted note
		public void subs(Node n) {
			
			Node current = n.right;
			Node parent = null;
			while(current.left != null) {
				
				parent = current;
				current = current.left;
				
			}
			
			if(current.right != null) {		// if the substitude note only has right side
											// link the right side with the parent node's left side
											// then replace the delete node with it
				
				parent.left = current.right;
				update(n, current);
				
			}
			
			else {							// if the substitude note has no children
											// just replace the delete node with it
				
				update(n,current);
				parent.left = null;
				
			}
			
		}
	
	
	// delete node n
	public void delete(Node n) {
		
		Node parent = null;
		Node current = null;
		Node curAndpar[] = new Node[2];
		curAndpar = find(n.value);
		current = curAndpar[0];
		parent = curAndpar[1];
		
		
		// if the node has two children
		if(current.left != null && current.right != null) {
	
				subs(current);		
			
		}
		
		// if the node has only one child
		else if(current.left != null) {	   // if the only child is on the left side of the node
			
			if(current == root)
				root = null;
			
			else if(current == parent.left){
				
				parent.left = current.left;
				current = null;
				
			}
			
			else {
				
				parent.right = current.left;
				current = null;
			}
			
			
		}
		
		
		else if(current.right != null){		// if the only child is on the right side of the node
			
			if(current == root)
				current = null;
			else if(current == parent.left) {
				
				parent.left = current.right;
				current = null;
			}
			
			else {
				
				parent.right = current.right;
				current = null;
				
			}
		}
		
		
		
		// if current has no child
		else {
			
			current = null;
		}
	}
	
	
}
