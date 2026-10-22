package com.bytedance.blockframework.framework.monitor;

import com.bytedance.blockframework.framework.config.BlockInit;
import com.bytedance.blockframework.framework.join.IBlockScene;
import com.obric.olog.Constants;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Vector;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BlockMonitor.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ2\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\nR6\u0010\u0003\u001a*\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0004j\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006`\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/bytedance/blockframework/framework/monitor/BlockMonitor;", "", "()V", "recordMap", "Ljava/util/HashMap;", "", "Ljava/util/Vector;", "Lcom/bytedance/blockframework/framework/monitor/JobRecord;", "Lkotlin/collections/HashMap;", "doctor", "", "scene", "Lcom/bytedance/blockframework/framework/join/IBlockScene;", "record", "key", "type", "message", "cost", "", Constants.REPORT_FIELD, "blockframework_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class BlockMonitor {
    public static final BlockMonitor INSTANCE = null;
    private static final HashMap<String, Vector<JobRecord>> recordMap = null;

    private BlockMonitor() {
    }

    static {
        INSTANCE = new BlockMonitor();
        recordMap = new HashMap();
    }

    public static /* synthetic */ void record$default(BlockMonitor r7, String r8, String r9, String r10, String r11, long r12, int r14, Object r15) {
        if ((r14 & 8) == 0) goto L5;
        r11 = "";
    L5:
        String r4 = r11;
        if ((r14 & 16) == 0) goto L8;
        r12 = 0;
    L8:
        r7.record(r8, r9, r10, r4, r12);
    }

    public final void record(String r3, String r4, String r5, String r6, long r7) {
        Intrinsics.checkNotNullParameter(r3, "scene");
        Intrinsics.checkNotNullParameter(r4, "key");
        Intrinsics.checkNotNullParameter(r5, "type");
        Intrinsics.checkNotNullParameter(r6, "message");
        if (BlockInit.INSTANCE.recordEnable() == true) goto L6;
        return;
    L6:
        if (r7 > 0) goto L8;
        BlockLoggerKt.logger(r3, r3 + " -- " + r4 + " -- " + r5 + " -- " + r6);
        return;
    L8:
        BlockLoggerKt.logger(r3, r3 + " -- " + r4 + " -- " + r5 + " -- " + r6 + " -- cost: " + r7 + "ms");
    }

    public final void doctor(IBlockScene r3) {
        Intrinsics.checkNotNullParameter(r3, "scene");
        Vector<JobRecord> r2 = recordMap.get(r3.getName());
        if (r2 == null) goto L9;
        Iterator<T> r4 = r2.iterator();
    L6:
        if (r4.hasNext() == false) goto L8;
        JobRecord r0 = (JobRecord) r4.next();
        BlockLoggerKt.logger(r0.getKey(), r0.toString());
        goto L6
    L8:
        Unit r5 = Unit.INSTANCE;
    L10:
        if (r5 != null) goto L14;
        BlockLoggerKt.logger(r3.getName(), "There no BlockTree in this scene!");
        return;
    L14:
        return;
    L9:
        r5 = null;
        goto L10
    }

    public final void report() {
        Iterator<Map.Entry<String, Vector<JobRecord>>> r12 = recordMap.entrySet().iterator();
    L4:
        if (r12.hasNext() == false) goto L36;
        Map.Entry<String, Vector<JobRecord>> r0 = r12.next();
        Iterator<T> r1 = r0.getValue().iterator();
    L7:
        if (r1.hasNext() == false) goto L35;
        JobRecord r2 = (JobRecord) r1.next();
        if (Intrinsics.areEqual(r2.getType(), BlockMonitorKt.TYPE_BLOCK_TREE_INIT) == false) goto L7;
        long r4 = 0;
        if (r2 == null) goto L13;
        long r3 = r2.getCost();
    L14:
        Iterator<T> r6 = r0.getValue().iterator();
    L16:
        if (r6.hasNext() == false) goto L33;
        JobRecord r7 = (JobRecord) r6.next();
        if (Intrinsics.areEqual(r7.getType(), BlockMonitorKt.TYPE_BLOCK_TREE_CREATE) == false) goto L16;
        if (r7 == null) goto L21;
        long r8 = r7.getCost();
    L22:
        Iterator<T> r9 = r0.getValue().iterator();
    L24:
        if (r9.hasNext() == false) goto L31;
        JobRecord r10 = (JobRecord) r9.next();
        if (Intrinsics.areEqual(r10.getType(), BlockMonitorKt.TYPE_BLOCK_TREE_BIND) == false) goto L24;
        if (r10 == null) goto L29;
        r4 = r10.getCost();
    L29:
        BlockLogger.Companion.report(r0.getKey(), MapsKt.hashMapOf(new Pair[]{TuplesKt.to("block_tree_init_cost", String.valueOf(r3)), TuplesKt.to("block_tree_create_view_cost", String.valueOf(r8)), TuplesKt.to("block_tree_bind_cost", String.valueOf(r4))}));
        goto L4
    L31:
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    L21:
        r8 = 0;
        goto L22
    L33:
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    L13:
        r3 = 0;
        goto L14
    L35:
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }
}
