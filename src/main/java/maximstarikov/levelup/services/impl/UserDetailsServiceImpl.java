package maximstarikov.levelup.services.impl;

import lombok.RequiredArgsConstructor;
import maximstarikov.levelup.services.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserService userService;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        return userService.getByLoginWithRoles(login).orElseThrow(() -> new UsernameNotFoundException(""));
    }
}
