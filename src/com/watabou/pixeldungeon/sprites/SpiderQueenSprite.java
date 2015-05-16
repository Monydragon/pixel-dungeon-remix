package com.watabou.pixeldungeon.sprites;

import com.watabou.noosa.TextureFilm;
import com.watabou.noosa.audio.Sample;
import com.watabou.pixeldungeon.Assets;
import com.watabou.pixeldungeon.actors.mobs.Warlock;
import com.watabou.pixeldungeon.effects.MagicMissile;
import com.watabou.utils.Callback;

public class SpiderQueenSprite extends MobSprite {
	
	public SpiderQueenSprite() {
		super();
		
		texture( Assets.SPIDER_QUEEN );
		
		TextureFilm frames = new TextureFilm( texture, 16, 15 );
		
		idle = new Animation( 2, true );
		idle.frames( frames, 0, 0, 0, 1, 0, 0, 1, 1 );
		
		run = new Animation( 15, true );
		run.frames( frames, 0, 2, 3, 4 );
		
		attack = new Animation( 12, false );
		attack.frames( frames, 0, 5, 6 );
		
		zap = attack.clone();
		
		die = new Animation( 15, false );
		die.frames( frames, 0, 7, 8, 8, 9, 10 );
		
		play( idle );
	}
	
	public void zap( int cell ) {
		
		turnTo( ch.pos , cell );
		play( zap );
		
		MagicMissile.shadow( parent, ch.pos, cell, 
			new Callback() {			
				@Override
				public void call() {
					((Warlock)ch).onZapComplete();
				}
			} );
		Sample.INSTANCE.play( Assets.SND_ZAP );
	}
	
	@Override
	public void onComplete( Animation anim ) {
		if (anim == zap) {
			idle();
		}
		super.onComplete( anim );
	}
}