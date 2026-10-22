package com.android.settings;

import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.internal.app.AlertActivity;
import com.android.internal.app.AlertController;
import com.android.internal.telephony.SmsApplication;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class SmsDefaultDialog extends AlertActivity implements DialogInterface.OnClickListener {
    private SmsApplication.SmsApplicationData mNewSmsApplicationData;

    private class AppListAdapter extends BaseAdapter {
        private final List<Item> mItems;
        private final int mSelectedIndex;
        final /* synthetic */ SmsDefaultDialog this$0;

        private class Item {
            final Drawable icon;
            final String label;
            final String packgeName;
            final /* synthetic */ AppListAdapter this$1;

            public Item(AppListAdapter r1, String r2, Drawable r3, String r4) {
                this.this$1 = r1;
                this.label = r2;
                this.icon = r3;
                this.packgeName = r4;
            }
        }

        @Override // android.widget.Adapter
        public long getItemId(int r1) {
            return r1;
        }

        public AppListAdapter(SmsDefaultDialog r3) {
            this.this$0 = r3;
            List<Item> r4 = getItems();
            this.mItems = r4;
            int r0 = getSelectedIndex();
            if (r0 <= 0) goto L5;
            r4.add(0, r4.remove(r0));
            r0 = 0;
        L5:
            this.mSelectedIndex = r0;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            List<Item> r0 = this.mItems;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int r2) {
            List<Item> r0 = this.mItems;
            if (r0 != null) goto L5;
        L7:
            return null;
        L5:
            if (r2 >= r0.size()) goto L7;
            return this.mItems.get(r2);
        }

        @Override // android.widget.Adapter
        public View getView(int r4, View r5, ViewGroup r6) {
            Item r7 = (Item) getItem(r4);
            if (r7 != null) goto L6;
            return null;
        L6:
            View r8 = this.this$0.getLayoutInflater().inflate(R.layout.app_preference_item, r6, false);
            ((TextView) r8.findViewById(android.R.id.title)).setText(r7.label);
            if (r4 != this.mSelectedIndex) goto L9;
            r8.findViewById(R.id.default_label).setVisibility(0);
        L10:
            ((ImageView) r8.findViewById(android.R.id.icon)).setImageDrawable(r7.icon);
            return r8;
        L9:
            r8.findViewById(R.id.default_label).setVisibility(8);
            goto L10
        }

        public String getPackageName(int r1) {
            Item r0 = (Item) getItem(r1);
            if (r0 != null) goto L5;
            return null;
        L5:
            return r0.packgeName;
        }

        public boolean isSelected(int r1) {
            if (r1 != this.mSelectedIndex) goto L5;
            return true;
        L5:
            return false;
        }

        private List<Item> getItems() {
            PackageManager r0 = this.this$0.getPackageManager();
            ArrayList r1 = new ArrayList();
            Iterator r2 = SmsApplication.getApplicationCollection(this.this$0).iterator();
        L4:
            if (r2.hasNext() == false) goto L10;
            String r3 = ((SmsApplication.SmsApplicationData) r2.next()).mPackageName;     // Catch: PackageManager.NameNotFoundException -> L11
            ApplicationInfo r4 = r0.getApplicationInfo(r3, 0);     // Catch: PackageManager.NameNotFoundException -> L11
            if (r4 == null) goto L4;
            r1.add(new Item(this, r4.loadLabel(r0).toString(), r4.loadIcon(r0), r3));     // Catch: PackageManager.NameNotFoundException -> L11
            goto L4
        L10:
            return r1;
        }

        private int getSelectedIndex() {
            ComponentName r0 = SmsApplication.getDefaultSmsApplication(this.this$0, true);
            if (r0 == null) goto L13;
            String r1 = r0.getPackageName();
            if (TextUtils.isEmpty(r1) == true) goto L17;
            int r2 = 0;
        L8:
            if (r2 >= this.mItems.size()) goto L18;
            if (TextUtils.equals(this.mItems.get(r2).packgeName, r1) == true) goto L11;
            r2 = r2 + 1;
            goto L8
        L11:
            return r2;
        L18:
            return -1;
        L17:
            return -1;
        L13:
            return -1;
        }
    }

    public SmsDefaultDialog() {
    }

    protected void onCreate(Bundle r2) {
        super.onCreate(r2);
        String r3 = getIntent().getStringExtra("package");
        setResult(0);
        if (buildDialog(r3) == true) goto L6;
        finish();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface r3, int r4) {
        if (r4 != (-2)) goto L5;
        return;
    L5:
        if (r4 == (-1)) goto L12;
        if (r4 < 0) goto L15;
        AppListAdapter r0 = (AppListAdapter) this.mAlertParams.mAdapter;
        if (r0.isSelected(r4) == true) goto L16;
        String r5 = r0.getPackageName(r4);
        if (TextUtils.isEmpty(r5) == true) goto L17;
        SmsApplication.setDefaultApplication(r5, this);
        setResult(-1);
        return;
    L17:
        return;
    L16:
        return;
    L15:
        return;
    L12:
        SmsApplication.setDefaultApplication(this.mNewSmsApplicationData.mPackageName, this);
        setResult(-1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean buildDialog(String r6) {
        TelephonyManager r0 = (TelephonyManager) getSystemService(MultiSimAdapter.PHONE_KEY);
        if (r0 != null) goto L5;
    L24:
        return false;
    L5:
        if (r0.isSmsCapable() == false) goto L24;
        AlertController.AlertParams r1 = this.mAlertParams;
        r1.mTitle = getString(R.string.sms_change_default_dialog_title);
        SmsApplication.SmsApplicationData r7 = SmsApplication.getSmsApplicationData(r6, this);
        this.mNewSmsApplicationData = r7;
        if (r7 == null) goto L21;
        ComponentName r8 = SmsApplication.getDefaultSmsApplication(this, true);
        if (r8 == null) goto L16;
        SmsApplication.SmsApplicationData r9 = SmsApplication.getSmsApplicationData(r8.getPackageName(), this);
        if (r9 != null) goto L14;
    L17:
        if (r9 == null) goto L19;
        r1.mMessage = getString(R.string.sms_change_default_dialog_text, new Object[]{this.mNewSmsApplicationData.getApplicationName(this), r9.getApplicationName(this)});
    L20:
        r1.mPositiveButtonText = getString(R.string.yes);
        r1.mNegativeButtonText = getString(R.string.no);
        r1.mPositiveButtonListener = this;
        r1.mNegativeButtonListener = this;
    L22:
        setupAlert();
        return true;
    L19:
        r1.mMessage = getString(R.string.sms_change_default_no_previous_dialog_text, new Object[]{this.mNewSmsApplicationData.getApplicationName(this)});
        goto L20
    L14:
        if (r9.mPackageName.equals(this.mNewSmsApplicationData.mPackageName) == false) goto L17;
        return false;
    L16:
        r9 = null;
        goto L17
    L21:
        r1.mAdapter = new AppListAdapter(this);
        r1.mOnClickListener = this;
        r1.mNegativeButtonText = getString(R.string.cancel);
        r1.mNegativeButtonListener = this;
        goto L22
    }
}
