package com.byhuang.service;

import com.byhuang.pojo.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.stereotype.Service;

@Service
public class MyClientDetailsService implements ClientDetailsService {

    @Autowired
    private ClientService clientService;

    @Override
    public ClientDetails loadClientByClientId(String s) throws ClientRegistrationException {

        Client client = clientService.getClientById(s);

        BaseClientDetails clientDetails = new BaseClientDetails();
        clientDetails.setClientId(client.getClientId());
        clientDetails.setClientSecret(client.getSecret());
        clientDetails.setScope(client.getScopeList());
        clientDetails.setAuthorizedGrantTypes(client.getGrantTypeList());
        clientDetails.setRegisteredRedirectUri(client.getRedirectUriList());

        return clientDetails;
    }
}
