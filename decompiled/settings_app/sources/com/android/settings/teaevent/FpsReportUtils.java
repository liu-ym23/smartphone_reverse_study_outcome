package com.android.settings.teaevent;

import android.icu.text.PluralRules;
import com.obric.olog.OLog;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONObject;

/* JADX INFO: compiled from: FpsReportUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u000fB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bJ\u0016\u0010\f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/android/settings/teaevent/FpsReportUtils;", "", "()V", "TAG", "", "parseDropFrame", "Lcom/android/settings/teaevent/FpsReportUtils$DropFrameLevel;", "dropFrames", "Lorg/json/JSONObject;", "reportRecyclerDropFrame", "", "scene", "reportRecyclerFps", "fps", "", "DropFrameLevel", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class FpsReportUtils {
    public static final FpsReportUtils INSTANCE = null;
    private static final String TAG = null;

    /* JADX INFO: compiled from: FpsReportUtils.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003JE\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001e"}, d2 = {"Lcom/android/settings/teaevent/FpsReportUtils$DropFrameLevel;", "", "level0", "", "level1", "level2", "level3", "level4", "level5", "(IIIIII)V", "getLevel0", "()I", "getLevel1", "getLevel2", "getLevel3", "getLevel4", "getLevel5", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", PluralRules.KEYWORD_OTHER, "hashCode", "toString", "", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class DropFrameLevel {
        private final int level0;
        private final int level1;
        private final int level2;
        private final int level3;
        private final int level4;
        private final int level5;

        public DropFrameLevel() {
            this(0, 0, 0, 0, 0, 0, 63, null);
        }

        public static /* synthetic */ DropFrameLevel copy$default(DropFrameLevel r4, int r5, int r6, int r7, int r8, int r9, int r10, int r11, Object r12) {
            if ((r11 & 1) == 0) goto L6;
            r5 = r4.level0;
        L6:
            if ((r11 & 2) == 0) goto L8;
            r6 = r4.level1;
        L8:
            int r13 = r6;
            if ((r11 & 4) == 0) goto L11;
            r7 = r4.level2;
        L11:
            int r0 = r7;
            if ((r11 & 8) == 0) goto L14;
            r8 = r4.level3;
        L14:
            int r1 = r8;
            if ((r11 & 16) == 0) goto L17;
            r9 = r4.level4;
        L17:
            int r2 = r9;
            if ((r11 & 32) == 0) goto L20;
            r10 = r4.level5;
        L20:
            int r14 = r5;
            return r4.copy(r14, r13, r0, r1, r2, r10);
        }

        public final int component1() {
            return this.level0;
        }

        public final int component2() {
            return this.level1;
        }

        public final int component3() {
            return this.level2;
        }

        public final int component4() {
            return this.level3;
        }

        public final int component5() {
            return this.level4;
        }

        public final int component6() {
            return this.level5;
        }

        public final DropFrameLevel copy(int r8, int r9, int r10, int r11, int r12, int r13) {
            return new DropFrameLevel(r8, r9, r10, r11, r12, r13);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof DropFrameLevel) == true) goto L8;
            return false;
        L8:
            DropFrameLevel r6 = (DropFrameLevel) r5;
            if (this.level0 == r6.level0) goto L12;
            return false;
        L12:
            if (this.level1 == r6.level1) goto L15;
            return false;
        L15:
            if (this.level2 == r6.level2) goto L18;
            return false;
        L18:
            if (this.level3 == r6.level3) goto L21;
            return false;
        L21:
            if (this.level4 == r6.level4) goto L24;
            return false;
        L24:
            if (this.level5 == r6.level5) goto L26;
            return false;
        L26:
            return true;
        }

        public int hashCode() {
            return (((((((((Integer.hashCode(this.level0) * 31) + Integer.hashCode(this.level1)) * 31) + Integer.hashCode(this.level2)) * 31) + Integer.hashCode(this.level3)) * 31) + Integer.hashCode(this.level4)) * 31) + Integer.hashCode(this.level5);
        }

        public String toString() {
            return "DropFrameLevel(level0=" + this.level0 + ", level1=" + this.level1 + ", level2=" + this.level2 + ", level3=" + this.level3 + ", level4=" + this.level4 + ", level5=" + this.level5 + ')';
        }

        public DropFrameLevel(int r1, int r2, int r3, int r4, int r5, int r6) {
            this.level0 = r1;
            this.level1 = r2;
            this.level2 = r3;
            this.level3 = r4;
            this.level4 = r5;
            this.level5 = r6;
        }

        public /* synthetic */ DropFrameLevel(int r2, int r3, int r4, int r5, int r6, int r7, int r8, DefaultConstructorMarker r9) {
            if ((r8 & 1) == 0) goto L6;
            r2 = 0;
        L6:
            if ((r8 & 2) == 0) goto L9;
            r3 = 0;
        L9:
            if ((r8 & 4) == 0) goto L12;
            r4 = 0;
        L12:
            if ((r8 & 8) == 0) goto L15;
            r5 = 0;
        L15:
            if ((r8 & 16) == 0) goto L18;
            r6 = 0;
        L18:
            if ((r8 & 32) == 0) goto L20;
            r7 = 0;
        L20:
            this(r2, r3, r4, r5, r6, r7);
        }

        public final int getLevel0() {
            return this.level0;
        }

        public final int getLevel1() {
            return this.level1;
        }

        public final int getLevel2() {
            return this.level2;
        }

        public final int getLevel3() {
            return this.level3;
        }

        public final int getLevel4() {
            return this.level4;
        }

        public final int getLevel5() {
            return this.level5;
        }
    }

    private FpsReportUtils() {
    }

    static {
        INSTANCE = new FpsReportUtils();
        TAG = Reflection.getOrCreateKotlinClass(FpsReportUtils.class).getSimpleName();
    }

    public final void reportRecyclerFps(String r3, double r4) {
        Intrinsics.checkNotNullParameter(r3, "scene");
        TeaEventReportUtil.INSTANCE.report("settings_recycler_fps", MapsKt.mapOf(new Pair[]{TuplesKt.to("scene_action", r3), TuplesKt.to("recycler_fps", Double.valueOf(r4))}));
    }

    private final DropFrameLevel parseDropFrame(JSONObject r15) {
        Iterator<String> r0 = r15.keys();     // Catch: Throwable -> L49
        Intrinsics.checkNotNull(r0);     // Catch: Throwable -> L49
        int r1 = 0;
        int r2 = 0;
        int r3 = 0;
        int r4 = 0;
        int r5 = 0;
        int r6 = 0;
    L54:
        if (r0.hasNext() == false) goto L53;
        String r7 = r0.next();     // Catch: Throwable -> L47
        Intrinsics.checkNotNull(r7);     // Catch: Throwable -> L47
        int r8 = Integer.parseInt(r7);     // Catch: Throwable -> L47
        int r9 = r15.getInt(r7);     // Catch: Throwable -> L47
        if (r8 == 0) goto L9;
        boolean r11 = true;
        if (1 > r8) goto L14;
        if (r8 >= 3) goto L14;
        boolean r12 = true;
    L15:
        if (r12 == true) goto L16;
        if (3 > r8) goto L21;
        if (r8 >= 7) goto L21;
        boolean r10 = true;
    L22:
        if (r10 == true) goto L23;
        if (7 > r8) goto L28;
        if (r8 >= 14) goto L28;
        boolean r13 = true;
    L29:
        if (r13 == true) goto L30;
        if (14 > r8) goto L35;
        if (r8 >= 26) goto L35;
        boolean r14 = true;
    L36:
        if (r14 == true) goto L37;
        if (26 <= r8) goto L40;
    L42:
        r11 = false;
    L43:
        if (r11 == true) goto L44;
        OLog.e(TAG, "parseDropFrame with " + r7 + ": " + r9);     // Catch: Throwable -> L47
        goto L54
    L44:
        r6 = r6 + (r9 * r8);     // Catch: Throwable -> L47
        goto L54
    L40:
        if (r8 > Integer.MAX_VALUE) goto L42;
    L37:
        r5 = r5 + (r9 * r8);     // Catch: Throwable -> L47
    L35:
        r14 = false;
        goto L36
    L30:
        r4 = r4 + (r9 * r8);     // Catch: Throwable -> L47
    L28:
        r13 = false;
        goto L29
    L23:
        r3 = r3 + (r9 * r8);     // Catch: Throwable -> L47
    L21:
        r10 = false;
        goto L22
    L16:
        r2 = r2 + (r9 * r8);     // Catch: Throwable -> L47
    L14:
        r12 = false;
        goto L15
    L9:
        r1 = r1 + r9;     // Catch: Throwable -> L47
    L53:
        return new DropFrameLevel(r1, r2, r3, r4, r5, r6);
    L47:
        Object th = th;
    L51:
        OLog.e(TAG, "parseDropFrame error: " + th);
    L49:
        th = move-exception;
        r1 = 0;
        r2 = 0;
        r3 = 0;
        r4 = 0;
        r5 = 0;
        r6 = 0;
        th = th;
        goto L51
    }

    public final void reportRecyclerDropFrame(String r4, JSONObject r5) {
        Intrinsics.checkNotNullParameter(r4, "scene");
        Intrinsics.checkNotNullParameter(r5, "dropFrames");
        DropFrameLevel r3 = parseDropFrame(r5);
        TeaEventReportUtil.INSTANCE.report("settings_recycler_drop_frame", MapsKt.mapOf(new Pair[]{TuplesKt.to("scene_action", r4), TuplesKt.to("drop_frames", r5), TuplesKt.to("drop_frames_level0", Integer.valueOf(r3.getLevel0())), TuplesKt.to("drop_frames_level1", Integer.valueOf(r3.getLevel1())), TuplesKt.to("drop_frames_level2", Integer.valueOf(r3.getLevel2())), TuplesKt.to("drop_frames_level3", Integer.valueOf(r3.getLevel3())), TuplesKt.to("drop_frames_level4", Integer.valueOf(r3.getLevel4())), TuplesKt.to("drop_frames_level5", Integer.valueOf(r3.getLevel5()))}));
    }
}
