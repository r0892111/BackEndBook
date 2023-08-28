package karelbackend.demo.User.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import karelbackend.demo.User.model.User;
// import karelbackend.demo.User.service.*;
import karelbackend.demo.User.service.UserService;
import karelbackend.demo.User.service.UserServiceException;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin(origins = "http://127.0.0.1:3000")
@RestController
@RequestMapping("/users")
public class UserRestController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/oldest")
    public User getOldestUser() throws UserServiceException {
        return userService.getOldestUser();
    }

    @GetMapping("/search/olderthan")
    public List<User> searchUsersWithAgeOlderThan(@RequestParam("age") int age) throws UserServiceException {
        return userService.getUsersWithAgeOlderThan(age);
    }

    @GetMapping("/search/{name}")
    public User searchUserWithName(@PathVariable("name") String name) {
        return userService.getUserWithName(name);
    }
    @GetMapping("/adults")
    public List<User> getUsersWithAgeOlderThan() throws UserServiceException{
        return userService.getUsersWithAgeOlderThan(18);
    }
    @GetMapping("/search/email/{email}")
    public User searchUserWithEmail(@PathVariable("email")String Email) throws UserServiceException{
        return userService.getUserWithEmail(Email);
    }

    @GetMapping("/search")
    public List<User> searchUserswithAgeAndEmail(@RequestParam("email")String email, @RequestParam("age")int age){
        return userService.getUsersWithAgeAndEmail(age,email);
    }
    @GetMapping("/search/age/{min}/{max}")
    public List<User> searchUserBetweenAges(@PathVariable("min")int min, @PathVariable("max")int max){
        return userService.getUsersBetweenAges(min,max);
    }

    @GetMapping("/search/membership/{year}")
    public List<User> getUsersWithMembershipsFromYear(@PathVariable("year")int year){
        return userService.getListOfAllUsersWithMembershipFromYear(year);
    }

    @PostMapping()
    public User addUser(@RequestBody User user) throws UserServiceException {
        return userService.addUser(user);
    }
    @DeleteMapping("/{email}")
    public User deleteUser(@PathVariable("email")String email) throws UserServiceException{
        return userService.delete(email);
    }

}