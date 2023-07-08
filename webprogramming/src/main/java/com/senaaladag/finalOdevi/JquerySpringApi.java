package com.senaaladag.finalOdevi;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
//LOMBOK
@RequiredArgsConstructor //injection
@Log4j2

//API: Dış Dünyaya açılan kapıdır.
@RestController
@RequestMapping("/api/v1/jquery")
@CrossOrigin //(origins = "http://localhost:3000")
public class JquerySpringApi  {
    //INJECTION
    private final IJqueryService iJqueryService;

    @PostMapping(value = "/post",consumes={"application/json"})
    public ResponseEntity<JqueryDto>  createRegister(@Valid @RequestBody(required = true) JqueryDto jqueryDto) { //@RequestBody(required = false)
        System.out.println(jqueryDto);
        iJqueryService.createRegister(jqueryDto);
        return ResponseEntity.ok(jqueryDto);
    }
    // http://localhost:4444/api/v1/jquery/get
    @GetMapping(value = "/get")
    public ResponseEntity<List<JqueryDto>>  getAllRegisters() {
        return ResponseEntity.ok(iJqueryService.getAllRegisters());
    }
}