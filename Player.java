package com.mycitrus;

public class Player {
    protected String outputLetter;
    protected boolean isTurn;

    public Player(String outputLetter, boolean isTurn){
        this.setOutputLetter(outputLetter);
        this.setIsTurn(isTurn);
    }

    public void setIsTurn(boolean turn){
        this.isTurn = turn;
    }

    public boolean getIsTurn(){
        return this.isTurn;
    }

    public void setOutputLetter(String letter){
        this.outputLetter = letter;
    }

    public String getOutputLetter(){
        return this.outputLetter;
    }
}
