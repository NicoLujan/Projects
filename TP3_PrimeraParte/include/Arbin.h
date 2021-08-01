#ifndef PRUEBA_ARBIN_H
#define PRUEBA_ARBIN_H
#include "Lista.h"
#include "list"
template <typename T>
class Arbin {
    protected:
        class NodoArbol{
            public:
                NodoArbol(const T & elemento, Arbin* t1, Arbin* t2) { elem = elemento; l = t1; r = t2;}
                const T & obtenerElemento()const { return elem;}
                Arbin* hijoIzq()const{ return l;}
                Arbin* hijoDer()const{ return r;}
            private:
                T elem;
                Arbin* l;
                Arbin* r;
        };

        void vaciar(Arbin* raiz);

    public:
        Arbin();
        Arbin(const Arbin& arbol);
        void Crear(const Arbin*t1, const Arbin*t2, const T& elemento);
        ~Arbin();
        bool vacio()const;
        const T & raiz()const;
        Arbin* izq()const;
        Arbin* der()const;
        bool existe(const T & elemento)const;
        int cantNodos()const;
        bool esHoja()const;
        Arbin & operator= (const Arbin & arbol);
// CONSIGNAS DE EJERCITACION//
        void indorder()const;
        void preorder()const;
        void postorder()const;
        int suma(int & resultado)const;
        void nodosimpares(int contador)const;
        void menorymayor(int & menor, int & mayor);
        void maximadif(int & hijo1, int & dif);
        void ramaliviana(std::list<int> & solucion,std::list<int> & auxiliar);
        void fronterarecursiva(std::list<int> solucion );
        void fronteraiterativa(std::list<int> solucion );

    protected:
        NodoArbol* primero;
        int contador;
};
#endif //PRUEBA_ARBIN_H
