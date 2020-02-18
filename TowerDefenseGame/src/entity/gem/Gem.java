package entity.gem;

import java.util.Random;

public class Gem {

	private int grade;
	
	private int minDamage;
	private int maxDamage;
	private int range;
	private int firingRate;
	
	private Random random;
	
	public Gem(int grade) {
		this.grade = grade;
		random = new Random();
		updateGem();
	}
	
	public int getFiringRate() {
		return firingRate;
	}
	
	public void setFiringRate(int firingRate) {
		this.firingRate = firingRate;
	}
	
	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public int getMinDamage() {
		return minDamage;
	}

	public void setMinDamage(int minDamage) {
		this.minDamage = minDamage;
	}

	public int getMaxDamage() {
		return maxDamage;
	}

	public void setMaxDamage(int maxDamage) {
		this.maxDamage = maxDamage;
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	private void updateGem() {
		/**
		 * sets the fire rate
		 */
		firingRate = (2 + Math.round(random.nextInt() * 2)) * grade;
		
		/**
		 * sets the range
		 */
		range = (5 + Math.round(random.nextInt() * 2)) * grade;
		
		/**
		 * Sets the damage up
		 */
		minDamage = 2 * grade;
		maxDamage = 3 * grade;
		
		int randomEffect = Math.round(random.nextInt(4) * grade);
		boolean neg = random.nextBoolean();
		
		if(neg)
			minDamage -= randomEffect;
		else
			minDamage += randomEffect;
		
		randomEffect = Math.round(random.nextInt(4) * grade);
		neg = random.nextBoolean();
		
		if(neg)
			maxDamage -= randomEffect;
		else
			maxDamage += randomEffect;
	}
	
	public int getDamageForOneShot() {
		return minDamage + random.nextInt(maxDamage - minDamage);
	}
	
	
}
