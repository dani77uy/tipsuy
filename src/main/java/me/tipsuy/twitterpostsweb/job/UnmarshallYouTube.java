package me.tipsuy.twitterpostsweb.job;

import java.net.HttpURLConnection;
import java.net.URL;

import javax.xml.bind.JAXBContext;

import me.tipsuy.twitterpostsweb.model.job.Feed;

/**
 * @author Daniel Baharian
 * @since 19 oct. 2021
 */
//@Component
public class UnmarshallYouTube {

   //   @Bean
   //   public UnmarshallingTransformer unmarshallingTransformer() {
   //      final var jaxb2Marshaller = new Jaxb2Marshaller();
   //      jaxb2Marshaller.setContextPath("http://www.w3.org/2005/Atom");
   //      jaxb2Marshaller.set
   //      return new UnmarshallingTransformer(jaxb2Marshaller);
   //   }

   //   public Object xmlToObject() throws JAXBException, IOException {
   //      final var context = JAXBContext.newInstance( Entry.class );
   //      final var unmarshaller = context.createUnmarshaller();
   //      final var urlStr = "https://www.youtube.com/feeds/videos.xml?channel_id=UC6c1z7bA__85CIWZ_jpCK-Q";
   //      final var url = new URL(urlStr);
   //      final var http = (HttpURLConnection) url.openConnection();
   //      final var is = http.getInputStream();
   //      return unmarshaller.unmarshal(is);
   //   }

   public static void main(String[] args) {
      try {
         final var context = JAXBContext.newInstance(Feed.class);
         final var urlStr = "https://www.youtube.com/feeds/videos.xml?channel_id=UC6c1z7bA__85CIWZ_jpCK-Q";
         final var url = new URL(urlStr);
         final var http = (HttpURLConnection) url.openConnection();
         final var unmarshaller = context.createUnmarshaller();
         final var is = http.getInputStream();
         final var feed = (Feed) unmarshaller.unmarshal(is);
         final var entries = feed.getEntry();
         System.out.println(entries.get(0).getLink().getHref());
      } catch (Exception ex) {
         ex.printStackTrace();
      }

   }

}
