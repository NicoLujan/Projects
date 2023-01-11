library IEEE;
use IEEE.std_logic_1164.all;

entity lab1_2_tb is
end lab1_2_tb;

architecture beh_tb of lab1_2_tb is

component lab1_2
    Port ( sel : in  std_logic;
           a : in  std_logic;
           b : in std_logic;
           o : out std_logic
           );
end component;

signal sel : std_logic;
signal a : std_logic;
signal b : std_logic;
signal o : std_logic;

begin
	uut: lab1_2
    port map (sel => sel, a => a, b=>b, o=>o);
    
    tb: process
    begin
    	a <= '1';
        b <= '0';
        sel <= '0';
       	wait for 10 ns;
        sel <= '1';
        wait for 10 ns;
        sel <= '0';        
    wait;
    
    end process;

end beh_tb;