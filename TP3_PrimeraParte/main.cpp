#include <iostream>
#include <Punto.h>
#include <Segmento.h>

using namespace std;

int main()
{
    Punto P1;


    P1.trasladar(4,5);

    Punto P2(3,7);

    Segmento S1(P1,P2);

    Punto P3(4,5);

    Punto P4(3,7);

    Segmento S2(P3,P4);

    if (S1 == S2){
        cout<<"Son iguales";
    }

    return 0;
}
