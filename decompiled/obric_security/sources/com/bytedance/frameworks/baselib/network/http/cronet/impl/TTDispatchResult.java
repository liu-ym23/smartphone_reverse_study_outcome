package com.bytedance.frameworks.baselib.network.http.cronet.impl;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public class TTDispatchResult {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final String TAG = "TTDispatchResult";
    public final DispatchState mDispatchState;
    public final String mEpoch;
    public final String mEtag;
    public final String mFinalUrl;
    public final String mOriginalUrl;
    public final String mTTNetOriginHost;

    public static final enum DispatchState extends Enum<DispatchState> {
        private static final /* synthetic */ DispatchState[] $VALUES = null;
        public static final DispatchState CRONET_NOT_INIT = null;
        public static final DispatchState INVALID_FINAL_URL = null;
        public static final DispatchState INVALID_ORIGIN_URL = null;
        public static final DispatchState NOT_REACHED = null;
        public static final DispatchState OKHTTP_DISPATCH_FAILED = null;
        public static final DispatchState SUCCESS = null;
        public static final DispatchState TIMEOUT = null;
        public static final DispatchState WRONG_FORMAT = null;

        private DispatchState(String r1, int r2) {
            super(r1, r2);
        }

        public static DispatchState valueOf(String r1) {
            return (DispatchState) Enum.valueOf(DispatchState.class, r1);
        }

        public static DispatchState[] values() {
            return (DispatchState[]) $VALUES.clone();
        }

        static {
            DispatchState r0 = new DispatchState("SUCCESS", 0);
            SUCCESS = r0;
            DispatchState r1 = new DispatchState("INVALID_ORIGIN_URL", 1);
            INVALID_ORIGIN_URL = r1;
            DispatchState r3 = new DispatchState("CRONET_NOT_INIT", 2);
            CRONET_NOT_INIT = r3;
            DispatchState r5 = new DispatchState("TIMEOUT", 3);
            TIMEOUT = r5;
            DispatchState r7 = new DispatchState("INVALID_FINAL_URL", 4);
            INVALID_FINAL_URL = r7;
            DispatchState r9 = new DispatchState("WRONG_FORMAT", 5);
            WRONG_FORMAT = r9;
            DispatchState r11 = new DispatchState("OKHTTP_DISPATCH_FAILED", 6);
            OKHTTP_DISPATCH_FAILED = r11;
            DispatchState r13 = new DispatchState("NOT_REACHED", 7);
            NOT_REACHED = r13;
            $VALUES = new DispatchState[]{r0, r1, r3, r5, r7, r9, r11, r13};
        }
    }

    static {
    }

    public TTDispatchResult(String r1, DispatchState r2) {
        this.mOriginalUrl = r1;
        this.mFinalUrl = r1;
        this.mEpoch = "0";
        this.mEtag = "0";
        this.mDispatchState = r2;
        this.mTTNetOriginHost = "";
    }

    public TTDispatchResult(String r1, String r2, String r3, String r4, DispatchState r5, String r6) {
        this.mOriginalUrl = r1;
        this.mFinalUrl = r2;
        if (TextUtils.isEmpty(r3) == true) goto L5;
        this.mEpoch = r3;
    L7:
        if (TextUtils.isEmpty(r4) == true) goto L9;
        this.mEtag = r4;
    L11:
        if (TextUtils.isEmpty(r6) == true) goto L13;
        this.mTTNetOriginHost = r6;
    L14:
        this.mDispatchState = r5;
        return;
    L13:
        this.mTTNetOriginHost = "";
        goto L14
    L9:
        this.mEtag = "0";
        goto L11
    L5:
        this.mEpoch = "0";
        goto L7
    }

    public String getOriginalUrl() {
        return this.mOriginalUrl;
    }

    public String getFinalUrl() {
        return this.mFinalUrl;
    }

    public String getEpoch() {
        return this.mEpoch;
    }

    public String getEtag() {
        return this.mEtag;
    }

    public String getTTNetOriginHost() {
        return this.mTTNetOriginHost;
    }

    public DispatchState getDispatchState() {
        return this.mDispatchState;
    }
}
