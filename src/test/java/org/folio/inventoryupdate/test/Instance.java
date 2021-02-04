package org.folio.inventoryupdate.test;

import io.vertx.core.json.JsonObject;

public class Instance extends InventoryRecord {

  public static String TITLE = "title";
  public static String INSTANCE_TYPE_ID = "instanceTypeId";
  public static String MATCH_KEY = "matchKey";
  public static String HRID = "hrid";

  public Instance (JsonObject record) {
    super(record);
  }

  public Instance () {
    super();
  }

  public Instance setTitle (String title) {
    recordJson.put(TITLE, title);
    return this;
  }

  public Instance setInstanceTypeId (String instanceTypeId) {
    recordJson.put(INSTANCE_TYPE_ID, instanceTypeId);
    return this;
  }

  public Instance setMatchKey (String matchKey) {
    recordJson.put(MATCH_KEY, matchKey);
    return this;
  }

  public Instance setHrid (String hrid) {
    recordJson.put(HRID, hrid);
    return this;
  }

  public String getHrid () {
    return recordJson.getString(HRID);
  }

  public boolean match(String query) {
    String trimmed = query.replace("(","").replace(")", "");
    String[] queryParts = trimmed.split("==");
    System.out.println("query: " +query);
    System.out.println("queryParts[0]: " + queryParts[0]);
    String key = queryParts[0];
    String value = queryParts.length > 1 ?  queryParts[1].replace("\"", "") : "";
    System.out.println("key: "+key);
    System.out.println("value: "+value);
    System.out.println("instance.getString(key): " + recordJson.getString(key));
    return (recordJson.getString(key) != null && recordJson.getString(key).equals(value));
  }
}
