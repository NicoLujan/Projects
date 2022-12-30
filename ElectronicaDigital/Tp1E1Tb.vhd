-- Code your testbench here
library IEEE;
use IEEE.std_logic_1164.all;

entity lab1_1_tb is
end lab1_1_tb;

architecture beh_tb of lab1_1_tb is

component lab1_1
    Port ( ctrl : in  std_logic;
           a : in  std_logic;
           b : in std_logic;
           s : out std_logic
           );
end component;

signal ctrl : std_logic;
signal a : std_logic;
signal b : std_logic;
signal s : std_logic;

begin
	uut: lab1_1
    port map (ctrl => ctrl, a => a, b=>b, s=>s);
    
    tb: process
    begin
    	a <= '1';
        b <= '0';
        ctrl <= '0';
       	wait for 10 ns;
        ctrl <= '1';
    wait;
    
    end process;

end beh_tb;