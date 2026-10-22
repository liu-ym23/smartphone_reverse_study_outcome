package com.android.settings.wifi.assistant;

import android.icu.text.PluralRules;
import com.android.settings.wifi.AccessPointInfo;
import com.obric.olog.OLog;
import cz.msebera.android.httpclient.message.TokenParser;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SubAccessPoint.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002\u001e\u001fB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0011\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0000H\u0096\u0002J\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u000b\u001a\u00020\rJ\u0010\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0016H\u0002J\u000e\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u001dR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006 "}, d2 = {"Lcom/android/settings/wifi/assistant/SubAccessPoint;", "", "info", "Lcom/android/settings/wifi/AccessPointInfo;", "summary", "", "(Lcom/android/settings/wifi/AccessPointInfo;Ljava/lang/String;)V", "getInfo", "()Lcom/android/settings/wifi/AccessPointInfo;", "setInfo", "(Lcom/android/settings/wifi/AccessPointInfo;)V", "listener", "Ljava/lang/ref/WeakReference;", "Lcom/android/settings/wifi/assistant/SubAccessPoint$OnUpdateListener;", "getSummary", "()Ljava/lang/String;", "setSummary", "(Ljava/lang/String;)V", "compareTo", "", PluralRules.KEYWORD_OTHER, "isConnected", "", "setOnUpdateListener", "", "update", "succeed", "updateState", "state", "Lcom/android/settings/wifi/assistant/SubAccessPoint$State;", "OnUpdateListener", "State", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class SubAccessPoint implements Comparable<SubAccessPoint> {
    private AccessPointInfo info;
    private WeakReference<OnUpdateListener> listener;
    private String summary;

    /* JADX INFO: compiled from: SubAccessPoint.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/android/settings/wifi/assistant/SubAccessPoint$OnUpdateListener;", "", "onUpdate", "", "subAccessPoint", "Lcom/android/settings/wifi/assistant/SubAccessPoint;", "succeeded", "", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface OnUpdateListener {
        void onUpdate(SubAccessPoint r1, boolean r2);
    }

    /* JADX INFO: compiled from: SubAccessPoint.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0003\u0006\u0007\b¨\u0006\t"}, d2 = {"Lcom/android/settings/wifi/assistant/SubAccessPoint$State;", "", "()V", "Connecting", "Default", "Success", "Lcom/android/settings/wifi/assistant/SubAccessPoint$State$Connecting;", "Lcom/android/settings/wifi/assistant/SubAccessPoint$State$Default;", "Lcom/android/settings/wifi/assistant/SubAccessPoint$State$Success;", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static abstract class State {

        /* JADX INFO: compiled from: SubAccessPoint.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/android/settings/wifi/assistant/SubAccessPoint$State$Connecting;", "Lcom/android/settings/wifi/assistant/SubAccessPoint$State;", "()V", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Connecting extends State {
            public static final Connecting INSTANCE = null;

            static {
                INSTANCE = new Connecting();
            }

            private Connecting() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: SubAccessPoint.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/android/settings/wifi/assistant/SubAccessPoint$State$Default;", "Lcom/android/settings/wifi/assistant/SubAccessPoint$State;", "()V", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Default extends State {
            public static final Default INSTANCE = null;

            static {
                INSTANCE = new Default();
            }

            private Default() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: SubAccessPoint.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/android/settings/wifi/assistant/SubAccessPoint$State$Success;", "Lcom/android/settings/wifi/assistant/SubAccessPoint$State;", "()V", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Success extends State {
            public static final Success INSTANCE = null;

            static {
                INSTANCE = new Success();
            }

            private Success() {
                super(null);
            }
        }

        public /* synthetic */ State(DefaultConstructorMarker r1) {
            this();
        }

        private State() {
        }
    }

    public SubAccessPoint(AccessPointInfo r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "info");
        Intrinsics.checkNotNullParameter(r3, "summary");
        this.info = r2;
        this.summary = r3;
    }

    public /* synthetic */ SubAccessPoint(AccessPointInfo r1, String r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = "";
    L5:
        this(r1, r2);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(SubAccessPoint r1) {
        return compareTo2(r1);
    }

    public final AccessPointInfo getInfo() {
        return this.info;
    }

    public final String getSummary() {
        return this.summary;
    }

    public final void setInfo(AccessPointInfo r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.info = r2;
    }

    public final void setSummary(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.summary = r2;
    }

    public final void setOnUpdateListener(OnUpdateListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.listener = new WeakReference(r2);
    }

    private final void update(boolean r2) {
        WeakReference<OnUpdateListener> r0 = this.listener;
        if (r0 == null) goto L7;
        OnUpdateListener r1 = r0.get();
        if (r1 == null) goto L7;
        r1.onUpdate(this, r2);
    L7:
        StringBuilder r3 = new StringBuilder("(").append(this.info.ssid).append(")update ").append(this.summary).append(TokenParser.SP);
        WeakReference<OnUpdateListener> r4 = this.listener;
        if (r4 == null) goto L10;
        OnUpdateListener r5 = r4.get();
    L11:
        OLog.i("SubAccessPoint", r3.append(r5).toString());
        return;
    L10:
        r5 = null;
        goto L11
    }

    public final void updateState(State r3) {
        Intrinsics.checkNotNullParameter(r3, "state");
        OLog.i("SubAccessPoint", "(" + this.info.ssid + ")update " + this.summary + TokenParser.SP + r3.getClass().getSimpleName());
        if (Intrinsics.areEqual(r3, State.Connecting.INSTANCE) == false) goto L6;
        String r4 = "正在连接...";
    L11:
        this.summary = r4;
        update(Intrinsics.areEqual(r4, "辅助加速中"));
        return;
    L6:
        if (Intrinsics.areEqual(r3, State.Success.INSTANCE) == false) goto L9;
        r4 = "辅助加速中";
        goto L11
    L9:
        if (Intrinsics.areEqual(r3, State.Default.INSTANCE) == false) goto L14;
        this.info.mState = null;
        r4 = "";
        goto L11
    L14:
        throw new NoWhenBranchMatchedException();
    }

    public final boolean isConnected() {
        return Intrinsics.areEqual(this.summary, "辅助加速中");
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(SubAccessPoint r4) {
        Intrinsics.checkNotNullParameter(r4, PluralRules.KEYWORD_OTHER);
        boolean r1 = false;
        if (this.summary.length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L15;
        if (r4.summary.length() <= 0) goto L10;
        boolean r2 = true;
    L11:
        if (r2 == false) goto L15;
        return this.summary.compareTo(r4.summary);
    L10:
        r2 = false;
    L15:
        if (this.summary.length() <= 0) goto L17;
        boolean r3 = true;
    L18:
        if (r3 == false) goto L22;
        return -1;
    L22:
        if (r4.summary.length() <= 0) goto L24;
        r1 = true;
    L24:
        if (r1 == false) goto L27;
        return 1;
    L27:
        return this.info.compareTo2(r4.info);
    L17:
        r3 = false;
        goto L18
    L5:
        r0 = false;
        goto L6
    }
}
