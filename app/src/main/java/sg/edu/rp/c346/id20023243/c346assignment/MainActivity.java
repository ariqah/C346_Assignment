/*
Name: Mardhiyah Ariqah Bte Mansoor
Student ID: 20023243
 */

package sg.edu.rp.c346.id20023243.c346assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvWelcome, tvIntro,tvHeader, tvSamsungS21, tvAppleMacPro, tvHpSpectre15, tvOppoA53;
    Button btnSamsungS21, btnOppoA53, btnHpSpectre15, btnMacBookPro, btnViewList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvWelcome = findViewById(R.id.textViewWelcome);
        tvIntro = findViewById(R.id.textViewIntro);
        tvHeader = findViewById(R.id.textViewHeader);
        tvSamsungS21 = findViewById(R.id.textViewSamsungS21);
        tvAppleMacPro = findViewById(R.id.textViewMacPro);
        tvHpSpectre15 = findViewById(R.id.textViewHpSpectre15);
        tvOppoA53 = findViewById(R.id.textViewOppoA53);


        btnSamsungS21 = findViewById(R.id.buttonSamsung);
        btnSamsungS21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intentOpenUrl = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.samsung.com/sg/smartphones/galaxy-s21-ultra-5g/"));
                startActivity(intentOpenUrl);

            }
        });

        btnOppoA53 = findViewById(R.id.buttonOppo);
        btnOppoA53.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intentOpenUrl = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.oppo.com/sg/smartphones/series-a/a53/"));
                startActivity(intentOpenUrl);
            }
        });

        btnHpSpectre15 = findViewById(R.id.buttonHP);
        btnHpSpectre15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intentOpenUrl = new Intent(Intent.ACTION_VIEW, Uri.parse("https://store.hp.com/sg-en/default/hp-spectre-x360-laptop-15-eb0017tx-3r476pa.html"));
                startActivity(intentOpenUrl);

            }
        });

        btnMacBookPro = findViewById(R.id.buttonApple);
        btnMacBookPro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intentOpenUrl = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.apple.com/sg/macbook-pro/?afid=p238%7CsXuzVT09e-dc_mtid_18707vxu38484_pcrid_487089490213_pgrid_76500432375_&cid=aos-sg-kwgo-mac--slid---product--"));
                startActivity(intentOpenUrl);

            }
        });

        btnViewList = findViewById(R.id.buttonViewProductList);
        btnViewList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, ItemListActivity.class);
                startActivity(intent);
            }
        });




    }
}