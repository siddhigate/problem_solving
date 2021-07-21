#include <iostream>
#include <stdio.h>
#include <stdlib.h>

using namespace std;

class StackUnderFlowException : public  exception{
    
    public:
        const char * what() const throw()  
        {  
            return "Stack Underflow!\n";  
        }  
};

class Stack{
  
    private:
    
        struct Node{
          int data;
          struct Node *next;
        };
        
        struct Node *top;

    
    public:
        
        Stack(){
            top = NULL;
        }
        
        void push(int value){
            
            struct Node *newNode= (struct Node*) malloc(sizeof(struct Node));
            newNode->data = value ;
            
            if(top == NULL){
                top = newNode;
            }
            else{
                newNode->next = top;
                top = newNode;    
            }
            
            cout<<"Element pushed to stack."<<endl;
        }
        
        int pop(){
            
            try{
                if(top == NULL){
                    StackUnderFlowException se;
                    throw se;
                }
                else{
                    Node *temp = top;
                    int value = temp->data;
                    cout<<"The popped element is "<<value<<endl;
                    top = top->next ;
                    return value;
                }   
            }
            catch(StackUnderFlowException e){
                cout << e.what();
            }
            
        }
        
        int peek(){
            
            try{
                if(top == NULL){
                    StackUnderFlowException se;
                    throw se;
                }
                else{
                    int value = top->data;
                    cout<<"The element at the top of the stack is "<<value<<endl;
                    return value;
                }   
            }
            catch(StackUnderFlowException e){
                cout << e.what();
            }
            
        }
        
        void display(){
            
            if(top == NULL){
                cout<<"Stack is empty"<<endl;
            }
            else{
                
                Node *temp = top;
                
                cout<<"The stack elements are: "<<endl;
                while(temp!= NULL){
                    
                    cout<<temp->data<<" ";
                    temp= temp->next;
                }
            }
        }
};


int main(){
    
    Stack s;
    
    int item, itm, choice;    
     
    while(true){
        cout<<"\n\n==============================";
        cout<<"\nSTACK OPERATIONS";
        cout<<"\n==============================";
        cout<<"\nEnter 1 to Push";
        cout<<"\nEnter 2 to Pop";
        cout<<"\nEnter 3 to Peek";
        cout<<"\nEnter 4 to Display";
        cout<<"\nEnter 5 to Exit";    
    
        std::cout<<"\n\nEnter your choice: ";
        cin>>choice;
    
        switch(choice){
            
            case 1 : cout<<"\n------------------------------";
                     cout<<"\nPush";
                     cout<<"\n\nEnter an element to push onto the stack: ";
                     cin>>item;
                     s.push(item);
                     cout<<"\n------------------------------";
                     break;
            
            case 2 : cout<<"\n------------------------------";
                    cout<<"\nPop"<<endl;
                    item = s.pop();
                    cout<<"\n------------------------------";
                    break;    
                    
            case 3 : cout<<"\n------------------------------";
                     cout<<"\nPeek"<<endl;
                     item = s.peek();
                     cout<<"\n------------------------------";
                     break;    
                    
            case 4 : cout<<"\n------------------------------";
                     cout<<"\nDisplay"<<endl;
                     s.display();
                     cout<<"\n------------------------------";
                     break;
            
            case 5 : cout<<"\n\n------------------------------";
                     cout<<"\nThank You!";
                     cout<<"\n------------------------------";
                     exit(0);
                     
        }   
    }
    
    return 0;
}

