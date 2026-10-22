package com.obric.capabilitykit.common;

import com.obric.capabilitykit.entity.app.AlarmEntity;
import com.obric.capabilitykit.entity.app.AlbumEntity;
import com.obric.capabilitykit.entity.app.AuditoryRecordingEntity;
import com.obric.capabilitykit.entity.app.BrowserBookmarkEntity;
import com.obric.capabilitykit.entity.app.CallHistoryEntity;
import com.obric.capabilitykit.entity.app.CloudDocumentEntity;
import com.obric.capabilitykit.entity.app.ContactEntity;
import com.obric.capabilitykit.entity.app.CountdownEntity;
import com.obric.capabilitykit.entity.app.DoubaoAccountEntity;
import com.obric.capabilitykit.entity.app.FileEntity;
import com.obric.capabilitykit.entity.app.GroupChatEntity;
import com.obric.capabilitykit.entity.app.ICSProtocolEntity;
import com.obric.capabilitykit.entity.app.LifeLogEntity;
import com.obric.capabilitykit.entity.app.MessageEntity;
import com.obric.capabilitykit.entity.app.NoteEntity;
import com.obric.capabilitykit.entity.app.PhotoEntity;
import com.obric.capabilitykit.entity.app.PhotoFaceEntity;
import com.obric.capabilitykit.entity.app.ProactiveMemoryEntity;
import com.obric.capabilitykit.entity.app.RecordingEntity;
import com.obric.capabilitykit.entity.app.ScheduleEntity;
import com.obric.capabilitykit.entity.app.StockEntity;
import com.obric.capabilitykit.entity.app.UserProfileEntity;
import com.obric.capabilitykit.entity.app.WebsiteEntity;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/obric/capabilitykit/entity/app/EntityHashCodeGeneratorMapping;", "", "()V", "hashCodeMapping", "", "", "Lcom/obric/capabilitykit/entity/app/IEntityHashCodeGenerator;", "getHashCodeMapping$capabilitykitcommon_release", "()Ljava/util/Map;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class v {
    public static final v a = null;
    private static final Map<String, a0> b = null;

    static {
        a = new v();
        LinkedHashMap r0 = new LinkedHashMap();
        b = r0;
        String r1 = CloudDocumentEntity.class.getName();
        Intrinsics.checkNotNullExpressionValue(r1, "CloudDocumentEntity::class.java.name");
        r0.put(r1, p.a);
        String r2 = WebsiteEntity.class.getName();
        Intrinsics.checkNotNullExpressionValue(r2, "WebsiteEntity::class.java.name");
        r0.put(r2, l0.a);
        String r3 = ContactEntity.class.getName();
        Intrinsics.checkNotNullExpressionValue(r3, "ContactEntity::class.java.name");
        r0.put(r3, s.a);
        String r4 = FileEntity.class.getName();
        Intrinsics.checkNotNullExpressionValue(r4, "FileEntity::class.java.name");
        r0.put(r4, x.a);
        String r5 = AuditoryRecordingEntity.class.getName();
        Intrinsics.checkNotNullExpressionValue(r5, "AuditoryRecordingEntity::class.java.name");
        r0.put(r5, m.a);
        String r6 = AlarmEntity.class.getName();
        Intrinsics.checkNotNullExpressionValue(r6, "AlarmEntity::class.java.name");
        r0.put(r6, j.a);
        String r7 = ICSProtocolEntity.class.getName();
        Intrinsics.checkNotNullExpressionValue(r7, "ICSProtocolEntity::class.java.name");
        r0.put(r7, z.a);
        String r8 = CallHistoryEntity.class.getName();
        Intrinsics.checkNotNullExpressionValue(r8, "CallHistoryEntity::class.java.name");
        r0.put(r8, o.a);
        String r9 = StockEntity.class.getName();
        Intrinsics.checkNotNullExpressionValue(r9, "StockEntity::class.java.name");
        r0.put(r9, j0.a);
        String r10 = DoubaoAccountEntity.class.getName();
        Intrinsics.checkNotNullExpressionValue(r10, "DoubaoAccountEntity::class.java.name");
        r0.put(r10, u.a);
        String r11 = BrowserBookmarkEntity.class.getName();
        Intrinsics.checkNotNullExpressionValue(r11, "BrowserBookmarkEntity::class.java.name");
        r0.put(r11, n.a);
        String r12 = AlbumEntity.class.getName();
        Intrinsics.checkNotNullExpressionValue(r12, "AlbumEntity::class.java.name");
        r0.put(r12, k.a);
        String r13 = PhotoFaceEntity.class.getName();
        Intrinsics.checkNotNullExpressionValue(r13, "PhotoFaceEntity::class.java.name");
        r0.put(r13, f0.a);
        String r14 = ProactiveMemoryEntity.class.getName();
        Intrinsics.checkNotNullExpressionValue(r14, "ProactiveMemoryEntity::class.java.name");
        r0.put(r14, g0.a);
        String r15 = GroupChatEntity.class.getName();
        Intrinsics.checkNotNullExpressionValue(r15, "GroupChatEntity::class.java.name");
        r0.put(r15, y.a);
        String r16 = UserProfileEntity.class.getName();
        Intrinsics.checkNotNullExpressionValue(r16, "UserProfileEntity::class.java.name");
        r0.put(r16, k0.a);
        String r17 = ScheduleEntity.class.getName();
        Intrinsics.checkNotNullExpressionValue(r17, "ScheduleEntity::class.java.name");
        r0.put(r17, i0.a);
        String r18 = LifeLogEntity.class.getName();
        Intrinsics.checkNotNullExpressionValue(r18, "LifeLogEntity::class.java.name");
        r0.put(r18, b0.a);
        String r19 = NoteEntity.class.getName();
        Intrinsics.checkNotNullExpressionValue(r19, "NoteEntity::class.java.name");
        r0.put(r19, d0.a);
        String r20 = MessageEntity.class.getName();
        Intrinsics.checkNotNullExpressionValue(r20, "MessageEntity::class.java.name");
        r0.put(r20, c0.a);
        String r21 = RecordingEntity.class.getName();
        Intrinsics.checkNotNullExpressionValue(r21, "RecordingEntity::class.java.name");
        r0.put(r21, h0.a);
        String r22 = PhotoEntity.class.getName();
        Intrinsics.checkNotNullExpressionValue(r22, "PhotoEntity::class.java.name");
        r0.put(r22, e0.a);
        String r23 = CountdownEntity.class.getName();
        Intrinsics.checkNotNullExpressionValue(r23, "CountdownEntity::class.java.name");
        r0.put(r23, t.a);
    }

    private v() {
    }

    public final Map<String, a0> a() {
        return b;
    }
}
