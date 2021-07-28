#include <iostream>

using namespace std;

int main()
{
    double a=10,num=50,btc=0;

    for(int i=0;i<=a;i++){
        btc+=num;
        num/=2;
        cout<<btc<<"  ";
    }
}
