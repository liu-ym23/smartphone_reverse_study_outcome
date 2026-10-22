package com.bytedance.bdinstall;

import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.bdinstall.util.Singleton;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AbsEnv implements Cloneable {
    private InstallUrl config;
    private boolean isBoe;
    private boolean isChildMode;
    private boolean isI18n;
    private final Singleton<SharedPreferences> mSharedSp;

    AbsEnv(InstallUrl r2, boolean r3, boolean r4, boolean r5) {
        this.mSharedSp = new AnonymousClass1(this);
        this.config = r2;
        this.isI18n = r3;
        this.isBoe = r4;
        this.isChildMode = r5;
    }

    public InstallUrl getConfig() {
        return this.config;
    }

    public boolean isI18n() {
        return this.isI18n;
    }

    public boolean isBoe() {
        return this.isBoe;
    }

    public boolean isChildMode() {
        return this.isChildMode;
    }

    public String toString() {
        return "AbsEnv{isChildMode=" + this.isChildMode + ", config=" + this.config + ", isI18n=" + this.isI18n + ", isBoe=" + this.isBoe + '}';
    }

    public SharedPreferences getEnvIsolateSp(Context r3) {
        return this.mSharedSp.get(new Object[]{r3});
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof AbsEnv) == false) goto L18;
        AbsEnv r6 = (AbsEnv) r5;
        if (this.config.equals(r6.config) == false) goto L17;
        if (this.isBoe != r6.isBoe) goto L17;
        if (this.isI18n != r6.isI18n) goto L17;
        if (this.isChildMode != r6.isChildMode()) goto L17;
        return true;
    L17:
        return false;
    L18:
        return false;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
