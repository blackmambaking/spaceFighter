package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Aliens {
    private MyGdxGame myGdxGame= new MyGdxGame();
    private Player1 player1;

    private Vector2 position;
    private Vector2 positionLaser;
    private Sprite sprite;
    private Sprite laserSprite;
    private float speed = 100;
    //public float LaserSpeed = 300;
    private int a;
    private int b;

    public Vector2 getPosition() {
        return position;
    }

    public void setPosition(Vector2 position) {
        this.position = position;
    }

    public Vector2 getPositionLaser() {
        return positionLaser;
    }

    public void setPositionLaser(Vector2 positionLaser) {
        this.positionLaser = positionLaser;
    }

    public Sprite getSprite() {
        return sprite;
    }

    public void setSprite(Sprite sprite) {
        this.sprite = sprite;
    }

    public Sprite getLaserSprite() {
        return laserSprite;
    }

    public void setLaserSprite(Sprite laserSprite) {
        this.laserSprite = laserSprite;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public Aliens(Texture img){
        //myGdxGame = new MyGdxGame();
        sprite = new Sprite(img);
        //laserSprite = new Sprite(laserImg);
        Random rn = new Random();
        a = rn.nextInt(-300, 300);
        b = rn.nextInt(500, 800);
        position = new Vector2(a,b);
        //positionLaser = new Vector2(Gdx.graphics.getWidth()/2,-20);
        sprite.setScale((float) 0.25);

        //laserSprite.setScale((float) 0.2);


    }
    public void updateSprite(Texture img, float x, float y, final Texture img2) throws InterruptedException {
        sprite = new Sprite(img);
        sprite.setScale((float) 0.25);
        position.x = x;
        position.y = y;
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                sprite = new Sprite(img2);
                sprite.setScale((float) 0.25);
                Random rn = new Random();
                a = rn.nextInt(-300, 300);
                b = rn.nextInt(500, 800);
                position.y = b;
                position.x = a;
            }
        };
        timer.schedule(timerTask, 500L);
    }
    public void update(float deltaTime){
        if(position.y<=-180){
            Random rn = new Random();
            a = rn.nextInt(-300, 300);
            b = rn.nextInt(500, 800);
            position.y = b;
            position.x = a;
        }
//        if(myGdxGame != null && myGdxGame.getAlien() != null && myGdxGame.getPlayer1() != null && myGdxGame.getPlayer1().getSprite() != null && myGdxGame.getPlayer1().getLaserSprite() != null && myGdxGame.getAlien().getSprite() != null){
//            System.out.println("bello");
//            if(myGdxGame.getPlayer1().getLaserSprite().getBoundingRectangle().overlaps(myGdxGame.getAlien().getSprite().getBoundingRectangle())){
//                System.out.println("hello");
//                Random rn = new Random();
//                a = rn.nextInt(-300, 300);
//                b = rn.nextInt(200, 500);
//                player1.getLaserSprite().setPosition(0, 100000);
//                myGdxGame.getAlien().getSprite().setPosition(a,b);
//            }
//
//        }


        position.y -= deltaTime*speed;

    }
    public void draw(SpriteBatch batch){
        update(Gdx.graphics.getDeltaTime());
        sprite.setPosition(position.x, position.y);
        //laserSprite.setPosition(positionLaser.x, positionLaser.y);
        //laserSprite.draw(batch);
        sprite.draw(batch);
    }
}
