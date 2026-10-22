package com.obric.oui.privacy;

import android.icu.text.PluralRules;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OPrivacySheetConfig.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b \n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0085\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000e¢\u0006\u0002\u0010\u0011J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u000eHÆ\u0003J\t\u0010\"\u001a\u00020\u000eHÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010%\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u000eHÆ\u0003J\u008d\u0001\u0010+\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u000eHÆ\u0001J\u0013\u0010,\u001a\u00020\u000e2\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010.\u001a\u00020/HÖ\u0001J\t\u00100\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0011\u0010\u000f\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0011\u0010\u0010\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001dR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0013¨\u00061"}, d2 = {"Lcom/obric/oui/privacy/OPrivacySheetConfig;", "", "appIconPackageName", "", "appName", "appDescription", "items", "", "Lcom/obric/oui/privacy/PrivacyItem;", "privacyPolicyText", "privacyPolicyLinkTexts", "agreeButtonText", "exitButtonText", "enableDim", "", "cancelable", "enableEnterAnim", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;ZZZ)V", "getAgreeButtonText", "()Ljava/lang/String;", "getAppDescription", "getAppIconPackageName", "getAppName", "getCancelable", "()Z", "getEnableDim", "getEnableEnterAnim", "getExitButtonText", "getItems", "()Ljava/util/List;", "getPrivacyPolicyLinkTexts", "getPrivacyPolicyText", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", PluralRules.KEYWORD_OTHER, "hashCode", "", "toString", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OPrivacySheetConfig {
    private final String agreeButtonText;
    private final String appDescription;
    private final String appIconPackageName;
    private final String appName;
    private final boolean cancelable;
    private final boolean enableDim;
    private final boolean enableEnterAnim;
    private final String exitButtonText;
    private final List<PrivacyItem> items;
    private final List<String> privacyPolicyLinkTexts;
    private final String privacyPolicyText;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OPrivacySheetConfig copy$default(OPrivacySheetConfig r12, String r13, String r14, String r15, List r16, String r17, List r18, String r19, String r20, boolean r21, boolean r22, boolean r23, int r24, Object r25) {
        if ((r24 & 1) == 0) goto L5;
        String r2 = r12.appIconPackageName;
    L7:
        if ((r24 & 2) == 0) goto L9;
        String r3 = r12.appName;
    L11:
        if ((r24 & 4) == 0) goto L13;
        String r4 = r12.appDescription;
    L15:
        if ((r24 & 8) == 0) goto L17;
        List r5 = r12.items;
    L19:
        if ((r24 & 16) == 0) goto L21;
        String r6 = r12.privacyPolicyText;
    L23:
        if ((r24 & 32) == 0) goto L25;
        List r7 = r12.privacyPolicyLinkTexts;
    L27:
        if ((r24 & 64) == 0) goto L29;
        String r8 = r12.agreeButtonText;
    L31:
        if ((r24 & 128) == 0) goto L33;
        String r9 = r12.exitButtonText;
    L35:
        if ((r24 & 256) == 0) goto L37;
        boolean r10 = r12.enableDim;
    L39:
        if ((r24 & 512) == 0) goto L41;
        boolean r11 = r12.cancelable;
    L43:
        if ((r24 & 1024) == 0) goto L45;
        boolean r1 = r12.enableEnterAnim;
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
        return this.appIconPackageName;
    }

    public final boolean component10() {
        return this.cancelable;
    }

    public final boolean component11() {
        return this.enableEnterAnim;
    }

    public final String component2() {
        return this.appName;
    }

    public final String component3() {
        return this.appDescription;
    }

    public final List<PrivacyItem> component4() {
        return this.items;
    }

    public final String component5() {
        return this.privacyPolicyText;
    }

    public final List<String> component6() {
        return this.privacyPolicyLinkTexts;
    }

    public final String component7() {
        return this.agreeButtonText;
    }

    public final String component8() {
        return this.exitButtonText;
    }

    public final boolean component9() {
        return this.enableDim;
    }

    public final OPrivacySheetConfig copy(String r14, String r15, String r16, List<? extends PrivacyItem> r17, String r18, List<String> r19, String r20, String r21, boolean r22, boolean r23, boolean r24) {
        Intrinsics.checkNotNullParameter(r15, "appName");
        Intrinsics.checkNotNullParameter(r17, "items");
        Intrinsics.checkNotNullParameter(r19, "privacyPolicyLinkTexts");
        return new OPrivacySheetConfig(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof OPrivacySheetConfig) == true) goto L8;
        return false;
    L8:
        OPrivacySheetConfig r6 = (OPrivacySheetConfig) r5;
        if (Intrinsics.areEqual(this.appIconPackageName, r6.appIconPackageName) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.appName, r6.appName) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.appDescription, r6.appDescription) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.items, r6.items) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.privacyPolicyText, r6.privacyPolicyText) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.privacyPolicyLinkTexts, r6.privacyPolicyLinkTexts) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.agreeButtonText, r6.agreeButtonText) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.exitButtonText, r6.exitButtonText) == true) goto L33;
        return false;
    L33:
        if (this.enableDim == r6.enableDim) goto L36;
        return false;
    L36:
        if (this.cancelable == r6.cancelable) goto L39;
        return false;
    L39:
        if (this.enableEnterAnim == r6.enableEnterAnim) goto L41;
        return false;
    L41:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v18, types: [int] */
    /* JADX WARN: Type inference failed for: r0v20, types: [int] */
    /* JADX WARN: Type inference failed for: r0v22, types: [int] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v17, types: [int] */
    /* JADX WARN: Type inference failed for: r2v18 */
    public int hashCode() {
        String r0 = this.appIconPackageName;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = ((r2 * 31) + this.appName.hashCode()) * 31;
        String r4 = this.appDescription;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (((r3 + r5) * 31) + this.items.hashCode()) * 31;
        String r7 = this.privacyPolicyText;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (((r6 + r8) * 31) + this.privacyPolicyLinkTexts.hashCode()) * 31;
        String r10 = this.agreeButtonText;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.exitButtonText;
        if (r13 == null) goto L22;
        r1 = r13.hashCode();
    L22:
        int r14 = (r12 + r1) * 31;
        boolean r15 = this.enableDim;
        ?? r16 = 1;
        ?? r17 = r15;
        if (r15 == false) goto L25;
        r17 = 1;
    L25:
        int r18 = (r14 + r17) * 31;
        boolean r19 = this.cancelable;
        ?? r20 = r19;
        if (r19 == false) goto L28;
        r20 = 1;
    L28:
        int r21 = (r18 + r20) * 31;
        boolean r22 = this.enableEnterAnim;
        if (r22 == true) goto L33;
        r16 = r22;
    L33:
        return r21 + r16;
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("OPrivacySheetConfig(appIconPackageName=");
        r0.append(this.appIconPackageName).append(", appName=").append(this.appName).append(", appDescription=").append(this.appDescription).append(", items=").append(this.items).append(", privacyPolicyText=").append(this.privacyPolicyText).append(", privacyPolicyLinkTexts=").append(this.privacyPolicyLinkTexts).append(", agreeButtonText=").append(this.agreeButtonText).append(", exitButtonText=").append(this.exitButtonText).append(", enableDim=").append(this.enableDim).append(", cancelable=").append(this.cancelable).append(", enableEnterAnim=").append(this.enableEnterAnim).append(')');
        return r0.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OPrivacySheetConfig(String r2, String r3, String r4, List<? extends PrivacyItem> r5, String r6, List<String> r7, String r8, String r9, boolean r10, boolean r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r3, "appName");
        Intrinsics.checkNotNullParameter(r5, "items");
        Intrinsics.checkNotNullParameter(r7, "privacyPolicyLinkTexts");
        this.appIconPackageName = r2;
        this.appName = r3;
        this.appDescription = r4;
        this.items = r5;
        this.privacyPolicyText = r6;
        this.privacyPolicyLinkTexts = r7;
        this.agreeButtonText = r8;
        this.exitButtonText = r9;
        this.enableDim = r10;
        this.cancelable = r11;
        this.enableEnterAnim = r12;
    }

    public final String getAppIconPackageName() {
        return this.appIconPackageName;
    }

    public final String getAppName() {
        return this.appName;
    }

    public final String getAppDescription() {
        return this.appDescription;
    }

    public final List<PrivacyItem> getItems() {
        return this.items;
    }

    public final String getPrivacyPolicyText() {
        return this.privacyPolicyText;
    }

    public /* synthetic */ OPrivacySheetConfig(String r16, String r17, String r18, List r19, String r20, List r21, String r22, String r23, boolean r24, boolean r25, boolean r26, int r27, DefaultConstructorMarker r28) {
        if ((r27 & 1) == 0) goto L5;
        String r4 = null;
    L7:
        if ((r27 & 4) == 0) goto L9;
        String r6 = null;
    L11:
        if ((r27 & 16) == 0) goto L13;
        String r8 = null;
    L15:
        if ((r27 & 32) == 0) goto L17;
        List r9 = CollectionsKt.emptyList();
    L19:
        if ((r27 & 64) == 0) goto L21;
        String r10 = null;
    L23:
        if ((r27 & 128) == 0) goto L25;
        String r11 = null;
    L27:
        if ((r27 & 256) == 0) goto L29;
        boolean r12 = false;
    L31:
        if ((r27 & 512) == 0) goto L33;
        boolean r13 = true;
    L35:
        if ((r27 & 1024) == 0) goto L37;
        boolean r14 = false;
    L38:
        this(r4, r17, r6, r19, r8, r9, r10, r11, r12, r13, r14);
        return;
    L37:
        r14 = r26;
        goto L38
    L33:
        r13 = r25;
        goto L35
    L29:
        r12 = r24;
        goto L31
    L25:
        r11 = r23;
        goto L27
    L21:
        r10 = r22;
        goto L23
    L17:
        r9 = r21;
        goto L19
    L13:
        r8 = r20;
        goto L15
    L9:
        r6 = r18;
        goto L11
    L5:
        r4 = r16;
        goto L7
    }

    public final List<String> getPrivacyPolicyLinkTexts() {
        return this.privacyPolicyLinkTexts;
    }

    public final String getAgreeButtonText() {
        return this.agreeButtonText;
    }

    public final String getExitButtonText() {
        return this.exitButtonText;
    }

    public final boolean getEnableDim() {
        return this.enableDim;
    }

    public final boolean getCancelable() {
        return this.cancelable;
    }

    public final boolean getEnableEnterAnim() {
        return this.enableEnterAnim;
    }
}
