#include "Punto.h"
#include "math.h"

Punto::Punto(float x, float y)
{
    this->x = x;
    this->y = y;
}

Punto::Punto()
{
    this->x = 0;
    this->y = 0;
}

float Punto::CoordX() const
{
    return this->x;
}

float Punto::CoordY() const
{
    return this->y;
}

bool Punto::operator==(const Punto & P) const
{
    return ((this->CoordX() == P.CoordX()) && (this->CoordY() == P.CoordY()));
}

bool Punto::operator!=(const Punto & P) const
{
    return ((this->CoordX() != P.CoordX()) || (this->CoordY() != P.CoordY()));
}

void Punto::operator=(const Punto & P)
{
    this->x = P.CoordX();
    this->y = P.CoordY();
}

float Punto::distancia(const Punto & p) const
{
    return sqrt(pow(this->CoordX() - p.CoordX(),2) + pow(this->CoordY() - p.CoordY(),2));
}

void Punto::trasladar(float x,float y)
{

    this->x+=x;
    this->y+=y;
}

Punto::~Punto()
{
    //dtor
}
