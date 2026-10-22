package com.obric.oui.common.util;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import androidx.annotation.AttrRes;
import androidx.annotation.DimenRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f10942a = null;

    static {
        f10942a = new a();
    }

    private a() {
    }

    @Nullable
    public final TypedValue a(@NonNull Context r2, @AttrRes int r3) {
        o.f(r2, "context");
        TypedValue r1 = new TypedValue();
        if (r2.getTheme().resolveAttribute(r3, r1, true) == true) goto L7;
        return null;
    L7:
        return r1;
    }

    @Px
    public final int b(Context r2, @AttrRes int r3, @DimenRes int r4) {
        o.f(r2, "context");
        TypedValue r1 = a(r2, r3);
        if (r1 != null) goto L5;
    L8:
        float r5 = r2.getResources().getDimension(r4);
    L10:
        return (int) r5;
    L5:
        if (r1.type != 5) goto L8;
        Resources r6 = r2.getResources();
        o.e(r6, "context.resources");
        r5 = r1.getDimension(r6.getDisplayMetrics());
        goto L10
    }
}
