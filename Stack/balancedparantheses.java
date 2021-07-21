import java.util.*;

/*
 *    if string is of odd length return false
 *
 *    For every opening bracket 
 *        push its corresponding closing bracket onto the stack
 *
 *    If the character is not opening bracket
 *        check if that char == closing bracket on top of stack
 *            if not return false
 *        if stack is empty at that time return false
 *
 *    return stack.isEmpty()
 *
 */

class ParanthesesCheck{

  public boolean isValid(String s){

    Stack<Character> stack = new Stack<Character>();

    if(s.length()%2 != 0){
      return false;
    }

    for(char ch: s.toCharArray()){

      if(ch == '('){
        stack.push(')');
      }
      else if(ch == '{'){
        stack.push('}');
      }
      else if(ch == '['){
        stack.push(']');
      }
      else if(stack.isEmpty() || stack.pop() != ch){
        return false;
      }
    }

    return stack.isEmpty();
  }
}


class Main{

  public static void main(String args[]){

    ParanthesesCheck pcheck = new ParanthesesCheck();

    System.out.println(pcheck.isValid("[]{}(){]"));


  }
}