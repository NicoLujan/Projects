library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
use IEEE.STD_LOGIC_ARITH.ALL;
use IEEE.STD_LOGIC_UNSIGNED.ALL;

entity lab1_2b is
    Port ( sel : in  std_logic;
           a : in std_logic_vector  (7 downto 0);
           b : in std_logic_vector  (7 downto 0);
           o : out std_logic_vector (7 downto 0));
end lab1_2b;

architecture Behavioral of lab1_2b is

component lab1_2
    Port ( sel : in  std_logic;
           a : in  std_logic;
           b : in std_logic;
           o : out std_logic
           );
end component;

begin

	mux1: lab1_2 port map (a=>a(0),b=>b(0),sel=>sel,o=>o(0));
    mux2: lab1_2 port map (a=>a(1),b=>b(1),sel=>sel,o=>o(1));
    mux3: lab1_2 port map (a=>a(2),b=>b(2),sel=>sel,o=>o(2));
    mux4: lab1_2 port map (a=>a(3),b=>b(3),sel=>sel,o=>o(3));
    mux5: lab1_2 port map (a=>a(4),b=>b(4),sel=>sel,o=>o(4));
    mux6: lab1_2 port map (a=>a(5),b=>b(5),sel=>sel,o=>o(5));
    mux7: lab1_2 port map (a=>a(6),b=>b(6),sel=>sel,o=>o(6));
    mux8: lab1_2 port map (a=>a(7),b=>b(7),sel=>sel,o=>o(7));

end Behavioral;