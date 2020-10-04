package com.reboot.redemption.ftl.engine;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import java.util.concurrent.atomic.AtomicInteger;

@Entity
@Table(name = "FTL_TEMPLATES")
@Data
public class TemplateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false, unique = true)
    private int id;

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
