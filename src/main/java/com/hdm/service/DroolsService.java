package com.hdm.service;

import com.hdm.pojo.FactType;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DroolsService {

    private final KieContainer kieContainer;

    @Autowired
    public DroolsService(KieContainer kieContainer) {
        this.kieContainer = kieContainer;
    }

    public void executeRules() {
        KieSession kieSession = kieContainer.newKieSession();
        try {
            // 添加事实对象
            FactType fact = new FactType();
            // 设置事实对象的属性
            kieSession.insert(fact);

            // 触发规则执行
            kieSession.fireAllRules();
        } finally {
            kieSession.dispose();
        }
    }
}
