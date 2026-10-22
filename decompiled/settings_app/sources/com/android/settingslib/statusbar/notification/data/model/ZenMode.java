package com.android.settingslib.statusbar.notification.data.model;

import android.icu.text.PluralRules;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ZenMode.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u0005J\u0010\u0010\u000f\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002ø\u0001\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0014"}, d2 = {"Lcom/android/settingslib/statusbar/notification/data/model/ZenMode;", "", "zenMode", "", "constructor-impl", "(I)I", "getZenMode", "()I", "equals", "", PluralRules.KEYWORD_OTHER, "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "app_debug"}, k = 1, mv = {1, 7, 1}, xi = 48)
@JvmInline
public final class ZenMode {
    private static final Companion Companion = null;

    @Deprecated
    private static final List<Integer> supportedModes = null;
    private final int zenMode;

    /* JADX INFO: compiled from: ZenMode.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/android/settingslib/statusbar/notification/data/model/ZenMode$Companion;", "", "()V", "supportedModes", "", "", "getSupportedModes", "()Ljava/util/List;", "app_debug"}, k = 1, mv = {1, 7, 1}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        public final List<Integer> getSupportedModes() {
            return ZenMode.access$getSupportedModes$cp();
        }
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ ZenMode m772boximpl(int r1) {
        return new ZenMode(r1);
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m774equalsimpl(int r2, Object r3) {
        if ((r3 instanceof ZenMode) == true) goto L6;
        return false;
    L6:
        if (r2 == ((ZenMode) r3).m778unboximpl()) goto L8;
        return false;
    L8:
        return true;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m775equalsimpl0(int r0, int r1) {
        if (r0 != r1) goto L4;
        return true;
    L4:
        return false;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m776hashCodeimpl(int r0) {
        return Integer.hashCode(r0);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m777toStringimpl(int r2) {
        return "ZenMode(zenMode=" + r2 + ')';
    }

    public boolean equals(Object r1) {
        return m774equalsimpl(this.zenMode, r1);
    }

    public int hashCode() {
        return m776hashCodeimpl(this.zenMode);
    }

    public String toString() {
        return m777toStringimpl(this.zenMode);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m778unboximpl() {
        return this.zenMode;
    }

    public static final /* synthetic */ List access$getSupportedModes$cp() {
        return supportedModes;
    }

    private /* synthetic */ ZenMode(int r1) {
        this.zenMode = r1;
    }

    public final int getZenMode() {
        return this.zenMode;
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m773constructorimpl(int r2) {
        if (supportedModes.contains(Integer.valueOf(r2)) == false) goto L6;
        return r2;
    L6:
        throw new IllegalArgumentException(("Unsupported zenMode=" + r2).toString());
    }

    static {
        Companion = new Companion(null);
        supportedModes = CollectionsKt.listOf(new Integer[]{1, 2, 3, 0});
    }
}
