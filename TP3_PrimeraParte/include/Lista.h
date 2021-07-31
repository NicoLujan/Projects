#ifndef LISTA_H
#define LISTA_H

template <typename E>
class Lista
{
    public:
        Lista();
        float longLista() const;
        E recuperarElemento(int pos) const;
        void agregarLista(int pos, E elem);
        void eliminarLista(int pos, E elem);
        bool pertenece(const E elem) const;

    protected:

    private:
        struct Nodo
        {
            E elem;
            Nodo*sig;
        };

        Nodo*primero;

        int cantidad;

};

#endif // LISTA_H
