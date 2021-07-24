package jfs;

import com.sun.org.apache.xpath.internal.operations.Variable;
import java.lang.annotation.Annotation;

public class CustomAnno
{
    public static void main(String args[])
    {
        //1. getting reference to the class where the custom annotation is applied.
        //2. then getting the annotation to get the values 
        MyClass myClass = new MyClass();
        Class cls = myClass.getClass();
        Annotation getMyAnno = cls.getAnnotation(MyAnno.class);
        MyAnno myAnno = (MyAnno)getMyAnno;
        MyClass.myMeth(); //left this as is.
      
        System.out.println("myAnno.str(): "+ myAnno.str());
        System.out.println("myAnno.str(): "+ myAnno.val());     
    }
}