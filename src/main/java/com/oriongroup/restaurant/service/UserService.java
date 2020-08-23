package com.oriongroup.restaurant.service;


import com.oriongroup.restaurant.AuthorizedUser;
import com.oriongroup.restaurant.model.User;
import com.oriongroup.restaurant.repository.JPA.UserRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

import static com.oriongroup.restaurant.util.UserUtil.prepareToSave;
import static com.oriongroup.restaurant.util.ValidationUtil.checkNotFoundWithId;
@Service("userService")
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UserService implements UserDetailsService {

    protected final Logger log= LoggerFactory.getLogger(getClass());
    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepo userRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }
    private User prepareAndSave(User user) {
        return userRepo.save(prepareToSave(user, passwordEncoder));
    }

    @Transactional
    public void enable(int id, boolean enabled) {
        User user = get(id);
        user.setEnabled(enabled);
        userRepo.save(user);  // !! need only for JDBC implementation
    }
    @Override
    public AuthorizedUser loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepo.getByEmail(email.toLowerCase());
        if (user == null) {
            throw new UsernameNotFoundException("User " + email + " is not found");
        }
        return new AuthorizedUser(user);
    }

    public List<User> getAll(){
        log.info("getAll");
        List<User> u=userRepo.getAll();
        u.forEach(a->log.info("id:"+a.id()+" role:"+a.getRoles().toString()));
        return u;
    }

    public User get(Integer id){
        log.info("GET");
        return checkNotFoundWithId(userRepo.get(id),id);
    }

    public User create(User user){
        log.info("create");
        Assert.notNull(user,"user must not be null");
        return userRepo.save(user);
    }

    public void update(User user){
        log.info("update");
        Assert.notNull(user,"restaurant must not be null");
        checkNotFoundWithId(userRepo.save(user),user.id());
        log.info(user.getClass().getSimpleName()+":name:"+user.getName());
    }

    public void delete( int id){
        log.info("delete");
        checkNotFoundWithId(userRepo.delete(id),id);
    }
}
