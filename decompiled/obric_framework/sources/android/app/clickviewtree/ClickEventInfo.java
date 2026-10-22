package android.app.clickviewtree;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class ClickEventInfo {
    public final int buttonState;
    public final String clickClassification;
    public final String coordinateSource;
    public final int displayId;
    public final long downTimeMillis;
    public final String eventId;
    public final int metaState;
    public final float rawX;
    public final float rawY;
    public final String source;
    public final String triggerSource;
    public final long upTimeMillis;
    public final float x;
    public final float y;

    public static final class Builder {
        private int mButtonState;
        private String mClickClassification;
        private String mCoordinateSource;
        private int mDisplayId;
        private long mDownTimeMillis;
        private String mEventId;
        private int mMetaState;
        private float mRawX;
        private float mRawY;
        private String mSource;
        private String mTriggerSource;
        private long mUpTimeMillis;
        private float mX;
        private float mY;

        /* JADX INFO: renamed from: -$$Nest$fgetmButtonState, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m4$$Nest$fgetmButtonState(Builder r0) {
            return r0.mButtonState;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmClickClassification, reason: not valid java name */
        static /* bridge */ /* synthetic */ String m5$$Nest$fgetmClickClassification(Builder r0) {
            return r0.mClickClassification;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmCoordinateSource, reason: not valid java name */
        static /* bridge */ /* synthetic */ String m6$$Nest$fgetmCoordinateSource(Builder r0) {
            return r0.mCoordinateSource;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmDisplayId, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m7$$Nest$fgetmDisplayId(Builder r0) {
            return r0.mDisplayId;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmDownTimeMillis, reason: not valid java name */
        static /* bridge */ /* synthetic */ long m8$$Nest$fgetmDownTimeMillis(Builder r2) {
            return r2.mDownTimeMillis;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmEventId, reason: not valid java name */
        static /* bridge */ /* synthetic */ String m9$$Nest$fgetmEventId(Builder r0) {
            return r0.mEventId;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmMetaState, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m10$$Nest$fgetmMetaState(Builder r0) {
            return r0.mMetaState;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmRawX, reason: not valid java name */
        static /* bridge */ /* synthetic */ float m11$$Nest$fgetmRawX(Builder r0) {
            return r0.mRawX;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmRawY, reason: not valid java name */
        static /* bridge */ /* synthetic */ float m12$$Nest$fgetmRawY(Builder r0) {
            return r0.mRawY;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmSource, reason: not valid java name */
        static /* bridge */ /* synthetic */ String m13$$Nest$fgetmSource(Builder r0) {
            return r0.mSource;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmTriggerSource, reason: not valid java name */
        static /* bridge */ /* synthetic */ String m14$$Nest$fgetmTriggerSource(Builder r0) {
            return r0.mTriggerSource;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmUpTimeMillis, reason: not valid java name */
        static /* bridge */ /* synthetic */ long m15$$Nest$fgetmUpTimeMillis(Builder r2) {
            return r2.mUpTimeMillis;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmX, reason: not valid java name */
        static /* bridge */ /* synthetic */ float m16$$Nest$fgetmX(Builder r0) {
            return r0.mX;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmY, reason: not valid java name */
        static /* bridge */ /* synthetic */ float m17$$Nest$fgetmY(Builder r0) {
            return r0.mY;
        }

        /* synthetic */ Builder(ClickEventInfoIA r1) {
            this();
        }

        private Builder() {
            this.mTriggerSource = "UNKNOWN";
            this.mClickClassification = "UNKNOWN";
            this.mDisplayId = -1;
            this.mX = Float.NaN;
            this.mY = Float.NaN;
            this.mRawX = Float.NaN;
            this.mRawY = Float.NaN;
            this.mCoordinateSource = "UNKNOWN";
        }

        public Builder setEventId(String eventId) {
            this.mEventId = eventId;
            return this;
        }

        public Builder setTriggerSource(String triggerSource) {
            this.mTriggerSource = triggerSource;
            return this;
        }

        public Builder setClickClassification(String clickClassification) {
            this.mClickClassification = clickClassification;
            return this;
        }

        public Builder setDisplayId(int displayId) {
            this.mDisplayId = displayId;
            return this;
        }

        public Builder setDownTimeMillis(long downTimeMillis) {
            this.mDownTimeMillis = downTimeMillis;
            return this;
        }

        public Builder setUpTimeMillis(long upTimeMillis) {
            this.mUpTimeMillis = upTimeMillis;
            return this;
        }

        public Builder setX(float x) {
            this.mX = x;
            return this;
        }

        public Builder setY(float y) {
            this.mY = y;
            return this;
        }

        public Builder setRawX(float rawX) {
            this.mRawX = rawX;
            return this;
        }

        public Builder setRawY(float rawY) {
            this.mRawY = rawY;
            return this;
        }

        public Builder setCoordinateSource(String coordinateSource) {
            this.mCoordinateSource = coordinateSource;
            return this;
        }

        public Builder setSource(String source) {
            this.mSource = source;
            return this;
        }

        public Builder setButtonState(int buttonState) {
            this.mButtonState = buttonState;
            return this;
        }

        public Builder setMetaState(int metaState) {
            this.mMetaState = metaState;
            return this;
        }

        public ClickEventInfo build() {
            return new ClickEventInfo(this, null);
        }
    }

    /* synthetic */ ClickEventInfo(Builder r1, ClickEventInfoIA r2) {
        this(r1);
    }

    private ClickEventInfo(Builder builder) {
        this.eventId = limitString(Builder.m9$$Nest$fgetmEventId(builder));
        this.triggerSource = fallback(Builder.m14$$Nest$fgetmTriggerSource(builder), "UNKNOWN");
        this.clickClassification = fallback(Builder.m5$$Nest$fgetmClickClassification(builder), "UNKNOWN");
        this.displayId = Builder.m7$$Nest$fgetmDisplayId(builder);
        this.downTimeMillis = Builder.m8$$Nest$fgetmDownTimeMillis(builder);
        this.upTimeMillis = Builder.m15$$Nest$fgetmUpTimeMillis(builder);
        this.x = Builder.m16$$Nest$fgetmX(builder);
        this.y = Builder.m17$$Nest$fgetmY(builder);
        this.rawX = Builder.m11$$Nest$fgetmRawX(builder);
        this.rawY = Builder.m12$$Nest$fgetmRawY(builder);
        this.coordinateSource = fallback(Builder.m6$$Nest$fgetmCoordinateSource(builder), "UNKNOWN");
        this.source = limitString(Builder.m13$$Nest$fgetmSource(builder));
        this.buttonState = Builder.m4$$Nest$fgetmButtonState(builder);
        this.metaState = Builder.m10$$Nest$fgetmMetaState(builder);
    }

    public static Builder builder() {
        return new Builder(null);
    }

    public JSONObject toJsonObject() throws JSONException {
        JSONObject object = new JSONObject();
        putNullable(object, ClickViewTreeConstants.FIELD_EVENT_ID, this.eventId);
        object.put(ClickViewTreeConstants.FIELD_TRIGGER_SOURCE, this.triggerSource);
        object.put(ClickViewTreeConstants.FIELD_CLICK_CLASSIFICATION, this.clickClassification);
        object.put(ClickViewTreeConstants.FIELD_DISPLAY_ID, this.displayId);
        object.put(ClickViewTreeConstants.FIELD_DOWN_TIME_MILLIS, this.downTimeMillis);
        object.put(ClickViewTreeConstants.FIELD_UP_TIME_MILLIS, this.upTimeMillis);
        putFloat(object, ClickViewTreeConstants.FIELD_X, this.x);
        putFloat(object, ClickViewTreeConstants.FIELD_Y, this.y);
        putFloat(object, ClickViewTreeConstants.FIELD_RAW_X, this.rawX);
        putFloat(object, ClickViewTreeConstants.FIELD_RAW_Y, this.rawY);
        object.put(ClickViewTreeConstants.FIELD_COORDINATE_SOURCE, this.coordinateSource);
        putNullable(object, ClickViewTreeConstants.FIELD_SOURCE, this.source);
        object.put(ClickViewTreeConstants.FIELD_BUTTON_STATE, this.buttonState);
        object.put(ClickViewTreeConstants.FIELD_META_STATE, this.metaState);
        return object;
    }

    public String toJsonString() throws JSONException {
        return toJsonObject().toString();
    }

    public String toString() {
        return toJsonString();
    L6:
        return "ClickEventInfo{eventId=" + this.eventId + ", displayId=" + this.displayId + "}";
    }

    private static void putNullable(JSONObject object, String name, Object value) throws JSONException {
        if (value != null) goto L4;
        Object r0 = JSONObject.NULL;
    L5:
        object.put(name, r0);
        return;
    L4:
        r0 = value;
        goto L5
    }

    private static void putFloat(JSONObject object, String name, float value) throws JSONException {
        if (Float.isNaN(value) == false) goto L5;
        Object r0 = JSONObject.NULL;
    L6:
        object.put(name, r0);
        return;
    L5:
        r0 = Float.valueOf(value);
        goto L6
    }

    private static String fallback(String value, String fallback) {
        if (value != null) goto L5;
        return fallback;
    L5:
        return value;
    }

    private static String limitString(String value) {
        if (value != null) goto L4;
    L8:
        return value;
    L4:
        if (value.length() <= 256) goto L8;
        return value.substring(0, 256);
    }
}
