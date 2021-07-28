#include "Segmento.h"
#include <iostream>

using namespace std;


Segmento::Segmento(Punto & p1,Punto & p2)
{
    if(p1 != p2){
        this->ext1 = p1;
        this->ext2 = p2;
    }
}

Segmento::Segmento()
{
    Punto P1(0,0);
    Punto P2(1,0);

    this->ext1 = P1;
    this->ext2 = P2;
}

Punto Segmento::extremo1() const
{
    return this->ext1;
}

Punto Segmento::extremo2() const
{
    return this->ext2;
}

void Segmento::trasladar(float x, float y)
{
    this->ext1.trasladar(x,y);
    this->ext2.trasladar(x,y);
}

float Segmento::longitudS() const
{
    return (this->ext1.distancia(ext2));
}

bool Segmento::operator==(Segmento & otroSegmento) const
{
    return(((otroSegmento.extremo1() == this->extremo1()) && (otroSegmento.extremo2() == this->extremo2())) || ((otroSegmento.extremo1() == this->extremo2()) && (otroSegmento.extremo2() == this->extremo1())));
}

Segmento::~Segmento()
{
    //dtor
}
