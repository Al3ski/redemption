package com.reboot.redemption.ftl.engine.generator;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.reboot.redemption.ftl.engine.TemplateEntity;
import com.reboot.redemption.mvc.dto.UserInfoDto;
import freemarker.template.Template;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component
public class UserPageGenerator extends AbstractTemplateGenerator {
    //versions handling manually
    private int version = 1;

    private final FreeMarkerConfigurer freeMarkerConfigurer;
    private final ObjectMapper objectMapper;

    @Autowired
    public UserPageGenerator(FreeMarkerConfigurer freeMarkerConfigurer,
                             ObjectMapper objectMapper) {
        this.freeMarkerConfigurer = freeMarkerConfigurer;
        this.objectMapper = objectMapper;
        templateFileName = "user_operations_page.ftl";
    }

    @Override
    public int getVersion() {
        return version;
    }

    @Override
    public TemplateEntity generate() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        dateTimeFormatter.withZone(ZoneId.of("UTC"));

        Map<String, Object> root = new HashMap<>();
        UserInfoDto userInfoDto = new UserInfoDto(
                "${user.name}",
                "${user.surname}",
                "${user.email}",
                LocalDate.parse("09.05.1990", dateTimeFormatter)
        );
        root.put("userInfo", userInfoDto);

        TemplateEntity templateEntity = TemplateEntity.DUMMY_TEMPLATE;

        File templateFile = new File("src/main/resources/templates/" + templateFileName);

        try (Writer writer = new OutputStreamWriter(new FileOutputStream(templateFile), StandardCharsets.UTF_8)) {
            Template template = freeMarkerConfigurer.getConfiguration().getTemplate(templateFileName);
            template.process(root, writer);
            writer.flush();
            logger.info("Saving generated file {}, version: {}", templateFileName, version);

            templateEntity = new TemplateEntity(
                    templateFileName,
                    objectMapper.writeValueAsString(root),
                    this.version
            );
        } catch (Exception e) {
            logger.error("File writing using the Freemarker template engine failed!", e);
        }
        return templateEntity;
    }
}
