package grsu.lection.controller;

import grsu.lection.service.api.BeetleService;
import grsu.lection.service.dto.BeetleDictionaryDto;
import grsu.lection.service.dto.CreateBeetleDto;
import grsu.lection.service.dto.GetBeetleDto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
@RequestMapping(path = "/api/beetle", consumes = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class BeetleController {

    private final BeetleService beetleService;

    @PostConstruct
    public void init() {
        System.out.println("test");
    }

    @PostMapping
    public ResponseEntity<Void> createBeetle(@RequestBody CreateBeetleDto dto) {
        beetleService.save(dto);
        return ResponseEntity.ok().build();

        //model view controller
        //model - взаимодействует с бд
        //controller - обеспечивает взаимодействие между model и view
        //view - взаимодействует с клиентом
    }

    @GetMapping
    public ResponseEntity<List<GetBeetleDto>> getAll() {
        return ResponseEntity.ok(beetleService.getAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<GetBeetleDto> getById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(beetleService.getById(id));
    }

    @GetMapping(path = "/dictionary")
    public ResponseEntity<List<BeetleDictionaryDto>> getBeetleDictionary() {
        return ResponseEntity.ok(beetleService.getDictionary());
    }
}
