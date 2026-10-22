package com.obric.capabilitykit.common;

import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.ContactEntity;
import com.obric.capabilitykit.entity.app.ScheduleEntity;
import com.obric.capabilitykit.entity.enums.CalendarTypeEnum;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/obric/capabilitykit/entity/app/ScheduleEntityHashCodeGenerator;", "Lcom/obric/capabilitykit/entity/app/IEntityHashCodeGenerator;", "()V", "generatorHashCode", "", "instance", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class i0 implements a0 {
    public static final i0 a = null;

    static {
        a = new i0();
    }

    private i0() {
    }

    @Override // com.obric.capabilitykit.common.a0
    public int a(AppEntity r3) {
        Intrinsics.checkNotNullParameter(r3, "instance");
        if ((r3 instanceof ScheduleEntity) == false) goto L51;
        ScheduleEntity r4 = (ScheduleEntity) r3;
        int r2 = ((((r4.getName().hashCode() + 0) * 31) + r4.getStartTime().hashCode()) * 31) + r4.getEndTime().hashCode();
        String r0 = r4.getAddress();
        if (r0 == null) goto L7;
        r2 = (r2 * 31) + r0.hashCode();
    L7:
        List<ContactEntity> r1 = r4.getAttendees();
        if (r1 == null) goto L10;
        r2 = (r2 * 31) + r1.hashCode();
    L10:
        String r5 = r4.getRepeatDescription();
        if (r5 == null) goto L13;
        r2 = (r2 * 31) + r5.hashCode();
    L13:
        Long r6 = r4.getStartTimestamp();
        if (r6 == null) goto L16;
        r2 = (r2 * 31) + Long.hashCode(r6.longValue());
    L16:
        Long r7 = r4.getEndTimestamp();
        if (r7 == null) goto L19;
        r2 = (r2 * 31) + Long.hashCode(r7.longValue());
    L19:
        int r8 = (r2 * 31) + Boolean.hashCode(r4.getAllDay());
        String r9 = r4.getNote();
        if (r9 == null) goto L22;
        r8 = (r8 * 31) + r9.hashCode();
    L22:
        Boolean r10 = r4.getCompleted();
        if (r10 == null) goto L25;
        r8 = (r8 * 31) + Boolean.hashCode(r10.booleanValue());
    L25:
        int r11 = (r8 * 31) + Boolean.hashCode(r4.isFavorite());
        String r12 = r4.getReminderDesc();
        if (r12 == null) goto L28;
        r11 = (r11 * 31) + r12.hashCode();
    L28:
        String r13 = r4.getTimeDescription();
        if (r13 == null) goto L31;
        r11 = (r11 * 31) + r13.hashCode();
    L31:
        String r14 = r4.getRruleDescription();
        if (r14 == null) goto L34;
        r11 = (r11 * 31) + r14.hashCode();
    L34:
        String r15 = r4.getIcsId();
        if (r15 == null) goto L37;
        r11 = (r11 * 31) + r15.hashCode();
    L37:
        String r16 = r4.getRecurrenceId();
        if (r16 == null) goto L40;
        r11 = (r11 * 31) + r16.hashCode();
    L40:
        CalendarTypeEnum r17 = r4.getCalendarType();
        if (r17 == null) goto L43;
        r11 = (r11 * 31) + r17.name().hashCode();
    L43:
        String r18 = r4.getICalendarText();
        if (r18 == null) goto L46;
        r11 = (r11 * 31) + r18.hashCode();
    L46:
        Long r19 = r4.getJumpCalendarPageStartTimeStamp();
        if (r19 != null) goto L49;
        return r11;
    L49:
        return (r11 * 31) + Long.hashCode(r19.longValue());
    L51:
        throw new IllegalStateException("Check failed.".toString());
    }
}
