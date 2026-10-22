package com.obric.matrix.account.ui;

import android.content.Context;
import java.util.Locale;
import kotlin.Metadata;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\b\u0010\r\u001a\u0004\u0018\u00010\u0004J\u0018\u0010\u000e\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u000e\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/obric/matrix/account/ui/CountryUtils;", "", "()V", "KEY_COUNTRY_CODE", "", "KEY_COUNTRY_NAME", "KEY_PHONE_CODE", "getAllCountriesJsonArray", "Lorg/json/JSONArray;", "locale", "Ljava/util/Locale;", "context", "Landroid/content/Context;", "getCurrentCountryCode", "getSupportedLocaleInCurrentFlavor", "sortJsonArrayByCountryNameInOversea", "jsonArray", "account_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m f8801a = null;

    static {
        f8801a = new m();
    }

    private m() {
    }

    private final Locale b(Locale r2, Context r3) {
        n r1 = n.f8802a;
        if (r1.b().contains(r2.getLanguage()) == false) goto L6;
        return r2;
    L6:
        return r1.a();
    }

    public final JSONArray a(Locale r11, Context r12) {
        kotlin.n0.d.o.f(r11, "locale");
        kotlin.n0.d.o.f(r12, "context");
        Locale r10 = b(r11, r12);
        d.e.b.a.e r13 = d.e.b.a.e.m();
        String[] r0 = Locale.getISOCountries();
        JSONArray r1 = new JSONArray();
        kotlin.n0.d.o.e(r0, "countries");
        int r2 = r0.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L29;
        String r4 = r0[r3];
        d.e.b.a.j r5 = r13.l(r4, d.e.b.a.e.c.f16579g);     // Catch: Exception -> L30
        if (r5 == null) goto L28;
        JSONObject r6 = new JSONObject();     // Catch: Exception -> L30
        String r7 = new Locale(r10.getLanguage(), r4).getDisplayCountry(r10);     // Catch: Exception -> L30
        String r8 = new Locale(r10.getLanguage(), r4).getISO3Country();     // Catch: Exception -> L30
        String r9 = String.valueOf(r5.c());     // Catch: Exception -> L30
        if (kotlin.n0.d.o.a(r7, r12.getString(com.obric.matrix.account.j.f8540i)) == false) goto L10;
    L26:
        r7 = r12.getString(com.obric.matrix.account.j.f8539h) + r7;     // Catch: Exception -> L30
    L27:
        r6.put("country_name", r7);     // Catch: Exception -> L30
        r6.put("country_code", r8);     // Catch: Exception -> L30
        r6.put("phone_code", r9);     // Catch: Exception -> L30
        r1.put(r6);     // Catch: Exception -> L30
        goto L28
    L10:
        if (kotlin.n0.d.o.a(r7, r12.getString(com.obric.matrix.account.j.f8541j)) == true) goto L26;
        if (kotlin.n0.d.o.a(r7, r12.getString(com.obric.matrix.account.j.f8542k)) == true) goto L26;
        if (kotlin.n0.d.o.a(r7, "China") == false) goto L18;
        r7 = "China mainland";
    L18:
        if (kotlin.n0.d.o.a(r7, "Hong Kong") == false) goto L21;
        r7 = "Hongkong, China";
    L21:
        if (kotlin.n0.d.o.a(r7, "Taiwan") == false) goto L24;
        r7 = "Taiwan, China";
    L24:
        if (kotlin.n0.d.o.a(r7, "Macao") == false) goto L27;
        r7 = "Macau, China";
    L28:
        r3 = r3 + 1;
        goto L3
    L29:
        return r1;
    }
}
