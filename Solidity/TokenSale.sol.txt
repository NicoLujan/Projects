pragma solidity ^0.5.0;

interface MyToken{
    function decimals() external view returns(uint8);
    function balanceOf(address) external view returns(uint256);
    function transfer(address _to, uint256 _value) external returns (bool success);
}

contract TokenSale{
    address _owner;
    uint256 price;
    MyToken myTokenContract;
    uint256 tokenSold;

    event sold(address buyer,uint256 amount);

    constructor (uint256 _price,address _addresContract) public{
        _owner=msg.sender;
        price = _price;
        tokenSold = 0;
        myTokenContract = MyToken(_addresContract);
    }

    function mul(uint256 a, uint256 b) internal pure returns(uint256){
        if(a==0){
            return 0;
        }
        uint256 c = a * b;
        require(c / a==b);
        return c;
    }

    function buy(uint256 _numTokens) public payable{

        require (msg.value == mul(price,_numTokens));
        uint256 scaledAmount = mul(_numTokens,uint256(10) ** myTokenContract.decimals());
        require (myTokenContract.balanceOf(address(this)) >= scaledAmount);
        tokenSold+=_numTokens;
        require (myTokenContract.transfer(msg.sender,scaledAmount));
        emit sold(msg.sender,_numTokens);

    }

    function endSold() public{

        require(msg.sender == _owner);
        require(myTokenContract.transfer(_owner,myTokenContract.balanceOf(address(this))));
        msg.sender.transfer(address(this).balance);

    }



}