-- Code your design here
library IEEE;
use IEEE.std_logic_1164.all;

entity lab1_2 is
    Port ( sel : in  std_logic;
           a : in  std_logic;
           b : in std_logic;
           o : out std_logic
           );
end lab1_2;

--Proceso que describe un Mux2_1
architecture Behavioral of lab1_2 is	

begin

	o <= a when (sel = '0') else b;

end Behavioral;