package com.reboot.redemption.ftl.engine;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface TemplateEntityRepository extends CrudRepository<TemplateEntity, BigInteger> {

    TemplateEntity findByTemplateName(String templateName);

    void deleteTemplateEntityByTemplateName(String templateName);

    @Query("select version from ftl_templates where template_name = :templateName")
    int getVersionByTemplateName(String templateName);
}
