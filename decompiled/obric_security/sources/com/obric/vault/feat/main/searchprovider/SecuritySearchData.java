package com.obric.vault.feat.main.searchprovider;

import com.bytedance.common.wschannel.WsConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SecuritySearchData.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b/\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0085\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0007\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000fJ\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0007HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00102\u001a\u00020\u0007HÆ\u0003J\u0089\u0001\u00103\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\f\u001a\u00020\u00072\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u00104\u001a\u00020\u00072\b\u00105\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00106\u001a\u000207HÖ\u0001J\t\u00108\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0011\"\u0004\b\u0017\u0010\u0013R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0011\"\u0004\b\u0019\u0010\u0013R\u001a\u0010\f\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u001a\"\u0004\b\u001d\u0010\u001cR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0011\"\u0004\b\u001f\u0010\u0013R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0011\"\u0004\b!\u0010\u0013R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0011\"\u0004\b#\u0010\u0013R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0011\"\u0004\b%\u0010\u0013R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0011\"\u0004\b'\u0010\u0013¨\u00069"}, d2 = {"Lcom/obric/vault/feat/main/searchprovider/SecuritySearchData;", "", "name", "", "intent", WsConstants.KEY_EXTRA, "isSwitch", "", "switchTable", "switchKey", "specialKey", "defValue", "isSearchable", "itemPath", "description", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;)V", "getDefValue", "()Ljava/lang/String;", "setDefValue", "(Ljava/lang/String;)V", "getDescription", "setDescription", "getExtra", "setExtra", "getIntent", "setIntent", "()Z", "setSearchable", "(Z)V", "setSwitch", "getItemPath", "setItemPath", "getName", "setName", "getSpecialKey", "setSpecialKey", "getSwitchKey", "setSwitchKey", "getSwitchTable", "setSwitchTable", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "toString", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class SecuritySearchData {
    private String defValue;
    private String description;
    private String extra;
    private String intent;
    private boolean isSearchable;
    private boolean isSwitch;
    private String itemPath;
    private String name;
    private String specialKey;
    private String switchKey;
    private String switchTable;

    public SecuritySearchData() {
        this(null, null, null, false, null, null, null, null, false, null, null, 2047, null);
    }

    public static /* synthetic */ SecuritySearchData copy$default(SecuritySearchData r12, String r13, String r14, String r15, boolean r16, String r17, String r18, String r19, String r20, boolean r21, String r22, String r23, int r24, Object r25) {
        if ((r24 & 1) == 0) goto L5;
        String r2 = r12.name;
    L7:
        if ((r24 & 2) == 0) goto L9;
        String r3 = r12.intent;
    L11:
        if ((r24 & 4) == 0) goto L13;
        String r4 = r12.extra;
    L15:
        if ((r24 & 8) == 0) goto L17;
        boolean r5 = r12.isSwitch;
    L19:
        if ((r24 & 16) == 0) goto L21;
        String r6 = r12.switchTable;
    L23:
        if ((r24 & 32) == 0) goto L25;
        String r7 = r12.switchKey;
    L27:
        if ((r24 & 64) == 0) goto L29;
        String r8 = r12.specialKey;
    L31:
        if ((r24 & 128) == 0) goto L33;
        String r9 = r12.defValue;
    L35:
        if ((r24 & 256) == 0) goto L37;
        boolean r10 = r12.isSearchable;
    L39:
        if ((r24 & 512) == 0) goto L41;
        String r11 = r12.itemPath;
    L43:
        if ((r24 & 1024) == 0) goto L45;
        String r1 = r12.description;
    L47:
        return r12.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r1);
    L45:
        r1 = r23;
        goto L47
    L41:
        r11 = r22;
        goto L43
    L37:
        r10 = r21;
        goto L39
    L33:
        r9 = r20;
        goto L35
    L29:
        r8 = r19;
        goto L31
    L25:
        r7 = r18;
        goto L27
    L21:
        r6 = r17;
        goto L23
    L17:
        r5 = r16;
        goto L19
    L13:
        r4 = r15;
        goto L15
    L9:
        r3 = r14;
        goto L11
    L5:
        r2 = r13;
        goto L7
    }

    public final String component1() {
        return this.name;
    }

    public final String component10() {
        return this.itemPath;
    }

    public final String component11() {
        return this.description;
    }

    public final String component2() {
        return this.intent;
    }

    public final String component3() {
        return this.extra;
    }

    public final boolean component4() {
        return this.isSwitch;
    }

    public final String component5() {
        return this.switchTable;
    }

    public final String component6() {
        return this.switchKey;
    }

    public final String component7() {
        return this.specialKey;
    }

    public final String component8() {
        return this.defValue;
    }

    public final boolean component9() {
        return this.isSearchable;
    }

    public final SecuritySearchData copy(String r14, String r15, String r16, boolean r17, String r18, String r19, String r20, String r21, boolean r22, String r23, String r24) {
        return new SecuritySearchData(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof SecuritySearchData) == false) goto L28;
        SecuritySearchData r4 = (SecuritySearchData) r3;
        if (Intrinsics.areEqual(this.name, r4.name) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.intent, r4.intent) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.extra, r4.extra) == true) goto L12;
        return false;
    L12:
        if (this.isSwitch == r4.isSwitch) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.switchTable, r4.switchTable) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.switchKey, r4.switchKey) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.specialKey, r4.specialKey) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.defValue, r4.defValue) == true) goto L22;
        return false;
    L22:
        if (this.isSearchable == r4.isSearchable) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.itemPath, r4.itemPath) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.description, r4.description) == true) goto L43;
        return false;
    L43:
        return true;
    L28:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r2v29 */
    /* JADX WARN: Type inference failed for: r2v32 */
    /* JADX WARN: Type inference failed for: r2v7, types: [int] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        String r0 = this.name;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.intent;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.extra;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        boolean r10 = this.isSwitch;
        ?? r11 = 1;
        ?? r12 = r10;
        if (r10 == false) goto L17;
        r12 = 1;
    L17:
        int r13 = (r9 + r12) * 31;
        String r14 = this.switchTable;
        if (r14 == null) goto L20;
        int r15 = r14.hashCode();
    L21:
        int r16 = (r13 + r15) * 31;
        String r17 = this.switchKey;
        if (r17 == null) goto L24;
        int r18 = r17.hashCode();
    L25:
        int r19 = (r16 + r18) * 31;
        String r20 = this.specialKey;
        if (r20 == null) goto L28;
        int r21 = r20.hashCode();
    L29:
        int r22 = (r19 + r21) * 31;
        String r23 = this.defValue;
        if (r23 == null) goto L32;
        int r24 = r23.hashCode();
    L33:
        int r25 = (r22 + r24) * 31;
        boolean r26 = this.isSearchable;
        if (r26 == true) goto L37;
        r11 = r26;
    L37:
        int r27 = (r25 + r11) * 31;
        String r28 = this.itemPath;
        if (r28 == null) goto L40;
        int r29 = r28.hashCode();
    L41:
        int r30 = (r27 + r29) * 31;
        String r31 = this.description;
        if (r31 == null) goto L45;
        r1 = r31.hashCode();
    L45:
        return r30 + r1;
    L40:
        r29 = 0;
        goto L41
    L32:
        r24 = 0;
        goto L33
    L28:
        r21 = 0;
        goto L29
    L24:
        r18 = 0;
        goto L25
    L20:
        r15 = 0;
        goto L21
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "SecuritySearchData(name=" + this.name + ", intent=" + this.intent + ", extra=" + this.extra + ", isSwitch=" + this.isSwitch + ", switchTable=" + this.switchTable + ", switchKey=" + this.switchKey + ", specialKey=" + this.specialKey + ", defValue=" + this.defValue + ", isSearchable=" + this.isSearchable + ", itemPath=" + this.itemPath + ", description=" + this.description + ")";
    }

    public SecuritySearchData(String r1, String r2, String r3, boolean r4, String r5, String r6, String r7, String r8, boolean r9, String r10, String r11) {
        this.name = r1;
        this.intent = r2;
        this.extra = r3;
        this.isSwitch = r4;
        this.switchTable = r5;
        this.switchKey = r6;
        this.specialKey = r7;
        this.defValue = r8;
        this.isSearchable = r9;
        this.itemPath = r10;
        this.description = r11;
    }

    public /* synthetic */ SecuritySearchData(String r13, String r14, String r15, boolean r16, String r17, String r18, String r19, String r20, boolean r21, String r22, String r23, int r24, DefaultConstructorMarker r25) {
        String r2 = null;
        if ((r24 & 1) == 0) goto L5;
        String r1 = (String) null;
        String r3 = null;
    L7:
        if ((r24 & 2) == 0) goto L9;
        String r4 = (String) null;
        String r5 = null;
    L11:
        if ((r24 & 4) == 0) goto L13;
        String r6 = (String) null;
        String r7 = null;
    L14:
        boolean r8 = false;
        if ((r24 & 8) == 0) goto L17;
        boolean r9 = false;
    L19:
        if ((r24 & 16) == 0) goto L21;
        String r10 = (String) null;
        String r11 = null;
    L23:
        if ((r24 & 32) == 0) goto L25;
        String r12 = (String) null;
        String r26 = null;
    L27:
        if ((r24 & 64) == 0) goto L29;
        String r27 = (String) null;
        String r28 = null;
    L31:
        if ((r24 & 128) == 0) goto L33;
        String r110 = (String) null;
        String r111 = null;
    L35:
        if ((r24 & 256) != 0) goto L39;
        r8 = r21;
    L39:
        if ((r24 & 512) == 0) goto L41;
        String r112 = (String) null;
        String r113 = null;
    L43:
        if ((r24 & 1024) == 0) goto L45;
        String r0 = (String) null;
    L46:
        this(r3, r5, r7, r9, r11, r26, r28, r111, r8, r113, r2);
        return;
    L45:
        r2 = r23;
        goto L46
    L41:
        r113 = r22;
        goto L43
    L33:
        r111 = r20;
        goto L35
    L29:
        r28 = r19;
        goto L31
    L25:
        r26 = r18;
        goto L27
    L21:
        r11 = r17;
        goto L23
    L17:
        r9 = r16;
        goto L19
    L13:
        r7 = r15;
        goto L14
    L9:
        r5 = r14;
        goto L11
    L5:
        r3 = r13;
        goto L7
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String r1) {
        this.name = r1;
    }

    public final String getIntent() {
        return this.intent;
    }

    public final void setIntent(String r1) {
        this.intent = r1;
    }

    public final String getExtra() {
        return this.extra;
    }

    public final void setExtra(String r1) {
        this.extra = r1;
    }

    public final boolean isSwitch() {
        return this.isSwitch;
    }

    public final void setSwitch(boolean r1) {
        this.isSwitch = r1;
    }

    public final String getSwitchTable() {
        return this.switchTable;
    }

    public final void setSwitchTable(String r1) {
        this.switchTable = r1;
    }

    public final String getSwitchKey() {
        return this.switchKey;
    }

    public final void setSwitchKey(String r1) {
        this.switchKey = r1;
    }

    public final String getSpecialKey() {
        return this.specialKey;
    }

    public final void setSpecialKey(String r1) {
        this.specialKey = r1;
    }

    public final String getDefValue() {
        return this.defValue;
    }

    public final void setDefValue(String r1) {
        this.defValue = r1;
    }

    public final boolean isSearchable() {
        return this.isSearchable;
    }

    public final void setSearchable(boolean r1) {
        this.isSearchable = r1;
    }

    public final String getItemPath() {
        return this.itemPath;
    }

    public final void setItemPath(String r1) {
        this.itemPath = r1;
    }

    public final String getDescription() {
        return this.description;
    }

    public final void setDescription(String r1) {
        this.description = r1;
    }
}
