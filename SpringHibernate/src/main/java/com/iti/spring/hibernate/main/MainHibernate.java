package com.iti.spring.hibernate.main;


import com.iti.spring.hibernate.cfg.AppConfig;
import com.iti.spring.hibernate.model.dao.UserDAOSecured;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextImpl;

public class MainHibernate {

    String userName = "mohamed";
    String password = "123456";
    ApplicationContext context;

    public MainHibernate() {
        context = new AnnotationConfigApplicationContext(AppConfig.class);
        UsernamePasswordAuthenticationToken token = createUsernamePasswordAuthenticationToken(userName, password);
        Authentication authentication = authenticate(token);
        setSecurityContext(authentication);

        UserDAOSecured userDAO = context.getBean(UserDAOSecured.class);
        System.out.println(userDAO.retrieveByUserName("Feras2").getFullName());

    }

    public static void main(String[] args) {
        new MainHibernate();
    }

    private UsernamePasswordAuthenticationToken createUsernamePasswordAuthenticationToken(String userName, String password) {

          /*  String roles[] = {"ROLE_USER","ROLE_ADMIN"};
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>(roles.length);

        for(String role :roles){
            grantedAuthorities.add(new SimpleGrantedAuthority(role));
        }*/

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userName, password);
        return authenticationToken;
    }

    private Authentication authenticate(UsernamePasswordAuthenticationToken token) {
        AuthenticationManager authenticationManager = context.getBean(AuthenticationManager.class);

        Authentication authentication = authenticationManager.authenticate(token);
        return authentication;
    }

    private void setSecurityContext(Authentication authentication) {
        SecurityContextImpl securityContext = new SecurityContextImpl();
        securityContext.setAuthentication(authentication);
        SecurityContextHolder.setContext(securityContext);
    }
}
