package androidx.work;

import android.net.Uri;
import androidx.work.impl.utils.DurationApi26Impl;
import java.time.Duration;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Constraints.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 \u001e2\u00020\u0001:\u0003\u001d\u001e\u001fB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0000¢\u0006\u0002\u0010\u0003B[\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\u0002\u0010\u0011J\u0013\u0010\u0019\u001a\u00020\u00072\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u001a\u001a\u00020\u0007H\u0007J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\u0006\u0010\t\u001a\u00020\u0007J\u0006\u0010\u0006\u001a\u00020\u0007J\b\u0010\b\u001a\u00020\u0007H\u0007J\u0006\u0010\n\u001a\u00020\u0007R\u0016\u0010\r\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u000b\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0010\u0010\t\u001a\u00020\u00078\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00078\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\u00078\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\u00078\u0002X\u0083\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Landroidx/work/Constraints;", "", "other", "(Landroidx/work/Constraints;)V", "requiredNetworkType", "Landroidx/work/NetworkType;", "requiresCharging", "", "requiresDeviceIdle", "requiresBatteryNotLow", "requiresStorageNotLow", "contentTriggerUpdateDelayMillis", "", "contentTriggerMaxDelayMillis", "contentUriTriggers", "", "Landroidx/work/Constraints$ContentUriTrigger;", "(Landroidx/work/NetworkType;ZZZZJJLjava/util/Set;)V", "getContentTriggerMaxDelayMillis", "()J", "getContentTriggerUpdateDelayMillis", "getContentUriTriggers", "()Ljava/util/Set;", "getRequiredNetworkType", "()Landroidx/work/NetworkType;", "equals", "hasContentUriTriggers", "hashCode", "", "Builder", "Companion", "ContentUriTrigger", "work-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class Constraints {
    public static final Companion Companion = null;
    public static final Constraints NONE = null;
    private final long contentTriggerMaxDelayMillis;
    private final long contentTriggerUpdateDelayMillis;
    private final Set<ContentUriTrigger> contentUriTriggers;
    private final NetworkType requiredNetworkType;
    private final boolean requiresBatteryNotLow;
    private final boolean requiresCharging;
    private final boolean requiresDeviceIdle;
    private final boolean requiresStorageNotLow;

    /* JADX INFO: compiled from: Constraints.kt */
    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u000f\b\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0018\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\fH\u0007J\u0006\u0010\u0017\u001a\u00020\u0004J\u000e\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\nJ\u000e\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\u001b\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\fJ\u0010\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\fH\u0007J\u000e\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\fJ\u0010\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020 H\u0007J\u0018\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u00112\u0006\u0010!\u001a\u00020\"H\u0007J\u0010\u0010#\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020 H\u0007J\u0018\u0010#\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u00112\u0006\u0010!\u001a\u00020\"H\u0007R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Landroidx/work/Constraints$Builder;", "", "()V", "constraints", "Landroidx/work/Constraints;", "(Landroidx/work/Constraints;)V", "contentUriTriggers", "", "Landroidx/work/Constraints$ContentUriTrigger;", "requiredNetworkType", "Landroidx/work/NetworkType;", "requiresBatteryNotLow", "", "requiresCharging", "requiresDeviceIdle", "requiresStorageNotLow", "triggerContentMaxDelay", "", "triggerContentUpdateDelay", "addContentUriTrigger", "uri", "Landroid/net/Uri;", "triggerForDescendants", "build", "setRequiredNetworkType", "networkType", "setRequiresBatteryNotLow", "setRequiresCharging", "setRequiresDeviceIdle", "setRequiresStorageNotLow", "setTriggerContentMaxDelay", "duration", "Ljava/time/Duration;", "timeUnit", "Ljava/util/concurrent/TimeUnit;", "setTriggerContentUpdateDelay", "work-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Builder {
        private Set<ContentUriTrigger> contentUriTriggers;
        private NetworkType requiredNetworkType;
        private boolean requiresBatteryNotLow;
        private boolean requiresCharging;
        private boolean requiresDeviceIdle;
        private boolean requiresStorageNotLow;
        private long triggerContentMaxDelay;
        private long triggerContentUpdateDelay;

        public Builder() {
            this.requiredNetworkType = NetworkType.NOT_REQUIRED;
            this.triggerContentUpdateDelay = -1;
            this.triggerContentMaxDelay = -1;
            this.contentUriTriggers = new LinkedHashSet();
        }

        public Builder(Constraints r3) {
            Intrinsics.checkNotNullParameter(r3, "constraints");
            this.requiredNetworkType = NetworkType.NOT_REQUIRED;
            this.triggerContentUpdateDelay = -1;
            this.triggerContentMaxDelay = -1;
            this.contentUriTriggers = new LinkedHashSet();
            this.requiresCharging = r3.requiresCharging();
            if (r3.requiresDeviceIdle() == false) goto L5;
            boolean r0 = true;
        L6:
            this.requiresDeviceIdle = r0;
            this.requiredNetworkType = r3.getRequiredNetworkType();
            this.requiresBatteryNotLow = r3.requiresBatteryNotLow();
            this.requiresStorageNotLow = r3.requiresStorageNotLow();
            this.triggerContentUpdateDelay = r3.getContentTriggerUpdateDelayMillis();
            this.triggerContentMaxDelay = r3.getContentTriggerMaxDelayMillis();
            this.contentUriTriggers = CollectionsKt.toMutableSet(r3.getContentUriTriggers());
            return;
        L5:
            r0 = false;
            goto L6
        }

        public final Builder setRequiresCharging(boolean r1) {
            this.requiresCharging = r1;
            return this;
        }

        public final Builder setRequiresDeviceIdle(boolean r1) {
            this.requiresDeviceIdle = r1;
            return this;
        }

        public final Builder setRequiredNetworkType(NetworkType r2) {
            Intrinsics.checkNotNullParameter(r2, "networkType");
            this.requiredNetworkType = r2;
            return this;
        }

        public final Builder setRequiresBatteryNotLow(boolean r1) {
            this.requiresBatteryNotLow = r1;
            return this;
        }

        public final Builder setRequiresStorageNotLow(boolean r1) {
            this.requiresStorageNotLow = r1;
            return this;
        }

        public final Builder addContentUriTrigger(Uri r3, boolean r4) {
            Intrinsics.checkNotNullParameter(r3, "uri");
            this.contentUriTriggers.add(new ContentUriTrigger(r3, r4));
            return this;
        }

        public final Builder setTriggerContentUpdateDelay(long r2, TimeUnit r4) {
            Intrinsics.checkNotNullParameter(r4, "timeUnit");
            this.triggerContentUpdateDelay = r4.toMillis(r2);
            return this;
        }

        public final Builder setTriggerContentUpdateDelay(Duration r3) {
            Intrinsics.checkNotNullParameter(r3, "duration");
            this.triggerContentUpdateDelay = DurationApi26Impl.toMillisCompat(r3);
            return this;
        }

        public final Builder setTriggerContentMaxDelay(long r2, TimeUnit r4) {
            Intrinsics.checkNotNullParameter(r4, "timeUnit");
            this.triggerContentMaxDelay = r4.toMillis(r2);
            return this;
        }

        public final Builder setTriggerContentMaxDelay(Duration r3) {
            Intrinsics.checkNotNullParameter(r3, "duration");
            this.triggerContentMaxDelay = DurationApi26Impl.toMillisCompat(r3);
            return this;
        }

        public final Constraints build() {
            Set r11 = CollectionsKt.toSet(this.contentUriTriggers);
            long r7 = this.triggerContentUpdateDelay;
            long r9 = this.triggerContentMaxDelay;
            boolean r3 = this.requiresCharging;
            if (this.requiresDeviceIdle == false) goto L5;
            boolean r0 = true;
        L6:
            NetworkType r2 = this.requiredNetworkType;
            return new Constraints(r2, r3, r0, this.requiresBatteryNotLow, this.requiresStorageNotLow, r7, r9, r11);
        L5:
            r0 = false;
            goto L6
        }
    }

    /* JADX INFO: compiled from: Constraints.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Landroidx/work/Constraints$Companion;", "", "()V", "NONE", "Landroidx/work/Constraints;", "work-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: Constraints.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0013\u0010\n\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\f\u001a\u00020\rH\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u000e"}, d2 = {"Landroidx/work/Constraints$ContentUriTrigger;", "", "uri", "Landroid/net/Uri;", "isTriggeredForDescendants", "", "(Landroid/net/Uri;Z)V", "()Z", "getUri", "()Landroid/net/Uri;", "equals", "other", "hashCode", "", "work-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class ContentUriTrigger {
        private final boolean isTriggeredForDescendants;
        private final Uri uri;

        public ContentUriTrigger(Uri r2, boolean r3) {
            Intrinsics.checkNotNullParameter(r2, "uri");
            this.uri = r2;
            this.isTriggeredForDescendants = r3;
        }

        public final Uri getUri() {
            return this.uri;
        }

        public final boolean isTriggeredForDescendants() {
            return this.isTriggeredForDescendants;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L5;
            return true;
        L5:
            Class<?> r1 = getClass();
            if (r5 == null) goto L8;
            Class<?> r2 = r5.getClass();
        L10:
            if (Intrinsics.areEqual(r1, r2) == true) goto L12;
            return false;
        L12:
            Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type androidx.work.Constraints.ContentUriTrigger");
            ContentUriTrigger r6 = (ContentUriTrigger) r5;
            if (Intrinsics.areEqual(this.uri, r6.uri) == true) goto L16;
            return false;
        L16:
            if (this.isTriggeredForDescendants == r6.isTriggeredForDescendants) goto L18;
            return false;
        L18:
            return true;
        L8:
            r2 = null;
            goto L10
        }

        public int hashCode() {
            return (this.uri.hashCode() * 31) + Boolean.hashCode(this.isTriggeredForDescendants);
        }
    }

    public Constraints() {
        this(null, false, false, false, false, 0, 0, null, 255, null);
    }

    public Constraints(NetworkType r2, boolean r3, boolean r4, boolean r5, boolean r6, long r7, long r9, Set<ContentUriTrigger> r11) {
        Intrinsics.checkNotNullParameter(r2, "requiredNetworkType");
        Intrinsics.checkNotNullParameter(r11, "contentUriTriggers");
        this.requiredNetworkType = r2;
        this.requiresCharging = r3;
        this.requiresDeviceIdle = r4;
        this.requiresBatteryNotLow = r5;
        this.requiresStorageNotLow = r6;
        this.contentTriggerUpdateDelayMillis = r7;
        this.contentTriggerMaxDelayMillis = r9;
        this.contentUriTriggers = r11;
    }

    public /* synthetic */ Constraints(NetworkType r12, boolean r13, boolean r14, boolean r15, boolean r16, long r17, long r19, Set r21, int r22, DefaultConstructorMarker r23) {
        if ((r22 & 1) == 0) goto L5;
        NetworkType r1 = NetworkType.NOT_REQUIRED;
    L6:
        boolean r3 = false;
        if ((r22 & 2) == 0) goto L9;
        boolean r2 = false;
    L11:
        if ((r22 & 4) == 0) goto L13;
        boolean r4 = false;
    L15:
        if ((r22 & 8) == 0) goto L17;
        boolean r5 = false;
    L19:
        if ((r22 & 16) != 0) goto L22;
        r3 = r16;
    L22:
        long r7 = -1;
        if ((r22 & 32) == 0) goto L25;
        long r9 = -1;
    L27:
        if ((r22 & 64) != 0) goto L31;
        r7 = r19;
    L31:
        if ((r22 & 128) == 0) goto L33;
        Set r0 = SetsKt.emptySet();
    L34:
        this(r1, r2, r4, r5, r3, r9, r7, r0);
        return;
    L33:
        r0 = r21;
        goto L34
    L25:
        r9 = r17;
        goto L27
    L17:
        r5 = r15;
        goto L19
    L13:
        r4 = r14;
        goto L15
    L9:
        r2 = r13;
        goto L11
    L5:
        r1 = r12;
        goto L6
    }

    public final NetworkType getRequiredNetworkType() {
        return this.requiredNetworkType;
    }

    public final long getContentTriggerUpdateDelayMillis() {
        return this.contentTriggerUpdateDelayMillis;
    }

    public final long getContentTriggerMaxDelayMillis() {
        return this.contentTriggerMaxDelayMillis;
    }

    public final Set<ContentUriTrigger> getContentUriTriggers() {
        return this.contentUriTriggers;
    }

    public Constraints(Constraints r13) {
        Intrinsics.checkNotNullParameter(r13, "other");
        boolean r3 = r13.requiresCharging;
        boolean r4 = r13.requiresDeviceIdle;
        NetworkType r2 = r13.requiredNetworkType;
        boolean r5 = r13.requiresBatteryNotLow;
        boolean r6 = r13.requiresStorageNotLow;
        Set<ContentUriTrigger> r11 = r13.contentUriTriggers;
        this(r2, r3, r4, r5, r6, r13.contentTriggerUpdateDelayMillis, r13.contentTriggerMaxDelayMillis, r11);
    }

    public final boolean requiresCharging() {
        return this.requiresCharging;
    }

    public final boolean requiresDeviceIdle() {
        return this.requiresDeviceIdle;
    }

    public final boolean requiresBatteryNotLow() {
        return this.requiresBatteryNotLow;
    }

    public final boolean requiresStorageNotLow() {
        return this.requiresStorageNotLow;
    }

    public final boolean hasContentUriTriggers() {
        return !this.contentUriTriggers.isEmpty();
    }

    public boolean equals(Object r6) {
        if (this != r6) goto L6;
        return true;
    L6:
        if (r6 != null) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(getClass(), r6.getClass()) == false) goto L34;
        Constraints r7 = (Constraints) r6;
        if (this.requiresCharging == r7.requiresCharging) goto L14;
        return false;
    L14:
        if (this.requiresDeviceIdle == r7.requiresDeviceIdle) goto L17;
        return false;
    L17:
        if (this.requiresBatteryNotLow == r7.requiresBatteryNotLow) goto L20;
        return false;
    L20:
        if (this.requiresStorageNotLow == r7.requiresStorageNotLow) goto L23;
        return false;
    L23:
        if (this.contentTriggerUpdateDelayMillis == r7.contentTriggerUpdateDelayMillis) goto L26;
        return false;
    L26:
        if (this.contentTriggerMaxDelayMillis == r7.contentTriggerMaxDelayMillis) goto L29;
        return false;
    L29:
        if (this.requiredNetworkType == r7.requiredNetworkType) goto L32;
        return false;
    L32:
        return Intrinsics.areEqual(this.contentUriTriggers, r7.contentUriTriggers);
    L34:
        return false;
    }

    public int hashCode() {
        int r0 = ((((((((this.requiredNetworkType.hashCode() * 31) + (this.requiresCharging ? 1 : 0)) * 31) + (this.requiresDeviceIdle ? 1 : 0)) * 31) + (this.requiresBatteryNotLow ? 1 : 0)) * 31) + (this.requiresStorageNotLow ? 1 : 0)) * 31;
        long r1 = this.contentTriggerUpdateDelayMillis;
        int r2 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
        long r3 = this.contentTriggerMaxDelayMillis;
        return ((r2 + ((int) (r3 ^ (r3 >>> 32)))) * 31) + this.contentUriTriggers.hashCode();
    }

    static {
        Companion = new Companion(null);
        NONE = new Constraints(null, false, false, false, false, 0, 0, null, 255, null);
    }
}
