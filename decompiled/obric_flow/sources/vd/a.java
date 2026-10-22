package vd;

import android.net.Uri;
import androidx.room.jarjarred.org.stringtemplate.v4.STGroup;
import com.bytedance.ies.bullet.service.sdk.param.LaunchMode;
import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends um.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f22569c;

    public /* synthetic */ a(Object r5, int r10) {
        this.f22569c = r10;
        super(r5, 10);
    }

    @Override // um.a
    public Object g(Object r10) {
        switch(this.f22569c) {
            case 0: goto L39;
            case 1: goto L32;
            case 2: goto L25;
            case 3: goto L5;
            case 4: goto L18;
            case 5: goto L6;
            default: goto L5;
        };
    L6:
        Intrinsics.checkNotNullParameter(r10, "value");
        Integer r5 = null;
        if ((r10 instanceof Integer) == false) goto L9;
        Integer r11 = (Integer) r10;
    L10:
        IntRange r12 = new IntRange(0, 100);
        if (r11 != null) goto L13;
    L15:
        if (r5 == null) goto L17;
        return r5;
    L17:
        return (Integer) super.g(r10);
    L13:
        if (r12.contains(r11.intValue()) == false) goto L15;
        r5 = r11;
        goto L15
    L9:
        r11 = null;
        goto L10
    L18:
        Intrinsics.checkNotNullParameter(r10, "value");
        if ((r10 instanceof Long) == false) goto L21;
        Long r13 = (Long) r10;
    L22:
        if (r13 == null) goto L24;
        return r13;
    L24:
        return (Long) super.g(r10);
    L21:
        r13 = null;
        goto L22
    L25:
        Intrinsics.checkNotNullParameter(r10, "value");
        if ((r10 instanceof Integer) == false) goto L28;
        Integer r14 = (Integer) r10;
    L29:
        if (r14 == null) goto L31;
        return r14;
    L31:
        return (Integer) super.g(r10);
    L28:
        r14 = null;
        goto L29
    L32:
        Intrinsics.checkNotNullParameter(r10, "value");
        if ((r10 instanceof Double) == false) goto L35;
        Double r15 = (Double) r10;
    L36:
        if (r15 == null) goto L38;
        return r15;
    L38:
        return (Double) super.g(r10);
    L35:
        r15 = null;
        goto L36
    L39:
        Intrinsics.checkNotNullParameter(r10, "value");
        if ((r10 instanceof Boolean) == false) goto L42;
        Boolean r16 = (Boolean) r10;
    L43:
        if (r16 == null) goto L45;
        return r16;
    L45:
        return (Boolean) super.g(r10);
    L42:
        r16 = null;
        goto L43
    L5:
        return super.g(r10);
    }

    @Override // um.a
    public final Object h(String r10) {
        int r5 = 0;
        switch(this.f22569c) {
            case 0: goto L42;
            case 1: goto L39;
            case 2: goto L36;
            case 3: goto L29;
            case 4: goto L26;
            case 5: goto L19;
            case 6: goto L12;
            case 7: goto L10;
            default: goto L4;
        };
    L4:
        Intrinsics.checkNotNullParameter(r10, "string");
        Uri r11 = Uri.parse(r10);
        if (r11.isAbsolute() == true) goto L7;
        return null;
    L7:
        if (r11.isHierarchical() == true) goto L9;
        return null;
    L9:
        return r11;
    L10:
        Intrinsics.checkNotNullParameter(r10, "string");
        return r10;
    L12:
        Intrinsics.checkNotNullParameter(r10, "string");
        ArrayList r12 = new ArrayList();
        Iterator r13 = StringsKt.J(r10, new char[]{','}, 0, 6).iterator();
    L14:
        if (r13.hasNext() == false) goto L18;
        String r14 = (String) r13.next();
        if (r14.length() <= 0) goto L14;
        r12.add(r14);
        goto L14
    L18:
        return r12;
    L19:
        Intrinsics.checkNotNullParameter(r10, "string");
        int r15 = Integer.parseInt(r10);     // Catch: Exception -> L66
        if (r15 >= 0) goto L23;
        return null;
    L23:
        if (r15 >= 101) goto L88;
        return Integer.valueOf(r15);
    L88:
        return null;
    L89:
        return null;
    L26:
        Intrinsics.checkNotNullParameter(r10, "string");
        return Long.valueOf(Long.parseLong(r10));
    L90:
        return null;
    L29:
        Intrinsics.checkNotNullParameter(r10, "string");
        LaunchMode[] r16 = LaunchMode.values();
        int r17 = r16.length;
    L30:
        if (r5 >= r17) goto L91;
        LaunchMode r18 = r16[r5];
        if (Intrinsics.areEqual(r10, r18.f6149a) == true) goto L35;
        r5 = r5 + 1;
        goto L30
    L35:
        return r18;
    L91:
        return null;
    L36:
        Intrinsics.checkNotNullParameter(r10, "string");
        return Integer.valueOf(Integer.parseInt(r10));
    L92:
        return null;
    L39:
        Intrinsics.checkNotNullParameter(r10, "string");
        return Double.valueOf(Double.parseDouble(r10));
    L93:
        return null;
    L42:
        Intrinsics.checkNotNullParameter(r10, "string");
        int r19 = r10.hashCode();
        if (r19 == 48) goto L62;
        if (r19 == 49) goto L58;
        if (r19 == 3569038) goto L55;
        if (r19 == 97196323) goto L52;
        return null;
    L52:
        if (r10.equals("false") == true) goto L65;
        return null;
    L65:
        return Boolean.FALSE;
    L55:
        if (r10.equals("true") == true) goto L94;
        return null;
    L94:
        return Boolean.TRUE;
    L58:
        if (r10.equals(IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST) == true) goto L94;
        return null;
    L62:
        if (r10.equals("0") == true) goto L65;
        return null;
    }

    @Override // um.a
    public final String i() {
        switch(this.f22569c) {
            case 0: goto L44;
            case 1: goto L39;
            case 2: goto L34;
            case 3: goto L29;
            case 4: goto L24;
            case 5: goto L19;
            case 6: goto L11;
            case 7: goto L10;
            default: goto L4;
        };
    L4:
        Uri r5 = (Uri) this.f22372b;
        if (r5 != null) goto L53;
        return null;
    L53:
        return r5.toString();
    L11:
        StringBuilder r10 = new StringBuilder();
        List r11 = (List) this.f22372b;
        if (r11 == null) goto L18;
        Iterator r12 = r11.iterator();
    L15:
        if (r12.hasNext() == false) goto L18;
        r10.append((String) r12.next());
        r10.append(',');
    L18:
        return r10.toString();
    L19:
        Integer r13 = (Integer) this.f22372b;
        if (r13 != null) goto L54;
        return null;
    L54:
        return r13.toString();
    L24:
        Long r14 = (Long) this.f22372b;
        if (r14 != null) goto L55;
        return null;
    L55:
        return r14.toString();
    L29:
        LaunchMode r15 = (LaunchMode) this.f22372b;
        if (r15 != null) goto L56;
        return null;
    L56:
        return r15.f6149a;
    L34:
        Integer r16 = (Integer) this.f22372b;
        if (r16 != null) goto L57;
        return null;
    L57:
        return r16.toString();
    L39:
        Double r17 = (Double) this.f22372b;
        if (r17 != null) goto L58;
        return null;
    L58:
        return r17.toString();
    L44:
        Boolean r18 = (Boolean) this.f22372b;
        if (r18 != null) goto L47;
        return null;
    L47:
        if (r18.booleanValue() == false) goto L49;
        return IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST;
    L49:
        return "0";
    L10:
        return (String) this.f22372b;
    }

    public a(rd.b r5, LaunchMode r10) {
        this.f22569c = 3;
        Intrinsics.checkNotNullParameter(r5, "data");
        Intrinsics.checkNotNullParameter("bdx_launch_mode", STGroup.DICT_KEY);
        super(null, 10);
        j(r5, "bdx_launch_mode", r10);
    }

    public a(rd.b r5, String r10, int r11) {
        this.f22569c = r11;
        switch(r11) {
            case 5: goto L8;
            case 8: goto L6;
            default: goto L4;
        };
    L4:
        Intrinsics.checkNotNullParameter(r5, "data");
        Intrinsics.checkNotNullParameter(r10, STGroup.DICT_KEY);
        super(null, 10);
        j(r5, r10, null);
        return;
    L6:
        Intrinsics.checkNotNullParameter(r5, "data");
        Intrinsics.checkNotNullParameter(r10, STGroup.DICT_KEY);
        super(null, 10);
        j(r5, r10, null);
        return;
    L8:
        Intrinsics.checkNotNullParameter(r5, "data");
        Intrinsics.checkNotNullParameter(r10, STGroup.DICT_KEY);
        super(null, 10);
        j(r5, r10, null);
    }

    public a(rd.b r5, String r10, Boolean r11) {
        this.f22569c = 0;
        Intrinsics.checkNotNullParameter(r5, "data");
        Intrinsics.checkNotNullParameter(r10, STGroup.DICT_KEY);
        super(null, 10);
        j(r5, r10, r11);
    }

    public a(rd.b r5, String r10, String r11) {
        this.f22569c = 7;
        Intrinsics.checkNotNullParameter(r5, "data");
        Intrinsics.checkNotNullParameter(r10, STGroup.DICT_KEY);
        super(null, 10);
        j(r5, r10, r11);
    }

    public a(rd.b r5, String r10, List r11) {
        this.f22569c = 6;
        Intrinsics.checkNotNullParameter(r5, "data");
        Intrinsics.checkNotNullParameter(r10, STGroup.DICT_KEY);
        super(null, 10);
        j(r5, r10, r11);
    }
}
