#ifndef CONJUNTO_H
#define CONJUNTO_H
#include "Lista.h"
template <typename E>
class Conjunto
{
    public:
        Conjunto();
        void agregarC(E elem);
        bool esVacio() const;
        void eliminarC(E elem);
        bool perteneceC(const E elem) const;
        int CantidadC() const;
        void interseccionC(const Conjunto & otroC);
        void unionC(const Conjunto & otroC);

    private:
        struct Nodo
        {
            E elem;
            Nodo*sig;
        };

        Nodo*primero;
        int cantidad;
};

#endif // CONJUNTO_H
