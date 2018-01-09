package com.example.cuteu.utils;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import java.io.*;
import java.net.*;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;


/**
 * Http请求工具类
 */
public class HttpUtils {
    private static Logger logger = LoggerFactory.getLogger(HttpUtils.class);

    /**
     * 创建 HTTPS 链接客户端,默认信任证书,不跟随重定向
     *
     * @return HTTP 连接
     */
    private static CloseableHttpClient createHttpsClient()
            throws KeyStoreException, NoSuchAlgorithmException, KeyManagementException {
        SSLContext sslContext = new SSLContextBuilder()
                .loadTrustMaterial(null, (chain, authType) -> true).build();
        SSLConnectionSocketFactory sslConnectionSocketFactory = new SSLConnectionSocketFactory(sslContext);
        return HttpClients.custom()
                .setUserAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.84 Safari/537.36")
                .setSSLSocketFactory(sslConnectionSocketFactory)
                .build();
    }

    /**
     * 发送 get 请求
     *
     * @param url     请求 url
     * @param headers 请求头数组
     * @return 响应结果字符串
     * @throws NoSuchAlgorithmException
     * @throws KeyStoreException
     * @throws KeyManagementException
     * @throws IOException
     */
    public static String get(String url, Header[] headers)
            throws NoSuchAlgorithmException, KeyStoreException, KeyManagementException, IOException {
        CloseableHttpClient httpClient = createHttpsClient();
        HttpGet httpGet = new HttpGet(url);
        httpGet.setHeaders(headers);
        HttpResponse httpResponse = httpClient.execute(httpGet);
        String result = entity2String(httpResponse.getEntity());

        // 关闭资源
        httpClient.close();
        httpGet.releaseConnection();
        return result;
    }

    /**
     * 发送 get 请求
     *
     * @param url 请求 url
     * @return 响应结果字符串
     * @throws NoSuchAlgorithmException
     * @throws KeyStoreException
     * @throws KeyManagementException
     * @throws IOException
     */
    public static String get(String url)
            throws NoSuchAlgorithmException, KeyStoreException, KeyManagementException, IOException {
        return get(url, null);
    }

    /**
     * 发送 post 请求
     *
     * @param url     请求 url
     * @param headers 请求头
     * @param entity  请求实体
     * @return 响应结果字符串
     * @throws NoSuchAlgorithmException
     * @throws KeyStoreException
     * @throws KeyManagementException
     * @throws IOException
     */
    public static String post(String url, Header[] headers, HttpEntity entity)
            throws NoSuchAlgorithmException, KeyStoreException, KeyManagementException, IOException {
        CloseableHttpClient httpClient = createHttpsClient();
        HttpPost httpPost = new HttpPost(url);
        httpPost.setHeaders(headers);
        httpPost.setEntity(entity);
        HttpResponse httpResponse = httpClient.execute(httpPost);
        String result = entity2String(httpResponse.getEntity());

        // 关闭资源
        httpClient.close();
        httpPost.releaseConnection();
        return result;
    }

    /**
     * 发送 post 请求
     *
     * @param url 请求 url
     * @return 响应结果字符串
     * @throws NoSuchAlgorithmException
     * @throws KeyStoreException
     * @throws KeyManagementException
     * @throws IOException
     */
    public static String post(String url)
            throws IOException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
        return post(url, null, null);
    }

    /**
     * 发送 post 请求
     *
     * @param url     请求 url
     * @param headers 请求头
     * @return 响应结果字符串
     * @throws NoSuchAlgorithmException
     * @throws KeyStoreException
     * @throws KeyManagementException
     * @throws IOException
     */
    public static String post(String url, Header[] headers)
            throws IOException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
        return post(url, headers, null);
    }

    /**
     * 发送 post 请求
     *
     * @param url    请求 url
     * @param entity 请求体
     * @return 响应结果字符串
     * @throws NoSuchAlgorithmException
     * @throws KeyStoreException
     * @throws KeyManagementException
     * @throws IOException
     */
    public static String post(String url, HttpEntity entity)
            throws IOException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
        return post(url, null, entity);
    }

    /**
     * 将响应实体拼接成字符串返回
     *
     * @param entity 响应实体
     * @return 实体字符串
     */
    private static String entity2String(HttpEntity entity) {
        StringBuilder content = new StringBuilder();
        try (InputStream inputStream = entity.getContent();
             InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
            // 读取数据
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                content.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.toString();
    }


    /**
     * 微信请求专用
     *
     * @param url
     * @param charset
     * @param timeout
     * @return
     */
    public static String sendGet(String url, String charset, int timeout) {
        String result = "";
        try {
            URL u = new URL(url);
            try {
                URLConnection conn = u.openConnection();
                conn.connect();
                conn.setConnectTimeout(timeout);
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), charset));
                String line = "";
                while ((line = in.readLine()) != null) {

                    result = result + line;
                }
                in.close();
            } catch (IOException e) {
                return result;
            }
        } catch (MalformedURLException e) {
            return result;
        }

        return result;
    }

    // 设置body体
    public static void setBodyParameter(String sb, HttpURLConnection conn)
            throws IOException {
        DataOutputStream out = new DataOutputStream(conn.getOutputStream());
        out.writeBytes(sb);
        out.flush();
        out.close();
    }

    // 添加签名header
    public static HttpURLConnection CreatePostHttpConnection(String uri) throws MalformedURLException,
            IOException, ProtocolException {
        URL url = new URL(uri);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setUseCaches(false);
        conn.setDoInput(true);
        conn.setDoOutput(true);
        conn.setRequestMethod("POST");
        conn.setInstanceFollowRedirects(true);
        conn.setConnectTimeout(30000);
        conn.setReadTimeout(30000);
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setRequestProperty("Accept-Charset", "utf-8");
        conn.setRequestProperty("contentType", "utf-8");
        return conn;
    }

    public static byte[] readInputStream(InputStream inStream) throws Exception {
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        while ((len = inStream.read(buffer)) != -1) {
            outStream.write(buffer, 0, len);
        }
        byte[] data = outStream.toByteArray();
        outStream.close();
        inStream.close();
        return data;
    }

    /**
     * 发送https请求
     *
     * @param requestUrl    请求地址
     * @param requestMethod 请求方式（GET、POST）
     * @param outputStr     提交的数据
     * @return 返回微信服务器响应的信息
     * @throws Exception
     */
    public static String httpsRequest(String requestUrl, String requestMethod,
                                      String outputStr) throws Exception {
        try {
            // 创建SSLContext对象，并使用我们指定的信任管理器初始化
            TrustManager[] tm = {new FsTrustManager()};
            SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
            sslContext.init(null, tm, new java.security.SecureRandom());
            // 从上述SSLContext对象中得到SSLSocketFactory对象
            SSLSocketFactory ssf = sslContext.getSocketFactory();
            URL url = new URL(requestUrl);
            HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
            //使用http请求
//            conn.setSSLSocketFactory(ssf);
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);
            // 设置请求方式（GET/POST）
            conn.setRequestMethod(requestMethod);
            conn.setRequestProperty("content-type",
                    "application/x-www-form-urlencoded");
            // 当outputStr不为null时向输出流写数据
            if (null != outputStr) {
                OutputStream outputStream = conn.getOutputStream();
                // 注意编码格式
                outputStream.write(outputStr.getBytes("UTF-8"));
                outputStream.close();
            }
            // 从输入流读取返回内容
            InputStream inputStream = conn.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(
                    inputStream, "UTF-8");
            BufferedReader bufferedReader = new BufferedReader(
                    inputStreamReader);
            String str = null;
            StringBuffer buffer = new StringBuffer();
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }
            // 释放资源
            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();
            inputStream = null;
            conn.disconnect();
            return buffer.toString();
        } catch (ConnectException ce) {
            logger.error("连接超时：{}", ce);
            throw new RuntimeException("链接异常" + ce);
        } catch (Exception e) {
            logger.error("https请求异常：{}", e);
            throw new RuntimeException("https请求异常" + e);
        }

    }


    /**
     * 发送 get 请求
     *
     * @param url     请求 url
     * @param headers 请求头数组
     * @return 响应结果字符串
     * @throws NoSuchAlgorithmException
     * @throws KeyStoreException
     * @throws KeyManagementException
     * @throws IOException
     */
    public static String sendGet(String url, Header[] headers)
            throws NoSuchAlgorithmException, KeyStoreException, KeyManagementException, IOException {
        URL strUrl = new URL(url);
        URI uri = null;
        try {
            uri = new URI(strUrl.getProtocol(), strUrl.getHost(),
                    strUrl.getPath(), strUrl.getQuery(), null);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        CloseableHttpClient httpClient = createHttpsClient();
        HttpGet httpGet = new HttpGet(uri);
        httpGet.setHeaders(headers);
        HttpResponse httpResponse = httpClient.execute(httpGet);
        String result = entity2String(httpResponse.getEntity());
        // 关闭资源
        httpClient.close();
        httpGet.releaseConnection();
        return result;
    }


}