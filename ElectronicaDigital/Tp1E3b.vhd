library ieee;
use ieee.std_logic_1164.all;

entity lab1_3b is
    port(
        sel: in std_logic_vector (1 downto 0);  -- Señal de selección
        x: in std_logic;  -- Entrada
        y0, y1, y2, y3: out std_logic   -- Salidas
    );
end lab1_3b;

architecture Behavioral of lab1_3b is

signal first, second : std_logic;

component lab1_3a
    Port ( sel : in  std_logic;
           x : in  std_logic;
           y0,y1 : out std_logic
           );
end component;

begin
	dmux1:lab1_3a port map (x => x, y0 => first, y1 => second, sel => sel(1));
    dmux2:lab1_3a port map (x => first, y0 => y0, y1 => y1, sel => sel(0));
    dmux3:lab1_3a port map (x => second, y0 => y2, y1 => y3, sel => sel(0));

end Behavioral;