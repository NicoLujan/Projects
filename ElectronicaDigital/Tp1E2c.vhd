library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
use IEEE.STD_LOGIC_ARITH.ALL;
use IEEE.STD_LOGIC_UNSIGNED.ALL;

entity lab1_2c is
    Port ( sel : in  std_logic_vector(1 downto 0);
           a : in std_logic_vector  (7 downto 0);
           b : in std_logic_vector  (7 downto 0);
           c : in std_logic_vector  (7 downto 0);
           d : in std_logic_vector  (7 downto 0);
           o : out std_logic_vector (7 downto 0));
end lab1_2c;

architecture Behavioral of lab1_2c is

signal first : std_logic_vector  (7 downto 0);
signal second : std_logic_vector  (7 downto 0);

component lab1_2b
    Port ( sel : in  std_logic;
           a : in  std_logic_vector (7 downto 0);
           b : in std_logic_vector (7 downto 0);
           o : out std_logic_vector (7 downto 0)
           );
end component;

begin

	mux1: lab1_2b port map (a=>a,b=>b,sel=>sel(0),o=>first);
    mux2: lab1_2b port map (a=>c,b=>d,sel=>sel(0),o=>second);
    mux3: lab1_2b port map (a=>first,b=>second,sel=>sel(1),o=>o);
   
end Behavioral;