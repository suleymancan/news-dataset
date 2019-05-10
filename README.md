# yemi-yeme-dataset
Clickbait detection extension for Turkish news on social media: [Yemi Yeme](https://github.com/suleymancan/yemi-yeme).
This repository creates the dataset of the extension. 


[Webhose.io API](https://github.com/Webhose/webhoseio-java-sdk) veri toplamak için kullanılmıştır.
webhose.io adresinde, API Playground sekmesinde, filtreler ekleyerek belirli tarih aralığında istediğimiz kaynağın verilerine ulaşabiliriz.
Eklenen filtrelerin API sorgu parametrelerine aynı sayfanın alt kısmında 'Integrate' başlığından erişilebilir.
Aşağıda API'ın program aracılığı ile kullanımının örneği verilmiştir:

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
getNews metodu sorgu mapi (queries) ve haberlerin clickbait durumunu (null) parametre olarak alır. Webhose aracılığıyla sorgu yapar.
Sorgu sonucu dönen verileri listeye koyar. WebhoseIOClient sınıfında küçük bir hata tespit ettim. Bu hata 100'den fazla haber verisinin gelmesini engelliyordu. WebhoseIOClient getNext() metodunu güncelleyerek hatayı giderdim.
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
Web kazıma işleminde elde ettiğim verileri metin belgesinden okudum ve veritabanına kaydettim. (detay: NewsTitleTextController)

#### preprocessing package:
Verisetinden özellik çıkarımı için [text2arff](http://www.kemik.yildiz.edu.tr/?id=25) ve [prizma](https://code.google.com/archive/p/prizma-text-classification/)  programlarını kullanacağım. Her iki programda veri setinde sınıf adının klasör  ve verilerin klasör içinde txt dosyasında olmasını istiyor. Bu packageda bu işleri yaptım.


### Sonuç olarak:
20.000 haber başlığı ile çalışma hedefim vardı. Bazı kaynaklardan gelen haber başlığı verilerini detaylı incelemeden 'clickbait değil' olarak sınıflandırarak hedefime ulaştım.
Verisetindeki clickbait veya clickbait değil sınıflandırmaları tamamen gözlemlerime dayanmaktadır. 

Webhose'da dogrula.org tarafından yayınlanan [clickbait raporu](https://dogrula.org/wp-content/uploads/2018/02/CLICKBAIT-RAPORU-2017-1.pdf) çalışmasındaki haber kaynaklarından veri çekmeye özen gösterdim. Webhose.io aracılığıyla 70.000'den fazla haber çektim. Tekrarlayan haber verilerini veritabanında sildim. Web kazıma işleminden 13.000'den fazla veri (resources/static/newstitle adresinden incelenebilir) çektim. Haber başlığı olmayanları veritabanından sildim.
Web kazımada kullandığım nayn.co, evrensel ve dokuz8haber clickbait olayına bulaşmayan sitelerdir. Web kazıma ile elde ettiğim haber başlıklarının hepsini veritabanında 'clickbait değil' olarak işaretledim. Verilerin geri kalanını okuyarak el ile 'clickbait' veya 'clickbait değil' olarak işaretledim.


Veriseti:<br/>
Clicbait haber başlığı: 10.030 <br/>
Clickbait olmayan haber başlığı: 10.006

Haber Kaynağı:
![alt text](https://github.com/suleymancan/yemi-yeme-dataset/tree/master/src/main/resources/static/habersayisi.png "Haber kaynağı")


#### news dataset resources:
http://webhose.io/ <br/>
https://github.com/brodriguezmilla/WebScrapingCFCBS4

