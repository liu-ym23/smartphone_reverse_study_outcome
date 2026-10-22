package com.android.server.pm.permission;

import android.content.pm.PackageManagerInternal;
import com.android.server.LocalServices;
import com.android.server.pm.pkg.AndroidPackage;
import com.obric.app.ObricAssistUtils;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ObricPermissionManagerServiceImpl implements IObricPermissionManagerService {
    private static final List<String> AIKERNEL_ALLOWED_PERMISSIONS = null;
    private static final String AIKERNEL_PACKAGE = "com.obric.aikernel";
    private static final String AIKERNEL_SIGNATURE = "308205b9308203a1a003020102021500e1df9877305a94fc38694a7757a12fed745be65e300d06092a864886f70d01010d05003065310e300c060355040613056368696e613110300e060355040813074265694a696e673110300e060355040913074265694a696e67310e300c060355040a13054f6365616e310e300c060355040b13054f6365616e310f300d060355040313067a61697a6169301e170d3236303431353133343830375a170d3436303431303133343830375a3065310e300c060355040613056368696e613110300e060355040813074265694a696e673110300e060355040913074265694a696e67310e300c060355040a13054f6365616e310e300c060355040b13054f6365616e310f300d060355040313067a61697a616930820222300d06092a864886f70d01010105000382020f003082020a0282020100f85a665e49d85236e1021bc495c97737b2f0886929e6e99d183a228bee850a7999337a134389cc11e03878b708cba0507537fbaa20d0bb46e06003e4fb47f4689f765256bfaa5f314a54cd96046bc89ce0189e3b4def6daab12db6b11824d1d39794cc4a974789e54f7c5b341484fb4088a867ee177e09eb84bf69ac2cf6164834bc7443386e241c6045c82bbafb1576ca610318206aa091bb84cb4ee59ebd7f59e3d8e4ee2a67a7d397cb739923f318ddd37c9743338edc39a1850440f27c49ffff02212a0c6910b85f18faafeac6a39b1f2e4afbd322809b5da4dc10442acc28f07e95ec6a625106dfb2fa18f7f4af0f189ce453fdfe5f660f5fedff0388f688c0e132d94e639b862c4e983c609ccfc1fb1953f9e50499abf2032396a59ac01c2c38af7d28f3f8133ed8a82265b6677c706aa15f5efa3164ded2f4fec77ab0825ba8a05be41af71368c86696fc760c269fa4a8540d7253ae0979cdbc1944b9b344ecf05103b3eb80c86ae48e590a0c5da78c7f1af1e57db65d0dbefdc93ed27c84f4a7f1bfcd5213b18622ee38d0dd7599fb849091686d6b30c9148e2e589d5ea9cda9cf56cba2555e9953981db907f2563705c5a91be863de564bb9831dc9ad7779d0cb005ac07c80830151190458b90a20dee5ab2ad2813cf2ff33997bf057e16645c91830f893a8494f1278f7bccf606fe544843cbb9c5f3441ff72786d0203010001a360305e300e0603551d0f0101ff040403020780300c0603551d130101ff04023000301d0603551d0e041604149a43dc78deb72a023820818c6c3d8508289626d7301f0603551d230418301680149a43dc78deb72a023820818c6c3d8508289626d7300d06092a864886f70d01010d05000382020100f19e0dd2e4d2101efc208eb67717dc45a17d84f74931cc7e9e30a3f8799920a629df85bf5691a542b0e6be270b430c9b579caa11f6c5e63b63d1160561bc7dec48d5ec46befa698511b961c479f066784c6bbca22e158966f9740e51ed9dcfd4054f5c52f158f1046bf246ba150e19be6dcc533c90bbb9ff11f62cd9a655d147e23f2be7cc33e6ae5e944d00156ad2c25811a88d352a2c68a1a31e26f9c828b20271b0f1f96312678aefcaf731bd6d9c5160d7a1770e072af84844a63c21dbb74b8b8b70a1c0d1dbf7f369bfbf05dd6eaa63b5da760faa076e54dbc2537c6b2c8fc8ed923a79c8f8fabc31cd2701ce9a8afd04946b8152d90aa8c308767efc53e2f2345a7b1564ba55ed64a37855c49204636ac877b40148482d18e359034fcd44df6c910ea8d429fc86be191d9ca8b034b7799d580fb9ce35ed71a795e79c093297e4593a2117e72d84597af99face1060c366db994e2017ef30e6c9a2dfa5d906a8967cc1041b09d3be417c72b252bb403900b6be651b17ddd35d0d5974b6e832c9649a4f65317dc714785e3c5ff2491bd4dc6b893b39a89a531eb14e855f000ea1e7f92d8ce6b669861e7f2a06637099b7d6f642b6547916585aff833b12a8621b14a886cfa8c15263fbda50957e6bffc9375b796252864333270ac9a2e1c0be66f7f7b6c25a20cd144dfac97f2a5e1c068e1659c481a1e980f025fa5f9b0";
    private static final List<String> ASSIST_ALLOWED_PERMISSIONS = null;
    private PermissionManagerService mBase;

    static {
        ASSIST_ALLOWED_PERMISSIONS = Arrays.asList(new String[]{"android.permission.INTERNET", "android.permission.READ_EXTERNAL_STORAGE", "android.permission.MONITOR_INPUT", "android.permission.READ_FRAME_BUFFER", "android.permission.INJECT_EVENTS", "android.permission.INTERNAL_SYSTEM_WINDOW", "android.permission.ACCESS_SHORTCUTS", "android.permission.ADD_ALWAYS_UNLOCKED_DISPLAY", "android.permission.CAPTURE_SECURE_VIDEO_OUTPUT", "android.permission.ADD_TRUSTED_DISPLAY", "android.permission.MANAGE_ACTIVITY_TASKS", "android.permission.REMOVE_TASKS", "android.permission.NETWORK_STACK", "android.permission.START_ANY_ACTIVITY", "android.permission.MANAGE_ROLE_HOLDERS", "android.permission.OBSERVE_ROLE_HOLDERS", "android.permission.GET_TOP_ACTIVITY_INFO", "com.obric.aiagent.executionengine.DISPATCH_INTENTS", "com.obric.aiagent.permission.ASSISTANT_IPC"});
        AIKERNEL_ALLOWED_PERMISSIONS = Arrays.asList(new String[]{"android.permission.MANAGE_ROLE_HOLDERS", "android.permission.OBSERVE_ROLE_HOLDERS"});
    }

    private static boolean isObricAIKernel(String packageName, String signature) {
        if (packageName.equals(AIKERNEL_PACKAGE) == true) goto L5;
    L7:
        return false;
    L5:
        if (signature.equals(AIKERNEL_SIGNATURE) == false) goto L7;
        return true;
    }

    public ObricPermissionManagerServiceImpl(PermissionManagerService base) {
        this.mBase = base;
    }

    public boolean checkObricAssistPermission(String permissionName, String packageName) {
        if (ObricAssistUtils.getAssistantPkgName().equals(packageName) == true) goto L5;
        return false;
    L5:
        PackageManagerInternal pkgInt = (PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class);
        if (pkgInt == null) goto L21;
        if (permissionName == null) goto L21;
        AndroidPackage pkg = pkgInt.getPackage(packageName);
        if (pkg != null) goto L12;
        return false;
    L12:
        String signature = pkg.getSigningDetails().getSignatures()[0].toCharsString();
        if (ObricAssistUtils.getAssistantSignature().equals(signature) == false) goto L17;
        return ASSIST_ALLOWED_PERMISSIONS.contains(permissionName);
    L17:
        if (isObricAIKernel(packageName, signature) == true) goto L19;
        return false;
    L19:
        return AIKERNEL_ALLOWED_PERMISSIONS.contains(permissionName);
    L21:
        return false;
    }

    public boolean checkObricAssistPermission(AndroidPackage pkg, String permissionName) {
        if (pkg == null) goto L17;
        if (permissionName == null) goto L17;
        String packageName = pkg.getPackageName();
        String signature = pkg.getSigningDetails().getSignatures()[0].toCharsString();
        if (ObricAssistUtils.getAssistantPkgName().equals(packageName) == false) goto L13;
        if (ObricAssistUtils.getAssistantSignature().equals(signature) == false) goto L13;
        return ASSIST_ALLOWED_PERMISSIONS.contains(permissionName);
    L13:
        if (isObricAIKernel(packageName, signature) == true) goto L15;
        return false;
    L15:
        return AIKERNEL_ALLOWED_PERMISSIONS.contains(permissionName);
    L17:
        return false;
    }
}
