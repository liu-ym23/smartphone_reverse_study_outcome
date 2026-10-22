package com.obric.matrix.account.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.navigation.ActivityKt;
import androidx.navigation.NavController;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.obric.matrix.account.databinding.AccountCountryPickerPageBinding;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u000eH\u0002J&\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J \u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\fH\u0016J\u0010\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\fH\u0002J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001fH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/obric/matrix/account/ui/AccountCountryPickerFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/obric/matrix/account/ui/OnItemClickListener;", "()V", "binding", "Lcom/obric/matrix/account/databinding/AccountCountryPickerPageBinding;", "data", "Ljava/util/ArrayList;", "Lcom/obric/matrix/account/ui/Country;", "Lkotlin/collections/ArrayList;", "headerTextItems", "", "", "getData", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onItemClick", "", "countryNameCode", "countryCode", "countryName", "scrollToPosition", "index", "sortByChineseNamePinyin", "Lorg/json/JSONArray;", "jsonArray", "account_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AccountCountryPickerFragment extends Fragment implements o {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private List<String> f8738f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private AccountCountryPickerPageBinding f8739g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final ArrayList<l> f8740h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Map<Integer, View> f8741i;

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/obric/matrix/account/ui/AccountCountryPickerFragment$onCreateView$2", "Lcom/obric/matrix/account/ui/SideIndexBar$OnIndexTouchedChangedListener;", "onIndexChanged", "", "index", "", "position", "", "account_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a implements SideIndexBar.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AccountCountryPickerFragment f8742a;

        a(AccountCountryPickerFragment r1) {
            this.f8742a = r1;
        }

        @Override // com.obric.matrix.account.ui.SideIndexBar.a
        public void a(String r1, int r2) {
            kotlin.n0.d.o.f(r1, "index");
            AccountCountryPickerFragment.c(this.f8742a, r1);
        }
    }

    public AccountCountryPickerFragment() {
        this.f8741i = new LinkedHashMap();
        this.f8738f = new ArrayList();
        this.f8740h = new ArrayList();
    }

    public static final /* synthetic */ void c(AccountCountryPickerFragment r0, String r1) {
        r0.k(r1);
    }

    private final List<l> d() {
        m r0 = m.f8801a;
        Locale r1 = Locale.getDefault();
        kotlin.n0.d.o.e(r1, "getDefault()");
        JSONArray r2 = l(r0.a(r1, d.g.f.a.a.f16974a.c()));
        int r3 = r2.length();
        char r4 = ' ';
        int r5 = 0;
    L3:
        if (r5 >= r3) goto L14;
        JSONObject r6 = r2.getJSONObject(r5);
        String r7 = r6.getString("country_name");
        String r8 = r6.getString("country_code");
        String r9 = r6.getString("phone_code");
        String r10 = d.d.a.a.c.g(r7, "");
        kotlin.n0.d.o.e(r10, "pinyin");
        if (r10.length() <= 0) goto L7;
        boolean r11 = true;
    L8:
        if (r11 == false) goto L12;
        if (com.obric.matrix.account.r.b.a(r10.charAt(0)) == r4) goto L12;
        r4 = com.obric.matrix.account.r.b.a(r10.charAt(0));
        this.f8740h.add(new l(String.valueOf(r4), "", ""));
        this.f8738f.add(String.valueOf(r4));
    L12:
        ArrayList<l> r12 = this.f8740h;
        kotlin.n0.d.o.e(r7, "countryName");
        kotlin.n0.d.o.e(r8, "countryCode");
        kotlin.n0.d.o.e(r9, "phoneCode");
        r12.add(new l(r7, r8, r9));
        r5 = r5 + 1;
        goto L3
    L7:
        r11 = false;
        goto L8
    L14:
        return this.f8740h;
    }

    public static /* synthetic */ int g(JSONObject r0, JSONObject r1) {
        return m(r0, r1);
    }

    public static /* synthetic */ void i(AccountCountryPickerFragment r0, View r1) {
        j(r0, r1);
    }

    private static final void j(AccountCountryPickerFragment r0, View r1) {
        kotlin.n0.d.o.f(r0, "this$0");
        FragmentActivity r2 = r0.getActivity();
        if (r2 == null) goto L8;
        NavController r3 = ActivityKt.findNavController(r2, com.obric.matrix.account.g.o);
        if (r3 == null) goto L9;
        r3.navigateUp();
        return;
    L9:
        return;
    }

    private final void k(String r6) {
        int r0 = this.f8740h.size();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L19;
        if (kotlin.n0.d.o.a(this.f8740h.get(r2).b(), r6) == false) goto L18;
        AccountCountryPickerPageBinding r3 = this.f8739g;
        if (r3 == null) goto L11;
        RecyclerView r4 = r3.f8453c;
        if (r4 == null) goto L11;
        r4.scrollToPosition(r2);
    L11:
        AccountCountryPickerPageBinding r5 = this.f8739g;
        if (r5 == null) goto L16;
        RecyclerView r7 = r5.f8453c;
        if (r7 == null) goto L16;
        RecyclerView.LayoutManager r8 = r7.getLayoutManager();
    L17:
        Objects.requireNonNull(r8, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        ((LinearLayoutManager) r8).scrollToPositionWithOffset(r2, 0);
    L16:
        r8 = null;
    L18:
        r2 = r2 + 1;
        goto L3
    }

    private final JSONArray l(JSONArray r5) {
        ArrayList r4 = new ArrayList();
        int r0 = r5.length();
        int r1 = 0;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L5;
        r4.add(r5.getJSONObject(r2));
        r2 = r2 + 1;
        goto L3
    L5:
        Collections.sort(r4, com.obric.matrix.account.ui.a.f8786f);
        JSONArray r6 = new JSONArray();
        int r3 = r4.size();
    L6:
        if (r1 >= r3) goto L8;
        r6.put(r4.get(r1));
        r1 = r1 + 1;
        goto L6
    L8:
        return r6;
    }

    private static final int m(JSONObject r2, JSONObject r3) {
        String r4 = d.d.a.a.c.g(r2.getString("country_name"), "");     // Catch: JSONException -> L5
        String r5 = d.d.a.a.c.g(r3.getString("country_name"), "");     // Catch: JSONException -> L5
        kotlin.n0.d.o.e(r5, "bChineseNamePinyin");     // Catch: JSONException -> L5
        return r4.compareTo(r5);
    L5:
        e = move-exception;
        e.printStackTrace();
        return 0;
    }

    @Override // com.obric.matrix.account.ui.o
    public void a(String r1, String r2, String r3) {
        kotlin.n0.d.o.f(r1, "countryNameCode");
        kotlin.n0.d.o.f(r2, "countryCode");
        kotlin.n0.d.o.f(r3, "countryName");
    }

    public void b() {
        this.f8741i.clear();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        kotlin.n0.d.o.f(r2, "inflater");
        d.d.a.a.c.c(d.d.a.a.c.e());
        AccountCountryPickerPageBinding r5 = AccountCountryPickerPageBinding.c(r2, r3, false);
        this.f8739g = r5;
        if (r5 == null) goto L7;
        ImageView r6 = r5.f8452b;
        if (r6 == null) goto L7;
        r6.setOnClickListener(new b(this));
    L7:
        AccountCountryPickerPageBinding r7 = this.f8739g;
        if (r7 == null) goto L10;
        RecyclerView r8 = r7.f8453c;
    L11:
        if (r8 == null) goto L14;
        r8.setAdapter(new CountryCodeItemAdapter(d(), this));
    L14:
        AccountCountryPickerPageBinding r9 = this.f8739g;
        if (r9 == null) goto L17;
        RecyclerView r10 = r9.f8453c;
    L18:
        if (r10 == null) goto L21;
        r10.setLayoutManager(new LinearLayoutManager(getContext()));
    L21:
        AccountCountryPickerPageBinding r11 = this.f8739g;
        if (r11 == null) goto L27;
        SideIndexBar r12 = r11.f8454d;
        if (r12 == null) goto L27;
        r12.a(new a(this));
    L27:
        if ((!this.f8738f.isEmpty()) == false) goto L33;
        AccountCountryPickerPageBinding r13 = this.f8739g;
        if (r13 == null) goto L33;
        SideIndexBar r14 = r13.f8454d;
        if (r14 == null) goto L33;
        r14.setIndexItems(this.f8738f);
    L33:
        AccountCountryPickerPageBinding r1 = this.f8739g;
        if (r1 != null) goto L36;
        return null;
    L36:
        return r1.b();
    L17:
        r10 = null;
        goto L18
    L10:
        r8 = null;
        goto L11
    }

    @Override // androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        b();
    }
}
