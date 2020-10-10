package com.reboot.redemption.ftl.engine.generator;

import com.reboot.redemption.ftl.engine.TemplateEntity;

public interface TemplateGenerator {

    TemplateEntity generate();

    int getVersion();

    boolean isSameVersion(int version);
}
