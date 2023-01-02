library IEEE;
use IEEE.std_logic_1164.all;

entity lab1_3c_tb is
end lab1_3c_tb;

architecture beh_tb of lab1_3c_tb is

component lab1_3c
    port(
        sel: in std_logic_vector (3 downto 0);
        x: in std_logic;  
        y0, y1, y2, y3, 
        y4, y5, y6, y7, 
        y8, y9, y10, y11,
        y12, y13, y14, y15: out std_logic   
    );
end component;

signal sel : std_logic_vector (3 downto 0);
signal x : std_logic;  
signal y0, y1, y2, y3, 
       y4, y5, y6, y7, 
       y8, y9, y10, y11,
       y12, y13, y14, y15 : std_logic;

begin
	uut: lab1_3c
    port map (sel => sel, 
    x => x, 
    y0=>y0, 
    y1=>y1, 
    y2=>y2,
    y3=>y3,
    y4=>y4, 
    y5=>y5, 
    y6=>y6,
    y7=>y7,
    y8=>y8, 
    y9=>y9, 
    y10=>y10,
    y11=>y11,
    y12=>y12, 
    y13=>y13, 
    y14=>y14,
    y15=>y15);
    
    tb: process
    begin
    	x <= '1';
        sel <= "0000";
       	wait for 10 ns;
        sel <= "0001";
        wait for 10 ns;
        sel <= "0010";
        wait for 10 ns;
        sel <= "0011";
        wait for 10 ns;
        sel <= "0100";
       	wait for 10 ns;
        sel <= "0101";
        wait for 10 ns;
        sel <= "0110";
        wait for 10 ns;
        sel <= "0111";
        wait for 10 ns;
        sel <= "1000";
        wait for 10 ns;
        sel <= "1001";
        wait for 10 ns;
        sel <= "1010";
        wait for 10 ns;
        sel <= "1011";
        wait for 10 ns;
        sel <= "1100";
        wait for 10 ns;
        sel <= "1101";
        wait for 10 ns;
        sel <= "1110";
        wait for 10 ns;
        sel <= "1111";
    wait;
    
    end process;

end beh_tb;