package com.bytedance.bdinstall.loader;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseLoader {
    private static final String UTF_8 = "UTF-8";
    boolean mOptional;
    boolean mReady;
    boolean mShouldUpdate;
    boolean syncFromSub;

    protected abstract boolean doLoad(JSONObject r1) throws JSONException, SecurityException;

    public void remove(JSONObject r1) {
    }

    BaseLoader(boolean r1, boolean r2) {
        this.mOptional = r1;
        this.mShouldUpdate = r2;
        this.syncFromSub = false;
    }

    BaseLoader(boolean r1, boolean r2, boolean r3) {
        this.mOptional = r1;
        this.mShouldUpdate = r2;
        this.syncFromSub = r3;
    }
}
