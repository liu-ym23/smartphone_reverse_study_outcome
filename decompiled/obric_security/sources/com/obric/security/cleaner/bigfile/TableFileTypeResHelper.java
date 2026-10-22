package com.obric.security.cleaner.bigfile;

import com.obric.security.R;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class TableFileTypeResHelper {
    public static Map<String, Integer> FILE_RESOURCE;

    public TableFileTypeResHelper() {
    }

    static {
        HashMap r0 = new HashMap();
        FILE_RESOURCE = r0;
        r0.put("doc", Integer.valueOf(R.drawable.file_doc));
        FILE_RESOURCE.put("docm", Integer.valueOf(R.drawable.file_docm));
        FILE_RESOURCE.put("docx", Integer.valueOf(R.drawable.file_docx));
        FILE_RESOURCE.put("dot", Integer.valueOf(R.drawable.file_dot));
        FILE_RESOURCE.put("dotm", Integer.valueOf(R.drawable.file_dotm));
        FILE_RESOURCE.put("dotx", Integer.valueOf(R.drawable.file_dotx));
        FILE_RESOURCE.put("fodp", Integer.valueOf(R.drawable.file_fodp));
        FILE_RESOURCE.put("fods", Integer.valueOf(R.drawable.file_fods));
        FILE_RESOURCE.put("fodt", Integer.valueOf(R.drawable.file_fodt));
        FILE_RESOURCE.put("html", Integer.valueOf(R.drawable.file_html));
        FILE_RESOURCE.put("key", Integer.valueOf(R.drawable.file_key));
        FILE_RESOURCE.put("mht", Integer.valueOf(R.drawable.file_mht));
        FILE_RESOURCE.put("numbers", Integer.valueOf(R.drawable.file_numbers));
        FILE_RESOURCE.put("ods", Integer.valueOf(R.drawable.file_ods));
        FILE_RESOURCE.put("odp", Integer.valueOf(R.drawable.file_opd));
        FILE_RESOURCE.put("odt", Integer.valueOf(R.drawable.file_odt));
        FILE_RESOURCE.put("pages", Integer.valueOf(R.drawable.file_pages));
        FILE_RESOURCE.put("pdf", Integer.valueOf(R.drawable.file_pdf));
        FILE_RESOURCE.put("pot", Integer.valueOf(R.drawable.file_pot));
        FILE_RESOURCE.put("potx", Integer.valueOf(R.drawable.file_potx));
        FILE_RESOURCE.put("ppt", Integer.valueOf(R.drawable.file_ppt));
        FILE_RESOURCE.put("pptm", Integer.valueOf(R.drawable.file_pptm));
        FILE_RESOURCE.put("txt", Integer.valueOf(R.drawable.file_txt));
        FILE_RESOURCE.put("xls", Integer.valueOf(R.drawable.file_xls));
        FILE_RESOURCE.put("xlsx", Integer.valueOf(R.drawable.file_xlsx));
        FILE_RESOURCE.put("xlt", Integer.valueOf(R.drawable.file_xlt));
        FILE_RESOURCE.put("xltx", Integer.valueOf(R.drawable.file_xltx));
        FILE_RESOURCE.put("apk", Integer.valueOf(R.drawable.file_apk));
        FILE_RESOURCE.put("zip", Integer.valueOf(R.drawable.file_zip));
        FILE_RESOURCE.put("rar", Integer.valueOf(R.drawable.file_rar));
        FILE_RESOURCE.put("7z", Integer.valueOf(R.drawable.file_7z));
        FILE_RESOURCE.put("rtx", Integer.valueOf(R.drawable.file_rtx));
    }

    public static Integer getFileResource(String fileExtension) {
        boolean r0 = fileExtension.isEmpty();
        int r1 = R.drawable.file_unknown;
        if (r0 == true) goto L5;
        Integer r2 = FILE_RESOURCE.get(fileExtension);
        if (r2 == null) goto L11;
        r1 = r2.intValue();
    L11:
        return Integer.valueOf(r1);
    L5:
        return Integer.valueOf(R.drawable.file_unknown);
    }
}
