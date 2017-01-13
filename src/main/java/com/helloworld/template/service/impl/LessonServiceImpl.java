package com.helloworld.template.service.impl;

import java.io.IOException;
import java.util.List;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.helloworld.template.entity.Lesson;
import com.helloworld.template.service.LessonService;

@Service("lessonService")
public class LessonServiceImpl implements LessonService {

	@Override
	public List<Lesson> getLessonByName(String name) {
		List<Lesson> lessonList = null;

		CloseableHttpClient httpclient = HttpClients.createDefault();
		try {
			// 创建httpget.
			HttpGet httpget = new HttpGet("http://tongjilab.cn:7788/lesson/?name=" + name);
			System.out.println("executing request " + httpget.getURI());
			// 执行get请求.
			CloseableHttpResponse response = httpclient.execute(httpget);
			try {
				// 获取响应实体
				HttpEntity entity = response.getEntity();
				System.out.println("--------------------------------------");
				// 打印响应状态
				System.out.println(response.getStatusLine());
				if (entity != null) {
					// 打印响应内容长度
					// System.out.println("Response content length: " +
					// entity.getContentLength());
					// 打印响应内容
					String lessonJson = EntityUtils.toString(entity, Consts.UTF_8);
					System.out.println("Response content: " + lessonJson);

					if (!lessonJson.equals("{}")) {
						ObjectMapper mapper = new ObjectMapper();
						JavaType javaType = mapper.getTypeFactory().constructParametricType(List.class, Lesson.class);
						lessonList = mapper.readValue(lessonJson, javaType);
					}
				}
				System.out.println("------------------------------------");
			} finally {
				response.close();
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 关闭连接,释放资源
			try {
				httpclient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return lessonList;
	}

}
