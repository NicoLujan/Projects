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

int main()
{
    int myArray[] = {-4,-1,0,1,3,4,6,9,10};

    cout<<busquedaIndice(myArray,0,8);
}



