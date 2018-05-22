package com.sakuray.code.practice.jdk.io.entity;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.List;

public class Classroom implements Externalizable {

    private Teacher teacher;

    private List<Student> students;

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(teacher);
        out.writeObject(students);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.teacher = (Teacher) in.readObject();
        this.students = (List<Student>) in.readObject();
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Classroom [teacher=" + teacher + ", students=" + students + "]";
    }

}
