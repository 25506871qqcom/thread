package atomic;

import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;

public class FieldUpdater {

    public static void main(String[] args) {

        AtomicLongFieldUpdater longFieldUpdater
                = AtomicLongFieldUpdater.newUpdater(Student.class,"id");


        Student student = new Student(1);
        longFieldUpdater.compareAndSet(student,1,10);

        System.out.println(student.getId());
    }



}


    class Student{
       volatile long id ;
       String name ;

        public Student(long id) {
            this.id = id;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }
    }
