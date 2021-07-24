/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication71;

 public class Super extends Abs implements Inter {

        @Override
        public int number() {
            return 11;
        }

        public static void main(String args[]) {
            Super s1 = new Super();
            Super s2 = new Sub(16);

        }

        public int twice(int x) {
            return 2 * x;
        }

        public int thrice(int x) {
            return 3 * x;
        }

        public int ace() {
            return 1;
        }

        public String dub(String s) {
            return s + s;

        }
    }

interface Inter {

    int number();
}
 
abstract class Abs {

    static int foo = 12;

    int number() {
        return 5;
    }

    abstract int ace();
}

final class Sub extends Super {

    Sub(int bar) {
        foo = bar;
    }

    public int number() {
        return 10;
    }

    public int ace() {
        return 13;
    }

    int dub(int i) {
        return 2 * i;
    }

}  