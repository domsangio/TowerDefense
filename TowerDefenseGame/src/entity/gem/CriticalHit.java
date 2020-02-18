package entity.gem;

import java.awt.image.BufferedImage;

public class CriticalHit extends Gem {

	private double minMultiply;
	private double maxMultiply;
	
	private BufferedImage gemImage;
	
	public CriticalHit(int grade) {
		super(grade);
		minMultiply = grade*grade*2;
		maxMultiply = grade*grade*3;
	}

	public CriticalHit() {
		super(1);
	}
	
	
	
	
	
}
