library IEEE;
use IEEE.std_logic_1164.all;

entity lab1_2c_tb is
end lab1_2c_tb;

architecture beh_tb of lab1_2c_tb is

component lab1_2c
    Port ( sel : in  std_logic_vector (1 downto 0);
           a : in std_logic_vector  (7 downto 0);
           b : in std_logic_vector  (7 downto 0);
           c : in std_logic_vector  (7 downto 0);
           d : in std_logic_vector  (7 downto 0);
           o : out std_logic_vector (7 downto 0));
end component;


signal sel : std_logic_vector (1 downto 0);
signal a : std_logic_vector  (7 downto 0);
signal b : std_logic_vector  (7 downto 0);
signal c : std_logic_vector  (7 downto 0);
signal d : std_logic_vector  (7 downto 0);
signal o : std_logic_vector (7 downto 0);

begin
	uut: lab1_2c
    port map (sel => sel,
    a => a,
    b => b,
    c => c,
    d => d,
    o => o);
    
    tb: process
    begin
    	a <= "11111111";
        
        b <= "10101010";
        
        c <= "11101110";
        
        d <= "00000000";
        
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