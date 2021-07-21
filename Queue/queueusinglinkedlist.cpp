#include <iostream>
#include <stdio.h>
#include <stdlib.h>

using namespace std;

class QueueUnderFlowException : public  exception{
    
    public:
        const char * what() const throw()  
        {  
            return "Queue Underflow!\n";  
        }  
};

class Queue{
  
    private:
    
        struct Node{
          int data;
          struct Node *next;
        };
        
        struct Node *front, *rear;
    
    
    public:
        
        Queue(){
            front = rear = NULL;
        }
        
        void enqueue(int value){
            
            struct Node *newNode= (struct Node*) malloc(sizeof(struct Node));
            newNode->data = value ;
            
            if(front == NULL){
                front = newNode;
                rear = newNode;
                rear->next = NULL;
            }
            else{
                rear->next = newNode;
                rear = newNode; 
                rear->next = NULL;
            }
            
            cout<<"Element enqueued."<<endl;
        }
        
        int dequeue(){
            
            try{
                if(front == NULL){
                    QueueUnderFlowException se;
                    throw se;
                }
                else{
                    Node *temp = front;
                    int value = temp->data;
                    cout<<"The dequeued element is "<<value<<endl;
                    front = front->next ;
                    return value;
                }   
            }
            catch(QueueUnderFlowException e){
                cout << e.what();
            }
            
        }
        
        int peek(){
            
            try{
                if(front == NULL){
                    QueueUnderFlowException se;
                    throw se;
                }
                else{
                    int value = front->data;
                    cout<<"The element at the front of the queue is "<<value<<endl;
                    return value;
                }   
            }
            catch(QueueUnderFlowException e){
                cout << e.what();
            }
            
        }
        
        void display(){
            
            if(front == NULL){
                cout<<"Queue is empty"<<endl;
            }
            else{
                
                Node *temp = front;
                
                cout<<"The queue elements are: "<<endl;
                while(temp!= NULL){
                    
                    cout<<temp->data<<" ";
                    temp= temp->next;
                }
            }
        }
};


int main(){
    
    Queue q;
    
    int item, itm, choice;    
     
    while(true){
        cout<<"\n\n==============================";
        cout<<"\nQueue OPERATIONS";
        cout<<"\n==============================";
        cout<<"\nEnter 1 to Enqueue";
        cout<<"\nEnter 2 to Dequeue";
        cout<<"\nEnter 3 to Peek";
        cout<<"\nEnter 4 to Display";
        cout<<"\nEnter 5 to Exit";    
    
        std::cout<<"\n\nEnter your choice: ";
        cin>>choice;
    
        switch(choice){
            
            case 1 : cout<<"\n------------------------------";
                     cout<<"\nEnqueue";
                     cout<<"\n\nEnter an element to enqueue : ";
                     cin>>item;
                     q.enqueue(item);
                     cout<<"\n------------------------------";
                     break;
            
            case 2 : cout<<"\n------------------------------";
                    cout<<"\nDequeue"<<endl;
                    item = q.dequeue();
                    cout<<"\n------------------------------";
                    break;    
                    
            case 3 : cout<<"\n------------------------------";
                     cout<<"\nPeek"<<endl;
                     item = q.peek();
                     cout<<"\n------------------------------";
                     break;    
                    
            case 4 : cout<<"\n------------------------------";
                     cout<<"\nDisplay"<<endl;
                     q.display();
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





