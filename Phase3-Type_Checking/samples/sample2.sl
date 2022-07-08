int x
class Student {
    private int id
    private Course[10] courses
    private int course_num
    public initialize(int id) {
        Course c
        x.v()
        x()
        c.x()
        self.course_num = 0
        self.id = id
        1 = id
        if(x)
            id = true++
    }
    public bool coursePassed(int id) {
    Course c
    self.courses.each do |c|
        if c.getId() == id
            if c.getGrade() > 10
                return true
            else
                return 1
    return false
}
public void addCourse(int id, int grade) {
    Course newCourse
    newCourse = Course.new(id, grade)
    self.courses[self.course_num] = newCourse
    }
}
class Course {
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
    public initialize() {
        Student s
        s = Student.new(810198433)
        s.addCourse(810110, 15)
        s.addCourse(810114, 9)
        s.addCourse(810134, 14)
        print(s.coursePassed(810114))
    }
}
