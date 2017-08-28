package com.example.android.miwok;


import android.content.Context;
import android.content.SharedPreferences;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity
{
    private MediaPlayer mMediaPlayer ;
    private AudioManager mAudioManager;
    String chan_language;
    String app_subTitle="";
    SharedPreferences sharedPreferences;
    //SharedPreferences.Editor sharedPrefEditor;

    AudioManager.OnAudioFocusChangeListener afChangeListener=new AudioManager.OnAudioFocusChangeListener(){
        public void onAudioFocusChange(int focusChange){

            if (focusChange==AudioManager.AUDIOFOCUS_LOSS_TRANSIENT||focusChange==AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK){
                mMediaPlayer.pause();
                mMediaPlayer.seekTo(0);
            }else if(focusChange==AudioManager.AUDIOFOCUS_GAIN){
                //RESUME playback
                mMediaPlayer.start();
            }else if(focusChange==AudioManager.AUDIOFOCUS_LOSS){

                releaseMediaPlayer();
            }

        }
    };

    private MediaPlayer.OnCompletionListener mOnCompletionListener= new MediaPlayer.OnCompletionListener(){
        @Override
        public void onCompletion(MediaPlayer mp){

            releaseMediaPlayer();
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        //create and setup the {@link audiomanager}to request audio focus
        mAudioManager=(AudioManager)getSystemService(Context.AUDIO_SERVICE);

       //back button bar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //get intent from main activity
      //  Intent intent = getIntent();
       // chan_language = intent.getStringExtra("chan_language");





        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        chan_language = sharedPreferences.getString("language","");

        //create an array of words
        final ArrayList<Word>words=new ArrayList<Word>();
        switch (chan_language)
        {

            case "Tshivenda":
                //Tshivenda
                getSupportActionBar().setSubtitle("Nomboro");
                words.add(new Word("one", "Thihi", R.drawable.number_one, R.raw.nthihi));
                words.add(new Word("two", "Mbili", R.drawable.number_two, R.raw.mbili));
                words.add(new Word("three", "Raru", R.drawable.number_three, R.raw.raru));
                words.add(new Word("four", "Ina", R.drawable.number_four, R.raw.ina));
                words.add(new Word("five", "Thanu", R.drawable.number_five, R.raw.thanu));
                words.add(new Word("six", "Rathi", R.drawable.number_six, R.raw.rathi));
                words.add(new Word("seven", "Sumbe", R.drawable.number_seven, R.raw.sumbe));
                words.add(new Word("eight", "Malo", R.drawable.number_eight, R.raw.malo));
                words.add(new Word("nine", "Thahe", R.drawable.number_nine, R.raw.tahe));
                words.add(new Word("ten", "Fumi", R.drawable.number_ten, R.raw.fumi));
                break;


            case "Sipedi":
                //Sipedi
                getSupportActionBar().setSubtitle("Nomoro");
                words.add(new Word("one", "tee", R.drawable.number_one, R.raw.tee));
                words.add(new Word("two", "pedi", R.drawable.number_two, R.raw.pedi));
                words.add(new Word("three", "tharo", R.drawable.number_three, R.raw.tharo));
                words.add(new Word("four", "nne", R.drawable.number_four, R.raw.nne));
                words.add(new Word("five", "hlano", R.drawable.number_five, R.raw.thlano));
                words.add(new Word("six", "tshela", R.drawable.number_six, R.raw.tshela));
                words.add(new Word("seven", "supa", R.drawable.number_seven, R.raw.supa));
                words.add(new Word("eight", "seswai", R.drawable.number_eight, R.raw.seswai));
                words.add(new Word("nine", "senyane", R.drawable.number_nine, R.raw.senyane));
                words.add(new Word("ten", "lesome", R.drawable.number_ten, R.raw.lesome));
                break;

            case "isiXhosa":
                //IsiXhosa
                getSupportActionBar().setSubtitle("Amanani");
                words.add(new Word("One", "Nye", R.drawable.number_one, R.raw.xhosa_one));
                words.add(new Word("Two", "Mbini", R.drawable.number_two, R.raw.xhosa_two));
                words.add(new Word("Three", "Ntathu", R.drawable.number_three, R.raw.xhosa_three));
                words.add(new Word("Four", "Ne", R.drawable.number_four, R.raw.xhosa_four));
                words.add(new Word("Five", "Hlanu", R.drawable.number_five, R.raw.xhosa_five));
                words.add(new Word("Six", "Thandathu", R.drawable.number_six, R.raw.xhosa_six));
                words.add(new Word("Seven", "Sixhenxe", R.drawable.number_seven, R.raw.xhosa_seven));
                words.add(new Word("Eight", "Bhozo", R.drawable.number_eight, R.raw.xhosa_eight));
                words.add(new Word("Nine", "Lithoba", R.drawable.number_nine, R.raw.xhosa_one));//wrong
                words.add(new Word("Ten", "Lishumi", R.drawable.number_ten, R.raw.nde_ten));
                break;

            case "IsiNdebele":
                //IsiNdebele
                getSupportActionBar().setSubtitle("Inomboro");
                words.add(new Word("One", "Kunye", R.drawable.number_one, R.raw.nde_one));
                words.add(new Word("Two", "Kubili", R.drawable.number_two, R.raw.nde_two));
                words.add(new Word("Three", "Kuthathu", R.drawable.number_three, R.raw.nde_three));
                words.add(new Word("Four", "Kune", R.drawable.number_four, R.raw.nde_four));
                words.add(new Word("Five", "Kuhlanu", R.drawable.number_five, R.raw.nde_five));
                words.add(new Word("Six", "Sithandathu", R.drawable.number_six, R.raw.nde_six));
                words.add(new Word("Seven", "Likhomba", R.drawable.number_seven, R.raw.nde_seven));
                words.add(new Word("Eight", "Bunane", R.drawable.number_eight, R.raw.nde_eight));
                words.add(new Word("Nine", "Lithoba", R.drawable.number_nine, R.raw.nde_nine));
                words.add(new Word("Ten", "Itjhumi", R.drawable.number_ten, R.raw.nde_ten));
                break;

            case "XiTsonga":
                //XiTsonga
                getSupportActionBar().setSubtitle("Tinhlayo");
                words.add(new Word("one", "n'we", R.drawable.number_one, R.raw.number_one));
                words.add(new Word("two", "mbirhi", R.drawable.number_two, R.raw.number_two));
                words.add(new Word("three", "nharhu", R.drawable.number_three, R.raw.number_three));
                words.add(new Word("four", "mune", R.drawable.number_four, R.raw.number_four));
                words.add(new Word("five", "ntlhanu", R.drawable.number_five, R.raw.number_five));
                words.add(new Word("six", "tsevu", R.drawable.number_six, R.raw.number_six));
                words.add(new Word("seven", "nkombo", R.drawable.number_seven, R.raw.number_seven));
                words.add(new Word("eight", "nhungu", R.drawable.number_eight, R.raw.number_eight));
                words.add(new Word("nine", "kaye", R.drawable.number_nine, R.raw.number_nine));
                words.add(new Word("ten", "khume", R.drawable.number_ten, R.raw.number_ten));
                break;



            case "English":
                //english
                getSupportActionBar().setSubtitle("Number");
                words.add(new Word("one", "lutti", R.drawable.number_one, R.raw.number_one));
                words.add(new Word("two", "otiiko", R.drawable.number_two, R.raw.number_two));
                words.add(new Word("three", "tolookosu", R.drawable.number_three, R.raw.number_three));
                words.add(new Word("four", "Oyyisa", R.drawable.number_four, R.raw.number_four));
                words.add(new Word("five", "massokka", R.drawable.number_five, R.raw.number_five));
                words.add(new Word("six", "temmokka", R.drawable.number_six, R.raw.number_six));
                words.add(new Word("seven", "kenekaku", R.drawable.number_seven, R.raw.number_seven));
                words.add(new Word("eight", "kawinta", R.drawable.number_eight, R.raw.number_eight));
                words.add(new Word("nine", "wo'e", R.drawable.number_nine, R.raw.number_nine));
                words.add(new Word("ten", "na'aacha", R.drawable.number_ten, R.raw.number_ten));
                break;


            case "IsiZulu":
                //IsiZulu
                app_subTitle = "Inomoro";
                getSupportActionBar().setSubtitle(app_subTitle);
                words.add(new Word("One", "Kunye", R.drawable.number_one, R.raw.number_one));
                words.add(new Word("Two", "Kubili", R.drawable.number_two, R.raw.number_two));
                words.add(new Word("Three", "Kuthathu", R.drawable.number_three, R.raw.number_three));
                words.add(new Word("Four", "Kune", R.drawable.number_four, R.raw.number_four));
                words.add(new Word("Five", "Kuhlanu", R.drawable.number_five, R.raw.number_five));
                words.add(new Word("Six", "Isithupa", R.drawable.number_six, R.raw.number_six));
                words.add(new Word("Seven", "Isikhombisa", R.drawable.number_seven, R.raw.number_seven));
                words.add(new Word("Eight", "Isishiyagalombili", R.drawable.number_eight, R.raw.number_eight));
                words.add(new Word("Nine", "Isishiyagalolunye", R.drawable.number_nine, R.raw.number_nine));
                words.add(new Word("Ten", "Ishumi", R.drawable.number_ten, R.raw.number_ten));
                break;




            case "Afrikaans":
                //Afrikaans
                getSupportActionBar().setSubtitle("aantal");
                words.add(new Word("One", "Een", R.drawable.number_one, R.raw.number_one));
                words.add(new Word("Two", "Twee", R.drawable.number_two, R.raw.number_two));
                words.add(new Word("Three", "Drie", R.drawable.number_three, R.raw.number_three));
                words.add(new Word("Four", "Vier", R.drawable.number_four, R.raw.number_four));
                words.add(new Word("Five", "Vyf", R.drawable.number_five, R.raw.number_five));
                words.add(new Word("Six", "Ses", R.drawable.number_six, R.raw.number_six));
                words.add(new Word("Seven", "Sewe", R.drawable.number_seven, R.raw.number_seven));
                words.add(new Word("Eight", "Agt", R.drawable.number_eight, R.raw.number_eight));
                words.add(new Word("Nine", "Nege", R.drawable.number_nine, R.raw.number_nine));
                words.add(new Word("Ten", "Tien", R.drawable.number_ten, R.raw.number_ten));
                break;


            case "Sesotho":
                //Sesotho
                getSupportActionBar().setSubtitle("Dipalo");
                words.add(new Word("one", "Tee", R.drawable.number_one, R.raw.number_one));
                words.add(new Word("two", "Pedi", R.drawable.number_two, R.raw.number_two));
                words.add(new Word("three", "Tharo", R.drawable.number_three, R.raw.number_three));
                words.add(new Word("four", "Nne", R.drawable.number_four, R.raw.number_four));
                words.add(new Word("five", "Tlhano", R.drawable.number_five, R.raw.number_five));
                words.add(new Word("six", "Tshelela", R.drawable.number_six, R.raw.number_six));
                words.add(new Word("seven", "Supa", R.drawable.number_seven, R.raw.number_seven));
                words.add(new Word("eight", "Robedi", R.drawable.number_eight, R.raw.number_eight));
                words.add(new Word("nine", "Robong", R.drawable.number_nine, R.raw.number_nine));
                words.add(new Word("ten", "Leshome", R.drawable.number_ten, R.raw.number_ten));
                break;

            case "Setswana":
                //Setswana
                getSupportActionBar().setSubtitle("Dipalo");
                words.add(new Word("One", "Nngwe", R.drawable.number_one, R.raw.number_one));
                words.add(new Word("Two", "Bedi", R.drawable.number_two, R.raw.number_two));
                words.add(new Word("Three", "Raro", R.drawable.number_three, R.raw.number_three));
                words.add(new Word("Four", "Nne", R.drawable.number_four, R.raw.number_four));
                words.add(new Word("Five", "Tlhano", R.drawable.number_five, R.raw.number_five));
                words.add(new Word("Six", "Rataro", R.drawable.number_six, R.raw.number_six));
                words.add(new Word("Seven", "Supa", R.drawable.number_seven, R.raw.number_seven));
                words.add(new Word("Eight", "Robabobedi", R.drawable.number_eight, R.raw.number_eight));
                words.add(new Word("Nine", "Robabongwe", R.drawable.number_nine, R.raw.number_nine));
                words.add(new Word("Ten", "Lesome", R.drawable.number_ten, R.raw.number_ten));
                break;


            case "SiSwati":
                //SiSwati
                getSupportActionBar().setSubtitle("Inomboro");
                words.add(new Word("One", "Kunye", R.drawable.number_one, R.raw.number_one));
                words.add(new Word("Two", "Kubili", R.drawable.number_two, R.raw.number_two));
                words.add(new Word("Three", "Kutsatfu", R.drawable.number_three, R.raw.number_three));
                words.add(new Word("Four", "Kune", R.drawable.number_four, R.raw.number_four));
                words.add(new Word("Five", "Kusihlanu", R.drawable.number_five, R.raw.number_five));
                words.add(new Word("Six", "Kusitfupha", R.drawable.number_six, R.raw.number_six));
                words.add(new Word("Seven", "Kusikhombisa", R.drawable.number_seven, R.raw.number_seven));
                words.add(new Word("Eight", "Kusiphohlongo", R.drawable.number_eight, R.raw.number_eight));
                words.add(new Word("Nine", "Kuyimfica", R.drawable.number_nine, R.raw.number_nine));
                words.add(new Word("Ten", "Kulishumi", R.drawable.number_ten, R.raw.number_ten));
                break;


            default:
                //english
                getSupportActionBar().setSubtitle("Number");
                words.add(new Word("one", "lutti", R.drawable.number_one, R.raw.number_one));
                words.add(new Word("two", "otiiko", R.drawable.number_two, R.raw.number_two));
                words.add(new Word("three", "tolookosu", R.drawable.number_three, R.raw.number_three));
                words.add(new Word("four", "Oyyisa", R.drawable.number_four, R.raw.number_four));
                words.add(new Word("five", "massokka", R.drawable.number_five, R.raw.number_five));
                words.add(new Word("six", "temmokka", R.drawable.number_six, R.raw.number_six));
                words.add(new Word("seven", "kenekaku", R.drawable.number_seven, R.raw.number_seven));
                words.add(new Word("eight", "kawinta", R.drawable.number_eight, R.raw.number_eight));
                words.add(new Word("nine", "wo'e", R.drawable.number_nine, R.raw.number_nine));
                words.add(new Word("ten", "na'aacha", R.drawable.number_ten, R.raw.number_ten));
        }
                WordAdapter adapter= new WordAdapter(this,words,R.color.category_numbers);

                ListView listView=(ListView) findViewById(R.id.list);

                listView.setAdapter(adapter);

                listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
                {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id)
                    {

                        Word word=words.get(position);
                        releaseMediaPlayer();

                        int result=mAudioManager.requestAudioFocus(afChangeListener,
                                AudioManager.STREAM_MUSIC,
                                AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
                        if(result==AudioManager.AUDIOFOCUS_REQUEST_GRANTED)
                        {

                            // mAudioManager.registerMediaButtonEventReceiver(RemoteControlReceiver);

                            mMediaPlayer = MediaPlayer.create(NumbersActivity.this, word.getmAudioResourceId());
                            mMediaPlayer.start();
                            //setup a listener on the media
                            mMediaPlayer.setOnCompletionListener(mOnCompletionListener);
                        }
                    }
                });

        }

    @Override
    protected void onResume() {
        super.onResume();
       // updateLanguage();
    }


    //optional menu
@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }



//optional menu functionality


   // public void updateLanguage() {

     //   String selected_language = sharedPreferences.getString("language","");




    @Override
    protected void onStop(){
        super.onStop();
        //when the activity is stopped,release the media player resorces because we wont
        //be playing any more sound
        releaseMediaPlayer();
    }

    private void releaseMediaPlayer(){

        if(mMediaPlayer !=null){

            mMediaPlayer.release();
            mMediaPlayer=null;
            mAudioManager.abandonAudioFocus(afChangeListener);
        }
    }



    //TOP BACK BUTTON
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // int id = item.getItemId();
        if (item.getItemId() == android.R.id.home)
        {

            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
