package com.obric.capabilitykit;

import android.app.Application;
import android.content.Context;
import android.os.Process;
import com.obric.capabilitykit.logger.Logger;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\bJ\n\u0010\t\u001a\u0004\u0018\u00010\u0004H\u0002J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/obric/capabilitykit/ProcessUtils;", "", "()V", "TAG", "", "sCurProcessName", "getCurProcessName", "context", "Landroid/content/Context;", "getCurProcessNameFromProc", "isMainProcess", "", "capabilitykit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class h {
    public static final h a = null;
    public static final String b = "ProcessUtils";
    private static volatile String c;

    static {
        a = new h();
    }

    private h() {
    }

    private final String a() {
        BufferedReader r1 = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));     // Catch: Throwable -> L13
        Ref.IntRef r6 = new Ref.IntRef();     // Catch: Throwable -> L18
        StringBuilder r2 = new StringBuilder();     // Catch: Throwable -> L18
    L5:
        int r3 = r1.read();     // Catch: Throwable -> L18
        r6.element = r3;     // Catch: Throwable -> L18
        if (r3 <= 0) goto L10;
        r2.append((char) r3);     // Catch: Throwable -> L18
        goto L5
    L10:
        Logger.INSTANCE.d(b, "get processName = " + r2);     // Catch: Throwable -> L18
        String r7 = r2.toString();     // Catch: Throwable -> L18
        r1.close();     // Catch: Exception -> L17
    L12:
        return r7;
    L14:
        if (r1 != null) goto L24;
    L16:
        return null;
    L24:
        r1.close();     // Catch: Exception -> L19
    L13:
        r1 = null;
        goto L14
    }

    public final String a(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        String r1 = c;
        if (r1 != null) goto L5;
    L8:
        boolean r3 = true;
    L9:
        if (r3 == true) goto L11;
        return r1;
    L11:
        c = Application.getProcessName();
        Logger.INSTANCE.d(b, "processName = " + c);
        return c;
    L5:
        if (r1.length() == 0) goto L8;
        r3 = false;
        goto L9
    }

    public final boolean b(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        String r4 = a(r5);
        if (r4 != null) goto L5;
    L7:
        if (r4 != null) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(r4, r5.getPackageName()) == false) goto L13;
        return true;
    L13:
        return false;
    L5:
        if (StringsKt.contains$default(r4, ":", false, 2, null) == false) goto L7;
        return false;
    }
}
