#include <iostream>
#include<stdio.h>
#include<stdlib.h>

using namespace std;

float suma(float,float);
float multiplicacion(float,float);
float division(float,float);

int main()
{
    /*int input=1,contador=0;
    float media=0,suma=0;
    while(input>0){
            cout<<"Ingrese un numero: "<<"\n";
            cin>>input;
            suma+=input;
            contador++;
            media=suma/contador;
            cout<<"La suma hasta el momento es de: "<<suma<<"\n";
            cout<<"La media hasta el momento es de: "<<media<<"\n\n";
    }
    cout<<"La suma final es de: "<<suma<<"\n";
    cout<<"La media final es de: "<<media<<"\n";*/

    /*int numero1,numero2;

    cout<<"Ingrese un numero: "<<"\n";
    cin>>numero1;
    cout<<"Ingrese otro numero: "<<"\n";
    cin>>numero2;

    if(numero1>numero2){
        int aux=numero2;
        numero2=numero1;
        numero1=aux;
    }

    system("cls");

    for(numero1;numero1<=numero2;numero1++){
        cout<<numero1<<"\n";
    }*/

    float n1,n2;

    cout<<"Ingrese un numero"<<"\n";
    cin>>n1;
    cout<<"Ingrese otro numero"<<"\n";
    cin>>n2;

    cout<<"La suma es: "<<suma(n1,n2);
    cout<<"La multiplicacion es: "<<multiplicacion(n1,n2);
    cout<<"La division es: "<<division(n1,n2);

}

float suma(float f1,float f2){
    return f1+f2;
}
float multiplicacion(float f1,float f2){
    return f1*f2;
}
float division(float f1,float f2){
    return f1/f2;
}
