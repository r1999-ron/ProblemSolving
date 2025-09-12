package designPatterns.observerDesignPattern;

import java.util.ArrayList;
import java.util.List;

interface Observer{
    void update(String matchStatus);
}

interface Subject{
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}

class IplMatch implements Subject{
    private List<Observer> viewers = new ArrayList<>();
    private String matchStatus;

    @Override
    public void addObserver(Observer observer){
        viewers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer){
        viewers.remove(observer);
    }


    @Override
    public void notifyObservers(){
        for(Observer observer : viewers){
            observer.update(matchStatus);
        }
    }

    public void updateMatchScore(String status){
        this.matchStatus = status;
        notifyObservers();
    }

 }

 class TVDisplay implements Observer{
    private String viewerName;
    public TVDisplay(String viewerName){
        this.viewerName = viewerName;
    }
    @Override
     public void update(String matchStatus){
        System.out.println(viewerName + " on TV: Match Update - " + matchStatus);
    }
 }

class MobileApp implements Observer{
    private String appName;
    public MobileApp(String appName){
        this.appName = appName;
    }
    @Override
    public void update(String matchStatus){
        System.out.println(appName + " on TV: Match Update - " + matchStatus);
    }
}

class GoogleSearch implements Observer{
    @Override
    public void update(String matchStatus){
        System.out.println("Google Search: Match Update - " + matchStatus);
    }
}
public class Main {
    public static void main(String[] args) {
        IplMatch match = new IplMatch();
        Observer tvViewer = new TVDisplay("Star Sports");
        Observer mobileApp = new MobileApp("JioCinema");
        Observer google = new GoogleSearch();

        match.addObserver(tvViewer);
        match.addObserver(mobileApp);
        match.addObserver(google);

        System.out.println("First Match Update: ");
        match.updateMatchScore("CSK: 150/3 in 18 overs");

        System.out.println("\nSecond Match Update: ");
        match.updateMatchScore("CSK: 180/4 in 20 overs");

        match.removeObserver(google);

        System.out.println("\nThird Match Update (After removing Google):");
        match.updateMatchScore("CSK won by 20 runs");
    }

}
