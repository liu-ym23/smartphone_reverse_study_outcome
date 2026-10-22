package com.obric.capabilitykit.common;

import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.ContactEntity;
import com.obric.capabilitykit.entity.app.FileEntity;
import com.obric.capabilitykit.entity.app.GroupChatEntity;
import com.obric.capabilitykit.entity.app.MessageEntity;
import com.obric.capabilitykit.entity.enums.MessageStatusTypeEnum;
import com.obric.capabilitykit.entity.enums.MessageTypeEnum;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/obric/capabilitykit/entity/app/MessageEntityHashCodeGenerator;", "Lcom/obric/capabilitykit/entity/app/IEntityHashCodeGenerator;", "()V", "generatorHashCode", "", "instance", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class c0 implements a0 {
    public static final c0 a = null;

    static {
        a = new c0();
    }

    private c0() {
    }

    @Override // com.obric.capabilitykit.common.a0
    public int a(AppEntity r2) {
        Intrinsics.checkNotNullParameter(r2, "instance");
        if ((r2 instanceof MessageEntity) == false) goto L21;
        MessageEntity r3 = (MessageEntity) r2;
        int r1 = ((r3.getTelephones().hashCode() + 0) * 31) + r3.getText().hashCode();
        List<ContactEntity> r0 = r3.getContacts();
        if (r0 == null) goto L7;
        r1 = (r1 * 31) + r0.hashCode();
    L7:
        MessageTypeEnum r4 = r3.getMessageType();
        if (r4 == null) goto L10;
        r1 = (r1 * 31) + r4.name().hashCode();
    L10:
        List<FileEntity> r5 = r3.getFiles();
        if (r5 == null) goto L13;
        r1 = (r1 * 31) + r5.hashCode();
    L13:
        MessageStatusTypeEnum r6 = r3.getMessageStatusType();
        if (r6 == null) goto L16;
        r1 = (r1 * 31) + r6.name().hashCode();
    L16:
        GroupChatEntity r7 = r3.getGroupChat();
        if (r7 != null) goto L19;
        return r1;
    L19:
        return (r1 * 31) + r7.hashCode();
    L21:
        throw new IllegalStateException("Check failed.".toString());
    }
}
