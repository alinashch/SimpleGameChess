package Figure.Factories;

import Figure.*;

import java.awt.*;

public class ElephantFactory implements FigureFactory {
    @Override
    public Figure createFigure(Color c) {
        return new elephant(c);
    }
}
