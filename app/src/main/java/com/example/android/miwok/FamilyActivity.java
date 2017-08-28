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

public class FamilyActivity extends AppCompatActivity
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
                getSupportActionBar().setSubtitle("Mirado Ya Mita");
                //tshivenda
                words.add(new Word("father", "Khotsi", R.drawable.family_father, R.raw.khotsi));
                words.add(new Word("mother", "Mme", R.drawable.family_mother, R.raw.mme));
                words.add(new Word("son", "Nwana wa Mutukana", R.drawable.family_son, R.raw.mutukana));
                words.add(new Word("daughter", "Nwana wa Musidzana", R.drawable.family_daughter, R.raw.musidzana));
                words.add(new Word("older brother", "Mukomana wa Mutukana", R.drawable.family_older_brother, R.raw.khotsi_muhulu));
                words.add(new Word("younger brother", "Murathu wa Mutukana", R.drawable.family_younger_brother, R.raw.khotsi_munene));
                words.add(new Word("older sister", "Mukomana wa Musidzana", R.drawable.family_older_sister, R.raw.mme_muhulu));
                words.add(new Word("younger sister", "Murathu wa Musidzana", R.drawable.family_younger_sister, R.raw.mmane));
                words.add(new Word("grandmother", "Makhulu wa Mukegulu", R.drawable.family_grandmother, R.raw.makhulu_wa_mukegulu));
                words.add(new Word("grandfather", "Makhulu wa Mukalaha", R.drawable.family_grandfather, R.raw.makhulu_wa_mukalaha));
                break;


            case "Sipedi":
                getSupportActionBar().setSubtitle("Litho tsa Lelapa");
                //Sipedi
                words.add(new Word("father", "Tate", R.drawable.family_father, R.raw.sep_tate));
                words.add(new Word("mother", "Mma", R.drawable.family_mother, R.raw.sep_mma));
                words.add(new Word("son", "Morwa", R.drawable.family_son, R.raw.sep_morwa));
                words.add(new Word("daughter", "Morwedi", R.drawable.family_daughter, R.raw.sep_morwedi));
                words.add(new Word("older brother", "Buti o Mogolo", R.drawable.family_older_brother, R.raw.sep_buti_o_mogolo));
                words.add(new Word("younger brother", "Buti o Monnyane", R.drawable.family_younger_brother, R.raw.sep_buti_o_monnyane));
                words.add(new Word("older sister", "Sesi o Mogolo ", R.drawable.family_older_sister, R.raw.sep_sesi_o_mogolo));
                words.add(new Word("younger sister", "Sesi Monnyane", R.drawable.family_younger_sister, R.raw.sep_sesi_o_monnyane));
                words.add(new Word("grandmother", "Makgolo", R.drawable.family_grandmother, R.raw.sep_makgolo));
                words.add(new Word("grandfather", "Rakgolo", R.drawable.family_grandfather, R.raw.sep_rakgolo));
             break;

            case "IsiNdebele":
                getSupportActionBar().setSubtitle("Umndeni");
                //IsiNdebele
                words.add(new Word("Father", "Baba", R.drawable.family_father, R.raw.nde_father));
                words.add(new Word("Mother", "Mma", R.drawable.family_mother, R.raw.nde_mother));
                words.add(new Word("Son", "Umsana", R.drawable.family_son, R.raw.nde_son));
                words.add(new Word("Daughter", "Umntazana", R.drawable.family_daughter, R.raw.nde_daughter));
                words.add(new Word("Older Brother", "Ubhuti Omkhulu", R.drawable.family_older_brother, R.raw.nde_olderbrother));
                words.add(new Word("Younger Brother", "Ubhuti Omncani", R.drawable.family_younger_brother, R.raw.nde_younger_brother_sister));
                words.add(new Word("Older Sister", "Usesi Omkhulu", R.drawable.family_older_sister, R.raw.nde_older_sister));
                words.add(new Word("Younger Sister", "Usesi Omncani", R.drawable.family_younger_sister, R.raw.nde_younger_brother_sister));
                words.add(new Word("Grandmother", "Ugogo", R.drawable.family_grandmother, R.raw.nde_grandma));
                words.add(new Word("Grandfather", "Umkhulu", R.drawable.family_grandfather, R.raw.nde_grandpa));
                break;

            case "IsiXhosa":
                //IsiXhosa
                getSupportActionBar().setSubtitle("Amalungu Osapho");
                words.add(new Word("Father", "Unyihlo", R.drawable.family_father, R.raw.xhosa_father));
                words.add(new Word("Mother", "Unyoko", R.drawable.family_mother, R.raw.xhosa_mom));
                words.add(new Word("Son", "Sana", R.drawable.family_son, R.raw.xhosa_son));
                words.add(new Word("Daughter", "Unyana", R.drawable.family_daughter, R.raw.xhosa_daughter));
                words.add(new Word("Older Brother", "Ubuti Omdala", R.drawable.family_older_brother, R.raw.xhosa_older_brother));
                words.add(new Word("Younger Brother", "Ubuti Omncinci", R.drawable.family_younger_brother, R.raw.xhosa_younger_brother));
                words.add(new Word("Older Sister", "Usisi Omdala", R.drawable.family_older_sister, R.raw.xhosa_older_sis));
                words.add(new Word("Younger Sister", "Usisi Omncinci", R.drawable.family_younger_sister, R.raw.xhosa_young_sister));
                words.add(new Word("Grandmother", "Umkhulu", R.drawable.family_grandmother, R.raw.xhosa_grandma));
                words.add(new Word("Grandfather", "Utatokhulu", R.drawable.family_grandfather, R.raw.xhosa_grandma));//wrong
                break;

            case "XiTsonga":
                //XiTsonga
                getSupportActionBar().setSubtitle("Vondyanga");
                words.add(new Word("Father", "Tatana", R.drawable.family_father, R.raw.family_father));
                words.add(new Word("Mother", "Manana", R.drawable.family_mother, R.raw.family_mother));
                words.add(new Word("Son", "Jaha", R.drawable.family_son, R.raw.family_son));
                words.add(new Word("Daughter", "Nhwana", R.drawable.family_daughter, R.raw.family_daughter));
                words.add(new Word("Older Brother", "Buti", R.drawable.family_older_brother, R.raw.family_older_brother));
                words.add(new Word("Younger Brother", "Ndzisana Ya Jaha", R.drawable.family_younger_brother, R.raw.family_younger_brother));
                words.add(new Word("Older Sister", "Sesi", R.drawable.family_older_sister, R.raw.family_older_sister));
                words.add(new Word("Younger Sister", "Ndzisana Ya Nhwana", R.drawable.family_younger_sister, R.raw.family_younger_sister));
                words.add(new Word("Grandmother", "Kokwana Wa Xisati", R.drawable.family_grandmother, R.raw.family_grandmother));
                words.add(new Word("Grandfather", "Kokwana Wa Xinuna", R.drawable.family_grandfather, R.raw.family_grandfather));
                break;

            case "English":
            getSupportActionBar().setSubtitle("Family Members");
            //English
            words.add(new Word("father","әpә",R.drawable.family_father,R.raw.family_father));
            words.add(new Word("mother","әṭa",R.drawable.family_mother,R.raw.family_mother));
            words.add(new Word("son","angsi",R.drawable.family_son,R.raw.family_son));
            words.add(new Word("daughter","tune",R.drawable.family_daughter,R.raw.family_daughter));
            words.add(new Word("older brother","taachi",R.drawable.family_older_brother,R.raw.family_older_brother));
            words.add(new Word("younger brother","chalitti",R.drawable.family_younger_brother,R.raw.family_younger_brother));
            words.add(new Word("older sister","teṭe",R.drawable.family_older_sister,R.raw.family_older_sister));
            words.add(new Word("younger sister","kolliti",R.drawable.family_younger_sister,R.raw.family_younger_sister));
            words.add(new Word("grandmother","ama",R.drawable.family_grandmother,R.raw.family_grandmother));
            words.add(new Word("grandfather","paapa",R.drawable.family_grandfather,R.raw.family_grandfather));
            break;


            case "SiSwati":
                getSupportActionBar().setSubtitle("Umndeni");
                //SiSwati
                words.add(new Word("Father", "Baba", R.drawable.family_father, R.raw.family_father));
                words.add(new Word("Mother", "Maka", R.drawable.family_mother, R.raw.family_mother));
                words.add(new Word("Son", "Mnthawa Wemfana", R.drawable.family_son, R.raw.family_son));
                words.add(new Word("Daughter", "Mntwana", R.drawable.family_daughter, R.raw.family_daughter));
                words.add(new Word("Older Brother", "Buti Lomdzala", R.drawable.family_older_brother, R.raw.family_older_brother));
                words.add(new Word("Younger Brother", "Buti Lomncane", R.drawable.family_younger_brother, R.raw.family_younger_brother));
                words.add(new Word("Older Sister", "Sesi Lomdzala", R.drawable.family_older_sister, R.raw.family_older_sister));
                words.add(new Word("Younger Sister", "Sesi Lomncane", R.drawable.family_younger_sister, R.raw.family_younger_sister));
                words.add(new Word("Grandmother", "Gogo", R.drawable.family_grandmother, R.raw.family_grandmother));
                words.add(new Word("Grandfather", "Mkhulu", R.drawable.family_grandfather, R.raw.family_grandfather));
                break;
            case "Setswana":
                getSupportActionBar().setSubtitle("Maloko A Lelapa");
                //Setswana
                words.add(new Word("Father", "Rre", R.drawable.family_father, R.raw.family_father));
                words.add(new Word("Mother", "Mme", R.drawable.family_mother, R.raw.family_mother));
                words.add(new Word("Son", "Mora", R.drawable.family_son, R.raw.family_son));
                words.add(new Word("Daughter", "Moradi", R.drawable.family_daughter, R.raw.family_daughter));
                words.add(new Word("Older Brother", "Kgonne", R.drawable.family_older_brother, R.raw.family_older_brother));
                words.add(new Word("Younger Brother", "Nnake Wa Mosimane", R.drawable.family_younger_brother, R.raw.family_younger_brother));
                words.add(new Word("Older Sister", "Ausi", R.drawable.family_older_sister, R.raw.family_older_sister));
                words.add(new Word("Younger Sister", "Nne wa Mosetsana", R.drawable.family_younger_sister, R.raw.family_younger_sister));
                words.add(new Word("Grandmother", "Koko", R.drawable.family_grandmother, R.raw.family_grandmother));
                words.add(new Word("Grandfather", "Rremogolo", R.drawable.family_grandfather, R.raw.family_grandfather));
                break;

            case "Sesotho":
                getSupportActionBar().setSubtitle("Maloko A Lelapa");
                //Sesotho
                words.add(new Word("Father", "Ntate", R.drawable.family_father, R.raw.family_father));
                words.add(new Word("Mother", "Mme", R.drawable.family_mother, R.raw.family_mother));
                words.add(new Word("Son", "Mora", R.drawable.family_son, R.raw.family_son));
                words.add(new Word("Daughter", "Moradi", R.drawable.family_daughter, R.raw.family_daughter));
                words.add(new Word("Older Brother", "Abuti A Moholo", R.drawable.family_older_brother, R.raw.family_older_brother));
                words.add(new Word("Younger Brother", "Abuti A Monyane", R.drawable.family_younger_brother, R.raw.family_younger_brother));
                words.add(new Word("Older Sister", "Ausi A Moholo", R.drawable.family_older_sister, R.raw.family_older_sister));
                words.add(new Word("Younger Sister", "Ausi A Monyane", R.drawable.family_younger_sister, R.raw.family_younger_sister));
                words.add(new Word("Grandmother", "Nkgono", R.drawable.family_grandmother, R.raw.family_grandmother));
                words.add(new Word("Grandfather", "Ntate Moholo", R.drawable.family_grandfather, R.raw.family_grandfather));
                break;

            case "Afrikaans":
                getSupportActionBar().setSubtitle("Familielede");
                //Afrikaans
                words.add(new Word("Father", "Pa", R.drawable.family_father, R.raw.family_father));
                words.add(new Word("Mother", "Moeder", R.drawable.family_mother, R.raw.family_mother));
                words.add(new Word("Son", "Seun", R.drawable.family_son, R.raw.family_son));
                words.add(new Word("Daughter", "Dogter", R.drawable.family_daughter, R.raw.family_daughter));
                words.add(new Word("Older Brother", "Ouer Broer", R.drawable.family_older_brother, R.raw.family_older_brother));
                words.add(new Word("Younger Brother", "Jounger Broer", R.drawable.family_younger_brother, R.raw.family_younger_brother));
                words.add(new Word("Older Sister", "Ouer Sester", R.drawable.family_older_sister, R.raw.family_older_sister));
                words.add(new Word("Younger Sister", "Jounger Sester", R.drawable.family_younger_sister, R.raw.family_younger_sister));
                words.add(new Word("Grandmother", "Ouma", R.drawable.family_grandmother, R.raw.family_grandmother));
                words.add(new Word("Grandfather", "Oupa", R.drawable.family_grandfather, R.raw.family_grandfather));
                break;


            case "IsiZulu":
                getSupportActionBar().setSubtitle("Umdwni");
                //IsiZulu
                words.add(new Word("Father", "Ubaba", R.drawable.family_father, R.raw.family_father));
                words.add(new Word("Mother", "Umama", R.drawable.family_mother, R.raw.family_mother));
                words.add(new Word("Son", "Indodana", R.drawable.family_son, R.raw.family_son));
                words.add(new Word("Daughter", "Indodakazi", R.drawable.family_daughter, R.raw.family_daughter));
                words.add(new Word("Older Brother", "Umfowethu Omdala", R.drawable.family_older_brother, R.raw.family_older_brother));
                words.add(new Word("Younger Brother", "Umfowethu Omncane", R.drawable.family_younger_brother, R.raw.family_younger_brother));
                words.add(new Word("Older Sister", "Udadawethu Omdala", R.drawable.family_older_sister, R.raw.family_older_sister));
                words.add(new Word("Younger Sister", "Udadawethu Omncane", R.drawable.family_younger_sister, R.raw.family_younger_sister));
                words.add(new Word("Grandmother", "Ugogo", R.drawable.family_grandmother, R.raw.family_grandmother));
                words.add(new Word("Grandfather", "Umkhulu", R.drawable.family_grandfather, R.raw.family_grandfather));
                break;

            default:
                //English
                getSupportActionBar().setSubtitle("Family Members");
                words.add(new Word("father","әpә",R.drawable.family_father,R.raw.family_father));
                words.add(new Word("mother","әṭa",R.drawable.family_mother,R.raw.family_mother));
                words.add(new Word("son","angsi",R.drawable.family_son,R.raw.family_son));
                words.add(new Word("daughter","tune",R.drawable.family_daughter,R.raw.family_daughter));
                words.add(new Word("older brother","taachi",R.drawable.family_older_brother,R.raw.family_older_brother));
                words.add(new Word("younger brother","chalitti",R.drawable.family_younger_brother,R.raw.family_younger_brother));
                words.add(new Word("older sister","teṭe",R.drawable.family_older_sister,R.raw.family_older_sister));
                words.add(new Word("younger sister","kolliti",R.drawable.family_younger_sister,R.raw.family_younger_sister));
                words.add(new Word("grandmother","ama",R.drawable.family_grandmother,R.raw.family_grandmother));
                words.add(new Word("grandfather","paapa",R.drawable.family_grandfather,R.raw.family_grandfather));
                break;

        }



        WordAdapter adapter= new WordAdapter(this,words,R.color.category_family);

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

                    mMediaPlayer = MediaPlayer.create(FamilyActivity.this, word.getmAudioResourceId());
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
