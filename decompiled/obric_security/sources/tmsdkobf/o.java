package tmsdkobf;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Pattern;
import tmsdk.common.TMSDKContext;
import tmsdk.common.module.update.UpdateConfig;
import tmsdk.fg.module.cleanV2.AppGroupDesc;

/* JADX INFO: loaded from: classes5.dex */
public abstract class o {
    public static HashMap a() {
        HashMap r3 = new HashMap();
        k2 r4 = (k2) mg.a(TMSDKContext.getApplicaionContext(), UpdateConfig.DEEP_CLEAN_APPGROUP_DESC, UpdateConfig.intToString(40350), new k2(), "UTF-8");
        if (r4 == null) goto L137;
        ArrayList r6 = r4.f299a;
        if (r6 == null) goto L182;
        Iterator r7 = r6.iterator();
    L9:
        if (r7.hasNext() == false) goto L31;
        j2 r8 = (j2) r7.next();
        if (TextUtils.isEmpty(r8.f281a) == true) goto L9;
        if (TextUtils.isEmpty(r8.b) == true) goto L9;
        AppGroupDesc r9 = new AppGroupDesc();     // Catch: Throwable -> L139
        int r10 = Integer.parseInt(r8.f281a);     // Catch: Throwable -> L139
        r9.mType = r10;     // Catch: Throwable -> L139
        if (r10 == 1) goto L20;
        if (r10 != 2) goto L9;
    L20:
        r9.mGroupId = Integer.parseInt(r8.b);     // Catch: Throwable -> L139
        r9.mTitle = r8.c;     // Catch: Throwable -> L139
        r9.mDesc = r8.d;     // Catch: Throwable -> L139
        r9.mShowPhoto = TextUtils.equals(r8.e, "1");     // Catch: Throwable -> L139
        r3.put(Integer.valueOf(r9.mGroupId), r9);     // Catch: Throwable -> L139
        if (TextUtils.equals(r8.e, "1") == true) goto L25;
        if (TextUtils.equals(r8.e, "0") == true) goto L25;
    L29:
        r3.remove(Integer.valueOf(r9.mGroupId));     // Catch: Throwable -> L139
    L25:
        if (TextUtils.isEmpty(r8.c) == true) goto L29;
        if (TextUtils.isEmpty(r8.d) == true) goto L29;
        r3.put(Integer.valueOf(r9.mGroupId), r9);     // Catch: Throwable -> L139
        goto L9
    L31:
        String r2 = h8.d().e().toLowerCase();
        String r11 = h8.d().b().toLowerCase();
        String r12 = h8.d().f().toLowerCase();
        boolean r13 = tb.c();
        if (r13 == false) goto L34;
    L64:
        Iterator r14 = r3.entrySet().iterator();
    L66:
        if (r14.hasNext() == false) goto L136;
        Map.Entry r15 = (Map.Entry) r14.next();
        Integer r16 = (Integer) r15.getKey();
        Iterator r17 = r4.f299a.iterator();
        boolean r18 = false;
        j2 r19 = null;
    L69:
        if (r17.hasNext() == false) goto L131;
        j2 r20 = (j2) r17.next();
        if (TextUtils.isEmpty(r20.f281a) == false) goto L73;
    L127:
        k2 r110 = r4;
    L128:
        Iterator r111 = r14;
    L129:
        Integer r21 = r16;
    L130:
        r4 = r110;
        r14 = r111;
        r16 = r21;
        goto L69
    L73:
        if (TextUtils.isEmpty(r20.b) == true) goto L127;
        if (TextUtils.isEmpty(r20.c) == true) goto L127;
        if (TextUtils.isEmpty(r20.d) == true) goto L127;
        if (TextUtils.isEmpty(r20.f) == true) goto L127;
        r110 = r4;
        if (TextUtils.equals(String.valueOf(10), r20.f281a) == false) goto L128;
        if (TextUtils.equals(String.valueOf(r16), r20.b) == false) goto L128;
        String r5 = r20.f.toLowerCase();     // Catch: Throwable -> L126
        String r22 = r20.g;     // Catch: Throwable -> L126
        String r112 = "";
        if (r22 == null) goto L91;
        String r23 = r22.toLowerCase();     // Catch: Throwable -> L126
    L92:
        r111 = r14;
        String r113 = r20.h;     // Catch: Throwable -> L141
        if (r113 == null) goto L96;
        r112 = r113.toLowerCase();     // Catch: Throwable -> L141
    L96:
        if (r19 == null) goto L98;
        r21 = r16;
    L105:
        if (r13 == false) goto L111;
        if (r19 == null) goto L130;
        AppGroupDesc r24 = (AppGroupDesc) r15.getValue();     // Catch: Throwable -> L109
        r24.mTitle = r19.c;     // Catch: Throwable -> L109
        String r25 = r19.d;     // Catch: Throwable -> L109
    L124:
        r24.mDesc = r25;     // Catch: Throwable -> L109
        r18 = true;
    L132:
        if (r18 == true) goto L135;
        if (r19 == null) goto L135;
        AppGroupDesc r26 = (AppGroupDesc) r15.getValue();
        r26.mTitle = r19.c;
        r26.mDesc = r19.d;
    L135:
        r4 = r110;
        r14 = r111;
    L109:
        r18 = true;
        goto L130
    L111:
        if (Pattern.compile(r5).matcher(r2).matches() == false) goto L130;
        if (TextUtils.isEmpty(r23) == true) goto L119;
        if (Pattern.compile(r23).matcher(r11).matches() == false) goto L130;
    L119:
        if (TextUtils.isEmpty(r112) == true) goto L123;
        if (Pattern.compile(r112).matcher(r12).matches() == false) goto L130;
    L123:
        r24 = (AppGroupDesc) r15.getValue();     // Catch: Throwable -> L109
        r24.mTitle = r20.c;     // Catch: Throwable -> L109
        r25 = r20.d;     // Catch: Throwable -> L109
        goto L124
    L98:
        r21 = r16;
        if (Pattern.compile("^(" + r5 + ")$").matcher("en").matches() == false) goto L102;
    L103:
        r19 = r20;
        goto L105
    L102:
        if (Pattern.compile("^(" + r5 + ")$").matcher("eng").matches() == false) goto L105;
    L91:
        r23 = "";
    L126:
        r111 = r14;
        goto L129
    L131:
        r110 = r4;
        r111 = r14;
        goto L132
    L136:
        return r3;
    L34:
        if (TextUtils.equals(r2, "zh") == true) goto L40;
        if (TextUtils.equals(r2, "zho") == true) goto L40;
        if (TextUtils.equals(r2, "chi") == false) goto L64;
    L40:
        if (TextUtils.equals(r12, "hans") == false) goto L43;
    L63:
        return r3;
    L43:
        if (TextUtils.equals(r12, "hant") == true) goto L50;
        if (TextUtils.equals(r11, "cn") == true) goto L63;
        if (TextUtils.equals(r11, "chn") == true) goto L63;
    L50:
        if (TextUtils.equals(r12, "hant") == true) goto L64;
        if (TextUtils.equals(r11, "tw") == true) goto L64;
        if (TextUtils.equals(r11, "twn") == true) goto L64;
        if (TextUtils.equals(r11, "hk") == true) goto L64;
        if (TextUtils.equals(r11, "hkg") == true) goto L64;
        if (TextUtils.equals(r11, "mo") == true) goto L64;
        if (TextUtils.equals(r11, "mac") == true) goto L64;
    L182:
        return null;
    L137:
        return null;
    }
}
