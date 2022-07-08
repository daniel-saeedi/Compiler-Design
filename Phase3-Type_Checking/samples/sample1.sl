int x
class Student {
    private int id
    private Course[10] courses
    private int course_num
    public initialize(int id) {
        self.course_num = 0
        self.id = id
    }
    public bool coursePassed(int id) {
    Course c
    x()
    x.each do |c|
        if c.getId() == id
            if c.getGrade() > 10
                return true
            else
                return false
    self.courses.each do |id|
        return 0
    return 1
}
public void addCourse(int id, int grade) {
    Course newCourse
    newCourse = Course.new(id)
    self.courses[self.course_num] = newCourse
    }
}
class Course < Main {
    private int grade
    private int id
    public initialize(int id, int grade) {
        self.id = id
        self.grade = grade
    }
    public int getGrade()
        return self.grade
    public int getId()
        return self.id
}
class Main {
    private int[0] a
    public Set <int> ss
    public initialize() {
        Student s
        x = 1 + true
        self.ss = Set.new((true,2,3))
        s = Student.new(810198433)
        s.addCourse(810110, 15)
        s.addCourse(810114, 9)
        s.addCourse(810134, 14)
        print(s.coursePassed(810114))
    }
}
