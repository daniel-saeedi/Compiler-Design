int x
class Person < Student{
  private int name
  private int x
  private int age
  public initialize(int name, int age) {
    int x;
    self.name = name;
    self.age = age;
  }
  public void showName() {
    print(self.name);

  }
}

class Person {
    private int name
    private int x
    public int getName(){
        return self.name;
    }
}

class Student < Person {
  private int age
  private int sid
  private Course[10] courses;
  public initialize (int name, int age, int sid) {
    self.name = name;
    self.age = age;
    self.sid = sid;
  }
  }

  class Junior < Student {
    private int name
    public initialize (int name) {
      self.name = name;
    }
    }
