package com.obric.oui.window.permission;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsets;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.window.embedding.EmbeddingCompat;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.common.oui.g;
import com.obric.common.oui.i;
import com.obric.oui.actionbar.OBottomActionBar;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.f0;
import kotlin.n0.c.p;
import kotlin.n0.d.o;
import kotlin.n0.d.q;
import kotlin.u0.k;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0016\u0018\u00002\u00020\u0001:\u0002;<B\u0007¢\u0006\u0004\b:\u0010\bJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\bJ\u000f\u0010\n\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\n\u0010\bJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u000b\u0010\bJ\u000f\u0010\f\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\f\u0010\bJ\u000f\u0010\r\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\r\u0010\bJ\u000f\u0010\u000e\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u000e\u0010\bJ\u000f\u0010\u000f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\bJ\u000f\u0010\u0010\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0010\u0010\bJ\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0014\u0010\u0013J-\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0016\u001a\u00020\u00152\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00150\u00172\u0006\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ)\u0010!\u001a\u00020 2\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010\u001e\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u001f\u001a\u00020\u0015H\u0002¢\u0006\u0004\b!\u0010\"J/\u0010(\u001a\u00020\u001b2\u0006\u0010#\u001a\u00020\u00152\u0006\u0010$\u001a\u00020 2\u0006\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020%H\u0002¢\u0006\u0004\b(\u0010)J\u001f\u0010*\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020\u0015H\u0002¢\u0006\u0004\b*\u0010+J\u000f\u0010,\u001a\u00020\u0004H\u0002¢\u0006\u0004\b,\u0010\bR\u0016\u0010/\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00101\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u0010.R\u0018\u00105\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00107\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u0010.R\u0018\u00109\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00104¨\u0006="}, d2 = {"Lcom/obric/oui/window/permission/PrivacyStatementActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Landroid/os/Bundle;", "savedInstanceState", "Lkotlin/f0;", "onCreate", "(Landroid/os/Bundle;)V", "onContentChanged", "()V", "onBackPressed", "onStart", "onResume", "onPause", "onStop", "onDestroy", "I", "J", "", "D", "()Z", "H", "", "message", "", "urls", "Landroid/content/Context;", "context", "Landroid/text/SpannableString;", "L", "(Ljava/lang/String;[Ljava/lang/String;Landroid/content/Context;)Landroid/text/SpannableString;", WsConstants.KEY_CONNECTION_URL, "title", "Landroid/text/style/ClickableSpan;", "F", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Landroid/text/style/ClickableSpan;", "text", "span", "", "start", "end", "C", "(Ljava/lang/String;Landroid/text/style/ClickableSpan;II)Landroid/text/SpannableString;", "K", "(Ljava/lang/String;Ljava/lang/String;)V", "G", "f", "Z", "hasAgreed", "g", "showNetworkConfirm", "Landroid/view/View;", "j", "Landroid/view/View;", "contentChild", "h", "useLinkTextAsTitle", "i", "root", "<init>", "a", "b", "OUI_standardRelease"}, k = 1, mv = {1, 1, 15})
public class PrivacyStatementActivity extends AppCompatActivity {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final Map<String, b> f11625k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final Map<String, a> f11626l = null;
    private static final Map<String, com.obric.oui.window.permission.c> m = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f11627f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f11628g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f11629h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private View f11630i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private View f11631j;

    public interface a {
        void a(String r1, Context r2);
    }

    public interface b {
        void a();

        boolean b(Activity r1);

        boolean c(Activity r1);

        void onCancel();
    }

    public static final class c extends ClickableSpan {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ PrivacyStatementActivity f11632f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f11633g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f11634h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ Context f11635i;

        static final class a extends q implements p<DialogInterface, Integer, f0> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ c f11636f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ a f11637g;

            a(c r1, a r2) {
                this.f11636f = r1;
                this.f11637g = r2;
                super(2);
            }

            public final void a(DialogInterface r1, int r2) {
                o.f(r1, "dialog");
                r1.dismiss();
                boolean r3 = true;
                PrivacyStatementActivity.B(this.f11636f.f11632f, true);
                String r4 = this.f11636f.f11633g;
                if (r4 != null) goto L5;
            L8:
                if (r3 == true) goto L14;
                a r5 = this.f11637g;
                c r0 = this.f11636f;
                if (r5 == null) goto L12;
                r5.a(r0.f11633g, r0.f11632f);
                return;
            L12:
                PrivacyStatementActivity.A(r0.f11632f, r0.f11633g, r0.f11634h);
                return;
            L14:
                return;
            L5:
                if (r4.length() == 0) goto L8;
                r3 = false;
                goto L8
            }

            @Override // kotlin.n0.c.p
            public /* bridge */ /* synthetic */ f0 invoke(DialogInterface r1, Integer r2) {
                a(r1, r2.intValue());
                return f0.f18324a;
            }
        }

        static final class b extends q implements p<DialogInterface, Integer, f0> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public static final b f11638f = null;

            static {
                f11638f = new b();
            }

            b() {
                super(2);
            }

            public final void a(DialogInterface r1, int r2) {
                o.f(r1, "dialog");
                r1.dismiss();
            }

            @Override // kotlin.n0.c.p
            public /* bridge */ /* synthetic */ f0 invoke(DialogInterface r1, Integer r2) {
                a(r1, r2.intValue());
                return f0.f18324a;
            }
        }

        c(PrivacyStatementActivity r1, String r2, String r3, Context r4) {
            this.f11632f = r1;
            this.f11633g = r2;
            this.f11634h = r3;
            this.f11635i = r4;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View r6) {
            o.f(r6, "widget");
            a r7 = (a) PrivacyStatementActivity.x().get(this.f11632f.getIntent().getStringExtra("PrivacyStatementActivityInstanceId"));
            boolean r1 = true;
            if (PrivacyStatementActivity.z(this.f11632f) == true) goto L15;
            String r0 = this.f11633g;
            if (r0 != null) goto L7;
        L10:
            if (r1 == true) goto L28;
            if (r7 == null) goto L29;
            r7.a(this.f11633g, this.f11632f);
            return;
        L29:
            return;
        L28:
            return;
        L7:
            if (r0.length() == 0) goto L10;
            r1 = false;
            goto L10
        L15:
            if (PrivacyStatementActivity.w(this.f11632f) == false) goto L26;
            String r2 = this.f11633g;
            if (r2 != null) goto L19;
        L22:
            if (r1 == true) goto L30;
            if (r7 == null) goto L25;
            r7.a(this.f11633g, this.f11632f);
            return;
        L25:
            PrivacyStatementActivity.A(this.f11632f, this.f11633g, this.f11634h);
            return;
        L30:
            return;
        L19:
            if (r2.length() == 0) goto L22;
            r1 = false;
            goto L22
        L26:
            d.g.d.c.e.e r3 = new d.g.d.c.e.e(this.f11632f);
            r3.l(false);
            d.g.d.c.e.e.s(r3, this.f11632f.getString(i.f8273j), false, 2, null);
            r3.n(this.f11632f.getString(i.f8272i));
            String r4 = this.f11632f.getString(i.f8267d);
            o.e(r4, "getString(R.string.oui_agree)");
            r3.q(r4, new a(this, r7));
            String r5 = this.f11632f.getString(i.f8270g);
            o.e(r5, "getString(R.string.oui_cancel_only)");
            r3.o(r5, b.f11638f);
            r3.a().show();
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint r2) {
            o.f(r2, "ds");
            super.updateDrawState(r2);
            r2.setColor(ContextCompat.getColor(this.f11635i, com.obric.common.oui.c.F));
            r2.setUnderlineText(false);
        }
    }

    static final class d implements OnApplyWindowInsetsListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f11639a = null;

        static {
            f11639a = new d();
        }

        d() {
        }

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public final WindowInsetsCompat onApplyWindowInsets(View r4, WindowInsetsCompat r5) {
            o.e(r5, "insets");
            int r3 = r5.getSystemWindowInsetTop();
            int r0 = r5.getSystemWindowInsetBottom();
            o.e(r4, BaseSwitches.V);
            r4.setPadding(r4.getPaddingLeft(), r3, r4.getPaddingRight(), r0);
            return r5;
        }
    }

    static final class e implements View.OnApplyWindowInsetsListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f11640a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ImageView f11641b;

        e(int r1, ImageView r2) {
            this.f11640a = r1;
            this.f11641b = r2;
        }

        @Override // android.view.View.OnApplyWindowInsetsListener
        public final WindowInsets onApplyWindowInsets(View r6, WindowInsets r7) {
            o.f(r6, "view");
            o.f(r7, "insets");
            int r0 = r7.getSystemWindowInsetTop();
            int r1 = (int) ((((double) this.f11640a) * 0.235d) - ((double) r0));
            ImageView r2 = this.f11641b;
            o.e(r2, "iconImageView");
            ViewGroup.LayoutParams r3 = r2.getLayoutParams();
            Objects.requireNonNull(r3, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ViewGroup.MarginLayoutParams r4 = (ViewGroup.MarginLayoutParams) r3;
            r4.topMargin = r1;
            ImageView r5 = this.f11641b;
            o.e(r5, "iconImageView");
            r5.setLayoutParams(r4);
            return r6.onApplyWindowInsets(r7);
        }
    }

    static final class f implements OBottomActionBar.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ PrivacyStatementActivity f11642a;

        f(PrivacyStatementActivity r1) {
            this.f11642a = r1;
        }

        @Override // com.obric.oui.actionbar.OBottomActionBar.b
        public final void a(View r3, int r4) {
            o.f(r3, "<anonymous parameter 0>");
            b r5 = (b) PrivacyStatementActivity.y().get(this.f11642a.getIntent().getStringExtra("PrivacyStatementActivityInstanceId"));
            if (r4 != 1) goto L10;
            if (r5 != null) goto L6;
        L7:
            if (r5 == null) goto L9;
            r5.a();
        L9:
            this.f11642a.I();
            PrivacyStatementActivity.v(this.f11642a);
            return;
        L6:
            if (r5.b(this.f11642a) != true) goto L7;
            return;
        L10:
            if (r5 != null) goto L12;
        L13:
            if (r5 == null) goto L15;
            r5.onCancel();
        L15:
            this.f11642a.J();
            this.f11642a.finish();
            return;
        L12:
            if (r5.c(this.f11642a) != true) goto L13;
        }
    }

    static {
        f11625k = new LinkedHashMap();
        f11626l = new LinkedHashMap();
        m = new LinkedHashMap();
    }

    public PrivacyStatementActivity() {
        this.f11628g = true;
    }

    public static final /* synthetic */ void A(PrivacyStatementActivity r0, String r1, String r2) {
        r0.K(r1, r2);
    }

    public static final /* synthetic */ void B(PrivacyStatementActivity r0, boolean r1) {
        r0.f11627f = r1;
    }

    private final SpannableString C(String r1, ClickableSpan r2, int r3, int r4) {
        SpannableString r0 = new SpannableString(r1);
        r0.setSpan(r2, r3, r4, 33);
        return r0;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = EmbeddingCompat.DEBUG, value = "onStop")
    public static void E(PrivacyStatementActivity r2) {
        r2.u();
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L5;
        return;
    L5:
        if (Build.VERSION.SDK_INT < 21) goto L12;
        r2.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L8
        return;
    L13:
        return;
    }

    private final ClickableSpan F(Context r2, String r3, String r4) {
        return new c(this, r3, r4, r2);
    }

    private final void G() {
        super.finish();
        overridePendingTransition(com.obric.common.oui.a.f8190a, com.obric.common.oui.a.f8191b);
    }

    private final boolean H() {
        Window r1 = getWindow();
        o.e(r1, "window");
        View r2 = r1.getDecorView();
        o.e(r2, "window.decorView");
        return !r2.getFitsSystemWindows();
    }

    private final void K(String r1, String r2) {
        WebViewActivity.D(this, r1, r2);
    }

    private final SpannableString L(String r23, String[] r24, Context r25) {
        int r10 = k.Q(r23, "{", 0, false, 6, null);
        int r11 = k.Q(r23, "}", 0, false, 6, null);
        int r12 = k.V(r23, "{", 0, false, 6, null);
        int r13 = k.V(r23, "}", 0, false, 6, null);
        String r2 = "this as java.lang.String…ing(startIndex, endIndex)";
        if (this.f11629h == false) goto L8;
        if (r10 == (-1)) goto L8;
        if (r11 == (-1)) goto L8;
        if (r10 >= r11) goto L8;
        String r1 = r23.substring(r10 + 1, r11);
        o.e(r1, "this as java.lang.String…ing(startIndex, endIndex)");
    L10:
        if (this.f11629h == false) goto L15;
        if (r12 == (-1)) goto L15;
        if (r13 == (-1)) goto L15;
        if (r12 >= r13) goto L15;
        String r4 = r23.substring(r12 + 1, r13);
    L16:
        o.e(r4, r2);
        ClickableSpan r14 = F(r25, (String) kotlin.i0.i.B(r24, 0), r1);
        ClickableSpan r8 = F(r25, (String) kotlin.i0.i.B(r24, 1), r4);
        if (r10 == (-1)) goto L27;
        if (r11 == (-1)) goto L27;
        if (r12 == (-1)) goto L27;
        if (r13 == (-1)) goto L27;
        String r3 = k.w(k.w(r23, "{", "", false, 4, null), "}", "", false, 4, null);
        if (r10 != r12) goto L25;
        if (r11 != r13) goto L25;
        return C(r3, r14, r10, r11 - 1);
    L25:
        SpannableString r0 = new SpannableString(r3);
        r0.setSpan(r14, r10, r11 - 1, 33);
        r0.setSpan(r8, r12 - 2, r13 - 3, 33);
        return r0;
    L27:
        return new SpannableString(r23);
    L15:
        r4 = getString(i.p);
        r2 = "getString(R.string.title_user_agreement)";
    L8:
        r1 = getString(i.n);
        o.e(r1, "getString(R.string.title_privacy_policy)");
        goto L10
    }

    public static final /* synthetic */ void v(PrivacyStatementActivity r0) {
        r0.G();
    }

    public static final /* synthetic */ boolean w(PrivacyStatementActivity r0) {
        return r0.f11627f;
    }

    public static final /* synthetic */ Map x() {
        return f11626l;
    }

    public static final /* synthetic */ Map y() {
        return f11625k;
    }

    public static final /* synthetic */ boolean z(PrivacyStatementActivity r0) {
        return r0.f11628g;
    }

    public boolean D() {
        return true;
    }

    public void I() {
    }

    public void J() {
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        b r0 = f11625k.get(getIntent().getStringExtra("PrivacyStatementActivityInstanceId"));
        if (r0 != null) goto L5;
    L6:
        if (r0 == null) goto L8;
        r0.onCancel();
    L8:
        J();
        finish();
        return;
    L5:
        if (r0.c(this) != true) goto L6;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.Window.Callback
    public void onContentChanged() {
        super.onContentChanged();
        this.f11631j = ((ViewGroup) findViewById(R.id.content)).getChildAt(0);
        if (H() == false) goto L8;
        View r2 = this.f11631j;
        if (r2 == null) goto L9;
        ViewCompat.setOnApplyWindowInsetsListener(r2, d.f11639a);
        return;
    L9:
        return;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r21) {
        d.g.d.f.f.b.a("PrivacyStatementActivity", "onCreate");
        super.onCreate(r21);
        String r0 = getIntent().getStringExtra("PrivacyStatementActivityInstanceId");
        if (r0 == null) goto L8;
        com.obric.oui.window.permission.c r1 = m.get(r0);
        if (r1 == null) goto L8;
        r1.a(this);
    L8:
        if (D() == false) goto L15;
        if (r21 == null) goto L15;
        d.g.d.f.f.b.j("PrivacyStatementActivity", "onCreate, savedInstanceState is not null");
        if (f11625k.get(getIntent().getStringExtra("PrivacyStatementActivityInstanceId")) != null) goto L14;
        d.g.d.f.f.b.j("PrivacyStatementActivity", "privacyConsentCallbacks is null, finish");
        finish();
        overridePendingTransition(0, 0);
        return;
    L14:
        d.g.d.f.f.b.e("PrivacyStatementActivity", "privacyConsentCallbacks is not null");
    L15:
        setContentView(g.f8251a);
        Window r2 = getWindow();
        o.e(r2, "window");
        int r3 = com.obric.common.oui.c.D;
        r2.setStatusBarColor(getColor(r3));
        r2.setNavigationBarColor(getColor(r3));
        if (Build.VERSION.SDK_INT < 30) goto L18;
        d.g.d.f.a.a(this);
    L18:
        this.f11628g = getIntent().getBooleanExtra("showNetworkConfirm", true);
        this.f11629h = getIntent().getBooleanExtra("useLinkTextAsTitle", false);
        String r4 = getIntent().getStringExtra("title");
        if (r4 != null) goto L22;
        r4 = getString(i.f8266c);
    L22:
        o.e(r4, "intent.getStringExtra(\"t…g(R.string.default_title)");
        o.e(getString(i.f8265b), "getString(R.string.default_description)");
        String r5 = getIntent().getStringExtra("customizedCancelText");
        if (r5 != null) goto L26;
        r5 = getString(i.f8269f);
    L26:
        o.e(r5, "intent.getStringExtra(\"c…ring.oui_cancel_and_quit)");
        String r6 = getString(i.f8267d);
        o.e(r6, "getString(R.string.oui_agree)");
        String r7 = getIntent().getStringExtra("privacyText");
        if (r7 != null) goto L30;
        r7 = getString(i.f8274k);
    L30:
        String r10 = r7;
        o.e(r10, "intent.getStringExtra(\"p…ring.privacy_policy_text)");
        int r8 = getIntent().getIntExtra("iconResId", com.obric.common.oui.e.N);
        String[] r9 = getIntent().getStringArrayExtra("urls");
        if (r9 != null) goto L34;
        r9 = new String[0];
    L34:
        String[] r11 = r9;
        TextView r12 = (TextView) findViewById(com.obric.common.oui.f.S0);
        TextView r13 = (TextView) findViewById(com.obric.common.oui.f.H0);
        ImageView r14 = (ImageView) findViewById(com.obric.common.oui.f.T);
        Resources r15 = getResources();
        o.e(r15, "resources");
        int r16 = r15.getDisplayMetrics().heightPixels;
        View r17 = r2.getDecorView();
        o.e(r17, "window.decorView");
        View r18 = r17.getRootView();
        this.f11630i = r18;
        if (r18 == null) goto L37;
        r18.setOnApplyWindowInsetsListener(new e(r16, r14));
    L37:
        OBottomActionBar r19 = (OBottomActionBar) findViewById(com.obric.common.oui.f.y);
        r19.g(false, "l1", true, new String[]{r5, r6}, null);
        r19.setBottomButtonClickListener(new f(this));
        o.e(r12, "titleTextView");
        r12.setText(r4);
        Drawable r20 = ContextCompat.getDrawable(this, r8);     // Catch: Exception -> L40
        o.c(r20);     // Catch: Exception -> L40
        o.e(r20, "ContextCompat.getDrawable(this, iconResId)!!");     // Catch: Exception -> L40
        r14.setImageDrawable(d.g.d.e.a.f16933a.a(this, r20, -1.0f, -1.0f, 1.33f, ContextCompat.getColor(this, com.obric.common.oui.c.z)));     // Catch: Exception -> L40
    L42:
        o.e(r13, "privacyPolicyTextView");
        r13.setText(L(r10, r11, this));
        r13.setMovementMethod(LinkMovementMethod.getInstance());
        return;
    L40:
        e = move-exception;
        d.g.d.f.f.b.c("PrivacyStatementActivity", "createCircularDrawableWithBorder error", e);
        goto L42
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        d.g.d.f.f.b.a("PrivacyStatementActivity", "onDestroy");
        View r1 = this.f11630i;
        if (r1 != null) goto L19;
    L7:
        View r2 = this.f11631j;
        if (r2 != null) goto L21;
    L12:
        this.f11630i = null;
        this.f11631j = null;
        super.onDestroy();
        String r0 = getIntent().getStringExtra("PrivacyStatementActivityInstanceId");
        if (r0 == null) goto L23;
        f11625k.remove(r0);
        f11626l.remove(r0);
        Map<String, com.obric.oui.window.permission.c> r3 = m;
        com.obric.oui.window.permission.c r4 = r3.get(r0);
        if (r4 == null) goto L17;
        r4.b(this);
    L17:
        com.obric.oui.window.permission.c r5 = r3.remove(r0);
        return;
    L23:
        return;
    L21:
        ViewCompat.setOnApplyWindowInsetsListener(r2, null);     // Catch: Exception -> L11
    L11:
        d.g.d.f.f.b.b("PrivacyStatementActivity", "removing contentChild WindowInsets listener failed");
        goto L12
    L19:
        r1.setOnApplyWindowInsetsListener(null);     // Catch: Exception -> L6
    L6:
        d.g.d.f.f.b.b("PrivacyStatementActivity", "removing root WindowInsets listener failed");
        goto L7
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        String r0 = getIntent().getStringExtra("PrivacyStatementActivityInstanceId");
        if (r0 == null) goto L8;
        com.obric.oui.window.permission.c r1 = m.get(r0);
        if (r1 == null) goto L9;
        r1.c(this);
        return;
    L9:
        return;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        String r0 = getIntent().getStringExtra("PrivacyStatementActivityInstanceId");
        if (r0 == null) goto L8;
        com.obric.oui.window.permission.c r1 = m.get(r0);
        if (r1 == null) goto L9;
        r1.d(this);
        return;
    L9:
        return;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        super.onStart();
        String r0 = getIntent().getStringExtra("PrivacyStatementActivityInstanceId");
        if (r0 == null) goto L8;
        com.obric.oui.window.permission.c r1 = m.get(r0);
        if (r1 == null) goto L9;
        r1.e(this);
        return;
    L9:
        return;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        E(this);
    }

    public void u() {
        super.onStop();
        String r0 = getIntent().getStringExtra("PrivacyStatementActivityInstanceId");
        if (r0 == null) goto L8;
        com.obric.oui.window.permission.c r1 = m.get(r0);
        if (r1 == null) goto L9;
        r1.f(this);
        return;
    L9:
        return;
    }
}
