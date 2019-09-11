package com.lambdaschool.zoos.service;

import com.lambdaschool.zoos.model.User;
import com.lambdaschool.zoos.repository.RoleRepository;
import com.lambdaschool.zoos.repository.UserRepository;
import org.slf4j.ILoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service(value="userService")
public class UserServiceImpl implements UserDetailsService, UserService
{
    @Autowired
    private UserRepository userrepos;
    @Autowired
    private RoleRepository rolerepos;

    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        User user = userrepos.findByUsername(username);
        if(user == null)
        {
            throw new UsernameNotFoundException("Invalid UserName or Password");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), user.getAuthority());
    }
    @Override
    public List<User> findAll()
    {
        ArrayList<User> list = new ArrayList<>();
        userrepos.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public User findUserByName(String name)
    {
        return null;
    }

    @Override
    public User findUserById(long id) throws EntityNotFoundException
    {
        return userrepos.findById(id).orElseThrow(() -> new EntityNotFoundException(Long.toString(id)));
    }

    @Transactional
    @Override
    public void delete(long id) throws EntityNotFoundException
    {
        if (userrepos.findById(id).isPresent())
        {
            userrepos.deleteById(id);

        }else
        {
            throw new EntityNotFoundException(Long.toString(id));
        }
    }

    @Override
    public User save(User user)
    {
        return null;
    }

    @Override
    public User update(User user, long id)
    {
        return null;
    }


}
