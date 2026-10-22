package os.teatracker;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class TeaEvent {
    private String event;
    private boolean isInstant;
    private JSONObject jsonParams;
    private long timestamp;

    public TeaEvent(String event, JSONObject params) {
        this(event, params, false);
    }

    public TeaEvent(String event, JSONObject params, boolean isInstant) {
        this(event, params, isInstant, System.currentTimeMillis());
    }

    public TeaEvent(String event, JSONObject params, boolean isInstant, long timestamp) {
        this.event = event;
        this.jsonParams = params;
        this.isInstant = isInstant;
        this.timestamp = timestamp;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public void setJsonParams(JSONObject jsonParams) {
        this.jsonParams = jsonParams;
    }

    public String getEvent() {
        return this.event;
    }

    public JSONObject getJsonParams() {
        return this.jsonParams;
    }

    public boolean isInstant() {
        return this.isInstant;
    }

    public void setInstant(boolean instant) {
        this.isInstant = instant;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String toString() {
        return "Event{isInstant = '" + this.isInstant + "', event = '" + this.event + "', jsonParams = '" + this.jsonParams + "'}";
    }
}
