package com.firstRestWeb.Restfulwebservices.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

@Component
public class UserDaoService {
    private static List<User>users = new ArrayList<>() ;
    private static Integer usersCount =0 ;

    public UserDaoService() {
    }

    static {
        users.add(new User(++usersCount,"Adam", LocalDate.now().minusYears(30)));
        users.add(new User(++usersCount,"jim",LocalDate.now().minusYears(20)));
    }

    public List<User> findAll() {
        return users;
    }

    public User findOne(Integer id) {
//        for(User u: users ){
//            if(Objects.equals(u.getId(), id)){
//                return u ;
//            }
//        }
//        return null;
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        return users.stream().filter(predicate).findFirst().get();

    }
    public User save(User user){
        user.setId(++usersCount);
        users.add(user);
        return user ;
    }

    public void deleteById(int id) {
        users.removeIf(user -> user.getId().equals(id));
    }
}
