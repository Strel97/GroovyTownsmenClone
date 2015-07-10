package com.strel.townsmen.game

import com.strel.townsmen.engine.game.GameCore
import com.strel.townsmen.game.menu.MainMenu
import com.strel.townsmen.game.states.MenuState
import com.strel.townsmen.game.states.RunningState
import com.strel.townsmen.game.states.StateMachine

import java.awt.Graphics2D
import java.awt.event.KeyEvent

/**
 * Created by strel on 13.06.15.
 */
class TownsmenGame extends GameCore {

    private static TownsmenGame instance
    StateMachine stateMachine


    private TownsmenGame() {
        super()

        stateMachine = new StateMachine()
        stateMachine.state = new MenuState(new MainMenu())
    }

    static TownsmenGame getInstance() {
        if (!instance)
            instance = new TownsmenGame()

        return instance
    }

    void newGame() {
        stateMachine.clear()
        stateMachine.state = new RunningState()
    }

    @Override
    void handleInput() {
        input.poll()
        if (input.keyDownOnce(KeyEvent.VK_ESCAPE)) {
            if (stateMachine.hasPrevious())
                stateMachine.returnToPrevious()
            else
                stop()
        }
    }

    @Override
    void update(long elapsedTime) {
        handleInput()
        stateMachine.update(input)
    }

    @Override
    void render() {
        Graphics2D g = (Graphics2D) img.graphics

        canvas.render(g)
        stateMachine.draw(g)

        canvas.graphics.drawImage(img, 0, 0, canvas.width, canvas.height, null)

        g.dispose()
    }

    int wndWidth() {
        return img.width
    }

    int wndHeight() {
        return img.height
    }
}
