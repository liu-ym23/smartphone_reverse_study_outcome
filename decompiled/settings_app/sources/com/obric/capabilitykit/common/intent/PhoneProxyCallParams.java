package com.obric.capabilitykit.common.intent;

import android.icu.text.PluralRules;
import android.os.Parcel;
import android.os.Parcelable;
import com.android.launcher3.icons.cache.BaseIconCache;
import com.obric.matrix.platform.sdk.ones.account.AccountConst;
import com.obric.versionedparcelable.ParcelUtils;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PhoneProxyCallParams.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b&\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B_\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\rJ\u0010\u0010$\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0016\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u000b\u0010&\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0007HÆ\u0003Jh\u0010+\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010,J\t\u0010-\u001a\u00020.HÖ\u0001J\u0013\u0010/\u001a\u00020\u00042\b\u00100\u001a\u0004\u0018\u000101HÖ\u0003J\t\u00102\u001a\u00020.HÖ\u0001J\b\u00103\u001a\u00020\u0004H\u0016J\u0012\u00104\u001a\u00020\u00012\b\u00105\u001a\u0004\u0018\u000101H\u0016J\t\u00106\u001a\u00020\u0007HÖ\u0001J\u0019\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020.HÖ\u0001R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0014\"\u0004\b\u0018\u0010\u0016R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0014\"\u0004\b\u001a\u0010\u0016R$\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0014\"\u0004\b!\u0010\u0016R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0014\"\u0004\b#\u0010\u0016¨\u0006<"}, d2 = {"Lcom/obric/capabilitykit/common/intent/PhoneProxyCallParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "canInterruptCall", "", "option", "", "", AccountConst.KEY_PHONE_NUMBER, "name", "firstSentence", "targetPhoneNumber", "ext", "(Ljava/lang/Boolean;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCanInterruptCall", "()Ljava/lang/Boolean;", "setCanInterruptCall", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getExt", "()Ljava/lang/String;", "setExt", "(Ljava/lang/String;)V", "getFirstSentence", "setFirstSentence", "getName", "setName", "getOption", "()[Ljava/lang/String;", "setOption", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "getPhoneNumber", "setPhoneNumber", "getTargetPhoneNumber", "setTargetPhoneNumber", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/Boolean;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/obric/capabilitykit/common/intent/PhoneProxyCallParams;", "describeContents", "", "equals", PluralRules.KEYWORD_OTHER, "", "hashCode", "isParamsCompleted", "mergeParams", "params", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", BaseIconCache.IconDB.COLUMN_FLAGS, "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PhoneProxyCallParams implements IntentParams, Parcelable {
    public static final Parcelable.Creator<PhoneProxyCallParams> CREATOR = null;
    private Boolean canInterruptCall;
    private String ext;
    private String firstSentence;
    private String name;
    private String[] option;
    private String phoneNumber;
    private String targetPhoneNumber;

    /* JADX INFO: compiled from: PhoneProxyCallParams.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<PhoneProxyCallParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PhoneProxyCallParams createFromParcel(Parcel r13) {
            int r0 = r13.readInt();
            Intrinsics.checkNotNullParameter(r13, "parcel");
            int r11 = 1;
            if (r13.readInt() != 0) goto L7;
            Boolean r2 = null;
        L11:
            PhoneProxyCallParams r1 = new PhoneProxyCallParams(r2, r13.createStringArray(), r13.readString(), r13.readString(), r13.readString(), r13.readString(), r13.readString());
            int r3 = Math.min(r0, 0);
            ClassLoader r12 = getClass().getClassLoader();
        L12:
            if (r11 > r3) goto L14;
            r11 = r11 + 1;
        L14:
            if (r11 > r0) goto L16;
            ParcelUtils.skipValueSafely(r13, r12);
            r11 = r11 + 1;
            goto L14
        L16:
            return r1;
        L7:
            if (r13.readInt() == 0) goto L9;
            boolean r4 = true;
        L10:
            r2 = Boolean.valueOf(r4);
            goto L11
        L9:
            r4 = false;
            goto L10
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ PhoneProxyCallParams createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PhoneProxyCallParams[] newArray(int r1) {
            return new PhoneProxyCallParams[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ PhoneProxyCallParams[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = new Creator();
    }

    public PhoneProxyCallParams() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public static /* synthetic */ PhoneProxyCallParams copy$default(PhoneProxyCallParams r5, Boolean r6, String[] r7, String r8, String r9, String r10, String r11, String r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r6 = r5.canInterruptCall;
    L6:
        if ((r13 & 2) == 0) goto L8;
        r7 = r5.option;
    L8:
        String[] r15 = r7;
        if ((r13 & 4) == 0) goto L11;
        r8 = r5.phoneNumber;
    L11:
        String r0 = r8;
        if ((r13 & 8) == 0) goto L14;
        r9 = r5.name;
    L14:
        String r1 = r9;
        if ((r13 & 16) == 0) goto L17;
        r10 = r5.firstSentence;
    L17:
        String r2 = r10;
        if ((r13 & 32) == 0) goto L20;
        r11 = r5.targetPhoneNumber;
    L20:
        String r3 = r11;
        if ((r13 & 64) == 0) goto L23;
        r12 = r5.ext;
    L23:
        Boolean r16 = r6;
        return r5.copy(r16, r15, r0, r1, r2, r3, r12);
    }

    public final Boolean component1() {
        return this.canInterruptCall;
    }

    public final String[] component2() {
        return this.option;
    }

    public final String component3() {
        return this.phoneNumber;
    }

    public final String component4() {
        return this.name;
    }

    public final String component5() {
        return this.firstSentence;
    }

    public final String component6() {
        return this.targetPhoneNumber;
    }

    public final String component7() {
        return this.ext;
    }

    public final PhoneProxyCallParams copy(Boolean r9, String[] r10, String r11, String r12, String r13, String r14, String r15) {
        return new PhoneProxyCallParams(r9, r10, r11, r12, r13, r14, r15);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof PhoneProxyCallParams) == true) goto L8;
        return false;
    L8:
        PhoneProxyCallParams r6 = (PhoneProxyCallParams) r5;
        if (Intrinsics.areEqual(this.canInterruptCall, r6.canInterruptCall) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.option, r6.option) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.phoneNumber, r6.phoneNumber) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.name, r6.name) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.firstSentence, r6.firstSentence) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.targetPhoneNumber, r6.targetPhoneNumber) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.ext, r6.ext) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        Boolean r0 = this.canInterruptCall;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String[] r4 = this.option;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.phoneNumber;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.name;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.firstSentence;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.targetPhoneNumber;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        String r19 = this.ext;
        if (r19 == null) goto L31;
        r1 = r19.hashCode();
    L31:
        return r18 + r1;
    L25:
        r17 = r16.hashCode();
        goto L26
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = Arrays.hashCode(r4);
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "PhoneProxyCallParams(canInterruptCall=" + this.canInterruptCall + ", option=" + Arrays.toString(this.option) + ", phoneNumber=" + this.phoneNumber + ", name=" + this.name + ", firstSentence=" + this.firstSentence + ", targetPhoneNumber=" + this.targetPhoneNumber + ", ext=" + this.ext + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [android.os.Parcel, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v4, types: [int] */
    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r2, int r3) {
        ?? r4 = 0;
        r2.writeInt(0);
        Intrinsics.checkNotNullParameter(r2, "out");
        Boolean r0 = this.canInterruptCall;
        if (r0 != null) goto L5;
    L4:
        r2.writeInt(r4);
        r2.writeStringArray(this.option);
        r2.writeString(this.phoneNumber);
        r2.writeString(this.name);
        r2.writeString(this.firstSentence);
        r2.writeString(this.targetPhoneNumber);
        r2.writeString(this.ext);
        return;
    L5:
        r2.writeInt(1);
        r4 = r0.booleanValue();
        goto L4
    }

    public PhoneProxyCallParams(Boolean r1, String[] r2, String r3, String r4, String r5, String r6, String r7) {
        this.canInterruptCall = r1;
        this.option = r2;
        this.phoneNumber = r3;
        this.name = r4;
        this.firstSentence = r5;
        this.targetPhoneNumber = r6;
        this.ext = r7;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public String getSubActionValue() {
        return IntentParams.DefaultImpls.getSubActionValue(this);
    }

    public /* synthetic */ PhoneProxyCallParams(Boolean r2, String[] r3, String r4, String r5, String r6, String r7, String r8, int r9, DefaultConstructorMarker r10) {
        if ((r9 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r9 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r9 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r9 & 8) == 0) goto L15;
        r5 = null;
    L15:
        if ((r9 & 16) == 0) goto L18;
        r6 = null;
    L18:
        if ((r9 & 32) == 0) goto L21;
        r7 = null;
    L21:
        if ((r9 & 64) == 0) goto L23;
        r8 = null;
    L23:
        this(r2, r3, r4, r5, r6, r7, r8);
    }

    public final Boolean getCanInterruptCall() {
        return this.canInterruptCall;
    }

    public final void setCanInterruptCall(Boolean r1) {
        this.canInterruptCall = r1;
    }

    public final String[] getOption() {
        return this.option;
    }

    public final void setOption(String[] r1) {
        this.option = r1;
    }

    public final String getPhoneNumber() {
        return this.phoneNumber;
    }

    public final void setPhoneNumber(String r1) {
        this.phoneNumber = r1;
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String r1) {
        this.name = r1;
    }

    public final String getFirstSentence() {
        return this.firstSentence;
    }

    public final void setFirstSentence(String r1) {
        this.firstSentence = r1;
    }

    public final String getTargetPhoneNumber() {
        return this.targetPhoneNumber;
    }

    public final void setTargetPhoneNumber(String r1) {
        this.targetPhoneNumber = r1;
    }

    public final String getExt() {
        return this.ext;
    }

    public final void setExt(String r1) {
        this.ext = r1;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public boolean isParamsCompleted() {
        if (this.option != null) goto L5;
    L7:
        return false;
    L5:
        if (this.phoneNumber == null) goto L7;
        return true;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public IntentParams mergeParams(Object r10) {
        if ((r10 instanceof PhoneProxyCallParams) == false) goto L5;
        Boolean r0 = this.canInterruptCall;
        if (r0 != null) goto L9;
        r0 = ((PhoneProxyCallParams) r10).canInterruptCall;
    L9:
        Boolean r2 = r0;
        String[] r1 = this.option;
        if (r1 != null) goto L12;
        r1 = ((PhoneProxyCallParams) r10).option;
    L12:
        String[] r3 = r1;
        String r4 = this.phoneNumber;
        if (r4 != null) goto L15;
        r4 = ((PhoneProxyCallParams) r10).phoneNumber;
    L15:
        String r5 = r4;
        String r6 = this.name;
        if (r6 != null) goto L18;
        r6 = ((PhoneProxyCallParams) r10).name;
    L18:
        String r7 = r6;
        String r8 = this.firstSentence;
        if (r8 != null) goto L21;
        r8 = ((PhoneProxyCallParams) r10).firstSentence;
    L21:
        String r9 = r8;
        String r11 = this.targetPhoneNumber;
        if (r11 != null) goto L24;
        r11 = ((PhoneProxyCallParams) r10).targetPhoneNumber;
    L24:
        String r12 = r11;
        String r13 = this.ext;
        if (r13 != null) goto L28;
        r13 = ((PhoneProxyCallParams) r10).ext;
    L28:
        return new PhoneProxyCallParams(r2, r3, r5, r7, r9, r12, r13);
    L5:
        return this;
    }
}
