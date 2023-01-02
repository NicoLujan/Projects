library IEEE;
use IEEE.std_logic_1164.all;

entity lab1_2b_tb is
end lab1_2b_tb;

architecture beh_tb of lab1_2b_tb is

component lab1_2b
    Port ( sel : in  std_logic;
           a : in std_logic_vector  (7 downto 0);
           b : in std_logic_vector  (7 downto 0);
           o : out std_logic_vector (7 downto 0));
end component;

signal sel : std_logic;
signal a : std_logic_vector  (7 downto 0);
signal b : std_logic_vector  (7 downto 0);
signal o : std_logic_vector (7 downto 0);

begin
	uut: lab1_2b
    port map (sel => sel,
    a => a,
    b => b,
    o => o);
    
    tb: process
    begin
    	a <= "11111111";
        
        b <= "11101110";
        
        sel <= '0';
       	wait for 10 ns;
        sel <= '1';
        wait for 10 ns;
        sel <= '0';        
    wait;
    
    end process;

end beh_tb;