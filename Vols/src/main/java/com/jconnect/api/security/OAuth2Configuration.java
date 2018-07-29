package com.jconnect.api.security;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

import com.jconnect.enums.Authorities;

@Configuration
public class OAuth2Configuration {

    @Configuration
    @EnableResourceServer
    protected static class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {


        @Override
        public void configure(HttpSecurity http) throws Exception {

            http
            .authorizeRequests()
            .antMatchers("/api/user/**").authenticated()
            .antMatchers("/api/admin/**").hasAuthority("ROLE_ADMIN");


        }

    }

    @Configuration
    @EnableAuthorizationServer
    protected static class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {

    	@Value("${authentication.oauth.clientid}")
        private  String clientId;
    	
    	
    	@Value("${authentication.oauth.tokenValidityInSeconds}")
        private  String tokenValiditySeconds;
        
        //secret = "azerty"
    	@Value("${authentication.oauth.secret}")
        private String clientSecret;


        @Autowired
        private DataSource dataSource;

        @Bean
        public TokenStore tokenStore() {
            return new JdbcTokenStore(dataSource);
            
        }

        @Autowired
        @Qualifier("authenticationManagerBean")
        private AuthenticationManager authenticationManager;

        @Override
        public void configure(AuthorizationServerEndpointsConfigurer endpoints)
                throws Exception {
            endpoints
                    .tokenStore(tokenStore())
                    .authenticationManager(authenticationManager);
        }

        @Override
        public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
            clients
                    .inMemory()
                    .withClient(clientId)
                    .scopes("read", "write")
                    .authorities(Authorities.ROLE_USER.name(), Authorities.ROLE_ADMIN.name())
                    .authorizedGrantTypes("password", "refresh_token")
                    .secret(clientSecret)
                    .accessTokenValiditySeconds(Integer.valueOf(tokenValiditySeconds));
        }
        


    }

}
