package Figure;

import Desk.Desk;
import Game.Directions;
import Player.PlayerInterface;

import java.awt.*;

import static Game.Directions.*;

public class pawn extends Steps implements Figure {

    public pawn(Color color){
        this.color=color;
        this.name="pawn";
    }
    @Override
    public String getName() {
        return name;
    }
    @Override
    public Color getColor() {
        return color;
    }
    @Override
    public void doStep(  PlayerInterface playerInterface1) {
        Directions d=playerInterface1.EnterDirection();

        if(d==null){
            return;
        }
        int x=playerInterface1.EnterNumber();

        if(d== up){
            for(int i=0; i<x; i++) {
                if(CheckNextStep(up, this)) {
                    Desk.getDesk().deleteFigure(getX(), getY());
                    Delete(playerInterface1, getX(), getY());

                    UpStep();
                }
            }
       }else if(d== down){
            System.out.println("555555555");
            for(int i=0; i<x; i++) {
                if(CheckNextStep(down, this) ) {
                    Desk.getDesk().deleteFigure(getX(), getY());
                    Delete(playerInterface1, getX(), getY());

                    DownStep();

                }
            }
        }else {
            doStep( playerInterface1);
        }
        Desk.getDesk().addChess(getX(),getY(), this);
    }

    @Override
    public void enterCell(int x, int y) {
        Desk.getDesk().addChess(x, y ,this);
        X=x;
        Y=y;
    }
    @Override
    public int GetY() {
        return Y;
    }

    @Override
    public int GetX() {
        return X;
    }
}
