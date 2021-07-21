#include <iostream>
#include <stdio.h>
#include <stdlib.h>
#include<string>

using namespace std;

class Stack{

    private:
    
      struct Node{
        char data;
        struct Node *next;
      };
    
      struct Node *top;
    
    
    public:
    
        Stack (){
            top = NULL;
        }
        
        bool isEmpty(){
            if(top == NULL)
                return true;
            return false;
        }
    
      void push (char value){
    
        struct Node *newNode = (struct Node *) malloc (sizeof (struct Node));
        newNode->data = value;
    
        if (top == NULL){
        	top = newNode;
        }
        else{
    	    newNode->next = top;
    	    top = newNode;
         }
      }
    
      char pop (){
        if (top == NULL){
        	return -1;
        }
        else{
        	Node *temp = top;
        	int value = temp->data;
        	top = top->next;
        	return value;
         }
      }
      
      char peek (){
        if (top == NULL){
        	return -1;
        }
        else{
        	return top->data;
         }
      }
};
    
class InfixToPostfix{
    
    private:
        string postfix;
    
        int isOperator (char ch){
            if (ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^')
                return 1;
            return 0;
        }
    
        int isOperand (char ch){
            if ((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z')
    	        || (ch >= '0' && ch <= '9'))
                return 1;
            return 0;
        }
        
        int getPrecedence(char op)  {  
            if(op == '+' || op == '-')                     
                return 1;  
            if (op == '*' || op == '/')  
                return 2;  
            if(op == '^')                                  
                return 3;       
            return 0; 
        }
        
        bool operatorEqlOrHigher(char operator1, char operator2){
            
            int priority1 = getPrecedence(operator1);
            int priority2 = getPrecedence(operator2);
            
            if(priority1 == priority2){
                return true;
            }
            
            if(priority1 > priority2)
                return true;
            
            return false;
        }
        
    public:  
        string convert(string infix){
            
            Stack s;
            
            postfix = "";
            
            char ch;
            
            for(int i = 0; i < infix.length(); i++){
                
                if(isOperand(infix[i])){
                    
                    postfix += infix[i];
                    
                }
                else if(infix[i] == '(' || infix[i] == '{' || infix[i] == '['){
                    
                    s.push(infix[i]);
                
                }
                else if(infix[i] == ')' || infix[i] == '}' || infix[i] == ']'){
                    
                    if(infix[i] == ')'){
                        while(!s.isEmpty() && s.peek() != '('){
                            postfix += s.pop();
                        }
                        s.pop();    
                    }
                    
                    if(infix[i] == ']'){
                        while(!s.isEmpty() && s.peek() != '['){
                            postfix += s.pop();
                        }
                        s.pop();    
                    }
                    
                    if(infix[i] == '}'){
                        while(!s.isEmpty() && s.peek() != '{'){
                            postfix += s.pop();
                        }
                        s.pop();    
                    }
                    
                }
                else if(isOperator(infix[i])){
                    
                    while(!s.isEmpty() && s.peek()!='(' && operatorEqlOrHigher(s.peek(), infix[i])){
                        
                        postfix += s.pop();
                    }
                    
                    s.push(infix[i]);
                }
            }
            
            
            while(!s.isEmpty()){
                postfix += s.pop();
            }
            
            return postfix;
        }
};

int main ()
{
  
    InfixToPostfix i;

    string infix,postfix;
    
    cout<<"=======================================\n";
    cout<<"       INFIX TO POSTFIX Converter   \n";
    cout<<"=======================================\n\n";
    
    cout<<"Enter infix expression: ";
    cin>>infix;

    postfix = i.convert(infix);
    
    cout<<"\n\nInfix Expression:\t"<<infix<<endl;
    cout<<"Postfix Expression:\t"<<postfix<<endl;
  
    cout<<"\n=======================================\n";
  
  return 0;
}





