library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
use IEEE.STD_LOGIC_ARITH.ALL;
use IEEE.STD_LOGIC_UNSIGNED.ALL;

entity mux_tb is
end mux_tb;

architecture beh_tb of mux_tb is

component Mux2_32
    Port ( sel : in  std_logic;
           a : in  std_logic_vector (31 downto 0);
           b : in std_logic_vector (31 downto 0);
           o : out std_logic_vector (31 downto 0)
           );
end component;

signal sel : std_logic;
signal a : std_logic_vector (31 downto 0);
signal b : std_logic_vector (31 downto 0);
signal o : std_logic_vector (31 downto 0);

begin
	uut: mux2_32
    port map (sel => sel, a => a, b=>b, o=>o);
    
    tb: process
    begin
    	a <= x"12345678";
        b <= x"87654321";
        sel <= '0';
       	wait for 10 ns;
        sel <= '1';
    wait;
    
    end process;

end beh_tb;