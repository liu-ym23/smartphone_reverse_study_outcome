package com.obric.capabilitykit.common.execution;

import android.icu.text.PluralRules;
import android.os.Parcel;
import android.os.Parcelable;
import com.android.launcher3.icons.cache.BaseIconCache;
import com.obric.versionedparcelable.ParcelUtils;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u001f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bq\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\f\u001a\u0004\u0018\u00010\t\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0001\u0012\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\u000f¢\u0006\u0002\u0010\u0010J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u0017\u0010$\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\u000fHÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\tHÆ\u0003J\t\u0010*\u001a\u00020\tHÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\tHÆ\u0003J\u008b\u0001\u0010-\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00012\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\u000fHÆ\u0001J\t\u0010.\u001a\u00020/HÖ\u0001J\u0013\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u000103HÖ\u0003J\t\u00104\u001a\u00020/HÖ\u0001J\t\u00105\u001a\u00020\tHÖ\u0001J\u0019\u00106\u001a\u0002072\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020/HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R,\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0013\u0010\f\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0018R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0012R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0012¨\u0006;"}, d2 = {"Lcom/obric/capabilitykit/common/execution/IntentCalling;", "Landroid/os/Parcelable;", "questionId", "", "messageId", "actionId", "jobId", "replyFor", "intentName", "", "implClassName", "inputParamTypeName", "inputParams", "inputParamsParcel", "ext", "", "(JJJJJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/os/Parcelable;Ljava/util/Map;)V", "getActionId", "()J", "getExt", "()Ljava/util/Map;", "setExt", "(Ljava/util/Map;)V", "getImplClassName", "()Ljava/lang/String;", "getInputParamTypeName", "getInputParams", "getInputParamsParcel", "()Landroid/os/Parcelable;", "getIntentName", "getJobId", "getMessageId", "getQuestionId", "getReplyFor", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "", "equals", "", PluralRules.KEYWORD_OTHER, "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", BaseIconCache.IconDB.COLUMN_FLAGS, "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class IntentCalling implements Parcelable {
    public static final Parcelable.Creator<IntentCalling> CREATOR = null;
    private final long actionId;
    public Map<String, String> ext;
    private final String implClassName;
    private final String inputParamTypeName;
    private final String inputParams;
    private final Parcelable inputParamsParcel;
    private final String intentName;
    private final long jobId;
    private final long messageId;
    private final long questionId;
    private final long replyFor;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class a implements Parcelable.Creator<IntentCalling> {
        public a() {
        }

        public final IntentCalling a(Parcel r22) {
            int r1 = r22.readInt();
            Intrinsics.checkNotNullParameter(r22, "parcel");
            long r4 = r22.readLong();
            long r6 = r22.readLong();
            long r8 = r22.readLong();
            long r10 = r22.readLong();
            long r12 = r22.readLong();
            String r14 = r22.readString();
            String r15 = r22.readString();
            String r16 = r22.readString();
            String r17 = r22.readString();
            Parcelable r18 = r22.readParcelable(IntentCalling.class.getClassLoader());
            if (r22.readInt() != 0) goto L5;
            int r20 = r1;
            LinkedHashMap r19 = null;
        L9:
            IntentCalling r0 = new IntentCalling(r4, r6, r8, r10, r12, r14, r15, r16, r17, r18, r19);
            int r2 = r20;
            int r3 = Math.min(r2, 1);
            ClassLoader r5 = a.class.getClassLoader();
            int r7 = 1;
        L11:
            if (r7 > r3) goto L17;
            if (r7 != 1) goto L16;
            Object r9 = ParcelUtils.readValueSafely(r22, r5);
            if (r9 == null) goto L16;
            r0.ext = (Map) r9;
        L16:
            r7 = r7 + 1;
        L17:
            if (r7 > r2) goto L19;
            ParcelUtils.skipValueSafely(r22, r5);
            r7 = r7 + 1;
            goto L17
        L19:
            return r0;
        L5:
            int r11 = r22.readInt();
            LinkedHashMap r13 = new LinkedHashMap(r11);
            int r21 = 0;
        L6:
            if (r21 == r11) goto L8;
            r13.put(r22.readString(), r22.readString());
            r21 = r21 + 1;
            r11 = r11;
            r1 = r1;
            goto L6
        L8:
            r20 = r1;
            r19 = r13;
            goto L9
        }

        public final IntentCalling[] a(int r1) {
            return new IntentCalling[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ IntentCalling createFromParcel(Parcel r1) {
            return a(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ IntentCalling[] newArray(int r1) {
            return a(r1);
        }
    }

    static {
        CREATOR = new a();
    }

    public IntentCalling(long r6, long r8, long r10, long r12, long r14, String r16, String r17, String r18, String r19, Parcelable r20, Map<String, String> r21) {
        Intrinsics.checkNotNullParameter(r16, "intentName");
        Intrinsics.checkNotNullParameter(r17, "implClassName");
        this.questionId = r6;
        this.messageId = r8;
        this.actionId = r10;
        this.jobId = r12;
        this.replyFor = r14;
        this.intentName = r16;
        this.implClassName = r17;
        this.inputParamTypeName = r18;
        this.inputParams = r19;
        this.inputParamsParcel = r20;
        this.ext = r21;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ IntentCalling copy$default(IntentCalling r16, long r17, long r19, long r21, long r23, long r25, String r27, String r28, String r29, String r30, Parcelable r31, Map r32, int r33, Object r34) {
        if ((r33 & 1) == 0) goto L5;
        long r2 = r16.questionId;
    L7:
        if ((r33 & 2) == 0) goto L9;
        long r4 = r16.messageId;
    L11:
        if ((r33 & 4) == 0) goto L13;
        long r6 = r16.actionId;
    L15:
        if ((r33 & 8) == 0) goto L17;
        long r8 = r16.jobId;
    L19:
        if ((r33 & 16) == 0) goto L21;
        long r10 = r16.replyFor;
    L23:
        if ((r33 & 32) == 0) goto L25;
        String r12 = r16.intentName;
    L27:
        if ((r33 & 64) == 0) goto L29;
        String r13 = r16.implClassName;
    L31:
        if ((r33 & 128) == 0) goto L33;
        String r14 = r16.inputParamTypeName;
    L35:
        if ((r33 & 256) == 0) goto L37;
        String r15 = r16.inputParams;
    L38:
        String r35 = r15;
        if ((r33 & 512) == 0) goto L41;
        Parcelable r18 = r16.inputParamsParcel;
    L43:
        if ((r33 & 1024) == 0) goto L45;
        Map r1 = r16.ext;
    L47:
        return r16.copy(r2, r4, r6, r8, r10, r12, r13, r14, r35, r18, r1);
    L45:
        r1 = r32;
        goto L47
    L41:
        r18 = r31;
        goto L43
    L37:
        r15 = r30;
        goto L38
    L33:
        r14 = r29;
        goto L35
    L29:
        r13 = r28;
        goto L31
    L25:
        r12 = r27;
        goto L27
    L21:
        r10 = r25;
        goto L23
    L17:
        r8 = r23;
        goto L19
    L13:
        r6 = r21;
        goto L15
    L9:
        r4 = r19;
        goto L11
    L5:
        r2 = r17;
        goto L7
    }

    public final long component1() {
        return this.questionId;
    }

    public final Parcelable component10() {
        return this.inputParamsParcel;
    }

    public final Map<String, String> component11() {
        return this.ext;
    }

    public final long component2() {
        return this.messageId;
    }

    public final long component3() {
        return this.actionId;
    }

    public final long component4() {
        return this.jobId;
    }

    public final long component5() {
        return this.replyFor;
    }

    public final String component6() {
        return this.intentName;
    }

    public final String component7() {
        return this.implClassName;
    }

    public final String component8() {
        return this.inputParamTypeName;
    }

    public final String component9() {
        return this.inputParams;
    }

    public final IntentCalling copy(long r19, long r21, long r23, long r25, long r27, String r29, String r30, String r31, String r32, Parcelable r33, Map<String, String> r34) {
        Intrinsics.checkNotNullParameter(r29, "intentName");
        Intrinsics.checkNotNullParameter(r30, "implClassName");
        return new IntentCalling(r19, r21, r23, r25, r27, r29, r30, r31, r32, r33, r34);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof IntentCalling) == true) goto L8;
        return false;
    L8:
        IntentCalling r9 = (IntentCalling) r8;
        if (this.questionId == r9.questionId) goto L12;
        return false;
    L12:
        if (this.messageId == r9.messageId) goto L15;
        return false;
    L15:
        if (this.actionId == r9.actionId) goto L18;
        return false;
    L18:
        if (this.jobId == r9.jobId) goto L21;
        return false;
    L21:
        if (this.replyFor == r9.replyFor) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.intentName, r9.intentName) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.implClassName, r9.implClassName) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.inputParamTypeName, r9.inputParamTypeName) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.inputParams, r9.inputParams) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.inputParamsParcel, r9.inputParamsParcel) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.ext, r9.ext) == true) goto L41;
        return false;
    L41:
        return true;
    }

    public final long getActionId() {
        return this.actionId;
    }

    public final Map<String, String> getExt() {
        return this.ext;
    }

    public final String getImplClassName() {
        return this.implClassName;
    }

    public final String getInputParamTypeName() {
        return this.inputParamTypeName;
    }

    public final String getInputParams() {
        return this.inputParams;
    }

    public final Parcelable getInputParamsParcel() {
        return this.inputParamsParcel;
    }

    public final String getIntentName() {
        return this.intentName;
    }

    public final long getJobId() {
        return this.jobId;
    }

    public final long getMessageId() {
        return this.messageId;
    }

    public final long getQuestionId() {
        return this.questionId;
    }

    public final long getReplyFor() {
        return this.replyFor;
    }

    public int hashCode() {
        int r0 = ((((((((((((Long.hashCode(this.questionId) * 31) + Long.hashCode(this.messageId)) * 31) + Long.hashCode(this.actionId)) * 31) + Long.hashCode(this.jobId)) * 31) + Long.hashCode(this.replyFor)) * 31) + this.intentName.hashCode()) * 31) + this.implClassName.hashCode()) * 31;
        String r1 = this.inputParamTypeName;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.inputParams;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        Parcelable r8 = this.inputParamsParcel;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        Map<String, String> r11 = this.ext;
        if (r11 == null) goto L19;
        r2 = r11.hashCode();
    L19:
        return r10 + r2;
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

    public final void setExt(Map<String, String> r1) {
        this.ext = r1;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("IntentCalling(questionId=");
        r0.append(this.questionId).append(", messageId=").append(this.messageId).append(", actionId=").append(this.actionId).append(", jobId=").append(this.jobId).append(", replyFor=").append(this.replyFor).append(", intentName=").append(this.intentName).append(", implClassName=").append(this.implClassName).append(", inputParamTypeName=").append(this.inputParamTypeName).append(", inputParams=").append(this.inputParams).append(", inputParamsParcel=").append(this.inputParamsParcel).append(", ext=").append(this.ext).append(')');
        return r0.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r4, int r5) {
        r4.writeInt(1);
        Intrinsics.checkNotNullParameter(r4, "out");
        r4.writeLong(this.questionId);
        r4.writeLong(this.messageId);
        r4.writeLong(this.actionId);
        r4.writeLong(this.jobId);
        r4.writeLong(this.replyFor);
        r4.writeString(this.intentName);
        r4.writeString(this.implClassName);
        r4.writeString(this.inputParamTypeName);
        r4.writeString(this.inputParams);
        r4.writeParcelable(this.inputParamsParcel, r5);
        Map<String, String> r6 = this.ext;
        if (r6 != null) goto L5;
        r4.writeInt(0);
    L9:
        r4.writeValue(this.ext);
        return;
    L5:
        r4.writeInt(1);
        r4.writeInt(r6.size());
        Iterator<Map.Entry<String, String>> r7 = r6.entrySet().iterator();
    L7:
        if (r7.hasNext() == false) goto L9;
        Map.Entry<String, String> r0 = r7.next();
        r4.writeString(r0.getKey());
        r4.writeString(r0.getValue());
        goto L7
    }
}
