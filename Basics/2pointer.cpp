#include <iostream>
using namespace std;

void accessVarUsingPtr(){
    int num = 5;
    int * ptr;
    ptr = &num;
    
    cout<<"\nValue of num: "<<num;
    cout<<"\nValue of *ptr: "<<*ptr;
    cout<<"\nAddress of num: "<<&num;
    cout<<"\nValue of ptr: "<<ptr;
}

void accessArrayUsingPtr(){
    
    int arr[5] ={10,20,30,40,50};
    int *ptr;
    
    ptr = arr;
    
    for(int i=0; i<5; i++){
        cout<<"\narr["<<i<<"] = "<<*ptr;
        ptr++;
    }
    
}

void ptrToPTrDemo(){
    int num =5;
    int *ptr;
    int **ptr1;
    int ***ptr2;
    int ****ptr3;

    ptr = &num;
    ptr1 = &ptr;
    ptr2 = &ptr1;
    ptr3 = &ptr2;

    cout<<"\nValue of num: \t\t"<<num;
    cout<<"\nValue of *ptr: \t\t"<<*ptr;
    cout<<"\nValue of **ptr1: \t"<<**ptr1;
    cout<<"\nValue of ***ptr2: \t"<<***ptr2;
    cout<<"\nValue of ****ptr2: \t"<<****ptr3;

}

int main() {

    cout<<"\nAccessing variable using pointer";
    accessVarUsingPtr();
    
    cout<<"\n--------------------------------";
    cout<<"\nAccessing array using pointer";
    accessArrayUsingPtr();
    
    cout<<"\n-------------------------------------";
    cout<<"\nPointer to pointer";
    ptrToPTrDemo();
    return 0;
}




