package Figure.Factories;

import Figure.Factories.FigureFactory;
import Figure.*;

import java.awt.*;

public class HorseFactory implements FigureFactory {
    @Override
    public Figure createFigure(Color c) {
        return new horse(c);
    }
}
