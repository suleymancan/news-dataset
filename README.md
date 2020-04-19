# yemi-yeme-dataset

### Dataset Download: <br/>
[70000+ Turkish News](https://www.kaggle.com/suleymancan/turkishnews70000)<br/>
[20000+ Turkish  News Title Clickbait Classified](https://www.kaggle.com/suleymancan/turkishnewstitle20000clickbaitclassified)

<hr>

[Webhose.io API](https://github.com/Webhose/webhoseio-java-sdk) veri toplamak için kullanılmıştır.
webhose.io adresinde, API Playground sekmesinde, filtreler ekleyerek belirli tarih aralığında istenilen kaynağın verilerine ulaşılabilir.
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
getNews metodu sorgu mapi (queries) ve haberlerin clickbait durumunu (null) parametre olarak almakta ve Webhose aracılığıyla sorgu yapmaktadır.
Sorgu sonucu dönen veriler listeye konulmaktadır. WebhoseIOClient sınıfında küçük bir hata tespit edilmiştir. Bu hata 100'den fazla haber verisinin gelmesini engellemektedir. WebhoseIOClient getNext() metodu güncellenerek hata giderilmiştir.
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
Webhose aracılığıyla haberler hakkında detaylı bilgiler çekilmiştir. (site, title, text, url, mainImage, published)
#### titleandsite package:
Clickbait tespitinde sadece haber başlığı ile çalışılmıştır.

Web kazıma hakkındaki detaylar [YemiYemeWebScraping.ipynb](https://github.com/suleymancan/yemi-yeme-dataset/blob/master/YemiYemeWebScraping.ipynb) notebook dosyasından incelenebilir.
Web kazıma işleminde elde edilen veriler metin belgesinden okunmuş ve veritabanına kaydedilmiştir. (detay: [NewsTitleTextController](https://github.com/suleymancan/yemi-yeme-dataset/blob/master/src/main/java/com/clickbait/dataset/titleandsite/NewsTitleTextController.java))

#### preprocessing package:
Verisetinden özellik çıkarımı için [text2arff](http://www.kemik.yildiz.edu.tr/?id=25) ve [prizma](https://code.google.com/archive/p/prizma-text-classification/)  programları kullanılacaktır. Her iki programda veri setinde sınıf adının klasör  ve verilerin klasör içinde txt dosyasında olmasını beklemektedir. Bu packageda bu işler yapılmıştır.


### Sonuç olarak:
Veri setindeki clickbait veya clickbait değil sınıflandırmaları araştırmacının gözlemlerine dayanmaktadır. 

Webhose'da dogrula.org tarafından yayınlanan [clickbait raporu](https://dogrula.org/wp-content/uploads/2018/02/CLICKBAIT-RAPORU-2017-1.pdf) çalışmasındaki haber kaynaklarından veri çekmeye özen gösterilmiştir. Webhose.io aracılığıyla 70.000'den fazla haber çekilmiştir. Tekrarlayan haber verileri veritabanından silinmiştir. Web kazıma işleminden 13.000'den fazla veri (resources/static/newstitle adresinden incelenebilir) çekilmiştir. Haber başlığı olmayanlar veritabanından silinmiştir.
Web kazımada kullanılan nayn.co, evrensel ve dokuz8haber araştırmacının gözünde clickbait olayına bulaşmayan sitelerdir. Web kazıma ile bu sitelerden elde edilen haber başlıkları  veritabanında 'clickbait değil' olarak işaretlenmiştir. Verilerin geri kalanı okunarak 'clickbait' veya 'clickbait değil' olarak işaretlenmiştir.


Veriseti:<br/>
Clicbait haber başlığı: 10.030 <br/>
Clickbait olmayan haber başlığı: 10.006

Haber Kaynağı: <br/>
![Haber Kaynağı](https://suleymancanblog.files.wordpress.com/2019/05/habersayisi.png)

#### news dataset resources:
http://webhose.io/ <br/>
https://github.com/brodriguezmilla/WebScrapingCFCBS4

