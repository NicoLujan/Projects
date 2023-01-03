-- Code your design here
library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
use IEEE.STD_LOGIC_SIGNED.ALL;
use IEEE.STD_LOGIC_ARITH.ALL;

entity ALU is
    port(
        operando1: in std_logic_vector(7 downto 0);
        operando2: in std_logic_vector(7 downto 0);
        operador: in std_logic_vector(2 downto 0);
        resultado: out std_logic_vector(7 downto 0)
    );
end ALU;

architecture Behavioral of ALU is

signal r: std_logic_vector(7 downto 0);

begin
	
    process (operando1, operando2, operador)
    begin
		case operador is
    		when "000" => r <= operando1;
       		when "001" => r <= operando1 sll 1; -- Shift hacia izquierda 1
        	when "010" => r <= operando1 + operando2;
        	when "011" => r <= operando1 - operando2;
        	when "100" => r <= operando1 and operando2;
        	when "101" => r <= operando1 or operando2;
        	when "110" => r <= operando1 xor operando2;
        	when others => r <= operando1 srl 1; --Shift hacia derecha 1
    	end case;
    end process;
    
    resultado <= r;
    
end Behavioral;