#include "Arbin.h"
#include <cassert>
#include <iostream>
#include <stack>

using namespace std;
template<typename T>
Arbin<T>::Arbin() {
    primero = nullptr;
    contador=0;
}

template<typename T>
Arbin<T>::Arbin(const Arbin<T> & arbol) {
    primero= nullptr;
    contador=arbol.contador;
    this->operator=(arbol);
}

template<typename T>
void Arbin<T>::Crear(const Arbin<T> *t1, const Arbin<T> *t2, const T & elemento)
{
    Arbin* izquierda = new Arbin(*t1);
    Arbin* derecha = new Arbin(*t2);
    contador= t1->contador+t2->contador+1;
    primero= new NodoArbol(elemento,izquierda,derecha);
}

template<typename T>
Arbin<T>::~Arbin() {
    vaciar(this);
}
template<typename T>
bool Arbin<T>::vacio() const {
    return primero == nullptr;
}

template<typename T>
const T &Arbin<T>::raiz() const {
    assert(primero);
    return primero->obtenerElemento();
}

template<typename T>
int Arbin<T>::cantNodos() const {
    return contador;
}

template<typename T>
bool Arbin<T>::esHoja() const {
    assert(primero);
    return primero->hijoIzq()->contador == 0 && primero->hijoDer()->contador == 0;
}

template<typename T>
Arbin<T> & Arbin<T>::operator=(const Arbin & arbol) {
    vaciar(this);
    if(arbol.primero== nullptr)
    {
        primero= nullptr;
    }
    else
    {
        primero= new NodoArbol (arbol.primero->obtenerElemento(),
        arbol.primero->hijoIzq(), arbol.primero->hijoDer());
    }

    return *this;
}

template<typename T>
Arbin<T> *Arbin<T>::izq() const {
assert(primero);
return primero->hijoIzq();
}
template<typename T>
Arbin<T> *Arbin<T>::der() const {
assert(primero);
return primero->hijoDer();
}
template<typename T>
void Arbin<T>::vaciar(Arbin<T>* a1) {
if(a1->primero!= nullptr)
{
vaciar(a1->primero->hijoDer());
vaciar(a1->primero->hijoIzq());
delete a1->primero;
a1->primero= nullptr;
delete a1;
}
}
template<typename T>
bool Arbin<T>::existe(const T &elemento) const {
    return false;
}
template<typename T>
void Arbin<T>::preorder() const {
if (primero!=nullptr)
{
cout<<primero->obtenerElemento()<<endl;
primero->hijoIzq()->preorder();
primero->hijoDer()->preorder();
}
}
template<typename T>
void Arbin<T>::postorder() const {
if (primero!=nullptr)
{
primero->hijoIzq()->postorder();
primero->hijoDer()->postorder();
cout<<primero->obtenerElemento()<<endl;
}
}
template<typename T>
void Arbin<T>::indorder() const {
if (primero!=nullptr)
{
primero->hijoIzq()->indorder();
cout<<primero->obtenerElemento()<<endl;
primero->hijoDer()->indorder();
}
}
template<typename T>
int Arbin<T>::suma(int & resultado) const {
if (primero!=nullptr)
{
resultado= resultado+primero->obtenerElemento();
primero->hijoDer()->suma(resultado);
primero->hijoIzq()->suma(resultado);
}
return resultado;
}
template<typename T>
void Arbin<T>::nodosimpares(int contador) const {
if (primero!= nullptr)
{
contador++;
primero->hijoIzq()->nodosimpares(contador);
primero->hijoDer()->nodosimpares(contador);
if(contador%2 !=0 )
cout<<"contador de "<< primero->obtenerElemento()<<"es "<<
contador << endl;
}
}
template<typename T>
void Arbin<T>::menorymayor(int & menor, int & mayor) {
if(primero!= nullptr)
{
primero->hijoIzq()->menorymayor(menor,mayor);
primero->hijoDer()->menorymayor(menor,mayor);
if(primero->obtenerElemento()<menor)
{
menor= primero->obtenerElemento();
}
if(primero->obtenerElemento()>mayor)
{
mayor=primero->obtenerElemento();
}
}
}
template<typename T>
void Arbin<T>::maximadif(int & hijo1, int & dif) {
if(primero!= nullptr)
{
if ((esHoja()) && (hijo1!= -1))
{
int hijolocal= primero->obtenerElemento();
if(dif<abs(hijolocal-hijo1))
{
dif=abs(hijolocal-hijo1);
}
}
primero->hijoIzq()->maximadif(hijo1,dif);
primero->hijoDer()->maximadif(hijo1,dif);
if(esHoja()){
hijo1= primero->obtenerElemento();
}
}
}
template<typename T>
void Arbin<T>::fronterarecursiva(std::list<int> solucion ) {
if (primero== nullptr)
{
return;
}
else {
if (esHoja()) {
solucion.push_back(primero->obtenerElemento());
} else {
primero->hijoIzq()->fronterarecursiva(solucion);
primero->hijoDer()->fronterarecursiva(solucion);
}
}
}
template<typename T>
void Arbin<T>::fronteraiterativa(std::list<int> solucion) {
stack<NodoArbol*> aux;
aux.push(primero);
bool retroceder = false;
bool avanzar = true;
for (int i = 0; i < cantNodos(); ++i)
{
NodoArbol* tmp = aux.top();
if (tmp != nullptr){
if(esHoja()){
solucion.push_back(tmp->obtenerElemento());
retroceder = true;
avanzar = false;
aux.pop();
}else{
if(!retroceder && avanzar){
if (tmp->hijoIzq()!= nullptr)
aux.push(tmp->hijoIzq());
else
aux.push(tmp->hijoDer());
}else{
aux.pop();
retroceder = false;
avanzar = true;
}
}
}
}
}
