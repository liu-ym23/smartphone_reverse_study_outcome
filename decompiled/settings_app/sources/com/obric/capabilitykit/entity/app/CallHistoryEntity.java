package com.obric.capabilitykit.entity.app;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.launcher3.icons.cache.BaseIconCache;
import com.bytedance.apm.constant.PerfConsts;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.obric.capabilitykit.entity.enums.CallTypeEnum;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 C2\u00020\u0001:\u0001CB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004BO\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u000b\u0012\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u000b\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012J\b\u0010:\u001a\u00020;H\u0016J\"\u0010<\u001a\u00020=2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010>\u001a\u0004\u0018\u00010?2\u0006\u0010@\u001a\u00020\u0011H\u0016J\u0018\u0010A\u001a\u00020=2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010B\u001a\u00020\u0011H\u0016R\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010\f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0019\"\u0004\b\u001d\u0010\u001bR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001a\u0010(\u001a\u00020#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010%\"\u0004\b)\u0010'R\u001c\u0010*\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R \u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0019\"\u0004\b0\u0010\u001bR\"\u00101\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0019\"\u0004\b3\u0010\u001bR\u001c\u00104\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010,\"\u0004\b6\u0010.R\u001c\u00107\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010,\"\u0004\b9\u0010.¨\u0006D"}, d2 = {"Lcom/obric/capabilitykit/entity/app/CallHistoryEntity;", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "id", "", "createTime", "", "modifyTime", "telephones", "", "contacts", "Lcom/obric/capabilitykit/entity/app/ContactEntity;", "callType", "Lcom/obric/capabilitykit/entity/enums/CallTypeEnum;", "duration", "", "(Ljava/lang/String;JJLjava/util/List;Ljava/util/List;Lcom/obric/capabilitykit/entity/enums/CallTypeEnum;I)V", "getCallType", "()Lcom/obric/capabilitykit/entity/enums/CallTypeEnum;", "setCallType", "(Lcom/obric/capabilitykit/entity/enums/CallTypeEnum;)V", "carriers", "getCarriers", "()Ljava/util/List;", "setCarriers", "(Ljava/util/List;)V", "getContacts", "setContacts", "getDuration", "()I", "setDuration", "(I)V", "hasTranscript", "", "getHasTranscript", "()Z", "setHasTranscript", "(Z)V", "isAIPickup", "setAIPickup", "tag", "getTag", "()Ljava/lang/String;", "setTag", "(Ljava/lang/String;)V", "getTelephones", "setTelephones", "todoList", "getTodoList", "setTodoList", "transcript", "getTranscript", "setTranscript", "transcriptTitle", "getTranscriptTitle", "setTranscriptTitle", "getDisplayRepresentation", "Lcom/obric/capabilitykit/entity/app/DisplayRepresentation;", "onReadSubClassExtensionField", "", "currentClassLoader", "Ljava/lang/ClassLoader;", "version", "writeToParcel", BaseIconCache.IconDB.COLUMN_FLAGS, "CREATOR", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class CallHistoryEntity extends AppEntity {
    public static final CREATOR CREATOR = null;
    private static final int FIELD_VERSION = 3;
    private static final int RELATED_VERSION = 1;
    private CallTypeEnum callType;
    private List<String> carriers;
    private List<ContactEntity> contacts;
    private int duration;
    private boolean hasTranscript;
    private boolean isAIPickup;
    private String tag;
    private List<String> telephones;
    private List<String> todoList;
    private String transcript;
    private String transcriptTitle;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0087\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\u0016J\u0006\u0010\n\u001a\u00020\u0005J\u001d\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/capabilitykit/entity/app/CallHistoryEntity$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/capabilitykit/entity/app/CallHistoryEntity;", "()V", "FIELD_VERSION", "", "RELATED_VERSION", "createFromParcel", "parcel", "Landroid/os/Parcel;", "getVersion", "newArray", "", PerfConsts.PERF_DISK_FILE_SIZE, "(I)[Lcom/obric/capabilitykit/entity/app/CallHistoryEntity;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class CREATOR implements Parcelable.Creator<CallHistoryEntity> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(DefaultConstructorMarker r1) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CallHistoryEntity createFromParcel(Parcel r1) {
            Intrinsics.checkNotNullParameter(r1, "parcel");
            AppEntity r0 = AppEntity.CREATOR.createFromParcel(r1);
            Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.obric.capabilitykit.entity.app.CallHistoryEntity");
            return (CallHistoryEntity) r0;
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ CallHistoryEntity createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        public final int getVersion() {
            return 4;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CallHistoryEntity[] newArray(int r1) {
            return new CallHistoryEntity[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ CallHistoryEntity[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public CallHistoryEntity(Parcel r12) {
        Intrinsics.checkNotNullParameter(r12, "parcel");
        String r2 = EntityExtKt.readStringOrEmpty(r12);
        long r3 = r12.readLong();
        long r5 = r12.readLong();
        ArrayList<String> r0 = r12.createStringArrayList();
        if (r0 != null) goto L5;
        r0 = new ArrayList();
    L5:
        ArrayList<String> r7 = r0;
        ArrayList r8 = r12.createTypedArrayList(ContactEntity.CREATOR);
        CallTypeEnum r1 = CallTypeEnum.Companion.from(r12.readString());
        if (r1 != null) goto L8;
        r1 = CallTypeEnum.INCOMING_CALL_ANSWERED;
    L8:
        this(r2, r3, r5, r7, r8, r1, r12.readInt());
        readExtensionFieldFromParcel$capabilitykitcommon_release(r12);
        int r4 = r12.readInt();
        this.tag = r12.readString();
        this.isAIPickup = EntityExtKt.readBool(r12);
        this.hasTranscript = EntityExtKt.readBool(r12);
        this.transcript = r12.readString();
        readSubClassExtensionFieldFromParcel$capabilitykitcommon_release(r12, 3, r4);
    }

    public CallHistoryEntity(String r11, long r12, long r14, List<String> r16, List<ContactEntity> r17, CallTypeEnum r18, int r19) {
        Intrinsics.checkNotNullParameter(r11, "id");
        Intrinsics.checkNotNullParameter(r16, "telephones");
        Intrinsics.checkNotNullParameter(r18, "callType");
        super(r11, r12, r14, 202);
        this.telephones = r16;
        this.contacts = r17;
        this.callType = r18;
        this.duration = r19;
    }

    public /* synthetic */ CallHistoryEntity(String r12, long r13, long r15, List r17, List r18, CallTypeEnum r19, int r20, int r21, DefaultConstructorMarker r22) {
        if ((r21 & 16) == 0) goto L5;
        List r8 = null;
    L7:
        if ((r21 & 64) == 0) goto L9;
        int r10 = 0;
    L10:
        this(r12, r13, r15, r17, r8, r19, r10);
        return;
    L9:
        r10 = r20;
        goto L10
    L5:
        r8 = r18;
        goto L7
    }

    public final CallTypeEnum getCallType() {
        return this.callType;
    }

    public final List<String> getCarriers() {
        return this.carriers;
    }

    public final List<ContactEntity> getContacts() {
        return this.contacts;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity
    public DisplayRepresentation getDisplayRepresentation() {
        List<ContactEntity> r0 = this.contacts;
        if (r0 == null) goto L8;
        ContactEntity r1 = (ContactEntity) CollectionsKt.getOrNull(r0, 0);
        if (r1 == null) goto L8;
        String r2 = r1.getName();
        if (r2 == null) goto L8;
    L9:
        String r4 = r2;
        List<String> r3 = this.carriers;
        if (r3 == null) goto L12;
        String r5 = (String) CollectionsKt.getOrNull(r3, 0);
    L14:
        return new DisplayRepresentation(null, r4, r5, getLastModifiedTime());
    L12:
        r5 = null;
    L8:
        r2 = this.telephones.get(0);
        goto L9
    }

    public final int getDuration() {
        return this.duration;
    }

    public final boolean getHasTranscript() {
        return this.hasTranscript;
    }

    public final String getTag() {
        return this.tag;
    }

    public final List<String> getTelephones() {
        return this.telephones;
    }

    public final List<String> getTodoList() {
        return this.todoList;
    }

    public final String getTranscript() {
        return this.transcript;
    }

    public final String getTranscriptTitle() {
        return this.transcriptTitle;
    }

    public final boolean isAIPickup() {
        return this.isAIPickup;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity
    public void onReadSubClassExtensionField(Parcel r2, ClassLoader r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "parcel");
        if (r4 != 1) goto L5;
        this.carriers = (List) r2.readValue(r3);
        return;
    L5:
        if (r4 != 2) goto L7;
        this.todoList = (List) r2.readValue(r3);
        return;
    L7:
        if (r4 != 3) goto L19;
        Object r5 = r2.readValue(r3);
        if ((r5 instanceof String) == false) goto L12;
        String r6 = (String) r5;
    L13:
        this.transcriptTitle = r6;
        return;
    L12:
        r6 = null;
        goto L13
    }

    public final void setAIPickup(boolean r1) {
        this.isAIPickup = r1;
    }

    public final void setCallType(CallTypeEnum r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.callType = r2;
    }

    public final void setCarriers(List<String> r1) {
        this.carriers = r1;
    }

    public final void setContacts(List<ContactEntity> r1) {
        this.contacts = r1;
    }

    public final void setDuration(int r1) {
        this.duration = r1;
    }

    public final void setHasTranscript(boolean r1) {
        this.hasTranscript = r1;
    }

    public final void setTag(String r1) {
        this.tag = r1;
    }

    public final void setTelephones(List<String> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.telephones = r2;
    }

    public final void setTodoList(List<String> r1) {
        this.todoList = r1;
    }

    public final void setTranscript(String r1) {
        this.transcript = r1;
    }

    public final void setTranscriptTitle(String r1) {
        this.transcriptTitle = r1;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity, android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "parcel");
        writeBaseFieldToParcel$capabilitykitcommon_release(r1);
        r1.writeStringList(this.telephones);
        r1.writeTypedList(this.contacts);
        r1.writeString(this.callType.name());
        r1.writeInt(this.duration);
        writeExtensionFieldToParcel$capabilitykitcommon_release(r1);
        r1.writeInt(3);
        r1.writeString(this.tag);
        EntityExtKt.writeBool(r1, this.isAIPickup);
        EntityExtKt.writeBool(r1, this.hasTranscript);
        r1.writeString(this.transcript);
        r1.writeValue(this.carriers);
        r1.writeValue(this.todoList);
        r1.writeValue(this.transcriptTitle);
    }
}
