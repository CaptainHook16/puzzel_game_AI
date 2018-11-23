package com.company;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class IterativeDFS extends Algorithms {
    private Stack<BoardGame> m_open_list;
    private int m_depth_tree=-1;

    public int thirdValueToPrint(){
        return m_depth_tree;
    }
    public void StartAlgorithm(BoardGame first_board)
    {
        int lim = 0;
        while (!(DepthFirstSearchLimit(lim,first_board))){
            ++lim;
        }
        m_depth_tree = cure_board.getM_depth();

    }

    public boolean DepthFirstSearchLimit(int lim, BoardGame first)
    {
        //init our outof open list
        super.outOpenList = new LinkedList<>();
        //init our stack
        m_open_list = new Stack<>();
        super.cure_board = first;
        m_open_list.push(first);//push the first board to stack
        //as long as the stack is not empty
        while (m_open_list.isEmpty() != true)
        {
            cure_board = m_open_list.pop();//pop last item from stack
            super.outOpenList.add(cure_board);
            if (cure_board.isWon()) {
                super.finalBoard = cure_board;//update goal state
                return true;

            }else
                {
                    if (lim == cure_board.getM_depth()){
                        continue;//if we get to node in the limited , we wont add it to open list,
                        //but we need to keep checking the other nodes in the tree
                    }
                    //get list of all optional move (valid) in the order of UP,DOWN,RIGHT,LEFT
                    List<Enum.Direction> directions = cure_board.OptionalNextMoves();
                    Collections.reverse(directions);
                    for(Enum.Direction direction: directions)
                    {
                        BoardGame neighber = new BoardGame(super.cure_board.size(),null,super.cure_board,direction);
                        m_open_list.push(neighber);//add neighbor to the open list in required order
                        //System.out.println("child:");
                        //neighber.printBoard();
                    }
                }
        }
        return false;

    }
}
