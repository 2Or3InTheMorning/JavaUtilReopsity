package com.yang.javalib.httpclient4Util.HttpClient4Util;


import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.yang.javalib.ioUtil.rwopt.BufferWriterUtil;
import com.yang.javalib.threadUtil.ThreadPoolUtil;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.message.BasicNameValuePair;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.util.UriUtils;

import com.yang.javalib.httpclient4Util.dto.HttpResponseVO;

public class HttpClientUtilTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * @Description: OK, 发出httpClient请求, 这个也是可以 的.赞. 
	 * void
	 * @throws
	 */
	@Test
	public void test1DoGet() throws IOException {
		HttpClientUtil client = new HttpClientUtil();
        String targetUrl ="http://api.daili666.com/ip/?tid=770375867069069&filter=on&num=500";

        HttpResponseVO httpResponseVO =	client.doGet(targetUrl); //OK  百度查询关键字　HttpClient
	    System.out.println(httpResponseVO.toString());


		//client.doGet("http://www.qianbao666.com/ntask/home.html?co=0&po=0&ti=1&re=0&mr=0&mrb=&mre=&ty=0&p=1");
		 
	
	
	}

	/**
	 * @throws IOException 
	 * @throws ParseException 
	 * @Description: 这一个下载 的是JSON值 . 赞. 赞赞. 
	 * void
	 * @throws
	 */
	@Test
	public void test2DoPost() throws ParseException, IOException {
		HttpClientUtil client = new HttpClientUtil();
		
		  List<NameValuePair> formparams = new ArrayList<NameValuePair>();// 设置表格参数  
	        formparams.add(new BasicNameValuePair("usrname", "admin"));  
	        formparams.add(new BasicNameValuePair("password", "123456"));  
	        UrlEncodedFormEntity uefEntity = null;  
	        try {
	            uefEntity = new UrlEncodedFormEntity(formparams, "UTF-8");//获取实体对象  
	        } catch (UnsupportedEncodingException e) {  
	            e.printStackTrace();  
	        }
		 
	        
		client.doPost("http://www.qianbao666.com/task/listTask.html", uefEntity);
	}

	/**
	 * @Description: 可以使用，　赞，　就是文件格式，这个问题，　是固定　的吗　？
	 * @throws Exception
	 * void
	 * @throws
	 */
	@Test
	public void test3DownloadFile() throws Exception {
		String imgUrl="http://www.lashou.com/account/captcha";
		String imgSavePath="temp/yz.png";
		HttpClientUtil.downloadFile(imgUrl, imgSavePath);
	}

	@Test
	public void test403下载图片() throws Exception {

		HttpClientUtil client = new HttpClientUtil(); 
		HttpResponseVO httpResponseVO =client.doGet("http://www.03iii.com/zipai/list_2_1.html");
		 System.out.println("列表内容："+httpResponseVO.getContent());
		System.out.println("########################");
		
		httpResponseVO =client.doGet("http://www.03iii.com/zipai/2014/0522/7374.html");
		
		 System.out.println("单个文章内容："+httpResponseVO.getContent());
			System.out.println("########################");
		    String tt ="http://up.10gi.com/uploads/140501/%CD%B5%C5%C4%D7%D4%C5%C4%5B1%5D%2F%98O%C6%B7%C9%ED%B2%C4%B5%C4%D0%A1%D9%E2%F7%C8%C1%A6%CA%AE%D7%E3%C5%B688P%2F10%2Ejpg" ;
		   
			java.net.URLEncoder.encode(tt);
			System.out.println(java.net.URLDecoder.decode(tt));
			
			// http://hi.baidu.com/water_1221/item/90314616439c01048fbde46f
		String imgUrl="http://www.lashou.com/account/captcha";
		String imgSavePath="temp/yz.jpg";
		HttpClientUtil.downloadFile(tt, imgSavePath);
	}
	 

	@Test
	public void test403Decode() throws Exception {
		 String tt ="http://up.10gi.com/uploads/140501/%CD%B5%C5%C4%D7%D4%C5%C4%5B1%5D%2F%98O%C6%B7%C9%ED%B2%C4%B5%C4%D0%A1%D9%E2%F7%C8%C1%A6%CA%AE%D7%E3%C5%B688P%2F10%2Ejpg" ;
		 String url = "http://www.example.com/chapter1/%3Fref%3Dsomething%26term%3D?ref=xyz";
		 //URIUtils.extractHost(uri);
		// URI myUri = new URI(UriUtils.encodeHttpUrl(url)) ;
	    //System.out.println(java.net.URLDecoder.decode(tt));

			tt="http://up.10gi.com/uploads/140501/%CD%B5%C5%C4%D7%D4%C5%C4%5B1%5D%2F%CE%D2%BC%D2%B5%C4%B4%F3%B2%A8%C5%AE%BA%BA%D7%D319P%2F1%2Ejpg";
			
			//URLEncodedUtils.parse(entity)
			System.out.println(UriUtils.decode("%98O", "GBK")); //UriUtils.decode(tt, "GBK")

			//使用spring中的util可以 , 但是使用jdk的就不行. 难不成还得引入spring的. 

			System.out.println(UriUtils.decode("%98O", "GBK"));
			System.out.println(UriUtils.decode(tt, "GBK"));
			System.out.println(java.net.URLDecoder.decode(tt, "gb2312"));
			System.out.println(java.net.URLDecoder.decode(tt, "GB18030"));
	}
	
	@Test
	public void test403下载图片jpg() throws Exception {
		String tt = "http://up.10gi.com/uploads/140501/%CD%B5%C5%C4%D7%D4%C5%C4%5B1%5D%2F%98O%C6%B7%C9%ED%B2%C4%B5%C4%D0%A1%D9%E2%F7%C8%C1%A6%CA%AE%D7%E3%C5%B688P%2F10%2Ejpg";

		java.net.URLEncoder.encode(tt);

		// http://hi.baidu.com/water_1221/item/90314616439c01048fbde46f
		String imgUrl = "http://www.lashou.com/account/captcha";
		String imgSavePath = "temp/jingcaituijian06.jpg";
		HttpClientUtil.downloadFile(tt, imgSavePath);

		tt="http://up.10gi.com/uploads/140501/%CD%B5%C5%C4%D7%D4%C5%C4%5B1%5D%2F%CE%D2%BC%D2%B5%C4%B4%F3%B2%A8%C5%AE%BA%BA%D7%D319P%2F1%2Ejpg";
		
		//URLEncodedUtils.parse(entity)
		System.out.println(UriUtils.decode("%98O", "GBK")); //UriUtils.decode(tt, "GBK")

		//使用spring中的util可以 , 但是使用jdk的就不行. 难不成还得引入spring的. 

		System.out.println(UriUtils.decode("%98O", "GBK"));
		System.out.println(UriUtils.decode(tt, "GBK"));
		System.out.println(java.net.URLDecoder.decode(tt, "gb2312"));
		System.out.println(java.net.URLDecoder.decode(tt, "GB18030"));
		System.out.println(java.net.URLDecoder.decode(tt, "utf-8"));
		System.out.println(java.net.URLDecoder.decode(tt, "GBK"));
		System.out.println(java.net.URLDecoder.decode(tt, "Big5"));
		System.out.println(java.net.URLDecoder.decode(tt, "Unicode"));
		System.out.println(java.net.URLDecoder.decode(tt, "GB18030"));
	}

	@Test
	public void test503文章处理() throws Exception {

	String	tt="http://up.10gi.com/uploads/140501/%CD%B5%C5%C4%D7%D4%C5%C4%5B1%5D%2F%CE%D2%BC%D2%B5%C4%B4%F3%B2%A8%C5%AE%BA%BA%D7%D319P%2F1%2Ejpg";
	//tt="http://up.10gi.com/uploads/140501/%CD%B5%C5%C4%D7%D4%C5%C4%5B1%5D%2F10%2D25%D7%EE%CF%B2%BB%B6%C5%AE%D3%D1%A3%AC%BA%AC%C7%E9%C4%AC%C4%AC%B5%D8%CE%AA%CE%D2%B4%B5%F3%EF%A3%A115P%2F1%2Ejpg";
	
	
	String imgUrl =	UriUtils.decode(tt, "GBK");
	HttpClientUtil.downloadFile(tt, "temp/ttt2.jpg");
	
	   /*HttpClient client = new HttpClient();  
       GetMethod get = new GetMethod("http://images.sohu.com/uiue/sohu_logo/beijing2008/2008sohu.gif");  
       client.executeMethod(get);  
       File storeFile = new File("c:/2008sohu.gif");  
       FileOutputStream output = new FileOutputStream(storeFile);  
       //得到网络资源的字节数组,并写入文件  
       output.write(get.getResponseBody());  
       output.close();  */
	

	
	
	}


    /**
     * post使用代理测试　．
     * @throws Exception
     */
    @Test
    public void testPostProx() throws Exception{

        HttpClientUtil client = new HttpClientUtil();
        String targetUrl ="http://m.nanhunnvjia.com/m/minfo/7.html";

        List<NameValuePair> formparams = new ArrayList<NameValuePair>();// 设置表格参数
        formparams.add(new BasicNameValuePair("vid", "26"));
        UrlEncodedFormEntity uefEntity = null;
        try {
            uefEntity = new UrlEncodedFormEntity(formparams, "UTF-8");//获取实体对象
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
       @SuppressWarnings("unchecked")
        List<String> pros = FileUtils.readLines(new File("HttpClient4Util/conf/prox2.txt"));

        for (String item : pros) {
            String[] ipPort = item.split(":");
            if (ipPort.length != 2)
                continue;

            try {
                HttpResponseVO httpResponseVO = client.doPost(targetUrl, uefEntity,ipPort[0].trim(), Integer.parseInt(ipPort[1].trim()));
                System.out.println("输出结果为:"+httpResponseVO.toString());
            } catch (Exception e) {
                System.out.println("出错" + item);
            }
            System.out.println("IP--" + item + "_OK");
            Thread.sleep(2000);
        }
    }

    @Test
    public void test1Auto() throws Exception {
        BufferWriterUtil bufferWriterUtil  =BufferWriterUtil.buildBufferedWriter("HttpClient4Util/conf/prox2.txt");;
        HttpClientUtil client = new HttpClientUtil();
        String targetUrl ="http://api.daili666.com/ip/?tid=770080190199069&num=200&filter=on";
        while(true){
            HttpResponseVO httpResponseVO =	client.doGet(targetUrl); //OK  百度查询关键字　HttpClient
             if(httpResponseVO.getContent().contains(":")){
                 System.out.println("得到端口列表:"+httpResponseVO.getContent());
                 List<String> temp = Arrays.asList(httpResponseVO.getContent().split("\r\n"));
                 List<String>  okIpPort =testProxThread(temp);
                 for (String item:okIpPort){
                     bufferWriterUtil.writeLine(item);
                 }
                 bufferWriterUtil.flush();
            }
            Thread.currentThread().sleep(120*000);
        }
    }


    @Test
    public void testProxThreadALLL() throws Exception{
        String filaPath="HttpClient4Util/conf/prox.txt";
        List<String> pros = FileUtils.readLines(new File(filaPath));
        testProxThread(pros);
    }

    @Test
    public void testProxThread11111111111() throws Exception{
        String filaPath="HttpClient4Util/conf/prox1.txt";
        List<String> pros = FileUtils.readLines(new File(filaPath));
        testProxThread(pros);
    }


    private static final ThreadPoolUtil threadPoolUtil = ThreadPoolUtil.getInstance();

    public List<String> testProxThread(List<String> pros ) throws Exception{

        final List<FetchJobRunnable> jobLists =new ArrayList<FetchJobRunnable>();

        new BatchHelper<String>(20,pros){
            @Override
            public void eachBatch(List<String> subList) {
                FetchJobRunnable fetchJobRunnableItem = new FetchJobRunnable(subList);
                jobLists.add(fetchJobRunnableItem);
                threadPoolUtil.add(fetchJobRunnableItem);
            }
        }.executeBatch();

        boolean _tt=false;//都为true才结果
        while (!_tt){
            _tt=true;
            for(int i=0;i<jobLists.size();i++){
               if( !jobLists.get(i).isOver){//有一个为false
                   _tt=false;
                   break ;
               }
            }
            Thread.currentThread().sleep(500);
        }


        List<String> okIpPortAll=new ArrayList<String>();
         int totalNum = 0;
        for(int i=0;i<jobLists.size();i++){
            totalNum+=jobLists.get(i).okNum;
            okIpPortAll.addAll(jobLists.get(i).okIpPort);
        }
        System.out.println("////////////////////////:最终结果//////////////");
        System.out.println("输出结果: 有效值:"+totalNum+" +总值:"+pros.size()+"  有效百分比为:"+(totalNum*100)/pros.size() +" %");

        return okIpPortAll;
    }

}


class FetchJobRunnable implements  Runnable{
    private List<String> ipPort;

    public List<String>  okIpPort=new ArrayList<String>();

    public boolean isOver =false;
    public int okNum=0;


    public FetchJobRunnable(List<String> ipPort) {
        this.ipPort = ipPort;
    }

    @Override
    public void run() {
        HttpClientUtil client = new HttpClientUtil();
        String targetUrl ="http://m.nanhunnvjia.com/m/minfo/7.html";

        List<NameValuePair> formparams = new ArrayList<NameValuePair>();// 设置表格参数
        formparams.add(new BasicNameValuePair("vid", "26"));
        UrlEncodedFormEntity uefEntity = null;
        try {
            uefEntity = new UrlEncodedFormEntity(formparams, "UTF-8");//获取实体对象
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        for (String item : ipPort) {
            String[] ipPort = item.split(":");
            if (ipPort.length != 2)
                continue;
            try {
                HttpResponseVO httpResponseVO = client.doPost(targetUrl, uefEntity,ipPort[0].trim(), Integer.parseInt(ipPort[1].trim()));
                System.out.println("输出结果为:"+httpResponseVO.toString());
               if(  NumberUtils.isNumber(httpResponseVO.getContent())){

                   okNum++;
                   okIpPort.add(item);
               }
            } catch (Exception e) {
                System.out.println("出错" + item);
                continue;
            }
            System.out.println("IP--" + item + "_OK");
        }
        isOver=true;
    }
}

abstract class BatchHelper<T>{

    /**
     * 每一次提交数量
     */
    private int oneBatchCount;

    /**
     * 准备提交的所有数据
     */
    private List<T> allDatas;

    /**
     * 由上两个值计算出来的页码与最后一页数量
     */
    private int pageNo,lastPageCount;

    public BatchHelper( List<T> allDatas) {
        this(100,allDatas);
    }

    public BatchHelper(int oneBatchCount, List<T> allDatas) {
        this.oneBatchCount = oneBatchCount;
        this.allDatas = allDatas;

        pageNo = allDatas.size()/oneBatchCount;//从0页开始
        lastPageCount=allDatas.size()%oneBatchCount;
        if(lastPageCount==0)//最后一页为0时, 那么总页数要-1
            pageNo--;
    }

    /**
     * 执行提交
     *
     * @return
     */
    public void executeBatch(){
        int from_index,to_index;
        for(int i=0;i<=pageNo;i++){
            from_index=i*oneBatchCount;
            //最后一页且最后一页数量不为0时.
            to_index= i==pageNo && lastPageCount!=0 ? i*oneBatchCount+lastPageCount-1:  ((i+1)*oneBatchCount)-1 ;
            eachBatch(allDatas.subList(from_index,to_index+1));//开区间
        }
    }

    /**
     * 处理每一次的子集数据
     * @param subList
     */
    public abstract void eachBatch(List<T> subList);

}