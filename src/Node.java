
public class Node {
	
	protected int value;
	protected String key;
	protected Node left;
	protected Node right;
	
	public Node(String key, int value) {
		
		this.key = key;
		this.value = value;
		left = null;
		right = null;
		
	}

}
