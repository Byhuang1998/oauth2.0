package com.byhuang.pojo.entity;

import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
public class Client {

    private String clientId;

    private String secret;

    private String redirectUri;

    private Set redirectUriList;

    private String grantType;

    private List<String> grantTypeList;

    private String scope;

    private List<String> scopeList;

}
