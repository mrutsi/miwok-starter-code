package com.example.android.miwok;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import static com.example.android.miwok.R.id.XiTsonga;

public class MainActivity extends AppCompatActivity {

//global variables
    TextView numbers,family, colors, phrases;
    String numberText= "",familyText="",colorText="",phraseText="";
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor sharedPrefEditor;
    String category_language="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);

      /*
       // getSupportActionBar().setHomeButtonEnabled(true);
     //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setIcon(R.drawable.vendaicon);
        getSupportActionBar().setTitle("miwak");
       // getSupportActionBar().setHomeAsUpIndicator(R.drawable.vendaicon);
        //getSupportActionBar().setIcon(R.drawable.vendaicon);

        */

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        //  NumbersClickListener clickListener=new NumbersClickListener();
         numbers=(TextView)findViewById(R.id.numbers);
         family=(TextView) findViewById(R.id.family);
         colors=(TextView) findViewById(R.id.colors);
         phrases=(TextView) findViewById(R.id.phrases);


        //numbers
        numbers.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent numberIntent=new Intent(MainActivity.this,NumbersActivity.class);
                startActivity(numberIntent);
                //.putExtra("chan_language",category_language)
            }
        });

        //family
        family.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent familyIntent=new Intent(MainActivity.this,FamilyActivity.class);
                startActivity(familyIntent.putExtra("chan_language",category_language));
            }
        });

        //colors
        colors.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent colorIntent=new Intent(MainActivity.this,ColorsActivity.class);
                startActivity(colorIntent.putExtra("chan_language",category_language));
            }
        });

//phrases
        phrases.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent phraseIntent=new Intent(MainActivity.this,PhrasesActivity.class);
                startActivity(phraseIntent.putExtra("chan_language",category_language));

            }
        });
    }


//to remember language
    @Override
    protected void onResume() {
        super.onResume();
        updateLanguage();
    }


//optional menu
@Override
public boolean onCreateOptionsMenu(Menu menu) {
    MenuInflater inflater = getMenuInflater();
    inflater.inflate(R.menu.menu, menu);
    return true;
}

//optional menu functionality

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId())
        {
            //tshivenda language
            case R.id.Tshivenda:
                sharedPrefEditor = sharedPreferences.edit();
                sharedPrefEditor.putString("language","Tshivenda");
                sharedPrefEditor.apply();
                updateLanguage();
                return true;

            //XiTsonga language
            case XiTsonga:
                sharedPrefEditor = sharedPreferences.edit();
                sharedPrefEditor.putString("language","XiTsonga");
                sharedPrefEditor.apply();
                updateLanguage();
                return true;

           // Sipedi language
            case R.id.Sipedi:
                sharedPrefEditor = sharedPreferences.edit();
                sharedPrefEditor.putString("language","Sipedi");
                sharedPrefEditor.apply();
                updateLanguage();
                return true;

            case R.id.IsiZulu:
                sharedPrefEditor = sharedPreferences.edit();
                sharedPrefEditor.putString("language","IsiZulu");
                sharedPrefEditor.apply();
                updateLanguage();
                return true;

            case R.id.isiXhosa:
                sharedPrefEditor = sharedPreferences.edit();
                sharedPrefEditor.putString("language","isiXhosa");
                sharedPrefEditor.apply();
                updateLanguage();
                return true;


            case R.id.Afrikaans:
                sharedPrefEditor = sharedPreferences.edit();
                sharedPrefEditor.putString("language","Afrikaans");
                sharedPrefEditor.apply();
                updateLanguage();
                return true;

            case R.id.Sesotho:
                sharedPrefEditor = sharedPreferences.edit();
                sharedPrefEditor.putString("language","Sesotho");
                sharedPrefEditor.apply();
                updateLanguage();
                return true;

            case R.id.Setswana:
                sharedPrefEditor = sharedPreferences.edit();
                sharedPrefEditor.putString("language","Setswana");
                sharedPrefEditor.apply();
                updateLanguage();
                return true;

            case R.id.SiSwati:
                sharedPrefEditor = sharedPreferences.edit();
                sharedPrefEditor.putString("language","SiSwati");
                sharedPrefEditor.apply();
                updateLanguage();
                return true;

            case R.id.IsiNdebele:
                sharedPrefEditor = sharedPreferences.edit();
                sharedPrefEditor.putString("language","IsiNdebele");
                sharedPrefEditor.apply();
                updateLanguage();
                return true;

            case R.id.English:
                sharedPrefEditor = sharedPreferences.edit();
                sharedPrefEditor.putString("language","English");
                sharedPrefEditor.apply();
                updateLanguage();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    public void updateLanguage() {

        String selected_language = sharedPreferences.getString("language","");

        switch (selected_language) {
            case "Tshivenda":

               // Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
             //   setSupportActionBar(toolbar);
               // getSupportActionBar().setDisplayUseLogoEnabled(true);

                getSupportActionBar().setSubtitle("Luambo lwa Tshivenda");

                category_language ="Tshivenda";
                numberText = "Nomboro";
                familyText = "mirado ya Muta";
                colorText = "Mivhala";
                phraseText = "Mitaladzi";
                break;

            case "XiTsonga":
                getSupportActionBar().setSubtitle("Ndzimi Ya XiTsonga");
                category_language ="XiTsonga";
                numberText = "Tinhlayo";
                familyText = "Vondyanga";
                colorText = "Mihlovo";
                phraseText = "Timhako";
                break;

            case "Sipedi":
                getSupportActionBar().setSubtitle("Polelo Ya Sepedi");
                category_language ="Sipedi";
                numberText = "Nomoro";
                familyText = "Litho tsa Lelapa";
                colorText = "Mebala";
                phraseText = "Dipolelwana";
                break;


            case "IsiZulu":
                getSupportActionBar().setSubtitle("Ulimi lwe Zulu");
                category_language ="IsiZulu";
                numberText = "Inomoro";
                familyText = " Umdwni";
                colorText = "Imibala ";
                phraseText = "Imishwana";
                break;


            case "isiXhosa":
                getSupportActionBar().setSubtitle("Ulwimi lwe Sixhosa");
                category_language ="isiXhosa";
                numberText = "Amanani";
                familyText = "Amalungu Osapho";
                colorText = "Imibala";
                phraseText = "Ibizana";
                break;

            case "Afrikaans":
                getSupportActionBar().setSubtitle("Afrikaanse taal");
                category_language ="Afrikaans";
                numberText = "aantal";
                familyText = "Familielede";
                colorText = "Kleure";
                phraseText = "Frases";
                break;


            case "Sesotho":
                getSupportActionBar().setSubtitle("Puo ea Sesotho");
                category_language ="Sesotho";
                numberText = "Dipalo";
                familyText = "Maloko A Lelapa";
                colorText = "Mebala";
                phraseText = "Mafoko";
                break;

            case "Setswana":
                getSupportActionBar().setSubtitle("Puo ya Setwana");
                category_language ="Setswana";
                numberText = "Dipalo";
                familyText = "Maloko A Lelapa";
                colorText = "Mebale";
                phraseText = "Mafoko";
                break;

            case "IsiNdebele":
                getSupportActionBar().setSubtitle("Ilimu le Sindebele");
                category_language ="IsiNdebele";
                numberText = "Inomboro";
                familyText = "Umndeni";
                colorText = "Imibala";
                phraseText = "Izitho";
                break;

            case "SiSwati":
                getSupportActionBar().setSubtitle("Lulwimi le Siswati");
                category_language ="SiSwati";
                numberText = "Inomboro";
                familyText = "Umndeni";
                colorText = "Imibala";
                phraseText = "Izitho";
                break;

            case "English":
                getSupportActionBar().setSubtitle("English Language");
            category_language ="English";
            numberText = "Number";
            familyText = "Family Members";
            colorText = "Colors";
            phraseText = "Phrases";

            default:
                getSupportActionBar().setSubtitle("English Language");
                category_language ="English";
                numberText = "Number";
                familyText = "Family Members";
                colorText = "Colors";
                phraseText = "Phrases";
                break;
        }

      //  getSupportActionBar().setTitle(app_name);
        getSupportActionBar().setSubtitle("English Language");
        numbers.setText(numberText);
        family.setText(familyText);
        colors.setText(colorText);
        phrases.setText(phraseText);
    }

}







