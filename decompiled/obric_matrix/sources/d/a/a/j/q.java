package d.a.a.j;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Currency;
import java.util.Enumeration;
import java.util.Locale;
import java.util.TimeZone;
import java.util.UUID;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public final class q implements t, d.a.a.i.q.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q f12510a = null;

    static {
        f12510a = new q();
    }

    private q() {
    }

    /* JADX WARN: Type inference failed for: r7v6, types: [T, java.text.SimpleDateFormat] */
    @Override // d.a.a.i.q.f
    public <T> T a(d.a.a.i.b r6, Type r7, Object r8) {
        if (r7 == StackTraceElement.class) goto L5;
        d.a.a.i.e r5 = r6.f12388j;
        if (r6.o != 2) goto L17;
        r6.o = 0;
        r6.a(16);
        if (r5.a0() != 4) goto L16;
        if ("val".equals(r5.X()) == false) goto L14;
        r5.s();
        r6.a(17);
        Object r9 = r6.F();
        r6.a(13);
    L19:
        if (r9 != null) goto L22;
        return null;
    L22:
        if ((r9 instanceof String) == false) goto L92;
        String r10 = (String) r9;
        if (r10.length() != 0) goto L27;
        return null;
    L27:
        if (r7 != UUID.class) goto L31;
        return (T) UUID.fromString(r10);
    L31:
        if (r7 != Class.class) goto L35;
        return (T) d.a.a.k.d.C(r10, r6.f12385g.f12447c);
    L35:
        if (r7 != Locale.class) goto L47;
        String[] r11 = r10.split("_");
        if (r11.length != 1) goto L41;
        return (T) new Locale(r11[0]);
    L41:
        if (r11.length != 2) goto L45;
        return (T) new Locale(r11[0], r11[1]);
    L45:
        return (T) new Locale(r11[0], r11[1], r11[2]);
    L47:
        if (r7 != URI.class) goto L51;
        return (T) URI.create(r10);
    L51:
        if (r7 != URL.class) goto L58;
        return (T) new URL(r10);
    L54:
        e = move-exception;
        throw new d.a.a.d("create url error", e);
    L58:
        if (r7 != Pattern.class) goto L62;
        return (T) Pattern.compile(r10);
    L62:
        if (r7 != Charset.class) goto L66;
        return (T) Charset.forName(r10);
    L66:
        if (r7 != Currency.class) goto L70;
        return (T) Currency.getInstance(r10);
    L70:
        if (r7 != SimpleDateFormat.class) goto L74;
        ?? r12 = (T) new SimpleDateFormat(r10, r6.f12388j.n);
        r12.setTimeZone(r6.f12388j.m);
        return r12;
    L74:
        if (r7 == Character.TYPE) goto L90;
        if (r7 == Character.class) goto L90;
        if ((r7 instanceof Class) == false) goto L88;
        if ("android.net.Uri".equals(((Class) r7).getName()) == false) goto L88;
        return (T) Class.forName("android.net.Uri").getMethod("parse", new Class[]{String.class}).invoke(null, new Object[]{r10});
    L84:
        e = move-exception;
        throw new d.a.a.d("parse android.net.Uri error.", e);
    L88:
        return (T) TimeZone.getTimeZone(r10);
    L90:
        return (T) d.a.a.k.d.i(r10);
    L92:
        throw new d.a.a.d("except string value");
    L14:
        throw new d.a.a.d("syntax error");
    L16:
        throw new d.a.a.d("syntax error");
    L17:
        r9 = r6.F();
        goto L19
    L5:
        return (T) c(r6);
    }

    @Override // d.a.a.j.t
    public void b(m r6, Object r7, Object r8, Type r9) {
        z r5 = r6.f12492b;
        if (r7 != null) goto L19;
        if (r9 != Character.TYPE) goto L7;
    L16:
        r6.s("");
        return;
    L7:
        if (r9 == Character.class) goto L16;
        if ((r5.f12526h & a0.f12470l.f12471f) != 0) goto L12;
    L15:
        r5.Q();
        return;
    L12:
        if (Enumeration.class.isAssignableFrom(d.a.a.k.d.u(r9)) == false) goto L15;
        r5.write("[]");
        return;
    L19:
        if ((r7 instanceof Pattern) == false) goto L23;
        String r10 = ((Pattern) r7).pattern();
    L21:
        r6.s(r10);
        return;
    L23:
        if ((r7 instanceof TimeZone) == false) goto L26;
        r10 = ((TimeZone) r7).getID();
        goto L21
    L26:
        if ((r7 instanceof Currency) == false) goto L29;
        r10 = ((Currency) r7).getCurrencyCode();
        goto L21
    L29:
        if ((r7 instanceof Class) == false) goto L32;
        r10 = ((Class) r7).getName();
        goto L21
    L32:
        if ((r7 instanceof Character) == false) goto L37;
        Character r11 = (Character) r7;
        if (r11.charValue() != 0) goto L36;
        r10 = "\u0000";
        goto L21
    L36:
        r10 = r11.toString();
        goto L21
    L37:
        int r2 = 0;
        if ((r7 instanceof SimpleDateFormat) == false) goto L47;
        String r12 = ((SimpleDateFormat) r7).toPattern();
        if ((r5.f12526h & a0.t.f12471f) != 0) goto L42;
    L45:
        r5.S(r12);
        return;
    L42:
        if (r7.getClass() == r9) goto L45;
        r5.write(123);
        r5.F("@type", false);
        r6.s(r7.getClass().getName());
        r5.write(44);
        r5.F("val", false);
        r5.S(r12);
        r5.write(125);
        return;
    L47:
        if ((r7 instanceof d.a.a.f) == false) goto L50;
        ((d.a.a.f) r7).a(r5);
        return;
    L50:
        if ((r7 instanceof d.a.a.c) == false) goto L53;
        r5.write(((d.a.a.c) r7).c());
        return;
    L53:
        if ((r7 instanceof l) == false) goto L56;
        ((l) r7).a(r6, r8, r9);
        return;
    L56:
        if ((r7 instanceof Enumeration) == false) goto L78;
        Type r0 = null;
        if ((r5.f12526h & a0.t.f12471f) != 0) goto L60;
    L62:
        Enumeration r13 = (Enumeration) r7;
        w r3 = r6.m;
        r6.p(r3, r7, r8, 0);
        r5.write(91);     // Catch: Throwable -> L75
    L65:
        if (r13.hasMoreElements() == false) goto L73;
        Object r14 = r13.nextElement();     // Catch: Throwable -> L75
        int r15 = r2 + 1;     // Catch: Throwable -> L75
        if (r2 == 0) goto L69;
        r5.write(44);     // Catch: Throwable -> L75
    L69:
        if (r14 != null) goto L71;
        r5.Q();     // Catch: Throwable -> L75
    L72:
        r2 = r15;
        goto L65
    L71:
        r6.f12491a.a(r14.getClass()).b(r6, r14, Integer.valueOf(r15 - 1), r0);     // Catch: Throwable -> L75
        goto L72
    L73:
        r5.write(93);     // Catch: Throwable -> L75
        r6.m = r3;
        return;
    L75:
        th = move-exception;
        r6.m = r3;
        throw th;
    L60:
        if ((r9 instanceof ParameterizedType) == false) goto L62;
        r0 = ((ParameterizedType) r9).getActualTypeArguments()[0];
        goto L62
    L78:
        r10 = r7.toString();
        goto L21
    }

    protected <T> T c(d.a.a.i.b r15) {
        d.a.a.i.e r14 = r15.f12388j;
        if (r14.a0() != 8) goto L7;
        r14.s();
        return null;
    L7:
        if (r14.a0() != 12) goto L9;
    L13:
        int r7 = 0;
        String r3 = null;
        String r5 = null;
        String r6 = null;
    L14:
        String r8 = r14.R(r15.f12384f);
        if (r8 != null) goto L22;
        if (r14.a0() == 13) goto L18;
        if (r14.a0() != 16) goto L22;
    L18:
        r14.t(16);
        return (T) new StackTraceElement(r3, r5, r6, r7);
    L22:
        r14.u(':');
        if ("className".equals(r8) == false) goto L33;
        if (r14.a0() != 8) goto L28;
        r3 = null;
    L87:
        if (r14.a0() != 13) goto L14;
    L28:
        if (r14.a0() != 4) goto L31;
        r3 = r14.X();
        goto L87
    L31:
        throw new d.a.a.d("syntax error");
    L33:
        if ("methodName".equals(r8) == false) goto L43;
        if (r14.a0() != 8) goto L38;
        r5 = null;
        goto L87
    L38:
        if (r14.a0() != 4) goto L41;
        r5 = r14.X();
        goto L87
    L41:
        throw new d.a.a.d("syntax error");
    L43:
        if ("fileName".equals(r8) == false) goto L53;
        if (r14.a0() != 8) goto L48;
        r6 = null;
        goto L87
    L48:
        if (r14.a0() != 4) goto L51;
        r6 = r14.X();
        goto L87
    L51:
        throw new d.a.a.d("syntax error");
    L53:
        if ("lineNumber".equals(r8) == false) goto L63;
        if (r14.a0() != 8) goto L58;
        r7 = 0;
        goto L87
    L58:
        if (r14.a0() != 2) goto L61;
        r7 = r14.j();
        goto L87
    L61:
        throw new d.a.a.d("syntax error");
    L63:
        if ("nativeMethod".equals(r8) == false) goto L76;
        if (r14.a0() != 8) goto L68;
    L66:
        r14.t(16);
        goto L87
    L68:
        if (r14.a0() == 6) goto L66;
        if (r14.a0() == 7) goto L66;
        throw new d.a.a.d("syntax error");
    L76:
        if (r8 != "@type") goto L94;
        if (r14.a0() != 4) goto L85;
        String r9 = r14.X();
        if (r9.equals("java.lang.StackTraceElement") == true) goto L87;
        throw new d.a.a.d("syntax error : " + r9);
    L85:
        if (r14.a0() == 8) goto L87;
        throw new d.a.a.d("syntax error");
    L94:
        throw new d.a.a.d("syntax error : " + r8);
    L9:
        if (r14.a0() == 16) goto L13;
        throw new d.a.a.d("syntax error: " + d.a.a.i.f.a(r14.a0()));
    }
}
