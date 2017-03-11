package com.example.xeus_labmacbook.growup.Event;

import com.example.xeus_labmacbook.growup.model.ServerResponse;

/**
 * Created by DuckWalkZ on 10/3/2560.
 */

public class ServerEvent {
    private ServerResponse serverResponse;

    public ServerEvent(ServerResponse serverResponse) {
        this.serverResponse = serverResponse;
    }

    public ServerResponse getServerResponse() {
        return serverResponse;
    }

    public void setServerResponse(ServerResponse serverResponse) {
        this.serverResponse = serverResponse;
    }
}
