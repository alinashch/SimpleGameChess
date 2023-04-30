package Desk;

import Figure.Figure;

//используется паттерн одиночка, чтобы обеспечить одну доску
public class Desk {
    private static Desk desk;
    private static Figure[][] placement=new Figure[8][8];

    public static Desk getDesk(){
        if(desk==null){
            desk=new Desk();
        }
        return desk;
    }

    private Desk(){

    }
    public Figure[][] getPlacement(){
        return placement;
    }

    public void addChess(int a, int b, Figure n){
        for(int i=0; i<placement.length; i++){
            for (int j=0; j<placement.length; j++){
                if(i==a && j==b){
                    placement[i][j]=n;
                }
            }
        }
    }

    public void printDesk(){
        for(int i=0; i<placement.length; i++){
            for (int j=0; j<placement.length; j++) {
                if(placement[i][j]!=null) {
                    System.out.print(placement[i][j].getName() + " ");
                }else {
                    System.out.print(placement[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
    public void deleteFigure(int x, int y){
        for(int i=0; i<placement.length; i++){
            for (int j=0; j<placement.length; j++){
                if(i==x && j==y){
                    placement[i][j]=null;
                }
            }
        }
    }


}
