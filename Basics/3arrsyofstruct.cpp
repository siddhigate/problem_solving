/*
    EXPENSE TRACKER
    struct for one expense(description and amount)
    used array of struct to store all the daily/monthly expenses
*/

#include <iostream>
using namespace std;

struct Expense{
    char description[20];
    float amount;
    char date[20];
};

int main(){
    
    Expense e[20];
    int totalAmount =0,n;
    
    cout<<"\n-------------------------------------------------------\n";
    cout<<"EXPENSE TRACKER:";
    cout<<"\n-------------------------------------------------------\n";
    
    // taking input
    cout<<"How many expenses do you want to add? ";
    cin>>n;
    for(int i =0;i<n;i++){
        cout<<"\nExpense "<<i+1;
        cout<<"\nEnter where you spent your money?(ex.food,movie): ";
        cin>>e[i].description;
        cout<<"Enter how much money you spent: ";
        cin>>e[i].amount;
        cout<<"Enter the date in dd//mm/yyyy (without spaces): ";
        cin>>e[i].date;
        totalAmount += e[i].amount;
    }
    
    // displaying values 
    cout<<"\n-------------------------------------------------------\n";
    cout<<"YOUR EXPENSES:";
    cout<<"\n-------------------------------------------------------\n";
    cout<<"ID\tDescription\tAmount\t\tDate\n";
    for(int i =0;i<n;i++){
        cout<<i+1<<"\t"<<e[i].description<<"\t\t"<<e[i].amount<<"\t\t"<<e[i].date<<"\n";
    }
    cout<<"---------------------------------------------------------\n";
    cout<<"Total Expense Amount: " <<totalAmount;
    cout<<"\n-------------------------------------------------------\n";
    
    return 0;
}

