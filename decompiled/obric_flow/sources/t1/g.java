package t1;

import android.app.Application;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.CalendarContract;
import cn.nubia.neopush.commons.Constant;
import com.bytedance.ai.bridge.calendar.AbsGetCalendarObjectsMethodIDL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
public abstract class g {
    public static ArrayList a(Application r10, long r11) {
        ArrayList r5 = new ArrayList();
        String[] r12 = {String.valueOf(r11)};
        ContentResolver r13 = r10.getContentResolver();
        Cursor r14 = r13.query(CalendarContract.Reminders.CONTENT_URI, new String[]{"minutes", "method"}, "event_id = ?", r12, null);
        if (r14 != null) goto L19;
        return r5;
    L19:
    L7:
        th = move-exception;
        throw th;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        CloseableKt.closeFinally(r14, th);
        throw th;
    L5:
        if (r14.moveToNext() == false) goto L9;
        r5.add(new j(r14.getInt(0), r14.getInt(1)));     // Catch: Throwable -> L7
        goto L19
    L9:
        Unit r15 = Unit.INSTANCE;     // Catch: Throwable -> L7
        CloseableKt.closeFinally(r14, null);
        return r5;
    }

    public static ArrayList b(Application r40, Long r41, Long r42) {
        Intrinsics.checkNotNullParameter(r40, "context");
        ArrayList r5 = new ArrayList();
        ArrayList r10 = new ArrayList();
        Uri r11 = CalendarContract.Events.CONTENT_URI;
        String[] r12 = {"_id", Constant.TITLE, Constant.DESCRIPTION, "dtstart", "dtend", "duration", "eventLocation", "eventTimezone", "allDay", "rrule", "rdate", "duration", "eventStatus", "originalInstanceTime", "original_id"};
        StringBuilder r13 = new StringBuilder("(original_id IS NULL)");
        if (r41 == null) goto L7;
        if (r42 == null) goto L7;
        r13.append(" AND ((dtstart >= ? AND dtend <= ?) OR (dtstart >= ? AND rrule IS NOT NULL))");
        String[] r14 = {r41.toString(), r42.toString(), r41.toString()};
    L6:
        String[] r15 = r14;
    L12:
        Cursor r16 = r40.getContentResolver().query(r11, r12, r13.toString(), r15, "dtstart ASC");
        if (r16 != null) goto L130;
    L25:
        Iterator r17 = r10.iterator();
    L27:
        if (r17.hasNext() == false) goto L127;
        i r18 = (i) r17.next();
        SimpleDateFormat r19 = k.f22085a;
        Intrinsics.checkNotNullParameter(r18, "event");
        StringBuilder r20 = new StringBuilder("BEGIN:VCALENDAR\r\nVERSION:2.0\r\nPRODID:-//Android Calendar Export//EN\r\nBEGIN:VEVENT\r\n");
        String r21 = "UID:";
        StringBuilder r22 = new StringBuilder("UID:");
        r22.append(r18.f22074a);
        String r23 = "@android.local\r\n";
        r22.append("@android.local\r\n");
        r20.append(r22.toString());
        r20.append("DTSTAMP:" + k.f22085a.format(new Date()) + "\r\n");
        long r110 = k.a(r18.d, r18.e, r18.f22078i, r18.f22081l);
        boolean r24 = r18.f22078i;
        String r25 = "DTEND";
        String r111 = "DTSTART";
        String r112 = "DTEND;VALUE=DATE:";
        String r113 = "DTSTART;VALUE=DATE:";
        long r26 = r18.d;
        Iterator r43 = r17;
        String r27 = r18.g;
        if (r24 == false) goto L31;
        SimpleDateFormat r28 = k.f22086b;
        String r29 = r28.format(new Date(r26));
        String r30 = r28.format(new Date(r110));
        r20.append("DTSTART;VALUE=DATE:" + r29 + "\r\n");
        r20.append("DTEND;VALUE=DATE:" + r30 + "\r\n");
    L32:
        String r31 = "SUMMARY:";
        r20.append("SUMMARY:" + k.c(r18.f22075b) + "\r\n");
        String r32 = "DESCRIPTION:";
        String r33 = r18.f22076c;
        if (r33 != null) goto L35;
    L38:
        String r34 = "LOCATION:";
        String r114 = r18.f;
        if (r114 != null) goto L41;
    L44:
        String r115 = "DURATION:";
        String r116 = r18.f22081l;
        if (r116 != null) goto L47;
    L50:
        String r117 = r18.f22079j;
        if (r117 == null) goto L56;
        if (StringsKt.isBlank(r117) == true) goto L56;
        r20.append("RRULE:" + r117 + "\r\n");
    L56:
        String r35 = r18.f22080k;
        if (r35 != null) goto L59;
    L62:
        ArrayList r36 = new ArrayList();
        List r118 = r18.f22082m;
        Iterator r119 = r118.iterator();
    L64:
        if (r119.hasNext() == false) goto L69;
        String r44 = r32;
        Object r37 = r119.next();
        Iterator r120 = r119;
        String r210 = r115;
        if (((h) r37).f22071i != 2) goto L68;
        r36.add(r37);
    L68:
        r32 = r44;
        r119 = r120;
        r115 = r210;
        goto L64
    L69:
        String r45 = r32;
        String r211 = r115;
        Iterator r38 = r36.iterator();
    L71:
        if (r38.hasNext() == false) goto L73;
        r20.append("EXDATE:" + k.f22085a.format(new Date(((h) r38.next()).f22067a)) + "\r\n");
        r38 = r38;
        r25 = r25;
        goto L71
    L73:
        String r212 = r25;
        Iterator r39 = r18.f22077h.iterator();
    L74:
        String r46 = "END:VALARM\r\n";
        String r121 = r111;
        String r213 = r112;
        if (r39.hasNext() == false) goto L84;
        j r47 = (j) r39.next();
        Iterator r214 = r39;
        int r48 = r47.f22084b;
        String r215 = r113;
        if (r48 != 2) goto L79;
        String r49 = "EMAIL";
    L83:
        r20.append("BEGIN:VALARM\r\n");
        r20.append("ACTION:" + r49 + "\r\n");
        r20.append("DESCRIPTION:Reminder\r\n");
        r20.append("TRIGGER:-PT" + Math.abs(r47.f22083a) + "M\r\n");
        r20.append("END:VALARM\r\n");
        r111 = r121;
        r112 = r213;
        r39 = r214;
        r113 = r215;
        goto L74
    L79:
        if (r48 == 3) goto L81;
        r49 = "DISPLAY";
        goto L83
    L81:
        r49 = "SMS";
        goto L83
    L84:
        String r216 = r113;
        r20.append("END:VEVENT\r\n");
        boolean r50 = r118.isEmpty();
        String r122 = "END:VEVENT\r\n";
        long r51 = r18.f22074a;
        if (r50 == true) goto L126;
        Iterator r52 = r118.iterator();
    L88:
        if (r52.hasNext() == false) goto L126;
        h r123 = (h) r52.next();
        SimpleDateFormat r217 = k.f22085a;
        r52 = r52;
        String r218 = r122;
        if (r123.f22071i != 2) goto L91;
        r122 = r218;
        r23 = r23;
        goto L88
    L91:
        r20.append("BEGIN:VEVENT\r\n");
        r20.append(r21 + r51 + r23);
        StringBuilder r53 = new StringBuilder("RECURRENCE-ID");
        String r124 = r21;
        String r219 = r23;
        r53.append(k.b(r123.f22067a, r27));
        r53.append("\r\n");
        r20.append(r53.toString());
        r20.append(r31 + k.c(r123.f22068b) + "\r\n");
        long r310 = r51;
        String r54 = r46;
        String r311 = r31;
        long r55 = k.a(r123.g, r123.f22070h, r123.f, r123.f22072j);
        boolean r56 = r123.f;
        long r57 = r123.g;
        if (r56 == false) goto L94;
        SimpleDateFormat r58 = k.f22086b;
        String r59 = r58.format(new Date(r57));
        String r60 = r58.format(new Date(r55));
        r20.append(r216 + r59 + "\r\n");
        r20.append(r213 + r60 + "\r\n");
        String r61 = r121;
        String r62 = r212;
    L95:
        String r63 = r123.f22072j;
        if (r63 != null) goto L98;
    L99:
        String r64 = r211;
    L101:
        String r65 = r123.f22069c;
        if (r65 != null) goto L104;
    L105:
        String r66 = r45;
    L107:
        String r67 = r123.d;
        if (r67 != null) goto L110;
    L111:
        String r68 = r34;
    L113:
        Iterator r69 = r123.f22073k.iterator();
    L115:
        if (r69.hasNext() == false) goto L124;
        j r70 = (j) r69.next();
        r20.append("BEGIN:VALARM\r\n");
        int r125 = r70.f22084b;
        String r410 = r68;
        if (r125 != 2) goto L119;
        String r126 = "EMAIL";
    L123:
        r20.append("ACTION:" + r126 + "\r\n");
        r20.append("TRIGGER:-PT" + Math.abs(r70.f22083a) + "M\r\n");
        r20.append(r54);
        r68 = r410;
        goto L115
    L119:
        if (r125 == 3) goto L121;
        r126 = "DISPLAY";
        goto L123
    L121:
        r126 = "SMS";
        goto L123
    L124:
        r34 = r68;
        r20.append(r218);
        r211 = r64;
        r212 = r62;
        r45 = r66;
        r51 = r310;
        r31 = r311;
        r46 = r54;
        r23 = r219;
        r122 = r218;
        r27 = r27;
        r121 = r61;
        r21 = r124;
        goto L88
    L110:
        if (StringsKt.isBlank(r67) == true) goto L111;
        r68 = r34;
        r20.append(r68 + k.c(r67) + "\r\n");
        goto L113
    L104:
        if (StringsKt.isBlank(r65) == true) goto L105;
        r66 = r45;
        r20.append(r66 + k.c(r65) + "\r\n");
        goto L107
    L98:
        if (StringsKt.isBlank(r63) == true) goto L99;
        r64 = r211;
        r20.append(r64 + r63 + "\r\n");
        goto L101
    L94:
        r61 = r121;
        r20.append(r61 + k.b(r57, r27) + "\r\n");
        r62 = r212;
        r20.append(r62 + k.b(r55, r27) + "\r\n");
    L126:
        long r312 = r51;
        r20.append("END:VCALENDAR\r\n");
        r5 = r5;
        r5.add(new AbsGetCalendarObjectsMethodIDL.CalendarEvent(String.valueOf(r312), androidx.constraintlayout.motion.widget.a.j(r312, "local://event/"), r20.toString(), null, 8, null));
        r17 = r43;
        goto L27
    L59:
        if (StringsKt.isBlank(r35) == true) goto L62;
        r20.append("RDATE" + r35 + "\r\n");
        goto L62
    L47:
        if (StringsKt.isBlank(r116) == true) goto L50;
        r20.append("DURATION:" + k.c(r116) + "\r\n");
        goto L50
    L41:
        if (StringsKt.isBlank(r114) == true) goto L44;
        r20.append("LOCATION:" + k.c(r114) + "\r\n");
        goto L44
    L35:
        if (StringsKt.isBlank(r33) == true) goto L38;
        r20.append("DESCRIPTION:" + k.c(r33) + "\r\n");
        goto L38
    L31:
        r20.append("DTSTART" + k.b(r26, r27) + "\r\n");
        r20.append("DTEND" + k.b(r110, r27) + "\r\n");
        goto L32
    L127:
        return r5;
    L130:
    L17:
        th = move-exception;
        throw th;     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        CloseableKt.closeFinally(r16, th);
        throw th;
    L15:
        if (r16.moveToNext() == false) goto L19;
        r10.add(c(r16, r40));     // Catch: Throwable -> L17
        goto L130
    L19:
        Unit r71 = Unit.INSTANCE;     // Catch: Throwable -> L17
        CloseableKt.closeFinally(r16, null);
    L7:
        if (r41 == null) goto L9;
        r13.append(" AND ((dtstart >= ?))");
        r14 = new String[]{r41.toString()};
        goto L6
    L9:
        if (r42 == null) goto L11;
        r13.append(" AND ((dtstart >= ? AND dtend <= ?) OR (dtstart >= ? AND rrule IS NOT NULL))");
        r14 = new String[]{r42.toString(), r42.toString(), r42.toString()};
        goto L6
    L11:
        r15 = null;
        goto L12
    }

    public static i c(Cursor r39, Application r40) {
        long r5 = r39.getLong(r39.getColumnIndexOrThrow("_id"));
        String r10 = r39.getString(r39.getColumnIndexOrThrow(Constant.TITLE));
        int r11 = r39.getColumnIndexOrThrow("rrule");
        if (r39.isNull(r11) == false) goto L5;
        String r14 = null;
    L6:
        long r12 = r39.getLong(r39.getColumnIndexOrThrow("dtstart"));
        long r13 = r39.getLong(r39.getColumnIndexOrThrow("dtend"));
        int r15 = r39.getInt(r39.getColumnIndexOrThrow("eventStatus"));
        String r17 = "dtstart";
        String r18 = "dtend";
        long r16 = r39.getLong(r39.getColumnIndexOrThrow("original_id"));
        String r19 = "eventStatus";
        String r21 = "originalInstanceTime";
        String r20 = "_id";
        long r22 = r39.getLong(r39.getColumnIndexOrThrow("originalInstanceTime"));
        StringBuilder r110 = new StringBuilder();
        r110.append(r10);
        r110.append(" eventId: ");
        r110.append(r5);
        r110.append(", rrule: ");
        r110.append(r14);
        r110.append(", start: ");
        r110.append(r12);
        kotlin.collections.a.o(r110, ", end: ", r13, ", status: ");
        r110.append(r15);
        r110.append(", originalID: ");
        r110.append(r16);
        r110.append(", originalTime: ");
        r110.append(r22);
        String r23 = r110.toString();
        Intrinsics.checkNotNullParameter("LocalCalendarAdapter", "tag");
        t0.d r24 = com.bytedance.ai.utils.c.f2846a;
        if (r24 == null) goto L10;
        r24.d("LocalCalendarAdapter", r23);
    L10:
        if (r14 != null) goto L12;
    L13:
        long r25 = r5;
        String r26 = r14;
        String r27 = r17;
        String r111 = r18;
        String r28 = null;
        r40 = r40;
        List r29 = CollectionsKt.emptyList();
    L46:
        String r30 = r39.getString(r39.getColumnIndexOrThrow(Constant.TITLE));
        int r31 = r39.getColumnIndexOrThrow(Constant.DESCRIPTION);
        if (r39.isNull(r31) == false) goto L49;
        String r32 = r28;
    L50:
        int r33 = r39.getColumnIndexOrThrow("eventLocation");
        if (r39.isNull(r33) == false) goto L53;
        String r112 = r28;
    L54:
        long r113 = r39.getLong(r39.getColumnIndexOrThrow(r27));
        long r114 = r39.getLong(r39.getColumnIndexOrThrow(r111));
        if (r39.getInt(r39.getColumnIndexOrThrow("allDay")) != 1) goto L57;
        boolean r115 = true;
    L58:
        String r34 = r39.getString(r39.getColumnIndexOrThrow("eventTimezone"));
        int r35 = r39.getColumnIndexOrThrow("rdate");
        if (r39.isNull(r35) == false) goto L61;
        String r210 = r28;
    L62:
        int r36 = r39.getColumnIndexOrThrow("duration");
        if (r39.isNull(r36) == false) goto L66;
        String r37 = r28;
    L65:
        long r38 = r25;
        return new i(r38, r30, r32, r113, r114, r112, r34, a(r40, r38), r115, r26, r210, r37, r29);
    L66:
        r37 = r39.getString(r36);
        goto L65
    L61:
        r210 = r39.getString(r35);
        goto L62
    L57:
        r115 = false;
        goto L58
    L53:
        r112 = r39.getString(r33);
        goto L54
    L49:
        r32 = r39.getString(r31);
        goto L50
    L12:
        if (r14.length() == 0) goto L13;
        ArrayList r116 = new ArrayList();
        Cursor r117 = r40.getContentResolver().query(CalendarContract.Events.CONTENT_URI, new String[]{"_id", "originalInstanceTime", Constant.TITLE, Constant.DESCRIPTION, "dtstart", "dtend", "duration", "eventStatus", "eventLocation", "eventTimezone", "allDay"}, "original_id=?", new String[]{String.valueOf(r5)}, null);
        if (r117 != null) goto L69;
        r25 = r5;
        r26 = r14;
        r27 = r17;
        r111 = r18;
        r28 = null;
    L44:
        r29 = r116;
    L69:
    L35:
        th = move-exception;
        throw th;     // Catch: Throwable -> L40
    L40:
        th = move-exception;
        CloseableKt.closeFinally(r117, th);
        throw th;
    L17:
        if (r117.moveToNext() == false) goto L37;
        String r118 = r20;
        long r211 = r5;
        long r41 = r117.getLong(r117.getColumnIndexOrThrow(r118));     // Catch: Throwable -> L35
        String r119 = r21;
        long r212 = r117.getLong(r117.getColumnIndexOrThrow(r119));     // Catch: Throwable -> L35
        String r213 = r117.getString(r117.getColumnIndexOrThrow(Constant.TITLE));     // Catch: Throwable -> L35
        int r42 = r117.getColumnIndexOrThrow(Constant.DESCRIPTION);     // Catch: Throwable -> L35
        if (r117.isNull(r42) == false) goto L21;
        String r214 = null;
    L22:
        int r43 = r117.getColumnIndexOrThrow("eventLocation");     // Catch: Throwable -> L35
        if (r117.isNull(r43) == false) goto L25;
        String r215 = null;
    L26:
        long r310 = r117.getLong(r117.getColumnIndexOrThrow(r17));     // Catch: Throwable -> L35
        String r120 = r18;
        long r311 = r117.getLong(r117.getColumnIndexOrThrow(r120));     // Catch: Throwable -> L35
        String r216 = r14;
        if (r117.getInt(r117.getColumnIndexOrThrow("allDay")) != 1) goto L29;
        boolean r312 = true;
    L30:
        String r313 = r117.getString(r117.getColumnIndexOrThrow("eventTimezone"));     // Catch: Throwable -> L35
        int r121 = r117.getColumnIndexOrThrow("duration");     // Catch: Throwable -> L35
        if (r117.isNull(r121) == false) goto L33;
        String r314 = null;
    L34:
        r116.add(new h(r212, r213, r214, r215, r313, r312, r310, r311, r117.getInt(r117.getColumnIndexOrThrow(r19)), r314, a(r40, r41)));     // Catch: Throwable -> L35
        r17 = r17;
        r19 = r19;
        r20 = r118;
        r14 = r216;
        r5 = r211;
        r18 = r120;
        r21 = r119;
        goto L69
    L33:
        r314 = r117.getString(r121);     // Catch: Throwable -> L35
        goto L34
    L29:
        r312 = false;
        goto L30
    L25:
        r215 = r117.getString(r43);     // Catch: Throwable -> L35
        goto L26
    L21:
        r214 = r117.getString(r42);     // Catch: Throwable -> L35
        goto L22
    L37:
        r25 = r5;
        r26 = r14;
        r27 = r17;
        r111 = r18;
        Unit r44 = Unit.INSTANCE;     // Catch: Throwable -> L35
        r28 = null;
        CloseableKt.closeFinally(r117, null);
        goto L44
    L5:
        r14 = r39.getString(r11);
        goto L6
    }
}
