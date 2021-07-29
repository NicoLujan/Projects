#include <iostream>
#include <Punto.h>
#include <Segmento.h>
#include "Pila.h"

using namespace std;

int main()
{
    Pila<int> P1;
    P1.agregarP(8);
    P1.eliminarP();
    P1.agregarP(2);
    P1.eliminarP();
    P1.agregarP(3);
   // P1.eliminarP();
    P1.agregarP(4);
    P1.eliminarP();
    P1.agregarP(6);
    P1.eliminarP();
    P1.agregarP(9);
    P1.eliminarP();

    return 0;
}
