package com.bytedance.bdinstall.z0;

import android.annotation.SuppressLint;
import android.content.Context;
import com.bytedance.bdinstall.v0;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class s extends d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Context f2939e;

    s(Context r2) {
        super(true, true);
        this.f2939e = r2;
    }

    @Override // com.bytedance.bdinstall.z0.d
    @SuppressLint({"MissingPermission"})
    protected boolean a(JSONObject r2) {
        v0.l(r2, "access", com.bytedance.common.utility.i.g(this.f2939e));
        return true;
    }
}
