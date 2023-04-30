package Figure.Factories;

import Figure.Factories.FigureFactory;
import Figure.*;

import java.awt.*;

public class QueenFactory implements FigureFactory {
    @Override
    public Figure createFigure(Color c) {
        return new queen(c);
    }
}
