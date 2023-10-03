package com.byhuang.config;

import com.byhuang.service.MyUserDetails;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.provider.*;
import org.springframework.security.oauth2.provider.token.AbstractTokenGranter;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.util.StringUtils;

import java.util.LinkedHashMap;
import java.util.Map;

public class SmsCodeTokenGranter extends AbstractTokenGranter {

    private static final String SMS_GRANT_TYPE = "sms_code";

    private MyUserDetails userService;

    public SmsCodeTokenGranter(AuthorizationServerTokenServices tokenServices,
                               ClientDetailsService clientDetailsService,
                               OAuth2RequestFactory requestFactory,
                               MyUserDetails userService) {
        super(tokenServices, clientDetailsService, requestFactory, SMS_GRANT_TYPE);
        this.userService = userService;
    }


    @Override
    protected OAuth2Authentication getOAuth2Authentication(ClientDetails client,
                                                           TokenRequest tokenRequest) {

        Map<String, String> parameters = new LinkedHashMap<String, String>(tokenRequest.getRequestParameters());

        System.out.println(parameters.toString());
        // 客户端提交的手机号码
        String phoneNumber = parameters.get("phone");
        if (StringUtils.isEmpty(phoneNumber)) {
            throw new AccessDeniedException("get phone is null ！");
        }

        // 客户端提交的验证码
        String smsCode = parameters.get("code");
        if (!smsCode.equals("9876")) {
            throw new AccessDeniedException("code err!");
        }
        // todo 应该添加上校验电话号+验证码的逻辑，本处不实现

        UserDetails user = userService.loadUserByUsername("by");

        AbstractAuthenticationToken userAuth = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());

        userAuth.setDetails(parameters);
        OAuth2Request oAuth2Request = getRequestFactory().createOAuth2Request(client, tokenRequest);
        return new OAuth2Authentication(oAuth2Request, userAuth);
    }
}
