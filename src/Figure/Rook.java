package Figure;

import Desk.Desk;
import Game.Directions;
import Player.PlayerInterface;

import java.awt.*;

public class Rook extends Steps implements Figure {

    public Rook(Color color){
        this.color=color;
        this.name="Rook";
    }
    @Override
    public int GetY() {
        return Y;
    }
    @Override
    public String getName() {
        return name;
    }
    @Override
    public int GetX() {
        return X;
    }
    @Override
    public void doStep(  PlayerInterface playerInterface1) {
        Directions d=playerInterface1.EnterDirection();

        if(d==null){
            return;
        }
        int x=playerInterface1.EnterNumber();

        if(d==Directions.right){
            for(int i=0; i<x; i++) {
                if(CheckNextStep(Directions.right, this)) {
                    Desk.getDesk().deleteFigure(getX(), getY());
                    Delete(playerInterface1, getX(), getY());

                    RightStep();
                }
            }
        } else if(d==Directions.left){
            for(int i=0; i<x; i++) {
                if(CheckNextStep(Directions.left, this)) {
                    Desk.getDesk().deleteFigure(getX(), getY());
                    Delete(playerInterface1, getX(), getY());

                    LeftStep();
                }
            }
        }else if(d==Directions.up){
            for(int i=0; i<x; i++) {
                if(CheckNextStep(Directions.up, this)) {
                    Desk.getDesk().deleteFigure(getX(), getY());
                    Delete(playerInterface1, getX(), getY());

                    UpStep();
                }
            }
        }else if(d==Directions.down){
            for(int i=0; i<x; i++) {
                if(CheckNextStep(Directions.down, this) ) {
                    Desk.getDesk().deleteFigure(getX(), getY());
                    Delete(playerInterface1, getX(), getY());

                    DownStep();
                }
            }
        }else {
            doStep(playerInterface1);
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
    public Color getColor() {
        return color;
    }

}
