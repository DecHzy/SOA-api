package news;

import com.alibaba.fastjson.JSONObject;
import com.show.api.ShowapiRequest;

import java.util.Iterator;
import java.util.Map;

public class Demo {

    public static String appcode = "8f6fdadab3044adbb5f5f2d374dabbbf";

    public static void main(String[] args) throws Exception {
        Demo.newsList();
        System.out.println("分割线###########");
        Demo.newsChannel();
    }

    /**
     * 新闻频道查询
     */
    public static void newsChannel() throws Exception {
        ShowapiRequest req = new ShowapiRequest("https://ali-news.showapi.com/channelList", appcode);
        byte b[] = req.getAsByte();
        //打印返回头
        Map map = req.getRes_headMap();
        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            Object k = it.next();
            System.out.println(k + " " + map.get(k));
        }
        //打印返回体
        String res = new String(b, "utf-8");
        System.out.println(res);
        //下面是使用阿里的fastjson包解析。如果不需要，请使用自己的解析包
        JSONObject json = JSONObject.parseObject(res);
        System.out.println("分割线-------------");
        System.out.println(json.getJSONObject("showapi_res_body"));
    }

    /**
     * 新闻列表查询
     */
    public static void newsList() throws Exception {
        ShowapiRequest req = new ShowapiRequest("https://ali-news.showapi.com/newsList", appcode);
        byte b[] = req.addTextPara("channelId", "")
                .addTextPara("channelName", "")
                .addTextPara("title", "湖南")
                .addTextPara("page", "1")
                .addTextPara("needContent", "0")
                .addTextPara("needHtml", "0")
                .addTextPara("needAllList", "0")
                .addTextPara("maxResult", "20")
                .addTextPara("id", "")
                .getAsByte();
        //打印返回头
        Map map = req.getRes_headMap();
        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            Object k = it.next();
            System.out.println(k + " " + map.get(k));
        }
        //打印返回体
        String res = new String(b, "utf-8");
        System.out.println(res);
        //下面是使用阿里的fastjson包解析。如果不需要，请使用自己的解析包
        JSONObject json = JSONObject.parseObject(res);
        System.out.println("分割线-------------");
        System.out.println(json.getJSONObject("showapi_res_body"));
    }
}


