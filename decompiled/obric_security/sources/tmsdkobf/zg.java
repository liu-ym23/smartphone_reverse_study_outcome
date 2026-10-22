package tmsdkobf;

import android.content.Context;
import com.bytedanceos.utils.Constants;
import java.util.HashMap;

/* JADX INFO: loaded from: classes5.dex */
public abstract class zg {

    class a extends ti {
        final /* synthetic */ int b;
        final /* synthetic */ long c;
        final /* synthetic */ ej d;
        final /* synthetic */ long e;
        final /* synthetic */ int f;
        final /* synthetic */ String g;
        final /* synthetic */ Context h;
        final /* synthetic */ z6 i;
        final /* synthetic */ int j;
        final /* synthetic */ int k;
        final /* synthetic */ boolean l;
        final /* synthetic */ boolean m;

        a(int r1, long r2, ej r4, long r5, int r7, String r8, Context r9, z6 r10, int r11, int r12, boolean r13, boolean r14) {
            this.b = r1;
            this.c = r2;
            this.d = r4;
            this.e = r5;
            this.f = r7;
            this.g = r8;
            this.h = r9;
            this.i = r10;
            this.j = r11;
            this.k = r12;
            this.l = r13;
            this.m = r14;
        }

        @Override // tmsdkobf.ti
        public void a() {
            HashMap r0 = new HashMap();
            r0.put("B5", "1");
            r0.put("B20", "");
            r0.put("B10", "");
            r0.put("B12", String.valueOf(this.b));
            r0.put("B23", String.valueOf(this.c));
            r0.put("B3", uj.a(this.d.f186a));
            r0.put("B11", String.valueOf(this.d.b));
            r0.put("B6", String.valueOf(this.e));
            r0.put("B7", String.valueOf(this.f));
            r0.put("B8", uj.a(this.g));
            r0.put("B4", String.valueOf(bl.a(this.h)));
            r0.put("B24", String.valueOf(tk.b(this.i.b(1))));
            r0.put("B25", String.valueOf(this.j));
            r0.put("B26", String.valueOf(this.k));
            String r5 = "false";
            String r6 = "notcheck";
            if (this.l == true) goto L5;
            r0.put("B9", "false");
            r0.put("B21", "false");
            r0.put("B22", "notcheck");
        L15:
            this.i.a(r0);
            return;
        L5:
            if (this.m == true) goto L7;
        L10:
            r0.put("B9", Constants.IS_SET);
            if (this.m == false) goto L13;
            r5 = Constants.IS_SET;
        L13:
            r0.put("B21", r5);
            r0.put("B22", r6);
            goto L15
        L7:
            if (bl.a("tcp report") == false) goto L9;
            r6 = Constants.IS_SET;
            goto L10
        L9:
            r6 = "false";
            goto L10
        }
    }

    public static void a(Context r16, ej r17, long r18, long r20, int r22, String r23, int r24, boolean r25, z6 r26, int r27, boolean r28, int r29) {
        if (r16 == null) goto L8;
        if (r17 == null) goto L9;
        if (r26 == null) goto L10;
        uk.a(new a(r24, r20, r17, r18, r22, r23, r16, r26, r27, r29, r25, r28), "reportConnectInfoAsyn");
        return;
    L10:
        return;
    L9:
        return;
    }
}
