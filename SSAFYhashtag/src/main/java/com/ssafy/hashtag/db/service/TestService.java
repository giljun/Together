package com.ssafy.hashtag.db.service;

import java.io.BufferedInputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import com.ssafy.hashtag.db.dto.PostDto;
import com.ssafy.hashtag.db.dto.Test;
import com.ssafy.hashtag.db.dao.TestDao;

@Service
public class TestService {

    @Autowired
    private TestDao testdao;

    public List<Test> Getall() throws Exception {
        System.out.println("****************Getall**********************");

        return testdao.Getall();
    }

    public void locationBasedList() throws Exception {
        System.out.println("****************add locationBasedList**********************");

        List<Map<String, Object>> lists = new ArrayList<Map<String, Object>>();

        lists = insertInfo();

        PostDto postdto = new PostDto();

        for (int i = 0; i < lists.size(); i++) {
            System.out.println("****************add in for**********************");

            Map map = lists.get(i);

            postdto.setAddress((String) map.get("address"));
            postdto.setImage((String) map.get("image"));
            postdto.setTitle((String) map.get("title"));
            postdto.setAreacode((int) map.get("areacode"));
            postdto.setContent_id((int) map.get("content_id"));
            postdto.setCat3((String) map.get("cat3"));
            postdto.setContent_type_id((int) map.get("content_type_id"));

            testdao.addlocationBasedList(postdto);
            System.out.println(postdto.toString());

        }
    }

    public List<Map<String, Object>> insertInfo() throws Exception {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

        URL url = new URL("http://api.visitkorea.or.kr/openapi/service/rest/KorService/locationBasedList?ServiceKey=rbssLvuPaumnRlgRCPsgU5IeLlHAf5nHHGU8P3JVSYqJvgSFL8l%2FJbCYNE9zVd5Je%2BFoFlSBFo%2Fochd7h97a%2Fg%3D%3D&mapX=126.981611&mapY=37.568477&radius=1000&listYN=Y&arrange=A&MobileOS=ETC&MobileApp=AppTest&numOfRows=100");

        XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
        factory.setNamespaceAware(true);
        XmlPullParser xpp = factory.newPullParser();
        BufferedInputStream bis = new BufferedInputStream(url.openStream());
        xpp.setInput(bis, "utf-8");

        String tag = null;
        int event_type = xpp.getEventType();

        Map<String, Object> tempMap = null;

        while (event_type != XmlPullParser.END_DOCUMENT) {
            if (event_type == XmlPullParser.START_TAG) {
                tag = xpp.getName();
                if (tag.equals("item")) {
                    tempMap = new HashMap<String, Object>();
                }
            } else if (event_type == XmlPullParser.TEXT) {
                if (tag.equals("firstimage")) {
                    tempMap.put("image", xpp.getText());
                } else if (tag.equals("addr1")) {
                    tempMap.put("address", xpp.getText());
                } else if (tag.equals("title")) {
                    tempMap.put("title", xpp.getText());
                } else if (tag.equals("areacode")) {
                    tempMap.put("areacode", Integer.parseInt(xpp.getText()));
                } else if (tag.equals("contentid")) {
                    tempMap.put("content_id", Integer.parseInt(xpp.getText()));
                } else if (tag.equals("cat3")) {
                    tempMap.put("cat3", xpp.getText());
                } else if (tag.equals("contenttypeid")) {
                    tempMap.put("content_type_id", Integer.parseInt(xpp.getText()));
                }

            } else if (event_type == XmlPullParser.END_TAG) {
                tag = xpp.getName();
                if (tag.equals("item")) {
                    list.add(tempMap);
                }
            }
            event_type = xpp.next();
        }
        bis.close();
        return list;
    }
}
