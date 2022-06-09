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

import java.io.IOException;

@Extension
@PluginDescriptor(
	name = "MarketAbuse",
	description = "Integration with the MarketAbuse application"
)
@Slf4j
public class MarketAbusePlugin extends Plugin
{
	GrandExchangeOffer grandExchangeOffers[];
	MarketAbuseTCPClient client;

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
	protected void startUp() throws IOException {
		grandExchangeOffers = new GrandExchangeOffer[8];
		client = new MarketAbuseTCPClient();
	}

	@Override
	protected void shutDown()
	{
	}

	@Subscribe
	private void onGameTick(GameTick gameTick)
	{
	}

	@Subscribe
	public void onGrandExchangeOfferChanged(GrandExchangeOfferChanged offerChangedEvent) throws IOException {
		grandExchangeOffers[offerChangedEvent.getSlot()] = offerChangedEvent.getOffer();

		System.out.println("GE Offer Changed!");

		client.sendMessage(new GEOfferMessage(offerChangedEvent.getOffer()));
	}
}