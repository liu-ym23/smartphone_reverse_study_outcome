package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.obric.oui.bouncelayout.OScrollView;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.sectiontitlebar.OSectionTitleBar;

/* JADX INFO: loaded from: classes2.dex */
public final class TrustedCredentialSslCertificateBinding implements ViewBinding {
    public final LinearLayout body;
    public final OCardListItem byCommonHeader;
    public final OCardListItem byOrgHeader;
    public final OCardListItem byOrgUnitHeader;
    public final OCardListItem expiresOnHeader;
    public final OSectionTitleBar fingerprints;
    public final OCardListItem issuedOnHeader;
    public final LinearLayout placeholder;
    private final OScrollView rootView;
    public final OCardListItem serialNumberHeader;
    public final OCardListItem sha1FingerprintHeader;
    public final OCardListItem sha256FingerprintHeader;
    public final OCardListItem toCommonHeader;
    public final OCardListItem toOrgHeader;
    public final OCardListItem toOrgUnitHeader;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private TrustedCredentialSslCertificateBinding(OScrollView r1, LinearLayout r2, OCardListItem r3, OCardListItem r4, OCardListItem r5, OCardListItem r6, OSectionTitleBar r7, OCardListItem r8, LinearLayout r9, OCardListItem r10, OCardListItem r11, OCardListItem r12, OCardListItem r13, OCardListItem r14, OCardListItem r15) {
        this.rootView = r1;
        this.body = r2;
        this.byCommonHeader = r3;
        this.byOrgHeader = r4;
        this.byOrgUnitHeader = r5;
        this.expiresOnHeader = r6;
        this.fingerprints = r7;
        this.issuedOnHeader = r8;
        this.placeholder = r9;
        this.serialNumberHeader = r10;
        this.sha1FingerprintHeader = r11;
        this.sha256FingerprintHeader = r12;
        this.toCommonHeader = r13;
        this.toOrgHeader = r14;
        this.toOrgUnitHeader = r15;
    }

    @Override // androidx.viewbinding.ViewBinding
    public OScrollView getRoot() {
        return this.rootView;
    }

    public static TrustedCredentialSslCertificateBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static TrustedCredentialSslCertificateBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.trusted_credential_ssl_certificate, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static TrustedCredentialSslCertificateBinding bind(View r19) {
        int r1 = R.id.body;
        LinearLayout r5 = (LinearLayout) ViewBindings.findChildViewById(r19, R.id.body);
        if (r5 == null) goto L33;
        r1 = R.id.by_common_header;
        OCardListItem r6 = (OCardListItem) ViewBindings.findChildViewById(r19, R.id.by_common_header);
        if (r6 == null) goto L33;
        r1 = R.id.by_org_header;
        OCardListItem r7 = (OCardListItem) ViewBindings.findChildViewById(r19, R.id.by_org_header);
        if (r7 == null) goto L33;
        r1 = R.id.by_org_unit_header;
        OCardListItem r8 = (OCardListItem) ViewBindings.findChildViewById(r19, R.id.by_org_unit_header);
        if (r8 == null) goto L33;
        r1 = R.id.expires_on_header;
        OCardListItem r9 = (OCardListItem) ViewBindings.findChildViewById(r19, R.id.expires_on_header);
        if (r9 == null) goto L33;
        r1 = R.id.fingerprints;
        OSectionTitleBar r10 = (OSectionTitleBar) ViewBindings.findChildViewById(r19, R.id.fingerprints);
        if (r10 == null) goto L33;
        r1 = R.id.issued_on_header;
        OCardListItem r11 = (OCardListItem) ViewBindings.findChildViewById(r19, R.id.issued_on_header);
        if (r11 == null) goto L33;
        r1 = R.id.placeholder;
        LinearLayout r12 = (LinearLayout) ViewBindings.findChildViewById(r19, R.id.placeholder);
        if (r12 == null) goto L33;
        r1 = R.id.serial_number_header;
        OCardListItem r13 = (OCardListItem) ViewBindings.findChildViewById(r19, R.id.serial_number_header);
        if (r13 == null) goto L33;
        r1 = R.id.sha1_fingerprint_header;
        OCardListItem r14 = (OCardListItem) ViewBindings.findChildViewById(r19, R.id.sha1_fingerprint_header);
        if (r14 == null) goto L33;
        r1 = R.id.sha256_fingerprint_header;
        OCardListItem r15 = (OCardListItem) ViewBindings.findChildViewById(r19, R.id.sha256_fingerprint_header);
        if (r15 == null) goto L33;
        r1 = R.id.to_common_header;
        OCardListItem r16 = (OCardListItem) ViewBindings.findChildViewById(r19, R.id.to_common_header);
        if (r16 == null) goto L33;
        r1 = R.id.to_org_header;
        OCardListItem r17 = (OCardListItem) ViewBindings.findChildViewById(r19, R.id.to_org_header);
        if (r17 == null) goto L33;
        r1 = R.id.to_org_unit_header;
        OCardListItem r18 = (OCardListItem) ViewBindings.findChildViewById(r19, R.id.to_org_unit_header);
        if (r18 == null) goto L33;
        return new TrustedCredentialSslCertificateBinding((OScrollView) r19, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18);
    L33:
        throw new NullPointerException("Missing required view with ID: ".concat(r19.getResources().getResourceName(r1)));
    }
}
