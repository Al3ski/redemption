package com.reboot.redemption.ftl.engine;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import java.util.UUID;

@Entity(name = "FTL_TEMPLATES")
@Table(name = "FTL_TEMPLATES")
@Data
public class TemplateEntity {
    public static TemplateEntity DUMMY_TEMPLATE = new TemplateEntity(
            "EMPTY",
            "EMPTY",
            0
    );

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", columnDefinition = "UUID", nullable = false, unique = true)
    private UUID id;

    @NonNull
    @Column(name = "template_name", nullable = false)
    private String templateName;

    @NonNull
    @Column(name = "template_body", nullable = false, length = 1999)
    private String templateBody;

    @NonNull
    @Column(name = "version", nullable = false)
    private int version;
}
