package d.a.a.i;

import com.bytedance.common.wschannel.WsConstants;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: loaded from: classes.dex */
public class g implements d.a.a.i.q.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d.a.a.i.q.d[] f12416a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d.a.a.i.q.d[] f12417b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map<String, d.a.a.i.q.d> f12418c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Class<?> f12419d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final h f12420e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ConcurrentMap<String, Object> f12421f;

    public g(m r9, Class<?> r10, Type r11) {
        this(r9, r10, r11, h.b(r10, r10.getModifiers(), r11, false, true, true, true, r9.f12448d));
    }

    public g(m r9, Class<?> r10, Type r11, h r12) {
        this.f12419d = r10;
        this.f12420e = r12;
        d.a.a.k.a[] r13 = r12.f12427f;
        this.f12417b = new d.a.a.i.q.d[r13.length];
        int r14 = r13.length;
        int r0 = 0;
        HashMap r1 = null;
        int r2 = 0;
    L3:
        if (r2 >= r14) goto L11;
        d.a.a.k.a r3 = r12.f12427f[r2];
        d.a.a.i.q.d r4 = r9.a(r9, r10, r3);
        this.f12417b[r2] = r4;
        String[] r5 = r3.u;
        int r6 = r5.length;
        int r7 = 0;
    L5:
        if (r7 >= r6) goto L10;
        String r8 = r5[r7];
        if (r1 != null) goto L9;
        r1 = new HashMap();
    L9:
        r1.put(r8, r4);
        r7 = r7 + 1;
        goto L5
    L10:
        r2 = r2 + 1;
        goto L3
    L11:
        this.f12418c = r1;
        d.a.a.k.a[] r15 = r12.f12426e;
        this.f12416a = new d.a.a.i.q.d[r15.length];
        int r16 = r15.length;
    L12:
        if (r0 >= r16) goto L14;
        this.f12416a[r0] = f(r12.f12426e[r0].f12528f);
        r0 = r0 + 1;
        goto L12
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 20501. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
        */
    private <T> T d(d.a.a.i.b r46, java.lang.reflect.Type r47, java.lang.Object r48, java.lang.Object r49) {
        /*  JADX ERROR: Simple mode code generation failed
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0000: MOVE (r7v0 ?? I:??[OBJECT, ARRAY]) = (r45v0 'this' ?? I:??[OBJECT, ARRAY] A[IMMUTABLE_TYPE, THIS]) A[DECLARE_VAR] in method: d.a.a.i.g.d(d.a.a.i.b, java.lang.reflect.Type, java.lang.Object, java.lang.Object):T, file: classes.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:348)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.ArgType.getPrimitiveType()" because "type" is null
            	at jadx.core.codegen.ClassGen.useType(ClassGen.java:564)
            	at jadx.core.codegen.InsnGen.useType(InsnGen.java:269)
            	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:166)
            	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:159)
            	at jadx.core.codegen.InsnGen.assignVar(InsnGen.java:152)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:299)
            	... 31 more
            */
        /*
            Method dump skipped, instruction units count: 2050
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: d.a.a.i.g.d(d.a.a.i.b, java.lang.reflect.Type, java.lang.Object, java.lang.Object):java.lang.Object");
    }

    private <T> T e(b r17, Type r18, Object r19, Object r20) {
        e r2 = r17.f12388j;
        T r3 = (T) b(r17, r18);
        int r4 = this.f12417b.length;
        int r5 = 0;
    L4:
        if (r5 >= r4) goto L186;
        if (r5 != (r4 - 1)) goto L8;
        char r9 = ']';
    L9:
        d.a.a.i.q.d r11 = this.f12417b[r5];
        d.a.a.k.a r12 = r11.f12460a;
        Class<?> r13 = r12.f12534l;
    L182:
        e = move-exception;
        throw new d.a.a.d("set " + r12.f12528f + WsConstants.KEY_CONNECTION_ERROR, e);
    L11:
        if (r13 != Integer.TYPE) goto L34;
        int r10 = (int) r2.M();     // Catch: IllegalAccessException -> L182
        if (r12.f12531i == false) goto L15;
        r12.f12530h.setInt(r3, r10);     // Catch: IllegalAccessException -> L182
    L16:
        char r14 = r2.f12407d;     // Catch: IllegalAccessException -> L182
        if (r14 != ',') goto L24;
        int r7 = r2.f12408e + 1;     // Catch: IllegalAccessException -> L182
        r2.f12408e = r7;     // Catch: IllegalAccessException -> L182
        if (r7 < r2.r) goto L21;
        char r8 = 26;
    L22:
        r2.f12407d = r8;     // Catch: IllegalAccessException -> L182
    L23:
        r2.f12404a = 16;     // Catch: IllegalAccessException -> L182
    L181:
        r5 = r5 + 1;
        goto L4
    L21:
        r8 = r2.q.charAt(r7);     // Catch: IllegalAccessException -> L182
        goto L22
    L24:
        if (r14 != ']') goto L31;
        int r6 = r2.f12408e + 1;     // Catch: IllegalAccessException -> L182
        r2.f12408e = r6;     // Catch: IllegalAccessException -> L182
        if (r6 < r2.r) goto L28;
        char r15 = 26;
    L29:
        r2.f12407d = r15;     // Catch: IllegalAccessException -> L182
    L30:
        r2.f12404a = 15;     // Catch: IllegalAccessException -> L182
        goto L181
    L28:
        r15 = r2.q.charAt(r6);     // Catch: IllegalAccessException -> L182
    L31:
        r2.s();     // Catch: IllegalAccessException -> L182
        goto L181
    L15:
        r11.g(r3, new Integer(r10));     // Catch: IllegalAccessException -> L182
        goto L16
    L34:
        if (r13 != String.class) goto L67;
        char r16 = r2.f12407d;     // Catch: IllegalAccessException -> L182
        if (r16 != '\"') goto L39;
        String r21 = r2.Q('\"');     // Catch: IllegalAccessException -> L182
    L48:
        if (r12.f12531i == false) goto L50;
        r12.f12530h.set(r3, r21);     // Catch: IllegalAccessException -> L182
    L51:
        char r22 = r2.f12407d;     // Catch: IllegalAccessException -> L182
        if (r22 != ',') goto L58;
        int r23 = r2.f12408e + 1;     // Catch: IllegalAccessException -> L182
        r2.f12408e = r23;     // Catch: IllegalAccessException -> L182
        if (r23 < r2.r) goto L56;
        char r24 = 26;
    L57:
        r2.f12407d = r24;     // Catch: IllegalAccessException -> L182
        goto L23
    L56:
        r24 = r2.q.charAt(r23);     // Catch: IllegalAccessException -> L182
        goto L57
    L58:
        if (r22 != ']') goto L31;
        int r25 = r2.f12408e + 1;     // Catch: IllegalAccessException -> L182
        r2.f12408e = r25;     // Catch: IllegalAccessException -> L182
        if (r25 < r2.r) goto L62;
        char r26 = 26;
    L63:
        r2.f12407d = r26;     // Catch: IllegalAccessException -> L182
        goto L30
    L62:
        r26 = r2.q.charAt(r25);     // Catch: IllegalAccessException -> L182
        goto L63
    L50:
        r11.g(r3, r21);     // Catch: IllegalAccessException -> L182
        goto L51
    L39:
        if (r16 != 'n') goto L65;
        if (r2.q.startsWith("null", r2.f12408e) == false) goto L65;
        int r27 = r2.f12408e + 4;     // Catch: IllegalAccessException -> L182
        r2.f12408e = r27;     // Catch: IllegalAccessException -> L182
        if (r27 < r2.r) goto L45;
        char r28 = 26;
    L46:
        r2.f12407d = r28;     // Catch: IllegalAccessException -> L182
        r21 = null;
        goto L48
    L45:
        r28 = r2.q.charAt(r27);     // Catch: IllegalAccessException -> L182
    L65:
        throw new d.a.a.d("not match string. feild : " + r19);     // Catch: IllegalAccessException -> L182
    L67:
        if (r13 != Long.TYPE) goto L89;
        long r29 = r2.M();     // Catch: IllegalAccessException -> L182
        if (r12.f12531i == false) goto L71;
        r12.f12530h.setLong(r3, r29);     // Catch: IllegalAccessException -> L182
    L72:
        char r30 = r2.f12407d;     // Catch: IllegalAccessException -> L182
        if (r30 != ',') goto L80;
        int r31 = r2.f12408e + 1;     // Catch: IllegalAccessException -> L182
        r2.f12408e = r31;     // Catch: IllegalAccessException -> L182
        if (r31 < r2.r) goto L77;
        char r32 = 26;
    L78:
        r2.f12407d = r32;     // Catch: IllegalAccessException -> L182
    L79:
        r2.f12404a = 16;     // Catch: IllegalAccessException -> L182
        goto L181
    L77:
        r32 = r2.q.charAt(r31);     // Catch: IllegalAccessException -> L182
        goto L78
    L80:
        if (r30 != ']') goto L87;
        int r33 = r2.f12408e + 1;     // Catch: IllegalAccessException -> L182
        r2.f12408e = r33;     // Catch: IllegalAccessException -> L182
        if (r33 < r2.r) goto L84;
        char r34 = 26;
    L85:
        r2.f12407d = r34;     // Catch: IllegalAccessException -> L182
    L86:
        r2.f12404a = 15;     // Catch: IllegalAccessException -> L182
        goto L181
    L84:
        r34 = r2.q.charAt(r33);     // Catch: IllegalAccessException -> L182
    L87:
        r2.s();     // Catch: IllegalAccessException -> L182
        goto L181
    L71:
        r11.g(r3, new Long(r29));     // Catch: IllegalAccessException -> L182
        goto L72
    L89:
        if (r13 != Boolean.TYPE) goto L108;
        boolean r35 = r2.x();     // Catch: IllegalAccessException -> L182
        if (r12.f12531i == false) goto L93;
        r12.f12530h.setBoolean(r3, r35);     // Catch: IllegalAccessException -> L182
    L94:
        char r36 = r2.f12407d;     // Catch: IllegalAccessException -> L182
        if (r36 != ',') goto L101;
        int r37 = r2.f12408e + 1;     // Catch: IllegalAccessException -> L182
        r2.f12408e = r37;     // Catch: IllegalAccessException -> L182
        if (r37 < r2.r) goto L99;
        char r38 = 26;
    L100:
        r2.f12407d = r38;     // Catch: IllegalAccessException -> L182
        goto L79
    L99:
        r38 = r2.q.charAt(r37);     // Catch: IllegalAccessException -> L182
        goto L100
    L101:
        if (r36 != ']') goto L87;
        int r39 = r2.f12408e + 1;     // Catch: IllegalAccessException -> L182
        r2.f12408e = r39;     // Catch: IllegalAccessException -> L182
        if (r39 < r2.r) goto L105;
        char r40 = 26;
    L106:
        r2.f12407d = r40;     // Catch: IllegalAccessException -> L182
        goto L86
    L105:
        r40 = r2.q.charAt(r39);     // Catch: IllegalAccessException -> L182
        goto L106
    L93:
        r11.g(r3, Boolean.valueOf(r35));     // Catch: IllegalAccessException -> L182
        goto L94
    L108:
        if (r13.isEnum() == false) goto L136;
        char r41 = r2.f12407d;     // Catch: IllegalAccessException -> L182
        if (r41 != '\"') goto L116;
        String r42 = r2.R(r17.f12384f);     // Catch: IllegalAccessException -> L182
        if (r42 != null) goto L114;
        Enum r43 = null;
    L120:
        r11.g(r3, r43);     // Catch: IllegalAccessException -> L182
        char r44 = r2.f12407d;     // Catch: IllegalAccessException -> L182
        if (r44 != ',') goto L127;
        int r45 = r2.f12408e + 1;     // Catch: IllegalAccessException -> L182
        r2.f12408e = r45;     // Catch: IllegalAccessException -> L182
        if (r45 < r2.r) goto L125;
        char r46 = 26;
    L126:
        r2.f12407d = r46;     // Catch: IllegalAccessException -> L182
        goto L79
    L125:
        r46 = r2.q.charAt(r45);     // Catch: IllegalAccessException -> L182
        goto L126
    L127:
        if (r44 != ']') goto L87;
        int r47 = r2.f12408e + 1;     // Catch: IllegalAccessException -> L182
        r2.f12408e = r47;     // Catch: IllegalAccessException -> L182
        if (r47 < r2.r) goto L131;
        char r48 = 26;
    L132:
        r2.f12407d = r48;     // Catch: IllegalAccessException -> L182
        goto L86
    L131:
        r48 = r2.q.charAt(r47);     // Catch: IllegalAccessException -> L182
        goto L132
    L114:
        r43 = Enum.valueOf(r13, r42);     // Catch: IllegalAccessException -> L182
        goto L120
    L116:
        if (r41 < '0') goto L134;
        if (r41 > '9') goto L134;
        r43 = ((c) ((a) r11).h(r17.f12385g)).f12396b[(int) r2.M()];     // Catch: IllegalAccessException -> L182
    L134:
        throw new d.a.a.d("illegal enum." + r2.i());     // Catch: IllegalAccessException -> L182
    L136:
        if (r13 == Date.class) goto L138;
    L152:
        char r49 = r2.f12407d;     // Catch: IllegalAccessException -> L182
        if (r49 != '[') goto L160;
        int r50 = r2.f12408e + 1;     // Catch: IllegalAccessException -> L182
        r2.f12408e = r50;     // Catch: IllegalAccessException -> L182
        if (r50 < r2.r) goto L157;
        char r51 = 26;
    L158:
        r2.f12407d = r51;     // Catch: IllegalAccessException -> L182
        r2.f12404a = 14;     // Catch: IllegalAccessException -> L182
    L167:
        r11.b(r17, r3, r12.m, null);     // Catch: IllegalAccessException -> L182
        if (r9 == ']') goto L171;
        if (r9 != ',') goto L181;
        if (r2.f12404a == 16) goto L181;
        throw new d.a.a.d("syntax error");     // Catch: IllegalAccessException -> L182
    L171:
        if (r2.f12404a == 15) goto L181;
        throw new d.a.a.d("syntax error");     // Catch: IllegalAccessException -> L182
    L157:
        r51 = r2.q.charAt(r50);     // Catch: IllegalAccessException -> L182
        goto L158
    L160:
        if (r49 != '{') goto L166;
        int r52 = r2.f12408e + 1;     // Catch: IllegalAccessException -> L182
        r2.f12408e = r52;     // Catch: IllegalAccessException -> L182
        if (r52 < r2.r) goto L164;
        char r53 = 26;
    L165:
        r2.f12407d = r53;     // Catch: IllegalAccessException -> L182
        r2.f12404a = 12;     // Catch: IllegalAccessException -> L182
        goto L167
    L164:
        r53 = r2.q.charAt(r52);     // Catch: IllegalAccessException -> L182
        goto L165
    L166:
        r2.s();     // Catch: IllegalAccessException -> L182
        goto L167
    L138:
        if (r2.f12407d != '1') goto L152;
        r11.g(r3, new Date(r2.M()));     // Catch: IllegalAccessException -> L182
        char r54 = r2.f12407d;     // Catch: IllegalAccessException -> L182
        if (r54 != ',') goto L146;
        int r55 = r2.f12408e + 1;     // Catch: IllegalAccessException -> L182
        r2.f12408e = r55;     // Catch: IllegalAccessException -> L182
        if (r55 < r2.r) goto L144;
        char r56 = 26;
    L145:
        r2.f12407d = r56;     // Catch: IllegalAccessException -> L182
        goto L79
    L144:
        r56 = r2.q.charAt(r55);     // Catch: IllegalAccessException -> L182
        goto L145
    L146:
        if (r54 != ']') goto L87;
        int r57 = r2.f12408e + 1;     // Catch: IllegalAccessException -> L182
        r2.f12408e = r57;     // Catch: IllegalAccessException -> L182
        if (r57 < r2.r) goto L150;
        char r58 = 26;
    L151:
        r2.f12407d = r58;     // Catch: IllegalAccessException -> L182
        goto L86
    L150:
        r58 = r2.q.charAt(r57);     // Catch: IllegalAccessException -> L182
        goto L151
    L8:
        r9 = ',';
        goto L9
    L186:
        if (r2.f12407d != ',') goto L192;
        int r0 = r2.f12408e + 1;
        r2.f12408e = r0;
        if (r0 < r2.r) goto L190;
        char r59 = 26;
    L191:
        r2.f12407d = r59;
        r2.f12404a = 16;
    L193:
        return r3;
    L190:
        r59 = r2.q.charAt(r0);
        goto L191
    L192:
        r2.s();
        goto L193
    }

    private boolean j(b r17, String r18, Object r19, Type r20, Map<String, Object> r21) {
        e r12 = r17.f12388j;
        d.a.a.i.q.d r2 = f(r18);
        if (r2 != null) goto L18;
        boolean r3 = r18.startsWith("is");
        d.a.a.i.q.d[] r4 = this.f12417b;
        int r5 = r4.length;
        int r6 = 0;
    L5:
        if (r6 >= r5) goto L18;
        d.a.a.i.q.d r7 = r4[r6];
        d.a.a.k.a r8 = r7.f12460a;
        Class<?> r9 = r8.f12534l;
        String r10 = r8.f12528f;
        if (r10.equalsIgnoreCase(r18) == true) goto L16;
        if (r3 == false) goto L17;
        if (r9 == Boolean.TYPE) goto L15;
        if (r9 != Boolean.class) goto L17;
    L15:
        if (r10.equalsIgnoreCase(r18.substring(2)) == true) goto L16;
    L17:
        r6 = r6 + 1;
    L16:
        r2 = r7;
    L18:
        int r11 = d.w.f12403f;
        if (r2 == null) goto L21;
    L45:
        if (r2 != null) goto L48;
        i(r17, r19, r18);
        return false;
    L48:
        r12.u(':');
        r2.b(r17, r19, r20, r21);
        return true;
    L21:
        if ((r17.f12388j.f12406c & r11) != 0) goto L25;
        if ((r11 & this.f12420e.f12433l) == 0) goto L45;
    L25:
        if (this.f12421f != null) goto L39;
        ConcurrentHashMap r13 = new ConcurrentHashMap(1, 0.75f, 1);
        Field[] r14 = this.f12419d.getDeclaredFields();
        int r15 = r14.length;
        int r16 = 0;
    L27:
        if (r16 >= r15) goto L38;
        Field r22 = r14[r16];
        String r23 = r22.getName();
        if (f(r23) != null) goto L37;
        int r24 = r22.getModifiers();
        if ((r24 & 16) != 0) goto L37;
        if ((r24 & 8) != 0) goto L37;
        r13.put(r23, r22);
    L37:
        r16 = r16 + 1;
        goto L27
    L38:
        this.f12421f = r13;
    L39:
        Object r25 = this.f12421f.get(r18);
        if (r25 == null) goto L45;
        if ((r25 instanceof d.a.a.i.q.d) == false) goto L44;
        r2 = (d.a.a.i.q.d) r25;
        goto L45
    L44:
        Field r26 = (Field) r25;
        r26.setAccessible(true);
        r2 = new a(r17.f12385g, this.f12419d, new d.a.a.k.a(r18, r26.getDeclaringClass(), r26.getType(), r26.getGenericType(), r26, 0, 0));
        this.f12421f.put(r18, r2);
        goto L45
    }

    @Override // d.a.a.i.q.f
    public <T> T a(b r2, Type r3, Object r4) {
        return (T) d(r2, r3, r4, null);
    }

    protected Object b(b r7, Type r8) {
        int r2 = 0;
        if ((r8 instanceof Class) == true) goto L5;
    L12:
        h r9 = this.f12420e;
        Constructor<?> r0 = r9.f12422a;
        if (r0 == null) goto L15;
    L17:
        Method r4 = r9.f12425d;
        if (r4 != null) goto L20;
    L41:
    L38:
        e = move-exception;
        throw new d.a.a.d("create instance error, class " + this.f12419d.getName(), e);
    L23:
        if (r9.f12423b != 0) goto L27;
        if (r0 == null) goto L26;
        Object r10 = r0.newInstance(new Object[0]);     // Catch: Exception -> L38
    L28:
        if (r7 != null) goto L30;
    L37:
        return r10;
    L30:
        if ((r7.f12388j.f12406c & d.s.f12403f) == 0) goto L37;
        d.a.a.k.a[] r11 = this.f12420e.f12426e;     // Catch: Exception -> L38
        int r1 = r11.length;     // Catch: Exception -> L38
    L32:
        if (r2 >= r1) goto L37;
        d.a.a.k.a r3 = r11[r2];     // Catch: Exception -> L38
        if (r3.f12534l != String.class) goto L36;
        r3.l(r10, "");     // Catch: Exception -> L38
    L36:
        r2 = r2 + 1;
        goto L32
    L26:
        r10 = r4.invoke(null, new Object[0]);     // Catch: Exception -> L38
        goto L28
    L27:
        r10 = r0.newInstance(new Object[]{r7.f12389k.f12439a});     // Catch: Exception -> L38
        goto L28
    L20:
        if (r9.f12423b <= 0) goto L41;
        return null;
    L15:
        if (r9.f12425d != null) goto L17;
        return null;
    L5:
        if (this.f12419d.isInterface() == false) goto L12;
        Class r12 = (Class) r8;
        ClassLoader r6 = Thread.currentThread().getContextClassLoader();
        if ((r7.f12388j.f12406c & d.u.f12403f) == 0) goto L9;
        boolean r13 = true;
    L11:
        return Proxy.newProxyInstance(r6, new Class[]{r12}, new d.a.a.e(r13));
    L9:
        r13 = false;
        goto L11
    }

    public Object c(Map<String, Object> r6, m r7) {
        h r0 = this.f12420e;
        int r3 = 0;
        if (r0.f12424c != null) goto L15;
        Object r1 = b(null, this.f12419d);
        Iterator<Map.Entry<String, Object>> r8 = r6.entrySet().iterator();
    L6:
        if (r8.hasNext() == false) goto L14;
        Map.Entry<String, Object> r2 = r8.next();
        d.a.a.i.q.d r4 = f(r2.getKey());
        if (r4 == null) goto L6;
        Object r5 = r2.getValue();
        d.a.a.k.a r9 = r4.f12460a;
        Method r10 = r9.f12529g;
        if (r10 != null) goto L12;
        r9.f12530h.set(r1, d.a.a.k.d.c(r5, r9.m, r7));
        goto L6
    L12:
        r10.invoke(r1, new Object[]{d.a.a.k.d.c(r5, r10.getGenericParameterTypes()[0], r7)});
        goto L6
    L14:
        return r1;
    L15:
        d.a.a.k.a[] r11 = r0.f12426e;
        int r12 = r11.length;
        Object[] r13 = new Object[r12];
    L16:
        if (r3 >= r12) goto L18;
        r13[r3] = r6.get(r11[r3].f12528f);
        r3 = r3 + 1;
        goto L16
    L18:
        Constructor<?> r14 = this.f12420e.f12424c;
        if (r14 != null) goto L26;
        return null;
    L26:
        return r14.newInstance(r13);
    L22:
        e = move-exception;
        throw new d.a.a.d("create instance error, " + this.f12420e.f12424c.toGenericString(), e);
    }

    protected d.a.a.i.q.d f(String r6) {
        if (r6 != null) goto L5;
        return null;
    L5:
        int r2 = 0;
        if (this.f12420e.f12429h == false) goto L14;
    L7:
        d.a.a.i.q.d[] r1 = this.f12417b;
        if (r2 >= r1.length) goto L13;
        d.a.a.i.q.d r3 = r1[r2];
        if (r3.f12460a.f12528f.equalsIgnoreCase(r6) == true) goto L11;
        r2 = r2 + 1;
        goto L7
    L11:
        return r3;
    L13:
        return null;
    L14:
        int r4 = this.f12417b.length - 1;
    L15:
        if (r2 > r4) goto L23;
        int r5 = (r2 + r4) >>> 1;
        int r7 = this.f12417b[r5].f12460a.f12528f.compareTo(r6);
        if (r7 < 0) goto L18;
        if (r7 <= 0) goto L22;
        r4 = r5 - 1;
        goto L15
    L22:
        return this.f12417b[r5];
    L18:
        r2 = r5 + 1;
        goto L15
    L23:
        Map<String, d.a.a.i.q.d> r8 = this.f12418c;
        if (r8 != null) goto L26;
        return null;
    L26:
        return r8.get(r6);
    }

    protected d.a.a.i.q.d g(long r5) {
        int r0 = 0;
    L3:
        d.a.a.i.q.d[] r1 = this.f12417b;
        if (r0 >= r1.length) goto L9;
        d.a.a.i.q.d r2 = r1[r0];
        if (r2.f12460a.t == r5) goto L7;
        r0 = r0 + 1;
        goto L3
    L7:
        return r2;
    L9:
        return null;
    }

    protected g h(m r7, h r8, String r9) {
        d.a.a.h.c r10 = r8.f12428g;
        if (r10 != null) goto L5;
        return null;
    L5:
        Class<?>[] r11 = r10.seeAlso();
        int r1 = r11.length;
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L16;
        d.a.a.i.q.f r3 = r7.c(r11[r2]);
        if ((r3 instanceof g) == false) goto L15;
        g r4 = (g) r3;
        h r5 = r4.f12420e;
        if (r5.f12431j.equals(r9) == true) goto L11;
        g r6 = h(r7, r5, r9);
        if (r6 == null) goto L15;
        return r6;
    L11:
        return r4;
    L15:
        r2 = r2 + 1;
        goto L6
    L16:
        return null;
    }

    void i(b r4, Object r5, String r6) {
        e r0 = r4.f12388j;
        if ((r0.f12406c & d.o.f12403f) == 0) goto L25;
        r0.u(':');
        Type r3 = null;
        List<d.a.a.i.q.c> r1 = r4.p;
        if (r1 == null) goto L10;
        Iterator<d.a.a.i.q.c> r2 = r1.iterator();
    L8:
        if (r2.hasNext() == false) goto L10;
        r3 = r2.next().b(r5, r6);
    L10:
        if (r3 != null) goto L12;
        Object r7 = r4.F();
    L14:
        if ((r5 instanceof d.a.a.i.q.a) == false) goto L17;
        ((d.a.a.i.q.a) r5).a(r6, r7);
        return;
    L17:
        List<d.a.a.i.q.b> r8 = r4.q;
        if (r8 == null) goto L23;
        Iterator<d.a.a.i.q.b> r9 = r8.iterator();
    L21:
        if (r9.hasNext() == false) goto L28;
        r9.next().a(r5, r6, r7);
        goto L21
    L28:
        return;
    L23:
        return;
    L12:
        r7 = r4.X(r3);
        goto L14
    L25:
        throw new d.a.a.d("setter not found, class " + this.f12419d.getName() + ", property " + r6);
    }
}
