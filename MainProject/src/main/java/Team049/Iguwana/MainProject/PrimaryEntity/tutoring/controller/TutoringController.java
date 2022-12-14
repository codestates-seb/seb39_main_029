package Team049.Iguwana.MainProject.PrimaryEntity.tutoring.controller;

import Team049.Iguwana.MainProject.PrimaryEntity.tutoring.dto.TutoringDto;
import Team049.Iguwana.MainProject.PrimaryEntity.tutoring.entity.Tutoring;
import Team049.Iguwana.MainProject.PrimaryEntity.tutoring.mapper.TutoringMapper;
import Team049.Iguwana.MainProject.PrimaryEntity.tutoring.service.TutoringService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;
import java.util.List;

@RestController
@RequestMapping("/v1/tutorings")
@Validated
public class TutoringController {
    private final TutoringMapper tutoringMapper;
    private final TutoringService tutoringService;

    public TutoringController(TutoringMapper tutoringMapper, TutoringService tutoringService){
        this.tutoringMapper = tutoringMapper;
        this.tutoringService = tutoringService;
    }

    @PostMapping("/register")
    public ResponseEntity registerTutoring(@Validated @RequestBody TutoringDto.Register register){
        Tutoring tutoring = tutoringMapper.tutoringRegisterToTutoring(register);
        Tutoring response = tutoringService.createdTutoring(tutoring, tutoringService.codeToStudent(register.getStudentId()), tutoringService.codeToTeacher(register.getTeacherId()));
        return new ResponseEntity(tutoringMapper.tutoringToTutoringResponse(response),HttpStatus.CREATED);
    }

    @PatchMapping("/update/{tutoring-id}")
    public ResponseEntity updateTutoring(@PathVariable("tutoring-id") long tutoringId,
                                         @RequestBody TutoringDto.Patch patch){
        patch.setTutoringId(tutoringId);
        Tutoring tutoring = tutoringMapper.tutoringPatchToTutoring(patch);
        Tutoring updateTutoring = tutoringService.updateTutoring(tutoring);

        return new ResponseEntity(tutoringMapper.tutoringToTutoringResponse(updateTutoring), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{tutoring-id}")
    public ResponseEntity deleteTutoring(@PathVariable("tutoring-id") long tutoringId){
        tutoringService.deleteTutoring(tutoringId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{teacher-id}")
    public ResponseEntity getTutoring(@Positive @PathVariable("teacher-id") long teacherId,
                                      @RequestParam String date){
        List<Tutoring> tutoringPage = tutoringService.findTutorings(teacherId);
        List<TutoringDto.Response> responses = tutoringService.tutoringConvert(tutoringPage, date);
        return new ResponseEntity(responses, HttpStatus.OK);
    }
}
