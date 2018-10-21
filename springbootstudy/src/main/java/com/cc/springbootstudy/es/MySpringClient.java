package com.cc.springbootstudy.es;

import java.util.ArrayList;
import java.util.List;

import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.DeleteQuery;
import org.springframework.data.elasticsearch.core.query.IndexQueryBuilder;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.data.elasticsearch.core.query.StringQuery;
import org.springframework.data.elasticsearch.core.query.UpdateQuery;
import org.springframework.data.elasticsearch.core.query.UpdateQueryBuilder;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;

@Service
public class MySpringClient {
	@Autowired
	private ElasticsearchTemplate et;
	
	public final static String INDEX_NAME = "mytest3";
	public final static String PRODUCT_DOCUMENT_TYPE = "product";
	
	
	private void createIndex() {
		boolean f =et.createIndex(INDEX_NAME);
		if (f) {
			System.out.println("haha,create index success!");
		} else {
			System.out.println("wuwu,create index failed!");
		}
	}

	private void addData() {
		List<String> cats = new ArrayList<String>();
		cats.add("3c");
		cats.add("computer");

		TestModel tm = new TestModel("p3", "333 mac book �ʼǱ�", 333, cats);

		String jsonData = JSON.toJSONString(tm);

		et.index(new IndexQueryBuilder().withIndexName(INDEX_NAME)
				.withType(PRODUCT_DOCUMENT_TYPE)
				.withId(tm.getUuid())
				.withSource(jsonData)
				.build()
				);
	}

	private void getData() {
		StringQuery queryStr = new StringQuery(QueryBuilders.termQuery("uuid", "p1").toString()); 
		
		TestModel result = et.queryForObject(queryStr,TestModel.class);
		
		System.out.println("source===" + result);
	}

	private void getByQuery() {
		SearchQuery searchQuery = new NativeSearchQueryBuilder()
				.withIndices(INDEX_NAME)
				.withTypes(PRODUCT_DOCUMENT_TYPE)
				.withQuery(QueryBuilders.matchQuery("name", "mac"))
				.withPageable(new PageRequest(0,10)).build();
		
		List<TestModel> result = et.queryForList(searchQuery, TestModel.class);
		
		System.out.println("query result===" + result);
	}
	private void updateData(){
		List<String> cats = new ArrayList<String>();
		cats.add("3c update");
		cats.add("computer");

		TestModel tm = new TestModel("p1", "mac book �ʼǱ� update", 54321, cats);
		
		IndexRequest indexRequest = new IndexRequest();
		indexRequest.source(JSON.toJSONString(tm));
		
		UpdateQuery updateQuery = new UpdateQueryBuilder()
			.withIndexName(INDEX_NAME)
			.withType(PRODUCT_DOCUMENT_TYPE)
			.withId(tm.getUuid())
			.withIndexRequest(indexRequest)
			.withClass(TestModel.class)
			.build();
		
		et.update(updateQuery);
	}
	private void deleteData(){
		DeleteQuery deleteQuery = new DeleteQuery();
		deleteQuery.setQuery(QueryBuilders.termQuery("uuid", "p1"));
		deleteQuery.setIndex(INDEX_NAME);
		deleteQuery.setType(PRODUCT_DOCUMENT_TYPE);
		
		et.delete(deleteQuery);
	}
	private void deleteIndex(){
		et.deleteIndex(INDEX_NAME);
	}
	
	private void scrollData(){
		SearchQuery searchQuery = new NativeSearchQueryBuilder()
			.withIndices(INDEX_NAME)
			.withTypes(PRODUCT_DOCUMENT_TYPE)
//			.withQuery(QueryBuilders.matchQuery("name", "222"))
			.withQuery(QueryBuilders.matchAllQuery())
			.withPageable(new PageRequest(0,1)).build();
		
		String scrollId = et.scan(searchQuery, 1000, false);
		
		while (true) {
			Page<TestModel> page = et.scroll(scrollId, 5000L,TestModel.class);
			if(page.hasContent()){
				System.out.println("now scroll==="+page.getContent());				
			}else{
				break;
			}
		}
		
	}
	

	public void testES() {
//		this.createIndex();
//		this.addData();
		this.getData();
		this.getByQuery();
//		mt.updateData();
//		mt.deleteData();
//		mt.scrollData();
//		mt.aggr();
//		mt.getByQueryWithHighLight();
	}
	
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"applicationContext.xml","applicationContext-es.xml"
				);
		MySpringClient mt = (MySpringClient)ctx.getBean("mySpringClient");
		
//		mt.createIndex();
//		mt.addData();
//		mt.getData();
//		mt.getByQuery();
//		mt.updateData();
//		mt.deleteData();
//		mt.scrollData();
//		mt.aggr();
//		mt.getByQueryWithHighLight();
	}
}
