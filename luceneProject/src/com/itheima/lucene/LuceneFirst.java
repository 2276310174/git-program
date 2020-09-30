package com.itheima.lucene;


import org.apache.commons.io.FileUtils;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.CharacterUtils;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.document.*;
import org.apache.lucene.index.*;
import org.apache.lucene.search.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.junit.Test;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.File;
import java.io.IOException;

public class LuceneFirst {

    @Test
    public void stroeFile(){
        try {
            // 1、创建一个Director对象，指定索引库保存的位置
            Directory directory = FSDirectory.open(new File("F:\\file\\directory").toPath());
            // 2、基于Directory对象创建一个IndexWriter对象
            IndexWriter indexWriter = new IndexWriter(directory,new IndexWriterConfig());
            // 3、读取磁盘上的文件，对应每个文件创建一个文档对象。
            File file = new File("F:\\百度网盘\\lucene\\02.参考资料\\searchsource");
            File[] files = file.listFiles();
            for (File f : files) {
//                获取文件名
                String name = f.getName();
//                获取文件路径
                String path = f.getPath();
//                获取文件内容
                String content = FileUtils.readFileToString(f, "utf-8");
//                获取文件的大小
                long size = FileUtils.sizeOf(f);
//                创建Field对象
                Field fieldName = new TextField("name",name,Field.Store.YES);
                Field fieldpath = new TextField("path",path,Field.Store.YES);
                Field fieldcontent = new TextField("content",content,Field.Store.YES);
                Field fieldsize = new TextField("size",size + "",Field.Store.YES);
                // 4、向文档对象中添加域
//                创建文档对象
                Document document = new Document();
                document.add(fieldName);
                document.add(fieldpath);
                document.add(fieldcontent);
                document.add(fieldsize);
                // 5、把文档对象写入索引库
                indexWriter.addDocument(document);
            }
            // 6、关闭indexwriter对象
            indexWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void luceneRead(){

        try {
            //1、创建一个Director对象，指定索引库的位置 zhi
            Directory directory = FSDirectory.open(new File("F:\\file\\directory").toPath());
            //2、创建一个IndexReader对象
            IndexReader indexReader = DirectoryReader.open(directory);
            //3、创建一个IndexSearcher对象，构造方法中的参数indexReader对象。
            IndexSearcher indexSearcher = new IndexSearcher(indexReader);
            //4、创建一个Query对象，TermQuery
            Query query = new TermQuery(new Term("name","spring"));
            //5、执行查询，得到一个TopDocs对象
//            参数一：查询列表，参数二：查询返回的最大记录数
            TopDocs topDocs = indexSearcher.search(query, 10);
            //6、取查询结果的总记录数
            System.out.println("查询总记录数：" + topDocs.totalHits);
            //7、取文档列表
            ScoreDoc[] scoreDocs = topDocs.scoreDocs;
            //8、打印文档中的内容
            for (ScoreDoc scoreDoc : scoreDocs) {
//                获取文档id
                int doc = scoreDoc.doc;
                Document document = indexSearcher.doc(doc);
                System.out.println("文档内容："+document.get("name") + document.get("path")+document.get("size"));
                System.out.println("*************************************************************************");
            }
            //9、关闭IndexReader对象
            indexReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


      @Test
    public void testTokenStream() throws IOException {
    //1）创建一个Analyzer对象，StandardAnalyzer对象
        Analyzer analyzer = new StandardAnalyzer();
    //2）使用分析器对象的tokenStream方法获得一个TokenStream对象
        TokenStream test = analyzer.tokenStream("", "test,the spring framework" +
                " provides a comprehensive programming and configuration model.");
        //3）向TokenStream对象中设置一个引用，相当于数一个指针
        CharTermAttribute charTermAttribute = test.addAttribute(CharTermAttribute.class);
        //4）调用TokenStream对象的rest方法。如果不调用抛异常
        test.reset();
    //5）使用while循环遍历TokenStream对象
        while(test.incrementToken()){
            System.out.println(charTermAttribute.toString());
        }
    //6）关闭TokenStream对象
        test.close();
    }

    @Test
    public void testTokenStreamIK() throws IOException {
        //1）创建一个Analyzer对象，StandardAnalyzer对象
        Analyzer analyzer = new IKAnalyzer();
        //2）使用分析器对象的tokenStream方法获得一个TokenStream对象
        TokenStream test = analyzer.tokenStream("", "Subsco是干净和创意设计企业网站 传智播客" +
                "HTML模板，可用作设计施工、公安局、公安、建筑公司、装修和装修" +
                "承包商服务或任何建设施工业务，展示工作,服务用专业" +
                "的方式。这个模板有漂亮和独特的设计,最适合你的在线网站。模板基于");
        //3）向TokenStream对象中设置一个引用，相当于数一个指针
        CharTermAttribute charTermAttribute = test.addAttribute(CharTermAttribute.class);
        //4）调用TokenStream对象的rest方法。如果不调用抛异常
        test.reset();
        //5）使用while循环遍历TokenStream对象
        while(test.incrementToken()){
            System.out.println(charTermAttribute.toString());
        }
        //6）关闭TokenStream对象
        test.close();
    }



    @Test
    public void stroeFileIK(){
        try {
            // 1、创建一个Director对象，指定索引库保存的位置
            Directory directory = FSDirectory.open(new File("F:\\file\\directory").toPath());
            // 2、基于Directory对象创建一个IndexWriter对象
            IndexWriterConfig indexWriterConfig = new IndexWriterConfig(new IKAnalyzer());
            IndexWriter indexWriter = new IndexWriter(directory,indexWriterConfig);
            // 3、读取磁盘上的文件，对应每个文件创建一个文档对象。
            File file = new File("F:\\百度网盘\\lucene\\02.参考资料\\searchsource");
            File[] files = file.listFiles();
            for (File f : files) {
//                获取文件名
                String name = f.getName();
//                获取文件路径
                String path = f.getPath();
//                获取文件内容
                String content = FileUtils.readFileToString(f, "utf-8");
//                获取文件的大小
                long size = FileUtils.sizeOf(f);
//                创建Field对象
                Field fieldName = new TextField("name",name,Field.Store.YES);
//                Field fieldpath = new TextField("path",path,Field.Store.YES);
                Field fieldpath = new StoredField("path",path);
                Field fieldcontent = new TextField("content",content,Field.Store.YES);
                Field fieldsizevalue = new LongPoint("size",size);
                Field fieldsize = new StoredField("size",size);
                // 4、向文档对象中添加域
//                创建文档对象
                Document document = new Document();
                document.add(fieldName);
                document.add(fieldpath);
                document.add(fieldcontent);
                document.add(fieldsizevalue);
                document.add(fieldsize);
                // 5、把文档对象写入索引库
                indexWriter.addDocument(document);
            }
            // 6、关闭indexwriter对象
            indexWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
