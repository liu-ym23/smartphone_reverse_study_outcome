package androidx.work.impl;

import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecKt;
import com.bytedance.apm.constant.SlardarConfigConsts;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: StartStopToken.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0006J\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\u0006J\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\f\u001a\u00020\rJ\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0006J\u000e\u0010\u0011\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Landroidx/work/impl/StartStopTokens;", "", "()V", "lock", "runs", "", "Landroidx/work/impl/model/WorkGenerationalId;", "Landroidx/work/impl/StartStopToken;", "contains", "", SlardarConfigConsts.CONFIG_ID, "remove", "spec", "Landroidx/work/impl/model/WorkSpec;", "", "workSpecId", "", "tokenFor", "work-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class StartStopTokens {
    private final Object lock;
    private final Map<WorkGenerationalId, StartStopToken> runs;

    public StartStopTokens() {
        this.lock = new Object();
        this.runs = new LinkedHashMap();
    }

    public final StartStopToken tokenFor(WorkGenerationalId r3) {
        Intrinsics.checkNotNullParameter(r3, SlardarConfigConsts.CONFIG_ID);
        Object r0 = this.lock;
        monitor-enter(r0);
        Map<WorkGenerationalId, StartStopToken> r2 = this.runs;     // Catch: Throwable -> L10
        StartStopToken r1 = r2.get(r3);     // Catch: Throwable -> L10
        if (r1 != null) goto L7;
        r1 = new StartStopToken(r3);     // Catch: Throwable -> L10
        r2.put(r3, r1);     // Catch: Throwable -> L10
    L7:
        StartStopToken r4 = r1;     // Catch: Throwable -> L10
        monitor-exit(r0);
        return r4;
    L10:
        th = move-exception;
        throw th;
    }

    public final StartStopToken remove(WorkGenerationalId r2) {
        Intrinsics.checkNotNullParameter(r2, SlardarConfigConsts.CONFIG_ID);
        Object r0 = this.lock;
        monitor-enter(r0);
        StartStopToken r1 = this.runs.remove(r2);     // Catch: Throwable -> L7
        monitor-exit(r0);
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public final List<StartStopToken> remove(String r6) {
        Intrinsics.checkNotNullParameter(r6, "workSpecId");
        Object r0 = this.lock;
        monitor-enter(r0);
        Map<WorkGenerationalId, StartStopToken> r1 = this.runs;     // Catch: Throwable -> L17
        LinkedHashMap r2 = new LinkedHashMap();     // Catch: Throwable -> L17
        Iterator<Map.Entry<WorkGenerationalId, StartStopToken>> r3 = r1.entrySet().iterator();     // Catch: Throwable -> L17
    L6:
        if (r3.hasNext() == false) goto L10;
        Map.Entry<WorkGenerationalId, StartStopToken> r4 = r3.next();     // Catch: Throwable -> L17
        if (Intrinsics.areEqual(r4.getKey().getWorkSpecId(), r6) == false) goto L6;
        r2.put(r4.getKey(), r4.getValue());     // Catch: Throwable -> L17
        goto L6
    L10:
        LinkedHashMap r5 = r2;     // Catch: Throwable -> L17
        Iterator r7 = r5.keySet().iterator();     // Catch: Throwable -> L17
    L12:
        if (r7.hasNext() == false) goto L14;
        WorkGenerationalId r8 = (WorkGenerationalId) r7.next();     // Catch: Throwable -> L17
        this.runs.remove(r8);     // Catch: Throwable -> L17
        goto L12
    L14:
        List<StartStopToken> r9 = CollectionsKt.toList(r5.values());     // Catch: Throwable -> L17
        monitor-exit(r0);
        return r9;
    L17:
        th = move-exception;
        throw th;
    }

    public final boolean contains(WorkGenerationalId r2) {
        Intrinsics.checkNotNullParameter(r2, SlardarConfigConsts.CONFIG_ID);
        Object r0 = this.lock;
        monitor-enter(r0);
        boolean r1 = this.runs.containsKey(r2);     // Catch: Throwable -> L7
        monitor-exit(r0);
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    public final StartStopToken tokenFor(WorkSpec r2) {
        Intrinsics.checkNotNullParameter(r2, "spec");
        return tokenFor(WorkSpecKt.generationalId(r2));
    }

    public final StartStopToken remove(WorkSpec r2) {
        Intrinsics.checkNotNullParameter(r2, "spec");
        return remove(WorkSpecKt.generationalId(r2));
    }
}
