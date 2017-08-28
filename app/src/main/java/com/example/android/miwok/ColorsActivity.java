package com.example.android.miwok;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity
{

    private MediaPlayer mMediaPlayer ;
    private AudioManager mAudioManager;
    String chan_language;
    String app_subTitle="";

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
        Intent intent = getIntent();
        chan_language = intent.getStringExtra("chan_language");

        //create an array of words
        final ArrayList<Word>words=new ArrayList<Word>();
        switch (chan_language)
        {

            case "Tshivenda":
                //Tshivenda
                getSupportActionBar().setSubtitle("Mivhala");
                //tshivenda
                words.add(new Word("red", "Mutswuku", R.drawable.color_red, R.raw.color_red));
                words.add(new Word("green", "Mudala", R.drawable.color_green, R.raw.color_green));
                words.add(new Word("brown", "Buraunu", R.drawable.color_brown, R.raw.color_white));
                words.add(new Word("gray", "Girei", R.drawable.color_gray, R.raw.color_gray));
                words.add(new Word("black", "Mutswu", R.drawable.color_black, R.raw.color_gray));
                words.add(new Word("white", "kelelli", R.drawable.color_white, R.raw.color_white));
                words.add(new Word("dusty yellow", "dusty Mutada", R.drawable.color_dusty_yellow, R.raw.color_dusty_yellow));
                words.add(new Word("mustard yellow", "mustard Mutada", R.drawable.color_mustard_yellow, R.raw.color_mustard_yellow));
                break;

            case "Sipedi":
                //Sipedi
                getSupportActionBar().setSubtitle("Mebala");
                words.add(new Word("red", "Hubedu", R.drawable.color_red, R.raw.color_red));
                words.add(new Word("green", "Tala Morogo", R.drawable.color_green, R.raw.color_green));
                words.add(new Word("brown", "Tsothwa", R.drawable.color_brown, R.raw.color_brown));
                words.add(new Word("gray", "Sehla", R.drawable.color_gray, R.raw.color_gray));
                words.add(new Word("black", "Ntsho", R.drawable.color_black, R.raw.color_black));
                words.add(new Word("white", "Sweu", R.drawable.color_white, R.raw.color_white));
                words.add(new Word("dusty yellow", "Tshehla Serolwana", R.drawable.color_dusty_yellow, R.raw.color_dusty_yellow));
                words.add(new Word("mustard yellow", "Serolwana", R.drawable.color_mustard_yellow, R.raw.color_mustard_yellow));
           break;

            case "isiXhosa":
                //IsiXhosa
                getSupportActionBar().setSubtitle("Imibala");
                words.add(new Word("Red", "Bomvu", R.drawable.color_red,R.raw.xhosa_red));
                words.add(new Word("Green", "Luhlaza", R.drawable.color_green, R.raw.xhosa_green));
                words.add(new Word("Brown", "Bomvu-gwanqa", R.drawable.color_brown, R.raw.xhosa_brown));
                words.add(new Word("Gray", "Ngwevu",  R.drawable.color_gray, R.raw.xhosa_grey));
                words.add(new Word("Black", "Mnyama", R.drawable.color_black, R.raw.xhosa_black));
                words.add(new Word("White", "Mhlophe",  R.drawable.color_white, R.raw.xhosa_white));
                words.add(new Word("Dusty Yellow", "Umbala Wobhedu", R.drawable.color_dusty_yellow, R.raw.xhosa_yellow));
                words.add(new Word("Mustard Yellow", "Lubhelu/Mthubi", R.drawable.color_mustard_yellow, R.raw.xhosa_yellow));
                break;

            case "IsiNdebele":
                //IsiNdebele
                getSupportActionBar().setSubtitle("Imibala");
                words.add(new Word("Red", "Obovu", R.drawable.color_red, R.raw.nde_red));
                words.add(new Word("Green", "Luhlaza", R.drawable.color_green, R.raw.nde_green));
                words.add(new Word("Brown", "Nsundu", R.drawable.color_brown, R.raw.nde_brown));
                words.add(new Word("Gray", "Mpunga",  R.drawable.color_gray, R.raw.nde_red));//wrong
                words.add(new Word("Black", "Mnyama", R.drawable.color_black, R.raw.nde_black));
                words.add(new Word("White", "Mhlophe",  R.drawable.color_white, R.raw.nde_white));
                words.add(new Word("Dusty Yellow", "being translated", R.drawable.color_dusty_yellow, R.raw.nde_yellow));
                words.add(new Word("Mustard Yellow", "Otjheli", R.drawable.color_mustard_yellow, R.raw.nde_yellow));
                break;

            case "XiTsonga":
                //XiTsonga
                getSupportActionBar().setSubtitle("Mihlovo");
                words.add(new Word("Tshwuka", "weṭeṭṭi", R.drawable.color_red, R.raw.color_red));
                words.add(new Word("Rihlaza", "chokokki", R.drawable.color_green, R.raw.color_green));
                words.add(new Word("Ribungwa", "ṭakaakki", R.drawable.color_brown, R.raw.color_brown));
                words.add(new Word("gray", "ṭopoppi", R.drawable.color_gray, R.raw.color_gray));
                words.add(new Word("black", "kululli", R.drawable.color_black, R.raw.color_black));
                words.add(new Word("Basa", "kelelli", R.drawable.color_white, R.raw.color_white));
                words.add(new Word("dusty yellow", "ṭopiisә", R.drawable.color_dusty_yellow, R.raw.color_dusty_yellow));
                words.add(new Word("mustard yellow", "chiwiiṭә", R.drawable.color_mustard_yellow, R.raw.color_mustard_yellow));
                break;

            case "IsiZulu":
                //IsiZulu
                getSupportActionBar().setSubtitle("Imibala");
                words.add(new Word("red", "Bomvu", R.drawable.color_red, R.raw.color_red));
                words.add(new Word("Green", "Luhlaza", R.drawable.color_green, R.raw.color_green));
                words.add(new Word("Brown", "Nsundu", R.drawable.color_brown, R.raw.color_brown));
                words.add(new Word("Gray", "Mpunga",  R.drawable.color_gray, R.raw.color_gray));
                words.add(new Word("Black", "Mnyama", R.drawable.color_black, R.raw.color_black));
                words.add(new Word("White", "Mhlophe",  R.drawable.color_white, R.raw.color_white));
                words.add(new Word("Dusty Yellow", "Liphuzi", R.drawable.color_dusty_yellow, R.raw.color_dusty_yellow));
                words.add(new Word("Mustard Yellow", "Liphuzi", R.drawable.color_mustard_yellow, R.raw.color_mustard_yellow));
                break;


//yes
            case "Afrikaans":
                //Afrikaans
                getSupportActionBar().setSubtitle("Kleure");
                words.add(new Word("Red", "Rooi", R.drawable.color_red, R.raw.color_red));
                words.add(new Word("Green", "Groen", R.drawable.color_green, R.raw.color_green));
                words.add(new Word("Brown", "Bruin", R.drawable.color_brown, R.raw.color_brown));
                words.add(new Word("Gray", "Grys",  R.drawable.color_gray, R.raw.color_gray));
                words.add(new Word("Black", "Swart", R.drawable.color_black, R.raw.color_black));
                words.add(new Word("White", "Wit",  R.drawable.color_white, R.raw.color_white));
                words.add(new Word("Dusty Yellow", "Oranje", R.drawable.color_dusty_yellow, R.raw.color_dusty_yellow));
                words.add(new Word("Mustard Yellow", "Geel", R.drawable.color_mustard_yellow, R.raw.color_mustard_yellow));
                break;



            case "Sesotho":
                //Sesotho
                getSupportActionBar().setSubtitle("Mebala");
                words.add(new Word("Red", "Kgubedu", R.drawable.color_red, R.raw.color_red));
                words.add(new Word("Green", "Tala", R.drawable.color_green, R.raw.color_green));
                words.add(new Word("Brown", "Sootho", R.drawable.color_brown, R.raw.color_brown));
                words.add(new Word("Gray", "Thokwa",  R.drawable.color_gray, R.raw.color_gray));
                words.add(new Word("Black", "Ntsho", R.drawable.color_black, R.raw.color_black));
                words.add(new Word("White", "Tshweu",  R.drawable.color_white, R.raw.color_white));
                words.add(new Word("Dusty Yellow", "????", R.drawable.color_dusty_yellow, R.raw.color_dusty_yellow));
                words.add(new Word("Mustard Yellow", "Tshehla", R.drawable.color_mustard_yellow, R.raw.color_mustard_yellow));
                break;


            case "Setswana":
                //Setswana
                getSupportActionBar().setSubtitle("Mebale");
                words.add(new Word("Red", "Bohibidu", R.drawable.color_red, R.raw.color_red));
                words.add(new Word("Green", "Botala jwa ditlhare", R.drawable.color_green, R.raw.color_green));
                words.add(new Word("Brown", "Borokwa", R.drawable.color_brown, R.raw.color_brown));
                words.add(new Word("Gray", "Botuba",  R.drawable.color_gray, R.raw.color_gray));
                words.add(new Word("Black", "Bontsho", R.drawable.color_black, R.raw.color_black));
                words.add(new Word("White", "Bosweu",  R.drawable.color_white, R.raw.color_white));
                words.add(new Word("Dusty Yellow", "?????", R.drawable.color_dusty_yellow, R.raw.color_dusty_yellow));
                words.add(new Word("Mustard Yellow", "Bosetlha-galaledi", R.drawable.color_mustard_yellow, R.raw.color_mustard_yellow));
                break;





            case "SiSwati":
                //SiSwati
                getSupportActionBar().setSubtitle("Imibala");
                words.add(new Word("Red", "Bomvu", R.drawable.color_red, R.raw.color_red));
                words.add(new Word("Green", "Uluhlata satjani", R.drawable.color_green, R.raw.color_green));
                words.add(new Word("Brown", "Bubendze", R.drawable.color_brown, R.raw.color_brown));
                words.add(new Word("Gray", "Bhidzi",  R.drawable.color_gray, R.raw.color_gray));
                words.add(new Word("Black", "Mnyama", R.drawable.color_black, R.raw.color_black));
                words.add(new Word("White", "Mhlophe",  R.drawable.color_white, R.raw.color_white));
                words.add(new Word("Dusty Yellow", "????", R.drawable.color_dusty_yellow, R.raw.color_dusty_yellow));
                words.add(new Word("Mustard Yellow", "Mtfubi", R.drawable.color_mustard_yellow, R.raw.color_mustard_yellow));
                break;



            case "English":
                //english
                getSupportActionBar().setSubtitle("Colors");
                words.add(new Word("red", "weṭeṭṭi", R.drawable.color_red, R.raw.color_red));
                words.add(new Word("green", "chokokki", R.drawable.color_green, R.raw.color_green));
                words.add(new Word("brown", "ṭakaakki", R.drawable.color_brown, R.raw.color_brown));
                words.add(new Word("gray", "ṭopoppi", R.drawable.color_gray, R.raw.color_gray));
                words.add(new Word("black", "kululli", R.drawable.color_black, R.raw.color_black));
                words.add(new Word("white", "kelelli", R.drawable.color_white, R.raw.color_white));
                words.add(new Word("dusty yellow", "ṭopiisә", R.drawable.color_dusty_yellow, R.raw.color_dusty_yellow));
                words.add(new Word("mustard yellow", "chiwiiṭә", R.drawable.color_mustard_yellow, R.raw.color_mustard_yellow));
                break;
            default:
                //english
                getSupportActionBar().setSubtitle("Colors");
                words.add(new Word("red", "weṭeṭṭi", R.drawable.color_red, R.raw.color_red));
                words.add(new Word("green", "chokokki", R.drawable.color_green, R.raw.color_green));
                words.add(new Word("brown", "ṭakaakki", R.drawable.color_brown, R.raw.color_brown));
                words.add(new Word("gray", "ṭopoppi", R.drawable.color_gray, R.raw.color_gray));
                words.add(new Word("black", "kululli", R.drawable.color_black, R.raw.color_black));
                words.add(new Word("white", "kelelli", R.drawable.color_white, R.raw.color_white));
                words.add(new Word("dusty yellow", "ṭopiisә", R.drawable.color_dusty_yellow, R.raw.color_dusty_yellow));
                words.add(new Word("mustard yellow", "chiwiiṭә", R.drawable.color_mustard_yellow, R.raw.color_mustard_yellow));

        }

        WordAdapter adapter= new WordAdapter(this,words,R.color.category_colors);

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

                    mMediaPlayer = MediaPlayer.create(ColorsActivity.this, word.getmAudioResourceId());
                    mMediaPlayer.start();
                    //setup a listener on the media
                    mMediaPlayer.setOnCompletionListener(mOnCompletionListener);
                }
            }
        });
    }

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
