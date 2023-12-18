package com.sravs.controller;

import com.sravs.entities.Interest;
import com.sravs.entities.UserAccount;
import com.sravs.repo.InterestRepo;
import com.sravs.repo.UserAccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.ConstraintViolationException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserAccountController {
    @Autowired
    private UserAccountRepo userAccountRepo;

    @Autowired
    private InterestRepo interestRepo;

    @PostMapping("users/register-user")
    public UserAccount register(@RequestBody UserAccount userAccount) {
       try {
           return userAccountRepo.save(userAccount);
       } catch (ConstraintViolationException e){
           throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
       }

    }

    @PostMapping("/interest/update")
    public Interest updateInterest(@RequestBody Interest interest) {
        UserAccount account = userAccountRepo.findById(interest.getUserAccountId()).get();
        interest.setUserAccount(account);
        return interestRepo.save(interest);
    }
    @GetMapping("/user/get/all")
    public List<UserAccount> getllUsers(){
        return userAccountRepo.findAll();
    }
@DeleteMapping("users/delete/{id}")
    public void deleteInterest(@PathVariable("id")int id){
         interestRepo.deleteById(id);
    }
    @GetMapping("/matches/{id}")
   public  List<UserAccount> findMatches(@PathVariable("id")int id){
        UserAccount account = userAccountRepo.findById(id).get();
        return userAccountRepo.findMatches(account.getAge(),account.getCity(),account.getCountry(),account.getId());
   }

}
