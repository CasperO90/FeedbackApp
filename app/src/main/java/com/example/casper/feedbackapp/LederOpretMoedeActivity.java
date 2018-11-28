package com.example.casper.feedbackapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class LederOpretMoedeActivity extends AppCompatActivity {

    private LinearLayout mLayout;
    private Button mButton,mButton2,mButton3;
    public static int a = 0;
    public static int c = 0;
    public int mødeID;
    EditText ed,ed1,ed2,ed3,ed4,ed5,ed6,ed7,ed8,ed9;
    public static String text,text1,text2,text3,text4,text5,text6,text7,text8,text9 ="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leder_opret_moede);

        // action bar
        getSupportActionBar().setTitle("Opret Møde"); // for set actionbar title
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // for add back arrow in action bar


        //Layout
        mLayout = findViewById(R.id.linearLayout);

        //opret knap
        mButton = (Button) findViewById(R.id.button);
        mButton.setOnClickListener(onClick());

        //intent smid datene videre
        mButton2 = (Button)findViewById(R.id.opretmødeBtn);
        mButton2.setOnClickListener(onClick());

        //slet
        mButton3 = (Button)findViewById(R.id.button4);
        mButton3.setOnClickListener(onClick());



    }


    public void opretPunkter(){
        if (createNewEditText().getTag().
                equals("a1")||createNewEditText().getTag().
                equals("a2")||createNewEditText().getTag().
                equals("a3")||createNewEditText().getTag().
                equals("a4")||createNewEditText().getTag().
                equals("a5")||createNewEditText().getTag().
                equals("a6")||createNewEditText().getTag().
                equals("a7")||createNewEditText().getTag().
                equals("a8")||createNewEditText().getTag().
                equals("a9")||createNewEditText().getTag().
                equals("a10")) {

            // mLayout.addView(createNewTextView());
            mLayout.addView(createNewEditText());

            if (createNewEditText().getTag().equals("a1")) {

                ed = (EditText) findViewById(c);
                ed.setHint("mødepuntk 1");
                c++;
            }

            else if (createNewEditText().getTag().equals("a2")) {
                ed1 = (EditText) findViewById(c);
                ed1.setHint("mødepunkt 2");
                c++;
            }

            else if (createNewEditText().getTag().equals("a3")) {
                ed2 = (EditText) findViewById(c);
                ed2.setHint("mødepunkt 3");
                c++;
            }

            else if (createNewEditText().getTag().equals("a4")) {
                ed3 = (EditText) findViewById(c);
                ed3.setHint("mødepunkt 4");
                c++;
            }

            else if (createNewEditText().getTag().equals("a5")) {
                ed4 = (EditText) findViewById(c);
                ed4.setHint("mødepunkt 5");
                c++;
            }

            else if (createNewEditText().getTag().equals("a6")) {
                ed5 = (EditText) findViewById(c);
                ed5.setHint("mødepunkt 6");
                c++;
            }

            else if (createNewEditText().getTag().equals("a7")) {
                ed6 = (EditText) findViewById(c);
                ed6.setHint("mødepunkt 7");
                c++;
            }

            else if (createNewEditText().getTag().equals("a8")) {
                ed7 = (EditText) findViewById(c);
                ed7.setHint("mødepunkt 8");
                c++;
            }

            else if (createNewEditText().getTag().equals("a9")) {
                ed8 = (EditText) findViewById(c);
                ed8.setHint("mødepunkt 9");
                c++;
            }

            else if (createNewEditText().getTag().equals("a10")) {
                ed9 = (EditText) findViewById(c);
                ed9.setHint("mødepunkt 10");
                c++;
            }
        }

        else {

            Toast.makeText(LederOpretMoedeActivity.this,
                    "Der kan ikke oprettes flere mødepunkter", Toast.LENGTH_LONG).show();
            a =10;
        }
    }

    public void overførTekst(){
        // hvis der kun bliver oprettet et felt kaster den nulpoint exception
        // jeg skal derfor lave noget defensiv programmering.

        if(createNewEditText().getTag().equals("a1")) {
            text = ed.getText().toString();

        }
        else if(createNewEditText().getTag().equals("a2")) {
            text = ed.getText().toString();
            text1 = ed1.getText().toString();
        }

        else if(createNewEditText().getTag().equals("a3")) {
            text = ed.getText().toString();
            text1 = ed1.getText().toString();
            text2 = ed2.getText().toString();
        }

        else if(createNewEditText().getTag().equals("a4")) {
            text = ed.getText().toString();
            text1 = ed1.getText().toString();
            text2 = ed2.getText().toString();
            text3 = ed3.getText().toString();
        }

        else if(createNewEditText().getTag().equals("a5")) {
            text = ed.getText().toString();
            text1 = ed1.getText().toString();
            text2 = ed2.getText().toString();
            text3 = ed3.getText().toString();
            text4 = ed4.getText().toString();
        }

        else if(createNewEditText().getTag().equals("a6")) {
            text = ed.getText().toString();
            text1 = ed1.getText().toString();
            text2 = ed2.getText().toString();
            text3 = ed3.getText().toString();
            text4 = ed4.getText().toString();
            text5 = ed5.getText().toString();
        }

        else if(createNewEditText().getTag().equals("a7")) {
            text = ed.getText().toString();
            text1 = ed1.getText().toString();
            text2 = ed2.getText().toString();
            text3 = ed3.getText().toString();
            text4 = ed4.getText().toString();
            text5 = ed5.getText().toString();
            text6 = ed6.getText().toString();
        }

        else if(createNewEditText().getTag().equals("a8")) {
            text = ed.getText().toString();
            text1 = ed1.getText().toString();
            text2 = ed2.getText().toString();
            text3 = ed3.getText().toString();
            text4 = ed4.getText().toString();
            text5 = ed5.getText().toString();
            text6 = ed6.getText().toString();
            text7 = ed7.getText().toString();
        }

        else if(createNewEditText().getTag().equals("a9")) {
            text = ed.getText().toString();
            text1 = ed1.getText().toString();
            text2 = ed2.getText().toString();
            text3 = ed3.getText().toString();
            text4 = ed4.getText().toString();
            text5 = ed5.getText().toString();
            text6 = ed6.getText().toString();
            text7 = ed7.getText().toString();
            text8 = ed8.getText().toString();
        }

        else if(createNewEditText().getTag().equals("a10")) {
            text = ed.getText().toString();
            text1 = ed1.getText().toString();
            text2 = ed2.getText().toString();
            text3 = ed3.getText().toString();
            text4 = ed4.getText().toString();
            text5 = ed5.getText().toString();
            text6 = ed6.getText().toString();
            text7 = ed7.getText().toString();
            text8 = ed8.getText().toString();
            text9 = ed9.getText().toString();
        }

        gåvidere();
    }

    public void sletPunkt(){
        if(createNewEditText().getTag().equals("a1")) {

            mLayout.removeView(ed);
            a--;
        }

        else if(createNewEditText().getTag().equals("a2")) {

            mLayout.removeView(ed1);
            a--;
        }

        else if(createNewEditText().getTag().equals("a3")) {
            mLayout.removeView(ed2);
            a--;
        }

        else if(createNewEditText().getTag().equals("a4")) {
            mLayout.removeView(ed3);
            a--;
        }

        else if(createNewEditText().getTag().equals("a5")) {
            mLayout.removeView(ed4);
            a--;
        }

        else if(createNewEditText().getTag().equals("a6")) {
            mLayout.removeView(ed5);
            a--;
        }

        else if(createNewEditText().getTag().equals("a7")) {
            mLayout.removeView(ed6);
            a--;
        }

        else if(createNewEditText().getTag().equals("a8")) {
            mLayout.removeView(ed7);
            a--;
        }

        else if(createNewEditText().getTag().equals("a9")) {
            mLayout.removeView(ed8);
            a--;
        }

        else if(createNewEditText().getTag().equals("a10")) {
            mLayout.removeView(ed9);
            a--;
        }
    }

    private View.OnClickListener onClick() {
        return new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                //add
                if (mButton == v) {
                    a++;
                    opretPunkter();
                }
                //overfør tekst
                else if (mButton2 == v){
                    overførTekst();
                }

                //slet
                else if(mButton3 == v) {
                    sletPunkt();
                }




            }
        };
    }
        /*
        private TextView createNewTextView() {
            final ViewGroup.LayoutParams lparams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            final TextView textView = new TextView(this);
            textView.setLayoutParams(lparams);

            textView.setText("Mødepunkt"+ a +":");



            return textView;
        }
*/

    private EditText createNewEditText(){
        final ViewGroup.LayoutParams lparams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        final EditText editText = new EditText(this);
        editText.setLayoutParams(lparams);
        editText.setHint("skriv dagsorden");
        editText.setInputType(InputType.TYPE_CLASS_TEXT);

        editText.setId(c);
        editText.setTag("a"+a);
        return editText;
    }

    public void gåvidere() {
        Intent intent = new Intent(LederOpretMoedeActivity.this, MoedeOprettet.class);
        startActivity(intent);
    }





    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // TODO Auto-generated method stub
        int id = item.getItemId();
        if (id == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

}