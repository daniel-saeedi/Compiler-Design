int g_var
bool flag
class A {
    private int x, y
    public initialize(int x, int y) {
        print(g_var)
        print(flag)
        g_var = 5
        self.x = x
        self.y = y
        print(g_var)
    }
}

class B {
    private int z
    public void func() {
        print(self.z)
    }
}

class Main {
    public initialize() {
        A a
        B b
        a = A.new(4, 6)
        b = B.new()
        b.func()
        g_var = g_var + 5
        print(g_var)
    }
}

