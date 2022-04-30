#include <iostream>
#include <cmath>
#include <cstdlib>
#include <ctime>

using namespace std;

const float EPSILON = 0.000005;
const int MIN = 1000;

int SacarSobre(){

    srand(time(NULL));
    float aleatorio = (float)(rand() % 101)/100;
    float prob_acum[] = {(float)30/50,100};


    for(int i=0;i<2;i++){
        if(aleatorio < prob_acum[i])
            return i;
    }

    return -1;
}

bool Converge(float prob_ant,float prob_act){

    if(abs(prob_ant-prob_act) < EPSILON)
        return true;

    return false;
}

int main()
{
    int muestras=0,exitos=0;
    float prob_act=0,prob_ant=-1;

    while ((not Converge(prob_ant,prob_act)) || (muestras < MIN)){
        int S1 = SacarSobre();
        int S2 = SacarSobre();

        if(S1 == 0 || S2 == 0)
            exitos++;

        muestras++;
        prob_ant=prob_act;
        prob_act= (float) exitos/muestras;
    }

    cout << prob_act;
}
