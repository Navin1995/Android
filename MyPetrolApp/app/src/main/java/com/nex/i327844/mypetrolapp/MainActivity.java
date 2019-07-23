package com.nex.i327844.mypetrolapp;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.AsyncTask;
import android.speech.RecognizerIntent;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import ai.api.AIListener;
import ai.api.AIServiceException;
import ai.api.android.AIConfiguration;
import ai.api.android.AIService;
import ai.api.model.AIError;
import ai.api.model.AIRequest;
import ai.api.model.AIResponse;
import ai.api.model.Result;

import com.google.gson.JsonElement;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Map;

import ai.api.AIListener;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private AIService aiService;
    private Button listenButton;
    private TextView resultTextView;
    private final int SPEECH_RECOGNITION_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listenButton = (Button) findViewById(R.id.listenButton);
        listenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                promptSpeechInput();
            }
        });
        resultTextView = (TextView) findViewById(R.id.resultTextView);
        final AIConfiguration config = new AIConfiguration("0a533e8fb90c4bd4a198d3ffe527e409",
                AIConfiguration.SupportedLanguages.English,
                AIConfiguration.RecognitionEngine.System);
        aiService = AIService.getService(this, config);
    }
    private void promptSpeechInput() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Speak something...");
        try {
            startActivityForResult(intent, SPEECH_RECOGNITION_CODE);
        } catch (ActivityNotFoundException a) {
            Toast.makeText(getApplicationContext(),
                    "Sorry! Speech recognition is not supported in this device.",
                    Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case SPEECH_RECOGNITION_CODE: {
                if (resultCode == RESULT_OK && null != data) {

                    ArrayList<String> result = data
                            .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    String text = result.get(0);
                    new AIOperation().execute(text);
                }
                break;
            }

        }
    }
    private class AIOperation extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {
            try {
                AIResponse response = aiService.textRequest(new AIRequest(params[0]));
                Result result = response.getResult();

                // Get parameters
                String parameterString = "";
                if (result.getParameters() != null && !result.getParameters().isEmpty()) {
                    for (final Map.Entry<String, JsonElement> entry : result.getParameters().entrySet()) {
                        parameterString += "(" + entry.getKey() + ", " + entry.getValue() + ") ";
                    }
                }
                return "Query:" + result.getResolvedQuery() +
                        "\nAction: " + result.getAction() +
                        "\nParameters: " + parameterString ;

            } catch (AIServiceException e) {
                e.printStackTrace();
                Toast.makeText(MainActivity.this, "Error in AIRequest", Toast.LENGTH_SHORT).show();
            }
            return "";
        }

        @Override
        protected void onPostExecute(String result) {
            resultTextView.setText(result);
        }

        @Override
        protected void onPreExecute() {
        }

        @Override
        protected void onProgressUpdate(Void... values) {
        }
    }
}
