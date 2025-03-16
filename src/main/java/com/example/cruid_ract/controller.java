package com.example.cruid_ract;

import org.antlr.v4.runtime.atn.SemanticContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.time.LocalDate;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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
@GetMapping("/{id}")
public ResponseEntity<entity> book(@PathVariable("id") Long id){

    Optional<entity> book=jpac.findById(id);
    if(book.isPresent()){
        return ResponseEntity.ok(book.get());
    }
    return ResponseEntity.notFound().build();
}
@PostMapping()
    ResponseEntity<String >bookcreate(@RequestBody entity book){
   try{
       book.setDueDate(LocalDate.now());
   jpac.save(book);
   }catch (Exception e){
       return ResponseEntity.badRequest().build();
   }
  return ResponseEntity.ok("book created");
    }

    @PutMapping("/{id}")
    entity updatebook(@PathVariable Long id ,@RequestBody entity book){

         entity old=jpac.findById(id).orElse(null);
         if(old!=null){
             old.setName(book.getName()!=null&&!book.equals("")?book.getName():old.getName());
             old.setPhone(book.getPhone()!=0 ?book.getPhone():old.getPhone());

         } jpac.save(old);
return old;
    }

    @DeleteMapping("/{id}")
    ResponseEntity<?> deletebook(@PathVariable Long id){
    entity book=jpac.findById(id).orElse(null);
    if (book!=null){
        jpac.delete(book);
        return  new ResponseEntity<>("book deleted", HttpStatus.NO_CONTENT);

    }
  return new ResponseEntity<>("book not found", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/deleteall")
String deleteall (){
        jpac.deleteAll();
        return "success all books";
    }


    @GetMapping("/{id}/fine")
    public ResponseEntity<String> getFine(@PathVariable Long id, @RequestParam String returnDate) {
        LocalDate date = LocalDate.parse(returnDate);
        int fineAmount =BookService.calculateFine(id,date);
        return ResponseEntity.ok("Fine amount: ₹" + fineAmount);
    }
}
