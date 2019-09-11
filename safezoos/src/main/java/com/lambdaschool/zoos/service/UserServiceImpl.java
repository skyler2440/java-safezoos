package com.lambdaschool.zoos.service;

import com.lambdaschool.zoos.model.User;
import com.lambdaschool.zoos.repository.RoleRepository;
import com.lambdaschool.zoos.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        return null;
    }

    @Override
    public User findUserByName(String name)
    {
        return null;
    }

    @Override
    public User findUserById(long id)
    {
        return null;
    }

    @Override
    public void delete(long id)
    {

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
