package rh;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.pia.core.api.bridge.PiaMethod$Scope;
import com.bytedance.pia.core.setting.Settings;
import com.lynx.tasm.p;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f21747a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f21748b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public nh.d f21749c;
    public com.bytedance.pia.core.utils.f d;
    public fh.a e;
    public boolean f;
    public boolean g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f21750h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Map f21751i;

    public f() {
        this.f21747a = "";
        this.f21748b = "";
        this.f21749c = null;
        this.d = null;
        this.e = null;
        this.f = false;
        this.g = true;
        this.f21750h = "";
        this.f21751i = null;
    }

    public final g a() {
        Lazy r5 = Settings.B;
        if (p.a().x() == true) goto L6;
        return null;
    L6:
        if (TextUtils.isEmpty(this.f21748b) == false) goto L9;
        return null;
    L9:
        if (TextUtils.isEmpty(this.f21747a) == true) goto L12;
        Uri r10 = Uri.parse(this.f21747a);
    L11:
        Uri r11 = r10;
        if (this.f21748b.startsWith("javascript:") == true) goto L61;
        String r12 = this.f21748b;
        if (r12 == null) goto L18;
        Uri r13 = Uri.parse(r12);
    L19:
        if (r13 == null) goto L40;
        List<String> r14 = r13.getPathSegments();
        if (r14.isEmpty() == false) goto L25;
        r14 = null;
    L25:
        if (r14 == null) goto L40;
        String r15 = r13.getScheme();
        if (r15 != null) goto L34;
        if (r11 == null) goto L31;
        r15 = r11.getScheme();
    L32:
        if (r15 != null) goto L34;
    L31:
        r15 = null;
    L34:
        String r16 = r13.getEncodedAuthority();
        if (r16 != null) goto L42;
        if (r11 == null) goto L38;
        r16 = r11.getEncodedAuthority();
    L39:
        if (r16 != null) goto L42;
    L38:
        r16 = null;
    L42:
        if (Intrinsics.areEqual(CollectionsKt.first(r14), ".") == false) goto L57;
        if (r11 == null) goto L45;
        List<String> r17 = r11.getPathSegments();
    L46:
        if (r17 != null) goto L48;
        r17 = CollectionsKt.emptyList();
    L48:
        if (r11 == null) goto L50;
        String r18 = r11.getPath();
    L51:
        if (r18 != null) goto L54;
        r18 = "";
    L54:
        if (StringsKt.j(r18, '/') == true) goto L56;
        r17 = CollectionsKt.dropLast(r17, 1);
    L56:
        r14 = CollectionsKt.plus(r17, CollectionsKt.i(r14, 1));
        goto L57
    L50:
        r18 = null;
        goto L51
    L45:
        r17 = null;
    L57:
        String r19 = CollectionsKt.q(r14, "/", null, null, 0, null, null, 62);
        Uri.Builder r20 = new Uri.Builder();
        r20.scheme(r15);
        r20.encodedAuthority(r16);
        r20.encodedQuery(r13.getEncodedQuery());
        r20.path(r19);
        Uri r21 = r20.build();
    L58:
        if (r21 == null) goto L60;
        this.f21748b = r21.toString();
        goto L61
    L60:
        return null;
    L40:
        r21 = null;
        goto L58
    L18:
        r13 = null;
    L61:
        nh.d r22 = this.f21749c;
        if (r22 != null) goto L64;
        return null;
    L64:
        com.bytedance.pia.core.utils.f r23 = this.d;
        if (r23 != null) goto L67;
        r23 = r22.f20240k;
    L67:
        com.bytedance.pia.core.utils.f r24 = r23;
        gh.c r25 = new gh.c(PiaMethod$Scope.f6952a, r22, r22.f20238i);
        nh.d r26 = this.f21749c;
        return new g(r26, this.f21750h, this.f21748b, r11, r24, r25, r26.f20241l, this.e, this.f, this.g, this.f21751i);
    L70:
        return null;
    L12:
        r10 = this.f21749c.g;
        goto L11
    }
}
