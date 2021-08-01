#ifndef HEAP_H
#define HEAP_H


class Heap {
    public: Heap(int n);
        void agregarH(int e);
        bool esVacio()const;
        void eliminarRaiz();
        int raiz()const;

    private:
        int * arreglo;
        int ultimo;
        int cantidad;
};

#endif // HEAP_H
