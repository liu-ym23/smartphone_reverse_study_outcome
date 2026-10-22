package tmsdkobf;

import android.content.ContentProviderOperation;
import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import tmsdk.common.tcc.TccCryptor;

/* JADX INFO: loaded from: classes5.dex */
public class bc {
    private static bc b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private o3 f117a;

    private bc() {
        this.f117a = ((me) qd.a(9)).a("QQSecureProvider");
    }

    public boolean a(String r8) {
        if (r8 != null) goto L5;
        return false;
    L5:
        ArrayList r1 = new ArrayList();
        r1.add(ContentProviderOperation.newDelete(this.f117a.d("up")).withSelection("info1 = ?", new String[]{r8}).build());
        ContentValues r0 = new ContentValues();
        r0.put("info1", r8);
        r0.put("info2", Long.valueOf(System.currentTimeMillis()));
        r1.add(ContentProviderOperation.newInsert(this.f117a.c("up")).withValues(r0).build());
        this.f117a.a(r1);
        this.f117a.close();
        return true;
    }

    public boolean b(String r5) {
        if (r5 != null) goto L5;
        return false;
    L5:
        ArrayList r1 = new ArrayList();
        r1.add(ContentProviderOperation.newDelete(this.f117a.d("up")).withSelection("info1 = ?", new String[]{r5}).build());
        this.f117a.a(r1);
        this.f117a.close();
        return true;
    }

    public List c(String r6) {
        Cursor r0 = this.f117a.e("SELECT info2 FROM dcr_info WHERE info1='" + r6 + "'");
        if (r0 != null) goto L28;
        byte[] r3 = null;
    L21:
        this.f117a.close();
        if (r3 != null) goto L25;
        return null;
    L25:
        return cc.b(r6, r3);
    L28:
        int r2 = r0.getColumnIndex("info2");     // Catch: Throwable -> L12 Exception -> L14
        r3 = null;
    L26:
    L10:
        e = e;
    L16:
        e.printStackTrace();     // Catch: Throwable -> L12
    L17:
        r0.close();
        goto L21
    L7:
        if (r0.moveToNext() == false) goto L17;
        r3 = r0.getBlob(r2);     // Catch: Exception -> L10 Throwable -> L12
    L12:
        th = move-exception;
        r0.close();
        throw th;
    L14:
        e = e;
        r3 = null;
        goto L16
    }

    public Map d(String r9) {
        boolean r0 = tb.c();
        HashMap r2 = null;
        Cursor r1 = this.f117a.e("SELECT * FROM dcp_info WHERE info2=(x'" + y5.a(TccCryptor.encrypt(r9.getBytes(), null)) + "')");
        if (r1 != null) goto L32;
    L30:
        this.f117a.close();
        return r2;
    L32:
        int r3 = r1.getColumnIndex("info1");     // Catch: Throwable -> L23 Exception -> L25
        int r4 = r1.getColumnIndex("info3");     // Catch: Throwable -> L23 Exception -> L25
        int r5 = r1.getColumnIndex("info4");     // Catch: Throwable -> L23 Exception -> L25
        HashMap r6 = new HashMap();     // Catch: Throwable -> L23 Exception -> L25
    L34:
        if (r1.moveToNext() == false) goto L20;
        String r7 = r1.getString(r3);     // Catch: Exception -> L21 Throwable -> L23
        he r8 = (he) r6.get(r7);     // Catch: Exception -> L21 Throwable -> L23
        if (r8 != null) goto L11;
        he r10 = new he();     // Catch: Exception -> L21 Throwable -> L23
        r10.f246a = r7;     // Catch: Exception -> L21 Throwable -> L23
        r6.put(r7, r10);     // Catch: Exception -> L21 Throwable -> L23
        r8 = (he) r6.get(r7);     // Catch: Exception -> L21 Throwable -> L23
    L11:
        if (r8.b != null) goto L13;
        r8.b = new HashMap();     // Catch: Exception -> L21 Throwable -> L23
    L13:
        byte[] r11 = r1.getBlob(r5);     // Catch: Exception -> L21 Throwable -> L23
        if (r0 == false) goto L17;
        if (r11 == null) goto L17;
        Map r12 = r8.b;     // Catch: Exception -> L21 Throwable -> L23
        String r13 = a(r1.getBlob(r5));     // Catch: Exception -> L21 Throwable -> L23
    L18:
        r12.put(r9, r13);     // Catch: Exception -> L21 Throwable -> L23
    L17:
        r12 = r8.b;     // Catch: Exception -> L21 Throwable -> L23
        r13 = a(r1.getBlob(r4));     // Catch: Exception -> L21 Throwable -> L23
        goto L18
    L20:
        r1.close();
        r2 = r6;
    L21:
        e = e;
        r2 = r6;
    L26:
        e.printStackTrace();     // Catch: Throwable -> L23
        r1.close();
    L25:
        e = e;
    L23:
        th = move-exception;
        r1.close();
        throw th;
    }

    private String a(byte[] r1) {
        if (r1 == null) goto L8;
        byte[] r2 = TccCryptor.decrypt(r1, null);
        if (r2 != null) goto L7;
        return null;
    L7:
        return new String(r2);
    L8:
        return null;
    }

    public Map b() {
        HashMap r0 = new HashMap();
        Cursor r1 = this.f117a.e("SELECT info1,info2 FROM up");
        if (r1 != null) goto L20;
    L18:
        this.f117a.close();
        return r0;
    L20:
        int r2 = r1.getColumnIndex("info1");     // Catch: Throwable -> L11 Exception -> L13
        int r3 = r1.getColumnIndex("info2");     // Catch: Throwable -> L11 Exception -> L13
    L6:
        if (r1.moveToNext() == false) goto L15;
        if (r1.getString(r2) == null) goto L6;
        r0.put(r1.getString(r2), Long.valueOf(r1.getLong(r3)));     // Catch: Throwable -> L11 Exception -> L13
    L15:
        r1.close();
    L13:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        r1.close();
        throw th;
    }

    public HashMap c() {
        HashMap r0 = new HashMap();
        Cursor r1 = this.f117a.e("SELECT info1,info2 FROM dcr_info");
        if (r1 != null) goto L20;
    L18:
        this.f117a.close();
        return r0;
    L20:
        int r2 = r1.getColumnIndex("info1");     // Catch: Throwable -> L11 Exception -> L13
        int r3 = r1.getColumnIndex("info2");     // Catch: Throwable -> L11 Exception -> L13
    L6:
        if (r1.moveToNext() == false) goto L15;
        String r4 = r1.getString(r2);     // Catch: Throwable -> L11 Exception -> L13
        byte[] r5 = r1.getBlob(r3);     // Catch: Throwable -> L11 Exception -> L13
        he r6 = new he();     // Catch: Throwable -> L11 Exception -> L13
        r6.f246a = r4;     // Catch: Throwable -> L11 Exception -> L13
        List r7 = cc.b(r4, r5);     // Catch: Throwable -> L11 Exception -> L13
        if (r7 == null) goto L6;
        r6.a(r7);     // Catch: Throwable -> L11 Exception -> L13
        r0.put(r4, r6);     // Catch: Throwable -> L11 Exception -> L13
    L15:
        r1.close();
    L13:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        r1.close();
        throw th;
    }

    public boolean d() {
        Cursor r0 = this.f117a.e("SELECT * FROM dcp_info");
        if (r0 != null) goto L5;
    L7:
        boolean r1 = true;
    L8:
        if (r0 == null) goto L10;
        r0.close();
    L10:
        this.f117a.close();
        return r1;
    L5:
        if (r0.getCount() >= 10) goto L7;
        r1 = false;
        goto L8
    }

    public static bc a() {
        if (b != null) goto L6;
        b = new bc();
    L6:
        return b;
    }

    public Map a(String r7, boolean r8) {
        HashMap r0 = new HashMap();
        Cursor r9 = this.f117a.e("SELECT info2,info3,info4 FROM dcp_info WHERE info1='" + r7 + "'");
        if (r9 != null) goto L23;
    L21:
        this.f117a.close();
        return r0;
    L23:
        int r1 = r9.getColumnIndex("info2");     // Catch: Throwable -> L14 Exception -> L16
        int r2 = r9.getColumnIndex("info3");     // Catch: Throwable -> L14 Exception -> L16
        int r3 = r9.getColumnIndex("info4");     // Catch: Throwable -> L14 Exception -> L16
    L5:
        if (r9.moveToNext() == false) goto L18;
        byte[] r4 = r9.getBlob(r3);     // Catch: Throwable -> L14 Exception -> L16
        if (r8 == false) goto L11;
        if (r4 == null) goto L11;
        String r5 = a(r9.getBlob(r1));     // Catch: Throwable -> L14 Exception -> L16
        String r6 = a(r9.getBlob(r3));     // Catch: Throwable -> L14 Exception -> L16
    L12:
        r0.put(r5, r6);     // Catch: Throwable -> L14 Exception -> L16
    L11:
        r5 = a(r9.getBlob(r1));     // Catch: Throwable -> L14 Exception -> L16
        r6 = a(r9.getBlob(r2));     // Catch: Throwable -> L14 Exception -> L16
    L18:
        r9.close();
        goto L21
    L16:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        r9.close();
        throw th;
    }

    public List a(List r18) {
        String r1 = null;
        if (r18 != null) goto L5;
        return null;
    L5:
        ArrayList r2 = new ArrayList();
        ArrayList r3 = new ArrayList();
        Iterator r4 = r18.iterator();
    L7:
        if (r4.hasNext() == false) goto L48;
        mk r5 = (mk) r4.next();
        TreeMap r6 = new TreeMap();
        Iterator r7 = r5.f357a.iterator();
        String r10 = r1;
        boolean r9 = false;
    L10:
        if (r7.hasNext() == false) goto L31;
        Map r11 = (Map) r7.next();
        if (r11.get(2) != null) goto L13;
        if (r11.get(5) == null) goto L10;
        String r15 = (String) r11.get(24);
        if (TextUtils.isEmpty(r15) == false) goto L21;
        r15 = (String) r11.get(6);
    L21:
        String r8 = (String) r11.get(17);
        if (TextUtils.isEmpty(r15) == false) goto L24;
        r15 = r8;
    L24:
        String r12 = (String) r11.get(5);
        if (TextUtils.isEmpty(r8) == false) goto L27;
        r8 = r15;
    L27:
        if (r15 == null) goto L10;
        if (r12 == null) goto L10;
        r6.put(r12, new String[]{r15, r8});
        goto L10
    L13:
        r10 = ((String) r11.get(2)).toLowerCase();
        r9 = ((String) r11.get(16)).equals("1");
        if (r9 == false) goto L10;
    L31:
        if (r10 == null) goto L32;
        String[] r13 = {r10};
        r3.add(ContentProviderOperation.newDelete(this.f117a.d("dcr_info")).withSelection("info1 = ?", r13).build());
        r3.add(ContentProviderOperation.newDelete(this.f117a.d("dcp_info")).withSelection("info1 = ?", r13).build());
        if (r9 == true) goto L47;
        ContentValues r14 = new ContentValues();
        r14.put("info1", r10);
        r14.put("info2", r5.toByteArray());
        r3.add(ContentProviderOperation.newInsert(this.f117a.c("dcr_info")).withValues(r14).build());
        Iterator r16 = r6.entrySet().iterator();
    L37:
        if (r16.hasNext() == false) goto L47;
        Map.Entry r17 = (Map.Entry) r16.next();
        ContentValues r19 = new ContentValues();
        r19.put("info2", c3.a(((String) r17.getKey()).toUpperCase()));
        String[] r20 = (String[]) r17.getValue();
        if (r20.length <= 0) goto L42;
        r19.put("info3", c3.a(r20[0].toUpperCase()));
    L42:
        if (r20.length <= 1) goto L46;
        if (TextUtils.isEmpty(r20[1]) == true) goto L46;
        r19.put("info4", c3.a(r20[1].toUpperCase()));
    L46:
        r19.put("info1", r10);
        r3.add(ContentProviderOperation.newInsert(this.f117a.c("dcp_info")).withValues(r19).build());
    L47:
        r2.add(r10);
    L32:
        r1 = null;
        goto L7
    L48:
        this.f117a.a(r3);
        this.f117a.close();
        return r2;
    }
}
