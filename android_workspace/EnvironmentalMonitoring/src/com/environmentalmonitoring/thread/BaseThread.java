package com.environmentalmonitoring.thread;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import android.content.Context;
import android.os.Handler;
import android.os.Message;

import com.environmentalmonitoring.config.Config;
import com.environmentalmonitoring.db.ClientApp;
import com.environmentalmonitoring.request.BaseRequest;
import com.environmentalmonitoring.util.HexTransform;

public class BaseThread extends Thread {
	protected ClientApp app;
	protected Context mContext;
	protected Handler mHandler;
	protected BaseRequest baserequest;
	// protected MainActivity activity;

	private boolean isClosed = false;
	private boolean isPause = false;

	public BaseThread(Context mContext, BaseRequest baserequest,
			Handler mHandler) {
		this.mContext = mContext;
		this.app = (ClientApp) mContext.getApplicationContext();
		// this.activity = (MainActivity) mContext;
		this.mHandler = mHandler;
		this.baserequest = baserequest;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		Socket client = null;
		while (!isClosed) {
			while (isPause)
				;
			try {
				client = new Socket(Config.HTTP_SERVER_IP,
						Config.HTTP_SERVER_PORT);
				client.setSoTimeout(Config.TIME_OUT);

				//sendMsg(client, baserequest.getSend_byte());
				sendMsg(client, baserequest.getSend());
				byte[] back = new byte[51];
				back = rcvMsg(client);
				baserequest.parseBack(back);
				client.close();

				// ��ʱ1s
				try {
					Thread.sleep(Config.GET_DATA_DELAY);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				System.out.println("unknownhost");
				e.printStackTrace();
			} catch (SocketTimeoutException e) {
				e.printStackTrace();
				Message msg = mHandler.obtainMessage();
				msg.what = Config.TIME_OUT_WHAT;
				mHandler.sendMessage(msg);
			} catch (IOException e) {
				System.out.println("ioexception");
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (client != null) {
					try {
						client.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}

	}

	private void sendMsg(Socket client, byte[] getSensorData)
			throws IOException {
		OutputStream out = client.getOutputStream();
		if (!client.isClosed() && client.isConnected()
				&& !client.isOutputShutdown()) {
			out.write(getSensorData);
			out.flush();
		}

	}

	private byte[] rcvMsg(Socket client) throws IOException {
		// TODO Auto-generated method stub
		byte[] msg = new byte[51];
		InputStream in = client.getInputStream();
		in.read(msg);
		return msg;
	}

	public void setPause() {
		isPause = true;
	}

	private void sendMsg(Socket client, String data) throws IOException {
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(
				client.getOutputStream()));
		if (!client.isClosed() && client.isConnected()
				&& !client.isOutputShutdown()) {
			out.write(data + "\n");
			out.flush();
		}
	}

	public void unLockPause() {
		isPause = false;
	}

	public boolean isPause() {
		return isPause;
	}

	public void closeSocket() {
		isClosed = true;
	}
}
