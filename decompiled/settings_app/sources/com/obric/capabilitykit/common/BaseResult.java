package com.obric.capabilitykit.common;

import android.icu.text.PluralRules;
import com.bytedance.apm.constant.SlardarConfigConsts;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b'\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001Bm\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0006\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b\u0012\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u000e¢\u0006\u0002\u0010\u000fJ\u0010\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001dJ\u0010\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001dJ\t\u0010-\u001a\u00020\u0006HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\nHÆ\u0003J\t\u00100\u001a\u00020\u0006HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0017\u00102\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u000eHÆ\u0003Jv\u00103\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00062\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b2\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u000eHÆ\u0001¢\u0006\u0002\u00104J\u0013\u00105\u001a\u0002062\b\u00107\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00108\u001a\u00020\u0006HÖ\u0001J\t\u00109\u001a\u00020\bHÖ\u0001R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R(\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010 \u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010\f\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0011\"\u0004\b\"\u0010\u0013R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010 \u001a\u0004\b#\u0010\u001d\"\u0004\b$\u0010\u001fR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010\u000b\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010&\"\u0004\b*\u0010(¨\u0006:"}, d2 = {"Lcom/obric/capabilitykit/common/BaseResult;", "", "questionId", "", "replyId", SlardarConfigConsts.CONFIG_RET, "", "details", "", "file", "Ljava/io/File;", "uiType", "replyFor", "ext", "Ljava/util/concurrent/ConcurrentHashMap;", "(Ljava/lang/Long;Ljava/lang/Long;ILjava/lang/String;Ljava/io/File;ILjava/lang/String;Ljava/util/concurrent/ConcurrentHashMap;)V", "getDetails", "()Ljava/lang/String;", "setDetails", "(Ljava/lang/String;)V", "getExt", "()Ljava/util/concurrent/ConcurrentHashMap;", "setExt", "(Ljava/util/concurrent/ConcurrentHashMap;)V", "getFile", "()Ljava/io/File;", "setFile", "(Ljava/io/File;)V", "getQuestionId", "()Ljava/lang/Long;", "setQuestionId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getReplyFor", "setReplyFor", "getReplyId", "setReplyId", "getRet", "()I", "setRet", "(I)V", "getUiType", "setUiType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/Long;Ljava/lang/Long;ILjava/lang/String;Ljava/io/File;ILjava/lang/String;Ljava/util/concurrent/ConcurrentHashMap;)Lcom/obric/capabilitykit/common/BaseResult;", "equals", "", PluralRules.KEYWORD_OTHER, "hashCode", "toString", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class BaseResult {
    private String details;
    private ConcurrentHashMap<String, String> ext;
    private File file;
    private Long questionId;
    private String replyFor;
    private Long replyId;
    private int ret;
    private int uiType;

    public BaseResult() {
        this(null, null, 0, null, null, 0, null, null, 255, null);
    }

    public BaseResult(Long r1, Long r2, int r3, String r4, File r5, int r6, String r7, ConcurrentHashMap<String, String> r8) {
        this.questionId = r1;
        this.replyId = r2;
        this.ret = r3;
        this.details = r4;
        this.file = r5;
        this.uiType = r6;
        this.replyFor = r7;
        this.ext = r8;
    }

    public /* synthetic */ BaseResult(Long r3, Long r4, int r5, String r6, File r7, int r8, String r9, ConcurrentHashMap r10, int r11, DefaultConstructorMarker r12) {
        if ((r11 & 1) == 0) goto L6;
        r3 = null;
    L6:
        if ((r11 & 2) == 0) goto L9;
        r4 = null;
    L9:
        if ((r11 & 4) == 0) goto L12;
        r5 = 1;
    L12:
        if ((r11 & 8) == 0) goto L15;
        r6 = null;
    L15:
        if ((r11 & 16) == 0) goto L18;
        r7 = null;
    L18:
        if ((r11 & 32) == 0) goto L21;
        r8 = 1;
    L21:
        if ((r11 & 64) == 0) goto L24;
        r9 = "";
    L24:
        if ((r11 & 128) == 0) goto L26;
        r10 = null;
    L26:
        this(r3, r4, r5, r6, r7, r8, r9, r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BaseResult copy$default(BaseResult r9, Long r10, Long r11, int r12, String r13, File r14, int r15, String r16, ConcurrentHashMap r17, int r18, Object r19) {
        if ((r18 & 1) == 0) goto L5;
        Long r2 = r9.questionId;
    L7:
        if ((r18 & 2) == 0) goto L9;
        Long r3 = r9.replyId;
    L11:
        if ((r18 & 4) == 0) goto L13;
        int r4 = r9.ret;
    L15:
        if ((r18 & 8) == 0) goto L17;
        String r5 = r9.details;
    L19:
        if ((r18 & 16) == 0) goto L21;
        File r6 = r9.file;
    L23:
        if ((r18 & 32) == 0) goto L25;
        int r7 = r9.uiType;
    L27:
        if ((r18 & 64) == 0) goto L29;
        String r8 = r9.replyFor;
    L31:
        if ((r18 & 128) == 0) goto L33;
        ConcurrentHashMap r1 = r9.ext;
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

    public final Long component1() {
        return this.questionId;
    }

    public final Long component2() {
        return this.replyId;
    }

    public final int component3() {
        return this.ret;
    }

    public final String component4() {
        return this.details;
    }

    public final File component5() {
        return this.file;
    }

    public final int component6() {
        return this.uiType;
    }

    public final String component7() {
        return this.replyFor;
    }

    public final ConcurrentHashMap<String, String> component8() {
        return this.ext;
    }

    public final BaseResult copy(Long r11, Long r12, int r13, String r14, File r15, int r16, String r17, ConcurrentHashMap<String, String> r18) {
        return new BaseResult(r11, r12, r13, r14, r15, r16, r17, r18);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof BaseResult) == true) goto L8;
        return false;
    L8:
        BaseResult r6 = (BaseResult) r5;
        if (Intrinsics.areEqual(this.questionId, r6.questionId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.replyId, r6.replyId) == true) goto L15;
        return false;
    L15:
        if (this.ret == r6.ret) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.details, r6.details) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.file, r6.file) == true) goto L24;
        return false;
    L24:
        if (this.uiType == r6.uiType) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.replyFor, r6.replyFor) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.ext, r6.ext) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final String getDetails() {
        return this.details;
    }

    public final ConcurrentHashMap<String, String> getExt() {
        return this.ext;
    }

    public final File getFile() {
        return this.file;
    }

    public final Long getQuestionId() {
        return this.questionId;
    }

    public final String getReplyFor() {
        return this.replyFor;
    }

    public final Long getReplyId() {
        return this.replyId;
    }

    public final int getRet() {
        return this.ret;
    }

    public final int getUiType() {
        return this.uiType;
    }

    public int hashCode() {
        Long r0 = this.questionId;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Long r4 = this.replyId;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (((r3 + r5) * 31) + Integer.hashCode(this.ret)) * 31;
        String r7 = this.details;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        File r10 = this.file;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (((r9 + r11) * 31) + Integer.hashCode(this.uiType)) * 31;
        String r13 = this.replyFor;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        ConcurrentHashMap<String, String> r16 = this.ext;
        if (r16 == null) goto L27;
        r1 = r16.hashCode();
    L27:
        return r15 + r1;
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

    public final void setDetails(String r1) {
        this.details = r1;
    }

    public final void setExt(ConcurrentHashMap<String, String> r1) {
        this.ext = r1;
    }

    public final void setFile(File r1) {
        this.file = r1;
    }

    public final void setQuestionId(Long r1) {
        this.questionId = r1;
    }

    public final void setReplyFor(String r1) {
        this.replyFor = r1;
    }

    public final void setReplyId(Long r1) {
        this.replyId = r1;
    }

    public final void setRet(int r1) {
        this.ret = r1;
    }

    public final void setUiType(int r1) {
        this.uiType = r1;
    }

    public String toString() {
        return "BaseResult(questionId=" + this.questionId + ", replyId=" + this.replyId + ", ret=" + this.ret + ", details=" + this.details + ", file=" + this.file + ", uiType=" + this.uiType + ", replyFor=" + this.replyFor + ", ext=" + this.ext + ')';
    }
}
