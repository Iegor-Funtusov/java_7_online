package ua.com.alevel.api.controller.personal;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/private/personal")
public class PersonalTestController {

    @GetMapping
    public String test() {
        return "Hello";
    }
}
