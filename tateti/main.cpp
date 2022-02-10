#include <iostream>
#include<stdlib.h>
#include<stdio.h>
using namespace std;

int quienArranca(){
    return rand()%101;
}

void gamePVP(){
    int jugador1=1,jugador2=2,contador=0,arranca=0;
    char tablero[3][3];

    cout<<"Veamos quien comienza...";
    int comienza=quienArranca();

    system("pause");
    system("cls");

    if(comienza<51){
        cout<<"Arranca el jugador numero 1";
        arranca=1;
    }else{
        cout<<"Arranca el jugador numero 2";
        arranca=2;
    }

    system("cls");

}

int main()
{
    int input=0;
    while(true){
        cout << "----------------------------------------------------Menu Principal-----------------------------------------------------" << endl;
        cout<<"1.Jugar vs la computador"<<"\n";
        cout<<"2.Jugar vs otro jugador"<<"\n";

        cin>>input;

        switch(input){
            case 1: break;//gamePVE;
            case 2: gamePVP(); break;//gamePVP;
            default: cout<<"Usted presiono: "<<input<<"\nPor favor, ingrese una opcion valida"<<"\n";
        }
        system("pause");
        system("cls");
    }
    return 0;
}
