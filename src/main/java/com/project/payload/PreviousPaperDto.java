package com.project.payload;

import com.project.entity.Subject;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.ManyToOne;

@Getter
@Setter
@NoArgsConstructor
public class PreviousPaperDto {

    private int id;

    private String title;
    private int year;
    private int semester;
    private String questionPaperUrl;
    private String answerUrl;
    private SubjectDto subject;

}
