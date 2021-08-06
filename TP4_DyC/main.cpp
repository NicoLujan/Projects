#include <iostream>

using namespace std;

using namespace std;
void merge(int *,int, int , int );
void merge_sort(int *arr, int menor, int mayor)
{
    int medio;
    if (menor < mayor){
        //divide the array at mid and sort independently using merge sort
        medio=(menor+mayor)/2;
        merge_sort(arr,menor,medio);
        merge_sort(arr,medio+1,mayor);
        //merge or conquer sorted arrays
        merge(arr,menor,mayor,medio);
    }
}
// Merge sort
void merge(int *arr, int menor, int mayor, int medio)
{
    int i, j, k, c[50];
    i = menor;
    k = menor;
    j = medio + 1;
    while (i <= medio && j <= mayor) {
        if (arr[i] < arr[j]) {
            c[k] = arr[i];
            k++;
            i++;
        }
        else  {
            c[k] = arr[j];
            k++;
            j++;
        }
    }
    while (i <= medio) {
        c[k] = arr[i];
        k++;
        i++;
    }
    while (j <= mayor) {
        c[k] = arr[j];
        k++;
        j++;
    }
    for (i = menor; i < k; i++)  {
        arr[i] = c[i];
    }
}

void imprimir (int Arreglo[], int n){
    for(int i=0;i<n;i++){
        cout<<"[ "<<Arreglo[i]<<" ]";
    }
}

int particion (int Arreglo[], int inicio, int fin){
    int aux;
    int i= inicio;
    int j= fin;
    int pivot= Arreglo[inicio];

    while(i<j){

        while(Arreglo[i]<=pivot)
            i++;

        while(Arreglo[j]>pivot)
            j--;

        if (i<j){
            aux= Arreglo[j];
            Arreglo[j]= Arreglo[i];
            Arreglo[i]= aux;
        }
    }

    aux= Arreglo[j];
    Arreglo[j]= pivot;
    Arreglo[inicio]= aux;

    return j;
}
void quicksort (int Arreglo[], int inicio, int fin){

    if (inicio<fin){
        int pivot= particion (Arreglo,inicio,fin);
        quicksort(Arreglo,inicio,pivot-1);
        quicksort(Arreglo,pivot+1,fin);
    }

}

int busquedaIndice(int * Arreglo,int inic,int fin){

    if (inic+1==fin){

        if(Arreglo[inic]==inic){
            return inic;
        }

        if(Arreglo[fin]==fin){
            return fin;
        }

        return -1;
    }else{
        int medio= (inic+fin)/2;

        if(Arreglo[medio]==medio){
                return medio;
        }

        if(Arreglo[medio]>medio){
            medio = busquedaIndice(Arreglo,inic,medio);
        }else{
            medio = busquedaIndice(Arreglo,medio,fin);
        }

        return medio;
    }
}

void MaxyMin( int Arreglo[],int & MAX, int & MIN, int fin){
    int aux1=Arreglo[0];
    int aux2=Arreglo[0];
    for (int i=0; i< fin; i++){
        if (Arreglo[i]<=aux1){
            aux1= Arreglo[i];
        }

        if (Arreglo[i]>=aux2){
            aux2= Arreglo[i];
        }
    }

    MAX=aux2;
    MIN=aux1;
}

int encontrar_indice(int ar[], int inicio, int fin){

    if(inicio <= fin){
        int medio = (inicio + fin) / 2;

        if(ar[medio] == medio){
            return medio;
        }else{
            if(ar[medio] < medio){
                return encontrar_indice(ar, medio + 1, fin);
            }else{
                return encontrar_indice(ar, inicio, medio);
            }
        }
    }else{
        return -1;
    }
}
void DivideMAXMIN (int Arreglo[], int inicio, int fin, int & MAX, int &MIN){
    if (inicio==fin){
        MAX= Arreglo[inicio];
        MIN= MAX;
    }else{
        if(inicio==fin-1){
            if(Arreglo[inicio]>Arreglo[fin]){
                MAX= Arreglo[inicio];
                MIN= Arreglo[fin];
            }else{
                MIN= Arreglo[inicio];
                MAX= Arreglo[fin];
            }
        }else{
            int maxx=Arreglo[inicio];
            int minn=Arreglo[inicio];
            int medio= (fin+inicio)/2;
            DivideMAXMIN(Arreglo,inicio,medio,MAX,MIN);
            DivideMAXMIN(Arreglo,medio+1,fin,maxx,minn);
            if (maxx>MAX)
                MAX= maxx;
            if (minn<MIN){
                MIN=minn;
            }
        }
    }
}

int sumCombinada(const int *pInt, int i, int j, int m,int & inicio, int & fin) {
    int sumaIzq = INT16_MIN;
    int suma = 0;

    for (int k = m; k >=i; k--) {
        suma += pInt[k];
        if(suma > sumaIzq) {
            sumaIzq = suma;
            inicio = k;
        }
    }

    int sumaDer = INT16_MIN;
    suma = 0;
    for (int k = m+1; k <= j; k++) {
        suma += pInt[k];
        if(suma > sumaDer) {
            sumaDer = suma;
            fin = k;
        }
    }

    return sumaIzq+sumaDer;
}

int subArrMax(int*a, int i, int j,int & inicio, int & fin) {
    if (i == j) {
        return a[i];
    } else {
        int m = (i + j) / 2;
        int maxSumIzq = subArrMax(a, i, m,inicio,fin);
        int maxSumDer = subArrMax(a, m + 1, j,inicio,fin);
        int maxSumCombinada = sumCombinada(a, i, j, m,inicio,fin);

        if (maxSumIzq > maxSumDer && maxSumIzq > maxSumCombinada)
            return maxSumIzq;

        if (maxSumDer >= maxSumIzq && maxSumDer >= maxSumCombinada)
            return maxSumDer;
        else
            return maxSumCombinada;
    }
}

int main()
{
    int myArray[] = {-4,-1,0,1,3,4,6,9,10};

    int min,max,inic,fin;

    DivideMAXMIN(myArray,0,8,max,min);


    cout<<subArrMax(myArray,0,8,inic,fin);
}



