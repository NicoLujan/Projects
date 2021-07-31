#include "Lista.h"
#include <iostream>
#include<cassert>

template <typename E>
Lista<E>::Lista()
{
    cantidad=0;
    primero= NULL;
}

template <typename E>
float Lista<E>:: longLista() const
{
    return cantidad;
}

template<typename E>
E Lista<E>::recuperarElemento(int pos)const
{
    assert(!(pos > longLista()));
    Nodo * actual =primero;
    int posicion = 0;

    while(posicion<pos)
    {
        actual=actual->sig;
        posicion++;
    }

    return actual->elem;
}

template <typename E>
bool Lista<E>:: pertenece(const E elem) const
{
    if (primero==NULL)
        return false;

    Nodo*actual= primero;

    if (actual->elem == elem)
        return true;
    else
    {
        int pos= 0;
        while((actual->elem!=elem) &&(actual!=NULL))
        {
            actual=actual->sig;
            pos++;
        }
        if(actual==NULL)
            return false;
        else
            return true;
    }
}

template <typename E>
void Lista<E>::agregarLista(int pos,E elem)
{
    assert(!(pos > longLista()+1));
    Nodo * nuevoNodo = new Nodo();
    nuevoNodo->elem = elem;
    nuevoNodo->sig = NULL;
    if(primero == NULL)
        primero = nuevoNodo;
    else
    {
        int posicion = 0;
        Nodo * actual = primero;
        if(posicion == pos)
        {
            nuevoNodo->sig = actual;
            primero = nuevoNodo;
        }
        else
        {
            while(posicion < pos-1)
            {
                actual = actual->sig;
                posicion++;
            }
            nuevoNodo->sig = actual->sig;
            actual->sig=nuevoNodo;
        }
    }

    cantidad++;
}

template<typename E>
void Lista<E>::eliminarLista(int pos,E elem)
{
    assert(!(pos > longLista()));
    if(primero!=NULL)
    {
        int posicion=0;
        Nodo * actual= primero;
        while ((posicion<pos-1) && (pos< cantidad))
        {
            actual=actual->sig;
            posicion++;
        }
        if((pos==0) && (actual->elem==elem))
        {
            primero=actual->sig;
            delete actual;
        }
        else
        {
            Nodo*aux= actual->sig;
                if(actual->sig->elem==elem)
                {
                    actual->sig= aux->sig;
                    delete aux;
                }
        }
    }

    cantidad= cantidad-1;
}

template class Lista<int>;






