package coil.util;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: coil.util.-Logs, reason: invalid class name */
/* JADX INFO: compiled from: Logs.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u001a+\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\bH\u0080\b\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nH\u0000¨\u0006\u000b"}, d2 = {"log", "", "Lcoil/util/Logger;", "tag", "", "priority", "", "lazyMessage", "Lkotlin/Function0;", "throwable", "", "coil-base_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class Logs {
    public static final void log(Logger r1, String r2, int r3, Function0<String> r4) {
        if (r1.getLevel() > r3) goto L6;
        r1.log(r2, r3, r4.invoke(), null);
        return;
    }

    public static final void log(Logger r2, String r3, Throwable r4) {
        if (r2.getLevel() > 6) goto L6;
        r2.log(r3, 6, null, r4);
        return;
    }
}
