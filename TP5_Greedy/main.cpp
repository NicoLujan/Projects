#include <iostream>

using namespace std;

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

void CambioMoneda (int Arreglo[],int solucion[], int fin, int monto){

    quicksort(Arreglo,0,fin); //  Ordeno el arreglo por la moneda de mayor valor de manera descendente.

    int i=fin;
    int cantidad= 0;

    while ((i>=0) && (monto>0)){
        if(Arreglo[i]<=monto){
            cantidad++;
            monto =- Arreglo[i];
            solucion[i]=cantidad;
        }else{
            cantidad= 0;
            i--;
        }
    }
}

struct objeto{
    float peso;
    float valor;
    float ganancia;
};

void Mergeobj (objeto Arreglo[],int inicio, int medio, int fin){
    int k;
    int i=inicio; //para el arr
    int f= inicio; // para Arreglo de parametro
    int j= medio+1;
    objeto arr[fin];

    while ((f<=medio) && (j<=fin)){
        if(Arreglo[f].ganancia<=Arreglo[j].ganancia){
            arr[i]= Arreglo[f];
            f++;
        }else{
            arr[i]=Arreglo[j]; j++;
        }

        i++;
    }

    if(f<=medio){
        for (f;f<=medio;f++){
            arr[i]= Arreglo[f];
            i++;
        }
    }

    if(j<=fin){
        for (j;j<=fin;j++){
            arr[i]=Arreglo[j];
            i++;
        }
    }

    for (k=inicio;k<=fin; k++){
        Arreglo[k]=arr[k];
    }
}

void mergesortObj (objeto Arreglo[],int inicio, int fin){
    if (inicio<fin){
        int medio= (inicio+fin)/2;
        mergesortObj(Arreglo,inicio,medio);
        mergesortObj(Arreglo,medio+1,fin);
        Mergeobj(Arreglo,inicio,medio,fin);
    }
}

void mochila(objeto entrada[], objeto solucion[],int inicio, int fin, int limite){

    mergesortObj(entrada,0,fin); //Ordeno el arreglo de objeto con mayor ganancia por unidad de peso. B/P
    int i=fin;
    while((i>=0) && (limite>0)){
        if(entrada[i].peso<=limite) {
            solucion[i]= entrada[i];
            limite=limite-entrada[i].peso;
            i--;
        }

        if(entrada[i].peso>limite){
            entrada[i].peso= (limite/entrada[i].peso)*10;
            limite= limite-entrada[i].peso;
            solucion[i]= entrada[i];
        }
    }
}

struct proceso
{
    int tiempo;
    string nombre;
};

void Mergepro (proceso Arreglo[],int inicio, int medio, int fin){
    int k;
    int i=inicio; //para el arr
    int f= inicio; // para Arreglo de parametro
    int j= medio+1;
    proceso arr[fin];

    while ((f<=medio) && (j<=fin)){
        if(Arreglo[f].tiempo<=Arreglo[j].tiempo){
            arr[i]= Arreglo[f];
            f++;
        }else{
            arr[i]=Arreglo[j];
            j++;
        }
        i++;
    }

    if(f<=medio){
        for (f;f<=medio;f++){
            arr[i]= Arreglo[f];
            i++;
        }
    }

    if(j<=fin){
        for (j;j<=fin;j++){
            arr[i]=Arreglo[j];
            i++;
        }
    }

    for (k=inicio;k<=fin; k++){
        Arreglo[k]=arr[k];
    }
}

void mergesortpro (proceso Arreglo[],int inicio, int fin){
    if (inicio<fin){
        int medio= (inicio+fin)/2;
        mergesortpro(Arreglo,inicio,medio);
        mergesortpro(Arreglo,medio+1,fin);
        Mergepro(Arreglo,inicio,medio,fin);
    }
}

void procesos(proceso entrada[],proceso solucion[], int n, int fin){

    mergesortpro(entrada,0,fin); //ordeno por orden creciente el tiempo de los procesos a ejecutarse

    int i=0;
    while (i<=n){
        solucion[i]= entrada[i];
        i++;
    }
}

struct actividad{
    int inicio;
    int fin;
};

void Mergeact (actividad Arreglo[],int inicio, int medio, int fin){
    int k;
    int i=inicio; //para el arr
    int f= inicio; // para Arreglo de parametro
    int j= medio+1;
    actividad arr[fin];

    while ((f<=medio) && (j<=fin)){
        if((Arreglo[f].inicio*(Arreglo[f].fin-Arreglo[f].inicio))<=((Arreglo[j].inicio*(Arreglo[j].fin-Arreglo[j].inicio)))){
            arr[i]= Arreglo[f];
            f++;
        }else{
            arr[i]=Arreglo[j];
            j++;
        }

        i++;
    }

    if(f<=medio){
        for (f;f<=medio;f++) {
            arr[i]= Arreglo[f];
            i++;
        }
    }

    if(j<=fin) {
        for (j;j<=fin;j++){
            arr[i]=Arreglo[j];
            i++;
        }
    }

    for (k=inicio;k<=fin; k++) {
        Arreglo[k]=arr[k];
    }
}

void mergesortact (actividad Arreglo[],int inicio, int fin){
    if (inicio<fin) {
        int medio= (inicio+fin)/2;
        mergesortact(Arreglo,inicio,medio);
        mergesortact(Arreglo,medio+1,fin);
        Mergeact(Arreglo,inicio,medio,fin);
    }
}

void compatibles (actividad entrada[],actividad solucion[],int fin){

    mergesortact(entrada,0,fin); //ordena entrada según el tiempo de finalización de las actividades en forma creciente

    int i=0;
    int j=0;
    int horafin= entrada[i].fin;
    solucion[j]= entrada[i];
    i++;
    j++;

    while(i<=fin){
        if (horafin<=entrada[i].inicio){
            solucion[j]=entrada[i];
            horafin=entrada[i].fin;
            j++;
        }

        i++;
    }
}

int Planificar_tareas (int p[], int J[], int n){

    quicksort(p,0,n-1); //las tareas se ordenan decrecientemente según sus valores de ganancia

    //retorna la cantidad de elementos (k) de la solución
    //factible y la solución en los k primeros elementos J
    p[0]=0; J[0]=0;

    J[1]=1; // la tarea 1 siempre se selecciona

    int k=1; // la variable k dice cuántas tareas están ya en la planificación

    for (int i=2; i<=n;i++){ //tareas restantes tomadas en orden decreciente de g

        int r=k;
        while( (p[J[r]] > p[i]) && (p[J[r]] != r))
            r--;

        if ((p[J[r]] <= p[i]) && (p[i] > r)){
            for (int q = k; q >= (r+1); q--){
                J[q+1] = J[q];
                J[r+1] = i;
                k++;
            }
        }
    }

    return k;
}

int main()
{
    int f(){
    }

    return 0;
}
