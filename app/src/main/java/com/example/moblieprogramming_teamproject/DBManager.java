package com.example.moblieprogramming_teamproject;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/*
    데이터베이스 매니저
 */

class DBManager extends AsyncTask<String, Void, String> {
    private final String IP_ADDRESS = "210.115.48.93:8888";
    private final String insertServerUrl = "http://" + IP_ADDRESS + "/insert.php";
    private final String searchServerUrl = "http://" + IP_ADDRESS + "/search.php";

    // TODO : 사용자 프로필 리스트를 가져오는 메소드
    protected void loadProfileList(String bigarea, String smallarea) {

    }

    // TODO : 선택한 프로필 정보 가져오는 메소드
    protected void loadProfileInfo() {

    }

    // TODO : 게시물 리스트를 가져오는 메소드
    protected void loadCommunityList() {

    }

    // TODO : 선택한 게시물 정보 가져오는 메소드
    protected void loadCommunityInfo() {

    }

    // TODO : insert 이미지 추가
    protected void insertDBInfo(String... params) {
        String image = (String) params[0];
        String name = (String) params[1];
        String age = (String) params[2];
        String kind = (String) params[3];
        String gender = (String) params[4];
        String bigarea = (String) params[5];
        String smallarea = (String) params[6];
        String info = (String) params[7];

        String postParameters = "name=" + name + "&age=" + age +
                "&kind=" + kind + "&gender=" + gender + "&bigarea=" + bigarea + "&smallarea=" + smallarea + "&info=" + info + "&image=" + image;

        Log.i("Post Parameters", postParameters);

        execute(postParameters);
    }


    @Override
    protected String doInBackground(String... params) {
        String postParameters = (String) params[0];

        // TODO : insert.php에 저장할 정보 추가
        try {
            // 2. HttpURLConnection 클래스를 사용하여 POST 방식으로 데이터를 전송합니다.
            URL url = new URL(insertServerUrl); // 주소가 저장된 변수를 이곳에 입력합니다.

            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setReadTimeout(5000); //5초안에 응답이 오지 않으면 예외가 발생합니다.
            httpURLConnection.setConnectTimeout(5000); //5초안에 연결이 안되면 예외가 발생합니다.
            httpURLConnection.setRequestMethod("POST"); //요청 방식을 POST로 합니다.
            httpURLConnection.connect();


            OutputStream outputStream = httpURLConnection.getOutputStream();
            outputStream.write(postParameters.getBytes("UTF-8")); //전송할 데이터가 저장된 변수를 이곳에 입력합니다. 인코딩을 고려해줘야 합니다.

            outputStream.flush();
            outputStream.close();


            // 3. 응답을 읽습니다.
            int responseStatusCode = httpURLConnection.getResponseCode();
            InputStream inputStream;
            if(responseStatusCode == HttpURLConnection.HTTP_OK) {
                // 정상적인 응답 데이터
                inputStream = httpURLConnection.getInputStream();
            }
            else{
                // 에러 발생
                inputStream = httpURLConnection.getErrorStream();
            }



            // 4. StringBuilder를 사용하여 수신되는 데이터를 저장합니다.
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            StringBuilder sb = new StringBuilder();
            String line = null;

            while((line = bufferedReader.readLine()) != null){
                sb.append(line);
            }

            bufferedReader.close();

            // 5. 저장된 데이터를 스트링으로 변환하여 리턴합니다.
            return sb.toString();
        } catch (Exception e) {
            return new String("Error: " + e.getMessage());
        }
    }
}