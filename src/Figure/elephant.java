package Figure;

import Desk.Desk;
import Game.Directions;

import java.awt.*;
import Player.*;


public class elephant extends Steps implements Figure {

    public elephant(Color color){
        this.color=color;
        this.name="elephant";
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
    public Color getColor() {
        return color;
    }

    @Override
    public int GetX() {
        return X;
    }
    @Override
    public void doStep( PlayerInterface playerInterface1 ) {
        int x=playerInterface1.EnterNumber();
        Directions d=playerInterface1.EnterDirection();

        if(d==null){
            return;
        }
        if(d==Directions.upRight){
            for(int i=0; i<x; i++) {
                if(CheckNextStep(Directions.upRight, this)) {
                    UpRightStep();
                    Delete(playerInterface1, getX(), getY());
                    Desk.getDesk().deleteFigure(getX(), getY());
                }
            }
        }else if(d==Directions.downRight){
            for(int i=0; i<x; i++) {
                if(CheckNextStep(Directions.downRight, this)) {
                    DownRightStep();
                    Delete(playerInterface1, getX(), getY());

                    Desk.getDesk().deleteFigure(getX(), getY());
                }
            }
        }else if(d==Directions.downLeft){
            for(int i=0; i<x; i++) {
                if(CheckNextStep(Directions.downLeft, this)) {
                    DownLeftStep();
                    Delete(playerInterface1, getX(), getY());

                    Desk.getDesk().deleteFigure(getX(), getY());
                }
            }
        }else if(d==Directions.upLeft){
            for(int i=0; i<x; i++) {
                if(CheckNextStep(Directions.upLeft, this)) {
                    UpLeftStep();
                    Delete(playerInterface1, getX(), getY());

                    Desk.getDesk().deleteFigure(getX(), getY());
                }
            }
        } else {
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
}
