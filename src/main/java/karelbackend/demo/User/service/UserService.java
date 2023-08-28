package karelbackend.demo.User.service;

import java.util.ArrayList;
import java.util.List;

// import org.hibernate.service.spi.UserServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import karelbackend.demo.User.model.User;
import karelbackend.demo.User.repo.UserRepository;

@Service
public class UserService {

    // public List<User> userRepository = new ArrayList<>();
    @Autowired
    private UserRepository userRepository;

    // public User(){
        

    //     elke.addMembershipYear(2000);
    // }

    public UserService() {
        // User elke = new User("Elke", 44,"str@str1","str");
        // elke.addMembershipYear(2000);
        // userRepository.add(elke);
        // userRepository.add(new User("Elke", 10,"str@str2","str"));
        // userRepository.add(new User("Miyo", 30,"str@str3","str"));
        // userRepository.add(new User("John2", 70,"str@str4","str"));
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public List<User> getUsersWithAgeOlderThan(int age) throws UserServiceException{
        if(userRepository.findUsersByAgeAfter(age).isEmpty()){
            throw new UserServiceException("users", "no users with age "+age+ " found");
        }
       
        
        return userRepository.findUsersByAgeAfter(age);
        
    }
    
   

    public User getUserWithName(String name) {
        return userRepository.findUserByName(name);
    }

    public User addUser(User user) throws UserServiceException {
        // Attempt to get the user by email
        User existingUser = userRepository.findUserByEmail(user.getEmail());
    
        // Check if a user with the email already exists
        if (existingUser != null) {
            throw new UserServiceException("email", "email already taken");
        }
        
        // If the email is not taken, save the user
        userRepository.save(user);
        return user;
    }
    

    public User getUserWithEmail(String email)throws UserServiceException{
        User user = userRepository.findUserByEmail(email);
        if(user == null){
            throw new UserServiceException("user", "no user found with email: "+email);
        }
        
        return user;
           
    }

    public User removeUser(String email)throws UserServiceException{
        if(userRepository.findUserByEmail(email)==null){
            throw new UserServiceException("user","user with this email does not exist");
        }
        userRepository.deleteByEmail(email);
        return userRepository.findUserByEmail(email);
    }

    public List<User> getListOfAllUsersWithMembershipFromYear(int year){
        List<User> AllUsers = userRepository.findAll();
        List<User> filteredUsers = new ArrayList<>();
        for (User user:AllUsers){
            if(user.membershipYears.contains(year)){
                filteredUsers.add(user);
            }
        }return filteredUsers;

    }

    public List<User> getUsersWithAgeAndEmail(int age, String email){
        return userRepository.findUsersByAgeAndEmail(age,email);
    }

    public List<User> getUsersBetweenAges(int min,int max){
        return userRepository.findUsersByAgeBetween(min, max);
    }
   

    public User getOldestUser() throws UserServiceException{
        List<User> array = userRepository.findAllByOrderByAgeDesc();
        if(array==null || array.isEmpty()){
            throw new UserServiceException("users", "no oldest user found");
        }
        return userRepository.findAllByOrderByAgeDesc().get(0);
    }

    public User delete(String email)throws UserServiceException{
        User var = getUserWithEmail(email);
        if(var==null){
            throw new UserServiceException(email, email);
        }
        userRepository.delete(var);
        return var;
    }

// public class UserServiceException extends Exception{
//     private String field;
//     public UserServiceException(String field, String message) {
//         super(message);
//         this.field = field;
//     }
//     public String getField(){
//         return field;
//     }
// }
}