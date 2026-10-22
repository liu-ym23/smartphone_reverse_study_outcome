package d.a.a.k;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.bdlocation.exception.BDLocationException;
import d.a.a.i.e;
import d.a.a.i.g;
import d.a.a.i.m;
import d.a.a.i.q.f;
import d.a.a.j.a0;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.AccessControlException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Currency;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f12543a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f12544b = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static ConcurrentMap<String, Class<?>> f12545c;

    static {
        ConcurrentHashMap r8 = new ConcurrentHashMap();
        f12545c = r8;
        r8.put("byte", Byte.TYPE);
        f12545c.put("short", Short.TYPE);
        f12545c.put("int", Integer.TYPE);
        f12545c.put("long", Long.TYPE);
        f12545c.put(TypedValues.Custom.S_FLOAT, Float.TYPE);
        f12545c.put("double", Double.TYPE);
        f12545c.put(TypedValues.Custom.S_BOOLEAN, Boolean.TYPE);
        f12545c.put("char", Character.TYPE);
        f12545c.put("[byte", byte[].class);
        f12545c.put("[short", short[].class);
        f12545c.put("[int", int[].class);
        f12545c.put("[long", long[].class);
        f12545c.put("[float", float[].class);
        f12545c.put("[double", double[].class);
        f12545c.put("[boolean", boolean[].class);
        f12545c.put("[char", char[].class);
        f12545c.put("[B", byte[].class);
        f12545c.put("[S", short[].class);
        f12545c.put("[I", int[].class);
        f12545c.put("[J", long[].class);
        f12545c.put("[F", float[].class);
        f12545c.put("[D", double[].class);
        f12545c.put("[C", char[].class);
        f12545c.put("[Z", boolean[].class);
        f12545c.put(HashMap.class.getName(), HashMap.class);
    }

    public static boolean A(Type r3) {
        if ((r3 instanceof ParameterizedType) == false) goto L6;
        return true;
    L6:
        if ((r3 instanceof Class) == false) goto L14;
        Type r4 = ((Class) r3).getGenericSuperclass();
        if (r4 == Object.class) goto L13;
        if (A(r4) == false) goto L13;
        return true;
    L13:
        return false;
    L14:
        return false;
    }

    private static boolean B(Class<?> r5, d.a.a.h.c r6, String r7) {
        if (r6 != null) goto L5;
    L12:
        Class<? super Object> r8 = r5.getSuperclass();
        if (r8 == Object.class) goto L21;
        if (r8 != null) goto L16;
        return false;
    L16:
        if (B(r8, (d.a.a.h.c) r8.getAnnotation(d.a.a.h.c.class), r7) == true) goto L18;
        return false;
    L18:
        return true;
    L21:
        return false;
    L5:
        if (r6.ignores() == null) goto L12;
        String[] r9 = r6.ignores();
        int r2 = r9.length;
        int r3 = 0;
    L7:
        if (r3 >= r2) goto L12;
        if (r7.equalsIgnoreCase(r9[r3]) == true) goto L10;
        r3 = r3 + 1;
        goto L7
    L10:
        return true;
    }

    public static Class<?> C(String r6, ClassLoader r7) {
        if (r6 != null) goto L4;
        return null;
    L4:
        if (r6.length() != 0) goto L7;
        return null;
    L7:
        if (r6.length() >= 256) goto L43;
        Class<?> r0 = f12545c.get(r6);
        if (r0 == null) goto L12;
        return r0;
    L12:
        if (r6.charAt(0) != '[') goto L16;
        return Array.newInstance(C(r6.substring(1), r7), 0).getClass();
    L16:
        if (r6.startsWith("L") == true) goto L18;
    L21:
        if (r7 != null) goto L52;
    L48:
        ClassLoader r1 = Thread.currentThread().getContextClassLoader();     // Catch: Exception -> L34
        if (r1 == null) goto L46;
        if (r1 == r7) goto L46;
        Class<?> r8 = r1.loadClass(r6);     // Catch: Exception -> L34
        f12545c.put(r6, r8);     // Catch: Exception -> L32
        return r8;
    L32:
        Exception e2 = e;
    L36:
        e2.printStackTrace();
        r0 = r8;
    L46:
        r0 = Class.forName(r6);     // Catch: Exception -> L39
        f12545c.put(r6, r0);     // Catch: Exception -> L39
        return r0;
    L39:
        e = move-exception;
        e.printStackTrace();
        return r0;
    L34:
        e = move-exception;
        Class<?> r5 = r0;
        e2 = e;
        r8 = r5;
        goto L36
    L52:
        r0 = r7.loadClass(r6);     // Catch: Exception -> L24
        f12545c.put(r6, r0);     // Catch: Exception -> L24
        return r0;
    L24:
        e = move-exception;
        e.printStackTrace();
        goto L48
    L18:
        if (r6.endsWith(";") == false) goto L21;
        return C(r6.substring(1, r6.length() - 1), r7);
    L43:
        throw new d.a.a.d("className too long. " + r6);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean D(Class<?> r3, Member r4, int r5) {
        if (r4 != 0) goto L5;
    L20:
        return false;
    L5:
        if (f12544b == false) goto L20;
        Class<? super Object> r6 = r3.getSuperclass();
        if (r6 == null) goto L12;
        if (r6 == Object.class) goto L12;
    L21:
        ((AccessibleObject) r4).setAccessible(true);     // Catch: AccessControlException -> L19
        return true;
    L19:
        f12544b = false;
    L12:
        if ((r4.getModifiers() & 1) == 0) goto L21;
        if ((r5 & 1) == 0) goto L21;
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> T a(Object r5, Class<T> r6, m r7) {
        if (r5 != 0) goto L5;
        return null;
    L5:
        if (r6 == null) goto L143;
        if (r6 != r5.getClass()) goto L10;
        return r5;
    L10:
        if ((r5 instanceof Map) == true) goto L12;
        int r3 = 0;
        if (r6.isArray() == false) goto L35;
        if ((r5 instanceof Collection) == false) goto L31;
        Collection r8 = (Collection) r5;
        T r0 = (T) Array.newInstance(r6.getComponentType(), r8.size());
        Iterator r9 = r8.iterator();
    L27:
        if (r9.hasNext() == false) goto L29;
        Array.set(r0, r3, a(r9.next(), r6.getComponentType(), r7));
        r3 = r3 + 1;
        goto L27
    L29:
        return r0;
    L31:
        if (r6 != byte[].class) goto L35;
        return (T) h(r5);
    L35:
        if (r6.isAssignableFrom(r5.getClass()) == false) goto L38;
        return r5;
    L38:
        if (r6 == Boolean.TYPE) goto L141;
        if (r6 == Boolean.class) goto L141;
        if (r6 == Byte.TYPE) goto L139;
        if (r6 == Byte.class) goto L139;
        if (r6 == Character.TYPE) goto L52;
        if (r6 == Character.class) goto L52;
    L58:
        if (r6 == Short.TYPE) goto L137;
        if (r6 == Short.class) goto L137;
        if (r6 == Integer.TYPE) goto L135;
        if (r6 == Integer.class) goto L135;
        if (r6 == Long.TYPE) goto L133;
        if (r6 == Long.class) goto L133;
        if (r6 == Float.TYPE) goto L131;
        if (r6 == Float.class) goto L131;
        if (r6 == Double.TYPE) goto L129;
        if (r6 == Double.class) goto L129;
        if (r6 != String.class) goto L87;
        return (T) r(r5);
    L87:
        if (r6 != BigDecimal.class) goto L91;
        return (T) d(r5);
    L91:
        if (r6 != BigInteger.class) goto L95;
        return (T) e(r5);
    L95:
        if (r6 != Date.class) goto L99;
        return (T) j(r5);
    L99:
        if (r6.isEnum() == false) goto L103;
        return (T) l(r5, r6, r7);
    L103:
        if (Calendar.class.isAssignableFrom(r6) == false) goto L115;
        Date r10 = j(r5);
        if (r6 != Calendar.class) goto L144;
        Object r11 = (T) Calendar.getInstance(d.a.a.a.f12369f, d.a.a.a.f12370g);
    L109:
        ((Calendar) r11).setTime(r10);
        return (T) r11;
    L144:
        r11 = (T) ((Calendar) r6.newInstance());
    L111:
        e = move-exception;
        throw new d.a.a.d("can not cast to : " + r6.getName(), e);
    L115:
        if ((r5 instanceof String) == false) goto L127;
        String r12 = (String) r5;
        if (r12.length() != 0) goto L119;
    L125:
        return null;
    L119:
        if ("null".equals(r12) == true) goto L125;
        if (r6 != Currency.class) goto L127;
        return (T) Currency.getInstance(r12);
    L127:
        throw new d.a.a.d("can not cast to : " + r6.getName());
    L129:
        return (T) k(r5);
    L131:
        return (T) m(r5);
    L133:
        return (T) p(r5);
    L135:
        return (T) n(r5);
    L137:
        return (T) q(r5);
    L52:
        if ((r5 instanceof String) == false) goto L58;
        String r1 = (String) r5;
        if (r1.length() != 1) goto L58;
        return (T) Character.valueOf(r1.charAt(0));
    L139:
        return (T) g(r5);
    L141:
        return (T) f(r5);
    L12:
        if (r6 != Map.class) goto L14;
        return r5;
    L14:
        Map r2 = (Map) r5;
        if (r6 != Object.class) goto L20;
        if (r2.containsKey("@type") == true) goto L20;
        return r5;
    L20:
        return (T) o(r2, r6, r7);
    L143:
        throw new IllegalArgumentException("clazz is null");
    }

    /* JADX WARN: Type inference failed for: r7v8, types: [T, java.util.HashMap, java.util.Map] */
    public static final <T> T b(Object r6, ParameterizedType r7, m r8) {
        Type r0 = r7.getRawType();
        if (r0 != Set.class) goto L5;
    L12:
        Type r1 = r7.getActualTypeArguments()[0];
        if ((r6 instanceof Iterable) == true) goto L15;
    L30:
        if (r0 != Map.class) goto L32;
    L33:
        Type r2 = r7.getActualTypeArguments()[0];
        Type r4 = r7.getActualTypeArguments()[1];
        if ((r6 instanceof Map) == false) goto L41;
        ?? r9 = (T) new HashMap();
        Iterator r10 = ((Map) r6).entrySet().iterator();
    L37:
        if (r10.hasNext() == false) goto L39;
        Map.Entry r3 = (Map.Entry) r10.next();
        r9.put(c(r3.getKey(), r2, r8), c(r3.getValue(), r4, r8));
        goto L37
    L39:
        return r9;
    L41:
        if ((r6 instanceof String) == false) goto L49;
        String r5 = (String) r6;
        if (r5.length() != 0) goto L45;
        return null;
    L45:
        if ("null".equals(r5) == false) goto L49;
        return null;
    L49:
        if (r7.getActualTypeArguments().length != 1) goto L55;
        if ((r7.getActualTypeArguments()[0] instanceof WildcardType) == false) goto L55;
        return (T) c(r6, r0, r8);
    L55:
        throw new d.a.a.d("can not cast to : " + r7);
    L32:
        if (r0 != HashMap.class) goto L41;
    L15:
        if (r0 != Set.class) goto L17;
    L23:
        T r11 = (T) new HashSet();
    L24:
        Iterator<T> r12 = ((Iterable) r6).iterator();
    L26:
        if (r12.hasNext() == false) goto L28;
        ((Collection) r11).add(c(r12.next(), r1, r8));
        goto L26
    L28:
        return r11;
    L17:
        if (r0 == HashSet.class) goto L23;
        if (r0 != TreeSet.class) goto L22;
        r11 = (T) new TreeSet();
        goto L24
    L22:
        r11 = (T) new ArrayList();
        goto L24
    L5:
        if (r0 == HashSet.class) goto L12;
        if (r0 == TreeSet.class) goto L12;
        if (r0 == List.class) goto L12;
        if (r0 != ArrayList.class) goto L30;
        goto L12
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> T c(Object r2, Type r3, m r4) {
        if (r2 != 0) goto L6;
        return null;
    L6:
        if ((r3 instanceof Class) == false) goto L10;
        return (T) a(r2, (Class) r3, r4);
    L10:
        if ((r3 instanceof ParameterizedType) == false) goto L14;
        return (T) b(r2, (ParameterizedType) r3, r4);
    L14:
        if ((r2 instanceof String) == false) goto L21;
        String r5 = (String) r2;
        if (r5.length() != 0) goto L18;
    L19:
        return null;
    L18:
        if ("null".equals(r5) == true) goto L19;
    L21:
        if ((r3 instanceof TypeVariable) == false) goto L24;
        return r2;
    L24:
        throw new d.a.a.d("can not cast to : " + r3);
    }

    public static final BigDecimal d(Object r2) {
        if (r2 != null) goto L6;
        return null;
    L6:
        if ((r2 instanceof BigDecimal) == false) goto L10;
        return (BigDecimal) r2;
    L10:
        if ((r2 instanceof BigInteger) == true) goto L12;
        String r3 = r2.toString();
        if (r3.length() != 0) goto L16;
        return null;
    L16:
        if ("null".equals(r3) == false) goto L19;
        return null;
    L19:
        return new BigDecimal(r3);
    L12:
        return new BigDecimal((BigInteger) r2);
    }

    public static final BigInteger e(Object r2) {
        if (r2 != null) goto L6;
        return null;
    L6:
        if ((r2 instanceof BigInteger) == false) goto L10;
        return (BigInteger) r2;
    L10:
        if ((r2 instanceof Float) == true) goto L22;
        if ((r2 instanceof Double) == true) goto L22;
        String r3 = r2.toString();
        if (r3.length() != 0) goto L17;
        return null;
    L17:
        if ("null".equals(r3) == false) goto L20;
        return null;
    L20:
        return new BigInteger(r3);
    L22:
        return BigInteger.valueOf(((Number) r2).longValue());
    }

    public static final Boolean f(Object r3) {
        if (r3 != null) goto L6;
        return null;
    L6:
        if ((r3 instanceof Boolean) == false) goto L10;
        return (Boolean) r3;
    L10:
        if ((r3 instanceof Number) == false) goto L18;
        boolean r0 = true;
        if (((Number) r3).intValue() == 1) goto L16;
        r0 = false;
    L16:
        return Boolean.valueOf(r0);
    L18:
        if ((r3 instanceof String) == false) goto L39;
        String r1 = (String) r3;
        if (r1.length() != 0) goto L22;
    L37:
        return null;
    L22:
        if ("null".equals(r1) == true) goto L37;
        if ("true".equalsIgnoreCase(r1) == true) goto L36;
        if (LocationInfoConst.ALLOW_USE_LOCATION.equals(r1) == true) goto L36;
        if ("false".equalsIgnoreCase(r1) == true) goto L34;
        if (BDLocationException.ERROR_TIMEOUT.equals(r1) == false) goto L39;
    L34:
        return Boolean.FALSE;
    L36:
        return Boolean.TRUE;
    L39:
        throw new d.a.a.d("can not cast to int, value : " + r3);
    }

    public static final Byte g(Object r3) {
        if (r3 != null) goto L6;
        return null;
    L6:
        if ((r3 instanceof Number) == false) goto L11;
        byte r4 = ((Number) r3).byteValue();
    L9:
        return Byte.valueOf(r4);
    L11:
        if ((r3 instanceof String) == false) goto L20;
        String r5 = (String) r3;
        if (r5.length() != 0) goto L15;
    L18:
        return null;
    L15:
        if ("null".equals(r5) == true) goto L18;
        r4 = Byte.parseByte(r5);
        goto L9
    L20:
        throw new d.a.a.d("can not cast to byte, value : " + r3);
    }

    public static final byte[] h(Object r3) {
        if ((r3 instanceof byte[]) == false) goto L7;
        return (byte[]) r3;
    L7:
        if ((r3 instanceof String) == false) goto L11;
        String r4 = (String) r3;
        return e.h(r4, 0, r4.length());
    L11:
        throw new d.a.a.d("can not cast to int, value : " + r3);
    }

    public static final Character i(Object r4) {
        if (r4 != null) goto L6;
        return null;
    L6:
        if ((r4 instanceof Character) == false) goto L10;
        return (Character) r4;
    L10:
        if ((r4 instanceof String) == false) goto L21;
        String r1 = (String) r4;
        if (r1.length() != 0) goto L15;
        return null;
    L15:
        if (r1.length() != 1) goto L19;
        return Character.valueOf(r1.charAt(0));
    L19:
        throw new d.a.a.d("can not cast to byte, value : " + r4);
    L21:
        throw new d.a.a.d("can not cast to byte, value : " + r4);
    }

    public static final Date j(Object r7) {
        if (r7 != null) goto L6;
        return null;
    L6:
        if ((r7 instanceof Calendar) == false) goto L10;
        return ((Calendar) r7).getTime();
    L10:
        if ((r7 instanceof Date) == true) goto L12;
        long r1 = -1;
        if ((r7 instanceof Number) == false) goto L17;
        r1 = ((Number) r7).longValue();
    L17:
        if ((r7 instanceof String) == false) goto L43;
        String r2 = (String) r7;
        if (r2.indexOf(45) == (-1)) goto L36;
        if (r2.length() != d.a.a.a.f12372i.length()) goto L24;
        String r8 = d.a.a.a.f12372i;
    L30:
        SimpleDateFormat r0 = new SimpleDateFormat(r8, d.a.a.a.f12370g);
        r0.setTimeZone(d.a.a.a.f12369f);
        return r0.parse(r2);
    L34:
        throw new d.a.a.d("can not cast to Date, value : " + r2);
    L24:
        if (r2.length() != 10) goto L27;
        r8 = "yyyy-MM-dd";
        goto L30
    L27:
        if (r2.length() != 19) goto L29;
        r8 = "yyyy-MM-dd HH:mm:ss";
        goto L30
    L29:
        r8 = "yyyy-MM-dd HH:mm:ss.SSS";
        goto L30
    L36:
        if (r2.length() != 0) goto L38;
    L41:
        return null;
    L38:
        if ("null".equals(r2) == true) goto L41;
        r1 = Long.parseLong(r2);
    L43:
        if (r1 < 0) goto L47;
        return new Date(r1);
    L47:
        throw new d.a.a.d("can not cast to Date, value : " + r7);
    L12:
        return (Date) r7;
    }

    public static final Double k(Object r3) {
        if (r3 != null) goto L6;
        return null;
    L6:
        if ((r3 instanceof Number) == false) goto L11;
        double r0 = ((Number) r3).doubleValue();
    L9:
        return Double.valueOf(r0);
    L11:
        if ((r3 instanceof String) == false) goto L20;
        String r4 = r3.toString();
        if (r4.length() != 0) goto L15;
    L18:
        return null;
    L15:
        if ("null".equals(r4) == true) goto L18;
        r0 = Double.parseDouble(r4);
        goto L9
    L20:
        throw new d.a.a.d("can not cast to double, value : " + r3);
    }

    public static final <T> T l(Object r2, Class<T> r3, m r4) {
    L19:
        e = move-exception;
        throw new d.a.a.d("can not cast to : " + r3.getName(), e);
    L4:
        if ((r2 instanceof String) == false) goto L12;
        String r5 = (String) r2;     // Catch: Exception -> L19
        if (r5.length() != 0) goto L10;
        return null;
    L10:
        return (T) Enum.valueOf(r3, r5);
    L12:
        if ((r2 instanceof Number) == false) goto L18;
        int r6 = ((Number) r2).intValue();     // Catch: Exception -> L19
        T[] r0 = r3.getEnumConstants();     // Catch: Exception -> L19
        if (r6 >= r0.length) goto L18;
        return r0[r6];
    L18:
        throw new d.a.a.d("can not cast to : " + r3.getName());
    }

    public static final Float m(Object r3) {
        if (r3 != null) goto L6;
        return null;
    L6:
        if ((r3 instanceof Number) == false) goto L11;
        float r4 = ((Number) r3).floatValue();
    L9:
        return Float.valueOf(r4);
    L11:
        if ((r3 instanceof String) == false) goto L20;
        String r5 = r3.toString();
        if (r5.length() != 0) goto L15;
    L18:
        return null;
    L15:
        if ("null".equals(r5) == true) goto L18;
        r4 = Float.parseFloat(r5);
        goto L9
    L20:
        throw new d.a.a.d("can not cast to float, value : " + r3);
    }

    public static final Integer n(Object r3) {
        if (r3 != null) goto L6;
        return null;
    L6:
        if ((r3 instanceof Integer) == false) goto L10;
        return (Integer) r3;
    L10:
        if ((r3 instanceof Number) == false) goto L15;
        int r4 = ((Number) r3).intValue();
    L13:
        return Integer.valueOf(r4);
    L15:
        if ((r3 instanceof String) == false) goto L24;
        String r5 = (String) r3;
        if (r5.length() != 0) goto L19;
    L22:
        return null;
    L19:
        if ("null".equals(r5) == true) goto L22;
        r4 = Integer.parseInt(r5);
        goto L13
    L24:
        throw new d.a.a.d("can not cast to int, value : " + r3);
    }

    public static final <T> T o(Map<String, Object> r4, Class<T> r5, m r6) {
        int r1 = 0;
        if (r5 != StackTraceElement.class) goto L10;
        String r7 = (String) r4.get("className");     // Catch: Exception -> L50
        String r8 = (String) r4.get("methodName");     // Catch: Exception -> L50
        String r0 = (String) r4.get("fileName");     // Catch: Exception -> L50
        Number r9 = (Number) r4.get("lineNumber");     // Catch: Exception -> L50
        if (r9 == null) goto L9;
        r1 = r9.intValue();     // Catch: Exception -> L50
    L9:
        return (T) new StackTraceElement(r7, r8, r0, r1);
    L10:
        Object r2 = r4.get("@type");     // Catch: Exception -> L50
        g r3 = null;
        if ((r2 instanceof String) == false) goto L21;
        String r10 = (String) r2;     // Catch: Exception -> L50
        Class<?> r11 = C(r10, null);     // Catch: Exception -> L50
        if (r11 == null) goto L19;
        if (r11.equals(r5) == true) goto L21;
        return (T) o(r4, r11, r6);
    L19:
        throw new ClassNotFoundException(r10 + " not found");     // Catch: Exception -> L50
    L21:
        if (r5.isInterface() == false) goto L35;
        if ((r4 instanceof d.a.a.e) == false) goto L25;
        d.a.a.e r12 = (d.a.a.e) r4;     // Catch: Exception -> L50
    L26:
        if (r6 != null) goto L29;
        r6 = m.d();     // Catch: Exception -> L50
    L29:
        if (r6.c(r5) == null) goto L33;
        return (T) d.a.a.a.m(d.a.a.a.q(r12), r5);
    L33:
        return (T) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{r5}, r12);
    L25:
        r12 = new d.a.a.e(r4);     // Catch: Exception -> L50
        goto L26
    L35:
        if (r5 == String.class) goto L37;
    L40:
        if (r6 != null) goto L42;
        r6 = m.f12444e;     // Catch: Exception -> L50
    L42:
        f r13 = r6.c(r5);     // Catch: Exception -> L50
        if ((r13 instanceof g) == false) goto L45;
        r3 = (g) r13;     // Catch: Exception -> L50
    L45:
        if (r3 == null) goto L49;
        return (T) r3.c(r4, r6);
    L49:
        throw new d.a.a.d("can not get javaBeanDeserializer");     // Catch: Exception -> L50
    L37:
        if ((r4 instanceof d.a.a.e) == false) goto L40;
        return (T) r4.toString();
    L50:
        e = move-exception;
        throw new d.a.a.d(e.getMessage(), e);
    }

    public static final Long p(Object r4) {
        Calendar r0 = null;
        if (r4 != null) goto L6;
        return null;
    L6:
        if ((r4 instanceof Number) == false) goto L11;
        long r1 = ((Number) r4).longValue();
    L9:
        return Long.valueOf(r1);
    L11:
        if ((r4 instanceof String) == false) goto L27;
        String r2 = (String) r4;
        if (r2.length() != 0) goto L15;
    L25:
        return null;
    L15:
        if ("null".equals(r2) == true) goto L25;
        return Long.valueOf(Long.parseLong(r2));
    L19:
        e r3 = new e(r2);
        if (r3.K(false) == false) goto L22;
        r0 = r3.o;
    L22:
        r3.e();
        if (r0 == null) goto L27;
        r1 = r0.getTimeInMillis();
    L27:
        throw new d.a.a.d("can not cast to long, value : " + r4);
    }

    public static final Short q(Object r3) {
        if (r3 != null) goto L6;
        return null;
    L6:
        if ((r3 instanceof Number) == false) goto L11;
        short r4 = ((Number) r3).shortValue();
    L9:
        return Short.valueOf(r4);
    L11:
        if ((r3 instanceof String) == false) goto L20;
        String r5 = (String) r3;
        if (r5.length() != 0) goto L15;
    L18:
        return null;
    L15:
        if ("null".equals(r5) == true) goto L18;
        r4 = Short.parseShort(r5);
        goto L9
    L20:
        throw new d.a.a.d("can not cast to short, value : " + r3);
    }

    public static final String r(Object r0) {
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.toString();
    }

    public static List<a> s(Class<?> r33, int r34, boolean r35, d.a.a.h.c r36, Map<String, String> r37, boolean r38, boolean r39, boolean r40, d.a.a.g r41) {
        Class<?> r11 = r33;
        r34 = r34;
        d.a.a.h.c r13 = r36;
        r37 = r37;
        r41 = r41;
        Class<? super Object> r10 = Object.class;
        LinkedHashMap r9 = new LinkedHashMap();
        HashMap r8 = new HashMap();
        Field[] r7 = r33.getDeclaredFields();
        if (r35 == true) goto L171;
        ArrayList r0 = new ArrayList();
        Class<?> r1 = r11;
    L5:
        if (r1 == null) goto L31;
        if (r1 == r10) goto L31;
        Method[] r2 = r1.getDeclaredMethods();
        int r3 = r2.length;
        int r4 = 0;
    L8:
        if (r4 >= r3) goto L30;
        Method r5 = r2[r4];
        int r6 = r5.getModifiers();
        if ((r6 & 8) == 0) goto L12;
    L28:
        Method[] r310 = r2;
    L29:
        r4 = r4 + 1;
        r2 = r310;
        goto L8
    L12:
        if ((r6 & 2) != 0) goto L28;
        r310 = r2;
        if ((r6 & 256) != 0) goto L29;
        if ((r6 & 4) != 0) goto L29;
        if (r5.getReturnType().equals(Void.TYPE) == true) goto L29;
        if (r5.getParameterTypes().length != 0) goto L29;
        if (r5.getReturnType() == ClassLoader.class) goto L29;
        if (r5.getDeclaringClass() == r10) goto L29;
        r0.add(r5);
        goto L29
    L30:
        r1 = r1.getSuperclass();
    L31:
        Iterator r18 = r0.iterator();
    L33:
        if (r18.hasNext() == false) goto L171;
        Method r12 = (Method) r18.next();
        String r14 = r12.getName();
        if (r14.equals("getMetaClass") == false) goto L39;
        if (r12.getReturnType().getName().equals("groovy.lang.MetaClass") == true) goto L33;
    L39:
        if (r39 == false) goto L41;
        d.a.a.h.b r15 = (d.a.a.h.b) r12.getAnnotation(d.a.a.h.b.class);
    L42:
        if (r15 != null) goto L45;
        if (r39 == false) goto L45;
        r15 = z(r11, r12);
    L45:
        d.a.a.h.b r19 = r15;
        if (r19 == null) goto L59;
        if (r19.serialize() == false) goto L33;
        int r20 = r19.ordinal();
        int r21 = a0.a(r19.serialzeFeatures());
        if (r19.name().length() != 0) goto L52;
    L61:
        if (r14.startsWith("get") == false) goto L113;
        if (r14.length() < 4) goto L110;
        if (r14.equals("getClass") == true) goto L111;
        char r16 = r14.charAt(3);
        if (Character.isUpperCase(r16) == true) goto L70;
        if (r16 != '_') goto L75;
        String r17 = r14.substring(4);
    L83:
        if (B(r11, r13, r17) == true) goto L111;
        Field[] r22 = r7;
        HashMap r23 = r8;
        Field r24 = w(r11, r17, r22, r23);
        if (r24 == null) goto L102;
        if (r39 == false) goto L89;
        d.a.a.h.b r25 = (d.a.a.h.b) r24.getAnnotation(d.a.a.h.b.class);
    L90:
        if (r25 != null) goto L92;
    L101:
        int r26 = r21;
        int r27 = r20;
        d.a.a.h.b r28 = r25;
    L103:
        if (r41 == null) goto L105;
        r17 = r41.a(r17);
    L105:
        if (r37 == null) goto L109;
        r17 = r37.get(r17);
        if (r17 != null) goto L109;
    L108:
        r7 = r22;
        r8 = r23;
        r9 = r9;
    L112:
        r10 = r10;
    L109:
        String r29 = r17;
        D(r11, r12, r34);
        Field[] r31 = r22;
        r8 = r23;
        r9 = r9;
        r9.put(r29, new a(r29, r12, r24, r33, null, r27, r26, r19, r28, r40));
        r20 = r27;
        r21 = r26;
    L115:
        if (r14.startsWith("is") == false) goto L168;
        if (r14.length() < 3) goto L118;
        char r30 = r14.charAt(2);
        if (Character.isUpperCase(r30) == false) goto L127;
        if (f12543a == false) goto L125;
        String r32 = t(r14.substring(2));
    L133:
        if (B(r11, r13, r32) == true) goto L118;
        Field[] r110 = r31;
        Field r42 = w(r11, r32, r110, r8);
        if (r42 != null) goto L138;
        r42 = w(r11, r14, r110, r8);
    L138:
        Field r43 = r42;
        if (r43 == null) goto L157;
        if (r39 == false) goto L142;
        d.a.a.h.b r44 = (d.a.a.h.b) r43.getAnnotation(d.a.a.h.b.class);
    L143:
        if (r44 == null) goto L156;
        if (r44.serialize() == false) goto L146;
        int r45 = r44.ordinal();
        int r46 = a0.a(r44.serialzeFeatures());
        if (r44.name().length() == 0) goto L154;
        r32 = r44.name();
        r9 = r9;
        r37 = r37;
        if (r37 == null) goto L155;
        r32 = r37.get(r32);
        if (r32 != null) goto L155;
        r7 = r110;
        r9 = r9;
    L170:
        r41 = r41;
    L155:
        r41 = r41;
        d.a.a.h.b r47 = r44;
        int r48 = r45;
        int r49 = r46;
    L159:
        if (r41 == null) goto L161;
        r32 = r41.a(r32);
    L161:
        if (r37 == null) goto L165;
        r32 = r37.get(r32);
        if (r32 != null) goto L165;
        r7 = r110;
        r9 = r9;
        r10 = r10;
        r41 = r41;
        r8 = r8;
        r34 = r34;
    L165:
        String r111 = r32;
        D(r11, r43, r34);
        D(r11, r12, r34);
        Field[] r112 = r110;
        r9.put(r111, new a(r111, r12, r43, r33, null, r48, r49, r19, r47, r40));
    L169:
        r13 = r36;
        r7 = r112;
        r9 = r9;
        r8 = r8;
        r10 = r10;
        r11 = r33;
        goto L170
    L154:
        r9 = r9;
        r37 = r37;
        goto L155
    L146:
        r7 = r110;
    L119:
        r34 = r34;
        r37 = r37;
        goto L33
    L156:
        r47 = r44;
    L158:
        r48 = r20;
        r49 = r21;
        goto L159
    L142:
        r44 = null;
        goto L143
    L157:
        r47 = null;
        goto L158
    L125:
        r32 = Character.toLowerCase(r14.charAt(2)) + r14.substring(3);
        goto L133
    L127:
        if (r30 != '_') goto L130;
        r32 = r14.substring(3);
        goto L133
    L130:
        if (r30 != 'f') goto L166;
        r32 = r14.substring(2);
        goto L133
    L166:
        LinkedHashMap r113 = r9;
        r11 = r33;
        r13 = r36;
        r37 = r37;
        r9 = r113;
        r7 = r31;
    L118:
        r7 = r31;
        goto L119
    L168:
        r9 = r9;
        r112 = r31;
        r37 = r37;
        goto L169
    L92:
        if (r25.serialize() == false) goto L108;
        r20 = r25.ordinal();
        r21 = a0.a(r25.serialzeFeatures());
        if (r25.name().length() == 0) goto L101;
        r17 = r25.name();
        if (r37 == null) goto L101;
        r17 = r37.get(r17);
        if (r17 != null) goto L101;
    L89:
        r25 = null;
        goto L90
    L102:
        r26 = r21;
        r27 = r20;
        r28 = null;
        goto L103
    L75:
        if (r16 != 'f') goto L78;
        r17 = r14.substring(3);
        goto L83
    L78:
        if (r14.length() < 5) goto L110;
        if (Character.isUpperCase(r14.charAt(4)) == false) goto L110;
    L71:
        r17 = t(r14.substring(3));
        goto L83
    L70:
        if (f12543a == true) goto L71;
        r17 = Character.toLowerCase(r14.charAt(3)) + r14.substring(4);
    L111:
        r9 = r9;
        r7 = r7;
        r8 = r8;
    L110:
        r34 = r34;
        r37 = r37;
        r41 = r41;
        goto L111
    L113:
        r9 = r9;
        r31 = r7;
        r8 = r8;
        goto L115
    L52:
        String r50 = r19.name();
        if (r37 == null) goto L57;
        r50 = r37.get(r50);
        if (r50 == null) goto L33;
    L57:
        String r51 = r50;
        D(r11, r12, r34);
        r7 = r7;
        r8 = r8;
        r10 = r10;
        r9 = r9;
        r9.put(r51, new a(r51, r12, null, r33, null, r20, r21, r19, null, true));
        goto L111
    L59:
        r20 = 0;
        r21 = 0;
        goto L61
    L41:
        r15 = null;
    L171:
        Field[] r114 = r7;
        LinkedHashMap r115 = r9;
        Class<? super Object> r311 = r10;
        ArrayList r52 = new ArrayList(r114.length);
        int r53 = r114.length;
        int r54 = 0;
    L173:
        if (r54 >= r53) goto L184;
        Field r55 = r114[r54];
        if ((r55.getModifiers() & 8) != 0) goto L183;
        if (r55.getName().equals("this$0") == true) goto L183;
        if ((r55.getModifiers() & 1) == 0) goto L183;
        r52.add(r55);
    L183:
        r54 = r54 + 1;
        goto L173
    L184:
        Class<? super Object> r56 = r33.getSuperclass();
    L185:
        if (r56 == null) goto L198;
        Class<? super Object> r57 = r311;
        if (r56 == r57) goto L198;
        Field[] r58 = r56.getDeclaredFields();
        int r59 = r58.length;
        int r60 = 0;
    L189:
        if (r60 >= r59) goto L197;
        Field r61 = r58[r60];
        if ((r61.getModifiers() & 8) != 0) goto L196;
        if ((r61.getModifiers() & 1) == 0) goto L196;
        r52.add(r61);
    L196:
        r60 = r60 + 1;
        goto L189
    L197:
        r56 = r56.getSuperclass();
        r311 = r57;
    L198:
        Iterator r116 = r52.iterator();
    L200:
        if (r116.hasNext() == false) goto L227;
        Field r62 = (Field) r116.next();
        if (r39 == false) goto L204;
        d.a.a.h.b r63 = (d.a.a.h.b) r62.getAnnotation(d.a.a.h.b.class);
    L205:
        String r64 = r62.getName();
        if (r63 == null) goto L214;
        if (r63.serialize() == false) goto L200;
        int r65 = r63.ordinal();
        int r66 = a0.a(r63.serialzeFeatures());
        if (r63.name().length() == 0) goto L213;
        r64 = r63.name();
    L213:
        int r67 = r65;
        int r68 = r66;
    L215:
        if (r37 == null) goto L220;
        r64 = r37.get(r64);
        if (r64 == null) goto L200;
    L220:
        if (r41 == null) goto L222;
        r64 = r41.a(r64);
    L222:
        String r117 = r64;
        if (r115.containsKey(r117) == true) goto L226;
        D(r33, r62, r34);
        r115.put(r117, new a(r117, null, r62, r33, null, r67, r68, null, r63, r40));
    L226:
        r116 = r116;
        goto L200
    L214:
        r67 = 0;
        r68 = 0;
        goto L215
    L204:
        r63 = null;
        goto L205
    L227:
        ArrayList r69 = new ArrayList();
        if (r36 == null) goto L240;
        String[] r70 = r36.orders();
        if (r70 != null) goto L232;
    L241:
        boolean r118 = false;
    L242:
        if (r118 == false) goto L246;
        int r71 = r70.length;
        int r72 = 0;
    L244:
        if (r72 >= r71) goto L252;
        r69.add((a) r115.get(r70[r72]));
        r72 = r72 + 1;
    L252:
        return r69;
    L246:
        Iterator r73 = r115.values().iterator();
    L248:
        if (r73.hasNext() == false) goto L250;
        r69.add((a) r73.next());
        goto L248
    L250:
        if (r38 == false) goto L252;
        Collections.sort(r69);
        goto L252
    L232:
        if (r70.length != r115.size()) goto L241;
        int r74 = r70.length;
        int r75 = 0;
    L234:
        if (r75 >= r74) goto L239;
        if (r115.containsKey(r70[r75]) == false) goto L241;
        r75 = r75 + 1;
        goto L234
    L239:
        r118 = true;
        goto L242
    L240:
        r70 = null;
        goto L241
    }

    public static String t(String r3) {
        if (r3 != null) goto L4;
    L14:
        return r3;
    L4:
        if (r3.length() == 0) goto L14;
        if (r3.length() > 1) goto L8;
    L12:
        char[] r4 = r3.toCharArray();
        r4[0] = Character.toLowerCase(r4[0]);
        return new String(r4);
    L8:
        if (Character.isUpperCase(r3.charAt(1)) == false) goto L12;
        if (Character.isUpperCase(r3.charAt(0)) == false) goto L12;
        goto L12
    }

    public static Class<?> u(Type r2) {
        if (r2.getClass() != Class.class) goto L7;
        return (Class) r2;
    L7:
        if ((r2 instanceof ParameterizedType) == false) goto L11;
        return u(((ParameterizedType) r2).getRawType());
    L11:
        if ((r2 instanceof TypeVariable) == true) goto L13;
        return Object.class;
    L13:
        return (Class) ((TypeVariable) r2).getBounds()[0];
    }

    public static Type v(Type r4) {
        if ((r4 instanceof ParameterizedType) == false) goto L10;
        Type r5 = ((ParameterizedType) r4).getActualTypeArguments()[0];
        if ((r5 instanceof WildcardType) == false) goto L15;
        Type[] r1 = ((WildcardType) r5).getUpperBounds();
        if (r1.length != 1) goto L15;
        r5 = r1[0];
    L15:
        if (r5 != null) goto L18;
        return Object.class;
    L18:
        return r5;
    L10:
        if ((r4 instanceof Class) == false) goto L14;
        Class r6 = (Class) r4;
        if (r6.getName().startsWith("java.") == true) goto L14;
        r5 = v(r6.getGenericSuperclass());
    L14:
        r5 = null;
        goto L15
    }

    public static Field w(Class<?> r3, String r4, Field[] r5, Map<Class<?>, Field[]> r6) {
        Field r0 = x(r3, r4, r5, r6);
        if (r0 != null) goto L5;
        r0 = x(r3, "_" + r4, r5, r6);
    L5:
        if (r0 != null) goto L7;
        r0 = x(r3, "m_" + r4, r5, r6);
    L7:
        if (r0 == null) goto L9;
        return r0;
    L9:
        return x(r3, "m" + r4.substring(0, 1).toUpperCase() + r4.substring(1), r5, r6);
    }

    private static Field x(Class<?> r4, String r5, Field[] r6, Map<Class<?>, Field[]> r7) {
        int r0 = r6.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        Field r2 = r6[r1];
        if (r5.equals(r2.getName()) == true) goto L6;
        r1 = r1 + 1;
        goto L3
    L6:
        return r2;
    L8:
        Class<? super Object> r8 = r4.getSuperclass();
        Field[] r9 = null;
        if (r8 != null) goto L11;
    L21:
        return null;
    L11:
        if (r8 == Object.class) goto L21;
        if (r7 == null) goto L15;
        r9 = r7.get(r8);
    L15:
        if (r9 != null) goto L20;
        r9 = r8.getDeclaredFields();
        if (r7 == null) goto L20;
        r7.put(r8, r9);
    L20:
        return w(r8, r5, r9, r7);
    }

    public static Type y(Type r1) {
        if ((r1 instanceof Class) == true) goto L5;
        return r1;
    L5:
        return y(((Class) r1).getGenericSuperclass());
    }

    public static d.a.a.h.b z(Class<?> r14, Method r15) {
        Class<?>[] r0 = r14.getInterfaces();
        int r1 = r0.length;
        int r3 = 0;
    L4:
        if (r3 >= r1) goto L28;
        Method[] r5 = r0[r3].getMethods();
        int r6 = r5.length;
        int r7 = 0;
    L6:
        if (r7 >= r6) goto L27;
        Method r8 = r5[r7];
        if (r8.getName().equals(r15.getName()) == false) goto L26;
        Class<?>[] r9 = r8.getParameterTypes();
        Class<?>[] r10 = r15.getParameterTypes();
        if (r9.length != r10.length) goto L26;
        int r11 = 0;
    L15:
        if (r11 >= r9.length) goto L20;
        if (r9[r11].equals(r10[r11]) == false) goto L18;
        r11 = r11 + 1;
        goto L15
    L18:
        boolean r12 = false;
    L21:
        if (r12 == false) goto L26;
        d.a.a.h.b r13 = (d.a.a.h.b) r8.getAnnotation(d.a.a.h.b.class);
        if (r13 == null) goto L26;
        return r13;
    L20:
        r12 = true;
    L26:
        r7 = r7 + 1;
        goto L6
    L27:
        r3 = r3 + 1;
        goto L4
    L28:
        Class<? super Object> r16 = r14.getSuperclass();
        if (r16 != null) goto L32;
        return null;
    L32:
        if (Modifier.isAbstract(r16.getModifiers()) == false) goto L55;
        Class<?>[] r2 = r15.getParameterTypes();
        Method[] r17 = r16.getMethods();
        int r4 = r17.length;
        int r18 = 0;
    L34:
        if (r18 >= r4) goto L55;
        Method r19 = r17[r18];
        Class<?>[] r20 = r19.getParameterTypes();
        if (r20.length != r2.length) goto L54;
        if (r19.getName().equals(r15.getName()) == false) goto L54;
        int r21 = 0;
    L43:
        if (r21 >= r2.length) goto L48;
        if (r20[r21].equals(r2[r21]) == false) goto L46;
        r21 = r21 + 1;
        goto L43
    L46:
        boolean r22 = false;
    L49:
        if (r22 == false) goto L54;
        d.a.a.h.b r23 = (d.a.a.h.b) r19.getAnnotation(d.a.a.h.b.class);
        if (r23 == null) goto L54;
        return r23;
    L48:
        r22 = true;
    L54:
        r18 = r18 + 1;
    L55:
        return null;
    }
}
