package com.mysite.sbb.question;

import com.mysite.sbb.answer.Answer;
import com.mysite.sbb.user.SiteUser;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 200)
    private String subject;

    @Column(columnDefinition = "TEXT")
    private String content;

    @ManyToOne
    private SiteUser author;

    private LocalDateTime createDate;

    private LocalDateTime modifyDate;

    @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    private List<Answer> answerList;
}
