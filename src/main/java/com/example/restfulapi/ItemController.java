package com.example.restfulapi;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/items")
public class ItemController {

    private List<String> items = new ArrayList<>();

    // GET - Lista todos os itens
    @GetMapping
    public List<String> getAllItems() {
        return items;
    }

    // POST - Adiciona um item
    @PostMapping
    public String addItem(@RequestBody String item) {
        items.add(item);
        return "Item adicionado com sucesso!";
    }

    // DELETE - Remove um item
    @DeleteMapping("/{index}")
    public String deleteItem(@PathVariable int index) {
        if (index >= 0 && index < items.size()) {
            items.remove(index);
            return "Item removido com sucesso!";
        } else {
            return "Índice inválido!";
        }
    }
}
