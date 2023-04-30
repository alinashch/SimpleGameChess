package Figure.Factories;

import Figure.Figure;

import java.awt.*;

public interface FigureFactory {
    Figure createFigure(Color c);
}
