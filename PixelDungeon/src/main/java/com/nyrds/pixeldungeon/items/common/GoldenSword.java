package com.nyrds.pixeldungeon.items.common;

import com.watabou.pixeldungeon.Dungeon;
import com.watabou.pixeldungeon.actors.Char;
import com.watabou.pixeldungeon.actors.hero.Hero;
import com.watabou.pixeldungeon.actors.hero.HeroSubClass;
import com.watabou.pixeldungeon.actors.mobs.Boss;
import com.watabou.pixeldungeon.actors.mobs.Mob;
import com.watabou.pixeldungeon.actors.mobs.npcs.NPC;
import com.watabou.pixeldungeon.items.Gold;
import com.watabou.pixeldungeon.items.weapon.melee.SpecialWeapon;
import com.watabou.pixeldungeon.sprites.ItemSprite.Glowing;
import com.watabou.utils.Random;

public class GoldenSword extends SpecialWeapon {
	{
		imageFile = "items/swords.png";
		image = 5;
	}

	public GoldenSword() {
		super( 3, 1f, 1f );
	}
	
	@Override
	public Glowing glowing() {
		float period = 1;
		return new Glowing(0xFFFF66, period);
	}

	@Override
	public void applySpecial(Hero hero, Char tgt ) {
		//Gold proc
		if (Random.Int(10) == 1){
		int price = this.price() / 10;
		if ( price > 500) { price = 500;}
			Dungeon.level.drop(new Gold(price), tgt.getPos());
		}
	}
}
