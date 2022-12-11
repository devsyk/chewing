package io.web.chewing.service;

import io.web.chewing.model.ProviderUser;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserRequest;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserService;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Service;

@Service
public class CustomOidcUserService extends AbstractOAuth2UserService implements OAuth2UserService<OidcUserRequest, OidcUser> {
    @Override
    public OidcUser loadUser(OidcUserRequest userRequest) throws OAuth2AuthenticationException {

        ClientRegistration clientRegistration = userRequest.getClientRegistration();
        OAuth2UserService<OidcUserRequest,OidcUser> oidcUserRequestOidcUserOAuth2UserService = new OidcUserService();
        OidcUser oidcUser = oidcUserRequestOidcUserOAuth2UserService.loadUser(userRequest);

        ProviderUser providerUser = super.providerUser(clientRegistration, oidcUser);
        super.register(providerUser,userRequest);

        return oidcUser;
    }
}

