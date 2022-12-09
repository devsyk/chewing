package io.web.chewing.model;

import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.Map;

public class NaverUser extends OAuth2ProviderUser {
    public NaverUser(OAuth2User oAuth2User, ClientRegistration clientRegistration) {
        super((Map<String, Object>) oAuth2User.getAttributes().get("response"),
                oAuth2User,
                clientRegistration);
    }

    @Override
    public String getId() {
        return (String) getAttributes().get("id");
    }

    @Override
    public String getUsername() {
        return (String) getAttributes().get("email");
    }

    @Override
    public String getProfile() {
        return (String) getAttributes().get("profile_image");
    }

    @Override
    public char getGender() {
        return (char) getAttributes().get("gender");
    }

    @Override
    public String getPhone() {
        return (String) getAttributes().get("phone");
    }

    @Override
    public String getNickName() {
        return (String) getAttributes().get("nickname");
    }

    @Override
    public String getName() {
        return (String) getAttributes().get("name");
    }
}
