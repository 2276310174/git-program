package com.itheima.lucene;

import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StoredField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.Term;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.junit.Test;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.File;
import java.io.IOException;
import java.util.function.DoubleConsumer;

public class IndexManager {

    @Test
    public void addDocumentIndex(){
        try {
            //创建一个IndexWriter对象需要使用IKanalyzer分析器
            Directory directory = FSDirectory.open(new File("F:\\file\\directory").toPath());
            IndexWriter indexWriter = new IndexWriter(directory,new IndexWriterConfig(new IKAnalyzer()));
//            创建一个Document
            Document document = new Document();
//            向document对象中添加域
            document.add(new TextField("name","新添加的文件",Field.Store.YES));
            document.add(new TextField("content","新添加的内容",Field.Store.NO));
            document.add(new StoredField("path","c:\\file"));
//            把文档写入索引库
            indexWriter.addDocument(document);
//            关闭indexWriter链接
            indexWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void deleteDocumentAll() throws IOException {
        IndexWriter indexWriter = new IndexWriter(FSDirectory.open(new File("F:\\file\\directory").toPath())
                ,new IndexWriterConfig(new IKAnalyzer()));
        indexWriter.deleteAll();
        indexWriter.close();
    }

    @Test
    public void deleteDocumentBySearch() throws IOException {
        IndexWriter indexWriter = new IndexWriter(FSDirectory.open(new File("F:\\file\\directory").toPath())
                ,new IndexWriterConfig(new IKAnalyzer()));

        indexWriter.deleteDocuments(new Term("name","apache"));
        indexWriter.close();
    }

    @Test
    public void updateDocument() throws IOException {
        IndexWriter indexWriter = new IndexWriter(FSDirectory.open(new File("F:\\file\\directory").toPath())
                ,new IndexWriterConfig(new IKAnalyzer()));
        Document document = new Document();
        document.add(new TextField("name","修改后的文件",Field.Store.YES));
        document.add(new TextField("name1","修改后的文件",Field.Store.YES));
        document.add(new TextField("name2","修改后的文件",Field.Store.YES));
        indexWriter.updateDocument(new Term("name","spring"),document);
        indexWriter.close();
    }

}
