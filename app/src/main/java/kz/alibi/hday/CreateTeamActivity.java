package kz.alibi.hday;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.common.api.CommonStatusCodes;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;

import javax.net.ssl.HttpsURLConnection;

import kz.alibi.hday.gocr.OcrCaptureActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CreateTeamActivity extends AppCompatActivity {
    private static final int RC_OCR_CAPTURE = 9003;
    private RecyclerView recyclerView;
    private FloatingActionButton fab;
    private ArrayList<String> arrayList = new ArrayList<>();
    private java.util.List<Listz> usersLists = new ArrayList<>();
    private membersAdapter membersAdapter;
    public String tes = "";
    public static ApiManager apiManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team);
        apiManager = ApiManager.getInstance();
        final EditText editTeam = findViewById(R.id.name_team);
        final EditText editSect = findViewById(R.id.section);


        recyclerView = (RecyclerView) findViewById(R.id.rec_member_view);
        fab = findViewById(R.id.fab);


        RecyclerView.LayoutManager eLayoutManager = new LinearLayoutManager(getApplicationContext());
        Button button = findViewById(R.id.main_btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = editSect.getText().toString();
                String s1 = editTeam.getText().toString();

                ApiService api = RetrofitClient.getApiService();

                /**
                 * Calling JSON
                 */
                Call<UsersList> call = api.getMyJson();

                /**
                 * Enqueue Callback will be call when get response...
                 */
                call.enqueue(new Callback<UsersList>() {
                    @Override
                    public void onResponse(Call<UsersList> call, Response<UsersList> response) {


                        if (response.isSuccessful()) {
                            usersLists = response.body().getList();
                        }
                    }

                    @Override
                    public void onFailure(Call<UsersList> call, Throwable t) {

                    }
                });

                new SendRequest().execute();
            }
        });


        recyclerView.setLayoutManager(eLayoutManager);
        recyclerView.setKeepScreenOn(false);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), OcrCaptureActivity.class);
                intent.putExtra(OcrCaptureActivity.AutoFocus, true);
                intent.putExtra(OcrCaptureActivity.UseFlash, false);

                startActivityForResult(intent, RC_OCR_CAPTURE);
            }
        });


        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        myToolbar.setTitle("Создай команду!");
        setSupportActionBar(myToolbar);

    }

    /*******************/

    public class SendRequest extends AsyncTask<String, Void, String> {


        protected void onPreExecute() {
        }

        protected String doInBackground(String... arg0) {

            try {

                URL url = new URL("https://script.google.com/macros/s/AKfycbxI3uXtx7vS76YZ9ucd2gw3HuIHun9hK0oiu2x25CFMr-qpMGP8/exec");
                // https://script.google.com/macros/s/AKfycbyuAu6jWNYMiWt9X5yp63-hypxQPlg5JS8NimN6GEGmdKZcIFh0/exec
                JSONObject postDataParams = new JSONObject();

                //int i;
                //for(i=1;i<=70;i++)


                //    String usn = Integer.toString(i);

                String id = "18C90HMgpgw3nwNdBh1fccoFSqu299sMQs0EYv49P_No";

                postDataParams.put("name", "AAAAA");
                postDataParams.put("surname", "BBBB");
                postDataParams.put("id", id);


                Log.e("params", postDataParams.toString());

                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setReadTimeout(15000 /* milliseconds */);
                conn.setConnectTimeout(15000 /* milliseconds */);
                conn.setRequestMethod("POST");
                conn.setDoInput(true);
                conn.setDoOutput(true);

                OutputStream os = conn.getOutputStream();
                BufferedWriter writer = new BufferedWriter(
                        new OutputStreamWriter(os, "UTF-8"));
                writer.write(getPostDataString(postDataParams));

                writer.flush();
                writer.close();
                os.close();

                int responseCode = conn.getResponseCode();

                if (responseCode == HttpsURLConnection.HTTP_OK) {

                    BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    StringBuffer sb = new StringBuffer("");
                    String line = "";

                    while ((line = in.readLine()) != null) {

                        sb.append(line);
                        break;
                    }

                    in.close();
                    return sb.toString();

                } else {
                    return new String("false : " + responseCode);
                }
            } catch (Exception e) {
                return new String("Exception: " + e.getMessage());
            }
        }

        @Override
        protected void onPostExecute(String result) {
            Toast.makeText(getApplicationContext(), result,
                    Toast.LENGTH_LONG).show();

        }
    }

    public String getPostDataString(JSONObject params) throws Exception {

        StringBuilder result = new StringBuilder();
        boolean first = true;

        Iterator<String> itr = params.keys();

        while (itr.hasNext()) {

            String key = itr.next();
            Object value = params.get(key);

            if (first)
                first = false;
            else
                result.append("&");

            result.append(URLEncoder.encode(key, "UTF-8"));
            result.append("=");
            result.append(URLEncoder.encode(value.toString(), "UTF-8"));

        }
        return result.toString();
    }

    /***********/


    @Override
    protected void onResume() {
        super.onResume();

        Log.d("LC", "Resume" + arrayList.size());
        membersAdapter = new membersAdapter(arrayList);
        recyclerView.setAdapter(membersAdapter);
        membersAdapter.notifyDataSetChanged();
    }

    public void textCap(String text) {
        tes = text;
        arrayList.add(tes);
    }

    public String texts(String text) {
        return text;
    }

    @SuppressLint("StringFormatInvalid")
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == RC_OCR_CAPTURE) {
            if (resultCode == CommonStatusCodes.SUCCESS) {
                if (data != null) {
                    String text = data.getStringExtra(OcrCaptureActivity.TextBlockObject);
                    textCap(text);
                    Log.d("SOS", "Text read: " + text);
                } else {
                    // statusMessage.setText(R.string.ocr_failure);
                    Log.d("SOS", "No Text captured, intent data is null");
                }
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

}
