package com.zeco.aopDemo.dao;

import com.zeco.aopDemo.Account;

public interface AccountDAO {

   /** void addAccount();**/
   //void addAccount(Account theAccount);
   void addAccount(Account theAccount, boolean vipFlag);

   boolean doWork();
}
