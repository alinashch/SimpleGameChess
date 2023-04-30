package Player;

import Figure.Figure;
import Figure.Steps;
import Game.Directions;

import java.util.List;
import java.util.Scanner;

public class Player implements PlayerInterface{
    private List<Figure> figureList;
    @Override
    public List<Figure> getFigureList() {
        return figureList;
    }
    @Override
    public void setFigureList(List<Figure> figureList) {
        this.figureList = figureList;
    }

    public Player(List<Figure> figures){
        this.figureList=figures;
    }

    @Override
    public int[] EnterCell() {
        int [] arr=new int[2];
        System.out.println("Enter Cell");
        Scanner scanner=new Scanner(System.in);
        arr[0]=scanner.nextInt();
        arr[1]=scanner.nextInt();
       return arr;
       }

    @Override
    public int EnterNumber() {
        Scanner scanner=new Scanner(System.in);
        System.out.println("enter number");
        int x= scanner.nextInt();
        if(x<=0 || x>=7){
            return EnterNumber();
        }
        return x;
    }

    @Override
    public  Directions EnterDirection() {
        Scanner scanner=new Scanner(System.in);

        System.out.println("enter right or left or up or down or up-right or down-right or down-left or up-left right-right-up or right-right-down or left-left-up or left-left-down or up-up-left or up-up-right or down-down-right or down-down-left ");
        String string =scanner.nextLine();
        Directions d;
        if (string.equals("right")) {
            d = Directions.right;
        } else if (string.equals("up-right")) {
            d = Directions.upRight;
        } else if (string.equals("down-right")) {
            d=Directions.downRight;
        } else if (string.equals("down-left")) {
            d=Directions.downLeft;
        } else if (string.equals("up-left")) {
            d=Directions.upLeft;
        } else if (string.equals("left")) {
            d=Directions.left;
        } else if (string.equals("up")) {
            d=Directions.up;
        } else if (string.equals("down")) {
            d=Directions.down;
        }else if(string.equals("right-right-up")){
            d=Directions.rightRightUp;
        }else if(string.equals("right-right-down")){
            d=Directions.rightRightDown;
        }else if(string.equals("left-left-up")){
            d=Directions.leftLeftUp;
        }else if(string.equals("left-left-down")){
            d=Directions.leftLeftDown;
        }else if(string.equals("up-up-left")){
            d=Directions.upUpLeft;
        }else if(string.equals("up-up-right")){
            d=Directions.upRight;
        }else if(string.equals("down-down-right")){
            d=Directions.downDownRight;
        }else if(string.equals("down-down-left")){
            d=Directions.downDownLeft;
        } else {
            throw new RuntimeException("Is unknown speciality");
        }
        return d;
    }
}
