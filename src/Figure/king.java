package Figure;

import Desk.Desk;
import Game.Directions;
import Player.PlayerInterface;

import java.awt.*;

public class king extends Steps implements Figure {

    public king(Color color){
        this.color=color;
        this.name="king";
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
    public Color getColor() {
        return color;
    }
    @Override
    public void doStep(  PlayerInterface playerInterface1) {
        Directions d=playerInterface1.EnterDirection();

        if(d==null){
            return;
        }
        if(d==Directions.right){
            if( CheckNextStep(Directions.right, this)) {
                RightStep();
                Desk.getDesk().deleteFigure(getX(), getY());
                Delete(playerInterface1, getX(), getY());

            }
        }else if(d==Directions.upRight){
                if(CheckNextStep(Directions.upRight, this)) {
                    UpRightStep();
                    Desk.getDesk().deleteFigure(getX(), getY());
                }
        }else if(d==Directions.downRight){
                if(CheckNextStep(Directions.downRight, this)) {
                    DownRightStep();
                    Desk.getDesk().deleteFigure(getX(), getY());
                    Delete(playerInterface1, getX(), getY());

                }

        }else if(d==Directions.downLeft){
                if(CheckNextStep(Directions.downLeft, this)) {
                    DownLeftStep();
                    Desk.getDesk().deleteFigure(getX(), getY());
                    Delete(playerInterface1, getX(), getY());

                }

        }else if(d==Directions.upLeft){
                if(CheckNextStep(Directions.upLeft, this)) {
                    UpLeftStep();
                    Desk.getDesk().deleteFigure(getX(), getY());
                    Delete(playerInterface1, getX(), getY());

                }

        }else if(d==Directions.up){
            if( CheckNextStep(Directions.up, this)) {
                UpStep();
                Desk.getDesk().deleteFigure(getX(), getY());
                Delete(playerInterface1, getX(), getY());

            }
        }else if(d==Directions.down){
            if( CheckNextStep(Directions.down, this)) {
                DownStep();
                Desk.getDesk().deleteFigure(getX(), getY());
                Delete(playerInterface1, getX(), getY());

            }
        }if(d==Directions.left) {
            if (CheckNextStep(Directions.left, this)) {
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
}
