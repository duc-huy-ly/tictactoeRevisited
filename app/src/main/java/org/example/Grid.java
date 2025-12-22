package org.example;

import java.util.ArrayList;
import java.util.List;

public class Grid {
    private List<Cell> cells;
    
    public Grid(){
        this.cells = new ArrayList<>();
        for(int i = 0 ; i < 9 ; i++){
            cells.add(new Cell());
        }
    }
    
    public Cell getCell(int i){
        return cells.get(i);
    }

    public void printGrid(){
        for (int i = 0 ; i < 3 ; i ++){
            for (int j = 0 ; j < 3 ; j++){
                System.out.printf("|"+ cells.get(i + j).toString());
            }
            System.out.printf("|\n");
        }
    }

    
}
