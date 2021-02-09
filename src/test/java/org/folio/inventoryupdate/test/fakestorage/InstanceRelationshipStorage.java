package org.folio.inventoryupdate.test.fakestorage;

import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.RoutingContext;
import org.folio.inventoryupdate.test.fakestorage.entitites.InputInstanceRelationship;


public class InstanceRelationshipStorage extends RecordStorage {


    @Override
    public String getResultSetName() {
        return INSTANCE_RELATIONSHIPS;
    }

    @Override
    protected void declareDependencies() {
        fakeStorage.instanceStorage.acceptDependant(this, InputInstanceRelationship.SUB_INSTANCE_ID);
        fakeStorage.instanceStorage.acceptDependant(this, InputInstanceRelationship.SUPER_INSTANCE_ID);
    }

    public void createRecord(RoutingContext routingContext) {
        JsonObject recordJson = new JsonObject(routingContext.getBodyAsString());
        int code = insert(new InputInstanceRelationship(recordJson));
        respond(routingContext, recordJson, code);
    }

    public void updateRecord(RoutingContext routingContext) {
        // not needed
    }

}
