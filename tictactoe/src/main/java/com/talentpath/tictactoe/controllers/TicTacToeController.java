package com.talentpath.tictactoe.controllers;


import com.talentpath.tictactoe.models.TicTacToeBoard;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TicTacToeController {

    @PostMapping("/begin")
    public Integer beginGame() {
        return null;
    }

}
