class Person {
  private int name
  private int age
  public initialize(int name, int age) {
    self.name = name;
    self.age = age;
  }
  public void showName() {
    print(self.name);

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
  public void updateSid(int sid) {
    self.sid = sid;
  }
  public int getTotalCredits() {
  	int i
    int sum
    Course current
    int i


     sum = sum + current.credits;

  }
  public void updateSid(int sid) {
    self.sid = sid;
  }
}

class Course {
  private int cid
  private int name
  private Person instructor
  private int credits
  public initialize(int cid, int name) {
    self.cid = cid;
    self.name = name;
  }
  public void credits(int credits) {
    self.credits = credits;
  }
}

class Junior < Student {
  private int name
  public initialize (int name) {
    self.name = name;
  }



  public int showName() {
    return self.name;
  }
}

class Main {
  public initialize() {
    Person inst
    Student stu;
    Course course;
    inst = Person.new(10, 42);
    inst.showName();
    stu = Student.new(3, 20);
    stu.showName();
    course = Course.new(810157401, 1, inst);
  }
}
