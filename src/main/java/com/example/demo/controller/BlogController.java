package com.example.demo.controller;

import com.example.demo.domain.es.EsBlog;
import com.example.demo.repository.es.EsBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/blogs")
public class BlogController {
    @Autowired
    private EsBlogRepository esBlogRepository;

    public void initRepositoryData(){
        //清除所有数据
        esBlogRepository.deleteAll();
        esBlogRepository.save(new EsBlog("登鹳雀楼","王之涣的","白日，黄河，欲穷，更上"));
        esBlogRepository.save(new EsBlog("相思","王维的相思","红豆生南国，春来发几枝。愿君多采撷，此物最相思。"));
        esBlogRepository.save(new EsBlog("静夜思","李白的静夜思","床前明月光，疑是地上霜。举头望明月，低头思故乡。"));
        System.out.println("finished");
    }

    @GetMapping
    public List<EsBlog> list(@RequestParam(value="title") String title,
                             @RequestParam(value="summary") String summary,
                             @RequestParam(value="content") String content,
                             @RequestParam(value="pageIndex",defaultValue = "0") int pageIndex,
                             @RequestParam(value="pageSize",defaultValue = "10") int pageSize){
        initRepositoryData();
        Pageable pageable = PageRequest.of(pageIndex,pageSize);
        Page<EsBlog> page = esBlogRepository.findByTitleOrSummaryOrContent(title,summary,content,pageable);
        return page.getContent();
    }
}
