package com.company;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Astar extends Algorithms {
    private PriorityQueue<BoardGame> m_open_list = new PriorityQueue<BoardGame>(new Comparator<BoardGame>() {
        @Override
        public int compare(BoardGame a, BoardGame b) {
            int comp_a = a.calculateHuristicValue()+ a.getM_depth();
            int comp_b = b.calculateHuristicValue()+b.getM_depth();
            return comp_a-comp_b;
        }
    });

    public void StartAlgorithm(BoardGame firstBoard)
    {
        super.cure_board = firstBoard;
        m_open_list.add(cure_board);
        while (m_open_list.isEmpty()!=true)
        {
            //since we set the open list as priority queue it will remove the node with the lowest cost
            cure_board = m_open_list.remove();
            super.outOpenList.add(cure_board);
            if (cure_board.isWon() ){
                super.finalBoard = cure_board;
                break;
            }else {
                //get list of all optional move (valid) in the order of UP,DOWN,RIGHT,LEFT
                List<Enum.Direction> directions = cure_board.OptionalNextMoves();
                for(Enum.Direction direction: directions)
                {
                    BoardGame neighber = new BoardGame(super.cure_board.size(),null,super.cure_board,direction);
                    m_open_list.add(neighber);//add neighbor to the open list in required order
                    //System.out.println("child:");
                    //neighber.printBoard();
                }
            }

        }

    }

    public int thirdValueToPrint(){
        return this.finalBoard.getM_depth();//the cost of path is the length of path (edges wights considered one for each

    }
}
