/*
Name: Mardhiyah Ariqah Bte Mansoor
Student ID: 20023243
 */

package sg.edu.rp.c346.id20023243.c346assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class ItemListActivity extends AppCompatActivity {

    Spinner spnActionsType, spnFilter;
    EditText etIndex, etName, etExpire;
    Button btnAdd, btnUpdate, btnRemove;
    ListView lvProducts;
    ArrayList<String> alProducts;
    ArrayAdapter<String> aaProducts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);

        spnActionsType = findViewById(R.id.spinnerProducts);
        spnFilter = findViewById(R.id.spinnerMonthExpiry);
        etIndex = findViewById(R.id.editTextIndex);
        etName = findViewById(R.id.editTextProductName);
        etExpire = findViewById(R.id.editTextExpiryDate);
        btnAdd = findViewById(R.id.buttonAdd);
        btnUpdate = findViewById(R.id.buttonUpdate);
        btnRemove = findViewById(R.id.buttonRemove);
        lvProducts = findViewById(R.id.listViewProducts);


        alProducts = new ArrayList<>();
        alProducts.add("Expires 2022-09-03 Apple Macbook Pro");
        alProducts.add("Expires 2022-09-03 Apple Iphone XR");
        alProducts.add("Expires 2021-12-24 HP Spectre x360 15");
        alProducts.add("Expires 2022-02-13 Oppo A53");
        alProducts.add("Expires 2023-06-19 Samsung Galaxy S21");


        aaProducts = new ArrayAdapter<>(ItemListActivity.this, android.R.layout.simple_list_item_1, alProducts);

        lvProducts.setAdapter(aaProducts);

        spnActionsType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                switch(position) {
                    case 0: //add product
                        etIndex.setHint("-Not applicable-");
                        etName.setHint("Enter name of new product");
                        etExpire.setHint("Enter product expiry date (YYYY-MM-DD)");

                        etIndex.setEnabled(false);
                        etName.setEnabled(true);
                        etExpire.setEnabled(true);

                        btnAdd.setEnabled(true);
                        btnUpdate.setEnabled(false);
                        btnRemove.setEnabled(false);
                        break;

                    case 1: //update product
                        lvProducts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                etIndex.setText(""+position);
                            }
                        });
                        etIndex.setHint("Enter index of product to update");
                        etName.setHint("Enter updated product name ");
                        etExpire.setHint("Enter updated expiry date (YYYY-MM-DD)");

                        etIndex.setEnabled(true);
                        etName.setEnabled(true);
                        etExpire.setEnabled(true);

                        btnAdd.setEnabled(false);
                        btnUpdate.setEnabled(true);
                        btnRemove.setEnabled(false);
                        break;

                    case 2: //remove product
                        lvProducts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                etIndex.setText(""+position);
                            }
                        });
                        etIndex.setHint("Enter index of product to remove");
                        etName.setHint("-Not applicable-");
                        etExpire.setHint("-Not applicable-");

                        etIndex.setEnabled(true);
                        etName.setEnabled(false);
                        etExpire.setEnabled(false);

                        btnAdd.setEnabled(false);
                        btnUpdate.setEnabled(false);
                        btnRemove.setEnabled(true);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String productName = etName.getText().toString();
                String productExpire = etExpire.getText().toString();
                if (!productName.isEmpty() && !productExpire.isEmpty()) {
                    String newProduct = "Expires "+ productExpire +" "+productName;
                    alProducts.add(newProduct);
                    aaProducts.notifyDataSetChanged();
                    Collections.sort(alProducts);

                    etName.setText("");
                    etExpire.setText("");
                    Toast.makeText(ItemListActivity.this, "Product successfully added!", Toast.LENGTH_LONG).show();

                }
                else {
                    Toast.makeText(ItemListActivity.this, "Please enter BOTH product name & expiry date.", Toast.LENGTH_LONG).show();
                }


            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int productIndex = Integer.parseInt(etIndex.getText().toString());
                String productName = etName.getText().toString();
                String productExpire = etExpire.getText().toString();
                if (productIndex>=0 && productIndex<alProducts.size()) {

                    if (!productName.isEmpty() && !productExpire.isEmpty()) {
                        String newProduct = "Expires "+ productExpire +" "+productName;
                        alProducts.set(productIndex, newProduct);
                        aaProducts.notifyDataSetChanged();

                        etIndex.setText("");
                        etName.setText("");
                        etExpire.setText("");
                        Toast.makeText(ItemListActivity.this, "Product successfully updated!", Toast.LENGTH_LONG).show();

                    }

                    else {
                        Toast.makeText(ItemListActivity.this, "Please fill in all fields.", Toast.LENGTH_LONG).show();
                    }
                }
                else {
                    Toast.makeText(ItemListActivity.this, "Invalid index entered!", Toast.LENGTH_LONG).show();
                }

            }
        });

        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int productIndex = Integer.parseInt(etIndex.getText().toString());
                if (productIndex>=0 && productIndex<alProducts.size()) {
                    alProducts.remove(productIndex);
                    aaProducts.notifyDataSetChanged();

                    etIndex.setText("");
                    Toast.makeText(ItemListActivity.this, "Product successfully removed.", Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(ItemListActivity.this, "Invalid index entered!", Toast.LENGTH_LONG).show();
                }

            }
        });

        spnFilter.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                Collections.sort(alProducts);
                switch (position) {
                    case 0:
                        for (int i = 0; i<alProducts.size(); i++) {

                        }
                    case 1:
                    case 2:
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
}