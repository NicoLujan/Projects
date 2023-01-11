// Code your design here
library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
use IEEE.STD_LOGIC_ARITH.ALL;
use IEEE.STD_LOGIC_UNSIGNED.ALL;

entity registers is
    Port ( 
           reg_in, reg_out : in STD_LOGIC_VECTOR (3 downto 0);
           
           data_in : in STD_LOGIC_VECTOR (7 downto 0);
           
           we, clk, rst : in STD_LOGIC;
           
           data_out : out STD_LOGIC_VECTOR (7 downto 0)
          );
end registers;

architecture PRACTICA of registers is
	type mem is array (15 downto 0) of STD_LOGIC_VECTOR(7 downto 0);
    signal regs: mem;
begin


-- process de escritura
process (clk, rst) 
begin
    if (rst = '1') then 
        regs <= (others => (others => '0'));  
    elsif (falling_edge(clk)) then 
        if (we = '1') then
            if (reg_out /= "0000") then 
                regs (CONV_INTEGER(reg_wr)) <= data_wr; 
            end if;    
        end if;
    end if;
    
end process;


-- process de lectura
process (reg_in)
begin
    if (reg_in /= "0000") then 
        data1_rd <= regs (CONV_INTEGER(reg1_rd));
    else 
        data1_rd <= x"0000";
    end if;
end process;

end PRACTICA;