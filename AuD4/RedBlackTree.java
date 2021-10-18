
public class RedBlackTree {
	private RBTNode nil = new RBTNode(-1, "nil");
	private RBTNode root;
	
	public RedBlackTree() {
		this.root = nil;
		this.root.parent = nil;
	}
	
	public void insert(int k, String s) {
		RBTNode z = new RBTNode(k,s);
		RBTNode y = nil;
		RBTNode x = root;
		while(x != nil) {
			y = x;
			if(z.key < x.key) {
				x = x.left;
			} else {
				x = x.right;
			}
		}
		z.parent = y;
		if(y == nil) {
			root = z;
		} else if ( z.key < y.key) {
			y.left = z;
		} else {
			y.right = z;
		}
		z.left = nil;
		z.right = nil;
		z.color = RBTNode.red;
		rbInsertFixup(z);
	}
	
	public String search(int k) {
		if(root == nil) {
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
	
	private String search(RBTNode node, int k) {
		if(node == nil) {
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

	public int height() {
		int l = 0;
		int r = 0;
		if(root.left != nil) {
			l = height(root.left) + 1;
		}
		if(root.right != nil) {
			r = height(root.right) + 1;
		}
		if(l < r) {
			return r;
		} else {
			return l;
		}
	}
	

	public boolean CheckRB() {
		//BST-Bedingung-Check
		if(isValidBST(root,Integer.MIN_VALUE,Integer.MAX_VALUE) == false) {
			return false;
		}
		//Wurzelcheck
		if(root.color == RBTNode.red) {
			return false;
		}
		//check Fall 1
		if(checkCase1(root) == false) {
			return false;
		}
		//check Fall 2
		if(checkCase2(root) == false) {
			return false;
		}
		//check Fall 3
		if(checkCase3(root) == false) {
			return false;
		}
		//check Fall 4
		if(checkCase4(root) == false) {
			return false;
		}
		return true;
	}
	
	

	public void manipulate1() {
		root.color = RBTNode.red;
	}
	
	public void manipulate2() {
		root.left.color = RBTNode.red;
		root.left.left.color = RBTNode.red;
	}
	
	public void manipulate3() {
		RBTNode x = root;
		while(x != nil) {
			x.color = RBTNode.black;
			x = x.right;
		}
	}
	
	public void manipulate4() {
		swap(root.left,root.right);
	}
	
	

	//Hilfsmethoden
	private void rbInsertFixup(RBTNode node) {
		RBTNode y;
		while(node.parent.color == RBTNode.red) {
			if(node.parent == node.parent.parent.left) {
				//fall 1 
				y = node.parent.parent.right;
				if(y.color == RBTNode.red) {
					node.parent.color = RBTNode.black;
					y.color = RBTNode.black;
					node.parent.parent.color = RBTNode.red;
					node = node.parent.parent;
					//fall 1 ende
				} else { 
					if( node == node.parent.right) {
						//fall 2
						node = node.parent;
						leftRotate(node);
						//fall 2 ende
					}
					//fall 3
					node.parent.color = RBTNode.black;
					node.parent.parent.color = RBTNode.red;
					rightRotate(node.parent.parent);
					//fall 3 ende
				}
			}else {
				//fall 1
				y = node.parent.parent.left;
				if(y.color == RBTNode.red) {
					node.parent.color = RBTNode.black;
					y.color = RBTNode.black;
					node.parent.parent.color = RBTNode.red;
					node = node.parent.parent;
					//fall 1 ende
				} else {
					if( node == node.parent.left) {
						//fall 2
						node = node.parent;
						rightRotate(node);
						//fall 2 ende
					}
					//fall 3
					node.parent.color = RBTNode.black;
					node.parent.parent.color = RBTNode.red;
					leftRotate(node.parent.parent);
					//fall 3 ende
				}
			}
		}
		root.color = RBTNode.black;
	}
	
	
	private void leftRotate(RBTNode node) {
		if(node.right == nil) {
			return;
		}
		RBTNode upNode = node.right;
		node.right = upNode.left;
		if(upNode.left != nil) {
			upNode.left.parent = node;
		}
		upNode.parent = node.parent;
		if(node.parent == nil) {
			root = upNode;
		} else if (node == node.parent.left) {
			node.parent.left = upNode;
		} else {
			node.parent.right = upNode;
		}
		upNode.left = node;
		node.parent = upNode;
	}
	
	private void rightRotate(RBTNode node) {
		if(node.left == nil) {
			return;
		}
		RBTNode upNode = node.left;
		node.left = upNode.right;
		if(upNode.right != nil) {
			upNode.right.parent = node;
		}
		upNode.parent = node.parent;
		if(node.parent == nil) {
			root = upNode;
		} else if (node == node.parent.right) {
			node.parent.right = upNode;
		} else {
			node.parent.left = upNode;
		}
		upNode.right = node;
		node.parent = upNode;
	}
	
	private int height(RBTNode node) {
		int l = 0;
		int r = 0;
		if(node.left != nil) {
			l = height(node.left) + 1;
		}
		if(node.right != nil) {
			r = height(node.right) + 1;
		}
		if(l < r) {
			return r;
		} else {
			return l;
		}
	}
	
	//Zerstörung der BST-Bedingung mit swap-Methode
	private void swap(RBTNode a,RBTNode b) {
		int tmp = a.key;
		a.key = b.key;
		b.key = tmp;
	}
	
	//Hilfsmethoden für die Valid-Methode
	
	//Überpüfen ob BST-Bedingung erfüllt ist
	private boolean isValidBST(RBTNode node, int min, int max) {
		if(node==nil) {
			return true;
		}
		
		if(node.key < min || node.key > max) {
			return false;
		}
		return isValidBST(node.left,min,node.key) && isValidBST(node.right,node.key,max);
	}

	//Überprüfen ob Knoten entweder rot oder schwarz
	private boolean checkCase1(RBTNode node) {
		if(node == nil && node.color == RBTNode.black) {
			return true;
		}
		
		if(node.color != RBTNode.black && node.color != RBTNode.red) {
			return false;
		}
		
		return checkCase1(node.left) && checkCase1(node.right);
	}
	
	//Rot und rot ist tot Check
	private boolean checkCase2(RBTNode node) {
		if(node == nil) {
			return true;
		}
		
		if(node.color == RBTNode.red) {
			if(node.left.color == RBTNode.red || node.right.color == RBTNode.red) {
				return false;
			}
		}
		
		return checkCase2(node.left) && checkCase2(node.right);
	}
	
	//Wenn schwarzer Knoten ein Nachfolger hat, dann muss dieser rot sein
	private boolean checkCase3(RBTNode node) {
		if(node == nil) {
			return true;
		}
		if(node.color == RBTNode.black) {
			if(node.left == nil && node.right != nil) {
				if(node.right.color != RBTNode.red) {
					return false;
				}
			}
			if(node.left != nil && node.right == nil) {
				if(node.left.color != RBTNode.red) {
					return false;
				}
			}
		}
		return checkCase3(node.left) && checkCase3(node.right);
	}
	
	//Alle Pfade haben gleiche Anzehl an schwarze Knoten
	//Quelle: https://algs4.cs.princeton.edu/33balanced/RedBlackBST.java.html
	private boolean checkCase4(RBTNode node) {
		int black = 0;
		while(node != nil) {
			if(node.color == RBTNode.black) {
				black++;
			}
			node = node.left;
		}
//		System.out.println(black);
		return checkCase4(root,black);
	}
	
	
	private boolean checkCase4(RBTNode node, int black) {
		if(node == nil) {
			return black == 0;
		}
		if(node.color == RBTNode.black) {
			black--;
		}
		return checkCase4(node.left, black) && checkCase4(node.right, black);
	}

	//Ende Hilfsmethoden Validator
	
	
	
	//Inorder zur Ausgabe des Baumes (Element kleinstes bis größtes)
	//Nil Knoten werden jedoch trotzdem ausgegeben
		public void inorder() {
			inorder(root);
		}

		
		private void inorder(RBTNode node) {
			if(node != nil) {
				inorder(node.left);
				System.out.print(node.key + " ");
				inorder(node.right);
			}
			
		}
}
