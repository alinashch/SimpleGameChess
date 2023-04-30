package Game;

import Desk.Desk;
import Figure.*;
import Figure.Factories.*;
import Player.Player;
import Player.PlayerInterface;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Game {
    private boolean gameStatus=true;
    public static void main(String[] args) {

        List<Figure> figures=new ArrayList<Figure>();
        List<String>names=new ArrayList<>();
        names.add("rook");
        names.add("elephant");
        names.add("horse");
        names.add("king");
        names.add("queen");
        names.add("horse");
        names.add("elephant");
        names.add("rook");
        List<Figure> figuresPlayer1=new ArrayList<Figure>();
        List<Figure> figuresPlayer2=new ArrayList<Figure>();


        for(int i=0; i<names.size(); i++){
            FigureFactory figureFactory=createFigureBySpeciality(names.get(i));
            Figure figure=figureFactory.createFigure(Color.WHITE);
            figure.enterCell(0, i);
            figures.add(figure);
            figuresPlayer1.add(figure);

            figureFactory=createFigureBySpeciality("pawn");
            Figure pawn=figureFactory.createFigure(Color.WHITE);
            pawn.enterCell(1, i);
            figures.add(pawn);
            figuresPlayer1.add(pawn);


        }

        for(int i=0; i<names.size(); i++){
            FigureFactory figureFactory=createFigureBySpeciality(names.get(i));
            Figure figure=figureFactory.createFigure(Color.BLACK);
            figure.enterCell(7, i);
            figures.add(figure);
            figuresPlayer2.add(figure);


            figureFactory=createFigureBySpeciality("pawn");
            Figure pawn=figureFactory.createFigure(Color.BLACK);
            pawn.enterCell(6, i);
            figures.add(pawn);
            figuresPlayer2.add(pawn);


        }
        PlayerInterface playerInterface=new Player(figuresPlayer1);
        PlayerInterface playerInterface1=new Player(figuresPlayer2);
        MoveChess moveChess=new MoveChess();
        Game game=new Game();
        game.Play(playerInterface, playerInterface1, figures, moveChess);
    }
    public void Play(PlayerInterface playerInterface, PlayerInterface playerInterface1, List<Figure >figures,MoveChess moveChess){
        while(gameStatus){
            Desk.getDesk().printDesk();
            moveChess.doStep(playerInterface);
            Desk.getDesk().printDesk();
            if(playerInterface.getFigureList().size()==0 || playerInterface1.getFigureList().size()==0){
                gameStatus=false;
            }
            moveChess.doStep(playerInterface1);
            Desk.getDesk().printDesk();
            if(playerInterface.getFigureList().size()==0 || playerInterface1.getFigureList().size()==0){
                gameStatus=false;
            }
        }
    }
    static FigureFactory createFigureBySpeciality(String s){
        switch (s) {
            case "elephant":
                return new ElephantFactory();
            case "horse":
                return new HorseFactory();
            case "king":
                return new KingFactory();
            case "pawn":
                return new PawnFactory();
            case "queen":
                return new QueenFactory();
            case "rook":
                return new RookFactory();
            default:
                throw new RuntimeException("Is unknown speciality");
        }
    }
}
