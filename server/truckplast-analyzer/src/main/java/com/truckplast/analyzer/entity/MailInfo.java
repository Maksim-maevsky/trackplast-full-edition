package com.truckplast.analyzer.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.mail.Multipart;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "mail_infos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MailInfo {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;

    @Column(name = "subject")
    private String subject;

    @Column(name = "from_full_name")
    private String from;

    @Column(name = "date")
    private LocalDateTime dateTime;

    @Transient
    private Multipart multipart;

    @Transient
    private List<FileInfo> fileInfoList;



}
