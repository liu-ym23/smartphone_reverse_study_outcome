package androidx.room.util;

import android.util.Log;
import androidx.room.Room;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: StringUtil.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\u001a\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b\u001a\u0018\u0010\f\u001a\u0004\u0018\u00010\u00022\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u000e\u001a\u0006\u0010\u000f\u001a\u00020\t\u001a\u0018\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0002\" \u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0005\u0012\u0004\b\u0003\u0010\u0004¨\u0006\u0011"}, d2 = {"EMPTY_STRING_ARRAY", "", "", "getEMPTY_STRING_ARRAY$annotations", "()V", "[Ljava/lang/String;", "appendPlaceholders", "", "builder", "Ljava/lang/StringBuilder;", "count", "", "joinIntoString", "input", "", "newStringBuilder", "splitToIntList", "room-runtime_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class StringUtil {
    public static final String[] EMPTY_STRING_ARRAY = null;

    public static /* synthetic */ void getEMPTY_STRING_ARRAY$annotations() {
    }

    static {
        EMPTY_STRING_ARRAY = new String[0];
    }

    public static final StringBuilder newStringBuilder() {
        return new StringBuilder();
    }

    public static final void appendPlaceholders(StringBuilder r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "builder");
        int r0 = 0;
    L3:
        if (r0 >= r3) goto L8;
        r2.append("?");
        if (r0 >= (r3 - 1)) goto L7;
        r2.append(",");
    L7:
        r0 = r0 + 1;
        goto L3
    }

    public static final List<Integer> splitToIntList(String r7) {
        if (r7 == null) goto L25;
        List r8 = StringsKt.split$default(r7, new char[]{','}, false, 0, 6, null);
        if (r8 == null) goto L26;
        ArrayList r1 = new ArrayList();
        Iterator r9 = r8.iterator();
    L8:
        if (r9.hasNext() == false) goto L17;
        Integer r2 = Integer.valueOf(Integer.parseInt((String) r9.next()));     // Catch: NumberFormatException -> L12
    L14:
        if (r2 == null) goto L8;
        r1.add(r2);
    L12:
        e = move-exception;
        Log.e(Room.LOG_TAG, "Malformed integer list", e);
        Integer r3 = (Integer) null;
        r2 = null;
        goto L14
    L17:
        return r1;
    L26:
        return null;
    L25:
        return null;
    }

    public static final String joinIntoString(List<Integer> r9) {
        if (r9 != null) goto L6;
        return null;
    L6:
        return CollectionsKt.joinToString$default(r9, ",", null, null, 0, null, null, 62, null);
    }
}
