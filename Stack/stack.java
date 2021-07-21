import java.util.*;

class Stack<E>{

  private class Node<E>{

    private E data;

    private Node<E> next;

    Node(E data){
      this.data = data;
      this.next = null;
    }
  }

  private Node<E> top;

  Stack(){
    this.top = null;
  }

  boolean isEmpty(){
    return this.top == null;
  }

  void push(E data){

    Node<E> newNode = new Node(data);

    if(!isEmpty()){
      newNode.next = top;
    }

    this.top = newNode;
  }

  E pop(){

    if(isEmpty()){
      throw new EmptyStackException();
    }

    Node<E> oldTop = this.top;
    this.top = this.top.next;

    return oldTop.data;

  }

  E peek(){

    if(isEmpty()){
      throw new EmptyStackException();
    }

    return this.top.data;
  }
}


class Main{

  public static void main(String args[]){

    Stack<Integer> stack = new Stack<Integer>();

    Scanner sc = new Scanner(System.in);
    int choice,data;

    while(true){
      System.out.println("\n1 to push");
      System.out.println("2 to pop");
      System.out.println("3 to peek");
      System.out.println("4 to exit");
      System.out.print("Enter choice: ");
      choice = sc.nextInt();

      switch(choice){

        case 1: System.out.print("Enter data: ");
                data = sc.nextInt();
                stack.push(data);
                break;
        
        case 2: try{
                  System.out.println("Popped: "+stack.pop());
                }catch(EmptyStackException e){
                  System.out.println("Empty stack");
                }
                
                break;

        case 3: try{
                  System.out.println("Top: "+stack.peek());
                }catch(EmptyStackException e){
                  System.out.println("Empty stack");
                }
                break;

        case 4: System.exit(0);
                break;
      }

    }
    


  }
}