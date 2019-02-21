/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessPackage;

/**
 *
 * @author tonip
 */
public enum Alliance {
    WHITE{
        @Override
        public int getDirection(){
            return -1;
        }
        
        @Override
        public boolean isBlack(){
            return false;
        }
        
        @Override
        public boolean isWhite(){
            return true;
        }
    },
    BLACK{

        @Override
       public  int getDirection(){
            return 1;
        }
       
        @Override
       public boolean isWhite(){
           return false;
       }
       
       @Override
        public boolean isBlack(){
            return true;
        }
};

public abstract int getDirection();
public abstract boolean isWhite();
public abstract boolean isBlack();
}