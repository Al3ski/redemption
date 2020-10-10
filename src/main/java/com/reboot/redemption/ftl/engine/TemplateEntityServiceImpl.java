package com.reboot.redemption.ftl.engine;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class TemplateEntityServiceImpl implements TemplateEntityService {
    private final TemplateEntityRepository templateEntityRepository;

    @Autowired
    public TemplateEntityServiceImpl(TemplateEntityRepository templateEntityRepository) {
        this.templateEntityRepository = templateEntityRepository;
    }

    @Override
    public void saveTemplate(@NonNull TemplateEntity templateEntity) {
        logger.debug("Saving Template Entity with name: {}, version: {}",
                templateEntity.getTemplateName(), templateEntity.getVersion());
        templateEntityRepository.save(templateEntity);
    }

    @Override
    public TemplateEntity loadTemplate(@NonNull String templateName) {
        logger.debug("Searching for Template Entity with name: {}", templateName);
        return templateEntityRepository.findByTemplateName(templateName);
    }

    @Override
    public void deleteTemplate(@NonNull String templateName) {
        logger.debug("Deleting Template Entity with name: {}", templateName);
        templateEntityRepository.deleteTemplateEntityByTemplateName(templateName);
    }

    @Override
    public boolean isDummyTemplate(TemplateEntity templateEntity) {
        return "EMPTY".equals(templateEntity.getTemplateName())
                && "EMPTY".equals(templateEntity.getTemplateBody())
                && 0 == templateEntity.getVersion();
    }
}
