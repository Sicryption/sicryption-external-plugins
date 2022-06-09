package com.chaosrs.marketabuse;

import net.runelite.api.GrandExchangeOffer;
import com.chaosrs.marketabuse.org.json.JSONObject;

public class GEOfferMessage implements IMessage {
    GEOfferMessage(GrandExchangeOffer offer) {
        this.offer = offer;
    }

    @Override
    public JSONObject serialize() {

        System.out.println("Creating message");
        JSONObject jsonObject = new JSONObject();

        System.out.println("Created message 2");

        jsonObject.put("TEST", "12345696969");
        // jsonObject.put("GEOffer", offer);

        System.out.println("Created message " + jsonObject.toString());
        return jsonObject;
    }

    @Override
    public void deserialize(JSONObject jsonObject) {

    }

    private GrandExchangeOffer offer;
}
