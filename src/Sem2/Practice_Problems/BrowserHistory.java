package Sem2.Practice_Problems;

public class BrowserHistory {
    Page head;
    public BrowserHistory() {}
    public void visit(String url) {
        Page lcN = head;
        Page newPage = new Page(url);
        if (head==null) head = newPage;
        else {
            while (lcN.next != null)
                lcN = lcN.next;
            lcN.next = newPage;
            newPage.prev = lcN;
        }
    }
    public void ShowHistory() {
        Page lcN = head;
        while (lcN != null) {
            System.out.println(lcN.getUrl());
            lcN = lcN.next;
        }
    }
    public static class Page {
        private final String url;
        public Page next;
        public Page prev;
        public Page(String url) {this.url = url;}
        public String getUrl() {return url;}
    }
    public static void main(String[] args) {
        BrowserHistory history = new BrowserHistory();
        history.visit("http://www.google.com");
        history.visit("http://www.goofball.com");
        history.visit("http://www.blahblahblah.com");
        history.ShowHistory();
    }
}
