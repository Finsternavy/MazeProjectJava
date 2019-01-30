/*

Created by Christopher Finster on 27DEC2018.

*/
import java.util.Arrays;

public class MazeSquare {

    MazeSquare (){

        this.top = "...";
        this.mid = "...";
        this.bot = "...";
        this.seen = false;
        squareArray = new String[]{top, mid, bot};

    }

    MazeSquare (squareType c){

        setSquareType(c);

    }

    public String top;
    public String mid;
    public String bot;
    public boolean seen = false;

    public String[] squareArray;


    enum squareType{OPEN, WALL, START, FINISH, BACKTRACK, PATH, CURRENT}


    public String getTop(){

        return this.top;

    }

    public void setTop(String top){

        this.top = top;

    }

    public String getMid(){

        return this.mid;

    }

    public void setMid(String mid){

        this.mid = mid;

    }

    public String getBot(){

        return this.bot;

    }

    public void setBot(String bot){

        this.bot = bot;

    }

    public String printSquare(){

        return this.bot + "\n" + this.mid + "\n" + this.bot;

    }

    public void setSquareType(squareType c){

        switch (c){

            case OPEN:

                this.top = "...";
                this.mid = "...";
                this.bot = "...";
                this.seen = false;
                squareArray = new String[]{top, mid, bot};
                break;

            case WALL:

                this.top = "XXX";
                this.mid = "XXX";
                this.bot = "XXX";
                this.seen = false;
                squareArray = new String[]{top, mid, bot};
                break;

            case START:

                this.top = "...";
                this.mid = ".S.";
                this.bot = "...";
                this.seen = false;
                squareArray = new String[]{top, mid, bot};
                break;

            case FINISH:

                this.top = "...";
                this.mid = ".F.";
                this.bot = "...";
                this.seen = false;
                squareArray = new String[]{top, mid, bot};
                break;

            case BACKTRACK:

                this.top = "BBB";
                this.mid = "BBB";
                this.bot = "BBB";
                this.seen = false;
                squareArray = new String[]{top, mid, bot};
                break;

            case PATH:

                this.top = "   ";
                this.mid = "   ";
                this.bot = "   ";
                this.seen = false;
                squareArray = new String[]{top, mid, bot};
                break;

            case CURRENT:

                this.top = "---";
                this.mid = "-0-";
                this.bot = "---";
                this.seen = false;
                squareArray = new String[]{top, mid, bot};
                break;

            default:

                this.top = "...";
                this.mid = "...";
                this.bot = "...";
                this.seen = false;
                squareArray = new String[]{top, mid, bot};

        }

    }
}
