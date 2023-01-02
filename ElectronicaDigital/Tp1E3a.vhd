library ieee;
use ieee.std_logic_1164.all;

entity lab1_3a is
    port(
        sel: in std_logic;  -- Señal de selección
        x: in std_logic;  -- Entrada
        y0, y1: out std_logic   -- Salidas
    );
end lab1_3a;

architecture Behavioral of lab1_3a is
begin
    -- Si sel es cero, y0 toma el valor de x y y1 toma el valor de '0'
    -- Si sel es uno, y0 toma el valor de '0' y y1 toma el valor de x
    with sel select
        y0 <= x when '0',
              '0' when others;
    with sel select    
    	y1 <= '0' when '0',
              x when others;

end Behavioral;