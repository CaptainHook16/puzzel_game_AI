package com.company;

//collection of abstract methods used in our Algorithms.
public interface AlgoInterface {

    public int numberOutOfOpenList();

    public String findBestPath();

    //bfs - 0, A* - path cost, IDS - depth
    public int thirdValueToPrint();

    public void StartAlgorithm(BoardGame firstBoard);

}
