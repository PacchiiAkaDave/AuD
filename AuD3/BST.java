//Implementation zur Höhe des Baums und zum Einfügen von Knoten:
//https://www.youtube.com/watch?v=gq9LqlaeZXs
//https://www.youtube.com/watch?v=-bdEjEs0d_k


public class BST {
	private BSTnode root;
	
	
	
	public BST() {
		this.root = null;
	}
	

	//Einfügung eines Knotens und Platzierung nach BST-Bedingung
	public void insert(int k, String s) {
		if(root == null) {
			this.root = new BSTnode(k ,s);
		} else {
			insert(root,k,s);
		}
	}
	
	private void insert(BSTnode parent, int k, String s) {
		if(parent.key > k) {
			if(parent.left == null) {
				parent.left = new BSTnode(k,s);
				parent.left.parent = parent;
			} else {
				insert(parent.left , k ,s);
			}
		} else {
			if(parent.right == null) {
				parent.right = new BSTnode(k,s);
				parent.right.parent = parent;
			} else {
				insert(parent.right,k,s);
			}
		}
		
	}

	//Binäre Suche nach Knoten
	public String search(int k) {
		if(root == null) {
			return "nicht gefunden";
		}
		if(root.key > k) {
			return search(root.left,k);
		}
		if(root.key < k) {
			 return search(root.right,k);
		}
		return root.val;
	}
	
	
	private String search(BSTnode node, int k) {
		if(node == null) {
			return "nicht gefunden";
		}
		if(node.key > k) {
			return search(node.left,k);
		}
		if(node.key < k) {
			return search(node.right,k);
		}
		return node.val;
	}

	//Höhe des BST berechnen
	public int height() {
		int l = 0;
		int r = 0;
		if(root.left != null) {
			l = height(root.left) + 1;
		}
		if(root.right != null) {
			r = height(root.right) + 1;
		}
		if(l < r) {
			return r;
		} else {
			return l;
		}
	}
	
	
	private int height(BSTnode parent) {
		int l = 0;
		int r = 0;
		if(parent.left != null) {
			l = height(parent.left) + 1;
		}
		if(parent.right != null) {
			r = height(parent.right) + 1;
		}
		if(l < r) {
			return r;
		} else {
			return l;
		}
	}
	
	//Quelle zur ValidatorMethode: 
	//https://www.programcreek.com/2012/12/leetcode-validate-binary-search-tree-java/
	//Validieren
	public boolean isValidBST() {
		return isValidBST(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
	}

	

	private boolean isValidBST(BSTnode node, int min, int max) {
		if(node==null) {
			return true;
		}
		
		if(node.key < min || node.key > max) {
			return false;
		}
		return isValidBST(node.left,min,node.key) && isValidBST(node.right,node.key,max);
	}
	
	//zerstört die Ordnung des BST
	private void swap(BSTnode a,BSTnode b) {
		int tmp = a.key;
		a.key = b.key;
		b.key = tmp;
	}
	
	public void manipulate() {
		swap(root.left,root.right);
	}

	
	//Inorder zur Ausgabe des Baumes (Element kleinstes bis größtes)
	public void inorder() {
		inorder(root);
	}

	
	private void inorder(BSTnode root) {
		if(root != null) {
			inorder(root.left);
			System.out.print(root.key + " ");
			inorder(root.right);
		}
//		System.out.println();
	}

	//Quelle (Boolean Methode hier als Void): 
	//http://www.newthinktank.com/2013/03/binary-trees-in-java-2/
	//Entfernt Knoten und lässt durch neue Referenzen die BST Bedingung am leben
	public void remove(int k) {
		BSTnode node = root;
		BSTnode parent = null;
		
		while(node.key != k && node != null) {
			parent = node;
			
			if(k < node.key) {
				node = node.left;
			} else {
				node = node.right;
			}
			if(node == null) {
				System.out.println("nicht gefunden");
			}
		}
		
		if(node.left == null && node.right == null) {
			if(node == root) {
				root = null;
			} else if(parent.key > node.key) {
				parent.left = null;
			
			} else {
				parent.right = null;
				
			}
		}
		else if(node.right == null) {
			if(node == root) {
				root = node.left;
			} else if(parent.key > node.key) {
				parent.left = node.left;
				node.left.parent = node.parent;
			} else {
				parent.right = node.left;
				node.left.parent = node.parent;
			}
		} 
		else if(node.left == null) {
			if(node == root) {
				root = node.right;
			} else if(parent.key > node.key) {
				parent.left = node.right;
				node.right.parent = node.parent;
			} else {
				parent.right = node.right;
				node.right.parent = node.parent;
			}
			
		}
		
		else {
			BSTnode replacement = getReplacementNode(node);
			
			if(node == root) {
				root = replacement;
			}
			else if(parent.key > node.key) {
				parent.left = replacement;
				
			}
			else {
				parent.right = replacement;
				
			}
			replacement.right = node.right;
			
		}
	}



	private BSTnode getReplacementNode(BSTnode node) {
		BSTnode replacementParent = node;
		BSTnode replacement = node;
		
		BSTnode focNode = node.left;
		
		while(focNode != null) {
			replacementParent = replacement;
			replacement = focNode;
			focNode = focNode.right;
		}
		
		if(replacement != node.left) {
			
			replacementParent.right = replacement.left;
			replacement.left = node.left;
		}
		
		return replacement;
	}
	
	
	

		
	

}
