package tmsdkobf;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class ke extends ContentProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f307a;

    public ke(Context r1) {
        this.f307a = r1;
    }

    private String a(Object r1) {
        if ((r1 instanceof String) == false) goto L6;
        return "String";
    L6:
        if ((r1 instanceof Integer) == false) goto L9;
        return "Int";
    L9:
        if ((r1 instanceof Boolean) == false) goto L12;
        return "Boolean";
    L12:
        if ((r1 instanceof Float) == false) goto L15;
        return "Float";
    L15:
        if ((r1 instanceof Long) == false) goto L19;
        return "Long";
    L19:
        throw new RuntimeException("cannot parse type def!");
    }

    @Override // android.content.ContentProvider
    public int delete(Uri r1, String r2, String[] r3) {
        String r4 = a(r1);
        if (r4 == null) goto L11;
        SharedPreferences.Editor r0 = this.f307a.getSharedPreferences(r4, 0).edit();
        if (r2 != null) goto L7;
        r0.clear();
    L9:
        return r0.commit() ? 1 : 0;
    L7:
        r0.remove(r2);
        goto L9
    L11:
        throw new RuntimeException("[delete] sharedPreferences failed:file name should not be null(uri=" + r1 + ")");
    }

    @Override // android.content.ContentProvider
    public String getType(Uri r1) {
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri r5, ContentValues r6) {
        String r0 = a(r5);
        if (r0 == null) goto L35;
        if (r6 == null) goto L35;
        SharedPreferences.Editor r4 = this.f307a.getSharedPreferences(r0, 0).edit();
        Iterator<Map.Entry<String, Object>> r7 = r6.valueSet().iterator();
    L8:
        if (r7.hasNext() == false) goto L30;
        Map.Entry<String, Object> r1 = r7.next();
        String r2 = r1.getKey();
        Object r3 = r1.getValue();
        if (r3 == null) goto L11;
        if ((r3 instanceof String) == true) goto L14;
        if ((r3 instanceof Integer) == true) goto L17;
        if ((r3 instanceof Boolean) == true) goto L20;
        if ((r3 instanceof Float) == true) goto L23;
        if ((r3 instanceof Long) == false) goto L28;
        r4.putLong(r2, Long.parseLong(r3.toString()));
        goto L8
    L28:
        throw new IllegalArgumentException("not supported type.");
    L23:
        r4.putFloat(r2, Float.parseFloat(r3.toString()));
        goto L8
    L20:
        r4.putBoolean(r2, Boolean.parseBoolean(r3.toString()));
        goto L8
    L17:
        r4.putInt(r2, Integer.parseInt(r3.toString()));
        goto L8
    L14:
        r4.putString(r2, r3.toString());
        goto L8
    L11:
        r4.remove(r2);
        goto L8
    L30:
        if (r4.commit() == false) goto L32;
        return r5;
    L32:
        return null;
    L35:
        if (("[insert] sharedPreferences failed:" + r0) != null) goto L37;
        String r8 = "file name ";
    L39:
        throw new RuntimeException(r8);
    L37:
        r8 = "valuesshould not be null(uri=" + r5 + ")";
        goto L39
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri r7, String[] r8, String r9, String[] r10, String r11) {
        String r12 = a(r7);
        if (r12 == null) goto L5;
        SharedPreferences r13 = this.f307a.getSharedPreferences(r12, 0);
        MatrixCursor r1 = null;
        if (r11 != null) goto L24;
        Map<String, ?> r14 = r13.getAll();
        if (r14 == null) goto L23;
        r1 = new MatrixCursor(new String[]{"key", "value", "typedef"}, r14.size());
        Iterator<Map.Entry<String, ?>> r15 = r14.entrySet().iterator();
    L16:
        if (r15.hasNext() == false) goto L23;
        Map.Entry<String, ?> r16 = r15.next();
        String r17 = r16.getKey();
        Object r18 = r16.getValue();
        String r0 = a(r18);
        if (r0 == null) goto L16;
        if ("Boolean".equals(r0) == true) goto L21;
        r1.addRow(new Object[]{r17, r18, r0});
        goto L16
    L21:
        r1.addRow(new Object[]{r17, Integer.valueOf(((Boolean) r18).booleanValue() ? 1 : 0), r0});
    L23:
        return r1;
    L24:
        MatrixCursor r6 = new MatrixCursor(new String[]{"value"}, 1);
        String r19 = r7.getPathSegments().get(1);
        if (r13.contains(r11) == true) goto L27;
    L43:
        return r6;
    L27:
        if ("String".equals(r19) == false) goto L30;
        r6.addRow(new String[]{r13.getString(r11, null)});
        goto L43
    L30:
        if ("Boolean".equals(r19) == false) goto L33;
        r6.addRow(new Integer[]{Integer.valueOf(r13.getBoolean(r11, false) ? 1 : 0)});
        goto L43
    L33:
        if ("Int".equals(r19) == false) goto L36;
        r6.addRow(new Integer[]{Integer.valueOf(r13.getInt(r11, 0))});
        goto L43
    L36:
        if ("Float".equals(r19) == false) goto L39;
        r6.addRow(new Float[]{Float.valueOf(r13.getFloat(r11, 0.0f))});
        goto L43
    L39:
        if ("Long".equals(r19) == false) goto L42;
        r6.addRow(new Long[]{Long.valueOf(r13.getLong(r11, 0))});
        goto L43
    L42:
        throw new RuntimeException("cannot parse type def!");
    L5:
        if (("[query] sharedPreferences failed:" + r12) != null) goto L7;
        String r20 = "file name ";
    L9:
        throw new RuntimeException(r20);
    L7:
        r20 = "selectionshould not be null(uri=" + r7 + ")";
        goto L9
    }

    @Override // android.content.ContentProvider
    public int update(Uri r1, ContentValues r2, String r3, String[] r4) {
        throw new UnsupportedOperationException("[update] not implement");
    }

    private String a(Uri r1) {
    L6:
        e = move-exception;
        q8.b("SpProvider", e);
    L8:
        return null;
    L3:
        if (r1.getPathSegments().size() <= 0) goto L8;
        return r1.getPathSegments().get(0);
    }
}
