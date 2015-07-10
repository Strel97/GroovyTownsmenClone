package com.strel.townsmen.game.states

import com.strel.townsmen.engine.game.Playable
import com.strel.townsmen.engine.input.InputHandler

import java.awt.Graphics2D

/**
 * Created by strel on 13.06.15.
 */
class StateMachine {

    private Stack<GameState> states;


    public StateMachine() {
        states = new Stack<GameState>();
    }

    public void setState(GameState state) {
        states.push(state);
    }

    public GameState getState() {
        return states.peek();
    }

    public boolean hasPrevious() {
        return states.size() > 1
    }

    public void returnToPrevious() {
        states.pop();
    }

    public void clear() {
        states.clear();
    }

    public void update(InputHandler input) {

        states.peek().update(input);
    }

    public void draw(Graphics2D g) {
        states.peek().draw(g);
    }
}
