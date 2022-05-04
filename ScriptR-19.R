# 1)Variables del enunciado:
#
#       X: Cantidad de pollos de la raza A
#       Y: Cantidad de pollos de la raza B
#
# 2)Función objetivo:
#
#   Beneficios(maximizar):
#
#       Z = X+(1,4)*Y
#
#   Siendo $1 el beneficio por unidad de pollos de la raza A y
#   siendo $1,4 el beneficio por unidad de los pollos de la raza B
#
# 3)Restricciones:
#
#   La cantidad de ambas razas de pollo debe ser mayor o igual a 0, entonces:
#       X>=0
#       Y>=0
#
#   Otra restricción es la capacidad limitada
#       X+Y<=7000
#
#   Por otro lado otras de las restricciones que tenemos es que cada pollo de A cuesta $1 y
#   cada pollo de B cuesta $2:
#
#       X+2*Y<=9000
#
#   Por último otra de las restricciones son las razones comerciales de que
#   el número de pollos de la raza B no puede ser superior a los de la raza A:
#
#       Y<=X
#
#   Modelo matemático:
#
#     [1]  X + 2*Y <= 9000
#     [2]  X + Y <= 7000
#     [3]  Y <= X
#     [4]  X >= 0
#     [5]  Y >= 0

# Cargamos las librerias necesarias para resolver el problema y el grafico.
library("linprog")
library("lpSolve")
library("lpSolveAPI", character.only=TRUE)
library("ggplot2")

# Creamos las funciones que representan cada una de las restricciones.
Y_R1 <- function(X) (9000 - 1*X)/2 # Y <= (9000 - X)/2
Y_R2 <- function(X) 7000-1*X # y <= 7000 - X
Y_R3 <- function(X) 1*X # Y <= X

# Definimos el dominio.
x1 = seq(0,9000)

# Graficamos las restricciones usando las funciones obtenidas previamente evaluadas en el dominio definido.


mydf = data.frame(x1,Y1 = Y_R1(x1),Y2 = Y_R2(x1), Y3 = Y_R3(x1))

mydf <- transform(mydf, z = pmax(Y1,pmin(Y2,Y3)))

ggplot(mydf, aes(x = x1)) +
  geom_line(aes(y = Y1), colour = 'blue') +
  geom_line(aes(y = Y2), colour = 'purple') +
  geom_line(aes(y = Y3), colour = 'orange')


# Cargamos un vector z con los beneficios por unidades de pollos de A y de B respectivamente.

z <- c(1,1.4)

A <- matrix(c(1,1,-1,2,1,1), ncol = 2)

# Matriz A con los coeficientes de X e Y en [1], [2] y [3]:
#      [,1]   [,2]
# [1,]   1      2
# [2,]   1      1
# [3,]  -1      1
#
# Usamos unicamente las restricciones [1], [2] y [3]. La no negatividad se encuentra implicita.
#     [4]  X >= 0
#     [5]  Y >= 0

b <- c(9000,7000,0) # Vector con resultados de las funciones restriccion [1], [2] y [3].

dir <- rep('<=', 3)  # Definimos que todas las funciones son de menor o igual, y que son 3.

solopt <- solveLP(z,b,A,maximum = TRUE, dir)

# Usando la funcion solveLP, pasando por parametro todas las variables definidas previamente y
# definiendo que se trata de una funcion de maximizacion, calculamos la solucion y
# la guardamos en solOpt.

summary(solopt) # Mostramos la solucion por pantalla.




#    a)Si, se produce un cambio en el modelo si el granjero no tiene limitaciones de capacidad para
#      la cantidad de pollos, ya que la solución sería comprar 9000 pollos de la raza A y
#      ningún pollo de la raza B, por lo que en el modelo matemático no tendríamos la restricción X+Y<=7000
#      (capacidad total del granjero).

z <- c(1,1.4)

A <- matrix(c(1,-1,2,1), ncol = 2)

# Matriz A con los coeficientes de X e Y en [1] y [3]:
#      [,1]   [,2]
# [1,]   1      2
# [2,]  -1      1

b <- c(9000,0) # Vector con resultados de las funciones restriccion [1] y [3].

dir <- rep('<=', 2)  # Definimos que todas las funciones son de menor o igual, y que son 2.

solopt <- solveLP(z,b,A,maximum = TRUE, dir)


summary(solopt) # Mostramos la solucion por pantalla.

#    b) Por otro lado, si no hay restricción a la cantidad de pollos de raza A respecto a la cantidad de raza B,
#    pero si sobre la capacidad total del granjero, la solución óptima es la de comprar 5000 pollos de la raza A y
#    2000 pollos de la raza B y en el modelo matemático no tendríamos la restricción de Y<=X.

z <- c(1,1.4)

A <- matrix(c(1,1,2,1), ncol = 2)

# Matriz A con los coeficientes de X e Y en [1] y [2]:
#      [,1]   [,2]
# [1,]   1      2
# [2,]   1      1

b <- c(9000,7000) # Vector con resultados de las funciones restriccion [1], [2].

dir <- rep('<=', 2)  # Definimos que todas las funciones son de menor o igual, y que son 2.

solopt <- solveLP(z,b,A,maximum = TRUE, dir)
# Usando la funcion solveLP, pasando por parametro todas las variables definidas previamente y
# definiendo que se trata de una funcion de maximizacion, calculamos la solucion y
# la guardamos en solOpt.

summary(solopt) # Mostramos la solucion por pantalla.