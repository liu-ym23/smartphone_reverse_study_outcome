package com.obric.oui.texteffects;

import android.util.Log;
import com.android.settings.search.IndexDatabaseHelper;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TextEffectDebugLog.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00042\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u0015H\u0086\bø\u0001\u0000J\"\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00042\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u0015H\u0086\bø\u0001\u0000R\u0016\u0010\u0003\u001a\u00020\u00048\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b\u0005\u0010\u0002R$\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\b\u0010\u0002\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR$\u0010\r\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u000e\u0010\u0002\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\f\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0017"}, d2 = {"Lcom/obric/oui/texteffects/TextEffectDebugLog;", "", "()V", "TagPrefix", "", "getTagPrefix$annotations", IndexDatabaseHelper.IndexColumns.ENABLED, "", "getEnabled$annotations", "getEnabled", "()Z", "setEnabled", "(Z)V", "frameEnabled", "getFrameEnabled$annotations", "getFrameEnabled", "setFrameEnabled", "d", "", "tag", "message", "Lkotlin/Function0;", "frame", "OUITextEffects_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TextEffectDebugLog {
    public static final TextEffectDebugLog INSTANCE = null;
    public static final String TagPrefix = "OUITextEffects";
    private static boolean enabled;
    private static boolean frameEnabled;

    static {
        INSTANCE = new TextEffectDebugLog();
    }

    @JvmStatic
    public static /* synthetic */ void getEnabled$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getFrameEnabled$annotations() {
    }

    public static /* synthetic */ void getTagPrefix$annotations() {
    }

    private TextEffectDebugLog() {
    }

    public static final boolean getEnabled() {
        return enabled;
    }

    public static final void setEnabled(boolean r0) {
        enabled = r0;
    }

    public static final boolean getFrameEnabled() {
        return frameEnabled;
    }

    public static final void setFrameEnabled(boolean r0) {
        frameEnabled = r0;
    }

    public final void d(String r1, Function0<String> r2) {
        Intrinsics.checkNotNullParameter(r1, "tag");
        Intrinsics.checkNotNullParameter(r2, "message");
        if (getEnabled() == false) goto L6;
        Log.d(Intrinsics.stringPlus("OUITextEffects/", r1), r2.invoke());
        return;
    }

    public final void frame(String r1, Function0<String> r2) {
        Intrinsics.checkNotNullParameter(r1, "tag");
        Intrinsics.checkNotNullParameter(r2, "message");
        if (getEnabled() == true) goto L5;
        return;
    L5:
        if (getFrameEnabled() == false) goto L9;
        Log.d(Intrinsics.stringPlus("OUITextEffects/", r1), r2.invoke());
        return;
    }
}
