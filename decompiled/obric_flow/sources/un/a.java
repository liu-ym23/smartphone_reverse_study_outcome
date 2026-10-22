package un;

import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f22417a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f22418b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList f22419c;
    public final HashMap d;
    public final ReadableMap e;

    public a(int r5, int r10, ArrayList r11, HashMap r12, ReadableMap r13) {
        this.f22417a = r5;
        this.f22418b = r10;
        this.f22419c = new ArrayList(r11);
        this.d = new HashMap(r12);
        this.e = r13;
    }

    public static HashMap a(ReadableArray r14) {
        if (r14 != null) goto L5;
        return null;
    L5:
        HashMap r5 = new HashMap();
        int r10 = 0;
    L7:
        if (r10 >= r14.size()) goto L38;
        ReadableMap r11 = r14.getMap(r10);
        int r12 = r11.getInt("id");
        int r13 = r11.getInt("type");
        ReadableArray r15 = r11.getArray("callbackNames");
        ArrayList r16 = new ArrayList();
        if (r15 == null) goto L14;
        int r17 = 0;
    L12:
        if (r17 >= r15.size()) goto L14;
        r16.add(r15.getString(r17));
        r17 = r17 + 1;
    L14:
        HashMap r18 = new HashMap();
        ReadableMap r19 = r11.getMap("relationMap");
        if (r19 == null) goto L37;
        ReadableArray r110 = r19.getArray("simultaneous");
        if (r110 == null) goto L23;
        ArrayList r111 = new ArrayList();
        int r112 = 0;
    L20:
        if (r112 >= r110.size()) goto L22;
        r111.add(Integer.valueOf(r110.getInt(r112)));
        r112 = r112 + 1;
        goto L20
    L22:
        r18.put("simultaneous", r111);
    L23:
        ReadableArray r113 = r19.getArray("waitFor");
        if (r113 == null) goto L30;
        ArrayList r114 = new ArrayList();
        int r115 = 0;
    L27:
        if (r115 >= r113.size()) goto L29;
        r114.add(Integer.valueOf(r113.getInt(r115)));
        r115 = r115 + 1;
        goto L27
    L29:
        r18.put("waitFor", r114);
    L30:
        ReadableArray r20 = r19.getArray("continueWith");
        if (r20 == null) goto L37;
        ArrayList r116 = new ArrayList();
        int r117 = 0;
    L34:
        if (r117 >= r20.size()) goto L36;
        r116.add(Integer.valueOf(r20.getInt(r117)));
        r117 = r117 + 1;
        goto L34
    L36:
        r18.put("continueWith", r116);
    L37:
        r5.put(Integer.valueOf(r12), new a(r12, r13, r16, r18, r11.getMap("configMap")));
        r10 = r10 + 1;
        goto L7
    L38:
        return r5;
    }
}
