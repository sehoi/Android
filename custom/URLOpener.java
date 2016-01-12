package com.stn.utils.etc;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import com.stn.utils.logging.Debug;

/**
 * class for open urls.
 *
 * @author sehoi
 * @since 2016. 1. 12..
 */
public class URLOpener {
    private final static String TAG = URLOpener.class.getSimpleName();

    public static void open(Context context, String url) {
        try {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            Uri uri = Uri.parse(url);
            intent.setData(uri);
            context.startActivity(intent);
        } catch (Exception e) {
            Debug.logE(TAG, "url: " + url);
            e.printStackTrace();
        }
    }
}
