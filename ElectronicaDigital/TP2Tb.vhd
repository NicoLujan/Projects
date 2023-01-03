-- Code your testbench here
library IEEE;
use IEEE.std_logic_1164.all;

entity ALU_tb is
end ALU_tb;

architecture beh_tb of ALU_tb is

component ALU
    port(
        operando1: in std_logic_vector(7 downto 0);
        operando2: in std_logic_vector(7 downto 0);
        operador: in std_logic_vector(2 downto 0);
        resultado: out std_logic_vector(7 downto 0)
    );
end component;

signal operando1: std_logic_vector(7 downto 0);
signal operando2: std_logic_vector(7 downto 0);
signal operador:  std_logic_vector(2 downto 0);
signal resultado: std_logic_vector(7 downto 0);

begin
	uut: ALU
    port map (
    operando1 => operando1, 
    operando2 => operando2,
    operador => operador, 
    resultado => resultado);
    
    tb: process
    begin
    	operando1 <= "11111110";
        operando2 <= "00000001";
        operador <= "000";
       	wait for 10 ns;
        operador <= "001";
        wait for 10 ns;
        operador <= "010";
        wait for 10 ns;
        operador <= "011";
        wait for 10 ns;
        operador <= "100";
        wait for 10 ns;
        operador <= "101";
        wait for 10 ns;
        operador <= "110";
        wait for 10 ns;
        operador <= "111";
    wait;
    
    end process;

end beh_tb;