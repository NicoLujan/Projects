pragma solidity ^0.4.17;

contract Banco {
    
    constructor() payable public{
        
    }
    
    
    function incrementBalance(uint256 cantidad) payable public {
        require(msg.value == cantidad);
    }
    
    function withdrawBalance() public{
        msg.sender.transfer(address(this).balance);
    }
    
    
}