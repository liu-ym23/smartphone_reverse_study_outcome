package com.obric.capabilitykit.common.intent;

import android.icu.text.PluralRules;
import android.os.Parcel;
import android.os.Parcelable;
import com.android.launcher3.icons.cache.BaseIconCache;
import com.obric.versionedparcelable.ParcelUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FinanceSearchStockParams.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002BA\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\tJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0004HÆ\u0003JE\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020\u001dHÖ\u0001J\u0012\u0010#\u001a\u00020\u00012\b\u0010$\u001a\u0004\u0018\u00010!H\u0016J\t\u0010%\u001a\u00020\u0004HÖ\u0001J\u0019\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u001dHÖ\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\rR\u001c\u0010\b\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\r¨\u0006+"}, d2 = {"Lcom/obric/capabilitykit/common/intent/FinanceSearchStockParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "date", "", "keywords", "ticker", "market", "type", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDate", "()Ljava/lang/String;", "setDate", "(Ljava/lang/String;)V", "getKeywords", "setKeywords", "getMarket", "setMarket", "getTicker", "setTicker", "getType", "setType", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "", "equals", "", PluralRules.KEYWORD_OTHER, "", "hashCode", "mergeParams", "params", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", BaseIconCache.IconDB.COLUMN_FLAGS, "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class FinanceSearchStockParams implements IntentParams, Parcelable {
    public static final Parcelable.Creator<FinanceSearchStockParams> CREATOR = null;
    private String date;
    private String keywords;
    private String market;
    private String ticker;
    private String type;

    /* JADX INFO: compiled from: FinanceSearchStockParams.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<FinanceSearchStockParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final FinanceSearchStockParams createFromParcel(Parcel r9) {
            int r0 = r9.readInt();
            Intrinsics.checkNotNullParameter(r9, "parcel");
            FinanceSearchStockParams r1 = new FinanceSearchStockParams(r9.readString(), r9.readString(), r9.readString(), r9.readString(), r9.readString());
            int r2 = Math.min(r0, 0);
            ClassLoader r8 = getClass().getClassLoader();
            int r3 = 1;
        L3:
            if (r3 > r2) goto L5;
            r3 = r3 + 1;
        L5:
            if (r3 > r0) goto L7;
            ParcelUtils.skipValueSafely(r9, r8);
            r3 = r3 + 1;
            goto L5
        L7:
            return r1;
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ FinanceSearchStockParams createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final FinanceSearchStockParams[] newArray(int r1) {
            return new FinanceSearchStockParams[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ FinanceSearchStockParams[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = new Creator();
    }

    public FinanceSearchStockParams() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ FinanceSearchStockParams copy$default(FinanceSearchStockParams r3, String r4, String r5, String r6, String r7, String r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.date;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.keywords;
    L8:
        String r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.ticker;
    L11:
        String r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.market;
    L14:
        String r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.type;
    L17:
        String r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    public final String component1() {
        return this.date;
    }

    public final String component2() {
        return this.keywords;
    }

    public final String component3() {
        return this.ticker;
    }

    public final String component4() {
        return this.market;
    }

    public final String component5() {
        return this.type;
    }

    public final FinanceSearchStockParams copy(String r7, String r8, String r9, String r10, String r11) {
        return new FinanceSearchStockParams(r7, r8, r9, r10, r11);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof FinanceSearchStockParams) == true) goto L8;
        return false;
    L8:
        FinanceSearchStockParams r6 = (FinanceSearchStockParams) r5;
        if (Intrinsics.areEqual(this.date, r6.date) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.keywords, r6.keywords) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.ticker, r6.ticker) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.market, r6.market) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.type, r6.type) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        String r0 = this.date;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.keywords;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.ticker;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.market;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.type;
        if (r13 == null) goto L23;
        r1 = r13.hashCode();
    L23:
        return r12 + r1;
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
        return "FinanceSearchStockParams(date=" + this.date + ", keywords=" + this.keywords + ", ticker=" + this.ticker + ", market=" + this.market + ", type=" + this.type + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeInt(0);
        Intrinsics.checkNotNullParameter(r1, "out");
        r1.writeString(this.date);
        r1.writeString(this.keywords);
        r1.writeString(this.ticker);
        r1.writeString(this.market);
        r1.writeString(this.type);
    }

    public FinanceSearchStockParams(String r1, String r2, String r3, String r4, String r5) {
        this.date = r1;
        this.keywords = r2;
        this.ticker = r3;
        this.market = r4;
        this.type = r5;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public String getSubActionValue() {
        return IntentParams.DefaultImpls.getSubActionValue(this);
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public boolean isParamsCompleted() {
        return IntentParams.DefaultImpls.isParamsCompleted(this);
    }

    public /* synthetic */ FinanceSearchStockParams(String r2, String r3, String r4, String r5, String r6, int r7, DefaultConstructorMarker r8) {
        if ((r7 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r7 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r7 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r7 & 8) == 0) goto L15;
        r5 = null;
    L15:
        if ((r7 & 16) == 0) goto L17;
        r6 = null;
    L17:
        this(r2, r3, r4, r5, r6);
    }

    public final String getDate() {
        return this.date;
    }

    public final void setDate(String r1) {
        this.date = r1;
    }

    public final String getKeywords() {
        return this.keywords;
    }

    public final void setKeywords(String r1) {
        this.keywords = r1;
    }

    public final String getTicker() {
        return this.ticker;
    }

    public final void setTicker(String r1) {
        this.ticker = r1;
    }

    public final String getMarket() {
        return this.market;
    }

    public final void setMarket(String r1) {
        this.market = r1;
    }

    public final String getType() {
        return this.type;
    }

    public final void setType(String r1) {
        this.type = r1;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public IntentParams mergeParams(Object r8) {
        if ((r8 instanceof FinanceSearchStockParams) == false) goto L5;
        String r0 = this.date;
        if (r0 != null) goto L9;
        r0 = ((FinanceSearchStockParams) r8).date;
    L9:
        String r2 = r0;
        String r1 = this.keywords;
        if (r1 != null) goto L12;
        r1 = ((FinanceSearchStockParams) r8).keywords;
    L12:
        String r3 = r1;
        String r4 = this.ticker;
        if (r4 != null) goto L15;
        r4 = ((FinanceSearchStockParams) r8).ticker;
    L15:
        String r5 = r4;
        String r6 = this.market;
        if (r6 != null) goto L18;
        r6 = ((FinanceSearchStockParams) r8).market;
    L18:
        String r7 = r6;
        String r9 = this.type;
        if (r9 != null) goto L22;
        r9 = ((FinanceSearchStockParams) r8).type;
    L22:
        return new FinanceSearchStockParams(r2, r3, r5, r7, r9);
    L5:
        return this;
    }
}
