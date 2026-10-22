package com.bytedanceos.security.permission;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.bytedanceos.security.BaseActivity;
import com.bytedanceos.security.Utils;
import com.bytedanceos.security.multi.adpter.MultiSdkAdapter;
import com.bytedanceos.security.reflect.OpsManagerHelper;
import com.obric.security.R;
import java.util.ArrayDeque;

/* JADX INFO: loaded from: classes2.dex */
public class NativePermissionsActivity extends BaseActivity implements View.OnClickListener {
    private final String TAG;
    private int animInLeft;
    private int animInRight;
    private int animOutLeft;
    private int animOutRight;

    public NativePermissionsActivity() {
        this.TAG = "MainActivity";
    }

    @Override // com.bytedanceos.security.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.native_permissions_activity);
        getWindow().setBackgroundDrawable(null);
        setupViews();
        this.animInRight = Utils.getSMTResouceId(this, "bytedanceos", "slide_in_from_right", "anim", R.anim.slide_in_from_right);
        this.animOutLeft = Utils.getSMTResouceId(this, "bytedanceos", "slide_out_to_left", "anim", R.anim.slide_out_to_left);
        this.animInLeft = Utils.getSMTResouceId(this, "bytedanceos", "slide_in_from_left", "anim", R.anim.slide_in_from_left);
        this.animOutRight = Utils.getSMTResouceId(this, "bytedanceos", "slide_out_to_right", "anim", R.anim.slide_out_to_right);
        updateViewWidth(R.id.ll_container);
        initItemView();
    }

    private void initItemView() {
        findViewById(R.id.permission_change_network_state).setVisibility(8);
        findViewById(R.id.permission_kill_background_processes).setVisibility(8);
        findViewById(R.id.permission_storage);
        findViewById(R.id.permission_storage_all).setVisibility(0);
    }

    protected void setupViews() {
        initTitleBar(false);
        updateNFCViews();
        if (MultiSdkAdapter.isAfterQ() == false) goto L8;
        View r2 = findViewById(R.id.permission_body);
        if (r2 == null) goto L9;
        r2.setVisibility(0);
        return;
    L9:
        return;
    }

    private void updateNFCViews() {
        View r0 = findViewById(R.id.permission_nfc);
        if (r0 != null) goto L5;
        return;
    L5:
        if (Utils.isNfcSupport(this) == false) goto L7;
        int r1 = 0;
    L8:
        r0.setVisibility(r1);
        return;
    L7:
        r1 = 8;
        goto L8
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        if (Utils.isFastDoubleClick() == false) goto L5;
        return;
    L5:
        Intent r0 = new Intent();
        int r7 = v.getId();
        String r1 = null;
        String r3 = Utils.INTENT_ACTION_SWITCH_PERMISSIONS_NEW;
        int r4 = -1;
        switch(r7) {
            case 2131297563: goto L48;
            case 2131297564: goto L46;
            case 2131297565: goto L45;
            case 2131297566: goto L44;
            case 2131297567: goto L43;
            case 2131297568: goto L42;
            case 2131297569: goto L41;
            case 2131297570: goto L7;
            case 2131297571: goto L40;
            case 2131297572: goto L39;
            case 2131297573: goto L7;
            case 2131297574: goto L38;
            case 2131297575: goto L36;
            case 2131297576: goto L35;
            case 2131297577: goto L34;
            case 2131297578: goto L33;
            case 2131297579: goto L7;
            case 2131297580: goto L32;
            case 2131297581: goto L31;
            case 2131297582: goto L30;
            case 2131297583: goto L29;
            case 2131297584: goto L28;
            case 2131297585: goto L27;
            case 2131297586: goto L26;
            case 2131297587: goto L25;
            case 2131297588: goto L24;
            case 2131297589: goto L23;
            case 2131297590: goto L22;
            case 2131297591: goto L21;
            case 2131297592: goto L20;
            case 2131297593: goto L19;
            case 2131297594: goto L18;
            case 2131297595: goto L7;
            case 2131297596: goto L7;
            case 2131297597: goto L7;
            case 2131297598: goto L7;
            case 2131297599: goto L17;
            case 2131297600: goto L16;
            case 2131297601: goto L15;
            case 2131297602: goto L14;
            case 2131297603: goto L13;
            case 2131297604: goto L7;
            case 2131297605: goto L7;
            case 2131297606: goto L12;
            case 2131297607: goto L11;
            case 2131297608: goto L10;
            case 2131297609: goto L9;
            case 2131297610: goto L8;
            default: goto L7;
        };
    L7:
        return;
    L8:
        r4 = 29;
        r1 = NativePermissionManager.PERMISSION_WRITE_SETTINGS;
    L50:
        NativePermission r8 = NativePermissionManager.getPermissionByName(r1);
        if (r8 != null) goto L53;
    L55:
        if (r8 != null) goto L57;
    L59:
        r0.setAction(r3);
        r0.putExtra(Utils.INTENT_KEY_INDEX, r4);
    L60:
        r0.putExtra(Utils.INTENT_KEY_FROM_CENTER, isFromSecurityCenter());
        startActivity(r0);
        return;
    L57:
        if (r8.isSpecial() == false) goto L59;
        r0.setClass(this, SpecialRadioPermissionsActivity.class);
        r0.putExtra(Utils.INTENT_KEY_NATIVE_PERMISSION, r1);
        goto L60
    L53:
        if (r8.isDangerous() == false) goto L55;
        r0.setClass(this, NativeRadioPermissions.class);
        r0.putExtra(Utils.INTENT_KEY_NATIVE_PERMISSION, r1);
        goto L60
    L9:
        r4 = 22;
        r1 = NativePermissionManager.PERMISSION_BOOKMARK;
    L49:
        r3 = Utils.INTENT_ACTION_RADIO_PERMISSIONS_NEW;
        goto L50
    L10:
        String r9 = NativePermissionManager.PERMISSION_WRITE_CONTACTS;
    L47:
        r3 = null;
        r1 = r9;
        goto L50
    L11:
        r9 = NativePermissionManager.PERMISSION_WRITE_CALLLOG;
        goto L47
    L12:
        r9 = NativePermissionManager.PERMISSION_WRITE_CALENDAR;
        goto L47
    L13:
        r9 = NativePermissionManager.PERMISSION_VOICEMAIL;
        goto L47
    L14:
        r4 = 18;
        r1 = NativePermissionManager.PERMISSION_AUTOSTART;
        goto L50
    L15:
        r4 = 20;
        r1 = NativePermissionManager.PERMISSION_SYSTEM_WINDOW;
        goto L50
    L16:
        r9 = NativePermissionManager.PERMISSION_STORAGE_ALL;
        goto L47
    L17:
        r9 = NativePermissionManager.PERMISSION_STORAGE;
        goto L47
    L18:
        r4 = 28;
        r1 = NativePermissionManager.PERMISSION_START_ON_BACKGROUND;
        goto L50
    L19:
        r9 = NativePermissionManager.PERMISSION_SIP;
        goto L47
    L20:
        r4 = 26;
        r1 = NativePermissionManager.PERMISSION_SHOW_ON_KEYGUARD;
        goto L50
    L21:
        r9 = NativePermissionManager.PERMISSION_SENSORS;
        goto L47
    L22:
        r9 = NativePermissionManager.PERMISSION_SEND_SMS;
        goto L47
    L23:
        r9 = NativePermissionManager.PERMISSION_AUDIO;
        goto L47
    L24:
        r9 = NativePermissionManager.PERMISSION_RECIVE_SMS;
        goto L47
    L25:
        r4 = 19;
        r1 = NativePermissionManager.PERMISSION_RECIVE_BOOT_COMPLETE;
        goto L50
    L26:
        r9 = NativePermissionManager.PERMISSION_READ_SMS;
        goto L47
    L27:
        r9 = NativePermissionManager.PERMISSION_READ_PHONE_STATE;
        goto L47
    L28:
        r9 = NativePermissionManager.PERMISSION_READ_CONTACTS;
        goto L47
    L29:
        r9 = NativePermissionManager.PERMISSION_READ_CALLLOG;
        goto L47
    L30:
        r9 = NativePermissionManager.PERMISSION_READ_CALENDAR;
        goto L47
    L31:
        r9 = NativePermissionManager.PERMISSION_PROCESS_OUTGOING_CALLS;
        goto L47
    L32:
        String r10 = "android.settings.NOTIFICATION_POLICY_ACCESS_SETTINGS";
    L37:
        r3 = r10;
        goto L50
    L33:
        r4 = 11;
        r1 = NativePermissionManager.PERMISSION_NFC;
        goto L49
    L34:
        r4 = 14;
        r1 = NativePermissionManager.PERMISSION_ACCESS_WIFI;
        goto L50
    L35:
        r4 = 13;
        r1 = NativePermissionManager.PERMISSION_ACCESS_MOBILE;
        goto L50
    L36:
        r10 = "android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS";
        goto L37
    L38:
        r9 = NativePermissionManager.PERMISSION_LOCATION;
        goto L47
    L39:
        r4 = 21;
        r1 = NativePermissionManager.PERMISSION_KILL_BACKGROUND_PROCESSES;
        goto L50
    L40:
        r4 = 27;
        r1 = NativePermissionManager.PERMISSION_INSTALL_UNKONW_RESOURCE;
        goto L50
    L41:
        r9 = NativePermissionManager.PERMISSION_GET_ACCOUNTS;
        goto L47
    L42:
        r4 = 9;
        r1 = NativePermissionManager.PERMISSION_OPEN_WIFI;
        goto L49
    L43:
        r4 = 8;
        r1 = NativePermissionManager.PERMISSION_OPEN_MOBILE;
        goto L49
    L44:
        r9 = NativePermissionManager.PERMISSION_CAMERA;
        goto L47
    L45:
        r9 = NativePermissionManager.PERMISSION_PHONE;
        goto L47
    L46:
        r9 = NativePermissionManager.PERMISSION_BODY;
        goto L47
    L48:
        r4 = 10;
        r1 = NativePermissionManager.PERMISSION_BLUETOOTH;
        goto L49
    }

    @Override // com.bytedanceos.security.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        setItemsClicked(OpsManagerHelper.getInstance().getEnabled());
    }

    private void setItemsClicked(boolean enabled) {
        ArrayDeque r0 = new ArrayDeque();
        r0.add((ViewGroup) getWindow().getDecorView());
    L3:
        ViewGroup r1 = (ViewGroup) r0.remove();
        int r2 = r1.getChildCount();
        int r3 = 0;
    L4:
        if (r3 >= r2) goto L16;
        View r4 = r1.getChildAt(r3);
        if (r4 == null) goto L14;
        if (r4 == this.mTitleBarBackView) goto L12;
        r4.setEnabled(enabled);
    L12:
        if ((r4 instanceof ViewGroup) == false) goto L14;
        r0.add((ViewGroup) r4);
    L14:
        r3 = r3 + 1;
        goto L4
    L16:
        if (r0.isEmpty() == false) goto L3;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        updateViewWidth(R.id.ll_container);
    }
}
