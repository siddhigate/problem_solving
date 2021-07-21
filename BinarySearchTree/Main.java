import java.util.Stack;
import java.util.Queue; 
import java.util.LinkedList;
import java.util.Scanner;


// BinarySearchTree class
class BinarySearchTree{

    // Node class
    private class Node{
        int data;
        Node left,right;

        Node(int inputData){
            data = inputData;
            left = right = null;
        }
    }

    private Node root;

    BinarySearchTree(){
        root = null;
    }
    
    // check if Empty
    boolean isEmpty(){
        if(root == null){
            return true;
        }
        else return false;
    }

    // INSERT OPERATION
    void insert(int inputData){
        root = insertData(root,inputData);
    }

    private Node insertData(Node root, int data){
        
        if(root == null){
            root = new Node(data);
            System.out.println("Element inserted");
            return root;
        }

        if(data < root.data){
            root.left = insertData(root.left,data);
        }
        else if(data > root.data){
            root.right = insertData(root.right,data);
        }else{
            System.out.println("Element not inserted -- Can't insert duplicate elements");
        }

        return root;
    }
    
    
    // DELETE OPERATION
    void delete(int inputData){
    
        if(isEmpty()){
            System.out.print("\nTree is Empty- can't delete");
            return;
        }
    
        root = deleteData(root, inputData);
    }
    
    private Node deleteData(Node root, int data){
        
        if(root == null){
            System.out.print("Data element not present");
            return root;
        }
        
        if(data < root.data){
            root.left = deleteData(root.left, data); 
        }
        else if(data > root.data){
            root.right = deleteData(root.right, data);
        }
        else{
            //node found
            
            // node with 0 or 1 child
            if(root.left == null){
                System.out.println("Element deleted");
                return root.right;
            }            
            else if(root.right == null){
                System.out.println("Element deleted");
                return root.left;
            }
            // node with 2 children
            else{
                
                root.data = getInorderSuccessor(root.right);
            
                root.right = deleteData(root.right , root.data);
            }
            
        }
            
        
        return root;
    }
    
    private int getInorderSuccessor(Node root){
        
        int inorderSuccessor = root.data;
        
        while(root.left != null){
            inorderSuccessor = root.left.data;
            root = root.left;
        }
        
        return inorderSuccessor;
    }
    
    //TRAVERSALS
    // DFS
    //Recursive Inorder Traversal
    void recursiveInorder(){
       
        if(isEmpty()){
            System.out.print(" Tree is Empty");
            return;
        }
        recursiveInorderTraversal(root);
    }

    private void recursiveInorderTraversal(Node root){
        
        if(root != null){
            recursiveInorderTraversal(root.left);
            System.out.print(root.data+" ");
            recursiveInorderTraversal(root.right);
            
        }
    }
    
    // Recursive Preorder Traversal
    void recursivePreorder(){
        
        if(isEmpty()){
            System.out.print(" Tree is Empty");
            return;
        }
        recursivePreorderTraversal(root);
    }

    private void recursivePreorderTraversal(Node root){
        
        if(root != null){
            System.out.print(root.data+" ");
            recursivePreorderTraversal(root.left);
            recursivePreorderTraversal(root.right);
            
        }
    }
    
    
    // Recursive Postorder Traversal
    void recursivePostorder(){
        
        if(isEmpty()){
            System.out.print(" Tree is Empty");
            return;
        }
        recursivePostorderTraversal(root);
    }

    private void recursivePostorderTraversal(Node root){

        if(root != null){
            recursivePostorderTraversal(root.left);
            recursivePostorderTraversal(root.right);
            System.out.print(root.data+" ");
        }
    }

    //  BFS ITERATIVE
    // Iterative Inorder Traversal
    void iterativeInorder(){
        
        if(isEmpty()){
            System.out.print(" Tree is Empty");
            return;
        }
        iterativeInorderTraversal();
    }
    
    private void iterativeInorderTraversal()
    {
        Stack<Node> s = new Stack<Node>();
        Node curr = root;
 
        while (curr != null || !s.isEmpty())
        {
            while (curr !=  null)
            {
                s.push(curr);
                curr = curr.left;
            }
 
            curr = s.pop();
 
            System.out.print(curr.data + " ");
 
            curr = curr.right;
        }
    }    
    
    void iterativePreorder(){
    
        if(isEmpty()){
            System.out.print(" Tree is Empty");
            return;
        }
        iterativePreorderTraversal();
    }
    
    private void iterativePreorderTraversal()
    {
        Stack<Node> s = new Stack<Node>();
        Node curr = root;
        s.push(root);
        
        while (!s.isEmpty())
        {
            
            curr = s.pop();
            
            System.out.print(curr.data+" ");
            
            if(curr.right!=null){
                s.push(curr.right);
            }
            
            if(curr.left!=null){
                s.push(curr.left);
            }
        }
    } 
    
    void iterativePostorder(){
        if(isEmpty()){
            System.out.print(" Tree is Empty");
            return;
        }
        iterativePostorderTraversal();
    }
    
    private void iterativePostorderTraversal()
    {
        
        Stack<Node> s1, s2;       
        s1 = new Stack<>(); 
        s2 = new Stack<>(); 
  
        s1.push(root); 
  
         
        while (!s1.isEmpty()) { 
            
            Node curr = s1.pop(); 
            s2.push(curr); 
  
            if (curr.left != null) 
                s1.push(curr.left); 
            if (curr.right != null) 
                s1.push(curr.right); 
        } 
  
        while (!s2.isEmpty()) { 
            Node curr = s2.pop(); 
            System.out.print(curr.data + " "); 
        } 
    } 
    
    // BFS
    // iterative BFS
    void iterativeLevelOrder(){
        if(isEmpty()){
            System.out.print(" Tree is Empty");
            return;
        }
        iterativeLevelOrderTraversal();
    }
    
    private void iterativeLevelOrderTraversal(){
        
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
      
        while (!queue.isEmpty()) {
            
            // dequeue
            Node temp = queue.poll();
            
            System.out.print(temp.data + " ");
 
            // enqueue left child
            if (temp.left != null) {
                  queue.add(temp.left);
            }
 
            // enqueue right child
            if (temp.right != null) {
                queue.add(temp.right);
            }
        }
    }
    
    // recursive BFS
    void recursiveLevelOrder(){
        if(isEmpty()){
            System.out.print(" Tree is Empty");
            return;
        }
        recursiveLevelOrderTraversal();
    }
    
    private void recursiveLevelOrderTraversal(){
        
        int h = getHeight(root);
        
        for (int i=1; i<=h; i++)
            printGivenLevel(root, i);
    }
    
    // finding height of tree
    private int getHeight(Node root)
    {
        if (root == null)
           return 0;
        else
        {
            // height of each subtree
            int lheight = getHeight(root.left);
            int rheight = getHeight(root.right);
             
            
            if (lheight > rheight)
                return(lheight+1);
            else 
                return(rheight+1); 
        }
    }
    
    // printing given level
    private void printGivenLevel(Node root ,int level)
    {
        if (root == null)
            return;
            
        if (level == 1){
            System.out.print(root.data + " ");   
        }
        else if (level > 1)
        {
            printGivenLevel(root.left, level-1);
            printGivenLevel(root.right, level-1);
        }
    }
}



class Main{
    
    public static void main(String args[]){
        
        System.out.println("BINARY SEARCH TREE");
        
        BinarySearchTree bstree = new BinarySearchTree(); 

        Scanner sc = new Scanner(System.in);
        
        
        int data,cont,num;
        
        do{
            System.out.println("\n------------BST OPERATIONS----------------");
            System.out.println("Enter 1 to insert");
            System.out.println("Enter 2 to delete");
            System.out.println("Enter 3 to display using all traversals");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            System.out.println("\n----------------------------------------");
            
            switch(choice){
                
                case 1 :System.out.println("INSERT");
                        System.out.print("Enter the number of elements you want to insert: ");
                        num = sc.nextInt();
                        for(int i=0;i<num;i++){
                            System.out.print("Enter element "+(i+1)+" to insert: ");
                            data = sc.nextInt();
                            bstree.insert(data);
                        }
                        break;
                
                case 2: System.out.println("DELETE");
                        if(!bstree.isEmpty()){
                            System.out.print("Enter the element you want to delete: ");
                            data = sc.nextInt();
                            bstree.delete(data);
                        }
                        else{
                            System.out.println("Tree is empty: no elements to delete");
                        }
                        
                        break;
                         
                case 3: System.out.println("TRAVERSAL");
                        // DFS TRAVERSALS
                        if(!bstree.isEmpty()){
                            System.out.println("\n\nDFS Traversal");
                            
                            System.out.println("INORDER");
                            System.out.print("Recursive : ");
                            bstree.recursiveInorder();
                            System.out.print("\nIterative : ");
                            bstree.iterativeInorder();
                    
                            System.out.print("\n\nPREORDER");
                            System.out.print("\nRecursive : ");
                            bstree.recursivePreorder();
                            System.out.print("\nIterative : ");
                            bstree.iterativePreorder();
                        
                            System.out.print("\n\nPOSTORDER");
                            System.out.print("\nRecursive : ");
                            bstree.recursivePostorder();
                            System.out.print("\nIterative : ");
                            bstree.iterativePostorder();
                        
                            // BFS TRAVERSALS
                            System.out.print("\n\nBFS Traversal");
                            System.out.print("\nRecursive : ");
                            bstree.recursiveLevelOrder();     
                            System.out.print("\nIterative : ");
                            bstree.iterativeLevelOrder();  
                        }
                        else{
                            System.out.println("Tree is Empty  - no elements to traverse");
                        }
                        break;
                        
                default : System.out.println("Invalid choice");
            }
            System.out.println("\n----------------------------------------");
            System.out.print("Do you want to repeat the operation? \nEnter 1 if yes  ");
            cont = sc.nextInt();
                
        }while(cont == 1);
  
        System.out.println("\n\n\n-------------------------------------------");
        System.out.println("THANK YOU");
        System.out.println("-------------------------------------------");
    }
}








