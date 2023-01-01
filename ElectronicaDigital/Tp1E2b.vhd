library IEEE;
use IEEE.std_logic_1164.all;

entity lab1_2b is
    Port ( sel : in  std_logic;
           a_0 : in  std_logic;
           a_1 : in  std_logic;
           a_2 : in  std_logic;
           a_3 : in  std_logic;
           a_4 : in  std_logic;
           a_5 : in  std_logic;
           a_6 : in  std_logic;
           a_7 : in  std_logic;
           b_0 : in std_logic;
           b_1 : in std_logic;
           b_2 : in std_logic;
           b_3 : in std_logic;
           b_4 : in std_logic;
           b_5 : in std_logic;
           b_6 : in std_logic;
           b_7 : in std_logic;
           o_0 : out std_logic;
           o_1 : out std_logic;
           o_2 : out std_logic;
           o_3 : out std_logic;
           o_4 : out std_logic;
           o_5 : out std_logic;
           o_6 : out std_logic;
           o_7 : out std_logic;
           );
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

	mux1: lab1_2 port map (a=>a_0,b=>b_0,sel=>sel,o=>o_0);
    mux2: lab1_2 port map (a=>a_1,b=>b_1,sel=>sel,o=>o_1);
    mux3: lab1_2 port map (a=>a_2,b=>b_2,sel=>sel,o=>o_2);
    mux4: lab1_2 port map (a=>a_3,b=>b_3,sel=>sel,o=>o_3);
    mux5: lab1_2 port map (a=>a_4,b=>b_4,sel=>sel,o=>o_4);
    mux6: lab1_2 port map (a=>a_5,b=>b_5,sel=>sel,o=>o_5);
    mux7: lab1_2 port map (a=>a_6,b=>b_6,sel=>sel,o=>o_6);
    mux8: lab1_2 port map (a=>a_7,b=>b_7,sel=>sel,o=>o_7);

end Behavioral;