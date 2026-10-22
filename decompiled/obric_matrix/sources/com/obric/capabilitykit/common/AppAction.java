package com.obric.capabilitykit.common;

import com.bytedance.common.wschannel.WsConstants;
import com.google.gson.y.c;
import kotlin.Metadata;
import kotlin.n0.d.g;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\bHÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003JI\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\bHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001f"}, d2 = {"Lcom/obric/capabilitykit/common/AppAction;", "", "packageName", "", "action", "params", "intent", WsConstants.KEY_CONNECTION_TYPE, "", "shortcutId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "getAction", "()Ljava/lang/String;", "getIntent", "getPackageName", "getParams", "getShortcutId", "getType", "()I", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AppAction {

    @c("OperationId")
    private final String action;

    @c("Intent")
    private final String intent;

    @c("Package")
    private final String packageName;

    @c("Params")
    private final String params;

    @c("ShortcutId")
    private final String shortcutId;

    @c("LocalToolType")
    private final int type;

    public AppAction(String r2, String r3, String r4, String r5, int r6, String r7) {
        o.f(r2, "packageName");
        o.f(r3, "action");
        o.f(r4, "params");
        this.packageName = r2;
        this.action = r3;
        this.params = r4;
        this.intent = r5;
        this.type = r6;
        this.shortcutId = r7;
    }

    public /* synthetic */ AppAction(String r10, String r11, String r12, String r13, int r14, String r15, int r16, g r17) {
        if ((r16 & 8) == 0) goto L5;
        String r6 = null;
    L7:
        if ((r16 & 16) == 0) goto L9;
        int r7 = ToolType.APP.ordinal();
    L11:
        if ((r16 & 32) == 0) goto L13;
        String r8 = null;
    L14:
        this(r10, r11, r12, r6, r7, r8);
        return;
    L13:
        r8 = r15;
        goto L14
    L9:
        r7 = r14;
        goto L11
    L5:
        r6 = r13;
        goto L7
    }

    public static /* synthetic */ AppAction copy$default(AppAction r4, String r5, String r6, String r7, String r8, int r9, String r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = r4.packageName;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = r4.action;
    L8:
        String r13 = r6;
        if ((r11 & 4) == 0) goto L11;
        r7 = r4.params;
    L11:
        String r0 = r7;
        if ((r11 & 8) == 0) goto L14;
        r8 = r4.intent;
    L14:
        String r1 = r8;
        if ((r11 & 16) == 0) goto L17;
        r9 = r4.type;
    L17:
        int r2 = r9;
        if ((r11 & 32) == 0) goto L20;
        r10 = r4.shortcutId;
    L20:
        String r14 = r5;
        return r4.copy(r14, r13, r0, r1, r2, r10);
    }

    public final String component1() {
        return this.packageName;
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

    public final AppAction copy(String r8, String r9, String r10, String r11, int r12, String r13) {
        o.f(r8, "packageName");
        o.f(r9, "action");
        o.f(r10, "params");
        return new AppAction(r8, r9, r10, r11, r12, r13);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof AppAction) == true) goto L8;
        return false;
    L8:
        AppAction r6 = (AppAction) r5;
        if (o.a(this.packageName, r6.packageName) == true) goto L12;
        return false;
    L12:
        if (o.a(this.action, r6.action) == true) goto L15;
        return false;
    L15:
        if (o.a(this.params, r6.params) == true) goto L18;
        return false;
    L18:
        if (o.a(this.intent, r6.intent) == true) goto L21;
        return false;
    L21:
        if (this.type == r6.type) goto L24;
        return false;
    L24:
        if (o.a(this.shortcutId, r6.shortcutId) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final String getAction() {
        return this.action;
    }

    public final String getIntent() {
        return this.intent;
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
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return r4 + r2;
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "AppAction(packageName=" + this.packageName + ", action=" + this.action + ", params=" + this.params + ", intent=" + this.intent + ", type=" + this.type + ", shortcutId=" + this.shortcutId + ')';
    }
}
