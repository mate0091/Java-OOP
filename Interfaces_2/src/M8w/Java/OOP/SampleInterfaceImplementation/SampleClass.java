package M8w.Java.OOP.SampleInterfaceImplementation;

import M8w.Java.OOP.SampleInterface.SampleInterface;

import java.lang.*;
import java.util.*;

public class SampleClass implements M8w.Java.OOP.SampleInterface.SampleInterface
{
    public void a(){ System.out.println("a()");}
    public void b(){ System.out.println("b()");}
    public void c(){ System.out.println("c()");}

    public static void main(String[] args)
    {
        SampleClass s = new SampleClass();

        s.a();
        s.b();
        s.c();
    }
}
