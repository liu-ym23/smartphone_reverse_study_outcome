package com.obric.capabilitykit.common;

import android.icu.text.PluralRules;
import android.util.Log;
import androidx.core.view.PointerIconCompat;
import com.bytedance.security.secretdata.SecretConst;
import com.bytedance.sremlib.LibUtil;
import com.google.gson.Gson;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b5\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 Q2\u00020\u0001:\u0001QB\u008b\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0002\u0010\u0012J\t\u0010;\u001a\u00020\u0003HÆ\u0003J\t\u0010<\u001a\u00020\u0003HÆ\u0003J\t\u0010=\u001a\u00020\fHÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u0010\u0010?\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u000b\u0010@\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010A\u001a\u00020\u0003HÆ\u0003J\u0010\u0010B\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u0010C\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u000b\u0010D\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010E\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010/J\t\u0010F\u001a\u00020\u0003HÆ\u0003J\u0094\u0001\u0010G\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÆ\u0001¢\u0006\u0002\u0010HJ\u0013\u0010I\u001a\u00020J2\b\u0010K\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0006\u0010L\u001a\u00020\u0014J\u0006\u0010M\u001a\u00020NJ\t\u0010O\u001a\u00020\fHÖ\u0001J\t\u0010P\u001a\u00020\u0006HÖ\u0001R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\r\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R \u0010\n\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010!\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R \u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0016\"\u0004\b'\u0010\u0018R\u001e\u0010\u000e\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0016\"\u0004\b)\u0010\u0018R \u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u001a\"\u0004\b+\u0010\u001cR\"\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010!\u001a\u0004\b,\u0010\u001e\"\u0004\b-\u0010 R\"\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u00102\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\"\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010!\u001a\u0004\b3\u0010\u001e\"\u0004\b4\u0010 R\u001e\u0010\u0007\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u0016\"\u0004\b6\u0010\u0018R\u001e\u0010\u000f\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:¨\u0006R"}, d2 = {"Lcom/obric/capabilitykit/common/IMAppAction;", "", "id", "", "messageId", "localMessageId", "", "replyId", "questionId", "createTime", "content", "messageType", "", "actionId", "jobId", "version", "ext", "Lcom/obric/capabilitykit/common/IMAppActionExt;", "(JLjava/lang/Long;Ljava/lang/String;JLjava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;JJILcom/obric/capabilitykit/common/IMAppActionExt;)V", "action", "Lcom/obric/capabilitykit/common/AppAction;", "getActionId", "()J", "setActionId", "(J)V", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "getCreateTime", "()Ljava/lang/Long;", "setCreateTime", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getExt", "()Lcom/obric/capabilitykit/common/IMAppActionExt;", "setExt", "(Lcom/obric/capabilitykit/common/IMAppActionExt;)V", "getId", "setId", "getJobId", "setJobId", "getLocalMessageId", "setLocalMessageId", "getMessageId", "setMessageId", "getMessageType", "()Ljava/lang/Integer;", "setMessageType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getQuestionId", "setQuestionId", "getReplyId", "setReplyId", "getVersion", "()I", "setVersion", "(I)V", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(JLjava/lang/Long;Ljava/lang/String;JLjava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;JJILcom/obric/capabilitykit/common/IMAppActionExt;)Lcom/obric/capabilitykit/common/IMAppAction;", "equals", "", PluralRules.KEYWORD_OTHER, "getAction", "getVersionInfo", "Lcom/obric/capabilitykit/common/VersionInfo;", "hashCode", "toString", "Companion", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class IMAppAction {
    public static final b Companion = null;
    private static final String TAG = "IMAppAction";
    private static final Lazy<Gson> gson$delegate = null;
    private transient AppAction action;

    @SerializedName(Ext.KEY_ACTION_ID)
    private long actionId;

    @SerializedName("content")
    private String content;

    @SerializedName(SecretConst.BUNDLE_KEY_CREATE_TIME)
    @JsonAdapter(TimeTransformAdapter.class)
    private Long createTime;

    @SerializedName("ext")
    private IMAppActionExt ext;

    @SerializedName("id")
    private long id;

    @SerializedName(Ext.KEY_JOB_ID)
    private long jobId;

    @SerializedName("local_message_id")
    private String localMessageId;

    @SerializedName("message_id")
    private Long messageId;

    @SerializedName(LibUtil.MESSAGE_TYPE)
    private Integer messageType;

    @SerializedName("question_id")
    private Long questionId;

    @SerializedName("reply_id")
    private long replyId;

    @SerializedName("version")
    private int version;

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/google/gson/Gson;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class a extends Lambda implements Function0<Gson> {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
            super(0);
        }

        public final Gson a() {
            return new Gson();
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Gson invoke() {
            return a();
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/obric/capabilitykit/common/IMAppAction$Companion;", "", "()V", "TAG", "", "gson", "Lcom/google/gson/Gson;", "getGson", "()Lcom/google/gson/Gson;", "gson$delegate", "Lkotlin/Lazy;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker r1) {
            this();
        }

        private final Gson a() {
            return (Gson) IMAppAction.access$getGson$delegate$cp().getValue();
        }

        public static final /* synthetic */ Gson a(b r0) {
            return r0.a();
        }
    }

    static {
        Companion = new b(null);
        gson$delegate = LazyKt.lazy(a.a);
    }

    public IMAppAction() {
        this(0, null, null, 0, null, null, null, null, 0, 0, 0, null, 4095, null);
    }

    public IMAppAction(long r4, Long r6, String r7, long r8, Long r10, Long r11, String r12, Integer r13, long r14, long r16, int r18, IMAppActionExt r19) {
        this.id = r4;
        this.messageId = r6;
        this.localMessageId = r7;
        this.replyId = r8;
        this.questionId = r10;
        this.createTime = r11;
        this.content = r12;
        this.messageType = r13;
        this.actionId = r14;
        this.jobId = r16;
        this.version = r18;
        this.ext = r19;
    }

    public /* synthetic */ IMAppAction(long r19, Long r21, String r22, long r23, Long r25, Long r26, String r27, Integer r28, long r29, long r31, int r33, IMAppActionExt r34, int r35, DefaultConstructorMarker r36) {
        if ((r35 & 1) == 0) goto L5;
        long r3 = -1;
    L6:
        IMAppActionExt r5 = null;
        if ((r35 & 2) == 0) goto L9;
        Long r1 = null;
    L11:
        if ((r35 & 4) == 0) goto L13;
        String r6 = null;
    L15:
        if ((r35 & 8) == 0) goto L17;
        long r7 = 0;
    L19:
        if ((r35 & 16) == 0) goto L21;
        Long r9 = null;
    L23:
        if ((r35 & 32) == 0) goto L25;
        Long r10 = null;
    L27:
        if ((r35 & 64) == 0) goto L29;
        String r11 = null;
    L30:
        int r13 = 1;
        if ((r35 & 128) == 0) goto L33;
        Integer r12 = 1;
    L35:
        if ((r35 & 256) == 0) goto L37;
        long r14 = -1;
    L39:
        if ((r35 & 512) == 0) goto L41;
        long r16 = -1;
    L43:
        if ((r35 & 1024) != 0) goto L47;
        r13 = r33;
    L47:
        if ((r35 & 2048) != 0) goto L50;
        r5 = r34;
    L50:
        this(r3, r1, r6, r7, r9, r10, r11, r12, r14, r16, r13, r5);
        return;
    L41:
        r16 = r31;
        goto L43
    L37:
        r14 = r29;
        goto L39
    L33:
        r12 = r28;
        goto L35
    L29:
        r11 = r27;
        goto L30
    L25:
        r10 = r26;
        goto L27
    L21:
        r9 = r25;
        goto L23
    L17:
        r7 = r23;
        goto L19
    L13:
        r6 = r22;
        goto L15
    L9:
        r1 = r21;
        goto L11
    L5:
        r3 = r19;
        goto L6
    }

    public static final /* synthetic */ Lazy access$getGson$delegate$cp() {
        return gson$delegate;
    }

    public static /* synthetic */ IMAppAction copy$default(IMAppAction r16, long r17, Long r19, String r20, long r21, Long r23, Long r24, String r25, Integer r26, long r27, long r29, int r31, IMAppActionExt r32, int r33, Object r34) {
        if ((r33 & 1) == 0) goto L5;
        long r2 = r16.id;
    L7:
        if ((r33 & 2) == 0) goto L9;
        Long r4 = r16.messageId;
    L11:
        if ((r33 & 4) == 0) goto L13;
        String r5 = r16.localMessageId;
    L15:
        if ((r33 & 8) == 0) goto L17;
        long r6 = r16.replyId;
    L19:
        if ((r33 & 16) == 0) goto L21;
        Long r8 = r16.questionId;
    L23:
        if ((r33 & 32) == 0) goto L25;
        Long r9 = r16.createTime;
    L27:
        if ((r33 & 64) == 0) goto L29;
        String r10 = r16.content;
    L31:
        if ((r33 & 128) == 0) goto L33;
        Integer r11 = r16.messageType;
    L35:
        if ((r33 & 256) == 0) goto L37;
        long r12 = r16.actionId;
    L39:
        if ((r33 & 512) == 0) goto L41;
        long r14 = r16.jobId;
    L42:
        long r210 = r14;
        if ((r33 & 1024) == 0) goto L45;
        int r15 = r16.version;
    L47:
        if ((r33 & 2048) == 0) goto L49;
        IMAppActionExt r1 = r16.ext;
    L51:
        return r16.copy(r2, r4, r5, r6, r8, r9, r10, r11, r12, r210, r15, r1);
    L49:
        r1 = r32;
        goto L51
    L45:
        r15 = r31;
        goto L47
    L41:
        r14 = r29;
        goto L42
    L37:
        r12 = r27;
        goto L39
    L33:
        r11 = r26;
        goto L35
    L29:
        r10 = r25;
        goto L31
    L25:
        r9 = r24;
        goto L27
    L21:
        r8 = r23;
        goto L23
    L17:
        r6 = r21;
        goto L19
    L13:
        r5 = r20;
        goto L15
    L9:
        r4 = r19;
        goto L11
    L5:
        r2 = r17;
        goto L7
    }

    public final long component1() {
        return this.id;
    }

    public final long component10() {
        return this.jobId;
    }

    public final int component11() {
        return this.version;
    }

    public final IMAppActionExt component12() {
        return this.ext;
    }

    public final Long component2() {
        return this.messageId;
    }

    public final String component3() {
        return this.localMessageId;
    }

    public final long component4() {
        return this.replyId;
    }

    public final Long component5() {
        return this.questionId;
    }

    public final Long component6() {
        return this.createTime;
    }

    public final String component7() {
        return this.content;
    }

    public final Integer component8() {
        return this.messageType;
    }

    public final long component9() {
        return this.actionId;
    }

    public final IMAppAction copy(long r19, Long r21, String r22, long r23, Long r25, Long r26, String r27, Integer r28, long r29, long r31, int r33, IMAppActionExt r34) {
        return new IMAppAction(r19, r21, r22, r23, r25, r26, r27, r28, r29, r31, r33, r34);
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof IMAppAction) == true) goto L8;
        return false;
    L8:
        IMAppAction r9 = (IMAppAction) r8;
        if (this.id == r9.id) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.messageId, r9.messageId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.localMessageId, r9.localMessageId) == true) goto L18;
        return false;
    L18:
        if (this.replyId == r9.replyId) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.questionId, r9.questionId) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.createTime, r9.createTime) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.content, r9.content) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.messageType, r9.messageType) == true) goto L33;
        return false;
    L33:
        if (this.actionId == r9.actionId) goto L36;
        return false;
    L36:
        if (this.jobId == r9.jobId) goto L39;
        return false;
    L39:
        if (this.version == r9.version) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.ext, r9.ext) == true) goto L44;
        return false;
    L44:
        return true;
    }

    public final AppAction getAction() {
        AppAction r0 = this.action;
        if (r0 == null) goto L10;
    L9:
        return r0;
    L10:
        Object r1 = b.a(Companion).fromJson(this.content, AppAction.class);     // Catch: IllegalStateException -> L6
        this.action = (AppAction) r1;     // Catch: IllegalStateException -> L6
        r0 = (AppAction) r1;     // Catch: IllegalStateException -> L6
    L8:
        Intrinsics.checkNotNullExpressionValue(r0, "try {\n            gson.f…            }\n\n\n        }");
    L6:
        e = move-exception;
        Log.w(TAG, "AppAction content is illegal", e);
        r0 = new AppAction("", "", "", null, 0, null, null, null, null, null, PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW, null);
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

    public final long getId() {
        return this.id;
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

    public final VersionInfo getVersionInfo() {
        Object r2 = b.a(Companion).fromJson(this.content, VersionInfo.class);     // Catch: IllegalStateException -> L4
        Intrinsics.checkNotNullExpressionValue(r2, "gson.fromJson(content, VersionInfo::class.java)");     // Catch: IllegalStateException -> L4
        return (VersionInfo) r2;
    L4:
        e = move-exception;
        Log.w(TAG, "AppAction content is illegal", e);
        return new VersionInfo(0);
    }

    public int hashCode() {
        int r0 = Long.hashCode(this.id) * 31;
        Long r1 = this.messageId;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.localMessageId;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (((r4 + r6) * 31) + Long.hashCode(this.replyId)) * 31;
        Long r8 = this.questionId;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        Long r11 = this.createTime;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (r10 + r12) * 31;
        String r14 = this.content;
        if (r14 != null) goto L21;
        int r15 = 0;
    L22:
        int r16 = (r13 + r15) * 31;
        Integer r17 = this.messageType;
        if (r17 != null) goto L25;
        int r18 = 0;
    L26:
        int r19 = (((((((r16 + r18) * 31) + Long.hashCode(this.actionId)) * 31) + Long.hashCode(this.jobId)) * 31) + Integer.hashCode(this.version)) * 31;
        IMAppActionExt r20 = this.ext;
        if (r20 == null) goto L31;
        r2 = r20.hashCode();
    L31:
        return r19 + r2;
    L25:
        r18 = r17.hashCode();
        goto L26
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

    public final void setId(long r1) {
        this.id = r1;
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
        StringBuilder r0 = new StringBuilder("IMAppAction(id=");
        r0.append(this.id).append(", messageId=").append(this.messageId).append(", localMessageId=").append(this.localMessageId).append(", replyId=").append(this.replyId).append(", questionId=").append(this.questionId).append(", createTime=").append(this.createTime).append(", content=").append(this.content).append(", messageType=").append(this.messageType).append(", actionId=").append(this.actionId).append(", jobId=").append(this.jobId).append(", version=").append(this.version).append(", ext=");
        r0.append(this.ext).append(')');
        return r0.toString();
    }
}
