package Sem2.Practice_Problems.WebHistory_4_1_2026;

public class BrowserHistory {
    Page head;
    public BrowserHistory() {}
    public void visit(String url) {
        Page lcN = head;
        Page newPage = new Page(url);
        if (head==null) head = newPage;
        else {while (lcN.next != null)lcN = lcN.next;lcN.next = newPage;newPage.prev = lcN;}
    }
    public void ShowHistory() {
        Page lcN = head;
        while (lcN != null) {System.out.println(lcN.getUrl());lcN = lcN.next;}
    }

    public static void main(String[] args) {
        BrowserHistory history = new BrowserHistory();
        history.visit("http://www.google.com");
        history.visit("http://www.goofball.com");
        history.visit("http://www.blahblahblah.com");
        history.ShowHistory();
    }
}
