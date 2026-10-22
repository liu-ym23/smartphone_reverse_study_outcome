package com.bytedanceos.security;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import com.bytedanceos.security.multi.adpter.MultiSdkAdapter;
import com.bytedanceos.utils.Constants;
import com.obric.oui.lisitem.OListItemSettings;
import com.obric.security.R;

/* JADX INFO: loaded from: classes2.dex */
public class PermissionCategoryActivity extends BaseActivity implements View.OnClickListener {
    private int animInLeft;
    private int animInRight;
    private int animOutLeft;
    private int animOutRight;
    private OListItemSettings mCategoryApp;
    private OListItemSettings mCategoryPermission;
    protected boolean mFromSecurityCenter;

    public PermissionCategoryActivity() {
    }

    @Override // com.bytedanceos.security.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.permission_category_layout);
        this.mFromSecurityCenter = isFromSecurityCenter();
        initTitleBar(false);
        OListItemSettings r1 = (OListItemSettings) findViewById(R.id.category_app);
        this.mCategoryApp = r1;
        if (r1 == null) goto L5;
        r1.setOnClickListener(this);
    L5:
        OListItemSettings r2 = (OListItemSettings) findViewById(R.id.category_permission);
        this.mCategoryPermission = r2;
        if (r2 == null) goto L8;
        r2.setOnClickListener(this);
    L8:
        updateViewWidth(R.id.ll_container);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (Utils.isFastDoubleClick() == false) goto L5;
        return;
    L5:
        Intent r0 = new Intent();
        r0.setAction("android.intent.action.MAIN");
        r0.putExtra("back_text_res_name", "permission_management");
        r0.putExtra(Utils.INTENT_KEY_FROM_CENTER, this.mFromSecurityCenter);
        switch(view.getId()) {
            case 2131296622: goto L12;
            case 2131296623: goto L9;
            default: goto L13;
        };
    L12:
        r0.setAction(Utils.INTENT_ACTION_PACKAGE_OVERVIEW);
    L13:
        r0.putExtra(Constants.EXTRA_BYTEDANCE_ANIM_RESOURCE_ID, new int[]{this.animInLeft, this.animOutRight});
        startActivity(r0);     // Catch: Exception -> L16
        return;
    L16:
        e = move-exception;
        e.printStackTrace();
        return;
    L9:
        if (MultiSdkAdapter.sdkIsBeforeO() == true) goto L13;
        r0.setClassName("com.obric.security", "com.bytedanceos.security.permission.NativePermissionsActivity");
        goto L13
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        updateViewWidth(R.id.ll_container);
    }
}
