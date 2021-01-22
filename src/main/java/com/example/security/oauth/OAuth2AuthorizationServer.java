package com.example.security.oauth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

/*
Spring security oauth exposes two endpoints for checking tokens (/oauth/check_token and /oauth/token_key) which are by default protected behind denyAll().
tokenKeyAccess() and checkTokenAccess() methods open these endpoints for use.
ClientDetailsServiceConfigurer is used to define an in-memory or JDBC implementation of the client details service. we have used in-memory implementation.

It has following important attribute:
clientId – (required) the client id.
secret – (required for trusted clients) the client secret, if any.
scope – The scope to which the client is limited. If the scope is undefined or empty (the default), the client is not limited by scope.
authorizedGrantTypes – Grant types that are authorized for the client to use. The default value is empty.
authorities – Authorities that are granted to the client (regular Spring Security authorities).
redirectUris – redirects the user-agent to the client’s redirection endpoint. It must be an absolute URL.
 */
@Configuration
@EnableAuthorizationServer
public class OAuth2AuthorizationServer extends AuthorizationServerConfigurerAdapter
{
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security
                .tokenKeyAccess("permitAll()")
                .checkTokenAccess("isAuthenticated()")
                .allowFormAuthenticationForClients();
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients
                .inMemory()
                .withClient("clientapp").secret(passwordEncoder.encode("123456"))
                .authorizedGrantTypes("password", "authorization_code", "refresh_token")
                .authorities("READ_ONLY_CLIENT")
                .scopes("read_profile_info")
                .resourceIds("oauth2-resource")
                .redirectUris("http://localhost:8081/login")
                .accessTokenValiditySeconds(120)
                .refreshTokenValiditySeconds(240000);
    }
}
