#include<iostream>

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
        int stack[50];
        int top;
        int size;
        
    public:
        
        Stack(){
            top = -1;
            size = 50;
        }
        
        void push(int value){
            
            if(top >= size){
                cout<<"Stack overflow"<<endl;
            }
            else{
                top++;
                stack[top] = value;
                cout<<"Element pushed to stack"<<endl;
            }
        }
        
        int pop(){
            try{
                if(top <= -1){
                    StackUnderFlowException se;
                    throw se;
                }
                else{
                    int value = stack[top];
                    cout<<"The popped element is "<<value<<endl;
                    top --;
                    return value;
                }   
            }
            catch(StackUnderFlowException e){
                cout << e.what();
            }
                
        }
        
        int peek(){
            try{
                if(top <= -1){
                    StackUnderFlowException se;
                    throw se;
                }
                else{
                    cout<<"The top element of stack is: "<<stack[top]<<endl;
                    return stack[top];
                }   
            }
            catch(StackUnderFlowException e){
                cout << e.what();
            }
            
        }
        
        void display(){
            
            if(top <= -1){
                cout<<"The Stack is empty";
                return;
            }
            
            cout<<"The stack elements are: "<<endl;
            for(int i = top; i >= 0; i--){
                cout<<stack[i]<<" ";
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



