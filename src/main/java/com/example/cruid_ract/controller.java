package com.example.cruid_ract;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/books")
public class controller {
@Autowired
    jpa jpac;
@GetMapping
List<entity> allbook(){
    return jpac.findAll();
}

@PostMapping()
    String bookcreate(@RequestBody entity book){
    System.out.println(book);
    System.out.println(book.getId());
    System.out.println(book.getName());
    System.out.println(book.getPhone());
    jpac.save(book);
    return "success";
    }

    @PutMapping("/{id}")
    entity updatebook(@PathVariable Long id ,@RequestBody entity book){

            if(jpac.findById(id).isEmpty()){
                return null;
            }else{
                entity book1=jpac.findById(id).orElseThrow();
                book1.setName(book.getName());
                book1.setPhone(book.getPhone());
                return jpac.save(book1);
            }
    }

    @DeleteMapping("/{id}")
    String deletebook(@PathVariable Long id){
    jpac.deleteById(id);
    return "success";
    }


}
