package androidx.work.impl.utils;

import android.content.Context;
import androidx.work.Configuration;
import androidx.work.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ProcessUtils.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0003\u001a\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"TAG", "", "getProcessName", "context", "Landroid/content/Context;", "isDefaultProcess", "", "configuration", "Landroidx/work/Configuration;", "work-runtime_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class ProcessUtils {
    private static final String TAG = null;

    static {
        String r0 = Logger.tagWithPrefix("ProcessUtils");
        Intrinsics.checkNotNullExpressionValue(r0, "tagWithPrefix(\"ProcessUtils\")");
        TAG = r0;
    }

    public static final boolean isDefaultProcess(Context r2, Configuration r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "configuration");
        String r0 = getProcessName(r2);
        String r1 = r3.getDefaultProcessName();
        if (r1 != null) goto L5;
    L8:
        boolean r4 = true;
    L9:
        if (r4 == true) goto L12;
        return Intrinsics.areEqual(r0, r3.getDefaultProcessName());
    L12:
        return Intrinsics.areEqual(r0, r2.getApplicationInfo().processName);
    L5:
        if (r1.length() == 0) goto L8;
        r4 = false;
        goto L9
    }

    private static final String getProcessName(Context r0) {
        return Api28Impl.INSTANCE.getProcessName();
    }
}
