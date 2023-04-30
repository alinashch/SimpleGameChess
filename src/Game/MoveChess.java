package Game;

import Figure.Figure;
import Figure.*;
import Player.PlayerInterface;


import java.util.List;

public class MoveChess extends Steps {
    public Figure ChooseChess(int [] arr, PlayerInterface playerInterface1){

        for(int i=0; i<playerInterface1.getFigureList().size(); i++){
            if(playerInterface1.getFigureList().get(i).GetX()==arr[0] && playerInterface1.getFigureList().get(i).GetY()==arr[1]){
                return playerInterface1.getFigureList().get(i);
            }
        }
        return null;
    }

    private Figure CheckFigure(PlayerInterface playerInterface1, Figure f){
        if(f==null){
            return ChooseChess(playerInterface1.EnterCell(), playerInterface1);
        }
        return f;
    }

    public void doStep(PlayerInterface playerInterface1){
        MoveChess moveChess=new MoveChess();
        Figure f=moveChess.ChooseChess(playerInterface1.EnterCell(), playerInterface1);
        while (f==null) {
            f = CheckFigure(playerInterface1,  f);
        }
        System.out.println(f+" "+f.GetX()+" "+ f.GetY());
        f.doStep( playerInterface1);
    }




}
