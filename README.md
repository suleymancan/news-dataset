# yemi-yeme-dataset
Clickbait detection extension for Turkish news on social media: [Yemi Yeme](https://github.com/suleymancan/yemi-yeme).
This repository creates the dataset of the extension. 


[Webhose.io API](https://github.com/Webhose/webhoseio-java-sdk) veri toplamak için kullanılmıştır.

NewsController:
```java
	@GetMapping("/bbccom")
	public String getBbcComNews() {
	  final List<News> bbcNews = newsService.getBbcNews();
	  newsService.saveAll(bbcNews);
		return "success!";
	}
	
```
NewsService:
```java
	List<News> getBbcNews() {

		final Map<String, String> queries = new HashMap<String, String>();
		queries.put("q", "site:bbc.com language:turkish");
		queries.put("ts", "1550062269550");
		queries.put("sort", "crawled");

		return this.getNews(queries, null);
	}
```
#### NewsService getNews metodu: 
Webhose, sorgu mapi (queries) ve haberlerin clickbait durumunu (null) alır. Webhose aracılığıyla sorgu yapar.
Sorgu sonucu donen verileri listeye koyar. WebhoseIOClient sınıfında küçük bir hata tespit ettim. Bu hata 100'den fazla haberin gelmesini engelliyordu. WebhoseIOClient getNext() metodunu güncelledim.
#### WebhoseIOClient getNext()
 ```java
 public JsonElement getNext() throws IOException, URISyntaxException {
 		try {
 			final String rawUrl = mNext.replace("\"","");
 			return  getResponse(rawUrl);
 		} catch (Exception e) {
 			e.printStackTrace();
 		}
 		return null;
 	}
```
#### news package:
Webhose aracılığıyla haberler hakkında detaylı bilgiler çektim. (site, title, text, url, mainImage, published)
#### titleandsite package:
Clickbait tespitinde sadece haber başlığı ile çalışmaya karar verdim.

Web kazıma hakkındaki detayları YemiYemeWebScraping.ipynb notebook dosyasından inceleyebilirsiniz.
Web kazıma işleminde elde ettiğim verileri metin belgesinden okudum ve veritabanına kaydettim.(detay: NewsTitleTextController)

#### preprocessing package:
Makine öğrenmesi uygulamasında özellik çıkarımı için [text2arff](http://www.kemik.yildiz.edu.tr/?id=25) ve [prizma](https://code.google.com/archive/p/prizma-text-classification/)  programlarını denedim. Her iki program da sınıfın adının klasör adı ve verilerin txt dosyasında olmasını istiyor. Bu packageda bu işleri yaptım.
Webhose'dan çektiğim  veriler arasında tekrarlı olanlar vardı. Tekrarlı verileri veritabanında sorgularla sildim.

###As a result  
Webhose'da dogrula.org tarafından yayınlanan [clickbait raporu](https://dogrula.org/wp-content/uploads/2018/02/CLICKBAIT-RAPORU-2017-1.pdf) çalışmasındaki haber kaynaklarından veri çekmeye özen gösterdim. Webhose.io aracılığıyla 70.000'den fazla haber çektim. Tekrarlayan haber verilerini temizledim. Web kazıma işleminden 13.000'den fazla veri(resources/static/newstitle) çektim. Haber başlığı olmayanları sildim.
Web kazıma başlıklarımı 'clickbait değil' olarak işaretledim. Verilerin geri kalanını okuyarak el ile 'clickbait' veya 'clickbait değil' olarak işaretledim.

dataset:<br/>
Clicbait haber başlığı: 10,030 <br/>
Not Clickbait haber başlığı 10,006

#### news dataset resources:
http://webhose.io/ <br/>
https://github.com/brodriguezmilla/WebScrapingCFCBS4

