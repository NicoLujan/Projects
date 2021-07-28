#include <iostream>

using namespace std;

bool pertenece(int *a, int n,int num);
void mayoria(unsigned int *a,int n);
int Potencia(int base, int exponente);

/* BubleSort
int main() {

   int num, aux;
   int comparaciones = 0;
   int intercambios = 0;
   int* arreglo;
   cout << "Cuantos numeros seran: ";
   cin >> num;
   arreglo = new int[num];
   cout << endl << "***CAPTURA DE NUMEROS***" << endl;

   for(int x = 0; x < num; x++) {
      cout << "Ingresa el numero " << x << " de la serie: ";
      cin >> arreglo[x];
      cout << endl;
   }
   cout << "***MUESTRA DE NUMEROS***" << endl;

   for(int y = 0; y < num; y++) {
      cout << "Numero " << y << ".- " << arreglo[y] << endl;
   }

   for(int z = 1; z < num; ++z) {
      for(int v = 0; v < (num - z); v++) {
         comparaciones++;
         if(arreglo[v] > arreglo[v+1]){
            aux = arreglo[v];
            arreglo[v] = arreglo[v + 1];
            arreglo[v + 1] = aux;
            intercambios++;
         }
      }
    }

   cout << "***NUMEROS ARREGLADOS***" << endl;

   for(int w = 0; w < num; w++) {
      cout << "Numero " << w << ".- " << arreglo[w] << endl;
   }

   cout << "Numero de comparaciones: " << comparaciones << endl;
   cout << "Numero de intercambios: " << intercambios << endl;

   delete[] arreglo;
   return 0;
}*/

/* SelectionSort
void ordena(int a[5])
{
    for(int i=0;i<5;i++)
    {
        for (int j=i;j<5;j++)
        {
            if (a[i] > a[j])
            {
                int aux = a[j];
                a[j] = a[i];
                a[i] = aux;
            }
        }
    }
}

int main()
{
    int a[5];
    for (int i=0;i<5;i++)
    {
        cout << "Ingrese el " << i <<"º elemento" << endl;
        cin >> a[i];
        cout << "\n\n";
    }
    ordena(a);
    cout << "Lista ordenada" << endl;
    for(int i=0; i < 5; i++)
    {
        cout << a[i] << endl;
    }
    return 1;
}*/

int main()
{
    cout<<7%2;

    return 0;
}

bool pertenece(int *arreglo,int n,int num){

    for(int i=0;i<n;i++){
        if(arreglo[i] == num)
            return true;
    }

    return false;
}

void mayoria(unsigned int *arreglo,int n){

    int contador;
    bool flag = false;
    unsigned int mayoria = 0;

    for(int i=0;i<n;i++){
        unsigned int aux = arreglo[i];
        if (flag == false){
            for(int j=0;j<n;j++){
                if((j != i) && (aux == arreglo[j])){
                    contador++;
                }
            }
            if(contador >= (n/2)){
                flag = true;
                mayoria = aux;
            }else{
                contador = 0;
            }
        }
    }


    if(flag == true){
        cout<<"El elemento mayoria es: "<<mayoria<<"\n";
    }else{
        cout<<"No existe un elemento mayoria en el arreglo.\n";
    }
}

int Potencia(int base, int exponente)
{
    float resultado = 1;
    int iterador = exponente;

    while(iterador > 0){
        resultado *= base;
        iterador--;
    }

    return resultado;
}
