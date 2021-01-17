package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class GameScreen implements Screen {
    private int width = 600;
    private int height = 600;
    private OrthographicCamera camera = new OrthographicCamera(width,height);
    private Viewport viewport;
    private MyGdxGame game;
    private GameState gameState = new GameState();

    public GameScreen(MyGdxGame game){
        this.game = game;
        camera.setToOrtho(false, width, height);
        viewport = new FitViewport(width, height, camera);
        viewport.apply();
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        camera.update();
        viewport.apply();

        gameState.update(delta);
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        gameState.draw(width,height, camera);
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
