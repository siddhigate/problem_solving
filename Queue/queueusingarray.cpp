#include<iostream>

using namespace std;

class Queue{
    
    int queue[50];
    int front;
    int rear;
    int size;
    
    public:
        Queue(){
            front = rear = -1;
            size = 50;
        }
        
        bool isEmpty(){
            
            if(front == - 1 || front > rear){
                return true;
            }
            
            return false;
        }
        
        bool isFull(){
            
            if(rear == size - 1){
                return true;
            }
            
            return false;
        }
        
        void enqueue(int data){
            
            if( isFull()){
                cout << "\nQueue is Full";
                return;
            }
            
            if( front == -1 ){
                front = 0;
            }
            
            rear += 1;
            queue[rear] = data;
            
            cout << "Element enqueued";
        }
        
        int dequeue(){
            
            if( isEmpty() ){
                cout << "Queue is Empty";
                return -1;
            }
            
            int data = queue[front];
            front += 1;
            
            cout << "Dequeued element is " << data;
            return data;
        }
        
        int peek(){
            
            if( isEmpty() ){
                cout << "Queue is Empty";
                return -1;
            }
            
            cout << "Front element is " << queue[front];
            return queue[front];
        }
        
        void display(){
            
            if( isEmpty() ){
                cout << "Queue is Empty";
                return;
            }
            
            for(int i = front; i <= rear; i++){
                cout << queue[i] << " - ";
            }
            
        }
    
};


int main(){
    
    Queue q;
    
    int item, itm, choice;    
     
    while(true){
        cout<<"\n\n==============================";
        cout<<"\nQUEUE OPERATIONS";
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
                     cout<<"\n\nEnter an element to push onto the stack: ";
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

