#include <iostream>

using namespace std;

void invertir(unsigned int *A,int inicio,int fin){

    if(inicio < fin){
        unsigned int aux = A[inicio];
        A[inicio] = A[fin];
        A[fin] = aux;
        invertir(A,inicio = inicio + 1,fin = fin - 1);
    }
}

void aBinario(unsigned int num){

    if(num <= 1){
        cout<< 1;
    }else{
        aBinario(num/2);
        cout << num%2;
    }

}

void mostrar(unsigned int *A,int n){

    for(int i=0;i<5;i++){
        cout<<"["<<A[i]<<"] ";
    }
}

int main()
{
    aBinario(8);

    return 0;
}
