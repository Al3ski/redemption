package com.reboot.redemption.ftl.engine;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.Optional;

@Repository
public interface TemplateEntityRepository extends CrudRepository<TemplateEntity, BigInteger> {

    TemplateEntity findByTemplateName(String templateName);

    void deleteTemplateEntityByTemplateName(String templateName);

    @Query("select version from FTL_TEMPLATES where template_name = :templateName")
    Optional<Integer> getVersionByTemplateName(@Param("templateName") String templateName);
}
