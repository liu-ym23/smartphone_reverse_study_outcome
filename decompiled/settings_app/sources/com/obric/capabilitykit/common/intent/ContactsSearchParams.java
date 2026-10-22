package com.obric.capabilitykit.common.intent;

import android.icu.text.PluralRules;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.app.NotificationCompat;
import com.android.launcher3.icons.cache.BaseIconCache;
import com.android.settings.search.IndexDatabaseHelper;
import com.obric.versionedparcelable.ParcelUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ContactsSearchParams.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\"\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002Be\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rJ\u000b\u0010#\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010*\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u0019Jn\u0010+\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0002\u0010,J\t\u0010-\u001a\u00020\fHÖ\u0001J\u0013\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u000101HÖ\u0003J\t\u00102\u001a\u00020\fHÖ\u0001J\u0012\u00103\u001a\u00020\u00012\b\u00104\u001a\u0004\u0018\u000101H\u0016J\t\u00105\u001a\u00020\u0004HÖ\u0001J\u0019\u00106\u001a\u0002072\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\fHÖ\u0001R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001c\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u000f\"\u0004\b\u001e\u0010\u0011R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u000f\"\u0004\b \u0010\u0011R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u000f\"\u0004\b\"\u0010\u0011¨\u0006;"}, d2 = {"Lcom/obric/capabilitykit/common/intent/ContactsSearchParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", IndexDatabaseHelper.SavedQueriesColums.QUERY, "", "contactName", "telephone", "telephoneType", "company", NotificationCompat.CATEGORY_EMAIL, "content", "maxCount", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getCompany", "()Ljava/lang/String;", "setCompany", "(Ljava/lang/String;)V", "getContactName", "setContactName", "getContent", "setContent", "getEmail", "setEmail", "getMaxCount", "()Ljava/lang/Integer;", "setMaxCount", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getQuery", "setQuery", "getTelephone", "setTelephone", "getTelephoneType", "setTelephoneType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/obric/capabilitykit/common/intent/ContactsSearchParams;", "describeContents", "equals", "", PluralRules.KEYWORD_OTHER, "", "hashCode", "mergeParams", "params", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", BaseIconCache.IconDB.COLUMN_FLAGS, "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ContactsSearchParams implements IntentParams, Parcelable {
    public static final Parcelable.Creator<ContactsSearchParams> CREATOR = null;
    private String company;
    private String contactName;
    private String content;
    private String email;
    private Integer maxCount;
    private String query;
    private String telephone;
    private String telephoneType;

    /* JADX INFO: compiled from: ContactsSearchParams.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ContactsSearchParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ContactsSearchParams createFromParcel(Parcel r12) {
            int r0 = r12.readInt();
            Intrinsics.checkNotNullParameter(r12, "parcel");
            String r3 = r12.readString();
            String r4 = r12.readString();
            String r5 = r12.readString();
            String r6 = r12.readString();
            String r7 = r12.readString();
            String r8 = r12.readString();
            String r9 = r12.readString();
            if (r12.readInt() != 0) goto L5;
            Integer r2 = null;
        L6:
            ContactsSearchParams r1 = new ContactsSearchParams(r3, r4, r5, r6, r7, r8, r9, r2);
            int r10 = Math.min(r0, 0);
            ClassLoader r11 = getClass().getClassLoader();
            int r13 = 1;
        L7:
            if (r13 > r10) goto L9;
            r13 = r13 + 1;
        L9:
            if (r13 > r0) goto L11;
            ParcelUtils.skipValueSafely(r12, r11);
            r13 = r13 + 1;
            goto L9
        L11:
            return r1;
        L5:
            r2 = Integer.valueOf(r12.readInt());
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ContactsSearchParams createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ContactsSearchParams[] newArray(int r1) {
            return new ContactsSearchParams[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ContactsSearchParams[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = new Creator();
    }

    public ContactsSearchParams() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    public static /* synthetic */ ContactsSearchParams copy$default(ContactsSearchParams r9, String r10, String r11, String r12, String r13, String r14, String r15, String r16, Integer r17, int r18, Object r19) {
        if ((r18 & 1) == 0) goto L5;
        String r2 = r9.query;
    L7:
        if ((r18 & 2) == 0) goto L9;
        String r3 = r9.contactName;
    L11:
        if ((r18 & 4) == 0) goto L13;
        String r4 = r9.telephone;
    L15:
        if ((r18 & 8) == 0) goto L17;
        String r5 = r9.telephoneType;
    L19:
        if ((r18 & 16) == 0) goto L21;
        String r6 = r9.company;
    L23:
        if ((r18 & 32) == 0) goto L25;
        String r7 = r9.email;
    L27:
        if ((r18 & 64) == 0) goto L29;
        String r8 = r9.content;
    L31:
        if ((r18 & 128) == 0) goto L33;
        Integer r1 = r9.maxCount;
    L35:
        return r9.copy(r2, r3, r4, r5, r6, r7, r8, r1);
    L33:
        r1 = r17;
        goto L35
    L29:
        r8 = r16;
        goto L31
    L25:
        r7 = r15;
        goto L27
    L21:
        r6 = r14;
        goto L23
    L17:
        r5 = r13;
        goto L19
    L13:
        r4 = r12;
        goto L15
    L9:
        r3 = r11;
        goto L11
    L5:
        r2 = r10;
        goto L7
    }

    public final String component1() {
        return this.query;
    }

    public final String component2() {
        return this.contactName;
    }

    public final String component3() {
        return this.telephone;
    }

    public final String component4() {
        return this.telephoneType;
    }

    public final String component5() {
        return this.company;
    }

    public final String component6() {
        return this.email;
    }

    public final String component7() {
        return this.content;
    }

    public final Integer component8() {
        return this.maxCount;
    }

    public final ContactsSearchParams copy(String r11, String r12, String r13, String r14, String r15, String r16, String r17, Integer r18) {
        return new ContactsSearchParams(r11, r12, r13, r14, r15, r16, r17, r18);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ContactsSearchParams) == true) goto L8;
        return false;
    L8:
        ContactsSearchParams r6 = (ContactsSearchParams) r5;
        if (Intrinsics.areEqual(this.query, r6.query) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.contactName, r6.contactName) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.telephone, r6.telephone) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.telephoneType, r6.telephoneType) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.company, r6.company) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.email, r6.email) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.content, r6.content) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.maxCount, r6.maxCount) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public int hashCode() {
        String r0 = this.query;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.contactName;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.telephone;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.telephoneType;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.company;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.email;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        String r19 = this.content;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        Integer r22 = this.maxCount;
        if (r22 == null) goto L35;
        r1 = r22.hashCode();
    L35:
        return r21 + r1;
    L29:
        r20 = r19.hashCode();
        goto L30
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
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "ContactsSearchParams(query=" + this.query + ", contactName=" + this.contactName + ", telephone=" + this.telephone + ", telephoneType=" + this.telephoneType + ", company=" + this.company + ", email=" + this.email + ", content=" + this.content + ", maxCount=" + this.maxCount + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r2, int r3) {
        r2.writeInt(0);
        Intrinsics.checkNotNullParameter(r2, "out");
        r2.writeString(this.query);
        r2.writeString(this.contactName);
        r2.writeString(this.telephone);
        r2.writeString(this.telephoneType);
        r2.writeString(this.company);
        r2.writeString(this.email);
        r2.writeString(this.content);
        Integer r1 = this.maxCount;
        if (r1 != null) goto L5;
        r2.writeInt(0);
        return;
    L5:
        r2.writeInt(1);
        r2.writeInt(r1.intValue());
    }

    public ContactsSearchParams(String r1, String r2, String r3, String r4, String r5, String r6, String r7, Integer r8) {
        this.query = r1;
        this.contactName = r2;
        this.telephone = r3;
        this.telephoneType = r4;
        this.company = r5;
        this.email = r6;
        this.content = r7;
        this.maxCount = r8;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public String getSubActionValue() {
        return IntentParams.DefaultImpls.getSubActionValue(this);
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public boolean isParamsCompleted() {
        return IntentParams.DefaultImpls.isParamsCompleted(this);
    }

    public /* synthetic */ ContactsSearchParams(String r2, String r3, String r4, String r5, String r6, String r7, String r8, Integer r9, int r10, DefaultConstructorMarker r11) {
        if ((r10 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r10 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r10 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r10 & 8) == 0) goto L15;
        r5 = null;
    L15:
        if ((r10 & 16) == 0) goto L18;
        r6 = null;
    L18:
        if ((r10 & 32) == 0) goto L21;
        r7 = null;
    L21:
        if ((r10 & 64) == 0) goto L24;
        r8 = null;
    L24:
        if ((r10 & 128) == 0) goto L26;
        r9 = null;
    L26:
        this(r2, r3, r4, r5, r6, r7, r8, r9);
    }

    public final String getQuery() {
        return this.query;
    }

    public final void setQuery(String r1) {
        this.query = r1;
    }

    public final String getContactName() {
        return this.contactName;
    }

    public final void setContactName(String r1) {
        this.contactName = r1;
    }

    public final String getTelephone() {
        return this.telephone;
    }

    public final void setTelephone(String r1) {
        this.telephone = r1;
    }

    public final String getTelephoneType() {
        return this.telephoneType;
    }

    public final void setTelephoneType(String r1) {
        this.telephoneType = r1;
    }

    public final String getCompany() {
        return this.company;
    }

    public final void setCompany(String r1) {
        this.company = r1;
    }

    public final String getEmail() {
        return this.email;
    }

    public final void setEmail(String r1) {
        this.email = r1;
    }

    public final String getContent() {
        return this.content;
    }

    public final void setContent(String r1) {
        this.content = r1;
    }

    public final Integer getMaxCount() {
        return this.maxCount;
    }

    public final void setMaxCount(Integer r1) {
        this.maxCount = r1;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public IntentParams mergeParams(Object r11) {
        if ((r11 instanceof ContactsSearchParams) == false) goto L5;
        String r0 = this.query;
        if (r0 != null) goto L9;
        r0 = ((ContactsSearchParams) r11).query;
    L9:
        String r2 = r0;
        String r1 = this.contactName;
        if (r1 != null) goto L12;
        r1 = ((ContactsSearchParams) r11).contactName;
    L12:
        String r3 = r1;
        String r4 = this.telephone;
        if (r4 != null) goto L15;
        r4 = ((ContactsSearchParams) r11).telephone;
    L15:
        String r5 = r4;
        String r6 = this.telephoneType;
        if (r6 != null) goto L18;
        r6 = ((ContactsSearchParams) r11).telephoneType;
    L18:
        String r7 = r6;
        String r8 = this.company;
        if (r8 != null) goto L21;
        r8 = ((ContactsSearchParams) r11).company;
    L21:
        String r9 = r8;
        String r10 = this.email;
        if (r10 != null) goto L24;
        r10 = ((ContactsSearchParams) r11).email;
    L24:
        String r12 = r10;
        String r13 = this.content;
        if (r13 != null) goto L27;
        r13 = ((ContactsSearchParams) r11).content;
    L27:
        String r14 = r13;
        Integer r15 = this.maxCount;
        if (r15 != null) goto L31;
        r15 = ((ContactsSearchParams) r11).maxCount;
    L31:
        return new ContactsSearchParams(r2, r3, r5, r7, r9, r12, r14, r15);
    L5:
        return this;
    }
}
