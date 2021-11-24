// SPDX-License-Identifier: GPL-3.0

pragma solidity >=0.7.0 <0.9.0;

contract Transaction {
    
    address owner; 
    
    modifier OnlyOwner {
        require (msg.sender == owner);       
        _;                                  
    }
    
    function newOwner(address _newOwner) public OnlyOwner{
        owner = _newOwner;
    }
    
    function getOwner() public view returns (address){
        return owner;
    }
    
    function getBalance() public view returns (uint256){
        return address(this).balance;
    }
    
    constructor() payable{ 
        owner = msg.sender; 
    }
    
    function incrementBalance(uint256 amount) payable public{ 
        require(msg.value == amount); 
    }
    
    function withDrawBalance() public OnlyOwner{                           
        payable(msg.sender).transfer (address(this).balance);    
    }   
}