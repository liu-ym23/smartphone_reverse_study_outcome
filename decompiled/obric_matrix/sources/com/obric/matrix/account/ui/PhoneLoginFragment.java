package com.obric.matrix.account.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.ActivityKt;
import androidx.navigation.NavController;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.mpaas.app.AppInfoProvider;
import com.obric.matrix.account.databinding.AccountPhonePageBinding;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.f0;
import kotlin.n0.d.q;
import os.teatracker.IBdInstall;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000  2\u00020\u0001:\u0001 B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\b\u0010\u0010\u001a\u00020\fH\u0002J&\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u000fH\u0017J\u001a\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u00122\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0017J\b\u0010\u001c\u001a\u00020\u000fH\u0002J\u0010\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/obric/matrix/account/ui/PhoneLoginFragment;", "Landroidx/fragment/app/Fragment;", "()V", "accountDialog", "Lcom/obric/matrix/account/ui/AccountDialog;", "binding", "Lcom/obric/matrix/account/databinding/AccountPhonePageBinding;", "enableClick", "", "loginViewModel", "Lcom/obric/matrix/account/ui/LoginViewModel;", "phoneCodeNumber", "", "phoneNumber", "closeInputWindow", "", "getDefaultPhoneCode", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "onViewCreated", "view", "sendCode", "showButtonChange", "loginButton", "Landroid/widget/Button;", "Companion", "account_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PhoneLoginFragment extends Fragment {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private AccountPhonePageBinding f8768f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private LoginViewModel f8769g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f8770h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f8771i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private k f8772j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f8773k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Map<Integer, View> f8774l;

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroid/widget/Button;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class a extends q implements kotlin.n0.c.l<Button, f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ PhoneLoginFragment f8775f;

        a(PhoneLoginFragment r1) {
            this.f8775f = r1;
            super(1);
        }

        public final void a(Button r2) {
            kotlin.n0.d.o.f(r2, "it");
            if (PhoneLoginFragment.g(this.f8775f) == true) goto L5;
            return;
        L5:
            PhoneLoginFragment r3 = this.f8775f;
            AccountPhonePageBinding r0 = PhoneLoginFragment.d(r3);
            if (r0 == null) goto L10;
            EditText r1 = r0.f8467f;
            if (r1 == null) goto L10;
            Editable r4 = r1.getText();
        L11:
            PhoneLoginFragment.n(r3, String.valueOf(r4));
            k r5 = PhoneLoginFragment.c(this.f8775f);
            if (r5 == null) goto L14;
            r5.show();
        L14:
            PhoneLoginFragment.l(this.f8775f);
            return;
        L10:
            r4 = null;
            goto L11
        }

        @Override // kotlin.n0.c.l
        public /* bridge */ /* synthetic */ f0 invoke(Button r1) {
            a(r1);
            return f0.f18324a;
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u0016¨\u0006\n"}, d2 = {"com/obric/matrix/account/ui/PhoneLoginFragment$sendCode$2", "Lcom/bytedance/sdk/account/mobile/thread/call/SendCodeCallback;", "onError", "", "response", "Lcom/bytedance/sdk/account/api/call/MobileApiResponse;", "Lcom/bytedance/sdk/account/mobile/query/SendCodeQueryObj;", WsConstants.KEY_CONNECTION_ERROR, "", "onSuccess", "account_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class b extends d.b.s.a.b0.b.g.c {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ PhoneLoginFragment f8776c;

        b(PhoneLoginFragment r1) {
            this.f8776c = r1;
        }

        @Override // d.b.s.a.j
        public void p(d.b.s.a.q.j.e<d.b.s.a.b0.a.f> r3, int r4) {
            StringBuilder r5 = new StringBuilder();
            r5.append("sendCode error: logId = ");
            String r0 = null;
            if (r3 == null) goto L5;
            String r1 = r3.f14885a;
        L6:
            r5.append(r1);
            r5.append(", errorMsg = ");
            if (r3 == null) goto L9;
            String r2 = r3.f14893i;
        L10:
            r5.append(r2);
            com.obric.matrix.r.c.c.f("PhoneLoginFragment", r5.toString());
            k r6 = PhoneLoginFragment.c(this.f8776c);
            if (r6 == null) goto L13;
            r6.dismiss();
        L13:
            com.obric.matrix.common_ui.widget.toast.a r7 = com.obric.matrix.common_ui.widget.toast.a.f9014a;
            Context r8 = this.f8776c.getContext();
            if (r3 == null) goto L16;
            r0 = r3.f14893i;
        L16:
            if (r0 != null) goto L18;
            String r9 = this.f8776c.getString(com.obric.matrix.account.j.m);
        L19:
            kotlin.n0.d.o.e(r9, "if (response?.errorMsg =…Msg\n                    }");
            r7.a(r8, r9);
            return;
        L18:
            r9 = r3.f14893i;
            goto L19
        L9:
            r2 = null;
            goto L10
        L5:
            r1 = null;
            goto L6
        }

        @Override // d.b.s.a.j
        public void q(d.b.s.a.q.j.e<d.b.s.a.b0.a.f> r5) {
            k r6 = PhoneLoginFragment.c(this.f8776c);
            if (r6 == null) goto L6;
            r6.dismiss();
        L6:
            if (this.f8776c.getActivity() != null) goto L8;
            return;
        L8:
            long r0 = SystemClock.elapsedRealtime();
            String r2 = PhoneLoginFragment.j(this.f8776c);
            kotlin.n0.d.o.c(r2);
            String r3 = PhoneLoginFragment.k(this.f8776c);
            kotlin.n0.d.o.c(r3);
            p r7 = new p(r0, r2, r3);
            LoginViewModel r4 = PhoneLoginFragment.i(this.f8776c);
            if (r4 == null) goto L11;
            MutableLiveData<p> r8 = r4.a();
        L12:
            if (r8 == null) goto L16;
            r8.setValue(r7);
            return;
        L16:
            return;
        L11:
            r8 = null;
            goto L12
        }
    }

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J*\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0017J*\u0010\f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016¨\u0006\u000e"}, d2 = {"com/obric/matrix/account/ui/PhoneLoginFragment$showButtonChange$1", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "account_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class c implements TextWatcher {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ PhoneLoginFragment f8777f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ Button f8778g;

        c(PhoneLoginFragment r1, Button r2) {
            this.f8777f = r1;
            this.f8778g = r2;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable r1) {
        }

        @Override // android.text.TextWatcher
        @SuppressLint({"ResourceAsColor"})
        public void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence r2, int r3, int r4, int r5) {
            if (r2 == null) goto L21;
            boolean r6 = true;
            if (kotlin.n0.d.o.a(PhoneLoginFragment.j(this.f8777f), BDLocationException.ERROR_DEVICE_LOCATION_DISABLE) == false) goto L11;
            PhoneLoginFragment r7 = this.f8777f;
            int r8 = r2.length();
            Button r1 = this.f8778g;
            if (r8 == 11) goto L8;
            r1.setBackgroundResource(com.obric.matrix.account.f.f8472a);
            r6 = false;
        L9:
            PhoneLoginFragment.m(r7, r6);
            return;
        L8:
            r1.setBackgroundResource(com.obric.matrix.account.f.f8473b);
            goto L9
        L11:
            PhoneLoginFragment r9 = this.f8777f;
            if (r2.length() != 0) goto L14;
            boolean r10 = true;
        L15:
            Button r11 = this.f8778g;
            if (r10 == false) goto L18;
            r11.setBackgroundResource(com.obric.matrix.account.f.f8472a);
            r6 = false;
        L19:
            PhoneLoginFragment.m(r9, r6);
            return;
        L18:
            r11.setBackgroundResource(com.obric.matrix.account.f.f8473b);
            goto L19
        L14:
            r10 = false;
            goto L15
        }
    }

    static {
    }

    public PhoneLoginFragment() {
        this.f8774l = new LinkedHashMap();
    }

    public static final /* synthetic */ k c(PhoneLoginFragment r0) {
        return r0.f8772j;
    }

    public static final /* synthetic */ AccountPhonePageBinding d(PhoneLoginFragment r0) {
        return r0.f8768f;
    }

    public static final /* synthetic */ boolean g(PhoneLoginFragment r0) {
        return r0.f8773k;
    }

    public static final /* synthetic */ LoginViewModel i(PhoneLoginFragment r0) {
        return r0.f8769g;
    }

    public static final /* synthetic */ String j(PhoneLoginFragment r0) {
        return r0.f8771i;
    }

    public static final /* synthetic */ String k(PhoneLoginFragment r0) {
        return r0.f8770h;
    }

    public static final /* synthetic */ void l(PhoneLoginFragment r0) {
        r0.u();
    }

    public static final /* synthetic */ void m(PhoneLoginFragment r0, boolean r1) {
        r0.f8773k = r1;
    }

    public static final /* synthetic */ void n(PhoneLoginFragment r0, String r1) {
        r0.f8770h = r1;
    }

    private final void o() {
        View r0 = getView();
        if (r0 == null) goto L10;
        FragmentActivity r2 = getActivity();
        if (r2 == null) goto L11;
        Window r3 = r2.getWindow();
        if (r3 == null) goto L12;
        kotlin.n0.d.o.e(r3, "window");
        new WindowInsetsControllerCompat(r3, r0).hide(WindowInsetsCompat.Type.ime());
        return;
    L12:
        return;
    L11:
        return;
    }

    private final String p() {
        return BDLocationException.ERROR_DEVICE_LOCATION_DISABLE;
    }

    public static /* synthetic */ void q(PhoneLoginFragment r0, View r1) {
        t(r0, r1);
    }

    public static /* synthetic */ void r(PhoneLoginFragment r0, View r1) {
        s(r0, r1);
    }

    private static final void s(PhoneLoginFragment r0, View r1) {
        kotlin.n0.d.o.f(r0, "this$0");
        View r2 = r0.getView();
        if (r2 == null) goto L5;
        r2.clearFocus();
    L5:
        r0.o();
        FragmentActivity r3 = r0.getActivity();
        if ((r3 instanceof LoginActivity) == false) goto L8;
        LoginActivity r4 = (LoginActivity) r3;
    L9:
        if (r4 == null) goto L12;
        r4.w();
        return;
    L12:
        return;
    L8:
        r4 = null;
        goto L9
    }

    private static final void t(PhoneLoginFragment r0, View r1) {
        kotlin.n0.d.o.f(r0, "this$0");
        View r2 = r0.getView();
        if (r2 == null) goto L5;
        r2.clearFocus();
    L5:
        r0.o();
        FragmentActivity r3 = r0.getActivity();
        if (r3 == null) goto L11;
        NavController r4 = ActivityKt.findNavController(r3, com.obric.matrix.account.g.o);
        if (r4 == null) goto L12;
        r4.navigate(com.obric.matrix.account.g.f8474a);
        return;
    L12:
        return;
    }

    private final void u() {
        LoginViewModel r0 = this.f8769g;
        if (r0 == null) goto L19;
        MutableLiveData<p> r1 = r0.a();
        if (r1 == null) goto L19;
        p r2 = r1.getValue();
        if (r2 == null) goto L19;
        if (kotlin.n0.d.o.a(r2.a(), this.f8771i) == false) goto L19;
        if (kotlin.n0.d.o.a(r2.b(), this.f8770h) == false) goto L19;
        if ((r2.c() + 60000) < SystemClock.elapsedRealtime()) goto L19;
        k r3 = this.f8772j;
        if (r3 == null) goto L17;
        r3.dismiss();
    L17:
        getActivity();
        return;
    L19:
        LinkedHashMap r4 = new LinkedHashMap();
        r4.put("is6Digits", LocationInfoConst.ALLOW_USE_LOCATION);
        String r5 = ((AppInfoProvider) com.bytedance.news.common.service.manager.d.a(AppInfoProvider.class)).getAppName();
        kotlin.n0.d.o.e(r5, "getService(AppInfoProvider::class.java).appName");
        r4.put(IBdInstall.PARAM_APP_NAME, r5);
        com.bytedance.sdk.account.impl.d.d().e('+' + this.f8771i + this.f8770h, 24, r4, new b(this));
    }

    private final void v(Button r3) {
        AccountPhonePageBinding r0 = this.f8768f;
        if (r0 == null) goto L8;
        EditText r1 = r0.f8467f;
        if (r1 == null) goto L9;
        r1.addTextChangedListener(new c(this, r3));
        return;
    L9:
        return;
    }

    public void b() {
        this.f8774l.clear();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        kotlin.n0.d.o.f(r1, "inflater");
        AccountPhonePageBinding r4 = AccountPhonePageBinding.c(r1, r2, false);
        this.f8768f = r4;
        if (r4 == null) goto L7;
        Button r5 = r4.f8463b;
        if (r5 == null) goto L7;
        r5.setBackgroundResource(com.obric.matrix.account.f.f8472a);
    L7:
        Context r6 = getContext();
        if (r6 == null) goto L10;
        k r7 = new k(r6);
    L11:
        this.f8772j = r7;
        AccountPhonePageBinding r8 = this.f8768f;
        if (r8 == null) goto L16;
        ImageView r9 = r8.f8466e;
        if (r9 == null) goto L16;
        r9.setOnClickListener(new j(this));
    L16:
        AccountPhonePageBinding r10 = this.f8768f;
        if (r10 == null) goto L19;
        TextView r11 = r10.f8469h;
    L20:
        if (r11 == null) goto L23;
        r11.setText(getString(com.obric.matrix.account.j.f8533b));
    L23:
        AccountPhonePageBinding r12 = this.f8768f;
        if (r12 == null) goto L26;
        TextView r13 = r12.f8468g;
    L27:
        if (r13 == null) goto L30;
        r13.setText(getString(com.obric.matrix.account.j.f8532a));
    L30:
        AccountPhonePageBinding r14 = this.f8768f;
        if (r14 == null) goto L33;
        Button r15 = r14.f8463b;
    L34:
        if (r15 == null) goto L37;
        r15.setText(getString(com.obric.matrix.account.j.u));
    L37:
        AccountPhonePageBinding r16 = this.f8768f;
        if (r16 == null) goto L42;
        Button r17 = r16.f8463b;
        if (r17 == null) goto L42;
        v(r17);
    L42:
        AccountPhonePageBinding r18 = this.f8768f;
        if (r18 == null) goto L47;
        Button r19 = r18.f8463b;
        if (r19 == null) goto L47;
        com.obric.matrix.common_ui.utils.e.a(r19, new a(this));
    L47:
        AccountPhonePageBinding r20 = this.f8768f;
        if (r20 == null) goto L52;
        LinearLayout r21 = r20.f8464c;
        if (r21 == null) goto L52;
        r21.setOnClickListener(new i(this));
    L52:
        FragmentActivity r22 = getActivity();
        if (r22 == null) goto L55;
        LoginViewModel r23 = (LoginViewModel) new ViewModelProvider(r22).get(LoginViewModel.class);
    L56:
        this.f8769g = r23;
        AccountPhonePageBinding r0 = this.f8768f;
        if (r0 != null) goto L59;
        return null;
    L59:
        return r0.b();
    L55:
        r23 = null;
        goto L56
    L33:
        r15 = null;
        goto L34
    L26:
        r13 = null;
        goto L27
    L19:
        r11 = null;
        goto L20
    L10:
        r7 = null;
        goto L11
    }

    @Override // androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        b();
    }

    @Override // androidx.fragment.app.Fragment
    @SuppressLint({"SetTextI18n"})
    public void onResume() {
        super.onResume();
        Bundle r0 = getArguments();
        TextView r1 = null;
        if (r0 == null) goto L5;
        String r2 = r0.getString("countryCode");
    L6:
        Bundle r3 = getArguments();
        if (r3 == null) goto L9;
        String r4 = r3.getString("phoneCode");
    L10:
        if (r4 == null) goto L12;
        this.f8771i = r4;
    L12:
        if (r2 == null) goto L20;
        AccountPhonePageBinding r5 = this.f8768f;
        if (r5 == null) goto L16;
        r1 = r5.f8465d;
    L16:
        if (r1 == null) goto L21;
        r1.setText('+' + r4);
        return;
    L21:
        return;
    L20:
        return;
    L9:
        r4 = null;
        goto L10
    L5:
        r2 = null;
        goto L6
    }

    @Override // androidx.fragment.app.Fragment
    @SuppressLint({"SetTextI18n"})
    public void onViewCreated(View r2, Bundle r3) {
        kotlin.n0.d.o.f(r2, "view");
        super.onViewCreated(r2, r3);
        AccountPhonePageBinding r4 = this.f8768f;
        if (r4 == null) goto L7;
        EditText r5 = r4.f8467f;
        if (r5 == null) goto L7;
        r5.requestFocus();
    L7:
        this.f8771i = p();
        AccountPhonePageBinding r6 = this.f8768f;
        if (r6 == null) goto L10;
        TextView r7 = r6.f8465d;
    L11:
        if (r7 == null) goto L15;
        r7.setText('+' + this.f8771i);
        return;
    L15:
        return;
    L10:
        r7 = null;
        goto L11
    }
}
