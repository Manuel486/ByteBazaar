package com.bytebazaar.service.impl;

import com.bytebazaar.mapper.ClientMapper;
import com.bytebazaar.models.Client;
import com.bytebazaar.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientMapper clienteMapper;

    @Override
    public List<Client> findAll() {
        return clienteMapper.findAll();
    }

    @Override
    public Client findById(int id) {
        return clienteMapper.findById(id);
    }

    @Override
    public int deleteById(int id) {
        return clienteMapper.deleteById(id);
    }

    @Override
    public int save(Client client) {
        return clienteMapper.save(client);
    }

    @Override
    public int update(int id, Client client) {
        return clienteMapper.update(client);
    }

    @Override
    public boolean isClientDeletable(int id) {
        return clienteMapper.isClientDeletable(id)<1;
    }
}
