package com.android.settings.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.android.settings.R;
import com.android.settings.wifi.scanner.AutoFitSurfaceView;
import com.android.settings.wifi.scanner.ScannerContainerView;
import com.android.settings.wifi.scanner.ScannerMaskView;
import com.obric.oui.button.OIconButtonFloating;
import com.obric.oui.text.OTextView;

/* JADX INFO: loaded from: classes2.dex */
public final class ActivityQrScannerBinding implements ViewBinding {
    public final OTextView barcodeScanHint;
    public final AutoFitSurfaceView barcodeScanner;
    public final OIconButtonFloating exitBarcodeScan;
    public final ScannerContainerView inactivePage;
    public final ConstraintLayout main;
    private final ConstraintLayout rootView;
    public final ScannerMaskView scannerMask;
    public final ScannerContainerView scannerPage;

    @Override // androidx.viewbinding.ViewBinding
    public /* bridge */ /* synthetic */ View getRoot() {
        return getRoot();
    }

    private ActivityQrScannerBinding(ConstraintLayout r1, OTextView r2, AutoFitSurfaceView r3, OIconButtonFloating r4, ScannerContainerView r5, ConstraintLayout r6, ScannerMaskView r7, ScannerContainerView r8) {
        this.rootView = r1;
        this.barcodeScanHint = r2;
        this.barcodeScanner = r3;
        this.exitBarcodeScan = r4;
        this.inactivePage = r5;
        this.main = r6;
        this.scannerMask = r7;
        this.scannerPage = r8;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityQrScannerBinding inflate(LayoutInflater r2) {
        return inflate(r2, null, false);
    }

    public static ActivityQrScannerBinding inflate(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(R.layout.activity_qr_scanner, r3, false);
        if (r4 == false) goto L6;
        r3.addView(r5);
    L6:
        return bind(r5);
    }

    public static ActivityQrScannerBinding bind(View r11) {
        int r0 = R.id.barcode_scan_hint;
        OTextView r4 = (OTextView) ViewBindings.findChildViewById(r11, R.id.barcode_scan_hint);
        if (r4 == null) goto L17;
        r0 = R.id.barcode_scanner;
        AutoFitSurfaceView r5 = (AutoFitSurfaceView) ViewBindings.findChildViewById(r11, R.id.barcode_scanner);
        if (r5 == null) goto L17;
        r0 = R.id.exit_barcode_scan;
        OIconButtonFloating r6 = (OIconButtonFloating) ViewBindings.findChildViewById(r11, R.id.exit_barcode_scan);
        if (r6 == null) goto L17;
        r0 = R.id.inactive_page;
        ScannerContainerView r7 = (ScannerContainerView) ViewBindings.findChildViewById(r11, R.id.inactive_page);
        if (r7 == null) goto L17;
        ConstraintLayout r8 = (ConstraintLayout) r11;
        r0 = R.id.scanner_mask;
        ScannerMaskView r9 = (ScannerMaskView) ViewBindings.findChildViewById(r11, R.id.scanner_mask);
        if (r9 == null) goto L17;
        r0 = R.id.scanner_page;
        ScannerContainerView r10 = (ScannerContainerView) ViewBindings.findChildViewById(r11, R.id.scanner_page);
        if (r10 == null) goto L17;
        return new ActivityQrScannerBinding(r8, r4, r5, r6, r7, r8, r9, r10);
    L17:
        throw new NullPointerException("Missing required view with ID: ".concat(r11.getResources().getResourceName(r0)));
    }
}
