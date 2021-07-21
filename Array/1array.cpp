#include <iostream>
using namespace std;

int main() {
    int num[20];
    int n;

    cout << "Enter how many numbers you want ";
    cin >> n;

    cout << "Enter "<<n<< " elements";
    for (int i = 0; i < n; ++i) {
        cin >> num[i];
    }

    cout << "\nThe array elements are: ";

    for (int i = 0; i < n; ++i) {
        cout << num[i] << "  ";
    }

    return 0;
}

