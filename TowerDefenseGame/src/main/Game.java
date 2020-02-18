package main;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import display.Display;
import gfx.Assets;
import input.KeyManager;
import input.MouseManager;
import states.GameState;
import states.MenuState;
import states.State;

public class Game implements Runnable{

	private Display display;
	
	private String title;
	
	private boolean running;
	
	private BufferStrategy bufferedStrategy;
	private Graphics graphics;
		
	private MouseManager mouse;
	private KeyManager keyboard;
	
	private State gameState;
	private State menuState;
	
	private Thread thread;
	
	public Game(String title) {
		this.title = title;
		
		mouse = new MouseManager();
		keyboard = new KeyManager();
	}

	
	private void init() {
		display = new Display(title, Launcher.WIDTH, Launcher.HEIGHT);
		display.getFrame().addKeyListener(keyboard);
		display.getFrame().addMouseListener(mouse);
		
		Assets.init();
		
		gameState = new GameState(this);
		menuState = new MenuState(this);
		State.setState(gameState);
	}
	
	
	@Override
	public void run() {
		
		init();
		
		int fps = 60;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;
		
		while(running) {
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer+= now - lastTime;
			lastTime = now;
			
			/**
			 * checks if we need to perform a render to get 60fps
			 * delta decrements since that is the 60 fps
			 */
			if(delta >= 1) {
				tick();
				render();
				ticks++;
				delta--;
			}
			
			if(timer >= 1000000000) {
				System.out.println("Ticks and Frames: " + ticks);
				ticks = 0;
				timer = 0;
			}
		}
		
		stop();
		
	}
	
	/**
	 * updates the stuff
	 */
	private void tick() {
		keyboard.tick();
		
		if(State.getState() != null) {
			State.getState().tick();
		}
	}
	
	/**
	 * changes the graphics
	 */
	private void render() {
		bufferedStrategy = display.getCanvas().getBufferStrategy();
		if(bufferedStrategy == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		
		graphics = bufferedStrategy.getDrawGraphics();
		
		//clear the screen first
		
		graphics.clearRect(0, 0, Launcher.WIDTH, Launcher.HEIGHT);
		
		//Draw here
		if(State.getState() != null) {
			State.getState().render(graphics);
		}
		
		
		//end drawing
		bufferedStrategy.show();		//updates the buffer
		graphics.dispose();				//gets rid of the graphics object
	}
	
	public KeyManager getKeyManager() {
		return keyboard;
	}
	
	public MouseManager getMouseManager() {
		return mouse;
	}
	
	public synchronized void start() {
		if(running == true)
			return;
		
		running = true;
		thread = new Thread(this);
		thread.start();
		
	}
	
	public synchronized void stop() {
		if(running == false)
			return;
		
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
