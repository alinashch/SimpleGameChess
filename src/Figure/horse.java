package Figure;

import Desk.Desk;
import Game.Directions;
import Player.PlayerInterface;

import java.awt.*;

public class horse extends Steps implements Figure {

    public horse(Color color){
        this.color=color;
        this.name="horse";
    }
    @Override
    public Color getColor() {
        return color;
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
        }
        if(d==Directions.rightRightUp){
            if(CheckNextStep(Directions.rightRightUp, this)) {
                RightStep();
                RightStep();
                UpStep();
                Desk.getDesk().deleteFigure(getX(), getY());
                Delete(playerInterface1, getX(), getY());

            }
        }else if(d==Directions.rightRightDown){
            if(CheckNextStep(Directions.rightRightDown, this)) {
                RightStep();
                RightStep();
                DownStep();
                Desk.getDesk().deleteFigure(getX(), getY());
                Delete(playerInterface1, getX(), getY());

            }
        }else if(d==Directions.leftLeftUp){
            if(CheckNextStep(Directions.leftLeftUp, this)) {
                LeftStep();
                LeftStep();
                UpStep();
                Desk.getDesk().deleteFigure(getX(), getY());
                Delete(playerInterface1, getX(), getY());

            }
        }else if(d==Directions.leftLeftDown){
            if(CheckNextStep(Directions.leftLeftDown, this)) {
                LeftStep();
                LeftStep();
                DownStep();
                Desk.getDesk().deleteFigure(getX(), getY());
                Delete(playerInterface1, getX(), getY());

            }
        }else if(d==Directions.upUpLeft){
            if(CheckNextStep(Directions.upUpLeft, this)) {

                UpStep();
                UpStep();
                LeftStep();
                Desk.getDesk().deleteFigure(getX(), getY());
                Delete(playerInterface1, getX(), getY());

            }
        }else if(d==Directions.upUpRight){
            if(CheckNextStep(Directions.upUpRight, this)) {

                UpStep();
                UpStep();
                RightStep();
                Desk.getDesk().deleteFigure(getX(), getY());
                Delete(playerInterface1, getX(), getY());

            }
        }else if(d==Directions.downDownRight){
            if(CheckNextStep(Directions.downDownRight, this)) {
                DownStep();
                DownStep();
                RightStep();
                Desk.getDesk().deleteFigure(getX(), getY());
                Delete(playerInterface1, getX(), getY());

            }
        }else if(d==Directions.downDownLeft){
            if(CheckNextStep(Directions.downDownLeft, this)) {
                DownStep();
                DownStep();
                LeftStep();
                Desk.getDesk().deleteFigure(getX(), getY());
                Delete(playerInterface1, getX(), getY());

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
    public int GetY() {
        return Y;
    }

    @Override
    public int GetX() {
        return X;
    }
}
