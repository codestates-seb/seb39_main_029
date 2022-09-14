package Team049.Iguwana.MainProject.PrimaryEntity.teacher.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;

@RestController
@RequestMapping("/v1/teacher")
@Validated
@Slf4j
public class TeacherController {

    @GetMapping
    public ResponseEntity createTeacher() {

        HashMap<String, String> map = new HashMap<>();
        map.put("result", "hello");
        return new ResponseEntity( map, HttpStatus.CREATED);
    }
}
