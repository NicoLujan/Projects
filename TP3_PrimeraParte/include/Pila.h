#ifndef PILA_H
#define PILA_H

template <typename T>
class Pila
{
    public:
        Pila();
        void agregarP(const T&);
        const T tope() const;
        bool esVacia() const;
        unsigned int cantElementos() const;
        void eliminarP();
        virtual ~Pila();

    protected:

    private:
        struct Nodo{
            T elemento;
            Nodo * anterior;
        };

        void vaciar();

        Nodo * primero;

        unsigned int cantElem;
};


#endif // PILA_H

