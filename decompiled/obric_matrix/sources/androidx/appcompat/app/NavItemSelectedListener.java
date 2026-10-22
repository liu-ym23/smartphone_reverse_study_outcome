package androidx.appcompat.app;

import android.view.View;
import android.widget.AdapterView;

/* JADX INFO: loaded from: classes.dex */
class NavItemSelectedListener implements AdapterView.OnItemSelectedListener {
    private final ActionBar.OnNavigationListener mListener;

    public NavItemSelectedListener(ActionBar.OnNavigationListener r1) {
        this.mListener = r1;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> r1, View r2, int r3, long r4) {
        ActionBar.OnNavigationListener r0 = this.mListener;
        if (r0 == null) goto L6;
        r0.onNavigationItemSelected(r3, r4);
        return;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> r1) {
    }
}
