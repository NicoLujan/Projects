#ifndef CIRCULO_H
#define CIRCULO_H
#include<Punto.h>
#include<Segmento.h>


class Circulo
{
    public:
        Circulo(Punto&,Segmento&);
        Punto centro() const;
        float radio() const;
        float diametro() const;
        void trasladarC(float,float);
        bool operator==(Circulo&) const;
        bool pertenece(Punto&) const;
        virtual ~Circulo();

    protected:

    private:
        Punto c; //centro del circulo
        Segmento r; // radio del circulo
};

#endif // CIRCULO_H
