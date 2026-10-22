package com.android.settings.nfc;

import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import androidx.appcompat.app.AlertDialog;
import androidx.preference.PreferenceViewHolder;
import com.android.settings.CustomDialogPreference;
import com.android.settings.R;
import com.obric.olog.OLog;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class NfcPaymentPreference extends CustomDialogPreference implements PaymentBackend.Callback, View.OnClickListener {
    private static final String TAG = "NfcPaymentPreference";
    private final NfcPaymentAdapter mAdapter;
    private final Context mContext;
    private final LayoutInflater mLayoutInflater;
    private final PaymentBackend mPaymentBackend;
    private ImageView mSettingsButtonView;

    class NfcPaymentAdapter extends BaseAdapter implements CompoundButton.OnCheckedChangeListener, View.OnClickListener {
        private PaymentBackend.PaymentAppInfo[] appInfos;
        final /* synthetic */ NfcPaymentPreference this$0;

        public class ViewHolder {
            public ImageView imageView;
            public RadioButton radioButton;
            final /* synthetic */ NfcPaymentAdapter this$1;

            public ViewHolder(NfcPaymentAdapter r1) {
                this.this$1 = r1;
            }
        }

        @Override // android.widget.Adapter
        public /* bridge */ /* synthetic */ Object getItem(int r1) {
            return getItem(r1);
        }

        public NfcPaymentAdapter(NfcPaymentPreference r1) {
            this.this$0 = r1;
        }

        public void updateApps(PaymentBackend.PaymentAppInfo[] r1, PaymentBackend.PaymentAppInfo r2) {
            this.appInfos = r1;
            notifyDataSetChanged();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.appInfos.length;
        }

        @Override // android.widget.Adapter
        public PaymentBackend.PaymentAppInfo getItem(int r1) {
            return this.appInfos[r1];
        }

        @Override // android.widget.Adapter
        public long getItemId(int r1) {
            return this.appInfos[r1].componentName.hashCode();
        }

        @Override // android.widget.Adapter
        public View getView(int r3, View r4, ViewGroup r5) {
            PaymentBackend.PaymentAppInfo r6 = this.appInfos[r3];
            if (r4 != null) goto L5;
            r4 = NfcPaymentPreference.access$000(this.this$0).inflate(R.layout.nfc_payment_option, r5, false);
            ViewHolder r7 = new ViewHolder(this);
            r7.imageView = (ImageView) r4.findViewById(R.id.banner);
            r7.radioButton = (RadioButton) r4.findViewById(R.id.button);
            r4.setTag(r7);
        L6:
            ImageView r0 = r7.imageView;
            if (r0 == null) goto L9;
            r0.setImageDrawable(r6.banner);
            r0.setTag(r6);
            r0.setContentDescription(r6.label);
            r0.setOnClickListener(this);
        L9:
            RadioButton r8 = r7.radioButton;
            if (r8 == null) goto L12;
            r8.setOnCheckedChangeListener(null);
            r8.setChecked(r6.isDefault);
            r8.setContentDescription(r6.label);
            r8.setOnCheckedChangeListener(this);
            r8.setTag(r6);
        L12:
            return r4;
        L5:
            r7 = (ViewHolder) r4.getTag();
            goto L6
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton r1, boolean r2) {
            makeDefault((PaymentBackend.PaymentAppInfo) r1.getTag());
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View r1) {
            makeDefault((PaymentBackend.PaymentAppInfo) r1.getTag());
        }

        void makeDefault(PaymentBackend.PaymentAppInfo r3) {
            if (r3.isDefault == true) goto L5;
            NfcPaymentPreference.access$100(this.this$0).setDefaultPaymentApp(r3.componentName, r3.userHandle.getIdentifier());
        L5:
            Dialog r2 = this.this$0.getDialog();
            if (r2 == null) goto L9;
            r2.dismiss();
            return;
        }
    }

    static /* synthetic */ LayoutInflater access$000(NfcPaymentPreference r0) {
        return r0.mLayoutInflater;
    }

    static /* synthetic */ PaymentBackend access$100(NfcPaymentPreference r0) {
        return r0.mPaymentBackend;
    }

    public NfcPaymentPreference(Context r2, PaymentBackend r3) {
        super(r2, null);
        this.mPaymentBackend = r3;
        this.mContext = r2;
        r3.registerCallback(this);
        this.mAdapter = new NfcPaymentAdapter(this);
        setDialogTitle(r2.getString(R.string.nfc_payment_pay_with));
        this.mLayoutInflater = (LayoutInflater) r2.getSystemService("layout_inflater");
        setWidgetLayoutResource(R.layout.preference_widget_settings);
        refresh();
    }

    @Override // androidx.preference.Preference
    public void onBindViewHolder(PreferenceViewHolder r2) {
        super.onBindViewHolder(r2);
        ImageView r3 = (ImageView) r2.findViewById(R.id.settings_button);
        this.mSettingsButtonView = r3;
        r3.setOnClickListener(this);
        updateSettingsVisibility();
    }

    public void refresh() {
        List<PaymentBackend.PaymentAppInfo> r0 = this.mPaymentBackend.getPaymentAppInfos();
        PaymentBackend.PaymentAppInfo r1 = this.mPaymentBackend.getDefaultApp();
        if (r0 == null) goto L5;
        PaymentBackend.PaymentAppInfo[] r2 = (PaymentBackend.PaymentAppInfo[]) r0.toArray(new PaymentBackend.PaymentAppInfo[r0.size()]);
        this.mAdapter.updateApps(r2, r1);
    L5:
        setTitle(R.string.nfc_payment_default);
        if (r1 == null) goto L8;
        setSummary(r1.label);
    L9:
        updateSettingsVisibility();
        return;
    L8:
        setSummary(this.mContext.getString(R.string.nfc_payment_default_not_set));
        goto L9
    }

    @Override // com.android.settings.CustomDialogPreference
    protected void onPrepareDialogBuilder(AlertDialog.Builder r2, DialogInterface.OnClickListener r3) {
        super.onPrepareDialogBuilder(r2, r3);
        r2.setSingleChoiceItems(this.mAdapter, 0, r3);
    }

    @Override // com.android.settings.nfc.PaymentBackend.Callback
    public void onPaymentAppsChanged() {
        refresh();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r3) {
        PaymentBackend.PaymentAppInfo r4 = this.mPaymentBackend.getDefaultApp();
        if (r4 != null) goto L5;
        return;
    L5:
        if (r4.settingsComponent == null) goto L14;
        Intent r0 = new Intent("android.intent.action.MAIN");
        r0.setComponent(r4.settingsComponent);
        r0.addFlags(268435456);
        this.mContext.startActivity(r0);     // Catch: ActivityNotFoundException -> L9
        return;
    L9:
        OLog.e(TAG, "Settings activity not found.");
        return;
    }

    void updateSettingsVisibility() {
        if (this.mSettingsButtonView == null) goto L12;
        PaymentBackend.PaymentAppInfo r0 = this.mPaymentBackend.getDefaultApp();
        if (r0 != null) goto L7;
    L10:
        this.mSettingsButtonView.setVisibility(8);
        return;
    L7:
        if (r0.settingsComponent == null) goto L10;
        this.mSettingsButtonView.setVisibility(0);
        return;
    }
}
