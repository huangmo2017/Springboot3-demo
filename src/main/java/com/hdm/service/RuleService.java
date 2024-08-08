package com.hdm.service;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.internal.io.ResourceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
public class RuleService {

    private final KieSession kieSession;
    private final KieContainer kieContainer;
    private long lastModifiedTime = 0;

    @Autowired
     public RuleService(KieSession kieSession, KieContainer kieContainer) {
         this.kieSession = kieSession;
         this.kieContainer = kieContainer;
     }

     public void executeRules() {
         // 获取决策表文件的最后修改时间
         long currentModifiedTime = 0;
         try {
             currentModifiedTime = Files.getLastModifiedTime(Paths.get("path/to/your/decision-table.xlsx")).toMillis();
         } catch (IOException e) {
             throw new RuntimeException(e);
         }

         if (currentModifiedTime > lastModifiedTime) {
             // 决策表有更新，重新加载决策表并重新初始化 session
             kieFileSystem.write(ResourceFactory.newClassPathResource("decision-table.xlsx"));
             kieBuilder.buildAll();
             kieContainer.updateToVersion(kieBuilder.getKieModule().getReleaseId());
             lastModifiedTime = currentModifiedTime;
         }

         // 执行规则
         kieSession.fireAllRules();
     }
}
