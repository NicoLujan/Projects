#include "Prueba.h"

Prueba::Prueba(int f,int c)
{
    this->f = f;
    this->c = c;
    this->arreglo = new int*[f];

    for(int i=0;i<f;i++){
        arreglo[i] = new int[c];
    }
}

Prueba::~Prueba()
{
    //dtor
}
