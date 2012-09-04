package com.bc.d3.data;

import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonAutoDetect.Visibility;

@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class CharacterStats {

	private int life;
	private int damage;
	private double attackSpeed;
	private int armor;
	private int strength;
	private int dexterity;
	private int vitality;
	private int intelligence;
	private int physicalResist;
	private int fireResist;
	private int coldResist;
	private int lightningResist;
	private int poisonResist;
	private int arcaneResist;
	private double critDamage;
	private double damageIncrease;
	private double critChance;
	private double damageReduction;
	private double blockChance;
	private int thorns;
	private int lifeSteal;
	private int lifePerKill;
	private int goldFind;
	private int magicFind;
	private int blockAmountMin;
	private int blockAmountMax;
	private int lifeOnHit;
	private int primaryResource;
	private int secondaryResource;
	private int experienceBonus;

	public int getLife() {
		return life;
	}

	public int getDamage() {
		return damage;
	}

	public double getAttackSpeed() {
		return attackSpeed;
	}

	public int getArmor() {
		return armor;
	}

	public int getStrength() {
		return strength;
	}

	public int getDexterity() {
		return dexterity;
	}

	public int getVitality() {
		return vitality;
	}

	public int getIntelligence() {
		return intelligence;
	}

	public int getPhysicalResist() {
		return physicalResist;
	}

	public int getFireResist() {
		return fireResist;
	}

	public int getColdResist() {
		return coldResist;
	}

	public int getLightningResist() {
		return lightningResist;
	}

	public int getPoisonResist() {
		return poisonResist;
	}

	public int getArcaneResist() {
		return arcaneResist;
	}

	public double getCritDamage() {
		return critDamage;
	}

	public double getDamageIncrease() {
		return damageIncrease;
	}

	public double getCritChance() {
		return critChance;
	}

	public double getDamageReduction() {
		return damageReduction;
	}

	public double getBlockChance() {
		return blockChance;
	}

	public int getThorns() {
		return thorns;
	}

	public int getLifeSteal() {
		return lifeSteal;
	}

	public int getLifePerKill() {
		return lifePerKill;
	}

	public int getGoldFind() {
		return goldFind;
	}

	public int getMagicFind() {
		return magicFind;
	}

	public int getBlockAmountMin() {
		return blockAmountMin;
	}

	public int getBlockAmountMax() {
		return blockAmountMax;
	}

	public int getLifeOnHit() {
		return lifeOnHit;
	}

	public int getPrimaryResource() {
		return primaryResource;
	}

	public int getSecondaryResource() {
		return secondaryResource;
	}

	public int getExperienceBonus() {
		return experienceBonus;
	}

}
