library IEEE;
use IEEE.std_logic_1164.all;

entity lab1_3b_tb is
end lab1_3b_tb;

architecture beh_tb of lab1_3b_tb is

component lab1_3b
    Port ( sel : in  std_logic_vector(1 downto 0);
           x : in  std_logic;
           y0, y1, y2, y3 : out std_logic
           );
end component;

signal sel : std_logic(1 downto 0);
signal x : std_logic;
signal y0 : std_logic;
signal y1 : std_logic;
signal y2 : std_logic;
signal y3 : std_logic;

begin
	uut: lab1_3b
    port map (sel => sel, x => x, y0 = >y0, y1 => y1, y2 => y2,y3 => y3);
    
    tb: process
    begin
    	x <= '1';
        sel <= "00";
       	wait for 10 ns;
        sel <= "01";
        wait for 10 ns;
        sel <= "10";
        wait for 10 ns;
        sel <= "11";
    wait;
    
    end process;

end beh_tb;