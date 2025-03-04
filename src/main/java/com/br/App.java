package com.br;

import com.br.autowired.bean.SingletonBean;
import com.br.autowired.container.BeansContainer;
import com.br.autowired.lifecycle.Shutdown;
import com.br.samples.service.UserService;

public class App {
  public static void main(String[] args) throws Exception {
    Shutdown shutdownHook = new Shutdown();
    BeansContainer container = new BeansContainer();
    shutdownHook.attachShutdown(container);
    try {
      SingletonBean singletonBean = new SingletonBean();
      singletonBean.initializeSingletonBean("testUser", UserService.class, container);
      Object testUserObj = container.getSingletonBean("testUser");
      UserService testUser = UserService.class.cast(testUserObj);
      System.out.println("TEST USER 1: " + testUser);
    } catch (InterruptedException ex) {
      ex.printStackTrace();
    }
  }
}
