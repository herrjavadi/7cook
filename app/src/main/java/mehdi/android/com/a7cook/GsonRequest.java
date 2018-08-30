package mehdi.android.com.a7cook;

import android.net.http.HttpResponseCache;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.Gson;

import java.lang.reflect.Type;

public class GsonRequest<T> extends Request<T> {
    private Response.Listener<T> responseListener;
    private Gson gson = new Gson();
    //private Class<T> tClass;
    private Type type;

    public GsonRequest(int method, String url, Type type, Response.Listener<T> responseListener, @Nullable Response.ErrorListener errorListener) {
        super(method, url, errorListener);
        this.responseListener = responseListener;
        this.type = type;
    }

    @Override
    protected Response<T> parseNetworkResponse(NetworkResponse response) {
        try {
            String json = new String(response.data);
            return (Response<T>) Response.success(gson.fromJson(json, type), HttpHeaderParser.parseCacheHeaders(response));

        }catch (Exception e){
            return Response.error(new VolleyError(e));
        }

    }

    @Override
    protected void deliverResponse(T response) {
        responseListener.onResponse(response);


    }
}
