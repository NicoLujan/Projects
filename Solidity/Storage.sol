// SPDX-License-Identifier: GPL-3.0
pragma solidity >=0.7.0 <0.9.0;

contract Storage {

    uint256 number;

     constructor(uint256 num){
        number = num;
    }
    
    function setNumber(uint256 _number) public{
        number = _number;
    }

    function retrieve() public view returns (uint256){
        return number;
    }
  
    function incrementCount() public{
        number += 1;
    }
  
    function predeterminedNumber() public pure returns (uint256){
        return 17;
    }
    
}