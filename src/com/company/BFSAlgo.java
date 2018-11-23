package com.company;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSAlgo extends Algorithms {
    //BFS as we know use queue - FIFO - First In First Out
    private Queue<BoardGame> m_open_list;//declare our open list

    public void StartAlgorithm(BoardGame firstBoard){

        m_open_list = new LinkedList<>();
        super.cure_board = firstBoard;
        ((LinkedList<BoardGame>) m_open_list).add(cure_board);

        while (!m_open_list.isEmpty()){
            cure_board = m_open_list.remove();//pop first element in the queue
            System.out.println("removed");
            //cure_board.printBoard();
            //save the last output of the open list
            super.outOpenList.add(cure_board);
            if (cure_board.isWon())
            {
                //if we reached the goal
                super.finalBoard = cure_board;
                break;
            }else
            {
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
        System.out.println(super.outOpenList.size());
    }
}
