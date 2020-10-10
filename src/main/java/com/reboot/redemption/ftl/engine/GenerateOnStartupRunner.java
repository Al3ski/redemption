package com.reboot.redemption.ftl.engine;

import com.reboot.redemption.ftl.engine.generator.TemplateGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Objects;

@Slf4j
@Component
public class GenerateOnStartupRunner implements ApplicationRunner {
    private final TemplateEntityService templateEntityService;
    private final Collection<TemplateGenerator> templateGenerators;

    @Autowired
    public GenerateOnStartupRunner(Collection<TemplateGenerator> templateGenerators,
                                   TemplateEntityService templateEntityService) {
        this.templateGenerators = templateGenerators;
        this.templateEntityService = templateEntityService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        templateGenerators.stream()
                .filter(Objects::nonNull)
                .forEach(templateGenerator -> {
                    if (!templateGenerator.isSameVersion(templateGenerator.getVersion())) {
                        TemplateEntity templateEntity = templateGenerator.generate();
                        if (!templateEntityService.isDummyTemplate(templateEntity)) {
                            templateEntityService.saveTemplate(templateEntity);
                        }
                    }
                });
    }
}
