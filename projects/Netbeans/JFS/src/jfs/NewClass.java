/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jfs;


import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Inherited
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnno
{
    String str();
    int val();
}

//using above custom annotation on class level
//can also use method level
//just need to change t @Target(ElementType.METHOD)
@MyAnno(str = "Annotation example", val = 100)
class MyClass
{

    public static void myMeth()
    {
        System.out.println("Inside myMeth()");
    }
}
