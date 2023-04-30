package Player;

import Figure.Figure;
import Game.Directions;

import java.util.List;

public interface PlayerInterface {
    int [] EnterCell();
    int EnterNumber();
    Directions EnterDirection();
    List<Figure> getFigureList();
    void setFigureList(List<Figure> figureList);
}
