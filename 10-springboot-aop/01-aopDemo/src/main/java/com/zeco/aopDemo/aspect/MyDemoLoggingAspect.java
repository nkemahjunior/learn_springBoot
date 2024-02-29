package com.zeco.aopDemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {


    // this is where we add all of our related advices for logging

    // let's start with an @Before advice
/**
    @Before("execution(public void addAccount())")
    public void beforeAddAccountAdvice() {

        System.out.println("\n=====>>> Executing @Before advice on addAccount()");

    }**/

/**
    @Before("execution(public void com.zeco.aopDemo.dao.AccountDAO.addAccount())")
    public void beforeAddAccountAdvice() {

        System.out.println("\n=====>>> Executing @Before advice on addAccount()");

    }**/


/**
    @Before("execution(public void add*())")
    public void beforeAddAccountAdvice() {

        System.out.println("\n=====>>> Executing @Before advice on addAccount()");

    }**/

    /***@Before("execution(* add*())")
    public void beforeAddAccountAdvice() {

        System.out.println("\n=====>>> Executing @Before advice on method");

    }**/

   /** @Before("execution(* add*(com.zeco.aopDemo.Account))")
    public void beforeAddAccountAdvice() {

        System.out.println("\n=====>>> Executing @Before advice on method");

    }**/

   /** first parameter should be of Account type, then the next params could be of any type**/
   /**@Before("execution(* add*(com.zeco.aopDemo.Account, ..))")
   public void beforeAddAccountAdvice() {

       System.out.println("\n=====>>> Executing @Before advice on method");

   }***/

   /**@Before("execution(* add*(..))")
   public void beforeAddAccountAdvice() {

       System.out.println("\n=====>>> Executing @Before advice on method");
   }**/

   //match any method in this our package
   @Before("execution(* com.zeco.aopDemo.dao.*.*(..))")
   public void beforeAddAccountAdvice() {

       System.out.println("\n=====>>> Executing @Before advice on method");

   }
}
