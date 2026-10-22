package kotlin.s0.w.d.l0.k;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.common.wschannel.WsConstants;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.s0.w.d.l0.c.b1;
import kotlin.s0.w.d.l0.c.h0;
import kotlin.s0.w.d.l0.c.k1;
import kotlin.s0.w.d.l0.c.l0;
import kotlin.s0.w.d.l0.c.q;
import kotlin.s0.w.d.l0.c.q0;
import kotlin.s0.w.d.l0.c.t;
import kotlin.s0.w.d.l0.c.u;
import kotlin.s0.w.d.l0.c.w0;
import kotlin.s0.w.d.l0.c.x0;
import kotlin.s0.w.d.l0.n.e0;
import kotlin.s0.w.d.l0.n.e1;
import kotlin.s0.w.d.l0.n.g0;
import kotlin.s0.w.d.l0.n.n1;

/* JADX INFO: loaded from: classes2.dex */
public class d {
    static {
        new kotlin.s0.w.d.l0.g.c("kotlin.jvm.JvmName");
    }

    public static boolean A(kotlin.s0.w.d.l0.c.m r1) {
        return D(r1, kotlin.s0.w.d.l0.c.f.f18867h);
    }

    public static boolean B(kotlin.s0.w.d.l0.c.m r1) {
        if (r1 != null) goto L4;
        a(36);
        throw null;
    L4:
        return D(r1, kotlin.s0.w.d.l0.c.f.f18868i);
    }

    public static boolean C(kotlin.s0.w.d.l0.c.m r1) {
        return D(r1, kotlin.s0.w.d.l0.c.f.f18866g);
    }

    private static boolean D(kotlin.s0.w.d.l0.c.m r1, kotlin.s0.w.d.l0.c.f r2) {
        if (r2 != null) goto L4;
        a(37);
        throw null;
    L4:
        if ((r1 instanceof kotlin.s0.w.d.l0.c.e) == true) goto L6;
    L8:
        return false;
    L6:
        if (((kotlin.s0.w.d.l0.c.e) r1).i() != r2) goto L8;
        return true;
    }

    public static boolean E(kotlin.s0.w.d.l0.c.m r2) {
        if (r2 == null) goto L14;
    L4:
        if (r2 == null) goto L12;
        if (u(r2) == true) goto L11;
        if (y(r2) == true) goto L11;
        r2 = r2.c();
    L11:
        return true;
    L12:
        return false;
    L14:
        a(1);
        throw null;
    }

    private static boolean F(e0 r1, kotlin.s0.w.d.l0.c.m r2) {
        if (r1 == null) goto L19;
        if (r2 == null) goto L17;
        kotlin.s0.w.d.l0.c.h r3 = r1.O0().d();
        if (r3 == null) goto L15;
        kotlin.s0.w.d.l0.c.m r4 = r3.a();
        if ((r4 instanceof kotlin.s0.w.d.l0.c.h) == true) goto L10;
        return false;
    L10:
        if ((r2 instanceof kotlin.s0.w.d.l0.c.h) == true) goto L12;
        return false;
    L12:
        if (((kotlin.s0.w.d.l0.c.h) r2).k().equals(((kotlin.s0.w.d.l0.c.h) r4).k()) == false) goto L23;
        return true;
    L23:
        return false;
    L15:
        return false;
    L17:
        a(31);
        throw null;
    L19:
        a(30);
        throw null;
    }

    public static boolean G(kotlin.s0.w.d.l0.c.m r1) {
        if (D(r1, kotlin.s0.w.d.l0.c.f.f18865f) == true) goto L7;
        if (D(r1, kotlin.s0.w.d.l0.c.f.f18866g) == true) goto L7;
    L9:
        return false;
    L7:
        if (((kotlin.s0.w.d.l0.c.e) r1).l() != kotlin.s0.w.d.l0.c.e0.f18861h) goto L9;
        return true;
    }

    public static boolean H(kotlin.s0.w.d.l0.c.e r1, kotlin.s0.w.d.l0.c.e r2) {
        if (r1 == null) goto L9;
        if (r2 != null) goto L6;
        a(29);
        throw null;
    L6:
        return I(r1.s(), r2.a());
    L9:
        a(28);
        throw null;
    }

    public static boolean I(e0 r2, kotlin.s0.w.d.l0.c.m r3) {
        if (r2 == null) goto L18;
        if (r3 != null) goto L6;
        a(33);
        throw null;
    L6:
        if (F(r2, r3) == false) goto L8;
        return true;
    L8:
        Iterator<e0> r4 = r2.O0().a().iterator();
    L10:
        if (r4.hasNext() == false) goto L14;
        if (I(r4.next(), r3) == false) goto L10;
        return true;
    L14:
        return false;
    L18:
        a(32);
        throw null;
    }

    public static boolean J(kotlin.s0.w.d.l0.c.m r0) {
        if (r0 != null) goto L4;
    L6:
        return false;
    L4:
        if ((r0.c() instanceof l0) == false) goto L6;
        return true;
    }

    public static boolean K(k1 r4, e0 r5) {
        if (r4 == null) goto L27;
        if (r5 != null) goto L6;
        a(64);
        throw null;
    L6:
        if (r4.j0() == false) goto L8;
        return false;
    L8:
        if (g0.a(r5) == false) goto L11;
        return false;
    L11:
        if (n1.b(r5) == false) goto L13;
        return true;
    L13:
        kotlin.s0.w.d.l0.b.h r6 = kotlin.s0.w.d.l0.k.t.a.f(r4);
        if (kotlin.s0.w.d.l0.b.h.r0(r5) == true) goto L24;
        kotlin.s0.w.d.l0.n.t1.e r0 = kotlin.s0.w.d.l0.n.t1.e.f21078a;
        if (r0.b(r6.W(), r5) == true) goto L24;
        if (r0.b(r6.K().s(), r5) == true) goto L24;
        if (r0.b(r6.i(), r5) == true) goto L24;
        kotlin.s0.w.d.l0.b.o r7 = kotlin.s0.w.d.l0.b.o.f18745a;
        if (kotlin.s0.w.d.l0.b.o.d(r5) == true) goto L24;
        return false;
    L24:
        return true;
    L27:
        a(63);
        throw null;
    }

    public static <D extends kotlin.s0.w.d.l0.c.b> D L(D r3) {
        if (r3 != null) goto L5;
        a(59);
        throw null;
    L5:
        if (r3.i() != kotlin.s0.w.d.l0.c.b.a.f18849g) goto L11;
        Collection<? extends kotlin.s0.w.d.l0.c.b> r1 = r3.f();
        if (r1.isEmpty() == true) goto L10;
        r3 = (D) r1.iterator().next();
        goto L5
    L10:
        throw new IllegalStateException("Fake override should have at least one overridden descriptor: " + r3);
    L11:
        if (r3 == null) goto L13;
        return r3;
    L13:
        a(60);
        throw null;
    }

    public static <D extends q> D M(D r2) {
        if (r2 != null) goto L5;
        a(61);
        throw null;
    L5:
        if ((r2 instanceof kotlin.s0.w.d.l0.c.b) == true) goto L7;
        if (r2 == null) goto L10;
        return r2;
    L10:
        a(62);
        throw null;
    L7:
        return L((kotlin.s0.w.d.l0.c.b) r2);
    }

    private static /* synthetic */ void a(int r23) {
        switch(r23) {
            case 4: goto L4;
            case 7: goto L4;
            case 9: goto L4;
            case 10: goto L4;
            case 12: goto L4;
            case 22: goto L4;
            case 40: goto L4;
            case 42: goto L4;
            case 43: goto L4;
            case 47: goto L4;
            case 49: goto L4;
            case 50: goto L4;
            case 51: goto L4;
            case 52: goto L4;
            case 53: goto L4;
            case 60: goto L4;
            case 62: goto L4;
            case 69: goto L4;
            case 73: goto L4;
            case 80: goto L4;
            case 81: goto L4;
            case 83: goto L4;
            case 86: goto L4;
            case 91: goto L4;
            case 93: goto L4;
            default: goto L3;
        };
    L3:
        String r0 = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
    L6:
        switch(r23) {
            case 4: goto L8;
            case 7: goto L8;
            case 9: goto L8;
            case 10: goto L8;
            case 12: goto L8;
            case 22: goto L8;
            case 40: goto L8;
            case 42: goto L8;
            case 43: goto L8;
            case 47: goto L8;
            case 49: goto L8;
            case 50: goto L8;
            case 51: goto L8;
            case 52: goto L8;
            case 53: goto L8;
            case 60: goto L8;
            case 62: goto L8;
            case 69: goto L8;
            case 73: goto L8;
            case 80: goto L8;
            case 81: goto L8;
            case 83: goto L8;
            case 86: goto L8;
            case 91: goto L8;
            case 93: goto L8;
            default: goto L7;
        };
    L7:
        int r2 = 3;
    L9:
        Object[] r3 = new Object[r2];
        switch(r23) {
            case 1: goto L35;
            case 2: goto L35;
            case 3: goto L35;
            case 4: goto L34;
            case 5: goto L35;
            case 6: goto L35;
            case 7: goto L34;
            case 8: goto L35;
            case 9: goto L34;
            case 10: goto L34;
            case 11: goto L35;
            case 12: goto L34;
            case 13: goto L35;
            case 14: goto L35;
            case 15: goto L35;
            case 16: goto L33;
            case 17: goto L32;
            case 18: goto L31;
            case 19: goto L31;
            case 20: goto L30;
            case 21: goto L35;
            case 22: goto L34;
            case 23: goto L35;
            case 24: goto L35;
            case 25: goto L29;
            case 26: goto L28;
            case 27: goto L27;
            case 28: goto L28;
            case 29: goto L27;
            case 30: goto L26;
            case 31: goto L25;
            case 32: goto L26;
            case 33: goto L27;
            case 34: goto L35;
            case 35: goto L35;
            case 36: goto L35;
            case 37: goto L24;
            case 38: goto L23;
            case 39: goto L23;
            case 40: goto L34;
            case 41: goto L23;
            case 42: goto L34;
            case 43: goto L34;
            case 44: goto L23;
            case 45: goto L26;
            case 46: goto L22;
            case 47: goto L34;
            case 48: goto L23;
            case 49: goto L34;
            case 50: goto L34;
            case 51: goto L34;
            case 52: goto L34;
            case 53: goto L34;
            case 54: goto L23;
            case 55: goto L21;
            case 56: goto L20;
            case 57: goto L35;
            case 58: goto L35;
            case 59: goto L35;
            case 60: goto L34;
            case 61: goto L35;
            case 62: goto L34;
            case 63: goto L19;
            case 64: goto L26;
            case 65: goto L23;
            case 66: goto L23;
            case 67: goto L23;
            case 68: goto L18;
            case 69: goto L34;
            case 70: goto L17;
            case 71: goto L16;
            case 72: goto L15;
            case 73: goto L34;
            case 74: goto L23;
            case 75: goto L23;
            case 76: goto L14;
            case 77: goto L14;
            case 78: goto L14;
            case 79: goto L35;
            case 80: goto L34;
            case 81: goto L34;
            case 82: goto L13;
            case 83: goto L34;
            case 84: goto L13;
            case 85: goto L12;
            case 86: goto L34;
            case 87: goto L13;
            case 88: goto L12;
            case 89: goto L13;
            case 90: goto L12;
            case 91: goto L34;
            case 92: goto L35;
            case 93: goto L34;
            case 94: goto L35;
            default: goto L11;
        };
    L11:
        r3[0] = "containingDeclaration";
    L37:
        switch(r23) {
            case 4: goto L56;
            case 7: goto L55;
            case 9: goto L54;
            case 10: goto L54;
            case 12: goto L53;
            case 22: goto L52;
            case 40: goto L51;
            case 42: goto L50;
            case 43: goto L50;
            case 47: goto L49;
            case 49: goto L48;
            case 50: goto L48;
            case 51: goto L48;
            case 52: goto L48;
            case 53: goto L48;
            case 60: goto L47;
            case 62: goto L46;
            case 69: goto L45;
            case 73: goto L44;
            case 80: goto L43;
            case 81: goto L43;
            case 83: goto L42;
            case 86: goto L41;
            case 91: goto L40;
            case 93: goto L39;
            default: goto L38;
        };
    L38:
        r3[1] = "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils";
    L57:
        switch(r23) {
            case 1: goto L113;
            case 2: goto L112;
            case 3: goto L111;
            case 4: goto L114;
            case 5: goto L110;
            case 6: goto L109;
            case 7: goto L114;
            case 8: goto L108;
            case 9: goto L114;
            case 10: goto L114;
            case 11: goto L107;
            case 12: goto L114;
            case 13: goto L106;
            case 14: goto L105;
            case 15: goto L104;
            case 16: goto L103;
            case 17: goto L103;
            case 18: goto L102;
            case 19: goto L102;
            case 20: goto L101;
            case 21: goto L100;
            case 22: goto L114;
            case 23: goto L101;
            case 24: goto L99;
            case 25: goto L98;
            case 26: goto L97;
            case 27: goto L97;
            case 28: goto L96;
            case 29: goto L96;
            case 30: goto L95;
            case 31: goto L95;
            case 32: goto L94;
            case 33: goto L94;
            case 34: goto L93;
            case 35: goto L92;
            case 36: goto L91;
            case 37: goto L90;
            case 38: goto L89;
            case 39: goto L88;
            case 40: goto L114;
            case 41: goto L87;
            case 42: goto L114;
            case 43: goto L114;
            case 44: goto L86;
            case 45: goto L85;
            case 46: goto L84;
            case 47: goto L114;
            case 48: goto L83;
            case 49: goto L114;
            case 50: goto L114;
            case 51: goto L114;
            case 52: goto L114;
            case 53: goto L114;
            case 54: goto L82;
            case 55: goto L82;
            case 56: goto L82;
            case 57: goto L81;
            case 58: goto L80;
            case 59: goto L79;
            case 60: goto L114;
            case 61: goto L78;
            case 62: goto L114;
            case 63: goto L77;
            case 64: goto L77;
            case 65: goto L76;
            case 66: goto L75;
            case 67: goto L74;
            case 68: goto L73;
            case 69: goto L114;
            case 70: goto L72;
            case 71: goto L72;
            case 72: goto L71;
            case 73: goto L114;
            case 74: goto L70;
            case 75: goto L69;
            case 76: goto L68;
            case 77: goto L67;
            case 78: goto L66;
            case 79: goto L65;
            case 80: goto L114;
            case 81: goto L114;
            case 82: goto L64;
            case 83: goto L114;
            case 84: goto L63;
            case 85: goto L63;
            case 86: goto L114;
            case 87: goto L62;
            case 88: goto L62;
            case 89: goto L61;
            case 90: goto L61;
            case 91: goto L114;
            case 92: goto L60;
            case 93: goto L114;
            case 94: goto L59;
            default: goto L58;
        };
    L58:
        r3[2] = "getDispatchReceiverParameterIfNeeded";
        goto L114
    L59:
        r3[2] = "isMethodOfAny";
        goto L114
    L60:
        r3[2] = "getDirectMember";
        goto L114
    L61:
        r3[2] = "getPropertyByName";
        goto L114
    L62:
        r3[2] = "getFunctionByNameOrNull";
        goto L114
    L63:
        r3[2] = "getFunctionByName";
        goto L114
    L64:
        r3[2] = "getAllDescriptors";
        goto L114
    L65:
        r3[2] = "getContainingSourceFile";
        goto L114
    L66:
        r3[2] = "hasJvmNameAnnotation";
        goto L114
    L67:
        r3[2] = "findJvmNameAnnotation";
        goto L114
    L68:
        r3[2] = "getJvmName";
        goto L114
    L69:
        r3[2] = "canHaveDeclaredConstructors";
        goto L114
    L70:
        r3[2] = "isSingletonOrAnonymousObject";
        goto L114
    L71:
        r3[2] = "getAllOverriddenDeclarations";
        goto L114
    L72:
        r3[2] = "collectAllOverriddenDescriptors";
        goto L114
    L73:
        r3[2] = "getAllOverriddenDescriptors";
        goto L114
    L74:
        r3[2] = "classCanHaveOpenMembers";
        goto L114
    L75:
        r3[2] = "classCanHaveAbstractDeclaration";
        goto L114
    L76:
        r3[2] = "classCanHaveAbstractFakeOverride";
        goto L114
    L77:
        r3[2] = "shouldRecordInitializerForProperty";
        goto L114
    L78:
        r3[2] = "unwrapFakeOverrideToAnyDeclaration";
        goto L114
    L79:
        r3[2] = "unwrapFakeOverride";
        goto L114
    L80:
        r3[2] = "isTopLevelOrInnerClass";
        goto L114
    L81:
        r3[2] = "isStaticNestedClass";
        goto L114
    L82:
        r3[2] = "getInnerClassByName";
        goto L114
    L83:
        r3[2] = "getDefaultConstructorVisibility";
        goto L114
    L84:
        r3[2] = "getClassDescriptorForTypeConstructor";
        goto L114
    L85:
        r3[2] = "getClassDescriptorForType";
        goto L114
    L86:
        r3[2] = "getSuperClassDescriptor";
        goto L114
    L87:
        r3[2] = "getSuperClassType";
        goto L114
    L88:
        r3[2] = "getSuperclassDescriptors";
        goto L114
    L89:
        r3[2] = "hasAbstractMembers";
        goto L114
    L90:
        r3[2] = "isKindOf";
        goto L114
    L91:
        r3[2] = "isEnumEntry";
        goto L114
    L92:
        r3[2] = "isAnonymousFunction";
        goto L114
    L93:
        r3[2] = "isAnonymousObject";
        goto L114
    L94:
        r3[2] = "isSubtypeOfClass";
        goto L114
    L95:
        r3[2] = "isSameClass";
        goto L114
    L96:
        r3[2] = "isSubclass";
        goto L114
    L97:
        r3[2] = "isDirectSubclass";
        goto L114
    L98:
        r3[2] = "isAncestor";
        goto L114
    L99:
        r3[2] = "getContainingClass";
        goto L114
    L100:
        r3[2] = "getContainingModule";
        goto L114
    L101:
        r3[2] = "getContainingModuleOrNull";
        goto L114
    L102:
        r3[2] = "getParentOfType";
        goto L114
    L103:
        r3[2] = "areInSameModule";
        goto L114
    L104:
        r3[2] = "isStaticDeclaration";
        goto L114
    L105:
        r3[2] = "isOverride";
        goto L114
    L106:
        r3[2] = "isExtension";
        goto L114
    L107:
        r3[2] = "getClassIdForNonLocalClass";
        goto L114
    L108:
        r3[2] = "getFqNameFromTopLevelClass";
        goto L114
    L109:
        r3[2] = "getFqNameUnsafe";
        goto L114
    L110:
        r3[2] = "getFqNameSafeIfPossible";
        goto L114
    L111:
        r3[2] = "getFqNameSafe";
        goto L114
    L112:
        r3[2] = "getFqName";
        goto L114
    L113:
        r3[2] = "isLocal";
    L114:
        String r1 = String.format(r0, r3);
        switch(r23) {
            case 4: goto L118;
            case 7: goto L118;
            case 9: goto L118;
            case 10: goto L118;
            case 12: goto L118;
            case 22: goto L118;
            case 40: goto L118;
            case 42: goto L118;
            case 43: goto L118;
            case 47: goto L118;
            case 49: goto L118;
            case 50: goto L118;
            case 51: goto L118;
            case 52: goto L118;
            case 53: goto L118;
            case 60: goto L118;
            case 62: goto L118;
            case 69: goto L118;
            case 73: goto L118;
            case 80: goto L118;
            case 81: goto L118;
            case 83: goto L118;
            case 86: goto L118;
            case 91: goto L118;
            case 93: goto L118;
            default: goto L119;
        };
    L119:
        throw new IllegalArgumentException(r1);
    L118:
        throw new IllegalStateException(r1);
    L39:
        r3[1] = "getDirectMember";
        goto L57
    L40:
        r3[1] = "getPropertyByName";
        goto L57
    L41:
        r3[1] = "getFunctionByName";
        goto L57
    L42:
        r3[1] = "getAllDescriptors";
        goto L57
    L43:
        r3[1] = "getContainingSourceFile";
        goto L57
    L44:
        r3[1] = "getAllOverriddenDeclarations";
        goto L57
    L45:
        r3[1] = "getAllOverriddenDescriptors";
        goto L57
    L46:
        r3[1] = "unwrapFakeOverrideToAnyDeclaration";
        goto L57
    L47:
        r3[1] = "unwrapFakeOverride";
        goto L57
    L48:
        r3[1] = "getDefaultConstructorVisibility";
        goto L57
    L49:
        r3[1] = "getClassDescriptorForTypeConstructor";
        goto L57
    L50:
        r3[1] = "getSuperClassType";
        goto L57
    L51:
        r3[1] = "getSuperclassDescriptors";
        goto L57
    L52:
        r3[1] = "getContainingModule";
        goto L57
    L53:
        r3[1] = "getClassIdForNonLocalClass";
        goto L57
    L54:
        r3[1] = "getFqNameFromTopLevelClass";
        goto L57
    L55:
        r3[1] = "getFqNameUnsafe";
        goto L57
    L56:
        r3[1] = "getFqNameSafe";
        goto L57
    L12:
        r3[0] = "name";
        goto L37
    L13:
        r3[0] = "scope";
        goto L37
    L14:
        r3[0] = "annotated";
        goto L37
    L15:
        r3[0] = "memberDescriptor";
        goto L37
    L16:
        r3[0] = "result";
        goto L37
    L17:
        r3[0] = "current";
        goto L37
    L18:
        r3[0] = "f";
        goto L37
    L19:
        r3[0] = "variable";
        goto L37
    L20:
        r3[0] = LocationMonitorConst.LOCATION;
        goto L37
    L21:
        r3[0] = "innerClassName";
        goto L37
    L22:
        r3[0] = "typeConstructor";
        goto L37
    L23:
        r3[0] = "classDescriptor";
        goto L37
    L24:
        r3[0] = "classKind";
        goto L37
    L25:
        r3[0] = "other";
        goto L37
    L26:
        r3[0] = WsConstants.KEY_CONNECTION_TYPE;
        goto L37
    L27:
        r3[0] = "superClass";
        goto L37
    L28:
        r3[0] = "subClass";
        goto L37
    L29:
        r3[0] = "declarationDescriptor";
        goto L37
    L30:
        r3[0] = "kotlinType";
        goto L37
    L31:
        r3[0] = "aClass";
        goto L37
    L32:
        r3[0] = "second";
        goto L37
    L33:
        r3[0] = "first";
        goto L37
    L34:
        r3[0] = "kotlin/reflect/jvm/internal/impl/resolve/DescriptorUtils";
        goto L37
    L35:
        r3[0] = "descriptor";
        goto L37
    L8:
        r2 = 2;
        goto L9
    L4:
        r0 = "@NotNull method %s.%s must not return null";
        goto L6
    }

    public static boolean b(kotlin.s0.w.d.l0.c.m r1, kotlin.s0.w.d.l0.c.m r2) {
        if (r1 == null) goto L9;
        if (r2 != null) goto L6;
        a(17);
        throw null;
    L6:
        return g(r1).equals(g(r2));
    L9:
        a(16);
        throw null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <D extends kotlin.s0.w.d.l0.c.a> void c(D r1, Set<D> r2) {
        if (r1 == null) goto L15;
        if (r2 != 0) goto L6;
        a(71);
        throw null;
    L6:
        if (r2.contains(r1) == false) goto L8;
        return;
    L8:
        Iterator<? extends kotlin.s0.w.d.l0.c.a> r3 = r1.a().f().iterator();
    L10:
        if (r3.hasNext() == false) goto L12;
        kotlin.s0.w.d.l0.c.a r0 = r3.next().a();
        c(r0, r2);
        r2.add(r0);
        goto L10
    L12:
        return;
    L15:
        a(70);
        throw null;
    }

    public static <D extends kotlin.s0.w.d.l0.c.a> Set<D> d(D r1) {
        if (r1 == null) goto L5;
        LinkedHashSet r0 = new LinkedHashSet();
        c(r1.a(), r0);
        return r0;
    L5:
        a(68);
        throw null;
    }

    public static kotlin.s0.w.d.l0.c.e e(e0 r0) {
        if (r0 != null) goto L4;
        a(45);
        throw null;
    L4:
        return f(r0.O0());
    }

    public static kotlin.s0.w.d.l0.c.e f(e1 r1) {
        if (r1 == null) goto L9;
        kotlin.s0.w.d.l0.c.e r2 = (kotlin.s0.w.d.l0.c.e) r1.d();
        if (r2 == null) goto L7;
        return r2;
    L7:
        a(47);
        throw null;
    L9:
        a(46);
        throw null;
    }

    public static h0 g(kotlin.s0.w.d.l0.c.m r1) {
        if (r1 == null) goto L9;
        h0 r2 = h(r1);
        if (r2 == null) goto L7;
        return r2;
    L7:
        a(22);
        throw null;
    L9:
        a(21);
        throw null;
    }

    public static h0 h(kotlin.s0.w.d.l0.c.m r2) {
        if (r2 == null) goto L15;
    L4:
        if (r2 == null) goto L14;
        if ((r2 instanceof h0) == true) goto L8;
        if ((r2 instanceof q0) == true) goto L12;
        r2 = r2.c();
        goto L4
    L12:
        return ((q0) r2).v0();
    L8:
        return (h0) r2;
    L14:
        return null;
    L15:
        a(23);
        throw null;
    }

    public static h0 i(e0 r1) {
        if (r1 == null) goto L9;
        kotlin.s0.w.d.l0.c.h r2 = r1.O0().d();
        if (r2 != null) goto L8;
        return null;
    L8:
        return h(r2);
    L9:
        a(20);
        throw null;
    }

    public static b1 j(kotlin.s0.w.d.l0.c.m r2) {
        if (r2 != null) goto L5;
        a(79);
        throw null;
    L5:
        if ((r2 instanceof w0) == false) goto L8;
        r2 = ((w0) r2).B0();
    L8:
        if ((r2 instanceof kotlin.s0.w.d.l0.c.p) == false) goto L14;
        b1 r3 = ((kotlin.s0.w.d.l0.c.p) r2).getSource().a();
        if (r3 == null) goto L12;
        return r3;
    L12:
        a(80);
        throw null;
    L14:
        b1 r4 = b1.f18854a;
        if (r4 == null) goto L17;
        return r4;
    L17:
        a(81);
        throw null;
    }

    public static u k(kotlin.s0.w.d.l0.c.e r3, boolean r4) {
        if (r3 == null) goto L39;
        kotlin.s0.w.d.l0.c.f r1 = r3.i();
        if (r1 != kotlin.s0.w.d.l0.c.f.f18867h) goto L7;
    L34:
        u r5 = t.f19159a;
        if (r5 == null) goto L37;
        return r5;
    L37:
        a(49);
        throw null;
    L7:
        if (r1.b() == true) goto L34;
        if (G(r3) == false) goto L23;
        if (r4 == false) goto L17;
        u r6 = t.f19161c;
        if (r6 == null) goto L15;
        return r6;
    L15:
        a(50);
        throw null;
    L17:
        u r7 = t.f19159a;
        if (r7 == null) goto L20;
        return r7;
    L20:
        a(51);
        throw null;
    L23:
        if (u(r3) == false) goto L29;
        u r8 = t.f19169k;
        if (r8 == null) goto L27;
        return r8;
    L27:
        a(52);
        throw null;
    L29:
        u r9 = t.f19163e;
        if (r9 == null) goto L32;
        return r9;
    L32:
        a(53);
        throw null;
    L39:
        a(48);
        throw null;
    }

    public static x0 l(kotlin.s0.w.d.l0.c.m r2) {
        if (r2 != null) goto L5;
        a(0);
        throw null;
    L5:
        if ((r2 instanceof kotlin.s0.w.d.l0.c.e) == true) goto L7;
        return null;
    L7:
        return ((kotlin.s0.w.d.l0.c.e) r2).K0();
    }

    public static kotlin.s0.w.d.l0.g.d m(kotlin.s0.w.d.l0.c.m r1) {
        if (r1 == null) goto L8;
        kotlin.s0.w.d.l0.g.c r0 = o(r1);
        if (r0 == null) goto L7;
        return r0.j();
    L7:
        return p(r1);
    L8:
        a(2);
        throw null;
    }

    public static kotlin.s0.w.d.l0.g.c n(kotlin.s0.w.d.l0.c.m r2) {
        if (r2 == null) goto L12;
        kotlin.s0.w.d.l0.g.c r1 = o(r2);
        if (r1 != null) goto L8;
        r1 = p(r2).l();
    L8:
        if (r1 == null) goto L10;
        return r1;
    L10:
        a(4);
        throw null;
    L12:
        a(3);
        throw null;
    }

    private static kotlin.s0.w.d.l0.g.c o(kotlin.s0.w.d.l0.c.m r2) {
        if (r2 != null) goto L5;
        a(5);
        throw null;
    L5:
        if ((r2 instanceof h0) == true) goto L19;
        if (kotlin.s0.w.d.l0.n.u1.k.m(r2) == true) goto L19;
        if ((r2 instanceof q0) == false) goto L14;
        return ((q0) r2).e();
    L14:
        if ((r2 instanceof l0) == true) goto L16;
        return null;
    L16:
        return ((l0) r2).e();
    L19:
        return kotlin.s0.w.d.l0.g.c.f20260c;
    }

    private static kotlin.s0.w.d.l0.g.d p(kotlin.s0.w.d.l0.c.m r2) {
        if (r2 == null) goto L9;
        kotlin.s0.w.d.l0.g.d r3 = m(r2.c()).c(r2.getName());
        if (r3 == null) goto L7;
        return r3;
    L7:
        a(7);
        throw null;
    L9:
        a(6);
        throw null;
    }

    public static <D extends kotlin.s0.w.d.l0.c.m> D q(kotlin.s0.w.d.l0.c.m r1, Class<D> r2) {
        if (r2 != null) goto L4;
        a(18);
        throw null;
    L4:
        return (D) r(r1, r2, true);
    }

    public static <D extends kotlin.s0.w.d.l0.c.m> D r(kotlin.s0.w.d.l0.c.m r1, Class<D> r2, boolean r3) {
        if (r2 == null) goto L13;
        if (r1 != null) goto L6;
        return null;
    L6:
        if (r3 == false) goto L8;
        r1 = (D) r1.c();
    L8:
        if (r1 == null) goto L12;
        if (r2.isInstance(r1) == true) goto L11;
        r1 = (D) r1.c();
        goto L8
    L11:
        return (D) r1;
    L12:
        return null;
    L13:
        a(19);
        throw null;
    }

    public static kotlin.s0.w.d.l0.c.e s(kotlin.s0.w.d.l0.c.e r4) {
        if (r4 == null) goto L11;
        Iterator<e0> r5 = r4.k().a().iterator();
    L6:
        if (r5.hasNext() == false) goto L10;
        kotlin.s0.w.d.l0.c.e r1 = e(r5.next());
        if (r1.i() == kotlin.s0.w.d.l0.c.f.f18866g) goto L6;
        return r1;
    L10:
        return null;
    L11:
        a(44);
        throw null;
    }

    public static boolean t(kotlin.s0.w.d.l0.c.m r1) {
        return D(r1, kotlin.s0.w.d.l0.c.f.f18869j);
    }

    public static boolean u(kotlin.s0.w.d.l0.c.m r1) {
        if (r1 != null) goto L4;
        a(34);
        throw null;
    L4:
        if (v(r1) == true) goto L6;
    L8:
        return false;
    L6:
        if (r1.getName().equals(kotlin.s0.w.d.l0.g.h.f20275b) == false) goto L8;
        return true;
    }

    public static boolean v(kotlin.s0.w.d.l0.c.m r1) {
        return D(r1, kotlin.s0.w.d.l0.c.f.f18865f);
    }

    public static boolean w(kotlin.s0.w.d.l0.c.m r1) {
        if (v(r1) == false) goto L5;
    L8:
        return true;
    L5:
        if (A(r1) == true) goto L8;
        return false;
    }

    public static boolean x(kotlin.s0.w.d.l0.c.m r1) {
        if (D(r1, kotlin.s0.w.d.l0.c.f.f18870k) == true) goto L5;
    L7:
        return false;
    L5:
        if (((kotlin.s0.w.d.l0.c.e) r1).x() == false) goto L7;
        return true;
    }

    public static boolean y(kotlin.s0.w.d.l0.c.m r1) {
        if ((r1 instanceof q) == true) goto L5;
    L7:
        return false;
    L5:
        if (((q) r1).getVisibility() != t.f19164f) goto L7;
        return true;
    }

    public static boolean z(kotlin.s0.w.d.l0.c.e r2, kotlin.s0.w.d.l0.c.e r3) {
        if (r2 == null) goto L16;
        if (r3 == null) goto L14;
        Iterator<e0> r4 = r2.k().a().iterator();
    L7:
        if (r4.hasNext() == false) goto L12;
        if (F(r4.next(), r3.a()) == false) goto L7;
        return true;
    L12:
        return false;
    L14:
        a(27);
        throw null;
    L16:
        a(26);
        throw null;
    }
}
