package com.reboot.redemption.ftl.engine.generator;

import com.reboot.redemption.ftl.engine.TemplateEntityRepository;
import com.reboot.redemption.ftl.engine.TemplateEntityService;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@Slf4j
@NoArgsConstructor
public abstract class AbstractTemplateGenerator implements TemplateGenerator {
    protected String templateFileName = "default_page.ftl";

    protected TemplateEntityRepository templateEntityRepository;
    protected TemplateEntityService templateEntityService;

    @Autowired
    public final void setTemplateEntityService(TemplateEntityService templateEntityService) {
        this.templateEntityService = templateEntityService;
    }

    @Autowired
    public final void setTemplateEntityRepository(TemplateEntityRepository templateEntityRepository) {
        this.templateEntityRepository = templateEntityRepository;
    }

    @Override
    public boolean isSameVersion(int version) {
        Optional<Integer> savedVersion = templateEntityRepository.getVersionByTemplateName(templateFileName);
        return savedVersion.isPresent() && savedVersion.get() == version;
    }
}
