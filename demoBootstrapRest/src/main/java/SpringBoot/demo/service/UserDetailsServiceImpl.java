package SpringBoot.demo.service;

import SpringBoot.demo.model.Role;
import SpringBoot.demo.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Collection;

@Service("userDetailsServiceImpl")
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserService userService;

    @Autowired
    public UserDetailsServiceImpl(UserService userService) {
        this.userService = userService;
    }

        @Override
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            User user = userService.findUserByUsername(username);
            return new org.springframework.security.core.userdetails.User(
                    user.getUsername(),
                    user.getPassword(),
                    getAuthorities(user)
            );
        }

    private static Collection<? extends GrantedAuthority> getAuthorities(User user) {
        String[] roles = user.getRoles().stream().map(Role::getRole).toArray(String[]::new);
        return AuthorityUtils.createAuthorityList(roles);
        }
}
