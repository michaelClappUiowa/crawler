package crawl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;

public class Controller {
	
	public static File file;
	public static FileWriter writer;
	public static BufferedWriter buff;
	
	public static void init(String writePath) throws IOException{
		file = new File(writePath);
		writer = new FileWriter(file,false);
		buff = new BufferedWriter(writer, 40000);
	}
	
	public static LinkedList<String> domains = new LinkedList<String>();
	
    public static void main(String[] args) throws Exception {
            String crawlStorageFolder = "F:\\CrawlerFolder";
            
            init("F:\\crawler4jUiowa.csv");
            
            int numberOfCrawlers = 200;
            

            CrawlConfig config = new CrawlConfig();
            config.setCrawlStorageFolder(crawlStorageFolder);
            config.setPolitenessDelay(0);
            config.setIncludeHttpsPages(true);
            /*
             * Instantiate the controller for this crawl.
             */
            PageFetcher pageFetcher = new PageFetcher(config);
            RobotstxtConfig robotstxtConfig = new RobotstxtConfig();
            RobotstxtServer robotstxtServer = new RobotstxtServer(robotstxtConfig, pageFetcher);
            CrawlController controller = new CrawlController(config, pageFetcher, robotstxtServer);

            /*
             * For each crawl, you need to add some seed urls. These are the first
             * URLs that are fetched and then the crawler starts following links
             * which are found in these pages
             */
            domains.add("uiowa.edu");
            controller.addSeed("http://www.uiowa.edu/");
//            controller.addSeed("http://www.ics.uci.edu/~lopes/");
//            controller.addSeed("http://www.ics.uci.edu/");

            /*
             * Start the crawl. This is a blocking operation, meaning that your code
             * will reach the line after this only when crawling is finished.
             */
            controller.start(MyCrawler.class, numberOfCrawlers);
            buff.close();
    }
}
