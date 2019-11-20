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
    }



// actual class defintion

    private Node  root;

    public BST( 	) {
        root = null;
    }

    // add function
    public void add( int val ) {
				Node n = new Node (val) ;
				root = n; 
    }
    // remove function



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


}
