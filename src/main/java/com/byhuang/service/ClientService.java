package com.byhuang.service;

import com.byhuang.dao.ClientDao;
import com.byhuang.pojo.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ClientService {

    @Autowired
    private ClientDao clientDao;

    public Client getClientById(String clientId) {
        Client client = clientDao.selectClientById(clientId);
        List<String> grantTypeList = Arrays.asList(client.getGrantType().split(","));
        List<String> scopeList = Arrays.asList(client.getScope().split(","));
        Set<String> redirectUriList = new HashSet<>(Arrays.asList(client.getRedirectUri().split(",")));
        client.setGrantTypeList(grantTypeList);
        client.setScopeList(scopeList);
        client.setRedirectUriList(redirectUriList);
        return client;
    }
}
