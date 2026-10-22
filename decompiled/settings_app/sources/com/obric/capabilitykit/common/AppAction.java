package com.obric.capabilitykit.common;

import android.icu.text.PluralRules;
import com.android.settings.NotificationDisplayDetailsActivity;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b \n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001Bo\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000eJ\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\bHÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jy\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010+\u001a\u00020\bHÖ\u0001J\t\u0010,\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u001e\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0010\"\u0004\b\u0017\u0010\u0018R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0010R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0010R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006-"}, d2 = {"Lcom/obric/capabilitykit/common/AppAction;", "", NotificationDisplayDetailsActivity.EXTRA_PACKAGE_NAME, "", "action", "params", "intent", "type", "", "shortcutId", "interfaceName", "targetPkgName", "logPb", "implClassName", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAction", "()Ljava/lang/String;", "getImplClassName", "getIntent", "getInterfaceName", "getLogPb", "getPackageName", "getParams", "setParams", "(Ljava/lang/String;)V", "getShortcutId", "getTargetPkgName", "getType", "()I", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", PluralRules.KEYWORD_OTHER, "hashCode", "toString", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AppAction {

    @SerializedName("OperationId")
    private final String action;
    private final String implClassName;

    @SerializedName("Intent")
    private final String intent;
    private final String interfaceName;
    private final String logPb;

    @SerializedName("Package")
    private final String packageName;

    @SerializedName("Params")
    private String params;

    @SerializedName("ShortcutId")
    private final String shortcutId;
    private final String targetPkgName;

    @SerializedName("LocalToolType")
    private final int type;

    public AppAction(String r2, String r3, String r4, String r5, int r6, String r7, String r8, String r9, String r10, String r11) {
        Intrinsics.checkNotNullParameter(r2, NotificationDisplayDetailsActivity.EXTRA_PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(r3, "action");
        Intrinsics.checkNotNullParameter(r4, "params");
        this.packageName = r2;
        this.action = r3;
        this.params = r4;
        this.intent = r5;
        this.type = r6;
        this.shortcutId = r7;
        this.interfaceName = r8;
        this.targetPkgName = r9;
        this.logPb = r10;
        this.implClassName = r11;
    }

    public /* synthetic */ AppAction(String r15, String r16, String r17, String r18, int r19, String r20, String r21, String r22, String r23, String r24, int r25, DefaultConstructorMarker r26) {
        if ((r25 & 8) == 0) goto L5;
        String r7 = null;
    L7:
        if ((r25 & 16) == 0) goto L9;
        ToolType r1 = ToolType.APP;
        int r8 = 1;
    L11:
        if ((r25 & 32) == 0) goto L13;
        String r9 = null;
    L15:
        if ((r25 & 64) == 0) goto L17;
        String r10 = null;
    L19:
        if ((r25 & 128) == 0) goto L21;
        String r11 = null;
    L23:
        if ((r25 & 256) == 0) goto L25;
        String r12 = null;
    L27:
        if ((r25 & 512) == 0) goto L29;
        String r13 = null;
    L30:
        this(r15, r16, r17, r7, r8, r9, r10, r11, r12, r13);
        return;
    L29:
        r13 = r24;
        goto L30
    L25:
        r12 = r23;
        goto L27
    L21:
        r11 = r22;
        goto L23
    L17:
        r10 = r21;
        goto L19
    L13:
        r9 = r20;
        goto L15
    L9:
        r8 = r19;
        goto L11
    L5:
        r7 = r18;
        goto L7
    }

    public static /* synthetic */ AppAction copy$default(AppAction r11, String r12, String r13, String r14, String r15, int r16, String r17, String r18, String r19, String r20, String r21, int r22, Object r23) {
        if ((r22 & 1) == 0) goto L5;
        String r2 = r11.packageName;
    L7:
        if ((r22 & 2) == 0) goto L9;
        String r3 = r11.action;
    L11:
        if ((r22 & 4) == 0) goto L13;
        String r4 = r11.params;
    L15:
        if ((r22 & 8) == 0) goto L17;
        String r5 = r11.intent;
    L19:
        if ((r22 & 16) == 0) goto L21;
        int r6 = r11.type;
    L23:
        if ((r22 & 32) == 0) goto L25;
        String r7 = r11.shortcutId;
    L27:
        if ((r22 & 64) == 0) goto L29;
        String r8 = r11.interfaceName;
    L31:
        if ((r22 & 128) == 0) goto L33;
        String r9 = r11.targetPkgName;
    L35:
        if ((r22 & 256) == 0) goto L37;
        String r10 = r11.logPb;
    L39:
        if ((r22 & 512) == 0) goto L41;
        String r1 = r11.implClassName;
    L43:
        return r11.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r1);
    L41:
        r1 = r21;
        goto L43
    L37:
        r10 = r20;
        goto L39
    L33:
        r9 = r19;
        goto L35
    L29:
        r8 = r18;
        goto L31
    L25:
        r7 = r17;
        goto L27
    L21:
        r6 = r16;
        goto L23
    L17:
        r5 = r15;
        goto L19
    L13:
        r4 = r14;
        goto L15
    L9:
        r3 = r13;
        goto L11
    L5:
        r2 = r12;
        goto L7
    }

    public final String component1() {
        return this.packageName;
    }

    public final String component10() {
        return this.implClassName;
    }

    public final String component2() {
        return this.action;
    }

    public final String component3() {
        return this.params;
    }

    public final String component4() {
        return this.intent;
    }

    public final int component5() {
        return this.type;
    }

    public final String component6() {
        return this.shortcutId;
    }

    public final String component7() {
        return this.interfaceName;
    }

    public final String component8() {
        return this.targetPkgName;
    }

    public final String component9() {
        return this.logPb;
    }

    public final AppAction copy(String r13, String r14, String r15, String r16, int r17, String r18, String r19, String r20, String r21, String r22) {
        Intrinsics.checkNotNullParameter(r13, NotificationDisplayDetailsActivity.EXTRA_PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(r14, "action");
        Intrinsics.checkNotNullParameter(r15, "params");
        return new AppAction(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof AppAction) == true) goto L8;
        return false;
    L8:
        AppAction r6 = (AppAction) r5;
        if (Intrinsics.areEqual(this.packageName, r6.packageName) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.action, r6.action) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.params, r6.params) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.intent, r6.intent) == true) goto L21;
        return false;
    L21:
        if (this.type == r6.type) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.shortcutId, r6.shortcutId) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.interfaceName, r6.interfaceName) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.targetPkgName, r6.targetPkgName) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.logPb, r6.logPb) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.implClassName, r6.implClassName) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public final String getAction() {
        return this.action;
    }

    public final String getImplClassName() {
        return this.implClassName;
    }

    public final String getIntent() {
        return this.intent;
    }

    public final String getInterfaceName() {
        return this.interfaceName;
    }

    public final String getLogPb() {
        return this.logPb;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final String getParams() {
        return this.params;
    }

    public final String getShortcutId() {
        return this.shortcutId;
    }

    public final String getTargetPkgName() {
        return this.targetPkgName;
    }

    public final int getType() {
        return this.type;
    }

    public int hashCode() {
        int r0 = ((((this.packageName.hashCode() * 31) + this.action.hashCode()) * 31) + this.params.hashCode()) * 31;
        String r1 = this.intent;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (((r0 + r3) * 31) + Integer.hashCode(this.type)) * 31;
        String r5 = this.shortcutId;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        String r8 = this.interfaceName;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        String r11 = this.targetPkgName;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (r10 + r12) * 31;
        String r14 = this.logPb;
        if (r14 != null) goto L21;
        int r15 = 0;
    L22:
        int r16 = (r13 + r15) * 31;
        String r17 = this.implClassName;
        if (r17 == null) goto L27;
        r2 = r17.hashCode();
    L27:
        return r16 + r2;
    L21:
        r15 = r14.hashCode();
        goto L22
    L17:
        r12 = r11.hashCode();
        goto L18
    L13:
        r9 = r8.hashCode();
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final void setParams(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.params = r2;
    }

    public String toString() {
        return "AppAction(packageName=" + this.packageName + ", action=" + this.action + ", params=" + this.params + ", intent=" + this.intent + ", type=" + this.type + ", shortcutId=" + this.shortcutId + ", interfaceName=" + this.interfaceName + ", targetPkgName=" + this.targetPkgName + ", logPb=" + this.logPb + ", implClassName=" + this.implClassName + ')';
    }
}
