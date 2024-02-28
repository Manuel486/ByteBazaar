package com.bytebazaar.controller;

import com.bytebazaar.models.Client;
import com.bytebazaar.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/bazaar/client")
public class ClientController {

    private final ClientService clientService;

    @GetMapping({"/",""})
    public String findAll(@RequestParam(name = "query", required = false) String query, Model model){
        List<Client> clients = clientService.findAll();;
        List<String> theaders = Arrays.asList("ID","Nombre","Apellidos","DNI","Email","Direccion");


        model.addAttribute("entities",clients);
        model.addAttribute("theaders",theaders);
        model.addAttribute("properties", List.of("id", "name", "lastname","dni","email","address"));


        return "pages/client/list-clients";
    }

    @GetMapping("/new-client")
    public String clientRegistrationForm(Model model){
        model.addAttribute("client", new Client());
        return "pages/client/new-client";
    }


    @PostMapping("/new-client")
    public String saveClient(@Validated Client client, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("client",client);
            return "pages/client/new-client";
        }

        clientService.save(client);
        return "redirect:/bazaar/client";
    }

    @GetMapping("/{id}/edit")
    public String clientEditForm(@PathVariable Integer id,Model model){
        Client client = clientService.findById(id);
        model.addAttribute("client",client);
        return "pages/client/new-client";
    }

    @PostMapping("/{id}/edit")
    public String updateProduct(@PathVariable Integer id,@Validated Client client, BindingResult bindingResult, Model model){
        Client clientDB = clientService.findById(id);

        if(bindingResult.hasErrors()){
            model.addAttribute("client",client);
            return "pages/client/new-client";
        }

        clientDB.setName(client.getName());
        clientDB.setLastname(client.getLastname());
        clientDB.setDni(client.getDni());
        clientDB.setEmail(client.getEmail());
        clientDB.setAddress(client.getAddress());

        clientService.update(id,clientDB);
        return "redirect:/bazaar/client";
    }

    @PostMapping("/{id}/delete")
    public String deleteClient(@PathVariable Integer id, RedirectAttributes redirect){
        boolean deletable = clientService.isClientDeletable(id);
        if ( deletable ) {
            clientService.deleteById(id);
            redirect.addFlashAttribute("message", "Cliente eliminado con éxito");
        } else {
            redirect.addFlashAttribute("message", "El cliente no pudo ser eliminado porque esta siendo usado en una venta");
        }
        return "redirect:/bazaar/client";
    }
}
