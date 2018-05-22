package com.sakuray.code.practice.jdk.io;

import com.sakuray.code.practice.jdk.io.entity.Classroom;
import com.sakuray.code.practice.jdk.io.entity.Student;
import com.sakuray.code.practice.jdk.io.entity.Teacher;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ObjectStreamTest {

    @Test
    public void test() throws IOException {
        Student student = new Student(10, "张三", 12);
        Teacher teacher = new Teacher(32, "李四", student);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(teacher);
        byte[] obj = baos.toByteArray();
        System.out.println(obj.length);
        System.out.println(Arrays.toString(obj));
        oos.close();
        ByteArrayInputStream bais = new ByteArrayInputStream(obj);
        ObjectInputStream ois = new ObjectInputStream(bais);
        try {
            Teacher t = (Teacher) ois.readObject();
            System.out.println(t);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        ois.close();
    }

    @Test
    public void test2() throws IOException {
        Student student = new Student(10, "张三", 12);
        Teacher teacher = new Teacher(32, "李四", student);
        Classroom classroom = new Classroom();
        List<Student> students = new ArrayList<Student>();
        students.add(student);
        classroom.setStudents(students);
        classroom.setTeacher(teacher);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(classroom);
        byte[] obj = baos.toByteArray();
        System.out.println(obj.length);
        System.out.println(Arrays.toString(obj));
        oos.close();
        ByteArrayInputStream bais = new ByteArrayInputStream(obj);
        ObjectInputStream ois = new ObjectInputStream(bais);
        try {
            Classroom c = (Classroom) ois.readObject();
            System.out.println(c);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        ois.close();
    }

    @Test
    public void test3() throws IOException {
        Student student = new Student(10, "张三", 12);
        Teacher teacher = new Teacher(32, "李四", student);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(student);
        oos.writeObject(teacher);
        byte[] obj = baos.toByteArray();
        System.out.println(obj.length);
        System.out.println(Arrays.toString(obj));
        oos.close();
        ByteArrayInputStream bais = new ByteArrayInputStream(obj);
        ObjectInputStream ois = new ObjectInputStream(bais);
        try {
            Student s = (Student) ois.readObject();
            System.out.println(s);
            Teacher t = (Teacher) ois.readObject();
            System.out.println(t);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        ois.close();
    }

    @Test
    public void test4() throws IOException {
        String path = ObjectStreamTest.class.getClassLoader().getResource("").getPath() + "objectstream.txt";
//		System.out.println(path);
        File file = new File(path);
        Student student = new Student(10, "张三", 12);
        Teacher teacher = new Teacher(32, "李四", student);
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(student);
        oos.writeObject(teacher);
        oos.flush();
        oos.close();
        FileInputStream fis = new FileInputStream(new File(path));
        ObjectInputStream ois = new ObjectInputStream(fis);
        try {
            Student s = (Student) ois.readObject();
            System.out.println(s);
            Teacher t = (Teacher) ois.readObject();
            System.out.println(t);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        ois.close();
    }
}
