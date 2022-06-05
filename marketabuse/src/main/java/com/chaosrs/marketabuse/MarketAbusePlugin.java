package com.chaosrs.marketabuse;

import com.google.inject.Provides;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.GrandExchangeOffer;
import net.runelite.api.GrandExchangeOfferState;
import net.runelite.api.events.GameTick;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.api.events.GrandExchangeOfferChanged;
import org.pf4j.Extension;

@Extension
@PluginDescriptor(
	name = "MarketAbuse",
	description = "Integration with the MarketAbuse application"
)
@Slf4j
public class MarketAbusePlugin extends Plugin
{
	GrandExchangeOffer grandExchangeOffers[];

	// Injects our config
	@Inject
	private MarketAbuseConfig config;

	// Provides our config
	@Provides
	MarketAbuseConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(MarketAbuseConfig.class);
	}

	@Override
	protected void startUp()
	{
		// runs on plugin startup
		log.info("MarketAbuse started");
		grandExchangeOffers = new GrandExchangeOffer[8];
	}

	@Override
	protected void shutDown()
	{
		// runs on plugin shutdown
		log.info("MarketAbuse stopped");
	}

	@Subscribe
	private void onGameTick(GameTick gameTick)
	{
		// runs every gametick
		log.info("On GameTick");
	}

	@Subscribe
	public void onGrandExchangeOfferChanged(GrandExchangeOfferChanged offerChangedEvent) {
		grandExchangeOffers[offerChangedEvent.getSlot()] = offerChangedEvent.getOffer();
	}
}