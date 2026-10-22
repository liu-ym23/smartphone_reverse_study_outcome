package com.obric.oui;

import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.media.SoundPool;
import com.obric.oui.common.style.OUISoundEffectHelper;
import com.obric.oui.utils.log.L;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class OUISdk implements ComponentCallbacks2 {
    public static boolean b;
    public static final OUISdk c = null;

    static {
        c = new OUISdk();
    }

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration r1) {
        Intrinsics.f(r1, "newConfig");
    }

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
        SoundPool r1 = OUISoundEffectHelper.f201a;
        L.a("OUISoundEffectHelper", "release");
        SoundPool r2 = OUISoundEffectHelper.f201a;
        if (r2 == null) goto L5;
        r2.release();
    L5:
        OUISoundEffectHelper.f201a = null;
        OUISoundEffectHelper.b.clear();
        OUISoundEffectHelper.c.clear();
    }

    @Override // android.content.ComponentCallbacks2
    public final void onTrimMemory(int r1) {
        SoundPool r0 = OUISoundEffectHelper.f201a;
        L.a("OUISoundEffectHelper", "release");
        SoundPool r2 = OUISoundEffectHelper.f201a;
        if (r2 == null) goto L5;
        r2.release();
    L5:
        OUISoundEffectHelper.f201a = null;
        OUISoundEffectHelper.b.clear();
        OUISoundEffectHelper.c.clear();
    }
}
