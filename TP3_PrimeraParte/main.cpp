#include <iostream>
#include <Punto.h>

using namespace std;

int main()
{
    Punto p1;


    p1.trasladar(4,4);

    Punto P2(3,3);

    cout<<p1.distancia(P2);

    return 0;
}
