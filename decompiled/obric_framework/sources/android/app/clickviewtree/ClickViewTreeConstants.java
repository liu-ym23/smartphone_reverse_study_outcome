package android.app.clickviewtree;

/* JADX INFO: loaded from: classes.dex */
public final class ClickViewTreeConstants {
    public static final String CALL_USER_PROPERTY = "sys.obric.click_viewtree.call_user";
    public static final String CLICK_CLASSIFICATION_TOUCH_CONFIRMED_CLICK = "TOUCH_CONFIRMED_CLICK";
    public static final String CLICK_CLASSIFICATION_TOUCH_CONSUMED_NO_CLICK = "TOUCH_CONSUMED_NO_CLICK";
    public static final String CLICK_CLASSIFICATION_TOUCH_NOT_CONSUMED = "TOUCH_NOT_CONSUMED";
    public static final String CLICK_CLASSIFICATION_UNKNOWN = "UNKNOWN";
    public static final String CONSUME_REASON_NONE = "NONE";
    public static final String CONSUME_REASON_ON_TOUCH_EVENT = "ON_TOUCH_EVENT";
    public static final String CONSUME_REASON_ON_TOUCH_LISTENER = "ON_TOUCH_LISTENER";
    public static final String CONSUME_REASON_PERFORM_CLICK = "PERFORM_CLICK";
    public static final String CONSUME_REASON_UNKNOWN = "UNKNOWN";
    public static final String CONSUME_REASON_VIEW_GROUP_INTERCEPT = "VIEW_GROUP_INTERCEPT";
    public static final String COORDINATE_SOURCE_INPUT_EVENT = "INPUT_EVENT";
    public static final String COORDINATE_SOURCE_NONE = "NONE";
    public static final String COORDINATE_SOURCE_UNKNOWN = "UNKNOWN";
    public static final String DEBUG_JSON_PROPERTY = "persist.sys.obric.click_viewtree.debug_json";
    public static final String DEBUG_PROPERTY = "persist.sys.obric.click_viewtree.debug";
    public static final String FIELD_BUTTON_STATE = "buttonState";
    public static final String FIELD_CLICK_CLASSIFICATION = "clickClassification";
    public static final String FIELD_CONSUME_REASON = "consumeReason";
    public static final String FIELD_COORDINATE_SOURCE = "coordinateSource";
    public static final String FIELD_DISPLAY_ID = "displayId";
    public static final String FIELD_DOWN_TIME_MILLIS = "downTimeMillis";
    public static final String FIELD_EVENT = "event";
    public static final String FIELD_EVENT_ID = "eventId";
    public static final String FIELD_MATCHED_BY = "matchedBy";
    public static final String FIELD_META_STATE = "metaState";
    public static final String FIELD_RAW_X = "rawX";
    public static final String FIELD_RAW_Y = "rawY";
    public static final String FIELD_SOURCE = "source";
    public static final String FIELD_STATUS = "status";
    public static final String FIELD_TRIGGER_SOURCE = "triggerSource";
    public static final String FIELD_UP_TIME_MILLIS = "upTimeMillis";
    public static final String FIELD_X = "x";
    public static final String FIELD_Y = "y";
    public static final String INJECT_LISTENER_PROPERTY = "sys.obric.click_viewtree.inject_listener";
    public static final String KEY_ASSIST_STRUCTURE = "assist_structure";
    public static final String KEY_ASSIST_STRUCTURE_TYPE = "type";
    public static final String KEY_CLICK_CLASSIFICATION = "obric.click_viewtree.click_classification";
    public static final String KEY_EVENT_ID = "event_id";
    public static final String MATCHED_BY_FINGERPRINT = "fingerprint";
    public static final String MATCHED_BY_NONE = "none";
    public static final String MATCHED_BY_UNKNOWN = "unknown";
    public static final int MAX_CACHED_RECORD_COUNT = 32;
    public static final int MAX_STRING_LENGTH = 256;
    public static final int MAX_VIEW_NODE_COUNT = 1000;
    public static final int MAX_VIEW_TREE_DEPTH = 5;
    public static final long RECORD_TTL_MILLIS = 5000;
    public static final String STATUS_APP_REPORT_TIMEOUT = "APP_REPORT_TIMEOUT";
    public static final String STATUS_NO_CONSUMER = "NO_CONSUMER";
    public static final String STATUS_NO_TARGET_WINDOW = "NO_TARGET_WINDOW";
    public static final String STATUS_PERMISSION_DENIED = "PERMISSION_DENIED";
    public static final String STATUS_SECURE_BLOCKED = "SECURE_BLOCKED";
    public static final String STATUS_SERIALIZE_FAILED = "SERIALIZE_FAILED";
    public static final String STATUS_SUCCESS = "SUCCESS";
    public static final String STATUS_UNKNOWN = "UNKNOWN";
    public static final String TRIGGER_SOURCE_MOTION_EVENT = "MOTION_EVENT";
    public static final String TRIGGER_SOURCE_UNKNOWN = "UNKNOWN";

    public static String formatSource(int source) {
        return "0x" + Integer.toHexString(source);
    }

    private ClickViewTreeConstants() {
    }
}
