class Sample {
    private int x, y
    public initialize(int x, int y) {
        self.x = x
        self.y = y
        print(x+y)
    }
}

class Main {
    public initialize() {
        int[2] x
        Sample s
        s = Sample.new(4, 6)
        x[1] = 12
        print(x[1] - s.x)
        print(x[0])
    }
}


