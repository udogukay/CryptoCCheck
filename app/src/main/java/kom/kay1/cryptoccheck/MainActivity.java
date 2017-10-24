package kom.kay1.cryptoccheck;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    //JSON URL List-BITCOIN

    public static final String BTC_AED = "https://min-api.cryptocompare.com/data/price?fsym=BTC&tsyms=AED";
    public static final String BTC_ARS = "https://min-api.cryptocompare.com/data/price?fsym=BTC&tsyms=ARS";
    public static final String BTC_AUD = "https://min-api.cryptocompare.com/data/price?fsym=BTC&tsyms=AUD";
    public static final String BTC_BRL = "https://min-api.cryptocompare.com/data/price?fsym=BTC&tsyms=BRL";
    public static final String BTC_BSD = "https://min-api.cryptocompare.com/data/price?fsym=BTC&tsyms=BSD";
    public static final String BTC_CAD = "https://min-api.cryptocompare.com/data/price?fsym=BTC&tsyms=CAD";
    public static final String BTC_CNH = "https://min-api.cryptocompare.com/data/price?fsym=BTC&tsyms=CNH";
    public static final String BTC_EGP = "https://min-api.cryptocompare.com/data/price?fsym=BTC&tsyms=EGP";
    public static final String BTC_EUR = "https://min-api.cryptocompare.com/data/price?fsym=BTC&tsyms=EUR";
    public static final String BTC_GHS = "https://min-api.cryptocompare.com/data/price?fsym=BTC&tsyms=GHS";
    public static final String BTC_GPB = "https://min-api.cryptocompare.com/data/price?fsym=BTC&tsyms=GPB";
    public static final String BTC_HKD = "https://min-api.cryptocompare.com/data/price?fsym=BTC&tsyms=HKD";
    public static final String BTC_ILS = "https://min-api.cryptocompare.com/data/price?fsym=BTC&tsyms=ILS";
    public static final String BTC_INR = "https://min-api.cryptocompare.com/data/price?fsym=BTC&tsyms=INR";
    public static final String BTC_JPY = "https://min-api.cryptocompare.com/data/price?fsym=BTC&tsyms=JPY";
    public static final String BTC_KES = "https://min-api.cryptocompare.com/data/price?fsym=BTC&tsyms=KES";
    public static final String BTC_PHP = "https://min-api.cryptocompare.com/data/price?fsym=BTC&tsyms=PHP";
    public static final String BTC_USD = "https://min-api.cryptocompare.com/data/price?fsym=BTC&tsyms=USD";
    public static final String BTC_ZAR = "https://min-api.cryptocompare.com/data/price?fsym=BTC&tsyms=ZAR";
    public static final String ETH_AED = "https://min-api.cryptocompare.com/data/price?fsym=ETH&tsyms=AED";

    //JSON URL List-ETHEREUM
    public static final String ETH_ARS = "https://min-api.cryptocompare.com/data/price?fsym=ETH&tsyms=ARS";
    public static final String ETH_AUD = "https://min-api.cryptocompare.com/data/price?fsym=ETH&tsyms=AUD";
    public static final String ETH_BRL = "https://min-api.cryptocompare.com/data/price?fsym=ETH&tsyms=BRL";
    public static final String ETH_BSD = "https://min-api.cryptocompare.com/data/price?fsym=ETH&tsyms=BSD";
    public static final String ETH_CAD = "https://min-api.cryptocompare.com/data/price?fsym=ETH&tsyms=CAD";
    public static final String ETH_CNH = "https://min-api.cryptocompare.com/data/price?fsym=ETH&tsyms=CNH";
    public static final String ETH_EGP = "https://min-api.cryptocompare.com/data/price?fsym=ETH&tsyms=EGP";
    public static final String ETH_EUR = "https://min-api.cryptocompare.com/data/price?fsym=ETH&tsyms=EUR";
    public static final String ETH_GHS = "https://min-api.cryptocompare.com/data/price?fsym=ETH&tsyms=GHS";
    public static final String ETH_GPB = "https://min-api.cryptocompare.com/data/price?fsym=ETH&tsyms=GPB";
    public static final String ETH_HKD = "https://min-api.cryptocompare.com/data/price?fsym=ETH&tsyms=HKD";
    public static final String ETH_ILS = "https://min-api.cryptocompare.com/data/price?fsym=ETH&tsyms=ILS";
    public static final String ETH_INR = "https://min-api.cryptocompare.com/data/price?fsym=ETH&tsyms=INR";
    public static final String ETH_JPY = "https://min-api.cryptocompare.com/data/price?fsym=ETH&tsyms=JPY";
    public static final String ETH_KES = "https://min-api.cryptocompare.com/data/price?fsym=ETH&tsyms=KES";
    public static final String ETH_NGN = "https://min-api.cryptocompare.com/data/price?fsym=ETH&tsyms=NGN";
    public static final String ETH_PHP = "https://min-api.cryptocompare.com/data/price?fsym=ETH&tsyms=PHP";
    public static final String ETH_USD = "https://min-api.cryptocompare.com/data/price?fsym=ETH&tsyms=USD";
    public static final String ETH_ZAR = "https://min-api.cryptocompare.com/data/price?fsym=ETH&tsyms=ZAR";
    String BTC_NGN = "https://min-api.cryptocompare.com/data/price?fsym=BTC&tsyms=NGN";
    LinearLayout can;
    String crypto;

    String bitcoin = "BTC";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //set transparent layer for bg image
        can = (LinearLayout) findViewById(R.id.canvas_layout);

        //locate textview
        TextView tv = (TextView) findViewById(R.id.display);
        //locate ttf file and define as a font
        Typeface face = Typeface.createFromAsset(getAssets(), "fonts/lcdmono.ttf");
        //assign font to textview
        tv.setTypeface(face);

        // onClicklisteners for Cryptocurrency switch
        RadioButton btc = (RadioButton) findViewById(R.id.btcswitch);
        btc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Integrated bg image switch
                can.setBackgroundResource(R.drawable.bitcoinlogo);
                //String output for api input
                crypto = "BTC";
            }
        });

        RadioButton eth = (RadioButton) findViewById(R.id.ethswitch);
        eth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Integrated bg image switch
                can.setBackgroundResource(R.drawable.etherumlogo);
                //String output for api input
                crypto = "ETH";
            }
        });


        //spinner init
        final Spinner spinner = (Spinner) findViewById(R.id.currencyspinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.currency_array, android.R.layout.simple_spinner_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);


        String req_url = null;

        /*if ((crypto == "BTC") && (spinner.getSelectedItem().toString() == "AED")) req_url = BTC_AED;
        if ((crypto == "BTC") && (spinner.getSelectedItem().toString() == "ARS")) req_url = BTC_ARS;
        if ((crypto == "BTC") && (spinner.getSelectedItem().toString() == "AUD")) req_url = BTC_AUD;
        if ((crypto == "BTC") && (spinner.getSelectedItem().toString() == "BRL")) req_url = BTC_BRL;
        if ((crypto == "BTC") && (spinner.getSelectedItem().toString() == "BSD")) req_url = BTC_BSD;
        if ((crypto == "BTC") && (spinner.getSelectedItem().toString() == "CAD")) req_url = BTC_CAD;
        if ((crypto == "BTC") && (spinner.getSelectedItem().toString() == "CNH")) req_url =* BTC_CNH;
        if ((crypto == "BTC") && (spinner.getSelectedItem().toString() == "EGP")) req_url = BTC_EGP;
        if ((crypto == "BTC") && (spinner.getSelectedItem().toString() == "EUR")) req_url = BTC_EUR;
        if ((crypto == "BTC") && (spinner.getSelectedItem().toString() == "GHS")) req_url = BTC_GHS;
        if ((crypto == "BTC") && (spinner.getSelectedItem().toString() == "GPB")) req_url = BTC_GPB;
        if ((crypto == "BTC") && (spinner.getSelectedItem().toString() == "HKD")) req_url = BTC_HKD;
        if ((crypto == "BTC") && (spinner.getSelectedItem().toString() == "ILS")) req_url = BTC_ILS;
        if ((crypto == "BTC") && (spinner.getSelectedItem().toString() == "INR")) req_url = BTC_INR;
        if ((crypto == "BTC") && (spinner.getSelectedItem().toString() == "JPY")) req_url = BTC_JPY;
        if ((crypto == "BTC") && (spinner.getSelectedItem().toString() == "KES")) req_url = BTC_KES;
        if ((crypto == "BTC") && (spinner.getSelectedItem().toString() == "NGN")) req_url = BTC_NGN;
        if ((crypto == "BTC") && (spinner.getSelectedItem().toString() == "PHP")) req_url = BTC_PHP;
        if ((crypto == "BTC") && (spinner.getSelectedItem().toString() == "USD")) req_url = BTC_USD;*/
        //if ((crypto.equals(bitcoin)) && ((spinner.getSelectedItem().toString().equals("ZAR"))) ){req_url = BTC_ZAR;}
        if ((crypto != null) && (crypto.equals("BTC"))) req_url = BTC_NGN;


        final JsonObjectRequest jsrequest = new JsonObjectRequest(Request.Method.GET, req_url, null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                TextView mlcd = (TextView) findViewById(R.id.display);
                mlcd.setText((response.toString().replace("{", "").replace("}", "").replace("\"", "")));

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, bitcoin + " " + crypto + " ", Toast.LENGTH_SHORT).show();
                // TODO Auto-generated method stub


            }
        });


        //Volley request queue init
        final RequestQueue queue = Volley.newRequestQueue(this);
        Button execute = (Button) findViewById(R.id.button);
        execute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // add to request queue
                queue.add(jsrequest);
                Toast.makeText(MainActivity.this, "Checking", Toast.LENGTH_SHORT).show();
                /*ProgressDialog progress = new ProgressDialog(getApplication());
                progress.setMessage("One Moment....");
                progress.show();*/

            }
        });


    }

}














