package com.lambdaschool.zoos.controller;

import com.lambdaschool.zoos.model.Zoo;
import com.lambdaschool.zoos.service.ZooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/zoos")
public class ZooController
{
    @Autowired
    private ZooService zooService;

    // GET: localhost:2019/zoos/zoos
    @GetMapping(value = "/zoos", produces = {"application/json"})
    public ResponseEntity<?> listAllZoos()
    {
        return new ResponseEntity<>(zooService.findAll(), HttpStatus.OK);
    }

    //127.0.0.1:2019/zoos/zoos/{id} -- Get zoo by id
    @GetMapping(value = "/zoos/{zooid}", produces = {"application/json"})
    public ResponseEntity<?> findZooById(@PathVariable long zooid)
    {
        Zoo z = zooService.findZooById(zooid);
        return new ResponseEntity<>(z, HttpStatus.OK);
    }
    //127.0.0.1:2019/zoos/{name} -- Get zoo by name
    @GetMapping(value = "/{name}", produces = {"application/json"})
    public ResponseEntity<?> getZooByName(@PathVariable String name)
    {
        Zoo z = zooService.findZooByName(name);
        return new ResponseEntity<>(z, HttpStatus.OK);
    }

}
