package com.obric.security.battertpower.powerHigh.notice;

import com.ss.android.message.log.PushLog;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PowerHighApp.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b3\b\u0087\b\u0018\u00002\u00020\u0001B\u009f\u0001\u0012\u001c\b\u0002\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u0012\u001a\u00020\b\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u000f¢\u0006\u0002\u0010\u0014J\u001d\u00100\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005HÆ\u0003J\u0010\u00101\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0019J\t\u00102\u001a\u00020\bHÆ\u0003J\t\u00103\u001a\u00020\u000fHÆ\u0003J\t\u00104\u001a\u00020\u0004HÆ\u0003J\t\u00105\u001a\u00020\bHÆ\u0003J\u0010\u00106\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0019J\u0010\u00107\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0019J\u0010\u00108\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\u0016J\u000b\u00109\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0010\u0010:\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u0010\u001bJ\u0010\u0010;\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u0010\u001bJ¨\u0001\u0010<\u001a\u00020\u00002\u001c\b\u0002\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u0012\u001a\u00020\b2\b\b\u0002\u0010\u0013\u001a\u00020\u000fHÆ\u0001¢\u0006\u0002\u0010=J\u0013\u0010>\u001a\u00020\u000f2\b\u0010?\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010@\u001a\u00020\u0004H\u0016J\t\u0010A\u001a\u00020\bHÖ\u0001R\u0015\u0010\f\u001a\u0004\u0018\u00010\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u000e\u0010\u001bR\u001a\u0010\u0012\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0013\u0010\r\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001eR.\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b'\u0010\u001bR\u001a\u0010\u0013\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u0015\u0010\u0011\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b,\u0010\u0019R\u0015\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b-\u0010\u0019R\u0011\u0010\u0006\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/¨\u0006B"}, d2 = {"Lcom/obric/security/battertpower/powerHigh/notice/PowerHighApp;", "", "pid", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "uid", "packageName", "", "totalDuration", "", "bgDuration", "bgCount", "networkType", "isControlled", "", "screenState", "timestamp", PushLog.KEY_LABEL, "tempCheck", "(Ljava/util/HashSet;ILjava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/String;Z)V", "getBgCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getBgDuration", "()Ljava/lang/Long;", "Ljava/lang/Long;", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getLabel", "()Ljava/lang/String;", "setLabel", "(Ljava/lang/String;)V", "getNetworkType", "getPackageName", "getPid", "()Ljava/util/HashSet;", "setPid", "(Ljava/util/HashSet;)V", "getScreenState", "getTempCheck", "()Z", "setTempCheck", "(Z)V", "getTimestamp", "getTotalDuration", "getUid", "()I", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/util/HashSet;ILjava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/String;Z)Lcom/obric/security/battertpower/powerHigh/notice/PowerHighApp;", "equals", "other", "hashCode", "toString", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class PowerHighApp {
    private final Integer bgCount;
    private final Long bgDuration;
    private final Boolean isControlled;
    private String label;
    private final String networkType;
    private final String packageName;
    private HashSet<Integer> pid;
    private final Boolean screenState;
    private boolean tempCheck;
    private final Long timestamp;
    private final Long totalDuration;
    private final int uid;

    public PowerHighApp() {
        this(null, 0, null, null, null, null, null, null, null, null, null, false, 4095, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PowerHighApp copy$default(PowerHighApp r13, HashSet r14, int r15, String r16, Long r17, Long r18, Integer r19, String r20, Boolean r21, Boolean r22, Long r23, String r24, boolean r25, int r26, Object r27) {
        if ((r26 & 1) == 0) goto L5;
        HashSet r2 = r13.pid;
    L7:
        if ((r26 & 2) == 0) goto L9;
        int r3 = r13.uid;
    L11:
        if ((r26 & 4) == 0) goto L13;
        String r4 = r13.packageName;
    L15:
        if ((r26 & 8) == 0) goto L17;
        Long r5 = r13.totalDuration;
    L19:
        if ((r26 & 16) == 0) goto L21;
        Long r6 = r13.bgDuration;
    L23:
        if ((r26 & 32) == 0) goto L25;
        Integer r7 = r13.bgCount;
    L27:
        if ((r26 & 64) == 0) goto L29;
        String r8 = r13.networkType;
    L31:
        if ((r26 & 128) == 0) goto L33;
        Boolean r9 = r13.isControlled;
    L35:
        if ((r26 & 256) == 0) goto L37;
        Boolean r10 = r13.screenState;
    L39:
        if ((r26 & 512) == 0) goto L41;
        Long r11 = r13.timestamp;
    L43:
        if ((r26 & 1024) == 0) goto L45;
        String r12 = r13.label;
    L47:
        if ((r26 & 2048) == 0) goto L49;
        boolean r1 = r13.tempCheck;
    L51:
        return r13.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r1);
    L49:
        r1 = r25;
        goto L51
    L45:
        r12 = r24;
        goto L47
    L41:
        r11 = r23;
        goto L43
    L37:
        r10 = r22;
        goto L39
    L33:
        r9 = r21;
        goto L35
    L29:
        r8 = r20;
        goto L31
    L25:
        r7 = r19;
        goto L27
    L21:
        r6 = r18;
        goto L23
    L17:
        r5 = r17;
        goto L19
    L13:
        r4 = r16;
        goto L15
    L9:
        r3 = r15;
        goto L11
    L5:
        r2 = r14;
        goto L7
    }

    public final HashSet<Integer> component1() {
        return this.pid;
    }

    public final Long component10() {
        return this.timestamp;
    }

    public final String component11() {
        return this.label;
    }

    public final boolean component12() {
        return this.tempCheck;
    }

    public final int component2() {
        return this.uid;
    }

    public final String component3() {
        return this.packageName;
    }

    public final Long component4() {
        return this.totalDuration;
    }

    public final Long component5() {
        return this.bgDuration;
    }

    public final Integer component6() {
        return this.bgCount;
    }

    public final String component7() {
        return this.networkType;
    }

    public final Boolean component8() {
        return this.isControlled;
    }

    public final Boolean component9() {
        return this.screenState;
    }

    public final PowerHighApp copy(HashSet<Integer> r15, int r16, String r17, Long r18, Long r19, Integer r20, String r21, Boolean r22, Boolean r23, Long r24, String r25, boolean r26) {
        Intrinsics.checkNotNullParameter(r17, "packageName");
        Intrinsics.checkNotNullParameter(r25, PushLog.KEY_LABEL);
        return new PowerHighApp(r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26);
    }

    public String toString() {
        return "PowerHighApp(pid=" + this.pid + ", uid=" + this.uid + ", packageName=" + this.packageName + ", totalDuration=" + this.totalDuration + ", bgDuration=" + this.bgDuration + ", bgCount=" + this.bgCount + ", networkType=" + this.networkType + ", isControlled=" + this.isControlled + ", screenState=" + this.screenState + ", timestamp=" + this.timestamp + ", label=" + this.label + ", tempCheck=" + this.tempCheck + ")";
    }

    public PowerHighApp(HashSet<Integer> r2, int r3, String r4, Long r5, Long r6, Integer r7, String r8, Boolean r9, Boolean r10, Long r11, String r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r4, "packageName");
        Intrinsics.checkNotNullParameter(r12, PushLog.KEY_LABEL);
        this.pid = r2;
        this.uid = r3;
        this.packageName = r4;
        this.totalDuration = r5;
        this.bgDuration = r6;
        this.bgCount = r7;
        this.networkType = r8;
        this.isControlled = r9;
        this.screenState = r10;
        this.timestamp = r11;
        this.label = r12;
        this.tempCheck = r13;
    }

    public /* synthetic */ PowerHighApp(HashSet r15, int r16, String r17, Long r18, Long r19, Integer r20, String r21, Boolean r22, Boolean r23, Long r24, String r25, boolean r26, int r27, DefaultConstructorMarker r28) {
        if ((r27 & 1) == 0) goto L5;
        HashSet r1 = new HashSet();
    L7:
        if ((r27 & 2) == 0) goto L9;
        int r2 = 0;
    L10:
        String r5 = "";
        if ((r27 & 4) == 0) goto L13;
        String r4 = "";
    L15:
        if ((r27 & 8) == 0) goto L17;
        Long r6 = 0L;
    L19:
        if ((r27 & 16) == 0) goto L21;
        Long r9 = 0L;
    L23:
        if ((r27 & 32) == 0) goto L25;
        Integer r10 = 0;
    L27:
        if ((r27 & 64) == 0) goto L29;
        String r11 = "";
    L31:
        if ((r27 & 128) == 0) goto L33;
        Boolean r12 = false;
    L35:
        if ((r27 & 256) == 0) goto L37;
        Boolean r3 = false;
    L39:
        if ((r27 & 512) == 0) goto L41;
        Long r7 = 0L;
    L43:
        if ((r27 & 1024) != 0) goto L47;
        r5 = r25;
    L47:
        if ((r27 & 2048) == 0) goto L49;
        boolean r0 = true;
    L50:
        this(r1, r2, r4, r6, r9, r10, r11, r12, r3, r7, r5, r0);
        return;
    L49:
        r0 = r26;
        goto L50
    L41:
        r7 = r24;
        goto L43
    L37:
        r3 = r23;
        goto L39
    L33:
        r12 = r22;
        goto L35
    L29:
        r11 = r21;
        goto L31
    L25:
        r10 = r20;
        goto L27
    L21:
        r9 = r19;
        goto L23
    L17:
        r6 = r18;
        goto L19
    L13:
        r4 = r17;
        goto L15
    L9:
        r2 = r16;
        goto L10
    L5:
        r1 = r15;
        goto L7
    }

    public final HashSet<Integer> getPid() {
        return this.pid;
    }

    public final void setPid(HashSet<Integer> r1) {
        this.pid = r1;
    }

    public final int getUid() {
        return this.uid;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final Long getTotalDuration() {
        return this.totalDuration;
    }

    public final Long getBgDuration() {
        return this.bgDuration;
    }

    public final Integer getBgCount() {
        return this.bgCount;
    }

    public final String getNetworkType() {
        return this.networkType;
    }

    public final Boolean isControlled() {
        return this.isControlled;
    }

    public final Boolean getScreenState() {
        return this.screenState;
    }

    public final Long getTimestamp() {
        return this.timestamp;
    }

    public final String getLabel() {
        return this.label;
    }

    public final void setLabel(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.label = r2;
    }

    public final boolean getTempCheck() {
        return this.tempCheck;
    }

    public final void setTempCheck(boolean r1) {
        this.tempCheck = r1;
    }

    public boolean equals(Object r3) {
        if (r3 != null) goto L6;
        return false;
    L6:
        if ((r3 instanceof PowerHighApp) == true) goto L9;
        return false;
    L9:
        if (((PowerHighApp) r3).uid != this.uid) goto L12;
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        return this.uid;
    }
}
