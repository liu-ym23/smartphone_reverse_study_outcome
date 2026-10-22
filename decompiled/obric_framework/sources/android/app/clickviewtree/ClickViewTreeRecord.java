package android.app.clickviewtree;

import android.app.assist.AssistStructure;
import android.os.Bundle;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class ClickViewTreeRecord {
    public final AssistStructure assistStructure;
    public final String clickClassification;
    public final String consumeReason;
    public final ClickEventInfo event;
    public final String matchedBy;
    public final String status;

    public static final class Builder {
        private AssistStructure mAssistStructure;
        private String mClickClassification;
        private String mConsumeReason;
        private ClickEventInfo mEvent;
        private String mMatchedBy;
        private String mStatus;

        /* JADX INFO: renamed from: -$$Nest$fgetmAssistStructure, reason: not valid java name */
        static /* bridge */ /* synthetic */ AssistStructure m32$$Nest$fgetmAssistStructure(Builder r0) {
            return r0.mAssistStructure;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmClickClassification, reason: not valid java name */
        static /* bridge */ /* synthetic */ String m33$$Nest$fgetmClickClassification(Builder r0) {
            return r0.mClickClassification;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmConsumeReason, reason: not valid java name */
        static /* bridge */ /* synthetic */ String m34$$Nest$fgetmConsumeReason(Builder r0) {
            return r0.mConsumeReason;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmEvent, reason: not valid java name */
        static /* bridge */ /* synthetic */ ClickEventInfo m35$$Nest$fgetmEvent(Builder r0) {
            return r0.mEvent;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmMatchedBy, reason: not valid java name */
        static /* bridge */ /* synthetic */ String m36$$Nest$fgetmMatchedBy(Builder r0) {
            return r0.mMatchedBy;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmStatus, reason: not valid java name */
        static /* bridge */ /* synthetic */ String m37$$Nest$fgetmStatus(Builder r0) {
            return r0.mStatus;
        }

        /* synthetic */ Builder(ClickViewTreeRecordIA r1) {
            this();
        }

        private Builder() {
            this.mConsumeReason = "NONE";
            this.mClickClassification = "UNKNOWN";
            this.mStatus = "UNKNOWN";
            this.mMatchedBy = ClickViewTreeConstants.MATCHED_BY_UNKNOWN;
        }

        public Builder setEvent(ClickEventInfo event) {
            this.mEvent = event;
            return this;
        }

        public Builder setAssistStructure(AssistStructure assistStructure) {
            this.mAssistStructure = assistStructure;
            return this;
        }

        public Builder setConsumeReason(String consumeReason) {
            this.mConsumeReason = consumeReason;
            return this;
        }

        public Builder setClickClassification(String clickClassification) {
            this.mClickClassification = clickClassification;
            return this;
        }

        public Builder setStatus(String status) {
            this.mStatus = status;
            return this;
        }

        public Builder setMatchedBy(String matchedBy) {
            this.mMatchedBy = matchedBy;
            return this;
        }

        public ClickViewTreeRecord build() {
            return new ClickViewTreeRecord(this, null);
        }
    }

    /* synthetic */ ClickViewTreeRecord(Builder r1, ClickViewTreeRecordIA r2) {
        this(r1);
    }

    private ClickViewTreeRecord(Builder builder) {
        this.event = Builder.m35$$Nest$fgetmEvent(builder);
        this.assistStructure = Builder.m32$$Nest$fgetmAssistStructure(builder);
        this.consumeReason = fallback(Builder.m34$$Nest$fgetmConsumeReason(builder), "NONE");
        this.clickClassification = fallback(Builder.m33$$Nest$fgetmClickClassification(builder), "UNKNOWN");
        this.status = fallback(Builder.m37$$Nest$fgetmStatus(builder), "UNKNOWN");
        this.matchedBy = fallback(Builder.m36$$Nest$fgetmMatchedBy(builder), ClickViewTreeConstants.MATCHED_BY_UNKNOWN);
    }

    public static Builder builder() {
        return new Builder(null);
    }

    public JSONObject toJsonObject() throws JSONException {
        JSONObject object = new JSONObject();
        if (this.event != null) goto L5;
        JSONObject r1 = null;
    L6:
        putNullable(object, ClickViewTreeConstants.FIELD_EVENT, r1);
        object.put(ClickViewTreeConstants.FIELD_CONSUME_REASON, this.consumeReason);
        object.put(ClickViewTreeConstants.FIELD_CLICK_CLASSIFICATION, this.clickClassification);
        object.put(ClickViewTreeConstants.FIELD_STATUS, this.status);
        object.put(ClickViewTreeConstants.FIELD_MATCHED_BY, this.matchedBy);
        return object;
    L5:
        r1 = this.event.toJsonObject();
        goto L6
    }

    public String toJsonString() throws JSONException {
        return toJsonObject().toString();
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putString(ClickViewTreeConstants.KEY_CLICK_CLASSIFICATION, this.clickClassification);
        return bundle;
    }

    public String toString() {
        return toJsonString();
    L6:
        return "ClickViewTreeRecord{status=" + this.status + ", event=" + this.event + "}";
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

    private static String fallback(String value, String fallback) {
        if (value != null) goto L5;
        return fallback;
    L5:
        return value;
    }
}
