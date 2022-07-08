class Test {
    public bool match_result(int x, int y, Sample s) {
        return (x+y) == s.get_xy_sum()
    }
}

class Sample {
    private int x, y
    public initialize(int x, int y) {
        self.x = x
        self.y = y
        print(x+y)
    }
    public int get_xy_sum() {
        return self.x+self.y
    }
}

class Main {
    public initialize() {
        Test t
        Sample s
        s = Sample.new(4, 6)
        t = Test.new()
        if !t.match_result(4, 6, s)
            print(0)
        elsif t.match_result(4, 7, s)
            print(7)
        else
            print(t.match_result(4, 5, s) ? s.x : s.x*s.y)
    }
}


