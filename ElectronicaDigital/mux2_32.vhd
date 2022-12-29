library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
use IEEE.STD_LOGIC_ARITH.ALL;
use IEEE.STD_LOGIC_UNSIGNED.ALL;


entity Mux2_32 is
    Port ( sel : in  std_logic;
           a : in  std_logic_vector (31 downto 0);
           b : in std_logic_vector (31 downto 0);
           o : out std_logic_vector (31 downto 0)
           );
end Mux2_32;

architecture Behavioral of Mux2_32 is	
begin


-- proceso que describe un mux de 2 entradas de 32 bits
	o <= a when (sel = '0') else b;

end Behavioral;