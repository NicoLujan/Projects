pragma solidity >=0.4.21 <0.6.0;

contract PaymentChannel{

    address owner;
    mapping(uint256 =>bool) usedNonces;

    constructor() public payable{
        owner = msg.sender;
    }

    function moreMoney() public payable {
        require(msg.sender == owner);
    }

    function claimPainment (uint256 _amount,uint256 _nonce,bytes memory _sig) public{
        // Comprobacion que este canal de pago no ha sido utilizado antes
        require(!usedNonces[_nonce], "Payment used");
        usedNonces[_nonce] = true;

        //Recrear el hash del pago
        bytes32 hash = keccak256(abi.encodePacked(msg.sender, _amount, _nonce, address(this)));
        hash = keccak256(abi.encodePacked("\x19Ethereum Signed Message:\n32", hash));

        //Comprobar que quien ha firmado el pago
        require(recoverSigner(hash, _sig) == owner);

        msg.sender.transfer(_amount);
    }

    function splitSignature(bytes memory sig) internal pure returns(uint8, bytes32, bytes32){
        require(sig.length == 65);

        bytes32 r;
        bytes32 s;
        uint8 v;
        
        //Ensamblador, solidity tiene un lenguaje para bajo nivel
        assembly {
            r := mload(add(sig,32))
            s := mload(add(sig,64))
            v := byte(0,mload(add(sig,96)))
        }
    }
    
    function recoverSigner(bytes32 message, bytes memory sig) internal pure returns (address){
        uint8 v;
        bytes32 r;
        bytes32 s;

        (v,r,s) = splitSignature(sig);

        return ecrecover(message, v, r, s);
    }
}