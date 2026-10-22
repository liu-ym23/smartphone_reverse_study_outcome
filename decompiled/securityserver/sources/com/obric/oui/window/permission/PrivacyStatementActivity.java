package com.obric.oui.window.permission;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import com.bytedance.securityserver.R;
import com.obric.oui.actionbar.OBottomActionBar;
import com.obric.oui.icon.IconUtils;
import com.obric.oui.utils.ActivityUtils;
import com.obric.oui.utils.log.L;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public class PrivacyStatementActivity extends AppCompatActivity {
    public static final LinkedHashMap j = null;
    public static final LinkedHashMap k = null;
    public static final LinkedHashMap l = null;
    public boolean b;
    public boolean c;
    public boolean e;
    public View f;
    public View i;

    @Metadata
    public static final class Companion {

        @Metadata
        public static abstract class ActivityCustomizer {
        }

        @Metadata
        public static final class Builder {
        }
    }

    @Metadata
    public interface LinkClickListener {
        void a();
    }

    @Metadata
    public interface PrivacyConsentCallback {

        @Metadata
        public static final class DefaultImpls {
        }

        void a();

        /* JADX INFO: renamed from: a, reason: collision with other method in class */
        boolean m41a();

        void onCancel();

        /* JADX INFO: renamed from: onCancel, reason: collision with other method in class */
        boolean m42onCancel();
    }

    static {
        j = new LinkedHashMap();
        k = new LinkedHashMap();
        l = new LinkedHashMap();
    }

    public PrivacyStatementActivity() {
        this.c = true;
    }

    public static final void a(PrivacyStatementActivity r2) {
        super.finish();
        r2.overridePendingTransition(R.anim.oui_transition_settings_out_a, R.anim.oui_transition_settings_out_b);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public final void onBackPressed() {
        PrivacyConsentCallback r0 = (PrivacyConsentCallback) j.get(getIntent().getStringExtra("PrivacyStatementActivityInstanceId"));
        if (r0 != null) goto L5;
    L6:
        if (r0 == null) goto L8;
        r0.onCancel();
    L8:
        finish();
        return;
    L5:
        if (r0.m42onCancel() != true) goto L6;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.Window.Callback
    public final void onContentChanged() {
        super.onContentChanged();
        this.i = ((ViewGroup) findViewById(android.R.id.content)).getChildAt(0);
        Window r0 = getWindow();
        Intrinsics.e(r0, "window");
        View r1 = r0.getDecorView();
        Intrinsics.e(r1, "window.decorView");
        if ((!r1.getFitsSystemWindows()) == false) goto L8;
        View r2 = this.i;
        if (r2 == null) goto L9;
        ViewCompat.setOnApplyWindowInsetsListener(r2, PrivacyStatementActivity$onContentChanged$1$1.f324a);
        return;
    L9:
        return;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle r21) {
        L.a("PrivacyStatementActivity", "onCreate");
        super.onCreate(r21);
        String r0 = getIntent().getStringExtra("PrivacyStatementActivityInstanceId");
        if (r0 == null) goto L6;
        Companion.ActivityCustomizer r1 = (Companion.ActivityCustomizer) l.get(r0);
    L6:
        if (r21 == null) goto L12;
        L.g("PrivacyStatementActivity", "onCreate, savedInstanceState is not null");
        if (((PrivacyConsentCallback) j.get(getIntent().getStringExtra("PrivacyStatementActivityInstanceId"))) != null) goto L11;
        L.g("PrivacyStatementActivity", "privacyConsentCallbacks is null, finish");
        finish();
        overridePendingTransition(0, 0);
        return;
    L11:
        L.d("PrivacyStatementActivity", "privacyConsentCallbacks is not null");
    L12:
        setContentView(R.layout.activity_privacy_statement);
        Window r2 = getWindow();
        Intrinsics.e(r2, "window");
        r2.setStatusBarColor(getColor(R.color.oui_bg_base_1));
        r2.setNavigationBarColor(getColor(R.color.oui_bg_base_1));
        ActivityUtils.a(this);
        this.c = getIntent().getBooleanExtra("showNetworkConfirm", true);
        this.e = getIntent().getBooleanExtra("useLinkTextAsTitle", false);
        String r3 = getIntent().getStringExtra("title");
        if (r3 != null) goto L16;
        r3 = getString(R.string.default_title);
    L16:
        Intrinsics.e(r3, "intent.getStringExtra(\"t…g(R.string.default_title)");
        Intrinsics.e(getString(R.string.default_description), "getString(R.string.default_description)");
        String r5 = getIntent().getStringExtra("customizedCancelText");
        if (r5 != null) goto L20;
        r5 = getString(R.string.oui_cancel_and_quit);
    L20:
        Intrinsics.e(r5, "intent.getStringExtra(\"c…ring.oui_cancel_and_quit)");
        String r7 = getString(R.string.oui_agree);
        Intrinsics.e(r7, "getString(R.string.oui_agree)");
        String r8 = getIntent().getStringExtra("privacyText");
        if (r8 != null) goto L24;
        r8 = getString(R.string.privacy_policy_text);
    L24:
        Intrinsics.e(r8, "intent.getStringExtra(\"p…ring.privacy_policy_text)");
        int r9 = getIntent().getIntExtra("iconResId", R.drawable.white_circle);
        String[] r10 = getIntent().getStringArrayExtra("urls");
        if (r10 != null) goto L28;
        r10 = new String[0];
    L28:
        TextView r11 = (TextView) findViewById(R.id.title);
        TextView r12 = (TextView) findViewById(R.id.privacy_policy_text);
        final ImageView r13 = (ImageView) findViewById(R.id.icon);
        Resources r14 = getResources();
        Intrinsics.e(r14, "resources");
        final int r15 = r14.getDisplayMetrics().heightPixels;
        View r4 = r2.getDecorView();
        Intrinsics.e(r4, "window.decorView");
        View r6 = r4.getRootView();
        this.f = r6;
        if (r6 == null) goto L31;
        r6.setOnApplyWindowInsetsListener(new PrivacyStatementActivity$onCreate$$inlined$let$lambda$1(r13, r15));
    L31:
        OBottomActionBar r16 = (OBottomActionBar) findViewById(R.id.bottom_action_bar);
        String[] r17 = {r5, r7};
        r16.getClass();
        View r18 = r16.c;
        if (r18 == null) goto L34;
        r16.e.removeView(r18);
        r16.c = null;
    L34:
        r16.a(new OBottomActionBar.OBABConfig(false, true, "l1", ArraysKt.v(r17), null));
        r16.setBottomButtonClickListener(new AnonymousClass3(this));
        Intrinsics.e(r11, "titleTextView");
        r11.setText(r3);
        Drawable r19 = ContextCompat.getDrawable(this, r9);     // Catch: Exception -> L37
        Intrinsics.c(r19);     // Catch: Exception -> L37
        r13.setImageDrawable(IconUtils.a(this, ContextCompat.getColor(this, R.color.oui_basic_line_1), r19));     // Catch: Exception -> L37
    L39:
        Intrinsics.e(r12, "privacyPolicyTextView");
        int r20 = StringsKt.s(r8, "{", 0, false, 6);
        int r22 = StringsKt.s(r8, "}", 0, false, 6);
        int r23 = StringsKt.u(6, r8, "{");
        int r24 = StringsKt.u(6, r8, "}");
        if (this.e == false) goto L45;
        if (r20 == (-1)) goto L45;
        if (r22 == (-1)) goto L45;
        if (r20 >= r22) goto L45;
        String r110 = r8.substring(r20 + 1, r22);
        Intrinsics.e(r110, "this as java.lang.String…ing(startIndex, endIndex)");
    L47:
        if (this.e == false) goto L52;
        if (r23 == (-1)) goto L52;
        if (r24 == (-1)) goto L52;
        if (r23 >= r24) goto L52;
        String r111 = r8.substring(r23 + 1, r24);
        Intrinsics.e(r111, "this as java.lang.String…ing(startIndex, endIndex)");
    L53:
        PrivacyStatementActivity$createClickableSpan$1 r112 = new PrivacyStatementActivity$createClickableSpan$1(this, (String) ArraysKt.n(r10, 0), r110, this);
        PrivacyStatementActivity$createClickableSpan$1 r113 = new PrivacyStatementActivity$createClickableSpan$1(this, (String) ArraysKt.n(r10, 1), r111, this);
        if (r20 == (-1)) goto L63;
        if (r22 == (-1)) goto L63;
        if (r23 == (-1)) goto L63;
        if (r24 == (-1)) goto L63;
        String r25 = StringsKt.B(StringsKt.B(r8, "{", ""), "}", "");
        if (r20 != r23) goto L62;
        if (r22 != r24) goto L62;
        SpannableString r26 = new SpannableString(r25);
        r26.setSpan(r112, r20, r22 - 1, 33);
    L64:
        r12.setText(r26);
        r12.setMovementMethod(LinkMovementMethod.getInstance());
        return;
    L62:
        SpannableString r27 = new SpannableString(r25);
        r27.setSpan(r112, r20, r22 - 1, 33);
        r27.setSpan(r113, r23 - 2, r24 - 3, 33);
        r26 = r27;
    L63:
        r26 = new SpannableString(r8);
    L52:
        r111 = getString(R.string.title_user_agreement);
        Intrinsics.e(r111, "getString(R.string.title_user_agreement)");
    L45:
        r110 = getString(R.string.title_privacy_policy);
        Intrinsics.e(r110, "getString(R.string.title_privacy_policy)");
    L37:
        e = move-exception;
        L.c("PrivacyStatementActivity", "createCircularDrawableWithBorder error", e);
        goto L39
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        L.a("PrivacyStatementActivity", "onDestroy");
        View r1 = this.f;
        if (r1 != null) goto L16;
    L7:
        View r2 = this.i;
        if (r2 != null) goto L18;
    L12:
        this.f = null;
        this.i = null;
        super.onDestroy();
        String r3 = getIntent().getStringExtra("PrivacyStatementActivityInstanceId");
        if (r3 == null) goto L20;
        j.remove(r3);
        k.remove(r3);
        LinkedHashMap r0 = l;
        Companion.ActivityCustomizer r4 = (Companion.ActivityCustomizer) r0.get(r3);
        Companion.ActivityCustomizer r5 = (Companion.ActivityCustomizer) r0.remove(r3);
        return;
    L20:
        return;
    L18:
        ViewCompat.setOnApplyWindowInsetsListener(r2, null);     // Catch: Exception -> L11
    L11:
        L.b("PrivacyStatementActivity", "removing contentChild WindowInsets listener failed");
        goto L12
    L16:
        r1.setOnApplyWindowInsetsListener(null);     // Catch: Exception -> L6
    L6:
        L.b("PrivacyStatementActivity", "removing root WindowInsets listener failed");
        goto L7
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onPause() {
        super.onPause();
        String r1 = getIntent().getStringExtra("PrivacyStatementActivityInstanceId");
        if (r1 == null) goto L6;
        Companion.ActivityCustomizer r2 = (Companion.ActivityCustomizer) l.get(r1);
        return;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onResume() {
        super.onResume();
        String r1 = getIntent().getStringExtra("PrivacyStatementActivityInstanceId");
        if (r1 == null) goto L6;
        Companion.ActivityCustomizer r2 = (Companion.ActivityCustomizer) l.get(r1);
        return;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onStart() {
        super.onStart();
        String r1 = getIntent().getStringExtra("PrivacyStatementActivityInstanceId");
        if (r1 == null) goto L6;
        Companion.ActivityCustomizer r2 = (Companion.ActivityCustomizer) l.get(r1);
        return;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onStop() {
        super.onStop();
        String r1 = getIntent().getStringExtra("PrivacyStatementActivityInstanceId");
        if (r1 == null) goto L6;
        Companion.ActivityCustomizer r2 = (Companion.ActivityCustomizer) l.get(r1);
        return;
    }
}
