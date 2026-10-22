package com.obric.capabilitykit.common;

import android.util.Log;
import androidx.annotation.Keep;
import com.google.gson.Gson;
import com.google.gson.y.b;
import com.google.gson.y.c;
import kotlin.Metadata;
import kotlin.h;
import kotlin.i;
import kotlin.n0.d.g;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b2\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0087\b\u0018\u0000 K2\u00020\u0001:\u0001KB\u0081\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0002\u0010\u0011J\u0010\u00108\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001dJ\t\u00109\u001a\u00020\u000bHÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010<\u001a\u00020\u0003HÆ\u0003J\u0010\u0010=\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001dJ\u0010\u0010>\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001dJ\u000b\u0010?\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010@\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010,J\t\u0010A\u001a\u00020\u0003HÆ\u0003J\t\u0010B\u001a\u00020\u0003HÆ\u0003J\u008a\u0001\u0010C\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u000b2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÆ\u0001¢\u0006\u0002\u0010DJ\u0013\u0010E\u001a\u00020F2\b\u0010G\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0006\u0010H\u001a\u00020\u0013J\t\u0010I\u001a\u00020\u000bHÖ\u0001J\t\u0010J\u001a\u00020\u0005HÖ\u0001R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\f\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R \u0010\t\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010 \u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR \u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001e\u0010\r\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0015\"\u0004\b&\u0010\u0017R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0019\"\u0004\b(\u0010\u001bR\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010 \u001a\u0004\b)\u0010\u001d\"\u0004\b*\u0010\u001fR\"\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010/\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\"\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010 \u001a\u0004\b0\u0010\u001d\"\u0004\b1\u0010\u001fR\u001e\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0015\"\u0004\b3\u0010\u0017R\u001e\u0010\u000e\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107¨\u0006L"}, d2 = {"Lcom/obric/capabilitykit/common/IMAppAction;", "", "messageId", "", "localMessageId", "", "replyId", "questionId", "createTime", "content", "messageType", "", "actionId", "jobId", "version", "ext", "Lcom/obric/capabilitykit/common/IMAppActionExt;", "(Ljava/lang/Long;Ljava/lang/String;JLjava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;JJILcom/obric/capabilitykit/common/IMAppActionExt;)V", "action", "Lcom/obric/capabilitykit/common/AppAction;", "getActionId", "()J", "setActionId", "(J)V", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "getCreateTime", "()Ljava/lang/Long;", "setCreateTime", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getExt", "()Lcom/obric/capabilitykit/common/IMAppActionExt;", "setExt", "(Lcom/obric/capabilitykit/common/IMAppActionExt;)V", "getJobId", "setJobId", "getLocalMessageId", "setLocalMessageId", "getMessageId", "setMessageId", "getMessageType", "()Ljava/lang/Integer;", "setMessageType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getQuestionId", "setQuestionId", "getReplyId", "setReplyId", "getVersion", "()I", "setVersion", "(I)V", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Long;Ljava/lang/String;JLjava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;JJILcom/obric/capabilitykit/common/IMAppActionExt;)Lcom/obric/capabilitykit/common/IMAppAction;", "equals", "", "other", "getAction", "hashCode", "toString", "Companion", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class IMAppAction {
    public static final Companion Companion = null;
    private static final String TAG = "IMAppAction";
    private static final h<Gson> gson$delegate = null;
    private transient AppAction action;

    @c("action_id")
    private long actionId;

    @c("content")
    private String content;

    @c("create_time")
    @b(TimeTransformAdapter.class)
    private Long createTime;

    @c("ext")
    private IMAppActionExt ext;

    @c("job_id")
    private long jobId;

    @c("local_message_id")
    private String localMessageId;

    @c("message_id")
    private Long messageId;

    @c("message_type")
    private Integer messageType;

    @c("question_id")
    private Long questionId;

    @c("reply_id")
    private long replyId;

    @c("version")
    private int version;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/obric/capabilitykit/common/IMAppAction$Companion;", "", "()V", "TAG", "", "gson", "Lcom/google/gson/Gson;", "getGson", "()Lcom/google/gson/Gson;", "gson$delegate", "Lkotlin/Lazy;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g r1) {
            this();
        }

        public static final /* synthetic */ Gson access$getGson(Companion r0) {
            return r0.getGson();
        }

        private final Gson getGson() {
            return (Gson) IMAppAction.access$getGson$delegate$cp().getValue();
        }
    }

    static {
        Companion = new Companion(null);
        gson$delegate = i.b(IMAppAction$Companion$gson$2.INSTANCE);
    }

    public IMAppAction() {
        this(null, null, 0, null, null, null, null, 0, 0, 0, null, 2047, null);
    }

    public IMAppAction(Long r1, String r2, long r3, Long r5, Long r6, String r7, Integer r8, long r9, long r11, int r13, IMAppActionExt r14) {
        this.messageId = r1;
        this.localMessageId = r2;
        this.replyId = r3;
        this.questionId = r5;
        this.createTime = r6;
        this.content = r7;
        this.messageType = r8;
        this.actionId = r9;
        this.jobId = r11;
        this.version = r13;
        this.ext = r14;
    }

    public /* synthetic */ IMAppAction(Long r17, String r18, long r19, Long r21, Long r22, String r23, Integer r24, long r25, long r27, int r29, IMAppActionExt r30, int r31, g r32) {
        IMAppActionExt r2 = null;
        if ((r31 & 1) == 0) goto L5;
        Long r1 = null;
    L7:
        if ((r31 & 2) == 0) goto L9;
        String r3 = null;
    L11:
        if ((r31 & 4) == 0) goto L13;
        long r4 = 0;
    L15:
        if ((r31 & 8) == 0) goto L17;
        Long r6 = null;
    L19:
        if ((r31 & 16) == 0) goto L21;
        Long r7 = null;
    L23:
        if ((r31 & 32) == 0) goto L25;
        String r8 = null;
    L26:
        int r10 = 1;
        if ((r31 & 64) == 0) goto L29;
        Integer r9 = 1;
    L30:
        long r12 = -1;
        if ((r31 & 128) == 0) goto L33;
        long r14 = -1;
    L35:
        if ((r31 & 256) != 0) goto L39;
        r12 = r27;
    L39:
        if ((r31 & 512) != 0) goto L43;
        r10 = r29;
    L43:
        if ((r31 & 1024) != 0) goto L46;
        r2 = r30;
    L46:
        this(r1, r3, r4, r6, r7, r8, r9, r14, r12, r10, r2);
        return;
    L33:
        r14 = r25;
        goto L35
    L29:
        r9 = r24;
        goto L30
    L25:
        r8 = r23;
        goto L26
    L21:
        r7 = r22;
        goto L23
    L17:
        r6 = r21;
        goto L19
    L13:
        r4 = r19;
        goto L15
    L9:
        r3 = r18;
        goto L11
    L5:
        r1 = r17;
        goto L7
    }

    public static final /* synthetic */ h access$getGson$delegate$cp() {
        return gson$delegate;
    }

    public static /* synthetic */ IMAppAction copy$default(IMAppAction r15, Long r16, String r17, long r18, Long r20, Long r21, String r22, Integer r23, long r24, long r26, int r28, IMAppActionExt r29, int r30, Object r31) {
        if ((r30 & 1) == 0) goto L5;
        Long r2 = r15.messageId;
    L7:
        if ((r30 & 2) == 0) goto L9;
        String r3 = r15.localMessageId;
    L11:
        if ((r30 & 4) == 0) goto L13;
        long r4 = r15.replyId;
    L15:
        if ((r30 & 8) == 0) goto L17;
        Long r6 = r15.questionId;
    L19:
        if ((r30 & 16) == 0) goto L21;
        Long r7 = r15.createTime;
    L23:
        if ((r30 & 32) == 0) goto L25;
        String r8 = r15.content;
    L27:
        if ((r30 & 64) == 0) goto L29;
        Integer r9 = r15.messageType;
    L31:
        if ((r30 & 128) == 0) goto L33;
        long r10 = r15.actionId;
    L35:
        if ((r30 & 256) == 0) goto L37;
        long r12 = r15.jobId;
    L39:
        if ((r30 & 512) == 0) goto L41;
        int r14 = r15.version;
    L43:
        if ((r30 & 1024) == 0) goto L45;
        IMAppActionExt r1 = r15.ext;
    L47:
        return r15.copy(r2, r3, r4, r6, r7, r8, r9, r10, r12, r14, r1);
    L45:
        r1 = r29;
        goto L47
    L41:
        r14 = r28;
        goto L43
    L37:
        r12 = r26;
        goto L39
    L33:
        r10 = r24;
        goto L35
    L29:
        r9 = r23;
        goto L31
    L25:
        r8 = r22;
        goto L27
    L21:
        r7 = r21;
        goto L23
    L17:
        r6 = r20;
        goto L19
    L13:
        r4 = r18;
        goto L15
    L9:
        r3 = r17;
        goto L11
    L5:
        r2 = r16;
        goto L7
    }

    public final Long component1() {
        return this.messageId;
    }

    public final int component10() {
        return this.version;
    }

    public final IMAppActionExt component11() {
        return this.ext;
    }

    public final String component2() {
        return this.localMessageId;
    }

    public final long component3() {
        return this.replyId;
    }

    public final Long component4() {
        return this.questionId;
    }

    public final Long component5() {
        return this.createTime;
    }

    public final String component6() {
        return this.content;
    }

    public final Integer component7() {
        return this.messageType;
    }

    public final long component8() {
        return this.actionId;
    }

    public final long component9() {
        return this.jobId;
    }

    public final IMAppAction copy(Long r17, String r18, long r19, Long r21, Long r22, String r23, Integer r24, long r25, long r27, int r29, IMAppActionExt r30) {
        return new IMAppAction(r17, r18, r19, r21, r22, r23, r24, r25, r27, r29, r30);
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof IMAppAction) == true) goto L8;
        return false;
    L8:
        IMAppAction r9 = (IMAppAction) r8;
        if (o.a(this.messageId, r9.messageId) == true) goto L12;
        return false;
    L12:
        if (o.a(this.localMessageId, r9.localMessageId) == true) goto L15;
        return false;
    L15:
        if (this.replyId == r9.replyId) goto L18;
        return false;
    L18:
        if (o.a(this.questionId, r9.questionId) == true) goto L21;
        return false;
    L21:
        if (o.a(this.createTime, r9.createTime) == true) goto L24;
        return false;
    L24:
        if (o.a(this.content, r9.content) == true) goto L27;
        return false;
    L27:
        if (o.a(this.messageType, r9.messageType) == true) goto L30;
        return false;
    L30:
        if (this.actionId == r9.actionId) goto L33;
        return false;
    L33:
        if (this.jobId == r9.jobId) goto L36;
        return false;
    L36:
        if (this.version == r9.version) goto L39;
        return false;
    L39:
        if (o.a(this.ext, r9.ext) == true) goto L41;
        return false;
    L41:
        return true;
    }

    public final AppAction getAction() {
        AppAction r0 = this.action;
        if (r0 == null) goto L10;
    L9:
        return r0;
    L10:
        Object r1 = Companion.access$getGson(Companion).m(this.content, AppAction.class);     // Catch: IllegalStateException -> L6
        this.action = (AppAction) r1;     // Catch: IllegalStateException -> L6
        r0 = (AppAction) r1;     // Catch: IllegalStateException -> L6
    L8:
        o.e(r0, "try {\n            gson.f…t\n            }\n        }");
    L6:
        e = move-exception;
        Log.w(TAG, "AppAction content is illegal", e);
        r0 = new AppAction("", "", "", null, 0, null, 56, null);
        this.action = r0;
        goto L8
    }

    public final long getActionId() {
        return this.actionId;
    }

    public final String getContent() {
        return this.content;
    }

    public final Long getCreateTime() {
        return this.createTime;
    }

    public final IMAppActionExt getExt() {
        return this.ext;
    }

    public final long getJobId() {
        return this.jobId;
    }

    public final String getLocalMessageId() {
        return this.localMessageId;
    }

    public final Long getMessageId() {
        return this.messageId;
    }

    public final Integer getMessageType() {
        return this.messageType;
    }

    public final Long getQuestionId() {
        return this.questionId;
    }

    public final long getReplyId() {
        return this.replyId;
    }

    public final int getVersion() {
        return this.version;
    }

    public int hashCode() {
        Long r0 = this.messageId;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.localMessageId;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (((r3 + r5) * 31) + Long.hashCode(this.replyId)) * 31;
        Long r7 = this.questionId;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Long r10 = this.createTime;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.content;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        Integer r16 = this.messageType;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (((((((r15 + r17) * 31) + Long.hashCode(this.actionId)) * 31) + Long.hashCode(this.jobId)) * 31) + Integer.hashCode(this.version)) * 31;
        IMAppActionExt r19 = this.ext;
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
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final void setActionId(long r1) {
        this.actionId = r1;
    }

    public final void setContent(String r1) {
        this.content = r1;
    }

    public final void setCreateTime(Long r1) {
        this.createTime = r1;
    }

    public final void setExt(IMAppActionExt r1) {
        this.ext = r1;
    }

    public final void setJobId(long r1) {
        this.jobId = r1;
    }

    public final void setLocalMessageId(String r1) {
        this.localMessageId = r1;
    }

    public final void setMessageId(Long r1) {
        this.messageId = r1;
    }

    public final void setMessageType(Integer r1) {
        this.messageType = r1;
    }

    public final void setQuestionId(Long r1) {
        this.questionId = r1;
    }

    public final void setReplyId(long r1) {
        this.replyId = r1;
    }

    public final void setVersion(int r1) {
        this.version = r1;
    }

    public String toString() {
        return "IMAppAction(messageId=" + this.messageId + ", localMessageId=" + this.localMessageId + ", replyId=" + this.replyId + ", questionId=" + this.questionId + ", createTime=" + this.createTime + ", content=" + this.content + ", messageType=" + this.messageType + ", actionId=" + this.actionId + ", jobId=" + this.jobId + ", version=" + this.version + ", ext=" + this.ext + ')';
    }
}
