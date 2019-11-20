package trees.bst;


public class BST  {

// main for demonstrations

    public static void main ( String args [] ) {
        BST tree = new BST();
        for (String arg : args) {
            int num = Integer.parseInt(arg) ;
            tree.add(num);

        }
        System.out.println(tree.toStringTreeFormat() );

        //tree.remove(4);
        //System.out.println(tree.toStringTreeFormat() );

    }



// actual class defintion

    private Node  root;

    public BST( 	) {
        root = null;
    }

    // add function
/*
    public boolean add( int val ) {
        if (root == null ) { 
            Node n = new Node (val) ;
            root = n;
            return true; 
        }
        
        return add (val, root); 
        
    }
    
    private boolean add (int val, Node n ) { 
        
        //found duplicate 
        if ( val == n.data) return false; 
        
        
        if ( val < n.data ) { // go left 
            if ( n.left == null ) {//attach it right here 
                Node current = new Node (val); 
                n.left = current; 
                return true; 
            }
            else { // recurse to its left subtree 
                return add(val, n.left) ; 
            } 
        }
        else { // go right 
            if ( n.right == null ) {//attach it right here 
                Node current = new Node (val); 
                n.right = current; 
                return true; 
            }
            else { // recurse to its right subtree 
                return add(val, n.right) ; 
            } 
            
        } 
    }
*/ 

	public boolean add ( int e ) {
        int oldSize = size();
        root  =  add ( e, root );
        if (oldSize == size())
            return false;
        return true;
	}

	private Node add ( int item, Node root ) {

        if ( root == null ) {
                return new Node(item);
        }
        if ( root.data == item ) {
                return root;
        }
        else if ( root.data < item  ) {
                root.right =  add ( item, root.right );
        }
        else {
                root.left = add ( item, root.left);
        }
        return root;
	}

    // remove function



		private boolean found ;
        
		public boolean remove(int val)
		{
			found = false;
			root = recRemove(val, root);
			return found;
		}

		private Node recRemove(int target, Node  node)
		{
			if (node == null)
				found = false;
			else if (target < node.data)
				node.left = recRemove(target, node.left);
			else if (target > node.data)
				node.right = recRemove(target, node.right );
			else {
				node = removeNode(node);
				found = true;
			}
			return node;
		}

		private Node removeNode(Node node)
		{
			int data;
			
            if (node.left == null)
				return node.right ;
			else if (node.right  == null)
				return node.left;
			
            else {
				data = getPredecessor(node.left);
				node.data = data;
				node.left = recRemove(data, node.left);
				return node;
			}
		}

		private int getPredecessor(Node subtree)
		{
			Node temp = subtree;
			while (temp.right  != null)
				temp = temp.right ;
			return temp.data;
		}






    // check if a value is stored in the tree
    public boolean contains (int val ) {
        if (root == null)
            return false;
        Node cur = root;

        do {
            int curVal = cur.data;

            if (val == curVal)  return true;
            if (val < curVal ) cur = cur.left;
            else cur = cur.right;

        } while (cur != null) ;

        return false;


    }

    // this should be stored in a data filed to improve performance
    // calculation is done just as an exercise
    public int size ( ) {
        return size(root);
    }
    private int size( Node n ) {
        if (n == null ) return 0;
        return 1 + size(n.left) + size(n.right);
    }






    private static class Node  {

        int  data;
        Node  left ;
        Node  right ;

        Node ( int data ) {
            this.data = data;
        }

        Node ( int data, Node l, Node r ) {
            this.data = data;
            left = l;
            right = r;
        }

    }










    private void preOrderPrint(Node tree, int level, StringBuilder output) {
        if (tree != null) {
            String spaces = "\n";
            if (level > 0) {
                for (int i = 0; i < level - 1; i++)
                    spaces += "   ";
                spaces += "|--";
            }
            output.append(spaces);
            output.append(tree.data);
            preOrderPrint(tree.left, level + 1, output);
            preOrderPrint(tree.right, level + 1, output);
        }
        // uncomment the part below to show "null children" in the output
        else {
            String spaces = "\n";
            if (level > 0) {
                for (int i = 0; i < level - 1; i++)
                    spaces += "   ";
                spaces += "|--";
            }
            output.append(spaces);
            output.append("null");
        }
    }


    public String toStringTreeFormat() {

        StringBuilder s = new StringBuilder();

        preOrderPrint(root, 0, s);
        return s.toString();
    }









/*



	public boolean add ( int e ) {
			int oldSize = size();
			root  =  add ( e, root );
			if (oldSize == size())
				return false;
			return true;
	}

	private Node add ( int item, Node root ) {

			if ( root == null ) {
					return new Node(item);
			}
			if ( root.data == item ) {
					return root;
			}
			else if ( root.data < item  ) {
					root.right =  add ( item, root.right );
			}
			else {
					root.left = add ( item, root.left);
			}
			return root;
	}




		private boolean found ;
		public boolean remove(int val)
		{
			found = false;
			root = recRemove(val, root);
			return found;
		}

		private Node recRemove(int target, Node  node)
		{
			if (node == null)
				found = false;
			else if (target < node.data)
				node.left = recRemove(target, node.left);
			else if (target > node.data)
				node.right = recRemove(target, node.right );
			else {
				node = removeNode(node);
				found = true;
			}
			return node;
		}

		private Node removeNode(Node node)
		{
			int data;
			if (node.left == null)
				return node.right ;
			else if (node.right  == null)
				return node.left;
			else {
				data = getPredecessor(node.left);
				node.data = data;
				node.left = recRemove(data, node.left);
				return node;
			}
		}

		private int getPredecessor(Node subtree)
		{
			Node temp = subtree;
			while (temp.right  != null)
				temp = temp.right ;
			return temp.data;
		}
*/

}
