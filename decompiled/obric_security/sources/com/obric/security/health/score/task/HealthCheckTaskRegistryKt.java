package com.obric.security.health.score.task;

import com.obric.security.health.model.HealthCheckItemPresentation;
import com.obric.security.health.model.HealthModulePresentation;
import com.obric.security.health.score.plan.HealthModulePlanItem;
import com.obric.security.health.score.presentation.HealthTaskPresentationProvider;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: HealthCheckTaskRegistry.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a,\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0002¨\u0006\t"}, d2 = {"createHealthTaskPresentations", "Lcom/obric/security/health/score/task/HealthTaskPresentations;", "modules", "", "Lcom/obric/security/health/score/plan/HealthModulePlanItem;", "entries", "Lcom/obric/security/health/score/task/HealthTaskEntry;", "presentationProvider", "Lcom/obric/security/health/score/presentation/HealthTaskPresentationProvider;", "app_neridaCnRelease"}, k = 2, mv = {1, 4, 3})
public final class HealthCheckTaskRegistryKt {
    public static final /* synthetic */ HealthTaskPresentations access$createHealthTaskPresentations(List r0, List r1, HealthTaskPresentationProvider r2) {
        return createHealthTaskPresentations(r0, r1, r2);
    }

    private static final HealthTaskPresentations createHealthTaskPresentations(List<HealthModulePlanItem> r11, List<HealthTaskEntry> r12, HealthTaskPresentationProvider r13) {
        List<HealthTaskEntry> r14 = r12;
        ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r14, 10));
        Iterator<T> r2 = r14.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        r0.add(((HealthTaskEntry) r2.next()).getPresentation());
        goto L4
    L6:
        ArrayList r1 = r0;
        ArrayList r3 = new ArrayList();
        Iterator<T> r4 = r14.iterator();
    L8:
        if (r4.hasNext() == false) goto L12;
        Object r5 = r4.next();
        if (((HealthTaskEntry) r5).getVisible() == false) goto L8;
        r3.add(r5);
        goto L8
    L12:
        ArrayList r6 = r3;
        ArrayList r7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10));
        Iterator r8 = r6.iterator();
    L14:
        if (r8.hasNext() == false) goto L16;
        r7.add(((HealthTaskEntry) r8.next()).getPresentation());
        goto L14
    L16:
        ArrayList r9 = r7;
        List<HealthModulePresentation> r10 = r13.modulePresentations(r11, r1);
        ArrayList r15 = r1;
        LinkedHashMap r16 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r15, 10)), 16));
        Iterator r17 = r15.iterator();
    L18:
        if (r17.hasNext() == false) goto L20;
        Object r18 = r17.next();
        r16.put(((HealthCheckItemPresentation) r18).getId(), r18);
        goto L18
    L20:
        List<HealthModulePresentation> r19 = r13.modulePresentations(r11, r9);
        ArrayList r110 = new ArrayList();
        Iterator<T> r111 = r14.iterator();
    L22:
        if (r111.hasNext() == false) goto L26;
        Object r20 = r111.next();
        if (((HealthTaskEntry) r20).getExecutable() == false) goto L22;
        r110.add(r20);
        goto L22
    L26:
        ArrayList r112 = r110;
        ArrayList r113 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r112, 10));
        Iterator r114 = r112.iterator();
    L28:
        if (r114.hasNext() == false) goto L30;
        r113.add(((HealthTaskEntry) r114.next()).getPresentation());
        goto L28
    L30:
        ArrayList r21 = r113;
        ArrayList r22 = r9;
        ArrayList r115 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r22, 10));
        Iterator r116 = r22.iterator();
    L32:
        if (r116.hasNext() == false) goto L34;
        r115.add(((HealthCheckItemPresentation) r116.next()).getId());
        goto L32
    L34:
        Set r23 = CollectionsKt.toSet(r115);
        ArrayList r117 = new ArrayList();
        Iterator<T> r118 = r14.iterator();
    L36:
        if (r118.hasNext() == false) goto L40;
        Object r119 = r118.next();
        if (((HealthTaskEntry) r119).getGrantedHidden() == false) goto L36;
        r117.add(r119);
        goto L36
    L40:
        ArrayList r120 = r117;
        ArrayList r121 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r120, 10));
        Iterator r122 = r120.iterator();
    L42:
        if (r122.hasNext() == false) goto L45;
        r121.add(((HealthTaskEntry) r122.next()).getPresentation());
        goto L42
    L45:
        return new HealthTaskPresentations(r10, r16, r19, r21, r23, r121);
    }
}
