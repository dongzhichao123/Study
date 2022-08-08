package com.dongchao.BIO.File;

import java.net.Socket;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ServerReaderThread {
  private ExecutorService executorService;
  public ServerReaderThread(int maxThreadNum ,int QueueSize){
      executorService=new ThreadPoolExecutor(3,maxThreadNum,60, TimeUnit.SECONDS,new ArrayBlockingQueue<Runnable>(QueueSize));
  }
  public void execute(Runnable target){
      executorService.execute(target);
  }
}
