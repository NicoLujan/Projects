#ifndef PUNTO_H
#define PUNTO_H


class Punto
{
    public:
        Punto(float,float);
        Punto();
        float CoordX() const;
        float CoordY() const;
        void trasladar(float,float);
        bool operator ==(const Punto&) const;
        void operator =(const Punto&);
        bool operator !=(const Punto&) const;
        float distancia(const Punto&) const;
        virtual ~Punto();

    protected:

    private:
        float x,y;
};

#endif // PUNTO_H
