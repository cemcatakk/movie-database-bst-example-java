public class BST {
    Node root;
    public BST()
    {
        root = null;
    }
    public void addNode(TreeNode key)
    {
        root = addNode(root, key);
    }
    public void deleteNode(TreeNode key){
        root = deleteNode(root,key);
    }
    Node addNode(Node root, TreeNode key)
    {
        if (root == null)
        {
            root = new Node(key);
            return root;
        }
        if (key.Compare(root.key))
        {
            root.left = addNode(root.left, key);
        }
        else
        {
            root.right = addNode(root.right, key);
        }
        return root;
    }
    Node deleteNode(Node root, TreeNode key)
    {
        if (root == null)
            return root;
        if (key.Compare(root.key))
        {
            root.left = deleteNode(root.left, key);
        }
        else if(root.key.Compare(key))
        {
            root.right = deleteNode(root.right, key);
        }
        else {
            if (root.left == null)
            {
                return root.right;
            }
            else if (root.right == null)
            {
                return root.left;
            }
            root.key = minimumNodeValue(root.right);
            root.right = deleteNode(root.right, root.key);
        }
        return root;
    }

    TreeNode minimumNodeValue(Node root)
    {
        TreeNode minVal = root.key;
        while (root.left != null)
        {
            minVal = root.left.key;
            root = root.left;
        }
        return minVal;
    }
    TreeNode findMovie(String movieTitle){
        BSTIterator iterator = new BSTIterator(root);
        while (iterator.hasNext()){
            Movie movie = (Movie)iterator.next();
            if(movie.getTitle().trim().equalsIgnoreCase(movieTitle.trim())){
                return movie;
            }
        }
        return null;
    }
    TreeNode findActor(String actorName,String actorSurname){
        BSTIterator iterator = new BSTIterator(root);
        while (iterator.hasNext()){
            Cast cast = (Cast)iterator.next();
            if(cast.getFirstName().trim().equalsIgnoreCase(actorName.trim())&&cast.getLastName().trim().equalsIgnoreCase(actorSurname.trim())){
                return cast;
            }
        }
        return null;
    }
    void printInOrder()
    {
        traverseInOrder(root);
    }
    void traverseInOrder(Node root)
    {
        if (root != null) {
            traverseInOrder(root.left);
            System.out.println(root.key.toString());
            traverseInOrder(root.right);
        }
    }
}
