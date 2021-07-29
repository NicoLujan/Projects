#include "Circulo.h"

Circulo::Circulo(Punto & centro,Segmento & radio)
{
    if(centro == radio.extremo1() || centro == radio.extremo2())
    {
        this->c = centro;
        this->r = radio;
    }
}

Punto Circulo::centro() const
{
    return this->c;
}

float Circulo::radio() const
{
    return this->r.longitudS();
}

float Circulo::diametro() const
{
    return this->r.longitudS()*2;
}

void Circulo::trasladarC(float x, float y)
{
    this->c.trasladar(x,y);
    this->r.trasladar(x,y);
}

bool Circulo::operator==(Circulo & otroCirculo) const
{
    return((this->centro() == otroCirculo.centro()) && (this->diametro() == otroCirculo.diametro()));
}

bool Circulo::pertenece(Punto & punto) const
{
    return(this->radio() >= punto.distancia(this->centro()));
}

Circulo::~Circulo()
{
    //dtor
}
