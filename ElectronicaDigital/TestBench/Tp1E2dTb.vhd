library IEEE;
use IEEE.std_logic_1164.all;

entity lab1_2d_tb is
end lab1_2d_tb;

architecture beh_tb of lab1_2d_tb is

component lab1_2d
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
end component;

signal sel : std_logic_vector (3 downto 0);
signal a : std_logic_vector  (7 downto 0);
signal b : std_logic_vector  (7 downto 0);
signal c : std_logic_vector  (7 downto 0);
signal d : std_logic_vector  (7 downto 0);
signal e : std_logic_vector  (7 downto 0);
signal f : std_logic_vector  (7 downto 0);
signal g : std_logic_vector  (7 downto 0);
signal h : std_logic_vector  (7 downto 0);
signal i : std_logic_vector  (7 downto 0);
signal j : std_logic_vector  (7 downto 0);
signal k : std_logic_vector  (7 downto 0);
signal l : std_logic_vector  (7 downto 0);
signal m : std_logic_vector  (7 downto 0);
signal n : std_logic_vector  (7 downto 0);
signal p : std_logic_vector  (7 downto 0);
signal q : std_logic_vector  (7 downto 0);
signal o : std_logic_vector  (7 downto 0);

begin
	uut: lab1_2d
    port map (sel => sel,
    a => a,
    b => b,
    c => c,
    d => d,
    e => e,
    f => f,
    g => g,
    h => h,
    i => i,
    j => j,
    k => k,
    l => l,
    m => m,
    n => n,
    p => p,
    q => q,
    o => o);
    
    tb: process
    begin
    	a <= "11111111";
        
        b <= "00000000";
        
        c <= "11101110";
        
        d <= "11101110";
        
        e <= "10101010";
        
        f <= "10101010";
        
        g <= "11101110";
        
        h <= "11101110";
        
        i <= "11111110";
        
        j <= "10101010";
        
        k <= "11101110";
        
        l <= "11101110";
        
        m <= "00000001";
        
        n <= "10101010";
        
        p <= "11101110";
        
        q <= "11101110";
        
        sel <= "0000";
       	wait for 10 ns;
        sel <= "0001";
        wait for 10 ns;
        sel <= "1000";
        wait for 10 ns;
        sel <= "1100";
    wait;
    
    end process;

end beh_tb;