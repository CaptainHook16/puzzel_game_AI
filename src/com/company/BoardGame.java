package com.company;

public class BoardGame
{
    //declere class members
    private BoardGame m_prev_state;
    private Enum.Direction m_direction;
    private int[] m_missing_prev_state;
    private int[] m_current_missing;
    private int m_depth;
    private int m_size;
    private int[][] m_numbers;


    /**
     *   BoardGame Constructor
     * @param   size - sixe of board
     * @param  numbers - 2D array of board numbers
     * @param  prev_state: the previous state before moving
     * @param direction:where to move
     */
    public BoardGame(int size,int[][] numbers,BoardGame prev_state,Enum.Direction direction){
        this.m_size = size;
        this.m_direction=direction;
        this.m_prev_state =prev_state;
        this.m_numbers = new int[size][size];
        //if this is son
        if (prev_state != null){
            this.m_depth = 1+prev_state.m_depth;
            InitBoard();
            //if this is the root
        }else{
            this.m_depth=0;
            this.m_numbers=numbers;
        }
        this.setCurrentMissingNumber();
    }

    private void setCurrentMissingNumber(){

        for(int raw=0;raw<this.m_size;++raw){
            for (int col=0;col<this.m_size;++col){
                if(this.m_numbers[raw][col] == 0){
                    this.m_current_missing[0]=raw;
                    this.m_current_missing[1] = col;
                    break;
                }
            }
        }
    }

    private int[][] getNumbers(){
        return m_numbers;
    }

    private void set_missing_prev_state(int i,int j){
        this.m_missing_prev_state[0]=i;
        this.m_missing_prev_state[1]=j;
    }

    private void InitBoard(){
        if (m_prev_state == null){
            return;
        }

        int[][] originalArr = this.m_prev_state.getNumbers();
        for(int raw=0;raw<this.m_size;++raw){
            for (int col=0;col<this.m_size;++col){
                if(originalArr[raw][col] == 0){
                    this.set_missing_prev_state(raw,col);
                }
                this.m_numbers[raw][col] = originalArr[raw][col];
            }
        }
        this.move();

    }

    private void move(){
        switch (this.m_direction){
            case Left:
                this.turn_left();
                break;
            case Right:
                this.turn_right();
                break;
            case Up:
                this.turn_up();
                break;
            case Down:
                this.turn_down();
                break;

        }
    }

    public Enum.Direction get_current_direction(){
        return this.m_direction;
    }

    public boolean isWon(){
        //check if the zero is at last place
        if (!(this.m_current_missing[0]==m_size-1 && m_current_missing[1]==m_size-1)){
            return false;
        }
        int correct_number=1;
        for(int i=0;i<m_size;++i){
            for (int k=0;k<m_size;++k){
                if(this.m_numbers[i][k] != correct_number){
                    return false;
                }
            }
        }
        return true;
    }



    private void turn_left(){
        if(this.m_missing_prev_state[1]<this.m_size -1)
        {
            //save into temp var the number we want to move left twards the 0
            int temp_num = this.m_numbers[m_missing_prev_state[0]][m_missing_prev_state[1]+1];
            m_numbers[m_missing_prev_state[0]][m_missing_prev_state[1]] = temp_num;
            m_numbers[m_missing_prev_state[0]][m_missing_prev_state[1]+1] = 0;
        }
    }

    private void turn_right(){
        if(this.m_missing_prev_state[1]>0){
            //save into temp var the number we want to move left twards the 0
            int temp_num = this.m_numbers[m_missing_prev_state[0]][m_missing_prev_state[1]-1];
            m_numbers[m_missing_prev_state[0]][m_missing_prev_state[1]] = temp_num;
            m_numbers[m_missing_prev_state[0]][m_missing_prev_state[1]-1] = 0;
        }
    }

    private void turn_down(){
        if(this.m_missing_prev_state[1]>0)
        {
            //save into temp var the number we want to move left twards the 0
            int temp_num = this.m_numbers[m_missing_prev_state[0]-1][m_missing_prev_state[1]];
            m_numbers[m_missing_prev_state[0]][m_missing_prev_state[1]] = temp_num;
            m_numbers[m_missing_prev_state[0]-1][m_missing_prev_state[1]] = 0;
        }

    }

    private void turn_up()
    {
        if(this.m_missing_prev_state[1]<this.m_size -1){
            //save into temp var the number we want to move left twards the 0
            int temp_num = this.m_numbers[m_missing_prev_state[0]+1][m_missing_prev_state[1]];
            m_numbers[m_missing_prev_state[0]][m_missing_prev_state[1]] = temp_num;
            m_numbers[m_missing_prev_state[0]+1][m_missing_prev_state[1]] = 0;
        }
    }
}
