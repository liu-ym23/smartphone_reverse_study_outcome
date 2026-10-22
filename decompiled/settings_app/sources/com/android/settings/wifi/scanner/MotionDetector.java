package com.android.settings.wifi.scanner;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.icu.text.DateFormat;
import android.icu.text.PluralRules;
import com.obric.oui.material.MaterialConfigFormatNames;
import java.util.Timer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MotionDetector.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000  2\u00020\u0001:\u0003 !\"B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\u0010\bJ\u001a\u0010\u0014\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0007H\u0002J\b\u0010\u0019\u001a\u00020\u0007H\u0002J\u0010\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0006\u0010\u001d\u001a\u00020\u0007J\u0006\u0010\u001e\u001a\u00020\u0007J\u0006\u0010\u001f\u001a\u00020\u0007R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/android/settings/wifi/scanner/MotionDetector;", "Landroid/hardware/SensorEventListener;", "context", "Landroid/content/Context;", "onStateChanged", "Lkotlin/Function1;", "Lcom/android/settings/wifi/scanner/MotionDetector$State;", "", "(Landroid/content/Context;Lkotlin/jvm/functions/Function1;)V", "accelerometer", "Landroid/hardware/Sensor;", "lastActiveTime", "", "lastPosition", "Lcom/android/settings/wifi/scanner/MotionDetector$Position;", "sensorManager", "Landroid/hardware/SensorManager;", "state", "timer", "Ljava/util/Timer;", "onAccuracyChanged", "sensor", "accuracy", "", "onScreenMoving", "onScreenStationary", "onSensorChanged", "event", "Landroid/hardware/SensorEvent;", "resetLastActiveTime", "start", "stop", "Companion", "Position", "State", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class MotionDetector implements SensorEventListener {
    public static final Companion Companion = null;
    public static final int INACTIVE_TIME_THRESHOLD = 180000;
    public static final float THRESHOLD = 0.5f;
    private Sensor accelerometer;
    private volatile long lastActiveTime;
    private Position lastPosition;
    private final Function1<State, Unit> onStateChanged;
    private SensorManager sensorManager;
    private State state;
    private Timer timer;

    /* JADX INFO: compiled from: MotionDetector.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/android/settings/wifi/scanner/MotionDetector$Companion;", "", "()V", "INACTIVE_TIME_THRESHOLD", "", "THRESHOLD", "", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: MotionDetector.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0016"}, d2 = {"Lcom/android/settings/wifi/scanner/MotionDetector$Position;", "", MaterialConfigFormatNames.X, "", "y", DateFormat.ABBR_SPECIFIC_TZ, "(FFF)V", "getX", "()F", "getY", "getZ", "component1", "component2", "component3", "copy", "equals", "", PluralRules.KEYWORD_OTHER, "hashCode", "", "toString", "", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Position {
        private final float x;
        private final float y;
        private final float z;

        public static /* synthetic */ Position copy$default(Position r0, float r1, float r2, float r3, int r4, Object r5) {
            if ((r4 & 1) == 0) goto L6;
            r1 = r0.x;
        L6:
            if ((r4 & 2) == 0) goto L9;
            r2 = r0.y;
        L9:
            if ((r4 & 4) == 0) goto L12;
            r3 = r0.z;
        L12:
            return r0.copy(r1, r2, r3);
        }

        public final float component1() {
            return this.x;
        }

        public final float component2() {
            return this.y;
        }

        public final float component3() {
            return this.z;
        }

        public final Position copy(float r1, float r2, float r3) {
            return new Position(r1, r2, r3);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof Position) == true) goto L8;
            return false;
        L8:
            Position r6 = (Position) r5;
            if (Float.compare(this.x, r6.x) == 0) goto L12;
            return false;
        L12:
            if (Float.compare(this.y, r6.y) == 0) goto L15;
            return false;
        L15:
            if (Float.compare(this.z, r6.z) == 0) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((Float.hashCode(this.x) * 31) + Float.hashCode(this.y)) * 31) + Float.hashCode(this.z);
        }

        public String toString() {
            return "Position(x=" + this.x + ", y=" + this.y + ", z=" + this.z + ')';
        }

        public Position(float r1, float r2, float r3) {
            this.x = r1;
            this.y = r2;
            this.z = r3;
        }

        public final float getX() {
            return this.x;
        }

        public final float getY() {
            return this.y;
        }

        public final float getZ() {
            return this.z;
        }
    }

    /* JADX INFO: compiled from: MotionDetector.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/android/settings/wifi/scanner/MotionDetector$State;", "", "(Ljava/lang/String;I)V", "ACTIVE", "INACTIVE", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final enum State extends Enum<State> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ State[] $VALUES = null;
        public static final State ACTIVE = null;
        public static final State INACTIVE = null;

        private static final /* synthetic */ State[] $values() {
            return new State[]{ACTIVE, INACTIVE};
        }

        public static EnumEntries<State> getEntries() {
            return $ENTRIES;
        }

        public static State valueOf(String r1) {
            return (State) Enum.valueOf(State.class, r1);
        }

        public static State[] values() {
            return (State[]) $VALUES.clone();
        }

        private State(String r1, int r2) {
            super(r1, r2);
        }

        static {
            ACTIVE = new State("ACTIVE", 0);
            INACTIVE = new State("INACTIVE", 1);
            State[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = EnumEntriesKt.enumEntries(r0);
        }
    }

    static {
        Companion = new Companion(null);
    }

    private final void onScreenStationary() {
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor r1, int r2) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MotionDetector(Context r7, Function1<? super State, Unit> r8) {
        Intrinsics.checkNotNullParameter(r7, "context");
        Intrinsics.checkNotNullParameter(r8, "onStateChanged");
        this.onStateChanged = r8;
        Object r9 = r7.getSystemService("sensor");
        Intrinsics.checkNotNull(r9, "null cannot be cast to non-null type android.hardware.SensorManager");
        this.sensorManager = (SensorManager) r9;
        this.state = State.ACTIVE;
        this.lastActiveTime = System.currentTimeMillis();
        this.timer = new Timer();
        SensorManager r10 = this.sensorManager;
        if (r10 == null) goto L5;
        Intrinsics.checkNotNull(r10);
        this.accelerometer = r10.getDefaultSensor(1);
    L5:
        Timer r0 = this.timer;
        if (r0 == null) goto L9;
        r0.schedule(new AnonymousClass1(this), 0, 1000);
        return;
    }

    public static final /* synthetic */ long access$getLastActiveTime$p(MotionDetector r2) {
        return r2.lastActiveTime;
    }

    public static final /* synthetic */ Function1 access$getOnStateChanged$p(MotionDetector r0) {
        return r0.onStateChanged;
    }

    public static final /* synthetic */ State access$getState$p(MotionDetector r0) {
        return r0.state;
    }

    public static final /* synthetic */ void access$setState$p(MotionDetector r0, State r1) {
        r0.state = r1;
    }

    public final void start() {
        Sensor r0 = this.accelerometer;
        if (r0 == null) goto L8;
        SensorManager r1 = this.sensorManager;
        if (r1 == null) goto L9;
        r1.registerListener(this, r0, 3);
        return;
    L9:
        return;
    }

    public final void stop() {
        Timer r0 = this.timer;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        this.timer = null;
        SensorManager r1 = this.sensorManager;
        if (r1 == null) goto L9;
        r1.unregisterListener(this);
        return;
    }

    public final void resetLastActiveTime() {
        this.state = State.ACTIVE;
        this.lastActiveTime = System.currentTimeMillis();
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent r7) {
        Intrinsics.checkNotNullParameter(r7, "event");
        float r0 = r7.values[0];
        float r1 = r7.values[1];
        float r8 = r7.values[2];
        Position r2 = this.lastPosition;
        if (r2 != null) goto L6;
        this.lastPosition = new Position(r0, r1, r8);
        return;
    L6:
        Intrinsics.checkNotNull(r2);
        float r3 = Math.abs(r0 - r2.getX());
        Position r4 = this.lastPosition;
        Intrinsics.checkNotNull(r4);
        float r5 = Math.abs(r1 - r4.getY());
        Position r6 = this.lastPosition;
        Intrinsics.checkNotNull(r6);
        float r9 = Math.abs(r8 - r6.getZ());
        this.lastPosition = new Position(r0, r1, r8);
        if (Math.sqrt(((r3 * r3) + (r5 * r5)) + (r9 * r9)) >= 0.5d) goto L9;
        onScreenStationary();
        return;
    L9:
        onScreenMoving();
    }

    private final void onScreenMoving() {
        if (this.state != State.INACTIVE) goto L5;
        this.onStateChanged.invoke(State.ACTIVE);
    L5:
        this.state = State.ACTIVE;
        this.lastActiveTime = System.currentTimeMillis();
    }
}
