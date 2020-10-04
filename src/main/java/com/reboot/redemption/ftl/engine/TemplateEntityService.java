package com.reboot.redemption.ftl.engine;

import java.math.BigInteger;

public interface TemplateEntityService {

    void saveTemplate(TemplateEntity templateEntity);

    TemplateEntity loadTemplate(String templateName);

    void deleteTemplate(String templateName);
}
