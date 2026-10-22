package com.obric.security.health.score;

import android.os.SystemClock;
import androidx.exifinterface.media.ExifInterface;
import com.obric.security.health.model.HealthCheckItemPresentation;
import com.obric.security.health.model.HealthCheckItemSnapshot;
import com.obric.security.health.model.HealthCheckResult;
import com.obric.security.health.model.HealthCheckStatus;
import com.obric.security.health.model.HealthFixCapability;
import com.obric.security.health.model.HealthModulePresentation;
import com.obric.security.health.model.HealthModuleSnapshot;
import com.obric.security.health.model.HealthScoreSnapshot;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: HealthScoreCalculator.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J8\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\f0\u000b2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u000eJ\"\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0010H\u0002J-\u0010\u0015\u001a\u00020\u0010\"\u0004\b\u0000\u0010\u0016*\b\u0012\u0004\u0012\u0002H\u00160\u00172\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u00020\u00100\u0019H\u0082\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/obric/security/health/score/HealthScoreCalculator;", "", "()V", "SOURCE", "", "calculate", "Lcom/obric/security/health/model/HealthScoreSnapshot;", "presentations", "", "Lcom/obric/security/health/model/HealthModulePresentation;", "checkResults", "", "Lcom/obric/security/health/model/HealthCheckResult;", "visibleItemIds", "", "earnedScoreOf", "", "result", "status", "Lcom/obric/security/health/model/HealthCheckStatus;", "taskScore", "sumOfCompat", ExifInterface.GPS_DIRECTION_TRUE, "", "selector", "Lkotlin/Function1;", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class HealthScoreCalculator {
    public static final HealthScoreCalculator INSTANCE = null;
    private static final String SOURCE = "HealthScoreCalculator";

    static {
        INSTANCE = new HealthScoreCalculator();
    }

    private HealthScoreCalculator() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ HealthScoreSnapshot calculate$default(HealthScoreCalculator r0, List r1, Map r2, Set r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L14;
        ArrayList r6 = new ArrayList();
        Iterator r7 = r1.iterator();
    L6:
        if (r7.hasNext() == false) goto L8;
        CollectionsKt.addAll(r6, ((HealthModulePresentation) r7.next()).getItems());
        goto L6
    L8:
        ArrayList r8 = r6;
        ArrayList r9 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10));
        Iterator r10 = r8.iterator();
    L10:
        if (r10.hasNext() == false) goto L12;
        r9.add(((HealthCheckItemPresentation) r10.next()).getId());
        goto L10
    L12:
        r3 = CollectionsKt.toSet(r9);
    L14:
        return r0.calculate(r1, r2, r3);
    }

    public final HealthScoreSnapshot calculate(List<HealthModulePresentation> r37, Map<String, HealthCheckResult> r38, Set<String> r39) {
        Map<String, HealthCheckResult> r1 = r38;
        Intrinsics.checkNotNullParameter(r37, "presentations");
        Intrinsics.checkNotNullParameter(r1, "checkResults");
        Intrinsics.checkNotNullParameter(r39, "visibleItemIds");
        long r3 = SystemClock.elapsedRealtime();
        List<HealthModulePresentation> r0 = r37;
        int r6 = 10;
        ArrayList r5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L36;
        HealthModulePresentation r7 = (HealthModulePresentation) r2.next();
        List<HealthCheckItemPresentation> r10 = r7.getItems();
        ArrayList r11 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r10, r6));
        Iterator<T> r12 = r10.iterator();
    L7:
        if (r12.hasNext() == false) goto L31;
        HealthCheckItemPresentation r13 = (HealthCheckItemPresentation) r12.next();
        HealthCheckResult r14 = r1.get(r13.getId());
        if (r14 == null) goto L12;
        HealthCheckStatus r15 = r14.getStatus();
        if (r15 == null) goto L12;
    L13:
        HealthCheckResult r16 = r1.get(r13.getId());
        int r8 = INSTANCE.earnedScoreOf(r16, r15, r13.getScore());
        HealthScoreLog r9 = HealthScoreLog.INSTANCE;
        Iterator r28 = r2;
        StringBuilder r4 = new StringBuilder("scoreItem moduleId=").append(r7.getId()).append(" itemId=").append(r13.getId()).append(" status=").append(r15).append(" taskScore=").append(r13.getScore()).append(" earnedScore=").append(r8).append(" reason=");
        Map<String, String> r17 = null;
        if (r16 == null) goto L16;
        String r18 = r16.getReason();
    L17:
        if (r18 != null) goto L19;
        r18 = "";
    L19:
        StringBuilder r19 = r4.append(r18).append(" evidence=");
        if (r16 == null) goto L22;
        Map<String, String> r110 = r16.getEvidence();
    L23:
        if (r110 != null) goto L25;
        r110 = MapsKt.emptyMap();
    L25:
        r9.d(SOURCE, r19.append(r110).toString());
        String r111 = r13.getId();
        String r112 = r13.getModuleId();
        int r113 = r13.getTitleResId();
        int r114 = r13.getCompletedTitleResId();
        int r20 = r13.getProblemTitleResId();
        int r21 = r13.getActionTextResId();
        int r22 = r13.getScore();
        HealthFixCapability r23 = r13.getFixCapability();
        boolean r25 = r39.contains(r13.getId());
        if (r16 == null) goto L28;
        r17 = r16.getEvidence();
    L28:
        if (r17 != null) goto L30;
        r17 = MapsKt.emptyMap();
    L30:
        r11.add(new HealthCheckItemSnapshot(r111, r112, r113, r114, r20, r21, r22, r23, r15, r25, r17, r8));
        r1 = r38;
        r2 = r28;
        goto L7
    L22:
        r110 = null;
        goto L23
    L16:
        r18 = null;
    L12:
        r15 = HealthCheckStatus.FAIL;
        goto L13
    L31:
        Iterator r29 = r2;
        ArrayList r35 = r11;
        Iterator r24 = r35.iterator();
        int r26 = 0;
    L33:
        if (r24.hasNext() == false) goto L35;
        r26 = r26 + ((HealthCheckItemSnapshot) r24.next()).getEarnedScore();
        goto L33
    L35:
        HealthModuleSnapshot r27 = new HealthModuleSnapshot(r7.getId(), r7.getTitleResId(), r7.getIconResId(), r7.getMaxScore(), Math.min(r7.getMaxScore(), r26), r35);
        HealthScoreLog.INSTANCE.d(SOURCE, "scoreModule moduleId=" + r7.getId() + " titleResId=" + r7.getTitleResId() + " rawEarnedScore=" + r26 + " maxScore=" + r7.getMaxScore() + " earnedScore=" + r27.getEarnedScore());
        r5.add(r27);
        r1 = r38;
        r2 = r29;
        r6 = 10;
        goto L4
    L36:
        ArrayList r30 = r5;
        ArrayList r31 = r30;
        ArrayList r32 = new ArrayList();
        Iterator r33 = r31.iterator();
    L38:
        if (r33.hasNext() == false) goto L40;
        CollectionsKt.addAll(r32, ((HealthModuleSnapshot) r33.next()).getItems());
        goto L38
    L40:
        ArrayList r34 = r32;
        ArrayList r36 = r34;
        ArrayList r40 = new ArrayList();
        Iterator r41 = r36.iterator();
    L42:
        if (r41.hasNext() == false) goto L46;
        Object r42 = r41.next();
        if (((HealthCheckItemSnapshot) r42).getVisible() == false) goto L42;
        r40.add(r42);
        goto L42
    L46:
        ArrayList r43 = r40;
        Iterator r44 = r31.iterator();
        int r45 = 0;
    L48:
        if (r44.hasNext() == false) goto L50;
        r45 = r45 + ((HealthModuleSnapshot) r44.next()).getEarnedScore();
        goto L48
    L50:
        int r46 = Math.min(100, r45);
        HealthScoreLog r47 = HealthScoreLog.INSTANCE;
        StringBuilder r115 = new StringBuilder("scoreTotal total=").append(r46).append(" baseScore=0 moduleScore=");
        Iterator r48 = r31.iterator();
        int r116 = 0;
    L52:
        if (r48.hasNext() == false) goto L54;
        r116 = r116 + ((HealthModuleSnapshot) r48.next()).getEarnedScore();
        goto L52
    L54:
        StringBuilder r49 = r115.append(r116).append(" allCompleted=");
        boolean r117 = r36 instanceof Collection;
        if (r117 == true) goto L57;
    L59:
        Iterator r118 = r36.iterator();
        int r119 = 0;
    L61:
        if (r118.hasNext() == false) goto L70;
        if (((HealthCheckItemSnapshot) r118.next()).getStatus() != HealthCheckStatus.PASS) goto L65;
        boolean r120 = true;
    L66:
        if (r120 == false) goto L61;
        r119 = r119 + 1;
        if (r119 >= 0) goto L61;
        CollectionsKt.throwCountOverflow();
        goto L61
    L65:
        r120 = false;
    L70:
        StringBuilder r50 = r49.append(r119).append(" allTodo=");
        if (r117 == true) goto L73;
    L75:
        Iterator r51 = r36.iterator();
        int r121 = 0;
    L77:
        if (r51.hasNext() == false) goto L86;
        if (((HealthCheckItemSnapshot) r51.next()).getStatus() == HealthCheckStatus.PASS) goto L81;
        boolean r122 = true;
    L82:
        if (r122 == false) goto L77;
        r121 = r121 + 1;
        if (r121 >= 0) goto L77;
        CollectionsKt.throwCountOverflow();
        goto L77
    L81:
        r122 = false;
    L86:
        StringBuilder r52 = r50.append(r121).append(" visibleCompleted=");
        ArrayList r53 = r43;
        boolean r123 = r53 instanceof Collection;
        if (r123 == true) goto L89;
    L91:
        Iterator r124 = r53.iterator();
        int r125 = 0;
    L93:
        if (r124.hasNext() == false) goto L102;
        if (((HealthCheckItemSnapshot) r124.next()).getStatus() != HealthCheckStatus.PASS) goto L97;
        boolean r126 = true;
    L98:
        if (r126 == false) goto L93;
        r125 = r125 + 1;
        if (r125 >= 0) goto L93;
        CollectionsKt.throwCountOverflow();
        goto L93
    L97:
        r126 = false;
    L102:
        StringBuilder r54 = r52.append(r125).append(" visibleTodo=");
        if (r123 == true) goto L105;
    L107:
        Iterator r55 = r53.iterator();
        int r127 = 0;
    L109:
        if (r55.hasNext() == false) goto L118;
        if (((HealthCheckItemSnapshot) r55.next()).getStatus() == HealthCheckStatus.PASS) goto L113;
        boolean r128 = true;
    L114:
        if (r128 == false) goto L109;
        r127 = r127 + 1;
        if (r127 >= 0) goto L109;
        CollectionsKt.throwCountOverflow();
        goto L109
    L113:
        r128 = false;
    L118:
        r47.i(SOURCE, r54.append(r127).append(" visibleCount=").append(r43.size()).append(" hiddenCount=").append(r34.size() - r43.size()).append(" costMs=").append(SystemClock.elapsedRealtime() - r3).toString());
        return new HealthScoreSnapshot(r46, r30, System.currentTimeMillis());
    L105:
        if (r53.isEmpty() == false) goto L107;
        r127 = 0;
        goto L118
    L89:
        if (r53.isEmpty() == false) goto L91;
        r125 = 0;
        goto L102
    L73:
        if (r36.isEmpty() == false) goto L75;
        r121 = 0;
        goto L86
    L57:
        if (r36.isEmpty() == false) goto L59;
        r119 = 0;
        goto L70
    }

    private final <T> int sumOfCompat(Iterable<? extends T> r2, Function1<? super T, Integer> r3) {
        Iterator<? extends T> r1 = r2.iterator();
        int r4 = 0;
    L4:
        if (r1.hasNext() == false) goto L6;
        r4 = r4 + r3.invoke(r1.next()).intValue();
        goto L4
    L6:
        return r4;
    }

    private final int earnedScoreOf(HealthCheckResult r2, HealthCheckStatus r3, int r4) {
        if (r2 == null) goto L12;
        Map<String, String> r5 = r2.getEvidence();
        if (r5 == null) goto L12;
        String r6 = r5.get(HealthEvidenceKeys.EARNED_SCORE);
        if (r6 == null) goto L12;
        Integer r7 = StringsKt.toIntOrNull(r6);
        if (r7 == null) goto L12;
        return RangesKt.coerceIn(r7.intValue(), 0, r4);
    L12:
        if (r3 != HealthCheckStatus.PASS) goto L15;
        return r4;
    L15:
        return 0;
    }
}
