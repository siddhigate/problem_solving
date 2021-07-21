#include<iostream>
using namespace std;

void merge(int *array, int l, int m, int r) {
   
    int i, j, k, nl, nr;
   
    //size of sub-arrays
    nl = m - l + 1; 
    nr = r - m;
    
    int larr[nl], rarr[nr];
   
    //fill sub-arrays
    for(i = 0; i < nl; i++)
        larr[i] = array[l+i];
   
    for(j = 0; j < nr; j++)
        rarr[j] = array[m+1+j];
   
    i = 0; j = 0; k = l;
   
    //merge arrays 
    while(i < nl && j<nr) {
        
        if(larr[i] <= rarr[j]) {
        
            array[k] = larr[i];
            i++;
        }
        else{
        
            array[k] = rarr[j];
            j++;
        }
        
        k++;
   }
   
    // insert extra elements
    while(i < nl) { 
        
        array[k] = larr[i];
        i++; k++;
    }
    
    while(j < nr) {     
        
        array[k] = rarr[j];
        j++; k++;
   }
}


void mergeSort(int *array, int l, int r) {

   int m;

   if(l < r) {
       
      int m = l + (r - l) / 2;
      
      mergeSort( array, l, m );
      mergeSort( array, m+1, r );
      merge( array, l, m, r );
   }
}


// Display array
void display(int *array, int size) {
   
    for(int i = 0; i<size; i++)
        cout << array[i] << " ";
    cout << endl;
}



int main() {
   
    int n;
   
    cout << "\n\n================================="<<endl;
    cout << "             SORTING"<<endl;
    cout << "================================="<<endl;
   
   
    // INPUT
    cout << "\nEnter the number of elements: ";
    cin >> n;
    
    int arr[n];     
    
   
    for(int i = 0; i<n; i++) {
        cout << "Enter element " << i <<": ";
        cin >> arr[i];
    }
    
    
    cout << "\n\n================================="<<endl;
   
    cout << "Original Array:\t";
    display(arr, n);
    
    // CALL MERGE SORT
    mergeSort(arr, 0, n-1);     
    
    // OUTPUT
    cout << "Sorted Array:\t";
    display(arr, n);
    
    cout << "================================="<<endl;
   
}
