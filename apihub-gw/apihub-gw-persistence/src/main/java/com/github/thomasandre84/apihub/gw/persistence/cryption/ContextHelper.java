package com.github.thomasandre84.apihub.gw.persistence.cryption;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.spi.BeanManager;

@ApplicationScoped
public class ContextHelper {

    private static BeanManager beanManager;

    public ContextHelper(BeanManager beanManager) {
        ContextHelper.beanManager = beanManager;
    }

    static BeanManager getBeanManager(){
        return ContextHelper.beanManager;
    }

}
