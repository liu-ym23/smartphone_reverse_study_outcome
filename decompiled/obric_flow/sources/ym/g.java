package ym;

import ai.j0;
import android.util.Log;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.DefaultType;
import com.bytedance.sdk.xbridge.cn.registry.core.exception.IllegalInputParamException;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.behavior.v0;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class g implements com.bytedance.sdk.xbridge.cn.protocol.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f23298a;

    public static Object e(Method r5, dj.c r10) {
        Class<?> r11 = r5.getReturnType();
        boolean r12 = true;
        if (Intrinsics.areEqual(r11, Number.class) == false) goto L19;
        DefaultType r13 = r10.defaultValue().type();
        int r14 = com.bytedance.sdk.xbridge.cn.platform.lynx.h.f7373a[r13.ordinal()];
        if (r14 == 1) goto L17;
        if (r14 == 2) goto L15;
        if (r14 == 3) goto L13;
        return Integer.valueOf(r10.defaultValue().intValue());
    L13:
        return Integer.valueOf(r10.defaultValue().intValue());
    L15:
        return Long.valueOf(r10.defaultValue().longValue());
    L17:
        return Double.valueOf(r10.defaultValue().doubleValue());
    L19:
        if (Intrinsics.areEqual(r11, Boolean.TYPE) == true) goto L22;
        r12 = Intrinsics.areEqual(r11, Boolean.class);
    L22:
        if (r12 == false) goto L26;
        return Boolean.valueOf(r10.defaultValue().boolValue());
    L26:
        return r10.defaultValue().stringValue();
    }

    public static HashMap f(Class r10, HashMap r11) {
        if (r10 == null) goto L14;
        Method[] r12 = r10.getDeclaredMethods();
        if (r12 == null) goto L14;
        ArrayList r5 = new ArrayList();
        int r13 = r12.length;
        int r14 = 0;
    L7:
        if (r14 >= r13) goto L15;
        Method r15 = r12[r14];
        dj.c r16 = (dj.c) r15.getAnnotation(dj.c.class);
        if (r16 == null) goto L13;
        if (r16.isGetter() != true) goto L13;
        r5.add(r15);
    L13:
        r14 = r14 + 1;
    L15:
        if (r5 == null) goto L41;
        HashMap r17 = new HashMap();
        Iterator r18 = r5.iterator();
    L18:
        if (r18.hasNext() == false) goto L40;
        Method r19 = (Method) r18.next();
        dj.c r20 = (dj.c) r19.getAnnotation(dj.c.class);
        Object r21 = r11.get(r20.keyPath());
        if (r21 == null) goto L22;
    L24:
        String r22 = r20.keyPath();
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(r20.nestedClassType()), Reflection.getOrCreateKotlinClass(fj.a.class)) == true) goto L30;
        if ((r21 instanceof ReadableMap) == false) goto L30;
        Object r23 = f(r20.nestedClassType(), ((ReadableMap) r21).toHashMap());
    L39:
        r17.put(r22, r23);
    L30:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(r20.nestedClassType()), Reflection.getOrCreateKotlinClass(fj.a.class)) == false) goto L32;
    L38:
        r23 = r11.get(r20.keyPath());
        goto L39
    L32:
        if ((r21 instanceof ReadableArray) == false) goto L38;
        ArrayList<Object> r24 = ((ReadableArray) r21).toArrayList();
        ArrayList r25 = new ArrayList(CollectionsKt.h(r24));
        Iterator<T> r26 = r24.iterator();
    L35:
        if (r26.hasNext() == false) goto L37;
        Object r27 = r26.next();
        Class r28 = r20.nestedClassType();
        Intrinsics.checkNotNull(r27, "null cannot be cast to non-null type com.lynx.react.bridge.ReadableMap");
        r25.add(f(r28, ((ReadableMap) r27).toHashMap()));
        goto L35
    L37:
        r23 = r25;
        goto L39
    L22:
        if (r20.defaultValue().type() == DefaultType.NONE) goto L24;
        r11.put(r20.keyPath(), e(r19, r20));
        goto L24
    L40:
        return r17;
    L41:
        return null;
    L14:
        r5 = null;
        goto L15
    }

    public static HashMap h(Class r16, HashMap r17) {
        Method[] r5 = r16.getDeclaredMethods();
        if (r5 == null) goto L137;
        HashMap r10 = new HashMap();
        int r11 = r5.length;
        int r12 = 0;
    L5:
        if (r12 >= r11) goto L10;
        Method r13 = r5[r12];
        dj.c r14 = (dj.c) r13.getAnnotation(dj.c.class);
        if (r14 == null) goto L9;
        r10.put(r14.keyPath(), new Pair(r13, r14));
    L9:
        r12 = r12 + 1;
        goto L5
    L10:
        LinkedHashMap r15 = new LinkedHashMap();
        Iterator r18 = r10.entrySet().iterator();
    L12:
        if (r18.hasNext() == false) goto L18;
        Map.Entry r19 = (Map.Entry) r18.next();
        if (r17.get(r19.getKey()) != null) goto L12;
        if (((dj.c) ((Pair) r19.getValue()).getSecond()).defaultValue().type() == DefaultType.NONE) goto L12;
        r15.put(r19.getKey(), r19.getValue());
        goto L12
    L18:
        Iterator r20 = r15.entrySet().iterator();
    L20:
        if (r20.hasNext() == false) goto L22;
        Map.Entry r21 = (Map.Entry) r20.next();
        r17.put(r21.getKey(), e((Method) ((Pair) r21.getValue()).getFirst(), (dj.c) ((Pair) r21.getValue()).getSecond()));
        goto L20
    L22:
        Iterator r22 = r10.entrySet().iterator();
    L24:
        if (r22.hasNext() == false) goto L136;
        Map.Entry r23 = (Map.Entry) r22.next();
        dj.c r24 = (dj.c) ((Pair) r23.getValue()).getSecond();
        Method r25 = (Method) ((Pair) r23.getValue()).getFirst();
        Object r26 = r17.get(r23.getKey());
        if (r24.required() == false) goto L31;
        if (r26 != null) goto L31;
        throw new IllegalInputParamException(j0.q(new StringBuilder(), (String) r23.getKey(), " param is missing from input"));
    L31:
        Class<?> r27 = r25.getReturnType();
        boolean r110 = true;
        if (Intrinsics.areEqual(r27, String.class) == false) goto L40;
        if (r26 != null) goto L35;
    L74:
        if (r26 == null) goto L24;
        if (r24.isEnum() == false) goto L24;
        Class<?> r28 = r25.getReturnType();
        if (Intrinsics.areEqual(r28, String.class) == true) goto L79;
        if (Intrinsics.areEqual(r28, Number.class) == true) goto L86;
        if (Intrinsics.areEqual(r28, Map.class) == false) goto L24;
        dj.f r29 = (dj.f) r25.getAnnotation(dj.f.class);
        if (r29 != null) goto L99;
        dj.b r30 = (dj.b) r25.getAnnotation(dj.b.class);
        if (r30 == null) goto L24;
        int[] r31 = r30.option();
        Map r32 = (Map) r26;
        if (r32.isEmpty() == true) goto L131;
        Iterator r33 = r32.entrySet().iterator();
    L120:
        if (r33.hasNext() == false) goto L131;
        Object r34 = ((Map.Entry) r33.next()).getValue();
        if ((r34 instanceof Number) == false) goto L126;
        if (ArraysKt.contains(r31, ((Number) r34).intValue()) == true) goto L120;
    L132:
        if (r110 == false) goto L24;
        throw new IllegalInputParamException(((String) r23.getKey()) + " has wrong value.should be one of " + ArraysKt.asList(r31) + " but got " + r26);
    L126:
        if (r34 != null) goto L130;
        throw new IllegalInputParamException("the key is null");
    L130:
        throw new IllegalInputParamException("the key is not a number");
    L131:
        r110 = false;
        goto L132
    L99:
        String[] r35 = r29.option();
        Map r36 = (Map) r26;
        if (r36.isEmpty() == true) goto L108;
        Iterator r37 = r36.entrySet().iterator();
    L104:
        if (r37.hasNext() == false) goto L108;
        if (ArraysKt.contains(r35, ((Map.Entry) r37.next()).getValue()) == true) goto L104;
    L109:
        if (r110 == false) goto L24;
        throw new IllegalInputParamException(((String) r23.getKey()) + " has wrong type.should be one of " + ArraysKt.asList(r35) + " but got " + r26);
    L108:
        r110 = false;
        goto L109
    L86:
        int[] r38 = ((dj.b) r25.getAnnotation(dj.b.class)).option();
        if ((r26 instanceof Number) == false) goto L94;
        if (ArraysKt.contains(r38, ((Number) r26).intValue()) == true) goto L24;
        throw new IllegalInputParamException(((String) r23.getKey()) + " has wrong value.should be one of " + ArraysKt.asList(r38) + " but got " + r26);
    L94:
        throw new IllegalInputParamException("the key is not a number");
    L79:
        String[] r39 = ((dj.f) r25.getAnnotation(dj.f.class)).option();
        if (ArraysKt.contains(r39, r26) == true) goto L24;
        throw new IllegalInputParamException(((String) r23.getKey()) + " has wrong type.should be one of " + ArraysKt.asList(r39) + " but got " + r26);
    L35:
        if ((r26 instanceof String) == true) goto L74;
        throw new IllegalInputParamException(androidx.room.jarjarred.org.antlr.runtime.a.u(new StringBuilder(), (String) r23.getKey(), " param has wrong declared type. except string,but ", r26));
    L40:
        if (Intrinsics.areEqual(r27, Number.class) == false) goto L48;
        if (r26 == null) goto L74;
        if ((r26 instanceof Number) == true) goto L74;
        throw new IllegalInputParamException(androidx.room.jarjarred.org.antlr.runtime.a.u(new StringBuilder(), (String) r23.getKey(), " param has wrong declared type. except number,but ", r26));
    L48:
        if (Intrinsics.areEqual(r27, Boolean.class) == false) goto L50;
        boolean r111 = true;
    L51:
        if (r111 == false) goto L59;
        if (r26 == null) goto L74;
        if ((r26 instanceof Boolean) == true) goto L74;
        throw new IllegalInputParamException(androidx.room.jarjarred.org.antlr.runtime.a.u(new StringBuilder(), (String) r23.getKey(), " param has wrong declared type. except boolean,but ", r26));
    L59:
        if (Intrinsics.areEqual(r27, List.class) == false) goto L67;
        if (r26 == null) goto L74;
        if ((r26 instanceof List) == true) goto L74;
        throw new IllegalInputParamException(androidx.room.jarjarred.org.antlr.runtime.a.u(new StringBuilder(), (String) r23.getKey(), " param has wrong declared type. except List ,but ", r26));
    L67:
        if (Intrinsics.areEqual(r27, Map.class) == false) goto L74;
        if (r26 == null) goto L74;
        if ((r26 instanceof Map) == true) goto L74;
        throw new IllegalInputParamException(androidx.room.jarjarred.org.antlr.runtime.a.u(new StringBuilder(), (String) r23.getKey(), " param has wrong declared type. except Map ,but ", r26));
    L50:
        r111 = Intrinsics.areEqual(r27, Boolean.TYPE);
        goto L51
    L136:
        return r10;
    L137:
        return null;
    }

    @Override // com.bytedance.sdk.xbridge.cn.protocol.g
    public LinkedHashMap a(Object r5) {
        ReadableMap r10 = (ReadableMap) r5;
        Intrinsics.checkNotNullParameter(r10, LynxResourceModule.PARAMS_KEY);
        return v0.o((JavaOnlyMap) r10);
    }

    @Override // com.bytedance.sdk.xbridge.cn.protocol.g
    public Map b(Class r5, Object r10, String r11) {
        ReadableMap r12 = (ReadableMap) r10;
        Intrinsics.checkNotNullParameter(r12, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r5, "clazz");
        Intrinsics.checkNotNullParameter(r11, "nameSpace");
        return g(r12, r5);
    }

    @Override // com.bytedance.sdk.xbridge.cn.protocol.g
    public /* bridge */ /* synthetic */ Map c(Class r5, Object r10) {
        return g((ReadableMap) r10, r5);
    }

    public Object d(Object r10, dj.c r11) {
        if ((r10 instanceof Map) == false) goto L21;
        if (r11 == null) goto L6;
        KClass r5 = Reflection.getOrCreateKotlinClass(r11.nestedClassType());
    L8:
        if (Intrinsics.areEqual(r5, Reflection.getOrCreateKotlinClass(fj.a.class)) == true) goto L21;
        if (r11 == null) goto L11;
        Class r12 = r11.nestedClassType();
    L12:
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type com.lynx.react.bridge.ReadableMap");
        HashMap<String, Object> r13 = ((ReadableMap) r10).toHashMap();
        if (r12 != null) goto L16;
        return null;
    L16:
        if (h(r12, r13) != null) goto L19;
        return null;
    L19:
        return Proxy.newProxyInstance(r12.getClassLoader(), new Class[]{r12}, new com.bytedance.sdk.xbridge.cn.platform.lynx.i(this, r12, r13, 0));
    L11:
        r12 = null;
        goto L12
    L6:
        r5 = null;
    L21:
        if ((r10 instanceof List) == false) goto L44;
        if (r11 == null) goto L24;
        KClass r14 = Reflection.getOrCreateKotlinClass(r11.nestedClassType());
    L26:
        if (Intrinsics.areEqual(r14, Reflection.getOrCreateKotlinClass(fj.a.class)) == true) goto L44;
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type kotlin.collections.List<*>");
        List r15 = (List) r10;
        ArrayList r16 = new ArrayList(CollectionsKt.h(r15));
        Iterator r17 = r15.iterator();
    L29:
        if (r17.hasNext() == false) goto L42;
        Object r18 = r17.next();
        if (r11 == null) goto L33;
        Class r19 = r11.nestedClassType();
    L34:
        Intrinsics.checkNotNull(r18, "null cannot be cast to non-null type com.lynx.react.bridge.ReadableMap");
        HashMap<String, Object> r20 = ((ReadableMap) r18).toHashMap();
        if (r19 != null) goto L38;
    L39:
        Object r21 = null;
    L41:
        r16.add(r21);
        goto L29
    L38:
        if (h(r19, r20) == null) goto L39;
        r21 = Proxy.newProxyInstance(r19.getClassLoader(), new Class[]{r19}, new com.bytedance.sdk.xbridge.cn.platform.lynx.i(this, r19, r20, 0));
        goto L41
    L33:
        r19 = null;
        goto L34
    L42:
        return r16;
    L24:
        r14 = null;
    L44:
        return v0.k(r10);
    }

    public LinkedHashMap g(ReadableMap r10, Class r11) {
        Intrinsics.checkNotNullParameter(r10, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r11, "clazz");
        cj.f r5 = (cj.f) cj.l.f1209a.get(r11);
        if (r5 == null) goto L12;
        HashMap<String, Object> r12 = r10.toHashMap();
        Intrinsics.checkNotNullParameter(r12, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r5, "clazz");
        cj.g r13 = com.lynx.tasm.behavior.ui.utils.e.b(r5.f1196c, r12);
        if (r13 != null) goto L7;
        return null;
    L7:
        LinkedHashMap r14 = new LinkedHashMap(MapsKt.mapCapacity(r12.size()));
        Iterator<T> r15 = r12.entrySet().iterator();
    L9:
        if (r15.hasNext() == false) goto L11;
        Map.Entry r16 = (Map.Entry) r15.next();
        r14.put(r16.getKey(), com.lynx.tasm.behavior.ui.utils.e.f(r16.getValue(), (cj.i) r13.f1198b.get(r16.getKey()), r5));
        goto L9
    L11:
        return r14;
    L12:
        Class r17 = f4.a.a(r11);
        if (r17 != null) goto L16;
        ConcurrentHashMap r18 = ki.b.f18649a;
        Intrinsics.checkNotNullParameter(r11, "clazz");
        ki.b.a(r11, dj.d.class);
        return null;
    L16:
        HashMap<String, Object> r19 = r10.toHashMap();
        HashMap r20 = h(r17, r19);
        if (r20 != null) goto L19;
        return null;
    L19:
        LinkedHashMap r21 = new LinkedHashMap(MapsKt.mapCapacity(r19.size()));
        Iterator<T> r22 = r19.entrySet().iterator();
    L21:
        if (r22.hasNext() == false) goto L27;
        Map.Entry r23 = (Map.Entry) r22.next();
        Object r24 = r23.getKey();
        Pair r25 = (Pair) r20.get(r23.getKey());
        if (r25 == null) goto L25;
        dj.c r26 = (dj.c) r25.getSecond();
    L26:
        r21.put(r24, d(r23.getValue(), r26));
        goto L21
    L25:
        r26 = null;
        goto L26
    L27:
        return r21;
    }

    public void i(int r5, String r10, String r11, Throwable r12) {
        Intrinsics.checkNotNullParameter(r11, "msg");
        if (r10 == null) goto L9;
        if (r10.length() == 0) goto L9;
        r11 = r10 + "-->" + r11;
    L9:
        if (this.f23298a == false) goto L12;
        r11 = "[" + Thread.currentThread().getName() + "]|" + r11;
    L12:
        if (r5 != 1) goto L14;
        Log.v("OUI_SDK", r11);
        return;
    L14:
        if (r5 != 2) goto L16;
        Log.d("OUI_SDK", r11);
        return;
    L16:
        if (r5 != 4) goto L18;
        Log.i("OUI_SDK", r11);
        return;
    L18:
        if (r5 != 8) goto L20;
        if (r12 != null) goto L27;
        Log.w("OUI_SDK", r11);
        return;
    L27:
        Log.w("OUI_SDK", r11, r12);
        return;
    L20:
        if (r5 != 16) goto L38;
        if (r12 != null) goto L24;
        Log.e("OUI_SDK", r11);
        return;
    L24:
        Log.e("OUI_SDK", r11, r12);
        return;
    }

    @Override // com.bytedance.sdk.xbridge.cn.protocol.g
    public Object a(HashMap r5, Class r10, bj.a r11) {
        Intrinsics.checkNotNullParameter(r5, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r10, "clazz");
        int r12 = r11.F;
        Object r13 = r5.get("__jsb2__data__");
        if (r13 == null) goto L11;
        if (this.f23298a == false) goto L9;
        return new com.bytedance.sdk.xbridge.cn.platform.lynx.j((JSONObject) r13);
    L9:
        return v0.h((JSONObject) r13, r12);
    L11:
        if (this.f23298a == false) goto L15;
        return new com.bytedance.sdk.xbridge.cn.platform.lynx.j(r5);
    L15:
        return v0.f(r12, r5);
    }
}
