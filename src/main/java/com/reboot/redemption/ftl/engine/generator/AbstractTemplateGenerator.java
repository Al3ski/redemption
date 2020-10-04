package com.reboot.redemption.ftl.engine.generator;

import com.reboot.redemption.ftl.engine.TemplateEntity;
import com.reboot.redemption.ftl.engine.TemplateEntityRepository;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;

@NoArgsConstructor
public abstract class AbstractTemplateGenerator {
    protected String templateFileName = "default_page.ftl";

    protected TemplateEntityRepository templateEntityRepository;

    @Autowired
    public AbstractTemplateGenerator(TemplateEntityRepository templateEntityRepository) {
        this.templateEntityRepository = templateEntityRepository;
    }

    public abstract TemplateEntity generate();

    public void saveTemplate(@NonNull TemplateEntity templateEntity) {
        templateEntityRepository.save(templateEntity);
    }
}
