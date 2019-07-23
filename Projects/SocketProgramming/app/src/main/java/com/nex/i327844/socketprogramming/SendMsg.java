package com.nex.i327844.socketprogramming;

import android.os.AsyncTask;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
/**
 * Created by I327844 on 9/5/2017.
 */

public class SendMsg extends AsyncTask<String, Void, Void> {
    Exception exception;
    @Override
    protected Void doInBackground(String... params) {
        try{
            try{
                Socket socket = new Socket("192.168.56.1",9999);
                PrintWriter outToServer = new PrintWriter(
                        new OutputStreamWriter(
                                socket.getOutputStream()));
                        outToServer.print(params[0]);
                        outToServer.flush();
            }catch(IOException  e){
                e.printStackTrace();
            }
        }catch (Exception e){
            this.exception = e;
            return null;
        }
        return null;
    }
}
