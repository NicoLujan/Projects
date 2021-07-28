#include <iostream>
#include <limits>
using namespace std;
const int LONG_STRING = 50;
const int EMPLEADOS = 100;
struct Empleado {
    int id;
    char nombre[LONG_STRING];
    char apellido[LONG_STRING];
    float salario;
};
struct Empleados {
    Empleado empleados[EMPLEADOS];
    int cantidad;
};

void ignorarLinea() {
    cin.ignore(numeric_limits<std::streamsize>::max(), '\n');
}
void cargarEmpleados(Empleados & emp) {
    int id = 1;
    while ((id != 0) && (emp.cantidad < EMPLEADOS)) {
        cout << "Ingresar id (0 para terminar):\n";
        cin >> id;
        ignorarLinea();
        if (id != 0) {
            int pos = emp.cantidad;
            emp.empleados[pos].id = id;
            cout << "Ingresar nombre:\n";
            cin.getline(emp.empleados[pos].nombre, LONG_STRING, '\n');
            cout << "Ingresar apellido:\n";
            cin.getline(emp.empleados[pos].apellido, LONG_STRING, '\n');
            cout << "Ingresar salario:\n";
            cin >> emp.empleados[pos].salario;
            ignorarLinea();
            emp.cantidad++;
        }
    }
}
void mostrarEmpleados(const Empleados & emp) {
    for (int i = 0; i < emp.cantidad; i++) {
        cout << emp.empleados[i].id << ", ";
        cout << emp.empleados[i].nombre << ", ";
        cout << emp.empleados[i].apellido << ", ";
        cout << emp.empleados[i].salario << "\n";
    }
}

//Ejemplo de escritura
void guardarEmpleadosTxt(ofstream & arch, const Empleados & emp) {
    for (int i = 0; i < emp.cantidad; i++) {
        arch << emp.empleados[i].id << "\n";
        arch << emp.empleados[i].nombre << "\n";
        arch << emp.empleados[i].apellido << "\n";
        arch << emp.empleados[i].salario << "\n";
    }
}
int main() {
    Empleados empleados;
    empleados.cantidad = 0;
    ofstream archSalida("prueba.txt", ios::trunc);
    if (archSalida.is_open()) {
        cargarEmpleados(empleados);
        guardarEmpleadosTxt(archSalida, empleados);
        archSalida.close();
    } else
        cout << "Error al crear el archivo de salida\n";

    return 0;
}

//Ejemplo de lectura
void cargarEmpleadosTxt(ifstream & arch, Empleados & emp) {
    int i = 0;
    int id;
    arch >> id;
    while (!arch.eof() && (i < EMPLEADOS)) {
        emp.empleados[i].id = id;
        arch >> emp.empleados[i].nombre;
        arch >> emp.empleados[i].apellido;
        arch >> emp.empleados[i].salario;
        i++;
        arch >> id;
    }
    emp.cantidad = i;
}
int main() {
    Empleados empleados;
    empleados.cantidad = 0;
    ifstream archEntrada("prueba.txt");
    if (archEntrada.is_open()) {
        cargarEmpleadosTxt(archEntrada, empleados);
        mostrarEmpleados(empleados);
        archEntrada.close();
    } else
        cout << "Error al abrir el archivo de entrada\n";
 return 0;
}

