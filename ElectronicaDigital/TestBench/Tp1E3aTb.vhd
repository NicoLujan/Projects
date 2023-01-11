library IEEE;
use IEEE.std_logic_1164.all;

entity lab1_3a_tb is
end lab1_3a_tb;

architecture beh_tb of lab1_3a_tb is

component lab1_3a
    Port ( sel : in  std_logic;
           x : in  std_logic;
           y0,y1 : out std_logic
           );
end component;

signal sel : std_logic;
signal x : std_logic;
signal y0 : std_logic;
signal y1 : std_logic;

begin
	uut: lab1_3a
    port map (sel => sel, x => x, y0=>y0, y1=>y1);
    
    tb: process
    begin
    	x <= '1';
        sel <= '0';
       	wait for 10 ns;
        sel <= '1';
        wait for 10 ns;
        sel <= '0';        
    wait;
    
    end process;

end beh_tb;