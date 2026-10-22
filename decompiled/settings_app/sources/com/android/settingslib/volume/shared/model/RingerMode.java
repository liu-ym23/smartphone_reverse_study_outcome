package com.android.settingslib.volume.shared.model;

import android.icu.text.PluralRules;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: RingerMode.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u0005J\u0010\u0010\u000f\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002ø\u0001\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0014"}, d2 = {"Lcom/android/settingslib/volume/shared/model/RingerMode;", "", "value", "", "constructor-impl", "(I)I", "getValue", "()I", "equals", "", PluralRules.KEYWORD_OTHER, "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "app_debug"}, k = 1, mv = {1, 7, 1}, xi = 48)
@JvmInline
public final class RingerMode {
    private static final Companion Companion = null;

    @Deprecated
    private static final Set<Integer> supportedRingerModes = null;
    private final int value;

    /* JADX INFO: compiled from: RingerMode.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\b\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/android/settingslib/volume/shared/model/RingerMode$Companion;", "", "()V", "supportedRingerModes", "", "", "getSupportedRingerModes", "()Ljava/util/Set;", "app_debug"}, k = 1, mv = {1, 7, 1}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        public final Set<Integer> getSupportedRingerModes() {
            return RingerMode.access$getSupportedRingerModes$cp();
        }
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ RingerMode m829boximpl(int r1) {
        return new RingerMode(r1);
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m831equalsimpl(int r2, Object r3) {
        if ((r3 instanceof RingerMode) == true) goto L6;
        return false;
    L6:
        if (r2 == ((RingerMode) r3).m835unboximpl()) goto L8;
        return false;
    L8:
        return true;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m832equalsimpl0(int r0, int r1) {
        if (r0 != r1) goto L4;
        return true;
    L4:
        return false;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m833hashCodeimpl(int r0) {
        return Integer.hashCode(r0);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m834toStringimpl(int r2) {
        return "RingerMode(value=" + r2 + ')';
    }

    public boolean equals(Object r1) {
        return m831equalsimpl(this.value, r1);
    }

    public int hashCode() {
        return m833hashCodeimpl(this.value);
    }

    public String toString() {
        return m834toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m835unboximpl() {
        return this.value;
    }

    public static final /* synthetic */ Set access$getSupportedRingerModes$cp() {
        return supportedRingerModes;
    }

    private /* synthetic */ RingerMode(int r1) {
        this.value = r1;
    }

    public final int getValue() {
        return this.value;
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m830constructorimpl(int r2) {
        if (supportedRingerModes.contains(Integer.valueOf(r2)) == false) goto L6;
        return r2;
    L6:
        throw new IllegalArgumentException(("Unsupported stream=" + r2).toString());
    }

    static {
        Companion = new Companion(null);
        supportedRingerModes = SetsKt.setOf(new Integer[]{0, 1, 2, 2});
    }
}
