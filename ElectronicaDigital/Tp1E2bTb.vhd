library IEEE;
use IEEE.std_logic_1164.all;

entity lab1_2b_tb is
end lab1_2b_tb;

architecture beh_tb of lab1_2b_tb is

component lab1_2b is
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
end component;

signal sel : std_logic;
signal a_0 : std_logic;
signal a_1 : std_logic;
signal a_2 : std_logic;
signal a_3 : std_logic;
signal a_4 : std_logic;
signal a_5 : std_logic;
signal a_6 : std_logic;
signal a_7 : std_logic;
signal b_0 : std_logic;
signal b_1 : std_logic;
signal b_2 : std_logic;
signal b_3 : std_logic;
signal b_4 : std_logic;
signal b_5 : std_logic;
signal b_6 : std_logic;
signal b_7 : std_logic;
signal o_0 : std_logic;
signal o_1 : std_logic;
signal o_2 : std_logic;
signal o_3 : std_logic;
signal o_4 : std_logic;
signal o_5 : std_logic;
signal o_6 : std_logic;
signal o_7 : std_logic;

begin
	uut: lab1_2b
    port map (sel => sel,
    a_0 => a_0,
    a_1 => a_1,
    a_2 => a_2,
    a_3 => a_3,
    a_4 => a_4,
    a_5 => a_5,
    a_6 => a_6,
    a_7 => a_7,
    b_0 => b_0,
    b_1 => b_1,
    b_2 => b_2,
    b_3 => b_3,
    b_4 => b_4,
    b_5 => b_5,
    b_6 => b_6,
    b_7 => b_7,
    o_0 => o_0,
    o_1 => o_1,
    o_2 => o_2,
    o_3 => o_3,
    o_4 => o_4,
    o_5 => o_5,
    o_6 => o_6,
    o_7 => o_7);
    
    tb: process
    begin
    	a_0 <= '1';
        a_1 <= '1';
        a_2 <= '1';
        a_3 <= '1';
        a_4 <= '1';
        a_5 <= '1';
        a_6 <= '1';
        a_7 <= '1';
        
        b_0 <= '0';
        b_1 <= '0';
        b_2 <= '0';
        b_3 <= '0';
        b_4 <= '0';
        b_5 <= '0';
        b_6 <= '0';
        b_7 <= '0';
        
        sel <= '0';
       	wait for 10 ns;
        sel <= '1';
        wait for 10 ns;
        sel <= '0';        
    wait;
    
    end process;

end beh_tb;