// SPDX-License-Identifier: GPL-3.0
pragma solidity >=0.7.0 <0.9.0;

contract Coches {
   address owner;
   uint256 precio;
   uint256[] identificadores; //Forma de declarar arrays
   mapping(address => Coche) coches; //mapping con address como clave y coche como dato
   struct Coche{ //Forma de declarar estructuras en Solidity
        uint256 identificador;
        string marca;
        uint32 caballos;  //Se usa uint32 para optimizar el consumo de GAS
        uint32 kilometros;
   }
   
   modifier precioFiltro(uint256 _precio){
        require(precio == _precio);
        _; 
   }
   
   constructor(uint256 _precio){
       owner = msg.sender;
       precio = _precio;
   }
    
   function addCoche(uint256 _id,string memory _marca,uint32 _caballos,uint32 _kilometros) public precioFiltro(msg.value) payable{
        identificadores.push(_id);
        coches[msg.sender].identificador = _id;
        coches[msg.sender].marca = _marca;
        coches[msg.sender].caballos = _caballos;
        coches[msg.sender].kilometros = _kilometros;
        
   }
   
   function getIdentificadores() external view returns (uint256){
       return identificadores.length;
   }
   
   function getCoches() external view returns (string memory _marca,uint32 _caballos,uint32 _kilometros){
       _marca = coches[msg.sender].marca;
       _caballos = coches[msg.sender].caballos;
       _kilometros = coches[msg.sender].kilometros;
   }
}