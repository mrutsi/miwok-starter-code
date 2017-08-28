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

public class PhrasesActivity extends AppCompatActivity
{
    private MediaPlayer mMediaPlayer ;
     private AudioManager mAudioManager;
    String chan_language;


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


//back button bar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //create and setup the {@link audiomanager}to request audio focus
        mAudioManager=(AudioManager)getSystemService(Context.AUDIO_SERVICE);


        //get intent from main activity
        Intent intent = getIntent();
        chan_language = intent.getStringExtra("chan_language");

        //create an array of words
        final ArrayList<Word>words=new ArrayList<Word>();
        switch (chan_language)
        {

            case "Tshivenda":
                //Tshivenda

                getSupportActionBar().setSubtitle("Mitaladzi");
                //tshivenda
                words.add(new Word("Where are you going?", "Nikho uya gai?", R.raw.ni_cou_ya_gai));
                words.add(new Word("What is your name?", "Dzina lanu ndi nnyi?", R.raw.dzina_lanu_ndi_nnyi));
                words.add(new Word("My name is...", "Dzina langa ndi...", R.raw.dzina_langa_ndi));
                words.add(new Word("How are you feeling?", "Nikho dipfa hani?", R.raw.phrase_how_are_you_feeling));
                words.add(new Word("I’m feeling good", "Ndikho dipfa zwavhudi.", R.raw.ndi_cou_dipfa_zwavhudi));
                words.add(new Word("Are you coming?", "Nikho uda?",R.raw.ni_cou_da));
                words.add(new Word("Yes, I’m coming", "Ehe ndikho uda", R.raw.ee_ndi_cou_da));
                words.add(new Word("I’m coming", "Ndikho uda", R.raw.ni_cou_da));
                words.add(new Word("Let’s go", "Ari tuwe", R.raw.kha_ri_tuwe));
                words.add(new Word("Come here..", "Idani hafha", R.raw.idani_hafha));
               break;

            case "Sipedi":
                //Sipedi
                getSupportActionBar().setSubtitle("Dipolelwana");
                words.add(new Word("Where are you going?", "O ya kae", R.raw.sep_o_ya_kae));
                words.add(new Word("What is your name?", "Lebitso lahago kemang", R.raw.sep_leina_la_gago_ke_mang));
                words.add(new Word("My name is...", "Lebitso laka ke..", R.raw.sep_leina_laka_ke));
                words.add(new Word("How are you feeling?", "O ikwa jwang?", R.raw.sep_o_ikwa_bjang));
                words.add(new Word("I’m feeling good.", "ke ikwa gabotse", R.raw.sep_ke_ikwa_ga_botse));
                words.add(new Word("Are you coming?", "watla?", R.raw.sep_watla_naa));
                words.add(new Word("Yes, I’m coming.", "ke etla", R.raw.sep_ee_ke_a_tla));
                words.add(new Word("I’m coming.", "ke etla", R.raw.sep_ke_atla));
                words.add(new Word("Let’s go.", "Etla re sepele", R.raw.sep_tla_re_sepele));
                words.add(new Word("Come here.", "Etla mo", R.raw.sep_e_tla_mo));
                break;

            case "IsiNdebele":

                //IsiNdebele
                getSupportActionBar().setSubtitle("Izitho");
                words.add(new Word("Where are you going?", "minto wuksus", R.raw.nde_whererugoing));
                words.add(new Word("What is your name?", "tinnә oyaase'nә", R.raw.nde_whts_ur_nme));
                words.add(new Word("My name is...", "oyaaset...", R.raw.nde_my_nme_is));
                words.add(new Word("How are you feeling?", "michәksәs?", R.raw.nde_howrufeelng));
                words.add(new Word("I’m feeling good.", "kuchi achit", R.raw.nde_im_flng_good));
                words.add(new Word("Are you coming?", "әәnәs'aa?", R.raw.nde_r_u_cmng));
                words.add(new Word("Yes, I’m coming.", "hәә’ әәnәm", R.raw.nde_yes_im_cmng));
                words.add(new Word("I’m coming.", "әәnәm", R.raw.nde_imcmng));
                words.add(new Word("Let’s go.", "yoowutis", R.raw.nde_lts_go));
                words.add(new Word("Come here.", "әnni'nem", R.raw.nde_cmehere));
                break;


            case "isiXhosa":
                //IsiXhosa
                getSupportActionBar().setSubtitle("Ibizana");
                words.add(new Word("Where are you going?", "minto wuksus", R.raw.xhosa_whereareyougoing));
                words.add(new Word("What is your name?", "tinnә oyaase'nә", R.raw.xhos_whatisyourname));
                words.add(new Word("My name is...", "oyaaset...", R.raw.xhosa_mynameis));
                words.add(new Word("How are you feeling?", "michәksәs?", R.raw.xhosa_howareyoufeeling));
                words.add(new Word("I’m feeling good.", "kuchi achit", R.raw.xhosa_imfeelinggood));
                words.add(new Word("Are you coming?", "әәnәs'aa?", R.raw.xhosa_areyoucoming));
                words.add(new Word("Yes, I’m coming.", "hәә’ әәnәm", R.raw.xhosa_yesimcoming));
                words.add(new Word("I’m coming.", "әәnәm", R.raw.xhosa_imcoming));
                words.add(new Word("Let’s go.", "yoowutis", R.raw.xhosa_letsgo));
                words.add(new Word("Come here.", "әnni'nem", R.raw.xhosa_comehere));
                break;


            case "XiTsonga":
                //XiTsonga
                getSupportActionBar().setSubtitle("Timhako");
                words.add(new Word("Where are you going?", "minto wuksus", R.raw.phrase_where_are_you_going));
                words.add(new Word("What is your name?", "tinnә oyaase'nә", R.raw.phrase_what_is_your_name));
                words.add(new Word("My name is...", "oyaaset...", R.raw.phrase_my_name_is));
                words.add(new Word("How are you feeling?", "michәksәs?", R.raw.phrase_how_are_you_feeling));
                words.add(new Word("I’m feeling good.", "kuchi achit", R.raw.phrase_im_feeling_good));
                words.add(new Word("Are you coming?", "әәnәs'aa?", R.raw.phrase_are_you_coming));
                words.add(new Word("Yes, I’m coming.", "hәә’ әәnәm", R.raw.phrase_yes_im_coming));
                words.add(new Word("I’m coming.", "әәnәm", R.raw.phrase_im_coming));
                words.add(new Word("Let’s go.", "yoowutis", R.raw.phrase_lets_go));
                words.add(new Word("Come here.", "әnni'nem", R.raw.phrase_come_here));
                break;

            case "IsiZulu":
                //IsiZulu
                getSupportActionBar().setSubtitle("Imishwana");
                words.add(new Word("Where are you going?", "minto wuksus", R.raw.phrase_where_are_you_going));
                words.add(new Word("What is your name?", "tinnә oyaase'nә", R.raw.phrase_what_is_your_name));
                words.add(new Word("My name is...", "oyaaset...", R.raw.phrase_my_name_is));
                words.add(new Word("How are you feeling?", "michәksәs?", R.raw.phrase_how_are_you_feeling));
                words.add(new Word("I’m feeling good.", "kuchi achit", R.raw.phrase_im_feeling_good));
                words.add(new Word("Are you coming?", "әәnәs'aa?", R.raw.phrase_are_you_coming));
                words.add(new Word("Yes, I’m coming.", "hәә’ әәnәm", R.raw.phrase_yes_im_coming));
                words.add(new Word("I’m coming.", "әәnәm", R.raw.phrase_im_coming));
                words.add(new Word("Let’s go.", "yoowutis", R.raw.phrase_lets_go));
                words.add(new Word("Come here.", "әnni'nem", R.raw.phrase_come_here));
                break;


//yes
            case "Afrikaans":
                //Afrikaans
                getSupportActionBar().setSubtitle("Frases");
                words.add(new Word("Where are you going?", "minto wuksus", R.raw.phrase_where_are_you_going));
                words.add(new Word("What is your name?", "tinnә oyaase'nә", R.raw.phrase_what_is_your_name));
                words.add(new Word("My name is...", "oyaaset...", R.raw.phrase_my_name_is));
                words.add(new Word("How are you feeling?", "michәksәs?", R.raw.phrase_how_are_you_feeling));
                words.add(new Word("I’m feeling good.", "kuchi achit", R.raw.phrase_im_feeling_good));
                words.add(new Word("Are you coming?", "әәnәs'aa?", R.raw.phrase_are_you_coming));
                words.add(new Word("Yes, I’m coming.", "hәә’ әәnәm", R.raw.phrase_yes_im_coming));
                words.add(new Word("I’m coming.", "әәnәm", R.raw.phrase_im_coming));
                words.add(new Word("Let’s go.", "yoowutis", R.raw.phrase_lets_go));
                words.add(new Word("Come here.", "әnni'nem", R.raw.phrase_come_here));
                break;


            case "Sesotho":
                //Sesotho
                getSupportActionBar().setSubtitle("Mafoko");
                words.add(new Word("Where are you going?", "minto wuksus", R.raw.phrase_where_are_you_going));
                words.add(new Word("What is your name?", "tinnә oyaase'nә", R.raw.phrase_what_is_your_name));
                words.add(new Word("My name is...", "oyaaset...", R.raw.phrase_my_name_is));
                words.add(new Word("How are you feeling?", "michәksәs?", R.raw.phrase_how_are_you_feeling));
                words.add(new Word("I’m feeling good.", "kuchi achit", R.raw.phrase_im_feeling_good));
                words.add(new Word("Are you coming?", "әәnәs'aa?", R.raw.phrase_are_you_coming));
                words.add(new Word("Yes, I’m coming.", "hәә’ әәnәm", R.raw.phrase_yes_im_coming));
                words.add(new Word("I’m coming.", "әәnәm", R.raw.phrase_im_coming));
                words.add(new Word("Let’s go.", "yoowutis", R.raw.phrase_lets_go));
                words.add(new Word("Come here.", "әnni'nem", R.raw.phrase_come_here));
                break;


            case "Setswana":
                //Setswana
                getSupportActionBar().setSubtitle("Mafoko");
                words.add(new Word("Where are you going?", "minto wuksus", R.raw.phrase_where_are_you_going));
                words.add(new Word("What is your name?", "tinnә oyaase'nә", R.raw.phrase_what_is_your_name));
                words.add(new Word("My name is...", "oyaaset...", R.raw.phrase_my_name_is));
                words.add(new Word("How are you feeling?", "michәksәs?", R.raw.phrase_how_are_you_feeling));
                words.add(new Word("I’m feeling good.", "kuchi achit", R.raw.phrase_im_feeling_good));
                words.add(new Word("Are you coming?", "әәnәs'aa?", R.raw.phrase_are_you_coming));
                words.add(new Word("Yes, I’m coming.", "hәә’ әәnәm", R.raw.phrase_yes_im_coming));
                words.add(new Word("I’m coming.", "әәnәm", R.raw.phrase_im_coming));
                words.add(new Word("Let’s go.", "yoowutis", R.raw.phrase_lets_go));
                words.add(new Word("Come here.", "әnni'nem", R.raw.phrase_come_here));

                break;


            case "SiSwati":
                //SiSwati
                getSupportActionBar().setSubtitle("Izitho");
                words.add(new Word("Where are you going?", "minto wuksus", R.raw.phrase_where_are_you_going));
                words.add(new Word("What is your name?", "tinnә oyaase'nә", R.raw.phrase_what_is_your_name));
                words.add(new Word("My name is...", "oyaaset...", R.raw.phrase_my_name_is));
                words.add(new Word("How are you feeling?", "michәksәs?", R.raw.phrase_how_are_you_feeling));
                words.add(new Word("I’m feeling good.", "kuchi achit", R.raw.phrase_im_feeling_good));
                words.add(new Word("Are you coming?", "әәnәs'aa?", R.raw.phrase_are_you_coming));
                words.add(new Word("Yes, I’m coming.", "hәә’ әәnәm", R.raw.phrase_yes_im_coming));
                words.add(new Word("I’m coming.", "әәnәm", R.raw.phrase_im_coming));
                words.add(new Word("Let’s go.", "yoowutis", R.raw.phrase_lets_go));
                words.add(new Word("Come here.", "әnni'nem", R.raw.phrase_come_here));

                break;

            case "English":
                //english
                getSupportActionBar().setSubtitle("Phrases");
                words.add(new Word("Where are you going?", "minto wuksus", R.raw.phrase_where_are_you_going));
                words.add(new Word("What is your name?", "tinnә oyaase'nә", R.raw.phrase_what_is_your_name));
                words.add(new Word("My name is...", "oyaaset...", R.raw.phrase_my_name_is));
                words.add(new Word("How are you feeling?", "michәksәs?", R.raw.phrase_how_are_you_feeling));
                words.add(new Word("I’m feeling good.", "kuchi achit", R.raw.phrase_im_feeling_good));
                words.add(new Word("Are you coming?", "әәnәs'aa?", R.raw.phrase_are_you_coming));
                words.add(new Word("Yes, I’m coming.", "hәә’ әәnәm", R.raw.phrase_yes_im_coming));
                words.add(new Word("I’m coming.", "әәnәm", R.raw.phrase_im_coming));
                words.add(new Word("Let’s go.", "yoowutis", R.raw.phrase_lets_go));
                words.add(new Word("Come here.", "әnni'nem", R.raw.phrase_come_here));
                break;

                default:
                //english
                    getSupportActionBar().setSubtitle("Phrases");
                words.add(new Word("Where are you going?", "minto wuksus", R.raw.phrase_where_are_you_going));
                words.add(new Word("What is your name?", "tinnә oyaase'nә", R.raw.phrase_what_is_your_name));
                words.add(new Word("My name is...", "oyaaset...", R.raw.phrase_my_name_is));
                words.add(new Word("How are you feeling?", "michәksәs?", R.raw.phrase_how_are_you_feeling));
                words.add(new Word("I’m feeling good.", "kuchi achit", R.raw.phrase_im_feeling_good));
                words.add(new Word("Are you coming?", "әәnәs'aa?", R.raw.phrase_are_you_coming));
                words.add(new Word("Yes, I’m coming.", "hәә’ әәnәm", R.raw.phrase_yes_im_coming));
                words.add(new Word("I’m coming.", "әәnәm", R.raw.phrase_im_coming));
                words.add(new Word("Let’s go.", "yoowutis", R.raw.phrase_lets_go));
                words.add(new Word("Come here.", "әnni'nem", R.raw.phrase_come_here));
                break;
        }

        WordAdapter adapter= new WordAdapter(this,words,R.color.category_phrases);

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

                    mMediaPlayer = MediaPlayer.create(PhrasesActivity.this, word.getmAudioResourceId());
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
