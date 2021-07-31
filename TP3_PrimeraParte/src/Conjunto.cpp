#include "Conjunto.h"
#include "Lista.h"
#include <iostream>

template <typename E>
Conjunto<E>::Conjunto()
{
    primero=NULL;
    cantidad=0;
}

template <typename E>
void Conjunto<E>:: agregarC (E elem)
{
    if (!perteneceC(elem))
    {
        Nodo * nuevoNodo= new Nodo();
        nuevoNodo->elem=elem;
        nuevoNodo->sig= NULL;
        if (primero==NULL)
            primero=nuevoNodo;
        else
        {
            Nodo * actual= primero;
            while (actual->sig!=NULL)
            {
                actual= actual->sig;
            }
            actual->sig = nuevoNodo;
        }
        cantidad++;
    }
}

template<typename E>
bool Conjunto<E>::esVacio()const
{
    if(cantidad==0)
        return true;
    else
        return false;
}

template <typename E>
void Conjunto<E>::eliminarC(E elem)
{
    Nodo * aux = primero;
    if(aux->elem == elem)
    {
        primero = primero->sig;
        delete aux;
    }
    else
    {
        while(aux->sig->elem != elem)
            aux = aux->sig;
        Nodo * aux2 = aux->sig;
        if(aux2->elem == elem)
        {
            aux->sig = aux2->sig;
            delete aux2;
        }
    }
}

template <typename E>
bool Conjunto<E>::perteneceC(const E elem) const
{
    Nodo * aux = primero;
    while(aux->elem != elem)
    {
        aux = aux->sig;
    }

    if(aux->elem == elem)
        return true;
    else
        return false;
}

template <typename E>
int Conjunto<E>:: CantidadC() const
{
    return cantidad;
}

/*
template <typename E>
void Conjunto<E>:: interseccionC(const Conjunto & otroC)
{
    Nodo * aux=primero;
    while (aux!=NULL)
    {
        if (!otroC.pertenece(aux->elem))
        {
            Nodo * aux2= aux;
            aux= aux->sig;
            eliminarC(aux2->elem);
        }
        else
        {
            aux= aux->sig;
        }
    }
}

template <typename E>
void Conjunto<E>:: unionC(const Conjunto & otroC) const
{
    Nodo * aux=primero;
    while (aux!=NULL)
    {
        if (!otroC.pertenece(aux->elem))
        {
        }
}*/

template class Conjunto<char>;
template class Conjunto<int>;
template class Conjunto<unsigned int>;
template class Conjunto<std::string>;

