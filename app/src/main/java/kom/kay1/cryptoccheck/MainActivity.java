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
    String crypto = "BTC";
    String req_url;
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

        //Volley requestQueue init
        final RequestQueue queue = Volley.newRequestQueue(this);
        //Request button init
        Button execute = (Button) findViewById(R.id.button);
        execute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                try {

                    if ((crypto.contentEquals("BTC")) && (spinner.getSelectedItem().toString().contentEquals("AED")))
                        req_url = BTC_AED;
                    else if ((crypto.contentEquals("BTC")) && (spinner.getSelectedItem().toString().contentEquals("ARS")))
                        req_url = BTC_ARS;
                    else if ((crypto.contentEquals("BTC")) && (spinner.getSelectedItem().toString().contentEquals("AUD")))
                        req_url = BTC_AUD;
                    else if ((crypto.contentEquals("BTC")) && (spinner.getSelectedItem().toString().contentEquals("BRL")))
                        req_url = BTC_BRL;
                    else if ((crypto.contentEquals("BTC")) && (spinner.getSelectedItem().toString().contentEquals("BSD")))
                        req_url = BTC_BSD;
                    else if ((crypto.contentEquals("BTC")) && (spinner.getSelectedItem().toString().contentEquals("CAD")))
                        req_url = BTC_CAD;
                    else if ((crypto.contentEquals("BTC")) && (spinner.getSelectedItem().toString().contentEquals("CNH")))
                        req_url = BTC_CNH;
                    else if ((crypto.contentEquals("BTC")) && (spinner.getSelectedItem().toString().contentEquals("EGP")))
                        req_url = BTC_EGP;
                    else if ((crypto.contentEquals("BTC")) && (spinner.getSelectedItem().toString().contentEquals("EUR")))
                        req_url = BTC_EUR;
                    else if ((crypto.contentEquals("BTC")) && (spinner.getSelectedItem().toString().contentEquals("GHS")))
                        req_url = BTC_GHS;
                    else if ((crypto.contentEquals("BTC")) && (spinner.getSelectedItem().toString().contentEquals("GPB")))
                        req_url = BTC_GPB;
                    else if ((crypto.contentEquals("BTC")) && (spinner.getSelectedItem().toString().contentEquals("HKD")))
                        req_url = BTC_HKD;
                    else if ((crypto.contentEquals("BTC")) && (spinner.getSelectedItem().toString().contentEquals("ILS")))
                        req_url = BTC_ILS;
                    else if ((crypto.contentEquals("BTC")) && (spinner.getSelectedItem().toString().contentEquals("INR")))
                        req_url = BTC_INR;
                    else if ((crypto.contentEquals("BTC")) && (spinner.getSelectedItem().toString().contentEquals("JPY")))
                        req_url = BTC_JPY;
                    else if ((crypto.contentEquals("BTC")) && (spinner.getSelectedItem().toString().contentEquals("KES")))
                        req_url = BTC_KES;
                    else if ((crypto.contentEquals("BTC")) && (spinner.getSelectedItem().toString().contentEquals("NGN")))
                        req_url = BTC_NGN;
                    else if ((crypto.contentEquals("BTC")) && (spinner.getSelectedItem().toString().contentEquals("PHP")))
                        req_url = BTC_PHP;
                    else if ((crypto.contentEquals("BTC")) && (spinner.getSelectedItem().toString().contentEquals("USD")))
                        req_url = BTC_USD;
                    else if ((crypto.contentEquals("BTC")) && ((spinner.getSelectedItem().toString().contentEquals("ZAR")))) {
                        req_url = BTC_ZAR;
                    }


                } finally {
                    //JSONObjectRequest Setup
        final JsonObjectRequest jsrequest = new JsonObjectRequest(Request.Method.GET, req_url, null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                TextView mlcd = (TextView) findViewById(R.id.display);
                mlcd.setText(crypto + "->" + (response.toString().replace("{", "").replace("}", "").replace("\"", "")));//whacked at the JSON string object with a spanner till it looked okay

            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "Error, Check connection and retry", Toast.LENGTH_SHORT).show();
            }
        });
                    // add to volley request queue
                queue.add(jsrequest);
                Toast.makeText(MainActivity.this, "Checking", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    }

















