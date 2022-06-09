package com.chaosrs.marketabuse;

import com.chaosrs.marketabuse.org.json.JSONObject;

public interface IMessage {
    JSONObject serialize();
    void deserialize(JSONObject jsonObject);
}
