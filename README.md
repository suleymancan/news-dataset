# yemi-yeme-dataset
Clickbait detection extension for Turkish news on social media: [Yemi Yeme](https://github.com/suleymancan/yemi-yeme).
This repository creates the dataset of the extension. 


[Webhose.io API](https://github.com/Webhose/webhoseio-java-sdk) was used to collect data.

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
#### NewsService getNews method: 
Webhose query map and gets clickbait status of news. Makes query through Webhose Client.
Returns the query result as a list. I've detected a minor error in the WebhoseIOClient class. This error prevented more than 100 news stories coming. I have updated WebhoseIOClient the method.
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
Through Webhose I received a variety of information about a news item. 

#### titleandsite package:
I decided to work only on the title and site name of the detailed news data.

You can examine the details of web scraping in YemiYemeWebScraping.ipynb file.
I read the records obtained in the web scraping process and saved the database. (details: NewsTitleTextController)

#### preprocessing package:
I tried [text2arff](http://www.kemik.yildiz.edu.tr/?id=25) and [prizma](https://code.google.com/archive/p/prizma-text-classification/) for feature extraction for machine learning. Both programs want the name of the class to be in the folder name and the txt file in the folder. I've done these things in this package.

The data from Webhose may be the same. I destroyed these copies with SQL queries in the database.


###As a result  
I tried to get news from sources in the [clickbait report](https://dogrula.org/wp-content/uploads/2018/02/CLICKBAIT-RAPORU-2017-1.pdf) published by dogrula.org. Through Webhose.io I got over 70,000 news. I've cleared recurring news data. I received more than 13,000 data(resources/static/newstitle) from the web scraping process. I erased non-news data.

dataset:<br/>
Clicbait News title: 10,030 <br/>
Not Clickbait News Sitle 10,006

I've marked the headlines from my web scraping as 'not clickbait'. By reading the rest of the data, I marked it manually as 'clickbait' or 'not clickbait'.

#### news dataset resources:
http://webhose.io/ <br/>
https://github.com/brodriguezmilla/WebScrapingCFCBS4

