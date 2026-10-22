package com.bytedance.badger.module;

import android.content.Context;
import com.bytedance.badger.BadgerCore;
import com.bytedance.badger.data.BadgerResult;
import kotlin.n0.d.o;
import kotlin.u0.k;

/* JADX INFO: loaded from: classes.dex */
public abstract class BadgerModuleBase {
    public static final a Companion = null;
    public static final int PRIORITY_HIGH = 2;
    public static final int PRIORITY_LOW = 0;
    public static final int PRIORITY_MIDDLE = 1;

    static {
        Companion = new a(null);
    }

    public BadgerModuleBase() {
    }

    protected abstract BadgerResult a(Context r1);

    public final BadgerResult execute() {
        return a(BadgerCore.Companion.a().getContext());
    L5:
        th = move-exception;
        StringBuilder r0 = new StringBuilder();
        r0.append(th.getClass().getName());
        r0.append(": ");
        String r2 = th.getMessage();
        if (r2 == null) goto L15;
        String r8 = k.w(r2, "\n", " ", false, 4, null);
        if (r8 == null) goto L15;
        String r14 = k.w(r8, "\"", "'", false, 4, null);
        if (r14 == null) goto L15;
        if (r14.length() <= 256) goto L16;
        r14 = r14.substring(0, 256);
        o.b(r14, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    L16:
        r0.append(r14);
        return new BadgerResult.Failure(-1000, r0.toString());
    L15:
        r14 = null;
        goto L16
    }

    public abstract String getName();

    public int getPriority() {
        return 1;
    }

    public int getRefreshIntervalSeconds() {
        return 0;
    }
}
