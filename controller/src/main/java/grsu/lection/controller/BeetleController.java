package grsu.lection.controller;

import grsu.lection.dao.filter.BeetleSearch;
import grsu.lection.service.api.BeetleService;
import grsu.lection.service.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.util.List;

@RestController
@RequestMapping(path = "/api/beetle", consumes = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Validated
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

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteBeetle(@PathVariable(name = "id") Long id) {
        beetleService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<GetBeetleDto>> getAll() {
        return ResponseEntity.ok(beetleService.getAll());
    }

    @GetMapping(path = "/{id}")
    @Secured({"ROLE_ADMIN"})
    public ResponseEntity<GetBeetleDto> getById(@Positive @PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(beetleService.getById(id));
    }

    @GetMapping(path = "/dictionary")
    @Secured("ROLE_USER")
    public ResponseEntity<List<BeetleDictionaryDto>> getBeetleDictionary() {
        return ResponseEntity.ok(beetleService.getDictionary());
    }

    @GetMapping(path = "/name/{name}")
    public ResponseEntity<List<GetBeetleDto>> findAllByName(@PathVariable(name="name") String name) {
        return ResponseEntity.ok(beetleService.findAllByName(name));
    }

    @GetMapping(path = "search")
    public ResponseEntity<List<GetBeetleDto>> search(@Positive @RequestParam(defaultValue = "10") Integer size,
                                                     @PositiveOrZero @RequestParam(defaultValue = "0") Integer page,
                                                     BeetleSearch search) {
        return ResponseEntity.ok(beetleService.search(size, page, search));
    }
}

//создать жука - MODER, ADMIN
//удалить жука - ADMIN
//посмотреть жука - USER, MODER, ADMIN
//переименовать жука - MODER, ADMIN

//CREATE_BEETLE, DELETE_BEETLE, SHOW_BEETLE, UPDATE_BEETLE