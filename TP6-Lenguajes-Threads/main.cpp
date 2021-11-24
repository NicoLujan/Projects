#include <iostream>
#include <thread>
#include <mutex>

using namespace std;

//Ejercicio numero 4

mutex mtx2;
void Ej4(int id){
    int j = 0;
    if (j<10){
        mtx2.lock();
        printf("id : %d, j: %d \n",id,j);
        j++;
        mtx2.unlock();
        Ej4(id+1);
    }
}

//Ejercicio numero 3

mutex mtx1;

void Ej3(int id){
    static thread_local int j = 0;
    printf("id : %d, j: %d \n",id,j);
    j++;
}

//Ejercicio numero 2
static int m;

void Ej2(int id){
    int j=4;
    static thread_local int k=4;
    static int l = 4;
    printf("id : %d, &j: %d, &k: %d, &l: %d, &j-&k: %d, &j-&l: %d, &k-&l:%d\n",id,&j,&k,&l,(&j-&k),(&j-&l),(&k-&l));
    printf("&l-&m : %d, \n",(&l-&m));
    k--;
    if (k>0)
        Ej2(id+1);
}

//Ejercicio numero 1
void Ej1(int id){
    static int j=4;
    printf("id : %d, j: %d, &j: %d\n",id, j, &j);
    for (int i=0;i<1000;i++);
    j--;
    if (j>0)
        Ej1(id+1);
}

int main (int argc, char *argv[]){
/*
    thread th1(Ej4,100);
    thread th2(Ej4,200);
    thread th3(Ej4,300);
    thread th4(Ej4,400);

    th1.join();
    th2.join();
    th3.join();
    th4.join();

*/

    int static a;

    cout<<&a;

    return 0;
}
