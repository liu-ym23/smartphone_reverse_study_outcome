package ru;

import android.util.Log;
import kotlin.jvm.internal.Intrinsics;
import org.koin.core.logger.Level;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends um.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f21797c;

    public /* synthetic */ b(Level r5, int r10) {
        this.f21797c = r10;
        super(r5);
    }

    @Override // um.a
    public final void p(Level r5, String r10) {
        switch(this.f21797c) {
            case 0: goto L6;
            default: goto L4;
        };
    L4:
        Intrinsics.checkNotNullParameter(r5, "level");
        Intrinsics.checkNotNullParameter(r10, "msg");
        return;
    L6:
        Intrinsics.checkNotNullParameter(r5, "level");
        Intrinsics.checkNotNullParameter(r10, "msg");
        int r11 = a.f21796a[r5.ordinal()];
        if (r11 != 1) goto L9;
        Log.d("[Koin]", r10);
        return;
    L9:
        if (r11 != 2) goto L11;
        Log.i("[Koin]", r10);
        return;
    L11:
        if (r11 != 3) goto L13;
        Log.w("[Koin]", r10);
        return;
    L13:
        if (r11 == 4) goto L15;
        Log.e("[Koin]", r10);
        return;
    L15:
        Log.e("[Koin]", r10);
    }
}
