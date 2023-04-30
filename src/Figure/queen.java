package Figure;

import Desk.Desk;
import Game.Directions;
import Player.PlayerInterface;

import java.awt.*;

public class queen extends Steps implements Figure {

    public queen(Color color){
        this.color=color;
        this.name="queen";
    }
    @Override
    public String getName() {
        return name;
    }
    @Override
    public void doStep(  PlayerInterface playerInterface1) {
        Directions d=playerInterface1.EnterDirection();

        if(d==null){
            return;
        }        int x=playerInterface1.EnterNumber();

        if(d==Directions.right){
            for(int i=0; i<x; i++) {
                if( CheckNextStep(Directions.right, this)) {
                    DownStep();
                    Desk.getDesk().deleteFigure(getX(), getY());
                    Delete(playerInterface1, getX(), getY());

                }
            }
        }else if(d==Directions.upRight){
            for(int i=0; i<x; i++) {
                if(CheckNextStep(Directions.upRight, this)) {
                    UpRightStep();
                    Desk.getDesk().deleteFigure(getX(), getY());
                    Delete(playerInterface1, getX(), getY());

                }
            }
        }else if(d==Directions.downRight){
            for(int i=0; i<x; i++) {
                if(CheckNextStep(Directions.downRight, this)) {
                    DownRightStep();
                    Desk.getDesk().deleteFigure(getX(), getY());
                    Delete(playerInterface1, getX(), getY());

                }
            }
        }else if(d==Directions.downLeft){
            for(int i=0; i<x; i++) {
                if(CheckNextStep(Directions.downLeft, this)) {
                    DownLeftStep();
                    Desk.getDesk().deleteFigure(getX(), getY());
                    Delete(playerInterface1, getX(), getY());

                }
            }
        }else if(d==Directions.upLeft){
            for(int i=0; i<x; i++) {
                if(CheckNextStep(Directions.upLeft, this)) {
                    UpLeftStep();
                    Desk.getDesk().deleteFigure(getX(), getY());
                    Delete(playerInterface1, getX(), getY());

                }
            }
        } else if(d==Directions.left){
            for(int i=0; i<x; i++) {
                if (CheckNextStep(Directions.left, this)) {
                    LeftStep();
                    Desk.getDesk().deleteFigure(getX(), getY());
                    Delete(playerInterface1, getX(), getY());

                }
            }
        }else if(d==Directions.up){
            for(int i=0; i<x; i++) {
                if( CheckNextStep(Directions.up, this)) {
                    UpStep();
                    Desk.getDesk().deleteFigure(getX(), getY());
                    Delete(playerInterface1, getX(), getY());

                }
            }
        }else if(d==Directions.down){
            for(int i=0; i<x; i++) {
                if( CheckNextStep(Directions.down, this)) {
                    DownStep();
                    Desk.getDesk().deleteFigure(getX(), getY());
                    Delete(playerInterface1, getX(), getY());

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
    @Override
    public Color getColor() {
        return color;
    }
}
