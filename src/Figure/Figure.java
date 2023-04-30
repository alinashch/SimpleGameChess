package Figure;

import Game.Directions;
import Player.PlayerInterface;

import java.awt.*;
import java.util.Scanner;


public interface Figure {
    void doStep(  PlayerInterface playerInterface1);
    void enterCell(int x, int y);
    int GetX();
    int GetY();
    String getName();
    Color getColor();

}
