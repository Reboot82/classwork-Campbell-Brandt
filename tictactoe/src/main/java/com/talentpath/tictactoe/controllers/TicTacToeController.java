package com.talentpath.tictactoe.controllers;


import com.talentpath.tictactoe.models.TicTacToeBoard;
import com.talentpath.tictactoe.services.TicTacToeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TicTacToeController {

    @Autowired
    TicTacToeService service;

    @PostMapping("/begin")
    public Integer beginGame() {
        return service.beginGame();
    }

}
