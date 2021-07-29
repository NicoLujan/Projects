#include "Pila.h"
#include "iostream"
#include <assert.h>
#include <cassert>

using namespace std;

template <typename T>
Pila<T>::Pila()
{
    primero = NULL;
    cantElem = 0;
}

template <typename T>
void Pila<T>::agregarP(const T & elemento)
{
    Nodo * aux = new Nodo;
    aux->elemento = elemento;
    aux->anterior = primero;

    primero = aux;
    cantElem++;
}

template <typename T>
const T Pila<T>::tope() const
{
    assert(!esVacia());
    return (primero->elemento);
}

template <typename T>
bool Pila<T>::esVacia() const
{
    return (primero == NULL);
}

template <typename T>
unsigned int Pila<T>::cantElementos() const
{
    return (cantElem);
}

template <typename T>
void Pila<T>::eliminarP()
{
    assert(!esVacia());
    Nodo * aux = this->primero;
    this->primero = aux->anterior;

    delete aux;
    this->cantElem--;
}

template <typename T>
void Pila<T>::vaciar(){

    while (primero != NULL){
        Nodo * aux = this->primero;
        this->primero = aux->anterior;
        delete aux;
    }
}

template <typename T>
Pila<T>::~Pila()
{
    vaciar();
}

template class Pila<int>;

