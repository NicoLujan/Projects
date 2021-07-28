#ifndef SEGMENTO_H
#define SEGMENTO_H
#include <Punto.h>


class Segmento
{
    public:
        Segmento(Punto&,Punto&);
        Segmento();
        Punto extremo1() const;
        Punto extremo2() const;
        void trasladar(float,float);
        float longitudS() const;
        bool operator==(Segmento&)const;
        virtual ~Segmento();

    protected:

    private:
        Punto ext1,ext2;
};

#endif // SEGMENTO_H
