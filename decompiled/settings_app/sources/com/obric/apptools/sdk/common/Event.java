package com.obric.apptools.sdk.common;

import android.icu.text.PluralRules;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AppMetrics.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 ,2\u00020\u0001:\u0001,B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J'\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001a\u00020*HÖ\u0001J\t\u0010+\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR'\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u000b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\bR'\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u000b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u000f\u001a\u0004\b\u0019\u0010\rR'\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00110\u000b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u000f\u001a\u0004\b\u001c\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\bR\u001a\u0010\u001f\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0013\"\u0004\b!\u0010\u0015¨\u0006-"}, d2 = {"Lcom/obric/apptools/sdk/common/Event;", "", "action", "", "scene", "appPackage", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAction", "()Ljava/lang/String;", "getAppPackage", "categoryParams", "", "getCategoryParams", "()Ljava/util/Map;", "categoryParams$delegate", "Lkotlin/Lazy;", "endTime", "", "getEndTime", "()J", "setEndTime", "(J)V", "eventName", "getEventName", "extraParams", "getExtraParams", "extraParams$delegate", "metricsParams", "getMetricsParams", "metricsParams$delegate", "getScene", "startTime", "getStartTime", "setStartTime", "component1", "component2", "component3", "copy", "equals", "", PluralRules.KEYWORD_OTHER, "hashCode", "", "toString", "Companion", "tools_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Event {
    public static final Companion Companion = null;
    public static final String METRICS_TIME_COST = "time_cost";
    private final String action;
    private final String appPackage;
    private final Lazy categoryParams$delegate;
    private volatile long endTime;
    private final String eventName;
    private final Lazy extraParams$delegate;
    private final Lazy metricsParams$delegate;
    private final String scene;
    private volatile long startTime;

    /* JADX INFO: compiled from: AppMetrics.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/obric/apptools/sdk/common/Event$Companion;", "", "()V", "METRICS_TIME_COST", "", "tools_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
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

    public static /* synthetic */ Event copy$default(Event r0, String r1, String r2, String r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.action;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.scene;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.appPackage;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final String component1() {
        return this.action;
    }

    public final String component2() {
        return this.scene;
    }

    public final String component3() {
        return this.appPackage;
    }

    public final Event copy(String r1, String r2, String r3) {
        Intrinsics.checkNotNullParameter(r1, "action");
        Intrinsics.checkNotNullParameter(r2, "scene");
        Intrinsics.checkNotNullParameter(r3, "appPackage");
        return new Event(r1, r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof Event) == true) goto L8;
        return false;
    L8:
        Event r6 = (Event) r5;
        if (Intrinsics.areEqual(this.action, r6.action) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.scene, r6.scene) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.appPackage, r6.appPackage) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((this.action.hashCode() * 31) + this.scene.hashCode()) * 31) + this.appPackage.hashCode();
    }

    public String toString() {
        return "Event(action=" + this.action + ", scene=" + this.scene + ", appPackage=" + this.appPackage + ')';
    }

    public Event(String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "action");
        Intrinsics.checkNotNullParameter(r3, "scene");
        Intrinsics.checkNotNullParameter(r4, "appPackage");
        this.action = r2;
        this.scene = r3;
        this.appPackage = r4;
        this.eventName = r4 + '_' + r3 + '_' + r2;
        this.categoryParams$delegate = LazyKt.lazy(Event$categoryParams$2.INSTANCE);
        this.metricsParams$delegate = LazyKt.lazy(Event$metricsParams$2.INSTANCE);
        this.extraParams$delegate = LazyKt.lazy(Event$extraParams$2.INSTANCE);
    }

    public final String getAction() {
        return this.action;
    }

    public final String getScene() {
        return this.scene;
    }

    public final String getAppPackage() {
        return this.appPackage;
    }

    public final String getEventName() {
        return this.eventName;
    }

    public final Map<String, Object> getCategoryParams() {
        return (Map) this.categoryParams$delegate.getValue();
    }

    public final Map<String, Long> getMetricsParams() {
        return (Map) this.metricsParams$delegate.getValue();
    }

    public final Map<String, Object> getExtraParams() {
        return (Map) this.extraParams$delegate.getValue();
    }

    public final long getStartTime() {
        return this.startTime;
    }

    public final void setStartTime(long r1) {
        this.startTime = r1;
    }

    public final long getEndTime() {
        return this.endTime;
    }

    public final void setEndTime(long r1) {
        this.endTime = r1;
    }
}
