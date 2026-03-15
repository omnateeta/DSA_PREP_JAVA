class Fancy {
    List<Long> seq;
    long add;
    long mul;
    int MOD = 1000000007;

    long power(long x, long y) {
        if (y == 0)
            return 1;

        long half   = power(x, y / 2);
        long res = (half * half) % MOD;

        if (y % 2 == 1) {
            res = (res * x) % MOD;
        }

        return res;
    }

    public Fancy() {
        seq = new ArrayList<>();
        add = 0;
        mul = 1;
    }
    
    public void append(int val) {
        long newValue = ((val - add) % MOD + MOD) * power(mul, MOD-2) % MOD;
        seq.add(newValue);
    }
    
    public void addAll(int inc) {
        add = (add+inc) % MOD;
    }
    
    public void multAll(int m) {
        mul = (mul * m) % MOD;
        add = (add * m) % MOD;
    }
    
    public int getIndex(int idx) {
        if(idx >= seq.size()) {
            return -1;
        }

        return (int) ((seq.get(idx) * mul + add) % MOD);
    }
}

/**
 * Your Fancy object will be instantiated and called as such:
 * Fancy obj = new Fancy();
 * obj.append(val);
 * obj.addAll(inc);
 * obj.multAll(m);
 * int param_4 = obj.getIndex(idx);
 */