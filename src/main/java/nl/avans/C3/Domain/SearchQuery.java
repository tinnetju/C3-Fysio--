package nl.avans.C3.Domain;

/**
 *
 * @author Tinne
 */
public class SearchQuery {
    private String SearchWords;
    private String SearchType;
    
    public String getSearchWords() {
        return SearchWords;
    }

    public void setSearchWords(String SearchWords) {
        this.SearchWords = SearchWords;
    }

    public String getSearchType() {
        return SearchType;
    }

    public void setSearchType(String SearchType) {
        this.SearchType = SearchType;
    }
}
