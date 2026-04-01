package Sem2.Practice_Problems.WebHistory_4_1_2026;

public class Page {
    private String url;
    public Page next;
    public Page prev;
    public Page(String url) {
        this.url = url;
    }
    public String getUrl() {return url;}
}
