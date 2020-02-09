package com.example.demo.repository.es;

import com.example.demo.domain.es.EsBlog;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.domain.Pageable;

public interface EsBlogRepository extends ElasticsearchRepository<EsBlog,String> {
    //分页查询博客去重
    Page<EsBlog> findByTitleOrSummaryOrContent(String title, String summary, String content,Pageable pageable);

}
