#include "Heap.h"

Heap::Heap(int n) {
    arreglo= new int [n+1];
    ultimo=0;
    cantidad=n;
}

void Heap::agregarH(int e)
{
    if(ultimo<=cantidad){
        ultimo++;
        arreglo[ultimo]=e;
        int pos= ultimo;
        while ((e<arreglo[pos/2]) && (pos>1))
        {
            int aux = arreglo[pos/2];
            arreglo[pos/2]=e;
            arreglo[pos]=aux;
            pos=pos/2;
        }
    }
}

bool Heap::esVacio() const
{
    return ultimo==0;
}

void Heap::eliminarRaiz()
{
    if(!esVacio()){
        arreglo[1]=arreglo[ultimo];
        int pos=1;
        ultimo--;
        bool continuar=true;
        while (((arreglo[pos]>arreglo[2*pos])|| (arreglo[pos]>arreglo[2*pos+1])) && (continuar==true))
        {
            if(arreglo[2*pos]<arreglo[2*pos+1])
            {
                int aux = arreglo[2*pos];
                arreglo[2*pos]=arreglo[pos];
                arreglo[pos]=aux;
                pos=2*pos;
            }
            else
            {
                if (2 * pos + 1 < ultimo)
                {
                    int aux = arreglo[2 * pos + 1];
                    arreglo[2 * pos + 1] = arreglo[pos];
                    arreglo[pos] = aux;
                    pos = 2 * pos + 1;
                }
                else
                {
                    continuar = false;
                }
            }
        }
    }
}

int Heap::raiz() const {
    if (!esVacio())
        return arreglo[1];
}


