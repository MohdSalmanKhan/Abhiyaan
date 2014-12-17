package com.abhiyaaan;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import android.os.AsyncTask;

public class RequestTask extends AsyncTask<String, String, String> {

	@Override
	protected String doInBackground(String... uri) {
		HttpClient httpclient = new DefaultHttpClient();
		HttpResponse response;
		String responseString = null;

		try {

			response = httpclient
					.execute(new HttpGet(
							"http://1-dot-glass-chemist-761.appspot.com/UploadImageBlobURL"));

			String responseBody = EntityUtils.toString(response.getEntity());

			HttpPost httpost = new HttpPost(responseBody);

			String boundary = "-------------" + System.currentTimeMillis();
			httpost.setHeader("Content-type", "multipart/form-data; boundary="
					+ boundary);

			MultipartEntityBuilder builder = MultipartEntityBuilder.create();
			builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
			builder.setBoundary(boundary);
			FileBody file = new FileBody(new File(uri[0]));

			builder.addTextBody("Location", uri[1]);
			builder.addTextBody("dirttype", uri[2]);
			builder.addTextBody("rating", uri[3]);
			builder.addTextBody("longitude",uri[4]);
			builder.addTextBody("latitude",uri[5]);
			
			builder.addPart("image", file);

			httpost.setEntity(builder.build());

			response = httpclient.execute(httpost);

			StatusLine statusLine = response.getStatusLine();
			if (statusLine.getStatusCode() == HttpStatus.SC_OK) {
				ByteArrayOutputStream out = new ByteArrayOutputStream();
				response.getEntity().writeTo(out);
				out.close();
				responseString = out.toString();
			} else {
				// Closes the connection.
				response.getEntity().getContent().close();
				throw new IOException(statusLine.getReasonPhrase());
			}
		} catch (ClientProtocolException e) {
			// TODO Handle problems..
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Handle problems..
			e.printStackTrace();
		}
		return responseString;
	}

	@Override
	protected void onPostExecute(String result) {
		super.onPostExecute(result);
		// Do anything with response..
	}
}
