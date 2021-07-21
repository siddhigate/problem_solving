
#include<iostream>

using namespace std;

class Array{
    
    private: 
        int arr[50];
        int size;
    
		int binarysearch(int arr[], int left, int right, int num){
        
        if(left <= right){
            
            int mid = (left + right) / 2;
            
            if(arr[mid] == num){
                return mid;
            }
            
            if(arr[mid] > num){
                return binarysearch(arr, left, mid - 1, num);
            }
            
            if(arr[mid] < num){
                return binarysearch(arr, mid + 1, right, num);
            }
        }
        
        return -1;
    }   
	 
    public:
    
    
    int search(int num){
    	return binarysearch(arr, 0, size-1, num);
	}
    
    
    void print(){
        
        cout<<"The array elements are:"<<endl;
        for(int i = 0; i< size; i++){
            cout<<arr[i]<<" ";
        }
        cout<<"\n";
    }
    
    void input(){
        
        cout<<"Enter the number of elements in sorted order: ";
        cin>> size;
        for(int i = 0; i< size; i++){
            cout<<"Enter element "<<i<<": ";
            cin>>arr[i];
        }
    }
};


int main(){
    
    int num;
    
    
    Array array;
    
	// user input	
	cout<<"\n\nINPUT\n-------------------------\n";
	array.input();
	
	// display array
    cout<<"\n\nARRAY ELEMENTS:\n-------------------------\n";
	array.print();
    
	// search
	cout<<"\n\nSEARCH\n-------------------------\n";
	cout<<"Enter an element to search: ";
	cin>>num;
	int index = array.search(num); 
	if(index == -1){
		cout << "\nElement not found in the array";
	}   
	else {
		cout << "\nElement present at index "<<index;
	}
    
    cout<<"\n------------------------------";
    
    return 0;
}



