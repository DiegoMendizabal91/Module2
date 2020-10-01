


public class BinarySearchTree<E extends Comparable<E>> {
	class Node {
		E value;
		Node leftChild = null;
		Node rightChild = null;
		Node(E value) {
			this.value = value;
		}
		@Override
		public boolean equals(Object obj) {
			if ((obj instanceof BinarySearchTree.Node) == false)
				return false;
			@SuppressWarnings("unchecked")
			Node other = (BinarySearchTree<E>.Node)obj;
			return other.value.compareTo(value) == 0 &&
					other.leftChild == leftChild && other.rightChild == rightChild;
		}
	}
	
	protected Node root = null;
	protected Node originNode = null;

	protected void visit(Node n) {
		System.out.println(n.value);
	}
	
	public boolean contains(E val) {
		return contains(root, val);
	}
	
	protected boolean contains(Node n, E val) {
		if (n == null) return false;
		
		if (n.value.equals(val)) {
			return true;
		} else if (n.value.compareTo(val) > 0) {
			return contains(n.leftChild, val);
		} else {
			return contains(n.rightChild, val);
		}
	}
	
	public boolean add(E val) {
		if (root == null) {
			root = new Node(val);
			return true;
		}
		return add(root, val);
	}
	
	protected boolean add(Node n, E val) {
		if (n == null) {
			return false;
		}
		int cmp = val.compareTo(n.value);
		if (cmp == 0) {
			return false; // this ensures that the same value does not appear more than once
		} else if (cmp < 0) {
			if (n.leftChild == null) {
				n.leftChild = new Node(val);
				return true;
			} else {
				return add(n.leftChild, val);
			} 	
		} else {
			if (n.rightChild == null) {
				n.rightChild = new Node(val);
				return true;
			} else {
				return add(n.rightChild, val);
			} 	
		}
	}	
	
	public boolean remove(E val) {
		return remove(root, null, val);
	}
	
	protected boolean remove(Node n, Node parent, E val) {
		if (n == null) return false;

		if (val.compareTo(n.value) == -1) {
				return remove(n.leftChild, n, val);
		} else if (val.compareTo(n.value) == 1) {
				return remove(n.rightChild, n, val);
		} else {
			if (n.leftChild != null && n.rightChild != null){
				n.value = maxValue(n.leftChild);
				remove(n.leftChild, n, n.value);
			} else if (parent == null) {
				root = n.leftChild != null ? n.leftChild : n.rightChild;
			} else if (parent.leftChild == n){
				parent.leftChild = n.leftChild != null ? n.leftChild : n.rightChild;
			} else {
				parent.rightChild = n.leftChild != null ? n.leftChild : n.rightChild;
			}
			return true;
		}
	}

	protected E maxValue(Node n) {
		if (n.rightChild == null) {
			return n.value;
	    } else {
	       return maxValue(n.rightChild);
	    }
	}

	protected void saveRoot() {
		Node originRoot = root;
	}
	
	/*********************************************
	 * 
	 * IMPLEMENT THE METHODS BELOW!
	 *
	 *********************************************/
	
	
	// Method #1.
	public Node findNode(E val) {
		if (val == null){
			return null;
		}
		Node nodeVal;
		Node originNode1 ;
		int cmp = val.compareTo(root.value);
		if (cmp == 0) {
			return root;
		} else if (cmp < 0) {
			if (root.leftChild != null) {
				originNode1 = root;
				root = root.leftChild;
				nodeVal = findNode(val);
				root = originNode1;
				return nodeVal;
			} else {
				return null;
			}
		} else if (cmp > 0){
			if (root.rightChild != null) {
				originNode1 = root;
				root = root.rightChild;
				nodeVal = findNode(val);
				root = originNode1;
				return nodeVal;
			} else {
				return null;
			}

		}


		return null; // this line is here only so this code will compile if you don't modify it

	}
	
	// Method #2.
	protected int depth(E val) {
		if (val == null){
			return -1;
		}
		Node originNode1 ;
		int actual;
		int cont = 0;
		int cmp = val.compareTo(root.value);
		if (cmp == 0) {
			return 0;
		} else if (cmp < 0) {
			if (root.leftChild != null) {
				originNode1 = root;
				root = root.leftChild;
				cont++;
				actual = depth(val);
				root = originNode1;
				if (actual == -1) {
					return -1;
				}
				return actual + cont;
			} else {
				return -1;
			}
		} else if (cmp > 0){
			if (root.rightChild != null) {
				cont++;
				originNode1 = root;
				root = root.rightChild;
				actual = depth(val);
				root = originNode1;
				if (actual == -1) {
					return -1;
				}
				return actual + cont;
			} else {
				return -1;
			}

		}
		
		return -2; // this line is here only so this code will compile if you don't modify it

	}
	
	// Method #3.
	protected int height(E val) {
		int cont = 0;
		int actual = 0;
		int actual1 = 0;
		int verifNull = 0;

		Node node = findNode(val);
		if (node == null){
			return -1;
		}

		if (node.rightChild != null && node.leftChild != null) {
			cont++;
			verifNull = height(node.rightChild.value);
			if (verifNull == -1){
				return -1;
			}
			actual =  verifNull + cont;

			verifNull = height(node.leftChild.value);
			if (verifNull == -1){
				return -1;
			}

			actual1 = verifNull + cont;

			if (actual > actual1){
				return actual;
			} else {
				return actual1;
			}
		}

		if(node.rightChild != null) {
			cont++;
			verifNull = height(node.rightChild.value);
			if (verifNull == -1){
				return -1;
			}
			actual = verifNull + cont;
		} else if (node.leftChild != null) {
			cont++;
			verifNull = height(node.leftChild.value);
			if (verifNull == -1){
				return -1;
			}
			actual = verifNull + cont;
		}


		return actual; // this line is here only so this code will compile if you don't modify it
	}


	// Method #4.
	protected boolean isBalanced(Node n) {
		int heightRight;
		int heightLeft;

		if (n == null) {
			return false;
		}

		try {
			heightRight = height(n.rightChild.value);

		} catch (NullPointerException e) {
			heightRight = -1;
        }

		try {
			heightLeft = height(n.leftChild.value);

		} catch (NullPointerException e) {
			heightLeft = -1;
		}


		if (heightRight - heightLeft == 0 || heightRight - heightLeft == 1 || heightLeft - heightRight == 0 || heightLeft - heightRight == 1) {
			return true;
		}
		
		return false; // this line is here only so this code will compile if you don't modify it

	}
	
	// Method #5. .
	public boolean isBalanced() {
		boolean balanced = true;
		Node startNode = root;
		if (!((isBalanced(startNode)))){
			root = startNode;
			return false;
		} else {
			if (startNode.rightChild != null) {
				root = startNode.rightChild;
				balanced = isBalanced();
			}
			if (startNode.leftChild != null) {
				root = startNode.leftChild;
				balanced = isBalanced();
			}
		}
		if ((startNode.leftChild == null) && (startNode.rightChild == null)) {
			return true;
		} else {
			return balanced;
		}
	}

}
