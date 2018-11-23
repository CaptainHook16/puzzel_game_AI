package com.company;

import java.util.LinkedList;
import java.util.List;

//if a class doesn't preform all methods of interface it must declare itself as abstract
public abstract class Algorithms implements AlgoInterface {

    //protected can be seen by subclasses or package member
    protected BoardGame finalBoard;
    protected BoardGame cure_board;
    protected List<BoardGame> outOpenList;

    //we wont implement this method here - each algo would have different implementation
    public abstract void StartAlgorithm(BoardGame firstBoard);
    public abstract int thirdValueToPrint();
    public Algorithms(){this.outOpenList = new LinkedList<>();}

    public int numberOutOfOpenList(){
        return this.outOpenList.size();
    }

    public String findBestPath()
    {
        String s_direction;
        StringBuilder path = new StringBuilder();
        Enum.Direction current_direction = null;
        BoardGame current_board = this.finalBoard;
        while (current_board.getM_prev_state() != null &&
                current_board!=null)
        {
            current_direction = current_board.get_current_direction();
            s_direction = current_direction.name().substring(0,1);
            path.insert(0,s_direction);
            //go up to previous state
            current_board = current_board.getM_prev_state();
        }
        return path.toString();

    }
}
