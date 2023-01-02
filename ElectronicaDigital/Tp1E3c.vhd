library ieee;
use ieee.std_logic_1164.all;

entity lab1_3c is
    port(
        sel: in std_logic_vector (3 downto 0);  -- Señal de selección
        x: in std_logic;  -- Entrada
        y0, y1, y2, y3, 
        y4, y5, y6, y7, 
        y8, y9, y10, y11,
        y12, y13, y14, y15: out std_logic   -- Salidas
    );
end lab1_3c;

architecture Behavioral of lab1_3c is

signal first, second, third, fourth : std_logic;

component lab1_3b
    port(
        sel: in std_logic_vector (1 downto 0);  -- Señal de selección
        x: in std_logic;  -- Entrada
        y0, y1, y2, y3: out std_logic   -- Salidas
    );
end component;

begin
	dmux1:lab1_3b port map (x => first, y0 => y0, y1 => y1, y2 => y2, y3 => y3, sel => sel(1 downto 0));
    dmux2:lab1_3b port map (x => second, y0 => y4, y1 => y5, y2 => y6, y3 => y7, sel => sel(1 downto 0));
    dmux3:lab1_3b port map (x => third, y0 => y8, y1 => y9, y2 => y10, y3 => y11, sel => sel(1 downto 0));
    dmux4:lab1_3b port map (x => fourth, y0 => y12, y1 => y13, y2 => y14, y3 => y15, sel => sel(1 downto 0));
    dmux5:lab1_3b port map (x => x, y0 => first, y1 => second, y2 => third, y3 => fourth, sel => sel(3 downto 2));

end Behavioral;