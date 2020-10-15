import java.util.Date;
import java.util.Set;

public abstract class Document {
    private String title;
    private String author;
    private Date date;
    private PublishingLocation publishingLocation;

    public Document(String title, String author, Date date, String city, String state, String postCode){

        this.title = title;
        this.author = author;
        this.date = date;
        this.publishingLocation = new PublishingLocation(city, state, postCode);
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public Date getDate() {
        return date;
    }

    public String getCity() {
        return publishingLocation.getCity();
    }

    public String getState() {
        return publishingLocation.getState();
    }

    public String getPostCode() {
        return publishingLocation.getPostCode();
    }

    public int compareWithGeneralDate(Date date){
        return this.date.compareTo(date);
    }

    public int compareDates(Document article){
        return this.getDate().compareTo(article.getDate());
    }

    public boolean sameAuthor(Document article){
        return this.getAuthor().equals(article.getAuthor());
    }
}
