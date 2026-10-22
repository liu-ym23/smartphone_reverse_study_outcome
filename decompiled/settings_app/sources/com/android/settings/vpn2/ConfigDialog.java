package com.android.settings.vpn2;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.SystemProperties;
import android.security.LegacyVpnProfileStore;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.TextView;
import com.android.internal.net.VpnProfile;
import com.android.settings.AdaptUtils;
import com.android.settings.R;
import com.android.settings.utils.HanziToPinyin;
import com.bytedance.librarian.LibrarianImpl;

/* JADX INFO: loaded from: classes2.dex */
class ConfigDialog extends AlertDialog implements TextWatcher, View.OnClickListener, AdapterView.OnItemSelectedListener, CompoundButton.OnCheckedChangeListener {
    private CheckBox mAlwaysOnVpn;
    private TextView mDnsServers;
    private boolean mEditing;
    private boolean mExists;
    private Spinner mIpsecCaCert;
    private TextView mIpsecIdentifier;
    private TextView mIpsecSecret;
    private Spinner mIpsecServerCert;
    private Spinner mIpsecUserCert;
    private TextView mL2tpSecret;
    private final DialogInterface.OnClickListener mListener;
    private CheckBox mMppe;
    private TextView mName;
    private TextView mPassword;
    private final VpnProfile mProfile;
    private TextView mRoutes;
    private CheckBox mSaveLogin;
    private TextView mSearchDomains;
    private TextView mServer;
    private CheckBox mShowOptions;
    private Spinner mType;
    private TextView mUsername;
    private View mView;

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> r1) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
    }

    ConfigDialog(Context r1, DialogInterface.OnClickListener r2, VpnProfile r3, boolean r4, boolean r5) {
        super(r1);
        this.mListener = r2;
        this.mProfile = r3;
        this.mEditing = r4;
        this.mExists = r5;
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    protected void onCreate(Bundle r8) {
        View r0 = getLayoutInflater().inflate(R.layout.vpn_dialog, null);
        this.mView = r0;
        setView(r0);
        Context r1 = getContext();
        this.mName = (TextView) this.mView.findViewById(R.id.name);
        this.mType = (Spinner) this.mView.findViewById(R.id.type);
        this.mServer = (TextView) this.mView.findViewById(R.id.server);
        this.mUsername = (TextView) this.mView.findViewById(R.id.username);
        this.mPassword = (TextView) this.mView.findViewById(R.id.password);
        this.mSearchDomains = (TextView) this.mView.findViewById(R.id.search_domains);
        this.mDnsServers = (TextView) this.mView.findViewById(R.id.dns_servers);
        this.mRoutes = (TextView) this.mView.findViewById(R.id.routes);
        this.mMppe = (CheckBox) this.mView.findViewById(R.id.mppe);
        this.mL2tpSecret = (TextView) this.mView.findViewById(R.id.l2tp_secret);
        this.mIpsecIdentifier = (TextView) this.mView.findViewById(R.id.ipsec_identifier);
        this.mIpsecSecret = (TextView) this.mView.findViewById(R.id.ipsec_secret);
        this.mIpsecUserCert = (Spinner) this.mView.findViewById(R.id.ipsec_user_cert);
        this.mIpsecCaCert = (Spinner) this.mView.findViewById(R.id.ipsec_ca_cert);
        this.mIpsecServerCert = (Spinner) this.mView.findViewById(R.id.ipsec_server_cert);
        this.mSaveLogin = (CheckBox) this.mView.findViewById(R.id.save_login);
        this.mShowOptions = (CheckBox) this.mView.findViewById(R.id.show_options);
        this.mAlwaysOnVpn = (CheckBox) this.mView.findViewById(R.id.always_on_vpn);
        this.mName.setText(this.mProfile.name);
        this.mType.setSelection(this.mProfile.type);
        this.mServer.setText(this.mProfile.server);
        if (this.mProfile.saveLogin == false) goto L5;
        this.mUsername.setText(this.mProfile.username);
        this.mPassword.setText(this.mProfile.password);
    L5:
        this.mSearchDomains.setText(this.mProfile.searchDomains);
        this.mDnsServers.setText(this.mProfile.dnsServers);
        this.mRoutes.setText(this.mProfile.routes);
        this.mMppe.setChecked(this.mProfile.mppe);
        this.mL2tpSecret.setText(this.mProfile.l2tpSecret);
        this.mIpsecIdentifier.setText(this.mProfile.ipsecIdentifier);
        this.mIpsecSecret.setText(this.mProfile.ipsecSecret);
        loadCertificates(this.mIpsecUserCert, "USRPKEY_", 0, this.mProfile.ipsecUserCert);
        loadCertificates(this.mIpsecCaCert, "CACERT_", R.string.vpn_no_ca_cert, this.mProfile.ipsecCaCert);
        loadCertificates(this.mIpsecServerCert, "USRCERT_", R.string.vpn_no_server_cert, this.mProfile.ipsecServerCert);
        this.mSaveLogin.setChecked(this.mProfile.saveLogin);
        this.mAlwaysOnVpn.setChecked(this.mProfile.key.equals(VpnUtils.getLockdownVpn()));
        this.mAlwaysOnVpn.setOnCheckedChangeListener(this);
        updateSaveLoginStatus();
        if (SystemProperties.getBoolean("persist.radio.imsregrequired", false) == false) goto L8;
        this.mAlwaysOnVpn.setVisibility(8);
    L8:
        this.mName.addTextChangedListener(this);
        this.mType.setOnItemSelectedListener(this);
        this.mServer.addTextChangedListener(this);
        this.mUsername.addTextChangedListener(this);
        this.mPassword.addTextChangedListener(this);
        this.mDnsServers.addTextChangedListener(this);
        this.mRoutes.addTextChangedListener(this);
        this.mIpsecSecret.addTextChangedListener(this);
        this.mIpsecUserCert.setOnItemSelectedListener(this);
        this.mShowOptions.setOnClickListener(this);
        boolean r3 = validate(true);
        if (this.mEditing == true) goto L13;
        if (r3 == false) goto L13;
        boolean r5 = false;
    L14:
        this.mEditing = r5;
        if (r5 == false) goto L27;
        setTitle(R.string.vpn_edit);
        this.mView.findViewById(R.id.editor).setVisibility(0);
        changeType(this.mProfile.type);
        this.mSaveLogin.setVisibility(8);
        if (this.mProfile.searchDomains.isEmpty() == true) goto L19;
    L22:
        showAdvancedOptions();
    L24:
        if (this.mExists == false) goto L26;
        setButton(-3, r1.getString(R.string.vpn_forget), this.mListener);
    L26:
        setButton(-1, r1.getString(R.string.vpn_save), this.mListener);
    L28:
        setButton(-2, r1.getString(R.string.vpn_cancel), this.mListener);
        super.onCreate(r8);
        Button r9 = getButton(-1);
        if (this.mEditing == true) goto L32;
        r3 = validate(false);
    L32:
        r9.setEnabled(r3);
        getWindow().setSoftInputMode(20);
        return;
    L19:
        if (this.mProfile.dnsServers.isEmpty() == false) goto L22;
        if (this.mProfile.routes.isEmpty() == true) goto L24;
    L27:
        setTitle(r1.getString(R.string.vpn_connect_to, new Object[]{this.mProfile.name}));
        setButton(-1, r1.getString(R.string.vpn_connect), this.mListener);
    L13:
        r5 = true;
        goto L14
    }

    @Override // android.app.Dialog
    public void onRestoreInstanceState(Bundle r1) {
        super.onRestoreInstanceState(r1);
        if (this.mShowOptions.isChecked() == false) goto L6;
        showAdvancedOptions();
        return;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable r2) {
        getButton(-1).setEnabled(validate(this.mEditing));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r2) {
        if (r2 != this.mShowOptions) goto L6;
        showAdvancedOptions();
        return;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> r1, View r2, int r3, long r4) {
        if (r1 != this.mType) goto L5;
        changeType(r3);
    L5:
        getButton(-1).setEnabled(validate(this.mEditing));
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton r1, boolean r2) {
        if (r1 != this.mAlwaysOnVpn) goto L6;
        updateSaveLoginStatus();
        getButton(-1).setEnabled(validate(this.mEditing));
        return;
    }

    public boolean isVpnAlwaysOn() {
        return this.mAlwaysOnVpn.isChecked();
    }

    private void updateSaveLoginStatus() {
        if (this.mAlwaysOnVpn.isChecked() == false) goto L5;
        this.mSaveLogin.setChecked(true);
        this.mSaveLogin.setEnabled(false);
        return;
    L5:
        this.mSaveLogin.setChecked(this.mProfile.saveLogin);
        this.mSaveLogin.setEnabled(true);
    }

    private void showAdvancedOptions() {
        this.mView.findViewById(R.id.options).setVisibility(0);
        this.mShowOptions.setVisibility(8);
    }

    private void changeType(int r7) {
        this.mMppe.setVisibility(8);
        this.mView.findViewById(R.id.l2tp).setVisibility(8);
        this.mView.findViewById(R.id.ipsec_psk).setVisibility(8);
        this.mView.findViewById(R.id.ipsec_user).setVisibility(8);
        this.mView.findViewById(R.id.ipsec_peer).setVisibility(8);
        if (r7 != 0) goto L5;
        this.mMppe.setVisibility(0);
        return;
    L5:
        if (r7 != 1) goto L7;
        this.mView.findViewById(R.id.l2tp).setVisibility(0);
    L19:
        this.mView.findViewById(R.id.ipsec_psk).setVisibility(0);
        return;
    L7:
        if (r7 != 2) goto L9;
        this.mView.findViewById(R.id.l2tp).setVisibility(0);
    L16:
        this.mView.findViewById(R.id.ipsec_user).setVisibility(0);
    L17:
        this.mView.findViewById(R.id.ipsec_peer).setVisibility(0);
        return;
    L9:
        if (r7 == 3) goto L19;
        if (r7 == 4) goto L16;
        if (r7 == 5) goto L17;
    }

    private boolean validate(boolean r4) {
        if (r4 == true) goto L12;
        if (this.mUsername.getText().length() == 0) goto L10;
        if (this.mPassword.getText().length() == 0) goto L10;
        return true;
    L10:
        return false;
    L12:
        if (this.mAlwaysOnVpn.isChecked() == false) goto L17;
        if (getProfile().isValidLockdownProfile() == true) goto L17;
        return false;
    L17:
        if (this.mName.getText().length() != 0) goto L19;
    L47:
        return false;
    L19:
        if (this.mServer.getText().length() == 0) goto L47;
        if (validateAddresses(this.mDnsServers.getText().toString(), false) == false) goto L47;
        if (validateAddresses(this.mRoutes.getText().toString(), true) == false) goto L47;
        int r5 = this.mType.getSelectedItemPosition();
        if (r5 == 0) goto L50;
        if (r5 == 1) goto L43;
        if (r5 == 2) goto L38;
        if (r5 == 3) goto L43;
        if (r5 == 4) goto L38;
        if (r5 == 5) goto L51;
        return false;
    L51:
        return true;
    L38:
        if (this.mIpsecUserCert.getSelectedItemPosition() == 0) goto L41;
        return true;
    L41:
        return false;
    L43:
        if (this.mIpsecSecret.getText().length() == 0) goto L46;
        return true;
    L46:
        return false;
    L50:
        return true;
    }

    private boolean validateAddresses(String r10, boolean r11) {
        String[] r12 = r10.split(HanziToPinyin.Token.SEPARATOR);     // Catch: Exception -> L25
        int r0 = r12.length;     // Catch: Exception -> L25
        int r1 = 0;
    L5:
        if (r1 >= r0) goto L24;
        String r3 = r12[r1];     // Catch: Exception -> L25
        if (r3.isEmpty() == false) goto L10;
    L22:
        r1 = r1 + 1;
        goto L5
    L10:
        if (r11 == false) goto L12;
        String[] r4 = r3.split(LibrarianImpl.Constants.SEPARATOR, 2);     // Catch: Exception -> L25
        String r6 = r4[0];     // Catch: Exception -> L25
        int r7 = Integer.parseInt(r4[1]);     // Catch: Exception -> L25
        r3 = r6;
    L13:
        byte[] r5 = AdaptUtils.parseNumericAddress(r3).getAddress();     // Catch: Exception -> L25
        int r2 = (((r5[1] & 255) << 16) | (((r5[2] & 255) << 8) | (r5[3] & 255))) | ((r5[0] & 255) << 24);     // Catch: Exception -> L25
        if (r5.length != 4) goto L23;
        if (r7 < 0) goto L23;
        if (r7 > 32) goto L23;
        if (r7 >= 32) goto L22;
        if ((r2 << r7) == 0) goto L22;
    L23:
        return false;
    L12:
        r7 = 32;
        goto L13
    L24:
        return true;
    L25:
        return false;
    }

    private void loadCertificates(Spinner r4, String r5, int r6, String r7) {
        Context r3 = getContext();
        if (r6 != 0) goto L5;
        String r8 = "";
    L6:
        String[] r9 = LegacyVpnProfileStore.list(r5);
        int r1 = 1;
        if (r9 != null) goto L9;
    L12:
        String[] r2 = {r8};
    L13:
        ArrayAdapter r10 = new ArrayAdapter(r3, android.R.layout.simple_spinner_item, r2);
        r10.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        r4.setAdapter(r10);
    L15:
        if (r1 >= r2.length) goto L23;
        if (r2[r1].equals(r7) == true) goto L18;
        r1 = r1 + 1;
        goto L15
    L18:
        r4.setSelection(r1);
        return;
    L23:
        return;
    L9:
        if (r9.length == 0) goto L12;
        r2 = new String[r9.length + 1];
        r2[0] = r8;
        System.arraycopy(r9, 0, r2, 1, r9.length);
        goto L13
    L5:
        r8 = r3.getString(r6);
        goto L6
    }

    boolean isEditing() {
        return this.mEditing;
    }

    VpnProfile getProfile() {
        VpnProfile r0 = new VpnProfile(this.mProfile.key);
        r0.name = this.mName.getText().toString();
        r0.type = this.mType.getSelectedItemPosition();
        r0.server = this.mServer.getText().toString().trim();
        r0.username = this.mUsername.getText().toString();
        r0.password = this.mPassword.getText().toString();
        r0.searchDomains = this.mSearchDomains.getText().toString().trim();
        r0.dnsServers = this.mDnsServers.getText().toString().trim();
        r0.routes = this.mRoutes.getText().toString().trim();
        int r1 = r0.type;
        boolean r2 = true;
        if (r1 == 0) goto L26;
        if (r1 != 1) goto L6;
        r0.l2tpSecret = this.mL2tpSecret.getText().toString();
    L25:
        r0.ipsecIdentifier = this.mIpsecIdentifier.getText().toString();
        r0.ipsecSecret = this.mIpsecSecret.getText().toString();
    L28:
        if (r0.username.isEmpty() == true) goto L30;
    L33:
        boolean r3 = true;
    L35:
        if (this.mSaveLogin.isChecked() == false) goto L37;
    L41:
        r0.saveLogin = r2;
        return r0;
    L37:
        if (this.mEditing == false) goto L40;
        if (r3 == true) goto L41;
    L40:
        r2 = false;
        goto L41
    L30:
        if (r0.password.isEmpty() == false) goto L33;
        r3 = false;
        goto L35
    L6:
        if (r1 != 2) goto L8;
        r0.l2tpSecret = this.mL2tpSecret.getText().toString();
    L16:
        if (this.mIpsecUserCert.getSelectedItemPosition() == 0) goto L19;
        r0.ipsecUserCert = (String) this.mIpsecUserCert.getSelectedItem();
    L19:
        if (this.mIpsecCaCert.getSelectedItemPosition() == 0) goto L22;
        r0.ipsecCaCert = (String) this.mIpsecCaCert.getSelectedItem();
    L22:
        if (this.mIpsecServerCert.getSelectedItemPosition() == 0) goto L28;
        r0.ipsecServerCert = (String) this.mIpsecServerCert.getSelectedItem();
        goto L28
    L8:
        if (r1 == 3) goto L25;
        if (r1 == 4) goto L16;
        if (r1 == 5) goto L19;
    L26:
        r0.mppe = this.mMppe.isChecked();
        goto L28
    }
}
