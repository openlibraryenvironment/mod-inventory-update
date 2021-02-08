package org.folio.inventoryupdate.test;

import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.RoutingContext;

public class InstanceStorage extends RecordStorage {

    @Override
    protected void createRecord(RoutingContext routingContext) {
        JsonObject recordJson = new JsonObject(routingContext.getBodyAsString());
        int code = insert(new TestInstance(recordJson));
        respond(routingContext, recordJson, code);
    }

    @Override
    protected void updateRecord(RoutingContext routingContext) {
        JsonObject recordJson = new JsonObject(routingContext.getBodyAsString());
        String id = routingContext.pathParam("id");
        int code = update(id, new TestInstance(recordJson));
        respond(routingContext, code);
    }

    public String getResultSetName() {
        return INSTANCES;
    }

}