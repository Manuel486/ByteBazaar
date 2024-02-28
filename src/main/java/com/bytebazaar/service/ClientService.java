package com.bytebazaar.service;

import com.bytebazaar.models.Client;

import java.util.List;

public interface ClientService {

    List<Client> findAll();
    Client findById(int id);
    int deleteById(int id);
    int save(Client client);
    int update(int id,Client client);

    boolean isClientDeletable(int id);
}
