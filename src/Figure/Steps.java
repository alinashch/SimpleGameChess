package Figure;

import Desk.Desk;
import Game.Directions;
import Player.PlayerInterface;

import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Steps {
    protected Color color;
    protected int X;
    protected int Y;
    protected String name;

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }

    protected void UpStep() {
        X--;
    }

    protected void DownStep() {
        X++;
    }

    protected void LeftStep() {
        Y++;
    }

    protected void RightStep() {
        Y--;
    }

    protected void UpLeftStep() {
        X--;
        Y++;
    }

    protected void UpRightStep() {
        X--;
        Y--;
    }

    protected void DownLeftStep() {
        X++;
        Y++;
    }

    protected void DownRightStep() {
        X++;
        Y--;
    }
    protected void Delete(PlayerInterface playerInterface, int X, int Y){
        for (int i=0; i<playerInterface.getFigureList().size(); i++){
            if(playerInterface.getFigureList().get(i).GetX()==X && playerInterface.getFigureList().get(i).GetY()==Y ){
                playerInterface.getFigureList().remove(i);
            }
        }
    }

    protected boolean CheckNextStep(Directions d, Figure f) {
        if (d == Directions.right) {
            if (Y != 0) {
                Check(d, f, X, Y);
                if (Desk.getDesk().getPlacement()[X][Y - 1] == null) {
                    return true;
                }
            } else {
                return false;
            }
        } else if (d == Directions.left) {
            if (Y != 7) {
                Check(d, f, X, Y);

                if (Desk.getDesk().getPlacement()[X][Y + 1] == null) {
                    return true;
                }
            }
        } else if (d == Directions.up) {
            if (X != 0) {
                Check(d, f, X, Y);

                if (Desk.getDesk().getPlacement()[X - 1][Y] == null) {
                    return true;
                }
            } else {
                return false;
            }
        } else if (d == Directions.down) {
            if (X != 7) {
                Check(d, f, X, Y);

                if (Desk.getDesk().getPlacement()[X + 1][Y] == null) {
                    return true;
                }
            }
        } else if (d == Directions.downLeft) {
            if (X != 7 && Y != 0) {
                Check(Directions.down, f, X, Y);
                Check(Directions.left, f, X+1, Y);


                if (Desk.getDesk().getPlacement()[X][Y - 1] == null && Desk.getDesk().getPlacement()[X + 1][Y] == null) {
                    return true;
                }

            }
        } else if (d == Directions.downRight) {
            if (X != 7 && Y != 0) {
                Check(Directions.down, f, X, Y);
                Check(Directions.right, f, X+1, Y);


                if (Desk.getDesk().getPlacement()[X][Y + 1] == null && Desk.getDesk().getPlacement()[X + 1][Y] == null) {
                    return true;
                }
            }
        } else if (d == Directions.upRight) {
            if (X != 0 && Y != 0) {
                Check(Directions.up, f, X, Y);
                Check(Directions.right, f, X-1, Y);


                if (Desk.getDesk().getPlacement()[X - 1][Y] == null && Desk.getDesk().getPlacement()[X][Y - 1] == null) {
                    return true;
                }
            }
        } else if (d == Directions.upLeft) {
            if (X != 0 && Y != 7) {
                Check(Directions.up, f, X, Y);
                Check(Directions.left, f, X-1, Y);


                if (Desk.getDesk().getPlacement()[X - 1][Y] == null && Desk.getDesk().getPlacement()[X][Y + 1] == null) {
                    return true;
                }
            }
        } else if (d == Directions.rightRightUp) {
            if (X != 0 && Y != 0 && Y != 1) {
                Check(Directions.right, f, X, Y);
                Check(Directions.right, f, X, Y-1);
                Check(Directions.up, f, X, Y-1);

                if (Desk.getDesk().getPlacement()[X - 1][Y] == null && Desk.getDesk().getPlacement()[X][Y - 2] == null && Desk.getDesk().getPlacement()[X][Y - 1] == null) {
                    return true;
                }
            }
        } else if (d == Directions.rightRightDown) {
            if (X != 7 && Y != 0 && Y != 1) {
                Check(Directions.right, f, X, Y);
                Check(Directions.right, f, X, Y-1);
                Check(Directions.down, f, X, Y-1);

                if (Desk.getDesk().getPlacement()[X + 1][Y] == null && Desk.getDesk().getPlacement()[X][Y - 1] == null && Desk.getDesk().getPlacement()[X][Y - 2] == null) {
                    return true;
                }
            }
        } else if (d == Directions.downDownRight) {
            if (X != 7 && Y != 0 && X != 6) {
                Check(Directions.down, f, X, Y);
                Check(Directions.down, f, X, Y-1);
                Check(Directions.right, f, X, Y-2);
                if (Desk.getDesk().getPlacement()[X + 1][Y] == null && Desk.getDesk().getPlacement()[X][Y - 1] == null && Desk.getDesk().getPlacement()[X + 2][Y] == null) {
                    return true;
                }
            }
        } else if (d == Directions.upUpRight) {
            if (X != 0 && Y != 0 && X != 1) {
                Check(Directions.up, f, X, Y);
                Check(Directions.up, f, X-1, Y);
                Check(Directions.right, f, X-2, Y);

                if (Desk.getDesk().getPlacement()[X - 1][Y] == null && Desk.getDesk().getPlacement()[X][Y - 1] == null && Desk.getDesk().getPlacement()[X - 2][Y] == null) {
                    return true;
                }
            }
        } else if (d == Directions.downDownLeft) {
            if (X != 7 && Y != 7 && X != 6) {
                Check(Directions.down, f, X, Y);
                Check(Directions.down, f, X, Y-1);
                Check(Directions.left, f, X, Y-2);

                if (Desk.getDesk().getPlacement()[X + 1][Y] == null && Desk.getDesk().getPlacement()[X][Y + 1] == null && Desk.getDesk().getPlacement()[X + 2][Y] == null) {
                    return true;
                }
            }
        } else if (d == Directions.upUpLeft) {
            if (X != 0 && Y != 7 && X != 1) {
                Check(Directions.up, f, X, Y);
                Check(Directions.up, f, X-1, Y);
                Check(Directions.left, f, X-2, Y);

                if (Desk.getDesk().getPlacement()[X - 1][Y] == null && Desk.getDesk().getPlacement()[X - 2][Y] == null && Desk.getDesk().getPlacement()[X][Y + 1] == null) {
                    return true;
                }
            }
        } else if (d == Directions.leftLeftUp) {
            if (Y != 7 && Y != 6 && X != 0) {
                Check(Directions.left, f, X, Y);
                Check(Directions.left, f, X, Y-1);
                Check(Directions.up, f, X, Y-2);

                if (Desk.getDesk().getPlacement()[X][Y + 1] == null && Desk.getDesk().getPlacement()[X][Y + 2] == null && Desk.getDesk().getPlacement()[X - 1][Y] == null) {
                    return true;
                }
            }
        } else if (d == Directions.leftLeftDown) {
            if (Y != 7 && Y != 6 && X != 7) {
                Check(Directions.left, f, X, Y);
                Check(Directions.left, f, X, Y-1);
                Check(Directions.down, f, X, Y-2);
                if (Desk.getDesk().getPlacement()[X][Y + 1] == null && Desk.getDesk().getPlacement()[X][Y + 2] == null && Desk.getDesk().getPlacement()[X + 1][Y] == null) {
                    return true;
                }
            }
        }

        return false;
    }

    private void Check(Directions d, Figure f, int X, int Y) {
        if (d == Directions.right) {
            if (Y != 0) {
                if (Desk.getDesk().getPlacement()[X][Y - 1] != null) {
                    if (Desk.getDesk().getPlacement()[X][Y - 1].getColor() != f.getColor()) {
                        Desk.getDesk().deleteFigure(X, Y - 1);
                    }
                }

            }
        } else if (d == Directions.left) {
            if (Y != 7) {
                if (Desk.getDesk().getPlacement()[X][Y + 1] != null) {
                    if (Desk.getDesk().getPlacement()[X][Y + 1].getColor() != f.getColor()) {
                        Desk.getDesk().deleteFigure(X, Y + 1);
                    }
                }

            }
        } else if (d == Directions.up) {
            if (X != 0) {
                if (Desk.getDesk().getPlacement()[X - 1][Y] != null) {
                    if (Desk.getDesk().getPlacement()[X - 1][Y].getColor() != f.getColor()) {
                        Desk.getDesk().deleteFigure(X - 1, Y);
                    }
                }
            }

        } else if (d == Directions.down) {
            if (X != 7) {
                if (Desk.getDesk().getPlacement()[X + 1][Y] != null) {
                    if (Desk.getDesk().getPlacement()[X + 1][Y].getColor() != f.getColor()) {
                        Desk.getDesk().deleteFigure(X + 1, Y);
                    }
                }

            }
        }
    }
}


