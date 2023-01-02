library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
use IEEE.STD_LOGIC_ARITH.ALL;
use IEEE.STD_LOGIC_UNSIGNED.ALL;

entity lab1_2d is
    Port ( sel : in  std_logic_vector(3 downto 0);
           a : in std_logic_vector  (7 downto 0);
           b : in std_logic_vector  (7 downto 0);
           c : in std_logic_vector  (7 downto 0);
           d : in std_logic_vector  (7 downto 0);
           e : in std_logic_vector  (7 downto 0);
           f : in std_logic_vector  (7 downto 0);
           g : in std_logic_vector  (7 downto 0);
           h : in std_logic_vector  (7 downto 0);
           i : in std_logic_vector  (7 downto 0);
           j : in std_logic_vector  (7 downto 0);
           k : in std_logic_vector  (7 downto 0);
           l : in std_logic_vector  (7 downto 0);
           m : in std_logic_vector  (7 downto 0);
           n : in std_logic_vector  (7 downto 0);
           p : in std_logic_vector  (7 downto 0);
           q : in std_logic_vector  (7 downto 0);
           o : out std_logic_vector (7 downto 0));
end lab1_2d;

architecture Behavioral of lab1_2d is

signal one : std_logic_vector  (7 downto 0);
signal two : std_logic_vector  (7 downto 0);
signal three: std_logic_vector  (7 downto 0);
signal four : std_logic_vector  (7 downto 0);

component lab1_2c
    Port ( sel : in  std_logic_vector(1 downto 0);
           a : in  std_logic_vector (7 downto 0);
           b : in std_logic_vector (7 downto 0);
           c : in std_logic_vector (7 downto 0);
           d : in std_logic_vector (7 downto 0);
           o : out std_logic_vector (7 downto 0)
           );
end component;

begin

	mux1: lab1_2c port map (a=>a,b=>b,c=>c,d=>d,sel=>sel(1 downto 0),o=>one);
    mux2: lab1_2c port map (a=>e,b=>f,c=>g,d=>h,sel=>sel(1 downto 0),o=>two);
    mux3: lab1_2c port map (a=>i,b=>j,c=>k,d=>l,sel=>sel(1 downto 0),o=>three);
    mux4: lab1_2c port map (a=>m,b=>n,c=>p,d=>q,sel=>sel(1 downto 0),o=>four);
    mux5: lab1_2c port map (a=>one,b=>two,c=>three,d=>four,sel=>sel(3 downto 2),o=>o);
   
end Behavioral;