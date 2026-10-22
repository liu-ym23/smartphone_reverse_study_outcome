package com.bytedance.common.wschannel.event;

import androidx.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class MessageAckEvent {
    private final int mChannelId;
    private JSONObject mLogInfo;
    private final int mMethodId;
    private final int mServiceId;
    private MessageState mState;
    private final String mUniqueId;

    public static final enum MessageState extends Enum<MessageState> {
        private static final /* synthetic */ MessageState[] $VALUES = null;
        public static final MessageState Default = null;
        public static final MessageState Failed = null;
        public static final MessageState Success = null;
        public static final MessageState TimeOut = null;
        final int mState;

        static {
            MessageState r0 = new MessageState("Default", 0, 0);
            Default = r0;
            MessageState r1 = new MessageState("TimeOut", 1, 1);
            TimeOut = r1;
            MessageState r2 = new MessageState("Failed", 2, 2);
            Failed = r2;
            MessageState r3 = new MessageState("Success", 3, 3);
            Success = r3;
            $VALUES = new MessageState[]{r0, r1, r2, r3};
        }

        private MessageState(String r1, int r2, int r3) {
            super(r1, r2);
            this.mState = r3;
        }

        public static MessageState valueOf(String r1) {
            return (MessageState) Enum.valueOf(MessageState.class, r1);
        }

        public static MessageState[] values() {
            return (MessageState[]) $VALUES.clone();
        }

        public int getTypeValue() {
            return this.mState;
        }

        public static MessageState valueOf(int r1) {
            if (r1 == 1) goto L15;
            if (r1 == 2) goto L13;
            if (r1 == 3) goto L11;
            return Default;
        L11:
            return Success;
        L13:
            return Failed;
        L15:
            return TimeOut;
        }
    }

    public MessageAckEvent(String r2, int r3, int r4, int r5, String r6) {
        this.mState = MessageState.Default;
        this.mUniqueId = r2;
        this.mChannelId = r3;
        this.mServiceId = r4;
        this.mMethodId = r5;
        this.mLogInfo = new JSONObject(r6);     // Catch: JSONException -> L5
        return;
    }

    public int getChannelId() {
        return this.mChannelId;
    }

    @Nullable
    public JSONObject getLogInfo() {
        return this.mLogInfo;
    }

    public int getMethodId() {
        return this.mMethodId;
    }

    public int getServiceId() {
        return this.mServiceId;
    }

    public MessageState getState() {
        return this.mState;
    }

    public String getUniqueId() {
        return this.mUniqueId;
    }

    public void setState(MessageState r1) {
        this.mState = r1;
    }

    public String toString() {
        return "UniqueId:" + this.mUniqueId + ", ChannelId:" + this.mChannelId + ", methodId:" + this.mMethodId + ", state:" + this.mState + ", logInfo:" + this.mLogInfo.toString();
    }
}
