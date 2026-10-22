package com.obric.oui.slider;

import android.content.Context;
import android.view.View;
import com.obric.oui.haptic.VibratorSmt;
import com.obric.oui.utils.log.L;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class SeekBarVibrateHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f284a;

    @Metadata
    public static final class Companion {
    }

    public final void a(Context r3, int r4, String r5, boolean r6, View r7) {
        if (this.f284a >= 2) goto L16;
        L.a("SeekBarVibrateHelper", "vibrateIfNeeded: " + r5);
        if (r6 == false) goto L7;
        VibratorSmt.a(r3, r4);
    L12:
        this.f284a++;
        return;
    L7:
        if (r7 == null) goto L12;
        r7.performHapticFeedback(r4);     // Catch: Exception -> L10
    L10:
        e = move-exception;
        L.b("VibratorSmt", "performHapticFeedbackAOSP error: " + e);
        goto L12
    }
}
