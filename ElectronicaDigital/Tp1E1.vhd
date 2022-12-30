-- Code your design here
library IEEE;
use IEEE.std_logic_1164.all;

entity lab1_1 is
    Port ( ctrl : in  std_logic;
           a : in  std_logic;
           b : in std_logic;
           s : out std_logic
           );
end lab1_1;


--Proceso que describe un Mux2_1 con compuertas logicas
architecture Behavioral of lab1_1 is	

signal not_1: std_logic;
signal and_1: std_logic;
signal and_2: std_logic;

begin
	not_1 <= '1' when (ctrl = '0') else '0';
    and_1 <= a and not_1;
    and_2 <= b and ctrl;
    s <= and_1 or and_2;

end Behavioral;