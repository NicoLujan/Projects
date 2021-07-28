#include <iostream>

using namespace std;

void imprimir(int[],int);
void imprimir(int);
void modificar(int[],int);
void modificar(int&);
int factorial(int);

int main()
{
    int numero[] = {1,2,3,4,5};

    cout<<numero;
    return 0;
}

void imprimir(int arreglo[],int tam){
    cout<<"Arreglo:\n";
    for(int i=0;i<tam;i++){
        cout<<arreglo[i]<<" ";
    }
    cout<<"\n";
}

void modificar(int arreglo[],int tam){

    for(int i=0;i<tam;i++){
        arreglo[i] = arreglo[i] + tam;
    }
}

void imprimir(int num){
    cout<<"Numero: "<<num<<"\n";
}

void modificar(int & num){

    num = 123;
}

int factorial(int numero) {
    if (numero == 0)
        return 1;
    else
        return (numero * factorial(numero-1));
 }
