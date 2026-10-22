package com.obric.search.api.migration;

import com.bytedance.apm.constant.TraceStatsConsts;
import com.obric.search.common.log.RuntimeLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NavigableSet;
import java.util.TreeMap;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MigrationContainer.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0004H\u0002J!\u0010\r\u001a\u00020\u000b2\u0012\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u000e\"\u00020\u0004H\u0002¢\u0006\u0002\u0010\u000fJ\u0016\u0010\r\u001a\u00020\u000b2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0002J\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\bJ\u001e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\bJ6\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00040\u00192\u0006\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\bH\u0002J \u0010\u001b\u001a\u001a\u0012\u0004\u0012\u00020\b\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00040\u001c0\u001cH\u0002R&\u0010\u0006\u001a\u001a\u0012\u0004\u0012\u00020\b\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00040\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/obric/search/api/migration/MigrationContainer;", "", "migrationsList", "", "Lcom/obric/search/api/migration/AbstractMigration;", "(Ljava/util/List;)V", "migrations", "", "", "Ljava/util/TreeMap;", "addMigration", "", "migration", "addMigrations", "", "([Lcom/obric/search/api/migration/AbstractMigration;)V", "contains", "", "startVersion", "endVersion", "findMigrationPath", "start", TraceStatsConsts.STATS_KEY_END, "findUpMigrationPath", "result", "", "upgrade", "getMigrations", "", "Companion", "sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class MigrationContainer {
    public static final Companion Companion = null;
    private static final String TAG = "MigrationContainer";
    private final Map<Integer, TreeMap<Integer, AbstractMigration>> migrations;

    /* JADX INFO: compiled from: MigrationContainer.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/search/api/migration/MigrationContainer$Companion;", "", "()V", "TAG", "", "sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    public MigrationContainer(List<? extends AbstractMigration> r2) {
        Intrinsics.checkNotNullParameter(r2, "migrationsList");
        this.migrations = new LinkedHashMap();
        addMigrations(r2);
    }

    private final void addMigrations(List<? extends AbstractMigration> r2) {
        Iterator<T> r3 = r2.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        addMigration((AbstractMigration) r3.next());
        goto L4
    }

    private final void addMigration(AbstractMigration r6) {
        int r0 = r6.getStartVersion();
        int r1 = r6.getEndVersion();
        Map<Integer, TreeMap<Integer, AbstractMigration>> r5 = this.migrations;
        Integer r2 = Integer.valueOf(r0);
        TreeMap<Integer, AbstractMigration> r3 = r5.get(r2);
        if (r3 != null) goto L5;
        r3 = new TreeMap();
        r5.put(r2, r3);
    L5:
        TreeMap<Integer, AbstractMigration> r4 = r3;
        TreeMap<Integer, AbstractMigration> r7 = r4;
        if (r7.containsKey(Integer.valueOf(r1)) == false) goto L8;
        RuntimeLogger.INSTANCE.warn(TAG, "Overriding migration " + r4.get(Integer.valueOf(r1)) + " with " + r6);
    L8:
        r7.put(Integer.valueOf(r1), r6);
    }

    public final List<AbstractMigration> findMigrationPath(int r3, int r4) {
        if (r3 == r4) goto L4;
        if (r4 <= r3) goto L7;
        boolean r0 = true;
    L9:
        return findUpMigrationPath(new ArrayList(), r0, r3, r4);
    L7:
        r0 = false;
        goto L9
    L4:
        return CollectionsKt.emptyList();
    }

    private final List<AbstractMigration> findUpMigrationPath(List<AbstractMigration> r9, boolean r10, int r11, int r12) {
    L2:
        boolean r0 = true;
        if (r10 == false) goto L6;
        if (r11 < r12) goto L7;
    L8:
        boolean r2 = false;
    L9:
        if (r2 == false) goto L35;
        TreeMap<Integer, AbstractMigration> r3 = this.migrations.get(Integer.valueOf(r11));
        if (r3 == null) goto L12;
        if (r10 == false) goto L15;
        NavigableSet<Integer> r4 = r3.descendingKeySet();
    L16:
        Iterator<Integer> r5 = r4.iterator();
    L18:
        if (r5.hasNext() == false) goto L32;
        Integer r6 = r5.next();
        if (r10 == false) goto L25;
        int r7 = r11 + 1;
        Intrinsics.checkNotNullExpressionValue(r6, "targetVersion");
        int r8 = r6.intValue();
        if (r7 > r8) goto L29;
        if (r8 > r12) goto L29;
    L28:
        boolean r13 = true;
    L30:
        if (r13 == false) goto L18;
        AbstractMigration r14 = r3.get(r6);
        Intrinsics.checkNotNull(r14);
        r9.add(r14);
        r11 = r6.intValue();
    L33:
        if (r0 == true) goto L2;
        return null;
    L29:
        r13 = false;
        goto L30
    L25:
        Intrinsics.checkNotNullExpressionValue(r6, "targetVersion");
        int r15 = r6.intValue();
        if (r12 > r15) goto L29;
        if (r15 >= r11) goto L29;
    L32:
        r0 = false;
        goto L33
    L15:
        r4 = r3.keySet();
        goto L16
    L12:
        return null;
    L35:
        return r9;
    L7:
        r2 = true;
        goto L9
    L6:
        if (r11 <= r12) goto L8;
        goto L7
    }

    private final Map<Integer, Map<Integer, AbstractMigration>> getMigrations() {
        return this.migrations;
    }

    public final boolean contains(int r2, int r3) {
        Map<Integer, Map<Integer, AbstractMigration>> r1 = getMigrations();
        if (r1.containsKey(Integer.valueOf(r2)) == false) goto L9;
        Map<Integer, AbstractMigration> r4 = r1.get(Integer.valueOf(r2));
        if (r4 != null) goto L8;
        r4 = MapsKt.emptyMap();
    L8:
        return r4.containsKey(Integer.valueOf(r3));
    L9:
        return false;
    }

    private final void addMigrations(AbstractMigration... r4) {
        int r0 = r4.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        addMigration(r4[r1]);
        r1 = r1 + 1;
        goto L3
    }
}
