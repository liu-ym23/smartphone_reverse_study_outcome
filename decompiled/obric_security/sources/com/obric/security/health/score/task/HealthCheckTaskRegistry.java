package com.obric.security.health.score.task;

import android.content.Context;
import com.obric.security.health.score.HealthScoreLog;
import com.obric.security.health.score.plan.HealthModulePlanItem;
import com.obric.security.health.score.plan.HealthPlan;
import com.obric.security.health.score.plan.HealthPlanCompiler;
import com.obric.security.health.score.plan.HealthTaskPlanItem;
import com.obric.security.health.score.presentation.HealthTaskPresentationProvider;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: HealthCheckTaskRegistry.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB+\b\u0002\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cJ\u000e\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u000fR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00060\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006 "}, d2 = {"Lcom/obric/security/health/score/task/HealthCheckTaskRegistry;", "", "modules", "", "Lcom/obric/security/health/score/plan/HealthModulePlanItem;", "entries", "Lcom/obric/security/health/score/task/HealthTaskEntry;", "presentationProvider", "Lcom/obric/security/health/score/presentation/HealthTaskPresentationProvider;", "(Ljava/util/List;Ljava/util/List;Lcom/obric/security/health/score/presentation/HealthTaskPresentationProvider;)V", "created", "", "executableEntries", "executableEntryById", "", "", "presentations", "Lcom/obric/security/health/score/task/HealthTaskPresentations;", "getPresentations", "()Lcom/obric/security/health/score/task/HealthTaskPresentations;", "onCreate", "", "context", "Landroid/content/Context;", "onDestroy", "scoreFor", "", "task", "Lcom/obric/security/health/score/task/HealthCheckTask;", "taskFor", "itemId", "Companion", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class HealthCheckTaskRegistry {
    public static final Companion Companion = null;
    private static final String SOURCE = "HealthCheckTaskRegistry";
    private boolean created;
    private final List<HealthTaskEntry> entries;
    private final List<HealthTaskEntry> executableEntries;
    private final Map<String, HealthTaskEntry> executableEntryById;
    private final List<HealthModulePlanItem> modules;
    private final HealthTaskPresentations presentations;

    /* JADX INFO: compiled from: HealthCheckTaskRegistry.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/security/health/score/task/HealthCheckTaskRegistry$Companion;", "", "()V", "SOURCE", "", "create", "Lcom/obric/security/health/score/task/HealthCheckTaskRegistry;", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public final HealthCheckTaskRegistry create() {
            HealthPlan r10 = HealthPlanCompiler.INSTANCE.compile();
            HealthTaskPresentationProvider r0 = new HealthTaskPresentationProvider();
            List<HealthTaskPlanItem> r1 = r10.getTasks();
            ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
            Iterator<T> r3 = r1.iterator();
        L4:
            if (r3.hasNext() == false) goto L6;
            HealthTaskPlanItem r4 = (HealthTaskPlanItem) r3.next();
            r2.add(new HealthTaskEntry(r4, r0.itemPresentationOf(r4)));
            goto L4
        L6:
            ArrayList r5 = r2;
            HealthScoreLog r6 = HealthScoreLog.INSTANCE;
            StringBuilder r7 = new StringBuilder("create modules=");
            List<HealthModulePlanItem> r8 = r10.getModules();
            ArrayList r9 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10));
            Iterator<T> r11 = r8.iterator();
        L8:
            if (r11.hasNext() == false) goto L10;
            r9.add(((HealthModulePlanItem) r11.next()).getId());
            goto L8
        L10:
            StringBuilder r12 = r7.append(r9).append(" tasks=");
            ArrayList r13 = r5;
            ArrayList r14 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r13, 10));
            Iterator r15 = r13.iterator();
        L12:
            if (r15.hasNext() == false) goto L14;
            HealthTaskEntry r16 = (HealthTaskEntry) r15.next();
            r14.add(r16.getId() + ':' + r16.getModuleId() + ':' + r16.getScore() + ":visible=" + r16.getVisible() + ":executable=" + r16.getExecutable() + ":grantedHidden=" + r16.getGrantedHidden());
            goto L12
        L14:
            r6.i(HealthCheckTaskRegistry.SOURCE, r12.append(r14).toString());
            return new HealthCheckTaskRegistry(r10.getModules(), r5, r0, null);
        }
    }

    static {
        Companion = new Companion(null);
    }

    private HealthCheckTaskRegistry(List<HealthModulePlanItem> r3, List<HealthTaskEntry> r4, HealthTaskPresentationProvider r5) {
        this.modules = r3;
        this.entries = r4;
        ArrayList r6 = new ArrayList();
        Iterator<T> r7 = r4.iterator();
    L4:
        if (r7.hasNext() == false) goto L8;
        Object r0 = r7.next();
        if (((HealthTaskEntry) r0).getExecutable() == false) goto L4;
        r6.add(r0);
        goto L4
    L8:
        ArrayList r8 = r6;
        this.executableEntries = r8;
        ArrayList r9 = r8;
        LinkedHashMap r1 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r9, 10)), 16));
        Iterator r10 = r9.iterator();
    L10:
        if (r10.hasNext() == false) goto L12;
        Object r11 = r10.next();
        r1.put(((HealthTaskEntry) r11).getId(), r11);
        goto L10
    L12:
        this.executableEntryById = r1;
        this.presentations = HealthCheckTaskRegistryKt.access$createHealthTaskPresentations(this.modules, this.entries, r5);
    }

    public /* synthetic */ HealthCheckTaskRegistry(List r1, List r2, HealthTaskPresentationProvider r3, DefaultConstructorMarker r4) {
        this(r1, r2, r3);
    }

    public final HealthTaskPresentations getPresentations() {
        return this.presentations;
    }

    public final HealthCheckTask taskFor(String r2) {
        Intrinsics.checkNotNullParameter(r2, "itemId");
        HealthTaskEntry r1 = this.executableEntryById.get(r2);
        if (r1 == null) goto L5;
        HealthCheckTask r3 = r1.getTask();
    L6:
        if (r3 == null) goto L9;
        return r3;
    L9:
        throw new IllegalArgumentException(("Executable HealthCheckTask not found, itemId=" + r2).toString());
    L5:
        r3 = null;
        goto L6
    }

    public final int scoreFor(HealthCheckTask r2) {
        Intrinsics.checkNotNullParameter(r2, "task");
        HealthTaskEntry r1 = this.executableEntryById.get(r2.getId());
        if (r1 == null) goto L7;
        return r1.getScore();
    L7:
        throw new IllegalArgumentException(("Executable HealthTaskEntry not found, taskId=" + r2.getId()).toString());
    }

    public final void onCreate(Context r7) {
        Intrinsics.checkNotNullParameter(r7, "context");
        if (this.created == false) goto L6;
        HealthScoreLog.INSTANCE.d(SOURCE, "onCreate ignored created=true");
        return;
    L6:
        this.created = true;
        Context r8 = r7.getApplicationContext();
        HealthScoreLog r0 = HealthScoreLog.INSTANCE;
        StringBuilder r2 = new StringBuilder("onCreate executableCount=").append(this.executableEntries.size()).append(" executableIds=");
        List<HealthTaskEntry> r3 = this.executableEntries;
        ArrayList r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10));
        Iterator<T> r5 = r3.iterator();
    L8:
        if (r5.hasNext() == false) goto L10;
        r4.add(((HealthTaskEntry) r5.next()).getId());
        goto L8
    L10:
        r0.i(SOURCE, r2.append(r4).toString());
        Iterator<T> r6 = this.executableEntries.iterator();
    L12:
        if (r6.hasNext() == false) goto L14;
        HealthCheckTask r1 = ((HealthTaskEntry) r6.next()).getTask();
        Intrinsics.checkNotNullExpressionValue(r8, "appContext");
        r1.onCreate(r8);
        goto L12
    }

    public final void onDestroy(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        if (this.created == true) goto L6;
        HealthScoreLog.INSTANCE.d(SOURCE, "onDestroy ignored created=false");
        return;
    L6:
        this.created = false;
        Context r6 = r5.getApplicationContext();
        HealthScoreLog.INSTANCE.i(SOURCE, "onDestroy executableCount=" + this.executableEntries.size());
        Iterator<T> r4 = this.executableEntries.iterator();
    L8:
        if (r4.hasNext() == false) goto L10;
        HealthCheckTask r0 = ((HealthTaskEntry) r4.next()).getTask();
        Intrinsics.checkNotNullExpressionValue(r6, "appContext");
        r0.onDestroy(r6);
        goto L8
    }
}
